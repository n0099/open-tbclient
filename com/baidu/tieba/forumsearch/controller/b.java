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
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.forumsearch.controller.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private final c dCP;
    private final d dCQ;
    private final a dCR;
    private String dCS;
    private OriginalThreadInfo dCT;
    private View.OnClickListener dCU = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                b.this.mPageContext.getPageActivity().setResult(-1, new Intent());
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.d(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.aT(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new ak("c12609").f(ImageViewerConfig.FORUM_ID, bVar.getForumId()));
                }
            }
        }
    };
    private Runnable dCV = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.b(b.this.mPageContext.getPageActivity(), b.this.dCP.dDb);
        }
    };
    private CustomMessageListener dCW = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.dCP.dDb.setText(str);
                b.this.dCP.dDb.setSelection(str.length());
                b.this.auk();
            }
        }
    };
    private CustomMessageListener dCX = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.aul();
            }
        }
    };
    private d.a dCY = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.E(cVar.aut())) {
                if (StringUtils.isNull(b.this.dCS)) {
                    b.this.aul();
                    return;
                } else {
                    b.this.aui();
                    return;
                }
            }
            b.this.dnU = cVar.aut();
            b.this.setDatas(b.this.dnU);
        }
    };
    private ArrayList<i> dnU;
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dCP = new c(tbPageContext);
        auj();
        this.dCQ = new d(tbPageContext, tbPageContext.getUniqueId());
        this.dCQ.a(this.dCY);
        this.dnU = new ArrayList<>();
        this.dCR = new a(tbPageContext, this.dCP.mListView);
        this.dCR.k(this.dCU);
        aul();
        tbPageContext.registerListener(this.dCX);
        tbPageContext.registerListener(this.dCW);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.dCV, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.dCT = originalThreadInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.mLiveId))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.dCT);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c auh() {
        return this.dCP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aui() {
        this.dnU.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.dDh);
        this.dnU.add(aVar);
        setDatas(this.dnU);
    }

    public void setDatas(ArrayList<i> arrayList) {
        this.dnU = arrayList;
        this.dCP.mListView.setData(arrayList);
    }

    private void auj() {
        this.dCP.aHT.setOnClickListener(this);
        this.dCP.dDb.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.auk();
                    return true;
                }
                return false;
            }
        });
        this.dCP.dDb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.auk();
            }
        });
        this.dCP.dDb.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.auk();
                }
            }
        });
        this.dCP.dDb.setOnClickListener(this);
        this.dCP.dDc.setOnClickListener(this);
        this.dCP.cyv.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auk() {
        if (this.dCP.dDb.getText() == null || StringUtils.isNull(this.dCP.dDb.getText().toString())) {
            this.dCP.dDc.setVisibility(8);
            this.dCS = null;
            aul();
            return;
        }
        i iVar = (i) v.f(this.dnU, 0);
        if (iVar != null && iVar.getType() == com.baidu.tieba.forumsearch.b.a.dDg) {
            this.dnU.clear();
            setDatas(this.dnU);
        }
        this.dCP.dDc.setVisibility(0);
        this.dCS = this.dCP.dDb.getText().toString();
        this.dCQ.lD(this.dCS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aul() {
        this.dCQ.cancelMessage();
        this.dnU.clear();
        ArrayList<String> aun = e.aun();
        if (!v.E(aun)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.dDg);
            this.dnU.add(aVar);
            this.dnU.add(new com.baidu.tieba.forumsearch.b.a(aun));
            setDatas(this.dnU);
            return;
        }
        this.dnU.clear();
        setDatas(this.dnU);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.dCV);
        MessageManager.getInstance().unRegisterListener(this.dCX);
        MessageManager.getInstance().unRegisterListener(this.dCW);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dCP.dDb) {
            auk();
        } else if (view == this.dCP.cyv) {
            l.a(this.mPageContext.getPageActivity(), this.dCP.dDb);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.dCP.dDc) {
            this.dCP.dDb.setText("");
        } else if (view == this.dCP.aHT) {
            setDatas(this.dnU);
        }
    }
}
