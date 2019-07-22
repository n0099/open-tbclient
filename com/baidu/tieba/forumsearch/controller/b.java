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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.forumsearch.controller.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    private ArrayList<m> eUx;
    private final c frV;
    private final d frW;
    private final a frX;
    private String frY;
    private OriginalThreadInfo frZ;
    private String fsa;
    private String fsb;
    private String fsc;
    private View.OnClickListener fsd = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.e(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.cW(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    TiebaStatic.log(new an("c12609").l("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.cV(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable fse = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.frV.fsk);
        }
    };
    private CustomMessageListener fsf = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.frV.fsk.setText(str);
                b.this.frV.fsk.setSelection(str.length());
                b.this.bkN();
            }
        }
    };
    private CustomMessageListener fsg = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bkO();
            }
        }
    };
    private d.a fsh = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.aa(cVar.bkW())) {
                if (StringUtils.isNull(b.this.frY)) {
                    b.this.bkO();
                    return;
                } else {
                    b.this.bkL();
                    return;
                }
            }
            b.this.eUx = cVar.bkW();
            b.this.setDatas(b.this.eUx);
        }
    };
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.frV = new c(tbPageContext);
        bkM();
        this.frW = new d(tbPageContext, tbPageContext.getUniqueId());
        this.frW.a(this.fsh);
        this.eUx = new ArrayList<>();
        this.frX = new a(tbPageContext, this.frV.mListView);
        this.frX.u(this.fsd);
        bkO();
        tbPageContext.registerListener(this.fsg);
        tbPageContext.registerListener(this.fsf);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.fse, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.frZ = originalThreadInfo;
    }

    public void setMoreForumImg(String str) {
        this.fsb = str;
    }

    public void setMoreForumTitle(String str) {
        this.fsc = str;
    }

    public void setMoreForumUrl(String str) {
        this.fsa = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.fsb);
        writeActivityConfig.setMoreForumUrl(this.fsa);
        writeActivityConfig.setMoreForumTitle(this.fsc);
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
    public void cW(String str, String str2) {
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.frZ);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c bkK() {
        return this.frV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkL() {
        this.eUx.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.fsp);
        this.eUx.add(aVar);
        setDatas(this.eUx);
    }

    public void setDatas(ArrayList<m> arrayList) {
        this.eUx = arrayList;
        this.frV.mListView.setData(arrayList);
    }

    private void bkM() {
        this.frV.mRoot.setOnClickListener(this);
        this.frV.fsk.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bkN();
                    return true;
                }
                return false;
            }
        });
        this.frV.fsk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bkN();
            }
        });
        this.frV.fsk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bkN();
                }
            }
        });
        this.frV.fsk.setOnClickListener(this);
        this.frV.evy.setOnClickListener(this);
        this.frV.bpI.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkN() {
        if (this.frV.fsk.getText() == null || StringUtils.isNull(this.frV.fsk.getText().toString())) {
            this.frV.evy.setVisibility(8);
            this.frY = null;
            bkO();
            return;
        }
        m mVar = (m) v.c(this.eUx, 0);
        if (mVar != null && mVar.getType() == com.baidu.tieba.forumsearch.b.a.fso) {
            this.eUx.clear();
            setDatas(this.eUx);
        }
        this.frV.evy.setVisibility(0);
        this.frY = this.frV.fsk.getText().toString();
        this.frW.wQ(this.frY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkO() {
        this.frW.cancelMessage();
        this.eUx.clear();
        ArrayList<String> bkQ = e.bkQ();
        if (!v.aa(bkQ)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.fso);
            this.eUx.add(aVar);
            this.eUx.add(new com.baidu.tieba.forumsearch.b.a(bkQ));
            setDatas(this.eUx);
            return;
        }
        this.eUx.clear();
        setDatas(this.eUx);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fse);
        MessageManager.getInstance().unRegisterListener(this.fsg);
        MessageManager.getInstance().unRegisterListener(this.fsf);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.frV.fsk) {
            bkN();
        } else if (view == this.frV.bpI) {
            l.b(this.mPageContext.getPageActivity(), this.frV.fsk);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.frV.evy) {
            this.frV.fsk.setText("");
        } else if (view == this.frV.mRoot) {
            setDatas(this.eUx);
        }
    }
}
