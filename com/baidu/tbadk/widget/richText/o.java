package com.baidu.tbadk.widget.richText;

import android.view.View;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView atj;
    private final /* synthetic */ c atk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, c cVar) {
        this.atj = tbRichTextView;
        this.atk = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.atj.getContext() instanceof j) && this.atk.DB() != null) {
            ((j) this.atj.getContext()).onVideoClicked(this.atj.getContext(), this.atk.DB().toString());
        }
    }
}
