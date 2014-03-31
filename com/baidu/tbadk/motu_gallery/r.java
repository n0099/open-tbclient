package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r implements View.OnClickListener {
    final /* synthetic */ n a;
    private final /* synthetic */ y b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar, y yVar) {
        this.a = nVar;
        this.b = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        n.a(this.a, this.b.getUri());
    }
}
