package com.baidu.tbadk.widget.richText;

import android.view.View;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView atr;
    private final /* synthetic */ c ats;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, c cVar) {
        this.atr = tbRichTextView;
        this.ats = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.atr.getContext() instanceof j) && this.ats.DH() != null) {
            ((j) this.atr.getContext()).onVideoClicked(this.atr.getContext(), this.ats.DH().toString());
        }
    }
}
