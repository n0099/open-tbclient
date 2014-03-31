package com.baidu.tbadk.widget.richText;

import android.view.View;
/* loaded from: classes.dex */
final class n implements View.OnClickListener {
    final /* synthetic */ TbRichTextView a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbRichTextView tbRichTextView, c cVar) {
        this.a = tbRichTextView;
        this.b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if ((this.a.getContext() instanceof j) && this.b.d() != null) {
            this.a.getContext();
            ((j) this.a.getContext()).b(this.b.d().toString());
        }
    }
}
