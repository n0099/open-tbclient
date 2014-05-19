package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u a;
    private final /* synthetic */ z b;
    private final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, z zVar, a aVar) {
        this.a = uVar;
        this.b = zVar;
        this.c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t tVar;
        n nVar;
        t tVar2;
        n nVar2;
        t tVar3;
        n nVar3;
        LinearLayout linearLayout;
        t tVar4;
        n nVar4;
        TextView textView;
        t tVar5;
        n nVar5;
        t tVar6;
        n nVar6;
        tVar = this.a.a;
        nVar = tVar.a;
        w wVar = nVar.a;
        tVar2 = this.a.a;
        nVar2 = tVar2.a;
        wVar.b(nVar2, this.b.getUri());
        this.c.setIsSelected(false);
        tVar3 = this.a.a;
        nVar3 = tVar3.a;
        linearLayout = nVar3.m;
        linearLayout.removeView(view);
        tVar4 = this.a.a;
        nVar4 = tVar4.a;
        textView = nVar4.o;
        tVar5 = this.a.a;
        nVar5 = tVar5.a;
        w wVar2 = nVar5.a;
        tVar6 = this.a.a;
        nVar6 = tVar6.a;
        textView.setText(wVar2.e(nVar6));
    }
}
