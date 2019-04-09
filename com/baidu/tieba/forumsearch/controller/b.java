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
    private final c eWR;
    private final d eWS;
    private final a eWT;
    private String eWU;
    private OriginalThreadInfo eWV;
    private View.OnClickListener eWW = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
    private Runnable eWX = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.eWR.eXd);
        }
    };
    private CustomMessageListener eWY = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.eWR.eXd.setText(str);
                b.this.eWR.eXd.setSelection(str.length());
                b.this.bbs();
            }
        }
    };
    private CustomMessageListener eWZ = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bbt();
            }
        }
    };
    private d.a eXa = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.T(cVar.bbB())) {
                if (StringUtils.isNull(b.this.eWU)) {
                    b.this.bbt();
                    return;
                } else {
                    b.this.bbq();
                    return;
                }
            }
            b.this.ezT = cVar.bbB();
            b.this.setDatas(b.this.ezT);
        }
    };
    private ArrayList<m> ezT;
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eWR = new c(tbPageContext);
        bbr();
        this.eWS = new d(tbPageContext, tbPageContext.getUniqueId());
        this.eWS.a(this.eXa);
        this.ezT = new ArrayList<>();
        this.eWT = new a(tbPageContext, this.eWR.mListView);
        this.eWT.s(this.eWW);
        bbt();
        tbPageContext.registerListener(this.eWZ);
        tbPageContext.registerListener(this.eWY);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.eWX, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.eWV = originalThreadInfo;
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
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.eWV);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c bbp() {
        return this.eWR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbq() {
        this.ezT.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.eXj);
        this.ezT.add(aVar);
        setDatas(this.ezT);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.ezT = arrayList;
        this.eWR.mListView.setData(arrayList);
    }

    private void bbr() {
        this.eWR.buc.setOnClickListener(this);
        this.eWR.eXd.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bbs();
                    return true;
                }
                return false;
            }
        });
        this.eWR.eXd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
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
        this.eWR.eXd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bbs();
                }
            }
        });
        this.eWR.eXd.setOnClickListener(this);
        this.eWR.eXe.setOnClickListener(this);
        this.eWR.biS.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbs() {
        if (this.eWR.eXd.getText() == null || StringUtils.isNull(this.eWR.eXd.getText().toString())) {
            this.eWR.eXe.setVisibility(8);
            this.eWU = null;
            bbt();
            return;
        }
        m mVar = (m) v.c(this.ezT, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.eXi) {
            this.ezT.clear();
            setDatas(this.ezT);
        }
        this.eWR.eXe.setVisibility(0);
        this.eWU = this.eWR.eXd.getText().toString();
        this.eWS.uS(this.eWU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbt() {
        this.eWS.cancelMessage();
        this.ezT.clear();
        ArrayList<String> bbv = e.bbv();
        if (!v.T(bbv)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.eXi);
            this.ezT.add(aVar);
            this.ezT.add(new com.baidu.tieba.forumsearch.b.a(bbv));
            setDatas(this.ezT);
            return;
        }
        this.ezT.clear();
        setDatas(this.ezT);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.eWX);
        MessageManager.getInstance().unRegisterListener(this.eWZ);
        MessageManager.getInstance().unRegisterListener(this.eWY);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eWR.eXd) {
            bbs();
        } else if (view == this.eWR.biS) {
            l.b(this.mPageContext.getPageActivity(), this.eWR.eXd);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.eWR.eXe) {
            this.eWR.eXd.setText("");
        } else if (view == this.eWR.buc) {
            setDatas(this.ezT);
        }
    }
}
