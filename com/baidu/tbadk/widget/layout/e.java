package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aDf;
    private final /* synthetic */ int aDg;
    private final /* synthetic */ boolean aDh;
    private final /* synthetic */ boolean aDi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aDf = cVar;
        this.aDg = i;
        this.aDh = z;
        this.aDi = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        hVar = this.aDf.aCU;
        if (hVar != null) {
            hVar2 = this.aDf.aCU;
            hVar2.c(view, this.aDg, this.aDh && this.aDi);
        }
    }
}
