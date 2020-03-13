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
    private long awt;
    private ArrayList<m> fSG;
    private final d gmA;
    private final a gmB;
    private String gmC;
    private OriginalThreadInfo.ShareInfo gmD;
    private String gmE;
    private String gmF;
    private String gmG;
    private String gmH;
    private String gmI;
    private View.OnClickListener gmJ = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
    private Runnable gmK = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.gmz.gmQ);
        }
    };
    private CustomMessageListener gmL = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.gmz.gmQ.setText(str);
                b.this.gmz.gmQ.setSelection(str.length());
                b.this.bCL();
            }
        }
    };
    private CustomMessageListener gmM = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bCM();
            }
        }
    };
    private d.a gmN = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.isEmpty(cVar.bCU())) {
                if (StringUtils.isNull(b.this.gmC)) {
                    b.this.bCM();
                    return;
                } else {
                    b.this.bCJ();
                    return;
                }
            }
            b.this.fSG = cVar.bCU();
            b.this.setDatas(b.this.fSG);
        }
    };
    private final c gmz;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gmz = new c(tbPageContext);
        bCK();
        this.gmA = new d(tbPageContext, tbPageContext.getUniqueId());
        this.gmA.a(this.gmN);
        this.fSG = new ArrayList<>();
        this.gmB = new a(tbPageContext, this.gmz.eko);
        this.gmB.x(this.gmJ);
        bCM();
        tbPageContext.registerListener(this.gmM);
        tbPageContext.registerListener(this.gmL);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.gmK, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.awt = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.gmD = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.gmE = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.gmF = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.gmH = str;
    }

    public void setMoreForumTitle(String str) {
        this.gmI = str;
    }

    public void setMoreForumUrl(String str) {
        this.gmG = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.gmH);
        writeActivityConfig.setMoreForumUrl(this.gmG);
        writeActivityConfig.setMoreForumTitle(this.gmI);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.awt))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.gmD);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.gmE);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.gmF);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c bCI() {
        return this.gmz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCJ() {
        this.fSG.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.o(com.baidu.tieba.forumsearch.b.a.gmV);
        this.fSG.add(aVar);
        setDatas(this.fSG);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.fSG = arrayList;
        this.gmz.eko.setData(arrayList);
    }

    private void bCK() {
        this.gmz.mRoot.setOnClickListener(this);
        this.gmz.gmQ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bCL();
                    return true;
                }
                return false;
            }
        });
        this.gmz.gmQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bCL();
            }
        });
        this.gmz.gmQ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bCL();
                }
            }
        });
        this.gmz.gmQ.setOnClickListener(this);
        this.gmz.fDe.setOnClickListener(this);
        this.gmz.mCancel.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCL() {
        if (this.gmz.gmQ.getText() == null || StringUtils.isNull(this.gmz.gmQ.getText().toString())) {
            this.gmz.fDe.setVisibility(8);
            this.gmC = null;
            bCM();
            return;
        }
        m mVar = (m) v.getItem(this.fSG, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.gmU) {
            this.fSG.clear();
            setDatas(this.fSG);
        }
        this.gmz.fDe.setVisibility(0);
        this.gmC = this.gmz.gmQ.getText().toString();
        this.gmA.Bb(this.gmC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCM() {
        this.gmA.cancelMessage();
        this.fSG.clear();
        ArrayList<String> bCO = e.bCO();
        if (!v.isEmpty(bCO)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.o(com.baidu.tieba.forumsearch.b.a.gmU);
            this.fSG.add(aVar);
            this.fSG.add(new com.baidu.tieba.forumsearch.b.a(bCO));
            setDatas(this.fSG);
            return;
        }
        this.fSG.clear();
        setDatas(this.fSG);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gmK);
        MessageManager.getInstance().unRegisterListener(this.gmM);
        MessageManager.getInstance().unRegisterListener(this.gmL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gmz.gmQ) {
            bCL();
        } else if (view == this.gmz.mCancel) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.gmz.gmQ);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gmz.fDe) {
            this.gmz.gmQ.setText("");
        } else if (view == this.gmz.mRoot) {
            setDatas(this.fSG);
        }
    }
}
