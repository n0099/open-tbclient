package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ TbRichTextView a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbRichTextView tbRichTextView, c cVar) {
        this.a = tbRichTextView;
        this.b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.a.getContext() instanceof j) && this.b.d() != null) {
            ((j) this.a.getContext()).c(this.a.getContext(), this.b.d().toString());
        }
    }
}
