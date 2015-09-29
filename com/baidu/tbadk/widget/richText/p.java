package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aCr;
    private final /* synthetic */ c aCt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.aCr = tbRichTextView;
        this.aCt = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aCt.EZ() != null) {
            if (this.aCr.getContext() instanceof i) {
                ((i) this.aCr.getContext()).onVideoClicked(this.aCr.getContext(), this.aCt.EZ().toString());
                return;
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.aCr.getContext());
            if (C != null && (C.getOrignalPage() instanceof i)) {
                ((i) C.getOrignalPage()).onVideoClicked(this.aCr.getContext(), this.aCt.EZ().toString());
            }
        }
    }
}
