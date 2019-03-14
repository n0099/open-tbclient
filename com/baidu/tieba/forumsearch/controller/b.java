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
    private ArrayList<m> eAh;
    private final c eXe;
    private final d eXf;
    private final a eXg;
    private String eXh;
    private OriginalThreadInfo eXi;
    private View.OnClickListener eXj = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.g(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.cH(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new am("c12609").k(ImageViewerConfig.FORUM_ID, bVar.getForumId()));
                } else if (b.this.mFrom == 3) {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable eXk = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.eXe.eXq);
        }
    };
    private CustomMessageListener eXl = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.eXe.eXq.setText(str);
                b.this.eXe.eXq.setSelection(str.length());
                b.this.bbu();
            }
        }
    };
    private CustomMessageListener eXm = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bbv();
            }
        }
    };
    private d.a eXn = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.T(cVar.bbD())) {
                if (StringUtils.isNull(b.this.eXh)) {
                    b.this.bbv();
                    return;
                } else {
                    b.this.bbs();
                    return;
                }
            }
            b.this.eAh = cVar.bbD();
            b.this.setDatas(b.this.eAh);
        }
    };
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eXe = new c(tbPageContext);
        bbt();
        this.eXf = new d(tbPageContext, tbPageContext.getUniqueId());
        this.eXf.a(this.eXn);
        this.eAh = new ArrayList<>();
        this.eXg = new a(tbPageContext, this.eXe.mListView);
        this.eXg.s(this.eXj);
        bbv();
        tbPageContext.registerListener(this.eXm);
        tbPageContext.registerListener(this.eXl);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.eXk, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.eXi = originalThreadInfo;
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
    public void cH(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.eXi);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c bbr() {
        return this.eXe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbs() {
        this.eAh.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.eXw);
        this.eAh.add(aVar);
        setDatas(this.eAh);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.eAh = arrayList;
        this.eXe.mListView.setData(arrayList);
    }

    private void bbt() {
        this.eXe.btY.setOnClickListener(this);
        this.eXe.eXq.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bbu();
                    return true;
                }
                return false;
            }
        });
        this.eXe.eXq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bbu();
            }
        });
        this.eXe.eXq.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bbu();
                }
            }
        });
        this.eXe.eXq.setOnClickListener(this);
        this.eXe.eXr.setOnClickListener(this);
        this.eXe.biO.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbu() {
        if (this.eXe.eXq.getText() == null || StringUtils.isNull(this.eXe.eXq.getText().toString())) {
            this.eXe.eXr.setVisibility(8);
            this.eXh = null;
            bbv();
            return;
        }
        m mVar = (m) v.c(this.eAh, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.eXv) {
            this.eAh.clear();
            setDatas(this.eAh);
        }
        this.eXe.eXr.setVisibility(0);
        this.eXh = this.eXe.eXq.getText().toString();
        this.eXf.uT(this.eXh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbv() {
        this.eXf.cancelMessage();
        this.eAh.clear();
        ArrayList<String> bbx = e.bbx();
        if (!v.T(bbx)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.eXv);
            this.eAh.add(aVar);
            this.eAh.add(new com.baidu.tieba.forumsearch.b.a(bbx));
            setDatas(this.eAh);
            return;
        }
        this.eAh.clear();
        setDatas(this.eAh);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.eXk);
        MessageManager.getInstance().unRegisterListener(this.eXm);
        MessageManager.getInstance().unRegisterListener(this.eXl);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eXe.eXq) {
            bbu();
        } else if (view == this.eXe.biO) {
            l.b(this.mPageContext.getPageActivity(), this.eXe.eXq);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.eXe.eXr) {
            this.eXe.eXq.setText("");
        } else if (view == this.eXe.btY) {
            setDatas(this.eAh);
        }
    }
}
