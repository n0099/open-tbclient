package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ n a;
    private final /* synthetic */ z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar, z zVar) {
        this.a = nVar;
        this.b = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a(this.b.getUri());
    }
}
