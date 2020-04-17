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
import com.baidu.adp.widget.ListView.m;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.forumsearch.controller.d;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private long aQg;
    private final c gWn;
    private final d gWo;
    private final a gWp;
    private String gWq;
    private OriginalThreadInfo.ShareInfo gWr;
    private String gWs;
    private String gWt;
    private String gWu;
    private String gWv;
    private String gWw;
    private ArrayList<m> gxX;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener gWx = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
                    TiebaStatic.log(new an("c12609").t("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.dA(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable gWy = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.gWn.gWE);
        }
    };
    private CustomMessageListener gWz = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.gWn.gWE.setText(str);
                b.this.gWn.gWE.setSelection(str.length());
                b.this.bNr();
            }
        }
    };
    private CustomMessageListener gWA = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bNs();
            }
        }
    };
    private d.a gWB = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.isEmpty(cVar.bNB())) {
                if (StringUtils.isNull(b.this.gWq)) {
                    b.this.bNs();
                    return;
                } else {
                    b.this.bNp();
                    return;
                }
            }
            b.this.gxX = cVar.bNB();
            b.this.setDatas(b.this.gxX);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gWn = new c(tbPageContext);
        bNq();
        this.gWo = new d(tbPageContext, tbPageContext.getUniqueId());
        this.gWo.a(this.gWB);
        this.gxX = new ArrayList<>();
        this.gWp = new a(tbPageContext, this.gWn.eOe);
        this.gWp.y(this.gWx);
        bNs();
        tbPageContext.registerListener(this.gWA);
        tbPageContext.registerListener(this.gWz);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.gWy, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.aQg = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.gWr = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.gWs = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.gWt = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.gWv = str;
    }

    public void setMoreForumTitle(String str) {
        this.gWw = str;
    }

    public void setMoreForumUrl(String str) {
        this.gWu = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.gWv);
        writeActivityConfig.setMoreForumUrl(this.gWu);
        writeActivityConfig.setMoreForumTitle(this.gWw);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.aQg))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.gWr);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.gWs);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.gWt);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || v.isEmpty(bVar.bNA())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.bNA().size());
        for (FrsTabInfo frsTabInfo : bVar.bNA()) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                arrayList.add(new FrsTabItemData(frsTabInfo));
            }
        }
        if (v.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = -1;
        return frsTabInfoData;
    }

    public c bNo() {
        return this.gWn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNp() {
        this.gxX.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.o(com.baidu.tieba.forumsearch.b.a.gWJ);
        this.gxX.add(aVar);
        setDatas(this.gxX);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.gxX = arrayList;
        this.gWn.eOe.setData(arrayList);
    }

    private void bNq() {
        this.gWn.mRoot.setOnClickListener(this);
        this.gWn.gWE.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bNr();
                    return true;
                }
                return false;
            }
        });
        this.gWn.gWE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bNr();
            }
        });
        this.gWn.gWE.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bNr();
                }
            }
        });
        this.gWn.gWE.setOnClickListener(this);
        this.gWn.giq.setOnClickListener(this);
        this.gWn.cWN.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNr() {
        if (this.gWn.gWE.getText() == null || StringUtils.isNull(this.gWn.gWE.getText().toString())) {
            this.gWn.giq.setVisibility(8);
            this.gWq = null;
            bNs();
            return;
        }
        m mVar = (m) v.getItem(this.gxX, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.gWI) {
            this.gxX.clear();
            setDatas(this.gxX);
        }
        this.gWn.giq.setVisibility(0);
        this.gWq = this.gWn.gWE.getText().toString();
        this.gWo.CN(this.gWq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNs() {
        this.gWo.cancelMessage();
        this.gxX.clear();
        ArrayList<String> bNu = e.bNu();
        if (!v.isEmpty(bNu)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.o(com.baidu.tieba.forumsearch.b.a.gWI);
            this.gxX.add(aVar);
            this.gxX.add(new com.baidu.tieba.forumsearch.b.a(bNu));
            setDatas(this.gxX);
            return;
        }
        this.gxX.clear();
        setDatas(this.gxX);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gWy);
        MessageManager.getInstance().unRegisterListener(this.gWA);
        MessageManager.getInstance().unRegisterListener(this.gWz);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gWn.gWE) {
            bNr();
        } else if (view == this.gWn.cWN) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.gWn.gWE);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gWn.giq) {
            this.gWn.gWE.setText("");
        } else if (view == this.gWn.mRoot) {
            setDatas(this.gxX);
        }
    }
}
