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
import com.baidu.adp.widget.ListView.q;
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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.forumsearch.controller.d;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes24.dex */
public class b implements View.OnClickListener {
    private long bmB;
    private ArrayList<q> iaV;
    private final c izd;
    private final d ize;
    private final a izf;
    private String izg;
    private OriginalThreadInfo.ShareInfo izh;
    private String izi;
    private String izj;
    private String izk;
    private String izl;
    private String izm;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener izn = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.k(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.a(bVar);
                    TiebaStatic.log(new aq("c12609").w("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.eQ(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable fHe = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.izd.izt);
        }
    };
    private CustomMessageListener izo = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.izd.izt.setText(str);
                b.this.izd.izt.setSelection(str.length());
                b.this.cus();
            }
        }
    };
    private CustomMessageListener izp = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.cut();
            }
        }
    };
    private d.a izq = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || y.isEmpty(cVar.cuC())) {
                if (StringUtils.isNull(b.this.izg)) {
                    b.this.cut();
                    return;
                } else {
                    b.this.cuq();
                    return;
                }
            }
            b.this.iaV = cVar.cuC();
            b.this.setDatas(b.this.iaV);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.izd = new c(tbPageContext);
        cur();
        this.ize = new d(tbPageContext, tbPageContext.getUniqueId());
        this.ize.a(this.izq);
        this.iaV = new ArrayList<>();
        this.izf = new a(tbPageContext, this.izd.gcr);
        this.izf.y(this.izn);
        cut();
        tbPageContext.registerListener(this.izp);
        tbPageContext.registerListener(this.izo);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fHe, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.bmB = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.izh = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.izi = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.izj = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.izl = str;
    }

    public void setMoreForumTitle(String str) {
        this.izm = str;
    }

    public void setMoreForumUrl(String str) {
        this.izk = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.izl);
        writeActivityConfig.setMoreForumUrl(this.izk);
        writeActivityConfig.setMoreForumTitle(this.izm);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.bmB))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.izh);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.izi);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.izj);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || y.isEmpty(bVar.cuB())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.cuB().size());
        for (FrsTabInfo frsTabInfo : bVar.cuB()) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                arrayList.add(new FrsTabItemData(frsTabInfo));
            }
        }
        if (y.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = -1;
        return frsTabInfoData;
    }

    public c cup() {
        return this.izd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuq() {
        this.iaV.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.izy);
        this.iaV.add(aVar);
        setDatas(this.iaV);
    }

    public void setDatas(ArrayList<q> arrayList) {
        this.iaV = arrayList;
        this.izd.gcr.setData(arrayList);
    }

    private void cur() {
        this.izd.mRoot.setOnClickListener(this);
        this.izd.izt.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.cus();
                    return true;
                }
                return false;
            }
        });
        this.izd.izt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.cus();
            }
        });
        this.izd.izt.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.cus();
                }
            }
        });
        this.izd.izt.setOnClickListener(this);
        this.izd.hLb.setOnClickListener(this);
        this.izd.bKf.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cus() {
        if (this.izd.izt.getText() == null || StringUtils.isNull(this.izd.izt.getText().toString())) {
            this.izd.hLb.setVisibility(8);
            this.izg = null;
            cut();
            return;
        }
        q qVar = (q) y.getItem(this.iaV, 0);
        if (qVar != null && qVar.getType() == com.baidu.tieba.forumsearch.b.a.izx) {
            this.iaV.clear();
            setDatas(this.iaV);
        }
        this.izd.hLb.setVisibility(0);
        this.izg = this.izd.izt.getText().toString();
        this.ize.JW(this.izg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cut() {
        this.ize.cancelMessage();
        this.iaV.clear();
        ArrayList<String> cuv = e.cuv();
        if (!y.isEmpty(cuv)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.izx);
            this.iaV.add(aVar);
            this.iaV.add(new com.baidu.tieba.forumsearch.b.a(cuv));
            setDatas(this.iaV);
            return;
        }
        this.iaV.clear();
        setDatas(this.iaV);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fHe);
        MessageManager.getInstance().unRegisterListener(this.izp);
        MessageManager.getInstance().unRegisterListener(this.izo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.izd.izt) {
            cus();
        } else if (view == this.izd.bKf) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.izd.izt);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.izd.hLb) {
            this.izd.izt.setText("");
        } else if (view == this.izd.mRoot) {
            setDatas(this.iaV);
        }
    }
}
