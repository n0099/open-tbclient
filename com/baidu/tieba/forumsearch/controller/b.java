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
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    private final c eWQ;
    private final d eWR;
    private final a eWS;
    private String eWT;
    private OriginalThreadInfo eWU;
    private View.OnClickListener eWV = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.g(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.cI(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new am("c12609").k(ImageViewerConfig.FORUM_ID, bVar.getForumId()));
                } else if (b.this.mFrom == 3) {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable eWW = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.eWQ.eXc);
        }
    };
    private CustomMessageListener eWX = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.eWQ.eXc.setText(str);
                b.this.eWQ.eXc.setSelection(str.length());
                b.this.bbs();
            }
        }
    };
    private CustomMessageListener eWY = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bbt();
            }
        }
    };
    private d.a eWZ = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.T(cVar.bbB())) {
                if (StringUtils.isNull(b.this.eWT)) {
                    b.this.bbt();
                    return;
                } else {
                    b.this.bbq();
                    return;
                }
            }
            b.this.ezS = cVar.bbB();
            b.this.setDatas(b.this.ezS);
        }
    };
    private ArrayList<m> ezS;
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eWQ = new c(tbPageContext);
        bbr();
        this.eWR = new d(tbPageContext, tbPageContext.getUniqueId());
        this.eWR.a(this.eWZ);
        this.ezS = new ArrayList<>();
        this.eWS = new a(tbPageContext, this.eWQ.mListView);
        this.eWS.s(this.eWV);
        bbt();
        tbPageContext.registerListener(this.eWY);
        tbPageContext.registerListener(this.eWX);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.eWW, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.eWU = originalThreadInfo;
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
    public void cI(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.eWU);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c bbp() {
        return this.eWQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbq() {
        this.ezS.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.eXi);
        this.ezS.add(aVar);
        setDatas(this.ezS);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.ezS = arrayList;
        this.eWQ.mListView.setData(arrayList);
    }

    private void bbr() {
        this.eWQ.bub.setOnClickListener(this);
        this.eWQ.eXc.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bbs();
                    return true;
                }
                return false;
            }
        });
        this.eWQ.eXc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bbs();
            }
        });
        this.eWQ.eXc.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bbs();
                }
            }
        });
        this.eWQ.eXc.setOnClickListener(this);
        this.eWQ.eXd.setOnClickListener(this);
        this.eWQ.biR.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbs() {
        if (this.eWQ.eXc.getText() == null || StringUtils.isNull(this.eWQ.eXc.getText().toString())) {
            this.eWQ.eXd.setVisibility(8);
            this.eWT = null;
            bbt();
            return;
        }
        m mVar = (m) v.c(this.ezS, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.eXh) {
            this.ezS.clear();
            setDatas(this.ezS);
        }
        this.eWQ.eXd.setVisibility(0);
        this.eWT = this.eWQ.eXc.getText().toString();
        this.eWR.uS(this.eWT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbt() {
        this.eWR.cancelMessage();
        this.ezS.clear();
        ArrayList<String> bbv = e.bbv();
        if (!v.T(bbv)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.eXh);
            this.ezS.add(aVar);
            this.ezS.add(new com.baidu.tieba.forumsearch.b.a(bbv));
            setDatas(this.ezS);
            return;
        }
        this.ezS.clear();
        setDatas(this.ezS);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.eWW);
        MessageManager.getInstance().unRegisterListener(this.eWY);
        MessageManager.getInstance().unRegisterListener(this.eWX);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eWQ.eXc) {
            bbs();
        } else if (view == this.eWQ.biR) {
            l.b(this.mPageContext.getPageActivity(), this.eWQ.eXc);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.eWQ.eXd) {
            this.eWQ.eXc.setText("");
        } else if (view == this.eWQ.bub) {
            setDatas(this.ezS);
        }
    }
}
