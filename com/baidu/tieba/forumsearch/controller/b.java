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
    private ArrayList<m> ePw;
    private final c fmV;
    private final d fmW;
    private final a fmX;
    private String fmY;
    private OriginalThreadInfo fmZ;
    private String fna;
    private String fnb;
    private String fnc;
    private View.OnClickListener fnd = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
    private Runnable fne = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.fmV.fnk);
        }
    };
    private CustomMessageListener fnf = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.fmV.fnk.setText(str);
                b.this.fmV.fnk.setSelection(str.length());
                b.this.biI();
            }
        }
    };
    private CustomMessageListener fng = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.biJ();
            }
        }
    };
    private d.a fnh = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.aa(cVar.biR())) {
                if (StringUtils.isNull(b.this.fmY)) {
                    b.this.biJ();
                    return;
                } else {
                    b.this.biG();
                    return;
                }
            }
            b.this.ePw = cVar.biR();
            b.this.setDatas(b.this.ePw);
        }
    };
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fmV = new c(tbPageContext);
        biH();
        this.fmW = new d(tbPageContext, tbPageContext.getUniqueId());
        this.fmW.a(this.fnh);
        this.ePw = new ArrayList<>();
        this.fmX = new a(tbPageContext, this.fmV.mListView);
        this.fmX.u(this.fnd);
        biJ();
        tbPageContext.registerListener(this.fng);
        tbPageContext.registerListener(this.fnf);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.fne, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.fmZ = originalThreadInfo;
    }

    public void setMoreForumImg(String str) {
        this.fnb = str;
    }

    public void setMoreForumTitle(String str) {
        this.fnc = str;
    }

    public void setMoreForumUrl(String str) {
        this.fna = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.fnb);
        writeActivityConfig.setMoreForumUrl(this.fna);
        writeActivityConfig.setMoreForumTitle(this.fnc);
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
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.fmZ);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c biF() {
        return this.fmV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biG() {
        this.ePw.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.fnp);
        this.ePw.add(aVar);
        setDatas(this.ePw);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.ePw = arrayList;
        this.fmV.mListView.setData(arrayList);
    }

    private void biH() {
        this.fmV.bBg.setOnClickListener(this);
        this.fmV.fnk.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.biI();
                    return true;
                }
                return false;
            }
        });
        this.fmV.fnk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.biI();
            }
        });
        this.fmV.fnk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.biI();
                }
            }
        });
        this.fmV.fnk.setOnClickListener(this);
        this.fmV.eqz.setOnClickListener(this);
        this.fmV.boV.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biI() {
        if (this.fmV.fnk.getText() == null || StringUtils.isNull(this.fmV.fnk.getText().toString())) {
            this.fmV.eqz.setVisibility(8);
            this.fmY = null;
            biJ();
            return;
        }
        m mVar = (m) v.c(this.ePw, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.fno) {
            this.ePw.clear();
            setDatas(this.ePw);
        }
        this.fmV.eqz.setVisibility(0);
        this.fmY = this.fmV.fnk.getText().toString();
        this.fmW.wm(this.fmY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biJ() {
        this.fmW.cancelMessage();
        this.ePw.clear();
        ArrayList<String> biL = e.biL();
        if (!v.aa(biL)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.fno);
            this.ePw.add(aVar);
            this.ePw.add(new com.baidu.tieba.forumsearch.b.a(biL));
            setDatas(this.ePw);
            return;
        }
        this.ePw.clear();
        setDatas(this.ePw);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fne);
        MessageManager.getInstance().unRegisterListener(this.fng);
        MessageManager.getInstance().unRegisterListener(this.fnf);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fmV.fnk) {
            biI();
        } else if (view == this.fmV.boV) {
            l.b(this.mPageContext.getPageActivity(), this.fmV.fnk);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.fmV.eqz) {
            this.fmV.fnk.setText("");
        } else if (view == this.fmV.bBg) {
            setDatas(this.ePw);
        }
    }
}
