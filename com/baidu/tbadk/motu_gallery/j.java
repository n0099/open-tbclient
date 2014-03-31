package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
final class j implements View.OnClickListener {
    final /* synthetic */ d a;
    private final /* synthetic */ y b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar, y yVar) {
        this.a = dVar;
        this.b = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        w wVar;
        LinearLayout linearLayout;
        w wVar2;
        wVar = this.a.k;
        wVar.b(this.a, this.b.getUri());
        linearLayout = this.a.v;
        linearLayout.removeView(view);
        TextView textView = this.a.a;
        wVar2 = this.a.k;
        textView.setText(wVar2.c(this.a));
    }
}
