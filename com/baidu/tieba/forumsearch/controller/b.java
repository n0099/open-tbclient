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
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.forumsearch.controller.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private ArrayList<h> cQR;
    private final c dkI;
    private final d dkJ;
    private final a dkK;
    private String dkL;
    private OriginalThreadInfo dkM;
    private View.OnClickListener dkN = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                b.this.mPageContext.getPageActivity().setResult(-1, new Intent());
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.d(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.bc(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new an("c12609").f(ImageViewerConfig.FORUM_ID, bVar.getForumId()));
                }
            }
        }
    };
    private Runnable dkO = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.b(b.this.mPageContext.getPageActivity(), b.this.dkI.dkU);
        }
    };
    private CustomMessageListener dkP = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.dkI.dkU.setText(str);
                b.this.dkI.dkU.setSelection(str.length());
                b.this.ats();
            }
        }
    };
    private CustomMessageListener dkQ = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.att();
            }
        }
    };
    private d.a dkR = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || w.z(cVar.atB())) {
                if (StringUtils.isNull(b.this.dkL)) {
                    b.this.att();
                    return;
                } else {
                    b.this.atq();
                    return;
                }
            }
            b.this.cQR = cVar.atB();
            b.this.setDatas(b.this.cQR);
        }
    };
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dkI = new c(tbPageContext);
        atr();
        this.dkJ = new d(tbPageContext, tbPageContext.getUniqueId());
        this.dkJ.a(this.dkR);
        this.cQR = new ArrayList<>();
        this.dkK = new a(tbPageContext, this.dkI.mListView);
        this.dkK.p(this.dkN);
        att();
        tbPageContext.registerListener(this.dkQ);
        tbPageContext.registerListener(this.dkP);
        com.baidu.adp.lib.g.e.in().postDelayed(this.dkO, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.dkM = originalThreadInfo;
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
    public void bc(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.dkM);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c atp() {
        return this.dkI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atq() {
        this.cQR.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.dla);
        this.cQR.add(aVar);
        setDatas(this.cQR);
    }

    public void setDatas(ArrayList<h> arrayList) {
        this.cQR = arrayList;
        this.dkI.mListView.setData(arrayList);
    }

    private void atr() {
        this.dkI.aaV.setOnClickListener(this);
        this.dkI.dkU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.ats();
                    return true;
                }
                return false;
            }
        });
        this.dkI.dkU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.ats();
            }
        });
        this.dkI.dkU.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.ats();
                }
            }
        });
        this.dkI.dkU.setOnClickListener(this);
        this.dkI.dkV.setOnClickListener(this);
        this.dkI.caP.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ats() {
        if (this.dkI.dkU.getText() == null || StringUtils.isNull(this.dkI.dkU.getText().toString())) {
            this.dkI.dkV.setVisibility(8);
            this.dkL = null;
            att();
            return;
        }
        h hVar = (h) w.d(this.cQR, 0);
        if (hVar != null && hVar.getType() == com.baidu.tieba.forumsearch.b.a.dkZ) {
            this.cQR.clear();
            setDatas(this.cQR);
        }
        this.dkI.dkV.setVisibility(0);
        this.dkL = this.dkI.dkU.getText().toString();
        this.dkJ.mp(this.dkL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void att() {
        this.dkJ.cancelMessage();
        this.cQR.clear();
        ArrayList<String> atv = e.atv();
        if (!w.z(atv)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.dkZ);
            this.cQR.add(aVar);
            this.cQR.add(new com.baidu.tieba.forumsearch.b.a(atv));
            setDatas(this.cQR);
            return;
        }
        this.cQR.clear();
        setDatas(this.cQR);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.dkO);
        MessageManager.getInstance().unRegisterListener(this.dkQ);
        MessageManager.getInstance().unRegisterListener(this.dkP);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dkI.dkU) {
            ats();
        } else if (view == this.dkI.caP) {
            l.a(this.mPageContext.getPageActivity(), this.dkI.dkU);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.dkI.dkV) {
            this.dkI.dkU.setText("");
        } else if (view == this.dkI.aaV) {
            setDatas(this.cQR);
        }
    }
}
