package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aCn;
    private final /* synthetic */ c aCp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.aCn = tbRichTextView;
        this.aCp = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aCp.Fc() != null) {
            if (this.aCn.getContext() instanceof i) {
                ((i) this.aCn.getContext()).onVideoClicked(this.aCn.getContext(), this.aCp.Fc().toString());
                return;
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.aCn.getContext());
            if (C != null && (C.getOrignalPage() instanceof i)) {
                ((i) C.getOrignalPage()).onVideoClicked(this.aCn.getContext(), this.aCp.Fc().toString());
            }
        }
    }
}
