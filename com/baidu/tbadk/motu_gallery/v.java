package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
final class v implements View.OnClickListener {
    final /* synthetic */ u a;
    private final /* synthetic */ y b;
    private final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, y yVar, a aVar) {
        this.a = uVar;
        this.b = yVar;
        this.c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        n nVar;
        n nVar2;
        n nVar3;
        LinearLayout linearLayout;
        n nVar4;
        TextView textView;
        n nVar5;
        n nVar6;
        nVar = this.a.a.a;
        w wVar = nVar.a;
        nVar2 = this.a.a.a;
        wVar.b(nVar2, this.b.getUri());
        this.c.setIsSelected(false);
        nVar3 = this.a.a.a;
        linearLayout = nVar3.m;
        linearLayout.removeView(view);
        nVar4 = this.a.a.a;
        textView = nVar4.o;
        nVar5 = this.a.a.a;
        w wVar2 = nVar5.a;
        nVar6 = this.a.a.a;
        textView.setText(wVar2.c(nVar6));
    }
}
