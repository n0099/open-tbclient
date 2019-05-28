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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.forumsearch.controller.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    private ArrayList<m> ePx;
    private final c fmW;
    private final d fmX;
    private final a fmY;
    private String fmZ;
    private OriginalThreadInfo fna;
    private String fnb;
    private String fnc;
    private String fnd;
    private View.OnClickListener fne = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.e(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.cV(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new am("c12609").l("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.cU(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable fnf = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.fmW.fnl);
        }
    };
    private CustomMessageListener fng = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.fmW.fnl.setText(str);
                b.this.fmW.fnl.setSelection(str.length());
                b.this.biL();
            }
        }
    };
    private CustomMessageListener fnh = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.biM();
            }
        }
    };
    private d.a fni = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.aa(cVar.biU())) {
                if (StringUtils.isNull(b.this.fmZ)) {
                    b.this.biM();
                    return;
                } else {
                    b.this.biJ();
                    return;
                }
            }
            b.this.ePx = cVar.biU();
            b.this.setDatas(b.this.ePx);
        }
    };
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fmW = new c(tbPageContext);
        biK();
        this.fmX = new d(tbPageContext, tbPageContext.getUniqueId());
        this.fmX.a(this.fni);
        this.ePx = new ArrayList<>();
        this.fmY = new a(tbPageContext, this.fmW.mListView);
        this.fmY.u(this.fne);
        biM();
        tbPageContext.registerListener(this.fnh);
        tbPageContext.registerListener(this.fng);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.fnf, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.fna = originalThreadInfo;
    }

    public void setMoreForumImg(String str) {
        this.fnc = str;
    }

    public void setMoreForumTitle(String str) {
        this.fnd = str;
    }

    public void setMoreForumUrl(String str) {
        this.fnb = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.fnc);
        writeActivityConfig.setMoreForumUrl(this.fnb);
        writeActivityConfig.setMoreForumTitle(this.fnd);
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
    public void cV(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.fna);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c biI() {
        return this.fmW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biJ() {
        this.ePx.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.fnq);
        this.ePx.add(aVar);
        setDatas(this.ePx);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.ePx = arrayList;
        this.fmW.mListView.setData(arrayList);
    }

    private void biK() {
        this.fmW.bBg.setOnClickListener(this);
        this.fmW.fnl.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.biL();
                    return true;
                }
                return false;
            }
        });
        this.fmW.fnl.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.biL();
            }
        });
        this.fmW.fnl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.biL();
                }
            }
        });
        this.fmW.fnl.setOnClickListener(this);
        this.fmW.eqA.setOnClickListener(this);
        this.fmW.boV.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biL() {
        if (this.fmW.fnl.getText() == null || StringUtils.isNull(this.fmW.fnl.getText().toString())) {
            this.fmW.eqA.setVisibility(8);
            this.fmZ = null;
            biM();
            return;
        }
        m mVar = (m) v.c(this.ePx, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.fnp) {
            this.ePx.clear();
            setDatas(this.ePx);
        }
        this.fmW.eqA.setVisibility(0);
        this.fmZ = this.fmW.fnl.getText().toString();
        this.fmX.wm(this.fmZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biM() {
        this.fmX.cancelMessage();
        this.ePx.clear();
        ArrayList<String> biO = e.biO();
        if (!v.aa(biO)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.fnp);
            this.ePx.add(aVar);
            this.ePx.add(new com.baidu.tieba.forumsearch.b.a(biO));
            setDatas(this.ePx);
            return;
        }
        this.ePx.clear();
        setDatas(this.ePx);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fnf);
        MessageManager.getInstance().unRegisterListener(this.fnh);
        MessageManager.getInstance().unRegisterListener(this.fng);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fmW.fnl) {
            biL();
        } else if (view == this.fmW.boV) {
            l.b(this.mPageContext.getPageActivity(), this.fmW.fnl);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.fmW.eqA) {
            this.fmW.fnl.setText("");
        } else if (view == this.fmW.bBg) {
            setDatas(this.ePx);
        }
    }
}
