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
/* loaded from: classes8.dex */
public class b implements View.OnClickListener {
    private long arv;
    private ArrayList<m> fMN;
    private final c ggZ;
    private final d gha;
    private final a ghb;
    private String ghc;
    private OriginalThreadInfo.ShareInfo ghd;
    private String ghe;
    private String ghf;
    private String ghg;
    private String ghh;
    private String ghi;
    private View.OnClickListener ghj = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.h(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.dc(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new an("c12609").s("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.db(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable ghk = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.ggZ.ghq);
        }
    };
    private CustomMessageListener ghl = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.ggZ.ghq.setText(str);
                b.this.ggZ.ghq.setSelection(str.length());
                b.this.bAe();
            }
        }
    };
    private CustomMessageListener ghm = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bAf();
            }
        }
    };
    private d.a ghn = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.isEmpty(cVar.bAn())) {
                if (StringUtils.isNull(b.this.ghc)) {
                    b.this.bAf();
                    return;
                } else {
                    b.this.bAc();
                    return;
                }
            }
            b.this.fMN = cVar.bAn();
            b.this.setDatas(b.this.fMN);
        }
    };
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ggZ = new c(tbPageContext);
        bAd();
        this.gha = new d(tbPageContext, tbPageContext.getUniqueId());
        this.gha.a(this.ghn);
        this.fMN = new ArrayList<>();
        this.ghb = new a(tbPageContext, this.ggZ.efM);
        this.ghb.x(this.ghj);
        bAf();
        tbPageContext.registerListener(this.ghm);
        tbPageContext.registerListener(this.ghl);
        com.baidu.adp.lib.f.e.gy().postDelayed(this.ghk, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.arv = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.ghd = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.ghe = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.ghf = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.ghh = str;
    }

    public void setMoreForumTitle(String str) {
        this.ghi = str;
    }

    public void setMoreForumUrl(String str) {
        this.ghg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.ghh);
        writeActivityConfig.setMoreForumUrl(this.ghg);
        writeActivityConfig.setMoreForumTitle(this.ghi);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.arv))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.ghd);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.ghe);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.ghf);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c bAb() {
        return this.ggZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAc() {
        this.fMN.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.o(com.baidu.tieba.forumsearch.b.a.ghv);
        this.fMN.add(aVar);
        setDatas(this.fMN);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.fMN = arrayList;
        this.ggZ.efM.setData(arrayList);
    }

    private void bAd() {
        this.ggZ.mRoot.setOnClickListener(this);
        this.ggZ.ghq.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bAe();
                    return true;
                }
                return false;
            }
        });
        this.ggZ.ghq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bAe();
            }
        });
        this.ggZ.ghq.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bAe();
                }
            }
        });
        this.ggZ.ghq.setOnClickListener(this);
        this.ggZ.fxg.setOnClickListener(this);
        this.ggZ.mCancel.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAe() {
        if (this.ggZ.ghq.getText() == null || StringUtils.isNull(this.ggZ.ghq.getText().toString())) {
            this.ggZ.fxg.setVisibility(8);
            this.ghc = null;
            bAf();
            return;
        }
        m mVar = (m) v.getItem(this.fMN, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.ghu) {
            this.fMN.clear();
            setDatas(this.fMN);
        }
        this.ggZ.fxg.setVisibility(0);
        this.ghc = this.ggZ.ghq.getText().toString();
        this.gha.AA(this.ghc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAf() {
        this.gha.cancelMessage();
        this.fMN.clear();
        ArrayList<String> bAh = e.bAh();
        if (!v.isEmpty(bAh)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.o(com.baidu.tieba.forumsearch.b.a.ghu);
            this.fMN.add(aVar);
            this.fMN.add(new com.baidu.tieba.forumsearch.b.a(bAh));
            setDatas(this.fMN);
            return;
        }
        this.fMN.clear();
        setDatas(this.fMN);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.ghk);
        MessageManager.getInstance().unRegisterListener(this.ghm);
        MessageManager.getInstance().unRegisterListener(this.ghl);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ggZ.ghq) {
            bAe();
        } else if (view == this.ggZ.mCancel) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.ggZ.ghq);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.ggZ.fxg) {
            this.ggZ.ghq.setText("");
        } else if (view == this.ggZ.mRoot) {
            setDatas(this.fMN);
        }
    }
}
