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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.forumsearch.controller.d;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes24.dex */
public class b implements View.OnClickListener {
    private long brr;
    private final c iQG;
    private final d iQH;
    private final a iQI;
    private String iQJ;
    private OriginalThreadInfo.ShareInfo iQK;
    private String iQL;
    private String iQM;
    private String iQN;
    private String iQO;
    private String iQP;
    private ArrayList<q> isD;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener iQQ = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.n(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.a(bVar);
                    TiebaStatic.log(new ar("c12609").w("fid", bVar.getForumId()));
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
    private Runnable fUi = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.iQG.iQW);
        }
    };
    private CustomMessageListener iQR = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.iQG.iQW.setText(str);
                b.this.iQG.iQW.setSelection(str.length());
                b.this.cAL();
            }
        }
    };
    private CustomMessageListener iQS = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.cAM();
            }
        }
    };
    private d.a iQT = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || y.isEmpty(cVar.cAU())) {
                if (StringUtils.isNull(b.this.iQJ)) {
                    b.this.cAM();
                    return;
                } else {
                    b.this.cAJ();
                    return;
                }
            }
            b.this.isD = cVar.cAU();
            b.this.setDatas(b.this.isD);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.iQG = new c(tbPageContext);
        cAK();
        this.iQH = new d(tbPageContext, tbPageContext.getUniqueId());
        this.iQH.a(this.iQT);
        this.isD = new ArrayList<>();
        this.iQI = new a(tbPageContext, this.iQG.gpX);
        this.iQI.z(this.iQQ);
        cAM();
        tbPageContext.registerListener(this.iQS);
        tbPageContext.registerListener(this.iQR);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fUi, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.brr = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.iQK = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.iQL = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.iQM = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.iQO = str;
    }

    public void setMoreForumTitle(String str) {
        this.iQP = str;
    }

    public void setMoreForumUrl(String str) {
        this.iQN = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eV(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.iQO);
        writeActivityConfig.setMoreForumUrl(this.iQN);
        writeActivityConfig.setMoreForumTitle(this.iQP);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.brr))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.iQK);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.iQL);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.iQM);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || y.isEmpty(bVar.cAT())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.cAT().size());
        for (FrsTabInfo frsTabInfo : bVar.cAT()) {
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

    public c cAI() {
        return this.iQG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAJ() {
        this.isD.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.iRb);
        this.isD.add(aVar);
        setDatas(this.isD);
    }

    public void setDatas(ArrayList<q> arrayList) {
        this.isD = arrayList;
        this.iQG.gpX.setData(arrayList);
    }

    private void cAK() {
        this.iQG.mRoot.setOnClickListener(this);
        this.iQG.iQW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.cAL();
                    return true;
                }
                return false;
            }
        });
        this.iQG.iQW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.cAL();
            }
        });
        this.iQG.iQW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.cAL();
                }
            }
        });
        this.iQG.iQW.setOnClickListener(this);
        this.iQG.eZs.setOnClickListener(this);
        this.iQG.bTh.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAL() {
        if (this.iQG.iQW.getText() == null || StringUtils.isNull(this.iQG.iQW.getText().toString())) {
            this.iQG.eZs.setVisibility(8);
            this.iQJ = null;
            cAM();
            return;
        }
        q qVar = (q) y.getItem(this.isD, 0);
        if (qVar != null && qVar.getType() == com.baidu.tieba.forumsearch.b.a.iRa) {
            this.isD.clear();
            setDatas(this.isD);
        }
        this.iQG.eZs.setVisibility(0);
        this.iQJ = this.iQG.iQW.getText().toString();
        this.iQH.KE(this.iQJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAM() {
        this.iQH.cancelMessage();
        this.isD.clear();
        ArrayList<String> cAO = e.cAO();
        if (!y.isEmpty(cAO)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.iRa);
            this.isD.add(aVar);
            this.isD.add(new com.baidu.tieba.forumsearch.b.a(cAO));
            setDatas(this.isD);
            return;
        }
        this.isD.clear();
        setDatas(this.isD);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fUi);
        MessageManager.getInstance().unRegisterListener(this.iQS);
        MessageManager.getInstance().unRegisterListener(this.iQR);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iQG.iQW) {
            cAL();
        } else if (view == this.iQG.bTh) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.iQG.iQW);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.iQG.eZs) {
            this.iQG.iQW.setText("");
        } else if (view == this.iQG.mRoot) {
            setDatas(this.isD);
        }
    }
}
