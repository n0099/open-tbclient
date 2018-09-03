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
    private ArrayList<h> cQO;
    private final c dkG;
    private final d dkH;
    private final a dkI;
    private String dkJ;
    private OriginalThreadInfo dkK;
    private View.OnClickListener dkL = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
    private Runnable dkM = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.b(b.this.mPageContext.getPageActivity(), b.this.dkG.dkS);
        }
    };
    private CustomMessageListener dkN = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.dkG.dkS.setText(str);
                b.this.dkG.dkS.setSelection(str.length());
                b.this.atr();
            }
        }
    };
    private CustomMessageListener dkO = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.ats();
            }
        }
    };
    private d.a dkP = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || w.z(cVar.atA())) {
                if (StringUtils.isNull(b.this.dkJ)) {
                    b.this.ats();
                    return;
                } else {
                    b.this.atp();
                    return;
                }
            }
            b.this.cQO = cVar.atA();
            b.this.setDatas(b.this.cQO);
        }
    };
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dkG = new c(tbPageContext);
        atq();
        this.dkH = new d(tbPageContext, tbPageContext.getUniqueId());
        this.dkH.a(this.dkP);
        this.cQO = new ArrayList<>();
        this.dkI = new a(tbPageContext, this.dkG.mListView);
        this.dkI.p(this.dkL);
        ats();
        tbPageContext.registerListener(this.dkO);
        tbPageContext.registerListener(this.dkN);
        com.baidu.adp.lib.g.e.in().postDelayed(this.dkM, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.dkK = originalThreadInfo;
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
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.dkK);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c ato() {
        return this.dkG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atp() {
        this.cQO.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.dkY);
        this.cQO.add(aVar);
        setDatas(this.cQO);
    }

    public void setDatas(ArrayList<h> arrayList) {
        this.cQO = arrayList;
        this.dkG.mListView.setData(arrayList);
    }

    private void atq() {
        this.dkG.aaW.setOnClickListener(this);
        this.dkG.dkS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.atr();
                    return true;
                }
                return false;
            }
        });
        this.dkG.dkS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.atr();
            }
        });
        this.dkG.dkS.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.atr();
                }
            }
        });
        this.dkG.dkS.setOnClickListener(this);
        this.dkG.dkT.setOnClickListener(this);
        this.dkG.caN.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atr() {
        if (this.dkG.dkS.getText() == null || StringUtils.isNull(this.dkG.dkS.getText().toString())) {
            this.dkG.dkT.setVisibility(8);
            this.dkJ = null;
            ats();
            return;
        }
        h hVar = (h) w.d(this.cQO, 0);
        if (hVar != null && hVar.getType() == com.baidu.tieba.forumsearch.b.a.dkX) {
            this.cQO.clear();
            setDatas(this.cQO);
        }
        this.dkG.dkT.setVisibility(0);
        this.dkJ = this.dkG.dkS.getText().toString();
        this.dkH.mr(this.dkJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ats() {
        this.dkH.cancelMessage();
        this.cQO.clear();
        ArrayList<String> atu = e.atu();
        if (!w.z(atu)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.dkX);
            this.cQO.add(aVar);
            this.cQO.add(new com.baidu.tieba.forumsearch.b.a(atu));
            setDatas(this.cQO);
            return;
        }
        this.cQO.clear();
        setDatas(this.cQO);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.dkM);
        MessageManager.getInstance().unRegisterListener(this.dkO);
        MessageManager.getInstance().unRegisterListener(this.dkN);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dkG.dkS) {
            atr();
        } else if (view == this.dkG.caN) {
            l.a(this.mPageContext.getPageActivity(), this.dkG.dkS);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.dkG.dkT) {
            this.dkG.dkS.setText("");
        } else if (view == this.dkG.aaW) {
            setDatas(this.cQO);
        }
    }
}
