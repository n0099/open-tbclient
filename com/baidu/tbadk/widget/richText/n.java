package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ TbRichTextView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbRichTextView tbRichTextView, c cVar) {
        this.b = tbRichTextView;
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.b.getContext() instanceof j) && this.a.d() != null) {
            ((j) this.b.getContext()).c(this.b.getContext(), this.a.d().toString());
        }
    }
}
