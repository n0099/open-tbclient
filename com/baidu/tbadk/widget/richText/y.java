package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aJH;
    private final /* synthetic */ c aJI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TbRichTextView tbRichTextView, c cVar) {
        this.aJH = tbRichTextView;
        this.aJI = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aJI.If() != null) {
            if (this.aJH.getContext() instanceof m) {
                ((m) this.aJH.getContext()).C(this.aJH.getContext(), this.aJI.If().toString());
                return;
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.aJH.getContext());
            if (C != null && (C.getOrignalPage() instanceof m)) {
                ((m) C.getOrignalPage()).C(this.aJH.getContext(), this.aJI.If().toString());
            }
        }
    }
}
