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
/* loaded from: classes7.dex */
public class b implements View.OnClickListener {
    private long brk;
    private ArrayList<n> iAl;
    private final c iYn;
    private final d iYo;
    private final a iYp;
    private String iYq;
    private OriginalThreadInfo.ShareInfo iYr;
    private String iYs;
    private String iYt;
    private String iYu;
    private String iYv;
    private String iYw;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener iYx = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
                        b.this.eV(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable fZd = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.iYn.iYD);
        }
    };
    private CustomMessageListener iYy = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.iYn.iYD.setText(str);
                b.this.iYn.iYD.setSelection(str.length());
                b.this.czO();
            }
        }
    };
    private CustomMessageListener iYz = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.czP();
            }
        }
    };
    private d.a iYA = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || x.isEmpty(cVar.czX())) {
                if (StringUtils.isNull(b.this.iYq)) {
                    b.this.czP();
                    return;
                } else {
                    b.this.czM();
                    return;
                }
            }
            b.this.iAl = cVar.czX();
            b.this.setDatas(b.this.iAl);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.iYn = new c(tbPageContext);
        czN();
        this.iYo = new d(tbPageContext, tbPageContext.getUniqueId());
        this.iYo.a(this.iYA);
        this.iAl = new ArrayList<>();
        this.iYp = new a(tbPageContext, this.iYn.gwr);
        this.iYp.A(this.iYx);
        czP();
        tbPageContext.registerListener(this.iYz);
        tbPageContext.registerListener(this.iYy);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.fZd, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.brk = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.iYr = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.iYs = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.iYt = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.iYv = str;
    }

    public void setMoreForumTitle(String str) {
        this.iYw = str;
    }

    public void setMoreForumUrl(String str) {
        this.iYu = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eV(String str, String str2) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.brk))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.iYr);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.iYs);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.iYt);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || x.isEmpty(bVar.czW())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.czW().size());
        for (FrsTabInfo frsTabInfo : bVar.czW()) {
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

    public c czL() {
        return this.iYn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czM() {
        this.iAl.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.iYI);
        this.iAl.add(aVar);
        setDatas(this.iAl);
    }

    public void setDatas(ArrayList<n> arrayList) {
        this.iAl = arrayList;
        this.iYn.gwr.setData(arrayList);
    }

    private void czN() {
        this.iYn.mRoot.setOnClickListener(this);
        this.iYn.iYD.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.czO();
                    return true;
                }
                return false;
            }
        });
        this.iYn.iYD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.czO();
            }
        });
        this.iYn.iYD.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.czO();
                }
            }
        });
        this.iYn.iYD.setOnClickListener(this);
        this.iYn.fel.setOnClickListener(this);
        this.iYn.bUf.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czO() {
        if (this.iYn.iYD.getText() == null || StringUtils.isNull(this.iYn.iYD.getText().toString())) {
            this.iYn.fel.setVisibility(8);
            this.iYq = null;
            czP();
            return;
        }
        n nVar = (n) x.getItem(this.iAl, 0);
        if (nVar != null && nVar.getType() == com.baidu.tieba.forumsearch.b.a.iYH) {
            this.iAl.clear();
            setDatas(this.iAl);
        }
        this.iYn.fel.setVisibility(0);
        this.iYq = this.iYn.iYD.getText().toString();
        this.iYo.Jq(this.iYq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czP() {
        this.iYo.cancelMessage();
        this.iAl.clear();
        ArrayList<String> czR = e.czR();
        if (!x.isEmpty(czR)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.iYH);
            this.iAl.add(aVar);
            this.iAl.add(new com.baidu.tieba.forumsearch.b.a(czR));
            setDatas(this.iAl);
            return;
        }
        this.iAl.clear();
        setDatas(this.iAl);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fZd);
        MessageManager.getInstance().unRegisterListener(this.iYz);
        MessageManager.getInstance().unRegisterListener(this.iYy);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iYn.iYD) {
            czO();
        } else if (view == this.iYn.bUf) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.iYn.iYD);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.iYn.fel) {
            this.iYn.iYD.setText("");
        } else if (view == this.iYn.mRoot) {
            setDatas(this.iAl);
        }
    }
}
