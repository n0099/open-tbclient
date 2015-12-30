package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aFI;
    private final /* synthetic */ c aFK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TbRichTextView tbRichTextView, c cVar) {
        this.aFI = tbRichTextView;
        this.aFK = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aFK.FG() != null) {
            if (this.aFI.getContext() instanceof l) {
                ((l) this.aFI.getContext()).onVideoClicked(this.aFI.getContext(), this.aFK.FG().toString());
                return;
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.aFI.getContext());
            if (C != null && (C.getOrignalPage() instanceof l)) {
                ((l) C.getOrignalPage()).onVideoClicked(this.aFI.getContext(), this.aFK.FG().toString());
            }
        }
    }
}
