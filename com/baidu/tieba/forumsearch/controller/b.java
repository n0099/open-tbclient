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
    private ArrayList<m> eWk;
    private final c fuh;
    private final d fui;
    private final a fuj;
    private String fuk;
    private OriginalThreadInfo ful;
    private String fum;
    private String fun;
    private String fuo;
    private View.OnClickListener fup = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.e(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.cX(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new an("c12609").n("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.cW(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable fuq = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.fuh.fuw);
        }
    };
    private CustomMessageListener fur = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.fuh.fuw.setText(str);
                b.this.fuh.fuw.setSelection(str.length());
                b.this.blF();
            }
        }
    };
    private CustomMessageListener fus = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.blG();
            }
        }
    };
    private d.a fut = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.aa(cVar.blO())) {
                if (StringUtils.isNull(b.this.fuk)) {
                    b.this.blG();
                    return;
                } else {
                    b.this.blD();
                    return;
                }
            }
            b.this.eWk = cVar.blO();
            b.this.setDatas(b.this.eWk);
        }
    };
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fuh = new c(tbPageContext);
        blE();
        this.fui = new d(tbPageContext, tbPageContext.getUniqueId());
        this.fui.a(this.fut);
        this.eWk = new ArrayList<>();
        this.fuj = new a(tbPageContext, this.fuh.mListView);
        this.fuj.u(this.fup);
        blG();
        tbPageContext.registerListener(this.fus);
        tbPageContext.registerListener(this.fur);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.fuq, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.ful = originalThreadInfo;
    }

    public void setMoreForumImg(String str) {
        this.fun = str;
    }

    public void setMoreForumTitle(String str) {
        this.fuo = str;
    }

    public void setMoreForumUrl(String str) {
        this.fum = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.fun);
        writeActivityConfig.setMoreForumUrl(this.fum);
        writeActivityConfig.setMoreForumTitle(this.fuo);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
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
    public void cX(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.ful);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c blC() {
        return this.fuh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blD() {
        this.eWk.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.fuB);
        this.eWk.add(aVar);
        setDatas(this.eWk);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.eWk = arrayList;
        this.fuh.mListView.setData(arrayList);
    }

    private void blE() {
        this.fuh.mRoot.setOnClickListener(this);
        this.fuh.fuw.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.blF();
                    return true;
                }
                return false;
            }
        });
        this.fuh.fuw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.blF();
            }
        });
        this.fuh.fuw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.blF();
                }
            }
        });
        this.fuh.fuw.setOnClickListener(this);
        this.fuh.exp.setOnClickListener(this);
        this.fuh.bqg.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blF() {
        if (this.fuh.fuw.getText() == null || StringUtils.isNull(this.fuh.fuw.getText().toString())) {
            this.fuh.exp.setVisibility(8);
            this.fuk = null;
            blG();
            return;
        }
        m mVar = (m) v.c(this.eWk, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.fuA) {
            this.eWk.clear();
            setDatas(this.eWk);
        }
        this.fuh.exp.setVisibility(0);
        this.fuk = this.fuh.fuw.getText().toString();
        this.fui.xq(this.fuk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blG() {
        this.fui.cancelMessage();
        this.eWk.clear();
        ArrayList<String> blI = e.blI();
        if (!v.aa(blI)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.fuA);
            this.eWk.add(aVar);
            this.eWk.add(new com.baidu.tieba.forumsearch.b.a(blI));
            setDatas(this.eWk);
            return;
        }
        this.eWk.clear();
        setDatas(this.eWk);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fuq);
        MessageManager.getInstance().unRegisterListener(this.fus);
        MessageManager.getInstance().unRegisterListener(this.fur);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fuh.fuw) {
            blF();
        } else if (view == this.fuh.bqg) {
            l.b(this.mPageContext.getPageActivity(), this.fuh.fuw);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.fuh.exp) {
            this.fuh.fuw.setText("");
        } else if (view == this.fuh.mRoot) {
            setDatas(this.eWk);
        }
    }
}
