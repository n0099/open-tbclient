package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aJR;
    private final /* synthetic */ c aJS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbRichTextView tbRichTextView, c cVar) {
        this.aJR = tbRichTextView;
        this.aJS = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aJS.HE() != null) {
            if (this.aJR.getContext() instanceof m) {
                ((m) this.aJR.getContext()).C(this.aJR.getContext(), this.aJS.HE().toString());
                return;
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.aJR.getContext());
            if (C != null && (C.getOrignalPage() instanceof m)) {
                ((m) C.getOrignalPage()).C(this.aJR.getContext(), this.aJS.HE().toString());
            }
        }
    }
}
