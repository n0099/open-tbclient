package com.baidu.tieba.frs;

import android.graphics.Bitmap;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.d.d {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.d.d
    public void a(Bitmap bitmap, String str, boolean z) {
        ba baVar;
        if (bitmap != null) {
            com.baidu.tieba.d.ae.a("iscached: " + z);
            baVar = this.a.l;
            View d = baVar.d(str);
            if (d != null) {
                d.invalidate();
            }
        }
    }
}
