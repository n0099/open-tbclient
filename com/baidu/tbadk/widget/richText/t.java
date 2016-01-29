package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aGA;
    private final /* synthetic */ c aGC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TbRichTextView tbRichTextView, c cVar) {
        this.aGA = tbRichTextView;
        this.aGC = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aGC.GY() != null) {
            if (this.aGA.getContext() instanceof l) {
                ((l) this.aGA.getContext()).J(this.aGA.getContext(), this.aGC.GY().toString());
                return;
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.aGA.getContext());
            if (C != null && (C.getOrignalPage() instanceof l)) {
                ((l) C.getOrignalPage()).J(this.aGA.getContext(), this.aGC.GY().toString());
            }
        }
    }
}
