package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aCC;
    private final /* synthetic */ c aCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.aCC = tbRichTextView;
        this.aCE = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aCE.EV() != null) {
            if (this.aCC.getContext() instanceof i) {
                ((i) this.aCC.getContext()).onVideoClicked(this.aCC.getContext(), this.aCE.EV().toString());
                return;
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.aCC.getContext());
            if (C != null && (C.getOrignalPage() instanceof i)) {
                ((i) C.getOrignalPage()).onVideoClicked(this.aCC.getContext(), this.aCE.EV().toString());
            }
        }
    }
}
