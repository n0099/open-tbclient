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
    private long awD;
    private ArrayList<m> fTp;
    private final c gnh;
    private final d gni;
    private final a gnj;
    private String gnk;
    private OriginalThreadInfo.ShareInfo gnl;
    private String gnm;
    private String gnn;
    private String gno;
    private String gnp;
    private String gnq;
    private View.OnClickListener gnr = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.h(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.a(bVar);
                    TiebaStatic.log(new an("c12609").s("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.dl(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable gns = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.gnh.gny);
        }
    };
    private CustomMessageListener gnt = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.gnh.gny.setText(str);
                b.this.gnh.gny.setSelection(str.length());
                b.this.bCR();
            }
        }
    };
    private CustomMessageListener gnu = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bCS();
            }
        }
    };
    private d.a gnv = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.isEmpty(cVar.bDb())) {
                if (StringUtils.isNull(b.this.gnk)) {
                    b.this.bCS();
                    return;
                } else {
                    b.this.bCP();
                    return;
                }
            }
            b.this.fTp = cVar.bDb();
            b.this.setDatas(b.this.fTp);
        }
    };
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gnh = new c(tbPageContext);
        bCQ();
        this.gni = new d(tbPageContext, tbPageContext.getUniqueId());
        this.gni.a(this.gnv);
        this.fTp = new ArrayList<>();
        this.gnj = new a(tbPageContext, this.gnh.ekE);
        this.gnj.x(this.gnr);
        bCS();
        tbPageContext.registerListener(this.gnu);
        tbPageContext.registerListener(this.gnt);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.gns, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.awD = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.gnl = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.gnm = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.gnn = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.gnp = str;
    }

    public void setMoreForumTitle(String str) {
        this.gnq = str;
    }

    public void setMoreForumUrl(String str) {
        this.gno = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.gnp);
        writeActivityConfig.setMoreForumUrl(this.gno);
        writeActivityConfig.setMoreForumTitle(this.gnq);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.awD))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.gnl);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.gnm);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.gnn);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || v.isEmpty(bVar.bDa())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.bDa().size());
        for (FrsTabInfo frsTabInfo : bVar.bDa()) {
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

    public c bCO() {
        return this.gnh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCP() {
        this.fTp.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.o(com.baidu.tieba.forumsearch.b.a.gnD);
        this.fTp.add(aVar);
        setDatas(this.fTp);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.fTp = arrayList;
        this.gnh.ekE.setData(arrayList);
    }

    private void bCQ() {
        this.gnh.mRoot.setOnClickListener(this);
        this.gnh.gny.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bCR();
                    return true;
                }
                return false;
            }
        });
        this.gnh.gny.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bCR();
            }
        });
        this.gnh.gny.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bCR();
                }
            }
        });
        this.gnh.gny.setOnClickListener(this);
        this.gnh.fDM.setOnClickListener(this);
        this.gnh.mCancel.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCR() {
        if (this.gnh.gny.getText() == null || StringUtils.isNull(this.gnh.gny.getText().toString())) {
            this.gnh.fDM.setVisibility(8);
            this.gnk = null;
            bCS();
            return;
        }
        m mVar = (m) v.getItem(this.fTp, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.gnC) {
            this.fTp.clear();
            setDatas(this.fTp);
        }
        this.gnh.fDM.setVisibility(0);
        this.gnk = this.gnh.gny.getText().toString();
        this.gni.Bc(this.gnk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCS() {
        this.gni.cancelMessage();
        this.fTp.clear();
        ArrayList<String> bCU = e.bCU();
        if (!v.isEmpty(bCU)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.o(com.baidu.tieba.forumsearch.b.a.gnC);
            this.fTp.add(aVar);
            this.fTp.add(new com.baidu.tieba.forumsearch.b.a(bCU));
            setDatas(this.fTp);
            return;
        }
        this.fTp.clear();
        setDatas(this.fTp);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gns);
        MessageManager.getInstance().unRegisterListener(this.gnu);
        MessageManager.getInstance().unRegisterListener(this.gnt);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gnh.gny) {
            bCR();
        } else if (view == this.gnh.mCancel) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.gnh.gny);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gnh.fDM) {
            this.gnh.gny.setText("");
        } else if (view == this.gnh.mRoot) {
            setDatas(this.fTp);
        }
    }
}
