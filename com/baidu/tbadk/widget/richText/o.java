package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ TbRichTextView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, c cVar) {
        this.b = tbRichTextView;
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.b.C;
        if (qVar != null) {
            e g = this.a.g();
            qVar2 = this.b.C;
            qVar2.a(view, g.e, g.h, g.i, g.a, g.b, g.c, g.f, g.g);
        }
    }
}
