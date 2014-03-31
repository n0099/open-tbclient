package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, c cVar) {
        this.a = tbRichTextView;
        this.b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.a.C;
        if (qVar != null) {
            e f = this.b.f();
            qVar2 = this.a.C;
            qVar2.a(view, f.e, f.h, f.i, f.a, f.b, f.c, f.f, f.g);
        }
    }
}
