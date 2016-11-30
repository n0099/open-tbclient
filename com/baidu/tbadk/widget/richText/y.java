package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aKA;
    private final /* synthetic */ c aKB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TbRichTextView tbRichTextView, c cVar) {
        this.aKA = tbRichTextView;
        this.aKB = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aKB.Ii() != null) {
            if (this.aKA.getContext() instanceof m) {
                ((m) this.aKA.getContext()).C(this.aKA.getContext(), this.aKB.Ii().toString());
                return;
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.aKA.getContext());
            if (C != null && (C.getOrignalPage() instanceof m)) {
                ((m) C.getOrignalPage()).C(this.aKA.getContext(), this.aKB.Ii().toString());
            }
        }
    }
}
