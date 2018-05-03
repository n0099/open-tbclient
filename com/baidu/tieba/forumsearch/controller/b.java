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
    private ArrayList<h> cFX;
    private final c cVH;
    private final d cVI;
    private final a cVJ;
    private String cVK;
    private OriginalThreadInfo cVL;
    private View.OnClickListener cVM = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
    private Runnable cVN = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.cVH.cVT);
        }
    };
    private CustomMessageListener cVO = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.cVH.cVT.setText(str);
                b.this.cVH.cVT.setSelection(str.length());
                b.this.aoz();
            }
        }
    };
    private CustomMessageListener cVP = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.aoA();
            }
        }
    };
    private d.a cVQ = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.w(cVar.aoI())) {
                if (StringUtils.isNull(b.this.cVK)) {
                    b.this.aoA();
                    return;
                } else {
                    b.this.aox();
                    return;
                }
            }
            b.this.cFX = cVar.aoI();
            b.this.setDatas(b.this.cFX);
        }
    };
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cVH = new c(tbPageContext);
        aoy();
        this.cVI = new d(tbPageContext, tbPageContext.getUniqueId());
        this.cVI.a(this.cVQ);
        this.cFX = new ArrayList<>();
        this.cVJ = new a(tbPageContext, this.cVH.mListView);
        this.cVJ.m(this.cVM);
        aoA();
        tbPageContext.registerListener(this.cVP);
        tbPageContext.registerListener(this.cVO);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.cVN, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.cVL = originalThreadInfo;
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
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.cVL);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c aow() {
        return this.cVH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aox() {
        this.cFX.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.cVZ);
        this.cFX.add(aVar);
        setDatas(this.cFX);
    }

    public void setDatas(ArrayList<h> arrayList) {
        this.cFX = arrayList;
        this.cVH.mListView.setData(arrayList);
    }

    private void aoy() {
        this.cVH.Tl.setOnClickListener(this);
        this.cVH.cVT.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.aoz();
                    return true;
                }
                return false;
            }
        });
        this.cVH.cVT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.aoz();
            }
        });
        this.cVH.cVT.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view2);
                } else {
                    b.this.aoz();
                }
            }
        });
        this.cVH.cVT.setOnClickListener(this);
        this.cVH.cVU.setOnClickListener(this);
        this.cVH.bOF.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoz() {
        if (this.cVH.cVT.getText() == null || StringUtils.isNull(this.cVH.cVT.getText().toString())) {
            this.cVH.cVU.setVisibility(8);
            this.cVK = null;
            aoA();
            return;
        }
        h hVar = (h) v.c(this.cFX, 0);
        if (hVar != null && hVar.getType() == com.baidu.tieba.forumsearch.b.a.cVY) {
            this.cFX.clear();
            setDatas(this.cFX);
        }
        this.cVH.cVU.setVisibility(0);
        this.cVK = this.cVH.cVT.getText().toString();
        this.cVI.lG(this.cVK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoA() {
        this.cVI.cancelMessage();
        this.cFX.clear();
        ArrayList<String> aoC = e.aoC();
        if (!v.w(aoC)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.cVY);
            this.cFX.add(aVar);
            this.cFX.add(new com.baidu.tieba.forumsearch.b.a(aoC));
            setDatas(this.cFX);
            return;
        }
        this.cFX.clear();
        setDatas(this.cFX);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.cVN);
        MessageManager.getInstance().unRegisterListener(this.cVP);
        MessageManager.getInstance().unRegisterListener(this.cVO);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.cVH.cVT) {
            aoz();
        } else if (view2 == this.cVH.bOF) {
            l.b(this.mPageContext.getPageActivity(), this.cVH.cVT);
            this.mPageContext.getPageActivity().finish();
        } else if (view2 == this.cVH.cVU) {
            this.cVH.cVT.setText("");
        } else if (view2 == this.cVH.Tl) {
            setDatas(this.cFX);
        }
    }
}
