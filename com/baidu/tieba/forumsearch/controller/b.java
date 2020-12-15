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
    private final c iQI;
    private final d iQJ;
    private final a iQK;
    private String iQL;
    private OriginalThreadInfo.ShareInfo iQM;
    private String iQN;
    private String iQO;
    private String iQP;
    private String iQQ;
    private String iQR;
    private ArrayList<q> isF;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener iQS = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.iQI.iQY);
        }
    };
    private CustomMessageListener iQT = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.iQI.iQY.setText(str);
                b.this.iQI.iQY.setSelection(str.length());
                b.this.cAM();
            }
        }
    };
    private CustomMessageListener iQU = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.cAN();
            }
        }
    };
    private d.a iQV = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || y.isEmpty(cVar.cAV())) {
                if (StringUtils.isNull(b.this.iQL)) {
                    b.this.cAN();
                    return;
                } else {
                    b.this.cAK();
                    return;
                }
            }
            b.this.isF = cVar.cAV();
            b.this.setDatas(b.this.isF);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.iQI = new c(tbPageContext);
        cAL();
        this.iQJ = new d(tbPageContext, tbPageContext.getUniqueId());
        this.iQJ.a(this.iQV);
        this.isF = new ArrayList<>();
        this.iQK = new a(tbPageContext, this.iQI.gpZ);
        this.iQK.z(this.iQS);
        cAN();
        tbPageContext.registerListener(this.iQU);
        tbPageContext.registerListener(this.iQT);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fUi, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.brr = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.iQM = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.iQN = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.iQO = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.iQQ = str;
    }

    public void setMoreForumTitle(String str) {
        this.iQR = str;
    }

    public void setMoreForumUrl(String str) {
        this.iQP = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eV(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.iQQ);
        writeActivityConfig.setMoreForumUrl(this.iQP);
        writeActivityConfig.setMoreForumTitle(this.iQR);
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
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.iQM);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.iQN);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.iQO);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || y.isEmpty(bVar.cAU())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.cAU().size());
        for (FrsTabInfo frsTabInfo : bVar.cAU()) {
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

    public c cAJ() {
        return this.iQI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAK() {
        this.isF.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.iRd);
        this.isF.add(aVar);
        setDatas(this.isF);
    }

    public void setDatas(ArrayList<q> arrayList) {
        this.isF = arrayList;
        this.iQI.gpZ.setData(arrayList);
    }

    private void cAL() {
        this.iQI.mRoot.setOnClickListener(this);
        this.iQI.iQY.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.cAM();
                    return true;
                }
                return false;
            }
        });
        this.iQI.iQY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.cAM();
            }
        });
        this.iQI.iQY.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.cAM();
                }
            }
        });
        this.iQI.iQY.setOnClickListener(this);
        this.iQI.eZs.setOnClickListener(this);
        this.iQI.bTh.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAM() {
        if (this.iQI.iQY.getText() == null || StringUtils.isNull(this.iQI.iQY.getText().toString())) {
            this.iQI.eZs.setVisibility(8);
            this.iQL = null;
            cAN();
            return;
        }
        q qVar = (q) y.getItem(this.isF, 0);
        if (qVar != null && qVar.getType() == com.baidu.tieba.forumsearch.b.a.iRc) {
            this.isF.clear();
            setDatas(this.isF);
        }
        this.iQI.eZs.setVisibility(0);
        this.iQL = this.iQI.iQY.getText().toString();
        this.iQJ.KE(this.iQL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAN() {
        this.iQJ.cancelMessage();
        this.isF.clear();
        ArrayList<String> cAP = e.cAP();
        if (!y.isEmpty(cAP)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.iRc);
            this.isF.add(aVar);
            this.isF.add(new com.baidu.tieba.forumsearch.b.a(cAP));
            setDatas(this.isF);
            return;
        }
        this.isF.clear();
        setDatas(this.isF);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fUi);
        MessageManager.getInstance().unRegisterListener(this.iQU);
        MessageManager.getInstance().unRegisterListener(this.iQT);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iQI.iQY) {
            cAM();
        } else if (view == this.iQI.bTh) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.iQI.iQY);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.iQI.eZs) {
            this.iQI.iQY.setText("");
        } else if (view == this.iQI.mRoot) {
            setDatas(this.isF);
        }
    }
}
