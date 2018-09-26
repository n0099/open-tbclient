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
    private ArrayList<h> cWF;
    private final d dqA;
    private final a dqB;
    private String dqC;
    private OriginalThreadInfo dqD;
    private View.OnClickListener dqE = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.g(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.bk(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new am("c12609").g(ImageViewerConfig.FORUM_ID, bVar.getForumId()));
                } else if (b.this.mFrom == 3) {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable dqF = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.b(b.this.mPageContext.getPageActivity(), b.this.dqz.dqL);
        }
    };
    private CustomMessageListener dqG = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.dqz.dqL.setText(str);
                b.this.dqz.dqL.setSelection(str.length());
                b.this.avf();
            }
        }
    };
    private CustomMessageListener dqH = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.avg();
            }
        }
    };
    private d.a dqI = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.z(cVar.avo())) {
                if (StringUtils.isNull(b.this.dqC)) {
                    b.this.avg();
                    return;
                } else {
                    b.this.avd();
                    return;
                }
            }
            b.this.cWF = cVar.avo();
            b.this.setDatas(b.this.cWF);
        }
    };
    private final c dqz;
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dqz = new c(tbPageContext);
        ave();
        this.dqA = new d(tbPageContext, tbPageContext.getUniqueId());
        this.dqA.a(this.dqI);
        this.cWF = new ArrayList<>();
        this.dqB = new a(tbPageContext, this.dqz.mListView);
        this.dqB.p(this.dqE);
        avg();
        tbPageContext.registerListener(this.dqH);
        tbPageContext.registerListener(this.dqG);
        com.baidu.adp.lib.g.e.jt().postDelayed(this.dqF, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.dqD = originalThreadInfo;
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
    public void bk(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.dqD);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c avc() {
        return this.dqz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avd() {
        this.cWF.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.dqR);
        this.cWF.add(aVar);
        setDatas(this.cWF);
    }

    public void setDatas(ArrayList<h> arrayList) {
        this.cWF = arrayList;
        this.dqz.mListView.setData(arrayList);
    }

    private void ave() {
        this.dqz.adA.setOnClickListener(this);
        this.dqz.dqL.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.avf();
                    return true;
                }
                return false;
            }
        });
        this.dqz.dqL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.avf();
            }
        });
        this.dqz.dqL.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.avf();
                }
            }
        });
        this.dqz.dqL.setOnClickListener(this);
        this.dqz.dqM.setOnClickListener(this);
        this.dqz.cgD.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avf() {
        if (this.dqz.dqL.getText() == null || StringUtils.isNull(this.dqz.dqL.getText().toString())) {
            this.dqz.dqM.setVisibility(8);
            this.dqC = null;
            avg();
            return;
        }
        h hVar = (h) v.d(this.cWF, 0);
        if (hVar != null && hVar.getType() == com.baidu.tieba.forumsearch.b.a.dqQ) {
            this.cWF.clear();
            setDatas(this.cWF);
        }
        this.dqz.dqM.setVisibility(0);
        this.dqC = this.dqz.dqL.getText().toString();
        this.dqA.mT(this.dqC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avg() {
        this.dqA.cancelMessage();
        this.cWF.clear();
        ArrayList<String> avi = e.avi();
        if (!v.z(avi)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.dqQ);
            this.cWF.add(aVar);
            this.cWF.add(new com.baidu.tieba.forumsearch.b.a(avi));
            setDatas(this.cWF);
            return;
        }
        this.cWF.clear();
        setDatas(this.cWF);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.dqF);
        MessageManager.getInstance().unRegisterListener(this.dqH);
        MessageManager.getInstance().unRegisterListener(this.dqG);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dqz.dqL) {
            avf();
        } else if (view == this.dqz.cgD) {
            l.a(this.mPageContext.getPageActivity(), this.dqz.dqL);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.dqz.dqM) {
            this.dqz.dqL.setText("");
        } else if (view == this.dqz.adA) {
            setDatas(this.cWF);
        }
    }
}
