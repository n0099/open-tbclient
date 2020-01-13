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
/* loaded from: classes9.dex */
public class b implements View.OnClickListener {
    private long ash;
    private ArrayList<m> fPW;
    private final c gkj;
    private final d gkk;
    private final a gkl;
    private String gkm;
    private OriginalThreadInfo.ShareInfo gkn;
    private String gko;
    private String gkp;
    private String gkq;
    private String gkr;
    private String gks;
    private View.OnClickListener gkt = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.h(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.de(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new an("c12609").s("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.dd(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable gku = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.gkj.gkA);
        }
    };
    private CustomMessageListener gkv = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.gkj.gkA.setText(str);
                b.this.gkj.gkA.setSelection(str.length());
                b.this.bBg();
            }
        }
    };
    private CustomMessageListener gkw = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bBh();
            }
        }
    };
    private d.a gkx = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.isEmpty(cVar.bBp())) {
                if (StringUtils.isNull(b.this.gkm)) {
                    b.this.bBh();
                    return;
                } else {
                    b.this.bBe();
                    return;
                }
            }
            b.this.fPW = cVar.bBp();
            b.this.setDatas(b.this.fPW);
        }
    };
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gkj = new c(tbPageContext);
        bBf();
        this.gkk = new d(tbPageContext, tbPageContext.getUniqueId());
        this.gkk.a(this.gkx);
        this.fPW = new ArrayList<>();
        this.gkl = new a(tbPageContext, this.gkj.efW);
        this.gkl.w(this.gkt);
        bBh();
        tbPageContext.registerListener(this.gkw);
        tbPageContext.registerListener(this.gkv);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.gku, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.ash = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.gkn = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.gko = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.gkp = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.gkr = str;
    }

    public void setMoreForumTitle(String str) {
        this.gks = str;
    }

    public void setMoreForumUrl(String str) {
        this.gkq = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.gkr);
        writeActivityConfig.setMoreForumUrl(this.gkq);
        writeActivityConfig.setMoreForumTitle(this.gks);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.ash))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.gkn);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.gko);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.gkp);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c bBd() {
        return this.gkj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBe() {
        this.fPW.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.o(com.baidu.tieba.forumsearch.b.a.gkF);
        this.fPW.add(aVar);
        setDatas(this.fPW);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.fPW = arrayList;
        this.gkj.efW.setData(arrayList);
    }

    private void bBf() {
        this.gkj.mRoot.setOnClickListener(this);
        this.gkj.gkA.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bBg();
                    return true;
                }
                return false;
            }
        });
        this.gkj.gkA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bBg();
            }
        });
        this.gkj.gkA.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bBg();
                }
            }
        });
        this.gkj.gkA.setOnClickListener(this);
        this.gkj.fAr.setOnClickListener(this);
        this.gkj.mCancel.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBg() {
        if (this.gkj.gkA.getText() == null || StringUtils.isNull(this.gkj.gkA.getText().toString())) {
            this.gkj.fAr.setVisibility(8);
            this.gkm = null;
            bBh();
            return;
        }
        m mVar = (m) v.getItem(this.fPW, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.gkE) {
            this.fPW.clear();
            setDatas(this.fPW);
        }
        this.gkj.fAr.setVisibility(0);
        this.gkm = this.gkj.gkA.getText().toString();
        this.gkk.AK(this.gkm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBh() {
        this.gkk.cancelMessage();
        this.fPW.clear();
        ArrayList<String> bBj = e.bBj();
        if (!v.isEmpty(bBj)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.o(com.baidu.tieba.forumsearch.b.a.gkE);
            this.fPW.add(aVar);
            this.fPW.add(new com.baidu.tieba.forumsearch.b.a(bBj));
            setDatas(this.fPW);
            return;
        }
        this.fPW.clear();
        setDatas(this.fPW);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gku);
        MessageManager.getInstance().unRegisterListener(this.gkw);
        MessageManager.getInstance().unRegisterListener(this.gkv);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gkj.gkA) {
            bBg();
        } else if (view == this.gkj.mCancel) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.gkj.gkA);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gkj.fAr) {
            this.gkj.gkA.setText("");
        } else if (view == this.gkj.mRoot) {
            setDatas(this.fPW);
        }
    }
}
