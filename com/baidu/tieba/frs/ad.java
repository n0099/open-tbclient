package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class ad implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        br brVar;
        if (bVar != null) {
            brVar = this.a.p;
            View d = brVar.d(str);
            if (d != null) {
                d.invalidate();
            }
        }
    }
}
