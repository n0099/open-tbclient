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
    private ArrayList<h> deX;
    private final c dyA;
    private final d dyB;
    private final a dyC;
    private String dyD;
    private OriginalThreadInfo dyE;
    private View.OnClickListener dyF = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.g(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.bw(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new am("c12609").h(ImageViewerConfig.FORUM_ID, bVar.getForumId()));
                } else if (b.this.mFrom == 3) {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable dyG = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.b(b.this.mPageContext.getPageActivity(), b.this.dyA.dyM);
        }
    };
    private CustomMessageListener dyH = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.dyA.dyM.setText(str);
                b.this.dyA.dyM.setSelection(str.length());
                b.this.ayC();
            }
        }
    };
    private CustomMessageListener dyI = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.ayD();
            }
        }
    };
    private d.a dyJ = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.J(cVar.ayL())) {
                if (StringUtils.isNull(b.this.dyD)) {
                    b.this.ayD();
                    return;
                } else {
                    b.this.ayA();
                    return;
                }
            }
            b.this.deX = cVar.ayL();
            b.this.setDatas(b.this.deX);
        }
    };
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dyA = new c(tbPageContext);
        ayB();
        this.dyB = new d(tbPageContext, tbPageContext.getUniqueId());
        this.dyB.a(this.dyJ);
        this.deX = new ArrayList<>();
        this.dyC = new a(tbPageContext, this.dyA.mListView);
        this.dyC.p(this.dyF);
        ayD();
        tbPageContext.registerListener(this.dyI);
        tbPageContext.registerListener(this.dyH);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.dyG, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.dyE = originalThreadInfo;
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
    public void bw(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.dyE);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c ayz() {
        return this.dyA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayA() {
        this.deX.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.dyS);
        this.deX.add(aVar);
        setDatas(this.deX);
    }

    public void setDatas(ArrayList<h> arrayList) {
        this.deX = arrayList;
        this.dyA.mListView.setData(arrayList);
    }

    private void ayB() {
        this.dyA.aix.setOnClickListener(this);
        this.dyA.dyM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.ayC();
                    return true;
                }
                return false;
            }
        });
        this.dyA.dyM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.ayC();
            }
        });
        this.dyA.dyM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.ayC();
                }
            }
        });
        this.dyA.dyM.setOnClickListener(this);
        this.dyA.dyN.setOnClickListener(this);
        this.dyA.cpf.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayC() {
        if (this.dyA.dyM.getText() == null || StringUtils.isNull(this.dyA.dyM.getText().toString())) {
            this.dyA.dyN.setVisibility(8);
            this.dyD = null;
            ayD();
            return;
        }
        h hVar = (h) v.d(this.deX, 0);
        if (hVar != null && hVar.getType() == com.baidu.tieba.forumsearch.b.a.dyR) {
            this.deX.clear();
            setDatas(this.deX);
        }
        this.dyA.dyN.setVisibility(0);
        this.dyD = this.dyA.dyM.getText().toString();
        this.dyB.nv(this.dyD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayD() {
        this.dyB.cancelMessage();
        this.deX.clear();
        ArrayList<String> ayF = e.ayF();
        if (!v.J(ayF)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.dyR);
            this.deX.add(aVar);
            this.deX.add(new com.baidu.tieba.forumsearch.b.a(ayF));
            setDatas(this.deX);
            return;
        }
        this.deX.clear();
        setDatas(this.deX);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.dyG);
        MessageManager.getInstance().unRegisterListener(this.dyI);
        MessageManager.getInstance().unRegisterListener(this.dyH);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dyA.dyM) {
            ayC();
        } else if (view == this.dyA.cpf) {
            l.a(this.mPageContext.getPageActivity(), this.dyA.dyM);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.dyA.dyN) {
            this.dyA.dyM.setText("");
        } else if (view == this.dyA.aix) {
            setDatas(this.deX);
        }
    }
}
