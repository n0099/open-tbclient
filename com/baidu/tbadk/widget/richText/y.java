package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aKi;
    private final /* synthetic */ c aKj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TbRichTextView tbRichTextView, c cVar) {
        this.aKi = tbRichTextView;
        this.aKj = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aKj.Ig() != null) {
            if (this.aKi.getContext() instanceof m) {
                ((m) this.aKi.getContext()).C(this.aKi.getContext(), this.aKj.Ig().toString());
                return;
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.aKi.getContext());
            if (C != null && (C.getOrignalPage() instanceof m)) {
                ((m) C.getOrignalPage()).C(this.aKi.getContext(), this.aKj.Ig().toString());
            }
        }
    }
}
