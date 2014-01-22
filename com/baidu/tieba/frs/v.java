package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class v implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        bk bkVar;
        if (dVar != null) {
            bkVar = this.a.n;
            View d = bkVar.d(str);
            if (d != null) {
                d.invalidate();
            }
        }
    }
}
