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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.forumsearch.controller.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private ArrayList<h> cHg;
    private final c cWO;
    private final d cWP;
    private final a cWQ;
    private String cWR;
    private OriginalThreadInfo cWS;
    private View.OnClickListener cWT = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                b.this.mPageContext.getPageActivity().setResult(-1, new Intent());
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view2.getTag();
                if (b.this.mFrom == 1) {
                    b.this.e(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.aS(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new al("c12609").f(ImageViewerConfig.FORUM_ID, bVar.getForumId()));
                }
            }
        }
    };
    private Runnable cWU = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.cWO.cXa);
        }
    };
    private CustomMessageListener cWV = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.cWO.cXa.setText(str);
                b.this.cWO.cXa.setSelection(str.length());
                b.this.aoy();
            }
        }
    };
    private CustomMessageListener cWW = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.aoz();
            }
        }
    };
    private d.a cWX = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.w(cVar.aoH())) {
                if (StringUtils.isNull(b.this.cWR)) {
                    b.this.aoz();
                    return;
                } else {
                    b.this.aow();
                    return;
                }
            }
            b.this.cHg = cVar.aoH();
            b.this.setDatas(b.this.cHg);
        }
    };
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cWO = new c(tbPageContext);
        aox();
        this.cWP = new d(tbPageContext, tbPageContext.getUniqueId());
        this.cWP.a(this.cWX);
        this.cHg = new ArrayList<>();
        this.cWQ = new a(tbPageContext, this.cWO.mListView);
        this.cWQ.m(this.cWT);
        aoz();
        tbPageContext.registerListener(this.cWW);
        tbPageContext.registerListener(this.cWV);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.cWU, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.cWS = originalThreadInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.mLiveId))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.cWS);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c aov() {
        return this.cWO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aow() {
        this.cHg.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.cXg);
        this.cHg.add(aVar);
        setDatas(this.cHg);
    }

    public void setDatas(ArrayList<h> arrayList) {
        this.cHg = arrayList;
        this.cWO.mListView.setData(arrayList);
    }

    private void aox() {
        this.cWO.Th.setOnClickListener(this);
        this.cWO.cXa.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.aoy();
                    return true;
                }
                return false;
            }
        });
        this.cWO.cXa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.aoy();
            }
        });
        this.cWO.cXa.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view2);
                } else {
                    b.this.aoy();
                }
            }
        });
        this.cWO.cXa.setOnClickListener(this);
        this.cWO.cXb.setOnClickListener(this);
        this.cWO.bPv.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoy() {
        if (this.cWO.cXa.getText() == null || StringUtils.isNull(this.cWO.cXa.getText().toString())) {
            this.cWO.cXb.setVisibility(8);
            this.cWR = null;
            aoz();
            return;
        }
        h hVar = (h) v.c(this.cHg, 0);
        if (hVar != null && hVar.getType() == com.baidu.tieba.forumsearch.b.a.cXf) {
            this.cHg.clear();
            setDatas(this.cHg);
        }
        this.cWO.cXb.setVisibility(0);
        this.cWR = this.cWO.cXa.getText().toString();
        this.cWP.lJ(this.cWR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoz() {
        this.cWP.cancelMessage();
        this.cHg.clear();
        ArrayList<String> aoB = e.aoB();
        if (!v.w(aoB)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.cXf);
            this.cHg.add(aVar);
            this.cHg.add(new com.baidu.tieba.forumsearch.b.a(aoB));
            setDatas(this.cHg);
            return;
        }
        this.cHg.clear();
        setDatas(this.cHg);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.cWU);
        MessageManager.getInstance().unRegisterListener(this.cWW);
        MessageManager.getInstance().unRegisterListener(this.cWV);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.cWO.cXa) {
            aoy();
        } else if (view2 == this.cWO.bPv) {
            l.b(this.mPageContext.getPageActivity(), this.cWO.cXa);
            this.mPageContext.getPageActivity().finish();
        } else if (view2 == this.cWO.cXb) {
            this.cWO.cXa.setText("");
        } else if (view2 == this.cWO.Th) {
            setDatas(this.cHg);
        }
    }
}
