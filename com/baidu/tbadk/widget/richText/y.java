package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aFD;
    private final /* synthetic */ c aFE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TbRichTextView tbRichTextView, c cVar) {
        this.aFD = tbRichTextView;
        this.aFE = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aFE.GI() != null) {
            if (this.aFD.getContext() instanceof m) {
                ((m) this.aFD.getContext()).B(this.aFD.getContext(), this.aFE.GI().toString());
                return;
            }
            com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(this.aFD.getContext());
            if (s != null && (s.getOrignalPage() instanceof m)) {
                ((m) s.getOrignalPage()).B(this.aFD.getContext(), this.aFE.GI().toString());
            }
        }
    }
}
