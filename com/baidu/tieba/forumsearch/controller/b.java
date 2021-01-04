package com.baidu.tieba.forumsearch.controller;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.forumsearch.controller.d;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes8.dex */
public class b implements View.OnClickListener {
    private long bvY;
    private ArrayList<n> iES;
    private final c jcU;
    private final d jcV;
    private final a jcW;
    private String jcX;
    private OriginalThreadInfo.ShareInfo jcY;
    private String jcZ;
    private String jda;
    private String jdb;
    private String jdc;
    private String jdd;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener jde = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.m(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.a(bVar);
                    TiebaStatic.log(new aq("c12609").w("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.eW(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable gdM = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.jcU.jdk);
        }
    };
    private CustomMessageListener jdf = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.jcU.jdk.setText(str);
                b.this.jcU.jdk.setSelection(str.length());
                b.this.cDF();
            }
        }
    };
    private CustomMessageListener jdg = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.cDG();
            }
        }
    };
    private d.a jdh = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || x.isEmpty(cVar.cDO())) {
                if (StringUtils.isNull(b.this.jcX)) {
                    b.this.cDG();
                    return;
                } else {
                    b.this.cDD();
                    return;
                }
            }
            b.this.iES = cVar.cDO();
            b.this.setDatas(b.this.iES);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.jcU = new c(tbPageContext);
        cDE();
        this.jcV = new d(tbPageContext, tbPageContext.getUniqueId());
        this.jcV.a(this.jdh);
        this.iES = new ArrayList<>();
        this.jcW = new a(tbPageContext, this.jcU.gAY);
        this.jcW.A(this.jde);
        cDG();
        tbPageContext.registerListener(this.jdg);
        tbPageContext.registerListener(this.jdf);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.gdM, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.bvY = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.jcY = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.jcZ = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.jda = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.jdc = str;
    }

    public void setMoreForumTitle(String str) {
        this.jdd = str;
    }

    public void setMoreForumUrl(String str) {
        this.jdb = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eW(String str, String str2) {
        if (!WriteActivityConfig.isAsyncWriting()) {
            WriteActivityConfig.newInstance(this.mPageContext.getPageActivity()).setType(9).setForumId(str).setForumName(str2).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).send();
            this.mPageContext.getPageActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.bvY))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.jcY);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.jcZ);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.jda);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || x.isEmpty(bVar.cDN())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.cDN().size());
        for (FrsTabInfo frsTabInfo : bVar.cDN()) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                arrayList.add(new FrsTabItemData(frsTabInfo));
            }
        }
        if (x.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = -1;
        return frsTabInfoData;
    }

    public c cDC() {
        return this.jcU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDD() {
        this.iES.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.jdp);
        this.iES.add(aVar);
        setDatas(this.iES);
    }

    public void setDatas(ArrayList<n> arrayList) {
        this.iES = arrayList;
        this.jcU.gAY.setData(arrayList);
    }

    private void cDE() {
        this.jcU.mRoot.setOnClickListener(this);
        this.jcU.jdk.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.cDF();
                    return true;
                }
                return false;
            }
        });
        this.jcU.jdk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.cDF();
            }
        });
        this.jcU.jdk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.cDF();
                }
            }
        });
        this.jcU.jdk.setOnClickListener(this);
        this.jcU.fiW.setOnClickListener(this);
        this.jcU.bYR.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDF() {
        if (this.jcU.jdk.getText() == null || StringUtils.isNull(this.jcU.jdk.getText().toString())) {
            this.jcU.fiW.setVisibility(8);
            this.jcX = null;
            cDG();
            return;
        }
        n nVar = (n) x.getItem(this.iES, 0);
        if (nVar != null && nVar.getType() == com.baidu.tieba.forumsearch.b.a.jdo) {
            this.iES.clear();
            setDatas(this.iES);
        }
        this.jcU.fiW.setVisibility(0);
        this.jcX = this.jcU.jdk.getText().toString();
        this.jcV.KC(this.jcX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDG() {
        this.jcV.cancelMessage();
        this.iES.clear();
        ArrayList<String> cDI = e.cDI();
        if (!x.isEmpty(cDI)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.jdo);
            this.iES.add(aVar);
            this.iES.add(new com.baidu.tieba.forumsearch.b.a(cDI));
            setDatas(this.iES);
            return;
        }
        this.iES.clear();
        setDatas(this.iES);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gdM);
        MessageManager.getInstance().unRegisterListener(this.jdg);
        MessageManager.getInstance().unRegisterListener(this.jdf);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jcU.jdk) {
            cDF();
        } else if (view == this.jcU.bYR) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jcU.jdk);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jcU.fiW) {
            this.jcU.jdk.setText("");
        } else if (view == this.jcU.mRoot) {
            setDatas(this.iES);
        }
    }
}
