package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aLs;
    private final /* synthetic */ int aLt;
    private final /* synthetic */ boolean aLu;
    private final /* synthetic */ boolean aLv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aLs = cVar;
        this.aLt = i;
        this.aLu = z;
        this.aLv = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        gVar = this.aLs.aLf;
        if (gVar != null) {
            gVar2 = this.aLs.aLf;
            gVar2.c(view, this.aLt, this.aLu && this.aLv);
        }
    }
}
