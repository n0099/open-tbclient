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
    private final c dCY;
    private final d dCZ;
    private final a dDa;
    private String dDb;
    private OriginalThreadInfo dDc;
    private View.OnClickListener dDd = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
    private Runnable dDe = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.b(b.this.mPageContext.getPageActivity(), b.this.dCY.dDk);
        }
    };
    private CustomMessageListener dDf = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.dCY.dDk.setText(str);
                b.this.dCY.dDk.setSelection(str.length());
                b.this.auk();
            }
        }
    };
    private CustomMessageListener dDg = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.aul();
            }
        }
    };
    private d.a dDh = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.E(cVar.aut())) {
                if (StringUtils.isNull(b.this.dDb)) {
                    b.this.aul();
                    return;
                } else {
                    b.this.aui();
                    return;
                }
            }
            b.this.doe = cVar.aut();
            b.this.setDatas(b.this.doe);
        }
    };
    private ArrayList<i> doe;
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dCY = new c(tbPageContext);
        auj();
        this.dCZ = new d(tbPageContext, tbPageContext.getUniqueId());
        this.dCZ.a(this.dDh);
        this.doe = new ArrayList<>();
        this.dDa = new a(tbPageContext, this.dCY.mListView);
        this.dDa.k(this.dDd);
        aul();
        tbPageContext.registerListener(this.dDg);
        tbPageContext.registerListener(this.dDf);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.dDe, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.dDc = originalThreadInfo;
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
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.dDc);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c auh() {
        return this.dCY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aui() {
        this.doe.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.dDq);
        this.doe.add(aVar);
        setDatas(this.doe);
    }

    public void setDatas(ArrayList<i> arrayList) {
        this.doe = arrayList;
        this.dCY.mListView.setData(arrayList);
    }

    private void auj() {
        this.dCY.aId.setOnClickListener(this);
        this.dCY.dDk.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.auk();
                    return true;
                }
                return false;
            }
        });
        this.dCY.dDk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
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
        this.dCY.dDk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.auk();
                }
            }
        });
        this.dCY.dDk.setOnClickListener(this);
        this.dCY.dDl.setOnClickListener(this);
        this.dCY.cyE.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auk() {
        if (this.dCY.dDk.getText() == null || StringUtils.isNull(this.dCY.dDk.getText().toString())) {
            this.dCY.dDl.setVisibility(8);
            this.dDb = null;
            aul();
            return;
        }
        i iVar = (i) v.f(this.doe, 0);
        if (iVar != null && iVar.getType() == com.baidu.tieba.forumsearch.b.a.dDp) {
            this.doe.clear();
            setDatas(this.doe);
        }
        this.dCY.dDl.setVisibility(0);
        this.dDb = this.dCY.dDk.getText().toString();
        this.dCZ.lD(this.dDb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aul() {
        this.dCZ.cancelMessage();
        this.doe.clear();
        ArrayList<String> aun = e.aun();
        if (!v.E(aun)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.dDp);
            this.doe.add(aVar);
            this.doe.add(new com.baidu.tieba.forumsearch.b.a(aun));
            setDatas(this.doe);
            return;
        }
        this.doe.clear();
        setDatas(this.doe);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.dDe);
        MessageManager.getInstance().unRegisterListener(this.dDg);
        MessageManager.getInstance().unRegisterListener(this.dDf);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dCY.dDk) {
            auk();
        } else if (view == this.dCY.cyE) {
            l.a(this.mPageContext.getPageActivity(), this.dCY.dDk);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.dCY.dDl) {
            this.dCY.dDk.setText("");
        } else if (view == this.dCY.aId) {
            setDatas(this.doe);
        }
    }
}
