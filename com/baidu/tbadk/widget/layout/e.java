package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aHs;
    private final /* synthetic */ int aHt;
    private final /* synthetic */ boolean aHu;
    private final /* synthetic */ boolean aHv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aHs = cVar;
        this.aHt = i;
        this.aHu = z;
        this.aHv = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        hVar = this.aHs.aHh;
        if (hVar != null) {
            hVar2 = this.aHs.aHh;
            hVar2.c(view, this.aHt, this.aHu && this.aHv);
        }
    }
}
