package com.baidu.tieba.frs;

import android.graphics.Bitmap;
import android.view.View;
/* loaded from: classes.dex */
class t implements com.baidu.tieba.d.d {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.a = sVar;
    }

    @Override // com.baidu.tieba.d.d
    public void a(Bitmap bitmap, String str, boolean z) {
        FrsActivity frsActivity;
        ba baVar;
        if (bitmap != null) {
            frsActivity = this.a.a;
            baVar = frsActivity.l;
            View d = baVar.d(str);
            if (d != null) {
                d.invalidate();
            }
        }
    }
}
