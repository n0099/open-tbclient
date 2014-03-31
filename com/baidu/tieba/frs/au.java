package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
final class au implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        cm cmVar;
        if (bVar != null) {
            cmVar = this.a.r;
            View d = cmVar.d(str);
            if (d != null) {
                d.invalidate();
            }
        }
    }
}
