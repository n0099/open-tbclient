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
    private final c dCM;
    private final d dCN;
    private final a dCO;
    private String dCP;
    private OriginalThreadInfo dCQ;
    private View.OnClickListener dCR = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
    private Runnable dCS = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.b(b.this.mPageContext.getPageActivity(), b.this.dCM.dCY);
        }
    };
    private CustomMessageListener dCT = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.dCM.dCY.setText(str);
                b.this.dCM.dCY.setSelection(str.length());
                b.this.auj();
            }
        }
    };
    private CustomMessageListener dCU = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.auk();
            }
        }
    };
    private d.a dCV = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.E(cVar.aus())) {
                if (StringUtils.isNull(b.this.dCP)) {
                    b.this.auk();
                    return;
                } else {
                    b.this.auh();
                    return;
                }
            }
            b.this.dnR = cVar.aus();
            b.this.setDatas(b.this.dnR);
        }
    };
    private ArrayList<i> dnR;
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dCM = new c(tbPageContext);
        aui();
        this.dCN = new d(tbPageContext, tbPageContext.getUniqueId());
        this.dCN.a(this.dCV);
        this.dnR = new ArrayList<>();
        this.dCO = new a(tbPageContext, this.dCM.mListView);
        this.dCO.k(this.dCR);
        auk();
        tbPageContext.registerListener(this.dCU);
        tbPageContext.registerListener(this.dCT);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.dCS, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.dCQ = originalThreadInfo;
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
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.dCQ);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c aug() {
        return this.dCM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auh() {
        this.dnR.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.dDe);
        this.dnR.add(aVar);
        setDatas(this.dnR);
    }

    public void setDatas(ArrayList<i> arrayList) {
        this.dnR = arrayList;
        this.dCM.mListView.setData(arrayList);
    }

    private void aui() {
        this.dCM.aHS.setOnClickListener(this);
        this.dCM.dCY.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.auj();
                    return true;
                }
                return false;
            }
        });
        this.dCM.dCY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.auj();
            }
        });
        this.dCM.dCY.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.auj();
                }
            }
        });
        this.dCM.dCY.setOnClickListener(this);
        this.dCM.dCZ.setOnClickListener(this);
        this.dCM.cys.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auj() {
        if (this.dCM.dCY.getText() == null || StringUtils.isNull(this.dCM.dCY.getText().toString())) {
            this.dCM.dCZ.setVisibility(8);
            this.dCP = null;
            auk();
            return;
        }
        i iVar = (i) v.f(this.dnR, 0);
        if (iVar != null && iVar.getType() == com.baidu.tieba.forumsearch.b.a.dDd) {
            this.dnR.clear();
            setDatas(this.dnR);
        }
        this.dCM.dCZ.setVisibility(0);
        this.dCP = this.dCM.dCY.getText().toString();
        this.dCN.lD(this.dCP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auk() {
        this.dCN.cancelMessage();
        this.dnR.clear();
        ArrayList<String> aum = e.aum();
        if (!v.E(aum)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.dDd);
            this.dnR.add(aVar);
            this.dnR.add(new com.baidu.tieba.forumsearch.b.a(aum));
            setDatas(this.dnR);
            return;
        }
        this.dnR.clear();
        setDatas(this.dnR);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.dCS);
        MessageManager.getInstance().unRegisterListener(this.dCU);
        MessageManager.getInstance().unRegisterListener(this.dCT);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dCM.dCY) {
            auj();
        } else if (view == this.dCM.cys) {
            l.a(this.mPageContext.getPageActivity(), this.dCM.dCY);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.dCM.dCZ) {
            this.dCM.dCY.setText("");
        } else if (view == this.dCM.aHS) {
            setDatas(this.dnR);
        }
    }
}
