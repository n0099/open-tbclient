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
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.forumsearch.controller.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private final c dJe;
    private final d dJf;
    private final a dJg;
    private String dJh;
    private OriginalThreadInfo dJi;
    private View.OnClickListener dJj = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.g(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.bB(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new am("c12609").i(ImageViewerConfig.FORUM_ID, bVar.getForumId()));
                } else if (b.this.mFrom == 3) {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable dJk = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.dJe.dJq);
        }
    };
    private CustomMessageListener dJl = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.dJe.dJq.setText(str);
                b.this.dJe.dJq.setSelection(str.length());
                b.this.aAy();
            }
        }
    };
    private CustomMessageListener dJm = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.aAz();
            }
        }
    };
    private d.a dJn = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.I(cVar.aAH())) {
                if (StringUtils.isNull(b.this.dJh)) {
                    b.this.aAz();
                    return;
                } else {
                    b.this.aAw();
                    return;
                }
            }
            b.this.dpB = cVar.aAH();
            b.this.setDatas(b.this.dpB);
        }
    };
    private ArrayList<h> dpB;
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dJe = new c(tbPageContext);
        aAx();
        this.dJf = new d(tbPageContext, tbPageContext.getUniqueId());
        this.dJf.a(this.dJn);
        this.dpB = new ArrayList<>();
        this.dJg = new a(tbPageContext, this.dJe.mListView);
        this.dJg.r(this.dJj);
        aAz();
        tbPageContext.registerListener(this.dJm);
        tbPageContext.registerListener(this.dJl);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.dJk, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.dJi = originalThreadInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.mLiveId))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.dJi);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c aAv() {
        return this.dJe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAw() {
        this.dpB.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.dJw);
        this.dpB.add(aVar);
        setDatas(this.dpB);
    }

    public void setDatas(ArrayList<h> arrayList) {
        this.dpB = arrayList;
        this.dJe.mListView.setData(arrayList);
    }

    private void aAx() {
        this.dJe.amM.setOnClickListener(this);
        this.dJe.dJq.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.aAy();
                    return true;
                }
                return false;
            }
        });
        this.dJe.dJq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.aAy();
            }
        });
        this.dJe.dJq.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.aAy();
                }
            }
        });
        this.dJe.dJq.setOnClickListener(this);
        this.dJe.dJr.setOnClickListener(this);
        this.dJe.mCancel.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAy() {
        if (this.dJe.dJq.getText() == null || StringUtils.isNull(this.dJe.dJq.getText().toString())) {
            this.dJe.dJr.setVisibility(8);
            this.dJh = null;
            aAz();
            return;
        }
        h hVar = (h) v.d(this.dpB, 0);
        if (hVar != null && hVar.getType() == com.baidu.tieba.forumsearch.b.a.dJv) {
            this.dpB.clear();
            setDatas(this.dpB);
        }
        this.dJe.dJr.setVisibility(0);
        this.dJh = this.dJe.dJq.getText().toString();
        this.dJf.nY(this.dJh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAz() {
        this.dJf.cancelMessage();
        this.dpB.clear();
        ArrayList<String> aAB = e.aAB();
        if (!v.I(aAB)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.dJv);
            this.dpB.add(aVar);
            this.dpB.add(new com.baidu.tieba.forumsearch.b.a(aAB));
            setDatas(this.dpB);
            return;
        }
        this.dpB.clear();
        setDatas(this.dpB);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dJk);
        MessageManager.getInstance().unRegisterListener(this.dJm);
        MessageManager.getInstance().unRegisterListener(this.dJl);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dJe.dJq) {
            aAy();
        } else if (view == this.dJe.mCancel) {
            l.b(this.mPageContext.getPageActivity(), this.dJe.dJq);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.dJe.dJr) {
            this.dJe.dJq.setText("");
        } else if (view == this.dJe.amM) {
            setDatas(this.dpB);
        }
    }
}
