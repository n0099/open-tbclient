package com.baidu.tbadk.widget.richText;

import android.view.View;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView akJ;
    private final /* synthetic */ c akK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, c cVar) {
        this.akJ = tbRichTextView;
        this.akK = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.akJ.getContext() instanceof j) && this.akK.Af() != null) {
            ((j) this.akJ.getContext()).onVideoClicked(this.akJ.getContext(), this.akK.Af().toString());
        }
    }
}
