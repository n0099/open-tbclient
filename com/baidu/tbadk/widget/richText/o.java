package com.baidu.tbadk.widget.richText;

import android.view.View;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aki;
    private final /* synthetic */ c akj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, c cVar) {
        this.aki = tbRichTextView;
        this.akj = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.aki.getContext() instanceof j) && this.akj.zR() != null) {
            ((j) this.aki.getContext()).onVideoClicked(this.aki.getContext(), this.akj.zR().toString());
        }
    }
}
