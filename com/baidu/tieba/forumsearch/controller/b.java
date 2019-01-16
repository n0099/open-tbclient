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
    private final c dJN;
    private final d dJO;
    private final a dJP;
    private String dJQ;
    private OriginalThreadInfo dJR;
    private View.OnClickListener dJS = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.g(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.bC(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new am("c12609").i(ImageViewerConfig.FORUM_ID, bVar.getForumId()));
                } else if (b.this.mFrom == 3) {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable dJT = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.dJN.dJZ);
        }
    };
    private CustomMessageListener dJU = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.dJN.dJZ.setText(str);
                b.this.dJN.dJZ.setSelection(str.length());
                b.this.aAV();
            }
        }
    };
    private CustomMessageListener dJV = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.aAW();
            }
        }
    };
    private d.a dJW = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.I(cVar.aBe())) {
                if (StringUtils.isNull(b.this.dJQ)) {
                    b.this.aAW();
                    return;
                } else {
                    b.this.aAT();
                    return;
                }
            }
            b.this.dqn = cVar.aBe();
            b.this.setDatas(b.this.dqn);
        }
    };
    private ArrayList<h> dqn;
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dJN = new c(tbPageContext);
        aAU();
        this.dJO = new d(tbPageContext, tbPageContext.getUniqueId());
        this.dJO.a(this.dJW);
        this.dqn = new ArrayList<>();
        this.dJP = new a(tbPageContext, this.dJN.mListView);
        this.dJP.r(this.dJS);
        aAW();
        tbPageContext.registerListener(this.dJV);
        tbPageContext.registerListener(this.dJU);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.dJT, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.dJR = originalThreadInfo;
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
    public void bC(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.dJR);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c aAS() {
        return this.dJN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAT() {
        this.dqn.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.dKf);
        this.dqn.add(aVar);
        setDatas(this.dqn);
    }

    public void setDatas(ArrayList<h> arrayList) {
        this.dqn = arrayList;
        this.dJN.mListView.setData(arrayList);
    }

    private void aAU() {
        this.dJN.ano.setOnClickListener(this);
        this.dJN.dJZ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.aAV();
                    return true;
                }
                return false;
            }
        });
        this.dJN.dJZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.aAV();
            }
        });
        this.dJN.dJZ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.aAV();
                }
            }
        });
        this.dJN.dJZ.setOnClickListener(this);
        this.dJN.dKa.setOnClickListener(this);
        this.dJN.mCancel.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAV() {
        if (this.dJN.dJZ.getText() == null || StringUtils.isNull(this.dJN.dJZ.getText().toString())) {
            this.dJN.dKa.setVisibility(8);
            this.dJQ = null;
            aAW();
            return;
        }
        h hVar = (h) v.d(this.dqn, 0);
        if (hVar != null && hVar.getType() == com.baidu.tieba.forumsearch.b.a.dKe) {
            this.dqn.clear();
            setDatas(this.dqn);
        }
        this.dJN.dKa.setVisibility(0);
        this.dJQ = this.dJN.dJZ.getText().toString();
        this.dJO.oq(this.dJQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAW() {
        this.dJO.cancelMessage();
        this.dqn.clear();
        ArrayList<String> aAY = e.aAY();
        if (!v.I(aAY)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.dKe);
            this.dqn.add(aVar);
            this.dqn.add(new com.baidu.tieba.forumsearch.b.a(aAY));
            setDatas(this.dqn);
            return;
        }
        this.dqn.clear();
        setDatas(this.dqn);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dJT);
        MessageManager.getInstance().unRegisterListener(this.dJV);
        MessageManager.getInstance().unRegisterListener(this.dJU);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dJN.dJZ) {
            aAV();
        } else if (view == this.dJN.mCancel) {
            l.b(this.mPageContext.getPageActivity(), this.dJN.dJZ);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.dJN.dKa) {
            this.dJN.dJZ.setText("");
        } else if (view == this.dJN.ano) {
            setDatas(this.dqn);
        }
    }
}
