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
/* loaded from: classes18.dex */
public class b implements View.OnClickListener {
    private long bew;
    private final c hQA;
    private final d hQB;
    private final a hQC;
    private String hQD;
    private OriginalThreadInfo.ShareInfo hQE;
    private String hQF;
    private String hQG;
    private String hQH;
    private String hQI;
    private String hQJ;
    private ArrayList<q> hss;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener hQK = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.j(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.a(bVar);
                    TiebaStatic.log(new aq("c12609").u("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.ez(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable fjz = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.hQA.hQQ);
        }
    };
    private CustomMessageListener hQL = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.hQA.hQQ.setText(str);
                b.this.hQA.hQQ.setSelection(str.length());
                b.this.ckz();
            }
        }
    };
    private CustomMessageListener hQM = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.ckA();
            }
        }
    };
    private d.a hQN = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || y.isEmpty(cVar.ckJ())) {
                if (StringUtils.isNull(b.this.hQD)) {
                    b.this.ckA();
                    return;
                } else {
                    b.this.ckx();
                    return;
                }
            }
            b.this.hss = cVar.ckJ();
            b.this.setDatas(b.this.hss);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hQA = new c(tbPageContext);
        cky();
        this.hQB = new d(tbPageContext, tbPageContext.getUniqueId());
        this.hQB.a(this.hQN);
        this.hss = new ArrayList<>();
        this.hQC = new a(tbPageContext, this.hQA.fCP);
        this.hQC.y(this.hQK);
        ckA();
        tbPageContext.registerListener(this.hQM);
        tbPageContext.registerListener(this.hQL);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.fjz, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.bew = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.hQE = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.hQF = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.hQG = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.hQI = str;
    }

    public void setMoreForumTitle(String str) {
        this.hQJ = str;
    }

    public void setMoreForumUrl(String str) {
        this.hQH = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.hQI);
        writeActivityConfig.setMoreForumUrl(this.hQH);
        writeActivityConfig.setMoreForumTitle(this.hQJ);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.bew))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.hQE);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.hQF);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.hQG);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || y.isEmpty(bVar.ckI())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.ckI().size());
        for (FrsTabInfo frsTabInfo : bVar.ckI()) {
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

    public c ckw() {
        return this.hQA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckx() {
        this.hss.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.hQV);
        this.hss.add(aVar);
        setDatas(this.hss);
    }

    public void setDatas(ArrayList<q> arrayList) {
        this.hss = arrayList;
        this.hQA.fCP.setData(arrayList);
    }

    private void cky() {
        this.hQA.mRoot.setOnClickListener(this);
        this.hQA.hQQ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.ckz();
                    return true;
                }
                return false;
            }
        });
        this.hQA.hQQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.ckz();
            }
        });
        this.hQA.hQQ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.ckz();
                }
            }
        });
        this.hQA.hQQ.setOnClickListener(this);
        this.hQA.hcH.setOnClickListener(this);
        this.hQA.dCB.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckz() {
        if (this.hQA.hQQ.getText() == null || StringUtils.isNull(this.hQA.hQQ.getText().toString())) {
            this.hQA.hcH.setVisibility(8);
            this.hQD = null;
            ckA();
            return;
        }
        q qVar = (q) y.getItem(this.hss, 0);
        if (qVar != null && qVar.getType() == com.baidu.tieba.forumsearch.b.a.hQU) {
            this.hss.clear();
            setDatas(this.hss);
        }
        this.hQA.hcH.setVisibility(0);
        this.hQD = this.hQA.hQQ.getText().toString();
        this.hQB.Im(this.hQD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckA() {
        this.hQB.cancelMessage();
        this.hss.clear();
        ArrayList<String> ckC = e.ckC();
        if (!y.isEmpty(ckC)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.hQU);
            this.hss.add(aVar);
            this.hss.add(new com.baidu.tieba.forumsearch.b.a(ckC));
            setDatas(this.hss);
            return;
        }
        this.hss.clear();
        setDatas(this.hss);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fjz);
        MessageManager.getInstance().unRegisterListener(this.hQM);
        MessageManager.getInstance().unRegisterListener(this.hQL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hQA.hQQ) {
            ckz();
        } else if (view == this.hQA.dCB) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.hQA.hQQ);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.hQA.hcH) {
            this.hQA.hQQ.setText("");
        } else if (view == this.hQA.mRoot) {
            setDatas(this.hss);
        }
    }
}
