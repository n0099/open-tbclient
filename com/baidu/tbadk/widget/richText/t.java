package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aEi;
    private final /* synthetic */ c aEk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TbRichTextView tbRichTextView, c cVar) {
        this.aEi = tbRichTextView;
        this.aEk = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aEk.FR() != null) {
            if (this.aEi.getContext() instanceof l) {
                ((l) this.aEi.getContext()).onVideoClicked(this.aEi.getContext(), this.aEk.FR().toString());
                return;
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.aEi.getContext());
            if (C != null && (C.getOrignalPage() instanceof l)) {
                ((l) C.getOrignalPage()).onVideoClicked(this.aEi.getContext(), this.aEk.FR().toString());
            }
        }
    }
}
