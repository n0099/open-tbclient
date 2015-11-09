package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aBw;
    private final /* synthetic */ c aBy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TbRichTextView tbRichTextView, c cVar) {
        this.aBw = tbRichTextView;
        this.aBy = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aBy.EO() != null) {
            if (this.aBw.getContext() instanceof l) {
                ((l) this.aBw.getContext()).onVideoClicked(this.aBw.getContext(), this.aBy.EO().toString());
                return;
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.aBw.getContext());
            if (C != null && (C.getOrignalPage() instanceof l)) {
                ((l) C.getOrignalPage()).onVideoClicked(this.aBw.getContext(), this.aBy.EO().toString());
            }
        }
    }
}
