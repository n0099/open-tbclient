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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.forumsearch.controller.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private ArrayList<h> cOi;
    private final c dhS;
    private final d dhT;
    private final a dhU;
    private String dhV;
    private OriginalThreadInfo dhW;
    private View.OnClickListener dhX = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                b.this.mPageContext.getPageActivity().setResult(-1, new Intent());
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.e(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.be(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new an("c12609").f(ImageViewerConfig.FORUM_ID, bVar.getForumId()));
                }
            }
        }
    };
    private Runnable dhY = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.dhS.die);
        }
    };
    private CustomMessageListener dhZ = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.dhS.die.setText(str);
                b.this.dhS.die.setSelection(str.length());
                b.this.asO();
            }
        }
    };
    private CustomMessageListener dia = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.asP();
            }
        }
    };
    private d.a dib = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || w.A(cVar.asX())) {
                if (StringUtils.isNull(b.this.dhV)) {
                    b.this.asP();
                    return;
                } else {
                    b.this.asM();
                    return;
                }
            }
            b.this.cOi = cVar.asX();
            b.this.setDatas(b.this.cOi);
        }
    };
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dhS = new c(tbPageContext);
        asN();
        this.dhT = new d(tbPageContext, tbPageContext.getUniqueId());
        this.dhT.a(this.dib);
        this.cOi = new ArrayList<>();
        this.dhU = new a(tbPageContext, this.dhS.mListView);
        this.dhU.p(this.dhX);
        asP();
        tbPageContext.registerListener(this.dia);
        tbPageContext.registerListener(this.dhZ);
        com.baidu.adp.lib.g.e.im().postDelayed(this.dhY, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.dhW = originalThreadInfo;
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
    public void be(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.dhW);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c asL() {
        return this.dhS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asM() {
        this.cOi.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.dik);
        this.cOi.add(aVar);
        setDatas(this.cOi);
    }

    public void setDatas(ArrayList<h> arrayList) {
        this.cOi = arrayList;
        this.dhS.mListView.setData(arrayList);
    }

    private void asN() {
        this.dhS.abt.setOnClickListener(this);
        this.dhS.die.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.asO();
                    return true;
                }
                return false;
            }
        });
        this.dhS.die.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.asO();
            }
        });
        this.dhS.die.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.asO();
                }
            }
        });
        this.dhS.die.setOnClickListener(this);
        this.dhS.dif.setOnClickListener(this);
        this.dhS.bZF.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asO() {
        if (this.dhS.die.getText() == null || StringUtils.isNull(this.dhS.die.getText().toString())) {
            this.dhS.dif.setVisibility(8);
            this.dhV = null;
            asP();
            return;
        }
        h hVar = (h) w.d(this.cOi, 0);
        if (hVar != null && hVar.getType() == com.baidu.tieba.forumsearch.b.a.dij) {
            this.cOi.clear();
            setDatas(this.cOi);
        }
        this.dhS.dif.setVisibility(0);
        this.dhV = this.dhS.die.getText().toString();
        this.dhT.mq(this.dhV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asP() {
        this.dhT.cancelMessage();
        this.cOi.clear();
        ArrayList<String> asR = e.asR();
        if (!w.A(asR)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.dij);
            this.cOi.add(aVar);
            this.cOi.add(new com.baidu.tieba.forumsearch.b.a(asR));
            setDatas(this.cOi);
            return;
        }
        this.cOi.clear();
        setDatas(this.cOi);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.dhY);
        MessageManager.getInstance().unRegisterListener(this.dia);
        MessageManager.getInstance().unRegisterListener(this.dhZ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dhS.die) {
            asO();
        } else if (view == this.dhS.bZF) {
            l.b(this.mPageContext.getPageActivity(), this.dhS.die);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.dhS.dif) {
            this.dhS.die.setText("");
        } else if (view == this.dhS.abt) {
            setDatas(this.cOi);
        }
    }
}
