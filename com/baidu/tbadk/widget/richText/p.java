package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aDV;
    private final /* synthetic */ c aDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.aDV = tbRichTextView;
        this.aDX = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aDX.Fm() != null) {
            if (this.aDV.getContext() instanceof i) {
                ((i) this.aDV.getContext()).onVideoClicked(this.aDV.getContext(), this.aDX.Fm().toString());
                return;
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.aDV.getContext());
            if (C != null && (C.getOrignalPage() instanceof i)) {
                ((i) C.getOrignalPage()).onVideoClicked(this.aDV.getContext(), this.aDX.Fm().toString());
            }
        }
    }
}
