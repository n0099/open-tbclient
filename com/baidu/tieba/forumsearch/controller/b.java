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
    private ArrayList<m> eUE;
    private String fsA;
    private String fsB;
    private View.OnClickListener fsC = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.e(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.cW(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new an("c12609").l("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.cV(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable fsD = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.fsu.fsJ);
        }
    };
    private CustomMessageListener fsE = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.fsu.fsJ.setText(str);
                b.this.fsu.fsJ.setSelection(str.length());
                b.this.bkU();
            }
        }
    };
    private CustomMessageListener fsF = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bkV();
            }
        }
    };
    private d.a fsG = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.aa(cVar.bld())) {
                if (StringUtils.isNull(b.this.fsx)) {
                    b.this.bkV();
                    return;
                } else {
                    b.this.bkS();
                    return;
                }
            }
            b.this.eUE = cVar.bld();
            b.this.setDatas(b.this.eUE);
        }
    };
    private final c fsu;
    private final d fsv;
    private final a fsw;
    private String fsx;
    private OriginalThreadInfo fsy;
    private String fsz;
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fsu = new c(tbPageContext);
        bkT();
        this.fsv = new d(tbPageContext, tbPageContext.getUniqueId());
        this.fsv.a(this.fsG);
        this.eUE = new ArrayList<>();
        this.fsw = new a(tbPageContext, this.fsu.mListView);
        this.fsw.u(this.fsC);
        bkV();
        tbPageContext.registerListener(this.fsF);
        tbPageContext.registerListener(this.fsE);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.fsD, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.fsy = originalThreadInfo;
    }

    public void setMoreForumImg(String str) {
        this.fsA = str;
    }

    public void setMoreForumTitle(String str) {
        this.fsB = str;
    }

    public void setMoreForumUrl(String str) {
        this.fsz = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.fsA);
        writeActivityConfig.setMoreForumUrl(this.fsz);
        writeActivityConfig.setMoreForumTitle(this.fsB);
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
    public void cW(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.fsy);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c bkR() {
        return this.fsu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkS() {
        this.eUE.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.fsO);
        this.eUE.add(aVar);
        setDatas(this.eUE);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.eUE = arrayList;
        this.fsu.mListView.setData(arrayList);
    }

    private void bkT() {
        this.fsu.mRoot.setOnClickListener(this);
        this.fsu.fsJ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bkU();
                    return true;
                }
                return false;
            }
        });
        this.fsu.fsJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bkU();
            }
        });
        this.fsu.fsJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bkU();
                }
            }
        });
        this.fsu.fsJ.setOnClickListener(this);
        this.fsu.evF.setOnClickListener(this);
        this.fsu.bpI.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkU() {
        if (this.fsu.fsJ.getText() == null || StringUtils.isNull(this.fsu.fsJ.getText().toString())) {
            this.fsu.evF.setVisibility(8);
            this.fsx = null;
            bkV();
            return;
        }
        m mVar = (m) v.c(this.eUE, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.fsN) {
            this.eUE.clear();
            setDatas(this.eUE);
        }
        this.fsu.evF.setVisibility(0);
        this.fsx = this.fsu.fsJ.getText().toString();
        this.fsv.wR(this.fsx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkV() {
        this.fsv.cancelMessage();
        this.eUE.clear();
        ArrayList<String> bkX = e.bkX();
        if (!v.aa(bkX)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.fsN);
            this.eUE.add(aVar);
            this.eUE.add(new com.baidu.tieba.forumsearch.b.a(bkX));
            setDatas(this.eUE);
            return;
        }
        this.eUE.clear();
        setDatas(this.eUE);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fsD);
        MessageManager.getInstance().unRegisterListener(this.fsF);
        MessageManager.getInstance().unRegisterListener(this.fsE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fsu.fsJ) {
            bkU();
        } else if (view == this.fsu.bpI) {
            l.b(this.mPageContext.getPageActivity(), this.fsu.fsJ);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.fsu.evF) {
            this.fsu.fsJ.setText("");
        } else if (view == this.fsu.mRoot) {
            setDatas(this.eUE);
        }
    }
}
