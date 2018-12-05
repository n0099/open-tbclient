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
    private final c dGq;
    private final d dGr;
    private final a dGs;
    private String dGt;
    private OriginalThreadInfo dGu;
    private View.OnClickListener dGv = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.g(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.bB(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new am("c12609").i(ImageViewerConfig.FORUM_ID, bVar.getForumId()));
                } else if (b.this.mFrom == 3) {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable dGw = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.dGq.dGC);
        }
    };
    private CustomMessageListener dGx = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.dGq.dGC.setText(str);
                b.this.dGq.dGC.setSelection(str.length());
                b.this.azJ();
            }
        }
    };
    private CustomMessageListener dGy = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.azK();
            }
        }
    };
    private d.a dGz = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.I(cVar.azS())) {
                if (StringUtils.isNull(b.this.dGt)) {
                    b.this.azK();
                    return;
                } else {
                    b.this.azH();
                    return;
                }
            }
            b.this.dmJ = cVar.azS();
            b.this.setDatas(b.this.dmJ);
        }
    };
    private ArrayList<h> dmJ;
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dGq = new c(tbPageContext);
        azI();
        this.dGr = new d(tbPageContext, tbPageContext.getUniqueId());
        this.dGr.a(this.dGz);
        this.dmJ = new ArrayList<>();
        this.dGs = new a(tbPageContext, this.dGq.mListView);
        this.dGs.r(this.dGv);
        azK();
        tbPageContext.registerListener(this.dGy);
        tbPageContext.registerListener(this.dGx);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.dGw, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.dGu = originalThreadInfo;
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
    public void bB(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.dGu);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c azG() {
        return this.dGq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azH() {
        this.dmJ.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.dGI);
        this.dmJ.add(aVar);
        setDatas(this.dmJ);
    }

    public void setDatas(ArrayList<h> arrayList) {
        this.dmJ = arrayList;
        this.dGq.mListView.setData(arrayList);
    }

    private void azI() {
        this.dGq.amM.setOnClickListener(this);
        this.dGq.dGC.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.azJ();
                    return true;
                }
                return false;
            }
        });
        this.dGq.dGC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.azJ();
            }
        });
        this.dGq.dGC.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.azJ();
                }
            }
        });
        this.dGq.dGC.setOnClickListener(this);
        this.dGq.dGD.setOnClickListener(this);
        this.dGq.mCancel.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azJ() {
        if (this.dGq.dGC.getText() == null || StringUtils.isNull(this.dGq.dGC.getText().toString())) {
            this.dGq.dGD.setVisibility(8);
            this.dGt = null;
            azK();
            return;
        }
        h hVar = (h) v.d(this.dmJ, 0);
        if (hVar != null && hVar.getType() == com.baidu.tieba.forumsearch.b.a.dGH) {
            this.dmJ.clear();
            setDatas(this.dmJ);
        }
        this.dGq.dGD.setVisibility(0);
        this.dGt = this.dGq.dGC.getText().toString();
        this.dGr.nV(this.dGt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azK() {
        this.dGr.cancelMessage();
        this.dmJ.clear();
        ArrayList<String> azM = e.azM();
        if (!v.I(azM)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.dGH);
            this.dmJ.add(aVar);
            this.dmJ.add(new com.baidu.tieba.forumsearch.b.a(azM));
            setDatas(this.dmJ);
            return;
        }
        this.dmJ.clear();
        setDatas(this.dmJ);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dGw);
        MessageManager.getInstance().unRegisterListener(this.dGy);
        MessageManager.getInstance().unRegisterListener(this.dGx);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dGq.dGC) {
            azJ();
        } else if (view == this.dGq.mCancel) {
            l.b(this.mPageContext.getPageActivity(), this.dGq.dGC);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.dGq.dGD) {
            this.dGq.dGC.setText("");
        } else if (view == this.dGq.amM) {
            setDatas(this.dmJ);
        }
    }
}
