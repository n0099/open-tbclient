package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aGf;
    private final /* synthetic */ c aGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TbRichTextView tbRichTextView, c cVar) {
        this.aGf = tbRichTextView;
        this.aGg = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aGg.GL() != null) {
            if (this.aGf.getContext() instanceof m) {
                ((m) this.aGf.getContext()).C(this.aGf.getContext(), this.aGg.GL().toString());
                return;
            }
            com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(this.aGf.getContext());
            if (s != null && (s.getOrignalPage() instanceof m)) {
                ((m) s.getOrignalPage()).C(this.aGf.getContext(), this.aGg.GL().toString());
            }
        }
    }
}
