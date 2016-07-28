package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aDW;
    private final /* synthetic */ int aDX;
    private final /* synthetic */ boolean aDY;
    private final /* synthetic */ boolean aDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aDW = cVar;
        this.aDX = i;
        this.aDY = z;
        this.aDZ = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        hVar = this.aDW.aDL;
        if (hVar != null) {
            hVar2 = this.aDW.aDL;
            hVar2.c(view, this.aDX, this.aDY && this.aDZ);
        }
    }
}
