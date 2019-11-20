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
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.forumsearch.controller.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    private long aju;
    private ArrayList<m> eYf;
    private final c fsD;
    private final d fsE;
    private final a fsF;
    private String fsG;
    private OriginalThreadInfo fsH;
    private String fsI;
    private String fsJ;
    private String fsK;
    private View.OnClickListener fsL = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.g(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.cI(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new an("c12609").p("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.cH(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable fsM = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.fsD.fsS);
        }
    };
    private CustomMessageListener fsN = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.fsD.fsS.setText(str);
                b.this.fsD.fsS.setSelection(str.length());
                b.this.biJ();
            }
        }
    };
    private CustomMessageListener fsO = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.biK();
            }
        }
    };
    private d.a fsP = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.isEmpty(cVar.biS())) {
                if (StringUtils.isNull(b.this.fsG)) {
                    b.this.biK();
                    return;
                } else {
                    b.this.biH();
                    return;
                }
            }
            b.this.eYf = cVar.biS();
            b.this.setDatas(b.this.eYf);
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fsD = new c(tbPageContext);
        biI();
        this.fsE = new d(tbPageContext, tbPageContext.getUniqueId());
        this.fsE.a(this.fsP);
        this.eYf = new ArrayList<>();
        this.fsF = new a(tbPageContext, this.fsD.duK);
        this.fsF.v(this.fsL);
        biK();
        tbPageContext.registerListener(this.fsO);
        tbPageContext.registerListener(this.fsN);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.fsM, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.aju = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.fsH = originalThreadInfo;
    }

    public void setMoreForumImg(String str) {
        this.fsJ = str;
    }

    public void setMoreForumTitle(String str) {
        this.fsK = str;
    }

    public void setMoreForumUrl(String str) {
        this.fsI = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.fsJ);
        writeActivityConfig.setMoreForumUrl(this.fsI);
        writeActivityConfig.setMoreForumTitle(this.fsK);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.aju))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.fsH);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c biG() {
        return this.fsD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biH() {
        this.eYf.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.n(com.baidu.tieba.forumsearch.b.a.fsX);
        this.eYf.add(aVar);
        setDatas(this.eYf);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.eYf = arrayList;
        this.fsD.duK.setData(arrayList);
    }

    private void biI() {
        this.fsD.mRoot.setOnClickListener(this);
        this.fsD.fsS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.biJ();
                    return true;
                }
                return false;
            }
        });
        this.fsD.fsS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.biJ();
            }
        });
        this.fsD.fsS.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.biJ();
                }
            }
        });
        this.fsD.fsS.setOnClickListener(this);
        this.fsD.eFi.setOnClickListener(this);
        this.fsD.bIb.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biJ() {
        if (this.fsD.fsS.getText() == null || StringUtils.isNull(this.fsD.fsS.getText().toString())) {
            this.fsD.eFi.setVisibility(8);
            this.fsG = null;
            biK();
            return;
        }
        m mVar = (m) v.getItem(this.eYf, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.fsW) {
            this.eYf.clear();
            setDatas(this.eYf);
        }
        this.fsD.eFi.setVisibility(0);
        this.fsG = this.fsD.fsS.getText().toString();
        this.fsE.vI(this.fsG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biK() {
        this.fsE.cancelMessage();
        this.eYf.clear();
        ArrayList<String> biM = e.biM();
        if (!v.isEmpty(biM)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.n(com.baidu.tieba.forumsearch.b.a.fsW);
            this.eYf.add(aVar);
            this.eYf.add(new com.baidu.tieba.forumsearch.b.a(biM));
            setDatas(this.eYf);
            return;
        }
        this.eYf.clear();
        setDatas(this.eYf);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fsM);
        MessageManager.getInstance().unRegisterListener(this.fsO);
        MessageManager.getInstance().unRegisterListener(this.fsN);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fsD.fsS) {
            biJ();
        } else if (view == this.fsD.bIb) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.fsD.fsS);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.fsD.eFi) {
            this.fsD.fsS.setText("");
        } else if (view == this.fsD.mRoot) {
            setDatas(this.eYf);
        }
    }
}
