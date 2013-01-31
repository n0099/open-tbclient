package com.baidu.tieba.frs;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class x implements com.baidu.tieba.c.d {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.a = wVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        if (bitmap == null) {
            frsActivity2 = this.a.a;
            frsActivity2.p();
            return;
        }
        frsActivity = this.a.a;
        frsActivity.a(bitmap, false);
    }
}
