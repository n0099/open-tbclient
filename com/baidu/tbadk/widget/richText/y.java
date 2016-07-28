package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aGW;
    private final /* synthetic */ c aGX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TbRichTextView tbRichTextView, c cVar) {
        this.aGW = tbRichTextView;
        this.aGX = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aGX.GJ() != null) {
            if (this.aGW.getContext() instanceof m) {
                ((m) this.aGW.getContext()).C(this.aGW.getContext(), this.aGX.GJ().toString());
                return;
            }
            com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(this.aGW.getContext());
            if (s != null && (s.getOrignalPage() instanceof m)) {
                ((m) s.getOrignalPage()).C(this.aGW.getContext(), this.aGX.GJ().toString());
            }
        }
    }
}
