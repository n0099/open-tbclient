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
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private long awr;
    private ArrayList<m> fSr;
    private final c gmk;
    private final d gml;
    private final a gmm;
    private String gmn;
    private OriginalThreadInfo.ShareInfo gmo;
    private String gmp;
    private String gmq;
    private String gmr;
    private String gms;
    private String gmt;
    private View.OnClickListener gmu = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.h(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.dn(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new an("c12609").s("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.dm(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable gmv = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.gmk.gmB);
        }
    };
    private CustomMessageListener gmw = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.gmk.gmB.setText(str);
                b.this.gmk.gmB.setSelection(str.length());
                b.this.bCI();
            }
        }
    };
    private CustomMessageListener gmx = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bCJ();
            }
        }
    };
    private d.a gmy = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.isEmpty(cVar.bCR())) {
                if (StringUtils.isNull(b.this.gmn)) {
                    b.this.bCJ();
                    return;
                } else {
                    b.this.bCG();
                    return;
                }
            }
            b.this.fSr = cVar.bCR();
            b.this.setDatas(b.this.fSr);
        }
    };
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gmk = new c(tbPageContext);
        bCH();
        this.gml = new d(tbPageContext, tbPageContext.getUniqueId());
        this.gml.a(this.gmy);
        this.fSr = new ArrayList<>();
        this.gmm = new a(tbPageContext, this.gmk.eka);
        this.gmm.x(this.gmu);
        bCJ();
        tbPageContext.registerListener(this.gmx);
        tbPageContext.registerListener(this.gmw);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.gmv, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.awr = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.gmo = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.gmp = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.gmq = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.gms = str;
    }

    public void setMoreForumTitle(String str) {
        this.gmt = str;
    }

    public void setMoreForumUrl(String str) {
        this.gmr = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.gms);
        writeActivityConfig.setMoreForumUrl(this.gmr);
        writeActivityConfig.setMoreForumTitle(this.gmt);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.awr))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.gmo);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.gmp);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.gmq);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c bCF() {
        return this.gmk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCG() {
        this.fSr.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.o(com.baidu.tieba.forumsearch.b.a.gmG);
        this.fSr.add(aVar);
        setDatas(this.fSr);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.fSr = arrayList;
        this.gmk.eka.setData(arrayList);
    }

    private void bCH() {
        this.gmk.mRoot.setOnClickListener(this);
        this.gmk.gmB.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bCI();
                    return true;
                }
                return false;
            }
        });
        this.gmk.gmB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bCI();
            }
        });
        this.gmk.gmB.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bCI();
                }
            }
        });
        this.gmk.gmB.setOnClickListener(this);
        this.gmk.fCP.setOnClickListener(this);
        this.gmk.mCancel.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCI() {
        if (this.gmk.gmB.getText() == null || StringUtils.isNull(this.gmk.gmB.getText().toString())) {
            this.gmk.fCP.setVisibility(8);
            this.gmn = null;
            bCJ();
            return;
        }
        m mVar = (m) v.getItem(this.fSr, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.gmF) {
            this.fSr.clear();
            setDatas(this.fSr);
        }
        this.gmk.fCP.setVisibility(0);
        this.gmn = this.gmk.gmB.getText().toString();
        this.gml.Ba(this.gmn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCJ() {
        this.gml.cancelMessage();
        this.fSr.clear();
        ArrayList<String> bCL = e.bCL();
        if (!v.isEmpty(bCL)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.o(com.baidu.tieba.forumsearch.b.a.gmF);
            this.fSr.add(aVar);
            this.fSr.add(new com.baidu.tieba.forumsearch.b.a(bCL));
            setDatas(this.fSr);
            return;
        }
        this.fSr.clear();
        setDatas(this.fSr);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gmv);
        MessageManager.getInstance().unRegisterListener(this.gmx);
        MessageManager.getInstance().unRegisterListener(this.gmw);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gmk.gmB) {
            bCI();
        } else if (view == this.gmk.mCancel) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.gmk.gmB);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gmk.fCP) {
            this.gmk.gmB.setText("");
        } else if (view == this.gmk.mRoot) {
            setDatas(this.fSr);
        }
    }
}
