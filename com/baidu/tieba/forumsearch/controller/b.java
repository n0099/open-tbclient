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
    private long ajM;
    private ArrayList<m> eYW;
    private String ftA;
    private String ftB;
    private View.OnClickListener ftC = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
    private Runnable ftD = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.ftu.ftJ);
        }
    };
    private CustomMessageListener ftE = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.ftu.ftJ.setText(str);
                b.this.ftu.ftJ.setSelection(str.length());
                b.this.biL();
            }
        }
    };
    private CustomMessageListener ftF = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.biM();
            }
        }
    };
    private d.a ftG = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.isEmpty(cVar.biU())) {
                if (StringUtils.isNull(b.this.ftx)) {
                    b.this.biM();
                    return;
                } else {
                    b.this.biJ();
                    return;
                }
            }
            b.this.eYW = cVar.biU();
            b.this.setDatas(b.this.eYW);
        }
    };
    private final c ftu;
    private final d ftv;
    private final a ftw;
    private String ftx;
    private OriginalThreadInfo fty;
    private String ftz;
    private int mFrom;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ftu = new c(tbPageContext);
        biK();
        this.ftv = new d(tbPageContext, tbPageContext.getUniqueId());
        this.ftv.a(this.ftG);
        this.eYW = new ArrayList<>();
        this.ftw = new a(tbPageContext, this.ftu.dvB);
        this.ftw.v(this.ftC);
        biM();
        tbPageContext.registerListener(this.ftF);
        tbPageContext.registerListener(this.ftE);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.ftD, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.ajM = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.fty = originalThreadInfo;
    }

    public void setMoreForumImg(String str) {
        this.ftA = str;
    }

    public void setMoreForumTitle(String str) {
        this.ftB = str;
    }

    public void setMoreForumUrl(String str) {
        this.ftz = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.ftA);
        writeActivityConfig.setMoreForumUrl(this.ftz);
        writeActivityConfig.setMoreForumTitle(this.ftB);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.ajM))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.fty);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c biI() {
        return this.ftu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biJ() {
        this.eYW.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.n(com.baidu.tieba.forumsearch.b.a.ftO);
        this.eYW.add(aVar);
        setDatas(this.eYW);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.eYW = arrayList;
        this.ftu.dvB.setData(arrayList);
    }

    private void biK() {
        this.ftu.mRoot.setOnClickListener(this);
        this.ftu.ftJ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.biL();
                    return true;
                }
                return false;
            }
        });
        this.ftu.ftJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.biL();
            }
        });
        this.ftu.ftJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.biL();
                }
            }
        });
        this.ftu.ftJ.setOnClickListener(this);
        this.ftu.eFZ.setOnClickListener(this);
        this.ftu.bIS.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biL() {
        if (this.ftu.ftJ.getText() == null || StringUtils.isNull(this.ftu.ftJ.getText().toString())) {
            this.ftu.eFZ.setVisibility(8);
            this.ftx = null;
            biM();
            return;
        }
        m mVar = (m) v.getItem(this.eYW, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.ftN) {
            this.eYW.clear();
            setDatas(this.eYW);
        }
        this.ftu.eFZ.setVisibility(0);
        this.ftx = this.ftu.ftJ.getText().toString();
        this.ftv.vI(this.ftx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biM() {
        this.ftv.cancelMessage();
        this.eYW.clear();
        ArrayList<String> biO = e.biO();
        if (!v.isEmpty(biO)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.n(com.baidu.tieba.forumsearch.b.a.ftN);
            this.eYW.add(aVar);
            this.eYW.add(new com.baidu.tieba.forumsearch.b.a(biO));
            setDatas(this.eYW);
            return;
        }
        this.eYW.clear();
        setDatas(this.eYW);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ftD);
        MessageManager.getInstance().unRegisterListener(this.ftF);
        MessageManager.getInstance().unRegisterListener(this.ftE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ftu.ftJ) {
            biL();
        } else if (view == this.ftu.bIS) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.ftu.ftJ);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.ftu.eFZ) {
            this.ftu.ftJ.setText("");
        } else if (view == this.ftu.mRoot) {
            setDatas(this.eYW);
        }
    }
}
