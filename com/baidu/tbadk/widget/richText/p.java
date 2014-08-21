package com.baidu.tbadk.widget.richText;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView, c cVar) {
        this.a = tbRichTextView;
        this.b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        rVar = this.a.D;
        if (rVar != null) {
            e g = this.b.g();
            rVar2 = this.a.D;
            rVar2.a(view, g.b.e, g.b.h, g.b.i, g.b.c, g.b.d, g.b.b, g.b.f, g.b.g);
        }
    }
}
