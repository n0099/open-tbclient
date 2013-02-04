package com.baidu.tieba.frs;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class y implements com.baidu.tieba.c.d {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.a = xVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        if (bitmap == null) {
            frsActivity2 = this.a.a;
            frsActivity2.o();
            return;
        }
        frsActivity = this.a.a;
        frsActivity.a(bitmap, false);
    }
}
