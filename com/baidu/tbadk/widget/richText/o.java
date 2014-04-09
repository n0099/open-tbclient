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
            e g = this.b.g();
            qVar2 = this.a.C;
            qVar2.a(view, g.e, g.h, g.i, g.a, g.b, g.c, g.f, g.g);
        }
    }
}
