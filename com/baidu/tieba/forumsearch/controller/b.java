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
    private ArrayList<h> dgc;
    private final c dzR;
    private final d dzS;
    private final a dzT;
    private String dzU;
    private OriginalThreadInfo dzV;
    private int mFrom;
    private long mLiveId;
    private TbPageContext mPageContext;
    private View.OnClickListener dzW = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
    private Runnable dzX = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.c(b.this.mPageContext.getPageActivity(), b.this.dzR.dAd);
        }
    };
    private CustomMessageListener dzY = new CustomMessageListener(2921021) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.dzR.dAd.setText(str);
                b.this.dzR.dAd.setSelection(str.length());
                b.this.axZ();
            }
        }
    };
    private CustomMessageListener dzZ = new CustomMessageListener(2921020) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.aya();
            }
        }
    };
    private d.a dAa = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.I(cVar.ayi())) {
                if (StringUtils.isNull(b.this.dzU)) {
                    b.this.aya();
                    return;
                } else {
                    b.this.axX();
                    return;
                }
            }
            b.this.dgc = cVar.ayi();
            b.this.setDatas(b.this.dgc);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dzR = new c(tbPageContext);
        axY();
        this.dzS = new d(tbPageContext, tbPageContext.getUniqueId());
        this.dzS.a(this.dAa);
        this.dgc = new ArrayList<>();
        this.dzT = new a(tbPageContext, this.dzR.mListView);
        this.dzT.r(this.dzW);
        aya();
        tbPageContext.registerListener(this.dzZ);
        tbPageContext.registerListener(this.dzY);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.dzX, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.mLiveId = j;
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        this.dzV = originalThreadInfo;
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
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.dzV);
        transmitPostEditActivityConfig.setCallFrom("2");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    public c axW() {
        return this.dzR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axX() {
        this.dgc.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.setType(com.baidu.tieba.forumsearch.b.a.dAj);
        this.dgc.add(aVar);
        setDatas(this.dgc);
    }

    public void setDatas(ArrayList<h> arrayList) {
        this.dgc = arrayList;
        this.dzR.mListView.setData(arrayList);
    }

    private void axY() {
        this.dzR.ajk.setOnClickListener(this);
        this.dzR.dAd.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.axZ();
                    return true;
                }
                return false;
            }
        });
        this.dzR.dAd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.axZ();
            }
        });
        this.dzR.dAd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.axZ();
                }
            }
        });
        this.dzR.dAd.setOnClickListener(this);
        this.dzR.dAe.setOnClickListener(this);
        this.dzR.mCancel.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axZ() {
        if (this.dzR.dAd.getText() == null || StringUtils.isNull(this.dzR.dAd.getText().toString())) {
            this.dzR.dAe.setVisibility(8);
            this.dzU = null;
            aya();
            return;
        }
        h hVar = (h) v.d(this.dgc, 0);
        if (hVar != null && hVar.getType() == com.baidu.tieba.forumsearch.b.a.dAi) {
            this.dgc.clear();
            setDatas(this.dgc);
        }
        this.dzR.dAe.setVisibility(0);
        this.dzU = this.dzR.dAd.getText().toString();
        this.dzS.nw(this.dzU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aya() {
        this.dzS.cancelMessage();
        this.dgc.clear();
        ArrayList<String> ayc = e.ayc();
        if (!v.I(ayc)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.setType(com.baidu.tieba.forumsearch.b.a.dAi);
            this.dgc.add(aVar);
            this.dgc.add(new com.baidu.tieba.forumsearch.b.a(ayc));
            setDatas(this.dgc);
            return;
        }
        this.dgc.clear();
        setDatas(this.dgc);
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dzX);
        MessageManager.getInstance().unRegisterListener(this.dzZ);
        MessageManager.getInstance().unRegisterListener(this.dzY);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dzR.dAd) {
            axZ();
        } else if (view == this.dzR.mCancel) {
            l.b(this.mPageContext.getPageActivity(), this.dzR.dAd);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.dzR.dAe) {
            this.dzR.dAd.setText("");
        } else if (view == this.dzR.ajk) {
            setDatas(this.dgc);
        }
    }
}
