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
/* loaded from: classes23.dex */
public class b implements View.OnClickListener {
    private long bhr;
    private final c hXG;
    private final d hXH;
    private final a hXI;
    private String hXJ;
    private OriginalThreadInfo.ShareInfo hXK;
    private String hXL;
    private String hXM;
    private String hXN;
    private String hXO;
    private String hXP;
    private ArrayList<q> hzD;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener hXQ = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
                        b.this.eE(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable fmw = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.hXG.hXW);
        }
    };
    private CustomMessageListener hXR = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.hXG.hXW.setText(str);
                b.this.hXG.hXW.setSelection(str.length());
                b.this.cnN();
            }
        }
    };
    private CustomMessageListener hXS = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.cnO();
            }
        }
    };
    private d.a hXT = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || y.isEmpty(cVar.cnX())) {
                if (StringUtils.isNull(b.this.hXJ)) {
                    b.this.cnO();
                    return;
                } else {
                    b.this.cnL();
                    return;
                }
            }
            b.this.hzD = cVar.cnX();
            b.this.setDatas(b.this.hzD);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hXG = new c(tbPageContext);
        cnM();
        this.hXH = new d(tbPageContext, tbPageContext.getUniqueId());
        this.hXH.a(this.hXT);
        this.hzD = new ArrayList<>();
        this.hXI = new a(tbPageContext, this.hXG.fGf);
        this.hXI.y(this.hXQ);
        cnO();
        tbPageContext.registerListener(this.hXS);
        tbPageContext.registerListener(this.hXR);
        com.baidu.adp.lib.f.e.mX().postDelayed(this.fmw, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.bhr = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.hXK = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.hXL = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.hXM = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.hXO = str;
    }

    public void setMoreForumTitle(String str) {
        this.hXP = str;
    }

    public void setMoreForumUrl(String str) {
        this.hXN = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.hXO);
        writeActivityConfig.setMoreForumUrl(this.hXN);
        writeActivityConfig.setMoreForumTitle(this.hXP);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.bhr))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.hXK);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.hXL);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.hXM);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || y.isEmpty(bVar.cnW())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.cnW().size());
        for (FrsTabInfo frsTabInfo : bVar.cnW()) {
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

    public c cnK() {
        return this.hXG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnL() {
        this.hzD.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.hYb);
        this.hzD.add(aVar);
        setDatas(this.hzD);
    }

    public void setDatas(ArrayList<q> arrayList) {
        this.hzD = arrayList;
        this.hXG.fGf.setData(arrayList);
    }

    private void cnM() {
        this.hXG.mRoot.setOnClickListener(this);
        this.hXG.hXW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.cnN();
                    return true;
                }
                return false;
            }
        });
        this.hXG.hXW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.cnN();
            }
        });
        this.hXG.hXW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.cnN();
                }
            }
        });
        this.hXG.hXW.setOnClickListener(this);
        this.hXG.hjK.setOnClickListener(this);
        this.hXG.dEG.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnN() {
        if (this.hXG.hXW.getText() == null || StringUtils.isNull(this.hXG.hXW.getText().toString())) {
            this.hXG.hjK.setVisibility(8);
            this.hXJ = null;
            cnO();
            return;
        }
        q qVar = (q) y.getItem(this.hzD, 0);
        if (qVar != null && qVar.getType() == com.baidu.tieba.forumsearch.b.a.hYa) {
            this.hzD.clear();
            setDatas(this.hzD);
        }
        this.hXG.hjK.setVisibility(0);
        this.hXJ = this.hXG.hXW.getText().toString();
        this.hXH.IK(this.hXJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnO() {
        this.hXH.cancelMessage();
        this.hzD.clear();
        ArrayList<String> cnQ = e.cnQ();
        if (!y.isEmpty(cnQ)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.hYa);
            this.hzD.add(aVar);
            this.hzD.add(new com.baidu.tieba.forumsearch.b.a(cnQ));
            setDatas(this.hzD);
            return;
        }
        this.hzD.clear();
        setDatas(this.hzD);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fmw);
        MessageManager.getInstance().unRegisterListener(this.hXS);
        MessageManager.getInstance().unRegisterListener(this.hXR);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hXG.hXW) {
            cnN();
        } else if (view == this.hXG.dEG) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.hXG.hXW);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.hXG.hjK) {
            this.hXG.hXW.setText("");
        } else if (view == this.hXG.mRoot) {
            setDatas(this.hzD);
        }
    }
}
