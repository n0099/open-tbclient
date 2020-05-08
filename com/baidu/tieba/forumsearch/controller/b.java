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
    private long aQm;
    private String gWA;
    private String gWB;
    private String gWC;
    private View.OnClickListener gWD = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
    private Runnable gWE = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.gWt.gWK);
        }
    };
    private CustomMessageListener gWF = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.gWt.gWK.setText(str);
                b.this.gWt.gWK.setSelection(str.length());
                b.this.bNp();
            }
        }
    };
    private CustomMessageListener gWG = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bNq();
            }
        }
    };
    private d.a gWH = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.isEmpty(cVar.bNz())) {
                if (StringUtils.isNull(b.this.gWw)) {
                    b.this.bNq();
                    return;
                } else {
                    b.this.bNn();
                    return;
                }
            }
            b.this.gyd = cVar.bNz();
            b.this.setDatas(b.this.gyd);
        }
    };
    private final c gWt;
    private final d gWu;
    private final a gWv;
    private String gWw;
    private OriginalThreadInfo.ShareInfo gWx;
    private String gWy;
    private String gWz;
    private ArrayList<m> gyd;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gWt = new c(tbPageContext);
        bNo();
        this.gWu = new d(tbPageContext, tbPageContext.getUniqueId());
        this.gWu.a(this.gWH);
        this.gyd = new ArrayList<>();
        this.gWv = new a(tbPageContext, this.gWt.eOj);
        this.gWv.y(this.gWD);
        bNq();
        tbPageContext.registerListener(this.gWG);
        tbPageContext.registerListener(this.gWF);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.gWE, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.aQm = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.gWx = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.gWy = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.gWz = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.gWB = str;
    }

    public void setMoreForumTitle(String str) {
        this.gWC = str;
    }

    public void setMoreForumUrl(String str) {
        this.gWA = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.gWB);
        writeActivityConfig.setMoreForumUrl(this.gWA);
        writeActivityConfig.setMoreForumTitle(this.gWC);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.aQm))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.gWx);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.gWy);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.gWz);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || v.isEmpty(bVar.bNy())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.bNy().size());
        for (FrsTabInfo frsTabInfo : bVar.bNy()) {
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

    public c bNm() {
        return this.gWt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNn() {
        this.gyd.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.o(com.baidu.tieba.forumsearch.b.a.gWP);
        this.gyd.add(aVar);
        setDatas(this.gyd);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.gyd = arrayList;
        this.gWt.eOj.setData(arrayList);
    }

    private void bNo() {
        this.gWt.mRoot.setOnClickListener(this);
        this.gWt.gWK.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bNp();
                    return true;
                }
                return false;
            }
        });
        this.gWt.gWK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bNp();
            }
        });
        this.gWt.gWK.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bNp();
                }
            }
        });
        this.gWt.gWK.setOnClickListener(this);
        this.gWt.giw.setOnClickListener(this);
        this.gWt.cWS.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNp() {
        if (this.gWt.gWK.getText() == null || StringUtils.isNull(this.gWt.gWK.getText().toString())) {
            this.gWt.giw.setVisibility(8);
            this.gWw = null;
            bNq();
            return;
        }
        m mVar = (m) v.getItem(this.gyd, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.gWO) {
            this.gyd.clear();
            setDatas(this.gyd);
        }
        this.gWt.giw.setVisibility(0);
        this.gWw = this.gWt.gWK.getText().toString();
        this.gWu.CQ(this.gWw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNq() {
        this.gWu.cancelMessage();
        this.gyd.clear();
        ArrayList<String> bNs = e.bNs();
        if (!v.isEmpty(bNs)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.o(com.baidu.tieba.forumsearch.b.a.gWO);
            this.gyd.add(aVar);
            this.gyd.add(new com.baidu.tieba.forumsearch.b.a(bNs));
            setDatas(this.gyd);
            return;
        }
        this.gyd.clear();
        setDatas(this.gyd);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gWE);
        MessageManager.getInstance().unRegisterListener(this.gWG);
        MessageManager.getInstance().unRegisterListener(this.gWF);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gWt.gWK) {
            bNp();
        } else if (view == this.gWt.cWS) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.gWt.gWK);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gWt.giw) {
            this.gWt.gWK.setText("");
        } else if (view == this.gWt.mRoot) {
            setDatas(this.gyd);
        }
    }
}
