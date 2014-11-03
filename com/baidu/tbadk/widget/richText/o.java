package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView acw;
    private final /* synthetic */ c acx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, c cVar) {
        this.acw = tbRichTextView;
        this.acx = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.acw.getContext() instanceof j) && this.acx.vG() != null) {
            ((j) this.acw.getContext()).u(this.acw.getContext(), this.acx.vG().toString());
        }
    }
}
