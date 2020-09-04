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
    private long bey;
    private final c hQG;
    private final d hQH;
    private final a hQI;
    private String hQJ;
    private OriginalThreadInfo.ShareInfo hQK;
    private String hQL;
    private String hQM;
    private String hQN;
    private String hQO;
    private String hQP;
    private ArrayList<q> hsy;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener hQQ = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
                        b.this.eA(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable fjD = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.hQG.hQW);
        }
    };
    private CustomMessageListener hQR = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.hQG.hQW.setText(str);
                b.this.hQG.hQW.setSelection(str.length());
                b.this.ckA();
            }
        }
    };
    private CustomMessageListener hQS = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.ckB();
            }
        }
    };
    private d.a hQT = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || y.isEmpty(cVar.ckK())) {
                if (StringUtils.isNull(b.this.hQJ)) {
                    b.this.ckB();
                    return;
                } else {
                    b.this.cky();
                    return;
                }
            }
            b.this.hsy = cVar.ckK();
            b.this.setDatas(b.this.hsy);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hQG = new c(tbPageContext);
        ckz();
        this.hQH = new d(tbPageContext, tbPageContext.getUniqueId());
        this.hQH.a(this.hQT);
        this.hsy = new ArrayList<>();
        this.hQI = new a(tbPageContext, this.hQG.fCT);
        this.hQI.y(this.hQQ);
        ckB();
        tbPageContext.registerListener(this.hQS);
        tbPageContext.registerListener(this.hQR);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.fjD, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.bey = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.hQK = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.hQL = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.hQM = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.hQO = str;
    }

    public void setMoreForumTitle(String str) {
        this.hQP = str;
    }

    public void setMoreForumUrl(String str) {
        this.hQN = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.hQO);
        writeActivityConfig.setMoreForumUrl(this.hQN);
        writeActivityConfig.setMoreForumTitle(this.hQP);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.bey))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.hQK);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.hQL);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.hQM);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || y.isEmpty(bVar.ckJ())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.ckJ().size());
        for (FrsTabInfo frsTabInfo : bVar.ckJ()) {
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

    public c ckx() {
        return this.hQG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cky() {
        this.hsy.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.hRb);
        this.hsy.add(aVar);
        setDatas(this.hsy);
    }

    public void setDatas(ArrayList<q> arrayList) {
        this.hsy = arrayList;
        this.hQG.fCT.setData(arrayList);
    }

    private void ckz() {
        this.hQG.mRoot.setOnClickListener(this);
        this.hQG.hQW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.ckA();
                    return true;
                }
                return false;
            }
        });
        this.hQG.hQW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.ckA();
            }
        });
        this.hQG.hQW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.ckA();
                }
            }
        });
        this.hQG.hQW.setOnClickListener(this);
        this.hQG.hcL.setOnClickListener(this);
        this.hQG.dCF.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckA() {
        if (this.hQG.hQW.getText() == null || StringUtils.isNull(this.hQG.hQW.getText().toString())) {
            this.hQG.hcL.setVisibility(8);
            this.hQJ = null;
            ckB();
            return;
        }
        q qVar = (q) y.getItem(this.hsy, 0);
        if (qVar != null && qVar.getType() == com.baidu.tieba.forumsearch.b.a.hRa) {
            this.hsy.clear();
            setDatas(this.hsy);
        }
        this.hQG.hcL.setVisibility(0);
        this.hQJ = this.hQG.hQW.getText().toString();
        this.hQH.In(this.hQJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckB() {
        this.hQH.cancelMessage();
        this.hsy.clear();
        ArrayList<String> ckD = e.ckD();
        if (!y.isEmpty(ckD)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.hRa);
            this.hsy.add(aVar);
            this.hsy.add(new com.baidu.tieba.forumsearch.b.a(ckD));
            setDatas(this.hsy);
            return;
        }
        this.hsy.clear();
        setDatas(this.hsy);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fjD);
        MessageManager.getInstance().unRegisterListener(this.hQS);
        MessageManager.getInstance().unRegisterListener(this.hQR);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hQG.hQW) {
            ckA();
        } else if (view == this.hQG.dCF) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.hQG.hQW);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.hQG.hcL) {
            this.hQG.hQW.setText("");
        } else if (view == this.hQG.mRoot) {
            setDatas(this.hsy);
        }
    }
}
