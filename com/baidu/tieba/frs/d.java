package com.baidu.tieba.frs;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.d.d {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.tieba.d.d
    public void a(Bitmap bitmap, String str, boolean z) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        if (bitmap == null) {
            frsActivity2 = this.a.a;
            frsActivity2.v();
            return;
        }
        frsActivity = this.a.a;
        frsActivity.a(bitmap, false);
    }
}
