package com.baidu.tbadk.widget.richText;

import android.view.View;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView auX;
    private final /* synthetic */ c auY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, c cVar) {
        this.auX = tbRichTextView;
        this.auY = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.auX.getContext() instanceof j) && this.auY.Es() != null) {
            ((j) this.auX.getContext()).onVideoClicked(this.auX.getContext(), this.auY.Es().toString());
        }
    }
}
