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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.forumsearch.controller.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private ArrayList<h> cQn;
    private final c dgb;
    private final d dgc;
    private final a dgd;
    private String dge;
    private OriginalThreadInfo dgf;
    private View.OnClickListener dgg = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                b.this.mPageContext.getPageActivity().setResult(-1, new Intent());
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.e(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.ba(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new am("c12609").f(ImageViewerConfig.FORUM_ID, bVar.getForumId()));
                }
            }
        }
    };
    private Runnable dgh = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.dgb.dgn);
        }
    };
    private CustomMessageListener dgi = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.dgb.dgn.setText(str);
                b.this.dgb.dgn.setSelection(str.length());
                b.this.asD();
            }
        }
    };
    private CustomMessageListener dgj = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.asE();
            }
        }
    };
    private d.a dgk = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || w.z(cVar.asM())) {
                if (StringUtils.isNull(b.this.dge)) {
                    b.this.asE();
                    return;
                } else {
                    b.this.asB();
                    return;
                }
            }
            b.this.cQn = cVar.asM();
            b.this.setDatas(b.this.cQn);
        }
    };
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dgb = new c(tbPageContext);
        asC();
        this.dgc = new d(tbPageContext, tbPageContext.getUniqueId());
        this.dgc.a(this.dgk);
        this.cQn = new ArrayList<>();
        this.dgd = new a(tbPageContext, this.dgb.mListView);
        this.dgd.m(this.dgg);
        asE();
        tbPageContext.registerListener(this.dgj);
        tbPageContext.registerListener(this.dgi);
        com.baidu.adp.lib.g.e.im().postDelayed(this.dgh, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.dgf = originalThreadInfo;
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
    public void ba(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.dgf);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c asA() {
        return this.dgb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asB() {
        this.cQn.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.dgt);
        this.cQn.add(aVar);
        setDatas(this.cQn);
    }

    public void setDatas(ArrayList<h> arrayList) {
        this.cQn = arrayList;
        this.dgb.mListView.setData(arrayList);
    }

    private void asC() {
        this.dgb.abp.setOnClickListener(this);
        this.dgb.dgn.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.asD();
                    return true;
                }
                return false;
            }
        });
        this.dgb.dgn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.asD();
            }
        });
        this.dgb.dgn.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.asD();
                }
            }
        });
        this.dgb.dgn.setOnClickListener(this);
        this.dgb.dgo.setOnClickListener(this);
        this.dgb.bXw.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asD() {
        if (this.dgb.dgn.getText() == null || StringUtils.isNull(this.dgb.dgn.getText().toString())) {
            this.dgb.dgo.setVisibility(8);
            this.dge = null;
            asE();
            return;
        }
        h hVar = (h) w.c(this.cQn, 0);
        if (hVar != null && hVar.getType() == com.baidu.tieba.forumsearch.b.a.dgs) {
            this.cQn.clear();
            setDatas(this.cQn);
        }
        this.dgb.dgo.setVisibility(0);
        this.dge = this.dgb.dgn.getText().toString();
        this.dgc.mq(this.dge);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asE() {
        this.dgc.cancelMessage();
        this.cQn.clear();
        ArrayList<String> asG = e.asG();
        if (!w.z(asG)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.dgs);
            this.cQn.add(aVar);
            this.cQn.add(new com.baidu.tieba.forumsearch.b.a(asG));
            setDatas(this.cQn);
            return;
        }
        this.cQn.clear();
        setDatas(this.cQn);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.dgh);
        MessageManager.getInstance().unRegisterListener(this.dgj);
        MessageManager.getInstance().unRegisterListener(this.dgi);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dgb.dgn) {
            asD();
        } else if (view == this.dgb.bXw) {
            l.b(this.mPageContext.getPageActivity(), this.dgb.dgn);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.dgb.dgo) {
            this.dgb.dgn.setText("");
        } else if (view == this.dgb.abp) {
            setDatas(this.cQn);
        }
    }
}
