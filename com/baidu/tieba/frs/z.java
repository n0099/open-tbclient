package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class z implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        bo boVar;
        if (dVar != null) {
            boVar = this.a.n;
            View d = boVar.d(str);
            if (d != null) {
                d.invalidate();
            }
        }
    }
}
