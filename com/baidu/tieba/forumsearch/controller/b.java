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
    private long aws;
    private ArrayList<m> fSt;
    private final c gmm;
    private final d gmn;
    private final a gmo;
    private String gmp;
    private OriginalThreadInfo.ShareInfo gmq;
    private String gmr;
    private String gms;
    private String gmt;
    private String gmu;
    private String gmv;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener gmw = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
    private Runnable gmx = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.gmm.gmD);
        }
    };
    private CustomMessageListener gmy = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.gmm.gmD.setText(str);
                b.this.gmm.gmD.setSelection(str.length());
                b.this.bCK();
            }
        }
    };
    private CustomMessageListener gmz = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bCL();
            }
        }
    };
    private d.a gmA = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.isEmpty(cVar.bCT())) {
                if (StringUtils.isNull(b.this.gmp)) {
                    b.this.bCL();
                    return;
                } else {
                    b.this.bCI();
                    return;
                }
            }
            b.this.fSt = cVar.bCT();
            b.this.setDatas(b.this.fSt);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gmm = new c(tbPageContext);
        bCJ();
        this.gmn = new d(tbPageContext, tbPageContext.getUniqueId());
        this.gmn.a(this.gmA);
        this.fSt = new ArrayList<>();
        this.gmo = new a(tbPageContext, this.gmm.ekb);
        this.gmo.x(this.gmw);
        bCL();
        tbPageContext.registerListener(this.gmz);
        tbPageContext.registerListener(this.gmy);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.gmx, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.aws = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.gmq = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.gmr = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.gms = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.gmu = str;
    }

    public void setMoreForumTitle(String str) {
        this.gmv = str;
    }

    public void setMoreForumUrl(String str) {
        this.gmt = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.gmu);
        writeActivityConfig.setMoreForumUrl(this.gmt);
        writeActivityConfig.setMoreForumTitle(this.gmv);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.aws))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.gmq);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.gmr);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.gms);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c bCH() {
        return this.gmm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCI() {
        this.fSt.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.o(com.baidu.tieba.forumsearch.b.a.gmI);
        this.fSt.add(aVar);
        setDatas(this.fSt);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.fSt = arrayList;
        this.gmm.ekb.setData(arrayList);
    }

    private void bCJ() {
        this.gmm.mRoot.setOnClickListener(this);
        this.gmm.gmD.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bCK();
                    return true;
                }
                return false;
            }
        });
        this.gmm.gmD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bCK();
            }
        });
        this.gmm.gmD.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bCK();
                }
            }
        });
        this.gmm.gmD.setOnClickListener(this);
        this.gmm.fCR.setOnClickListener(this);
        this.gmm.mCancel.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCK() {
        if (this.gmm.gmD.getText() == null || StringUtils.isNull(this.gmm.gmD.getText().toString())) {
            this.gmm.fCR.setVisibility(8);
            this.gmp = null;
            bCL();
            return;
        }
        m mVar = (m) v.getItem(this.fSt, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.gmH) {
            this.fSt.clear();
            setDatas(this.fSt);
        }
        this.gmm.fCR.setVisibility(0);
        this.gmp = this.gmm.gmD.getText().toString();
        this.gmn.Ba(this.gmp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCL() {
        this.gmn.cancelMessage();
        this.fSt.clear();
        ArrayList<String> bCN = e.bCN();
        if (!v.isEmpty(bCN)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.o(com.baidu.tieba.forumsearch.b.a.gmH);
            this.fSt.add(aVar);
            this.fSt.add(new com.baidu.tieba.forumsearch.b.a(bCN));
            setDatas(this.fSt);
            return;
        }
        this.fSt.clear();
        setDatas(this.fSt);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gmx);
        MessageManager.getInstance().unRegisterListener(this.gmz);
        MessageManager.getInstance().unRegisterListener(this.gmy);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gmm.gmD) {
            bCK();
        } else if (view == this.gmm.mCancel) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.gmm.gmD);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gmm.fCR) {
            this.gmm.gmD.setText("");
        } else if (view == this.gmm.mRoot) {
            setDatas(this.fSt);
        }
    }
}
