package com.baidu.tbadk.widget;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class e extends Thread {
    final /* synthetic */ a arm;

    private e(a aVar) {
        this.arm = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, e eVar) {
        this(aVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (a.l(this.arm) == 1 && a.m(this.arm) != null && a.n(this.arm) > 0 && a.o(this.arm) > 0 && a.p(this.arm) > 0) {
            try {
                a.m(this.arm).C(a.q(this.arm));
                f Dp = this.arm.Dp();
                if (Dp.art == null || (Dp.art.getWidth() != a.o(this.arm) && Dp.art.getHeight() != a.p(this.arm))) {
                    Dp.art = Bitmap.createBitmap(a.o(this.arm), a.p(this.arm), Bitmap.Config.ARGB_8888);
                }
                a.m(this.arm).a(Dp.art, null);
                Dp.delay = a.m(this.arm).D(a.q(this.arm));
                a aVar = this.arm;
                a.a(aVar, a.q(aVar) + 1);
                if (Dp.art == null) {
                    a aVar2 = this.arm;
                    a.a(aVar2, a.q(aVar2) + 1);
                }
                a aVar3 = this.arm;
                a.a(aVar3, a.q(aVar3) % a.n(this.arm));
                a.r(this.arm).put(Dp);
                if (a.c(this.arm)) {
                    this.arm.mHandler.sendEmptyMessage(1);
                }
            } catch (Exception e) {
                return;
            }
        }
    }
}
