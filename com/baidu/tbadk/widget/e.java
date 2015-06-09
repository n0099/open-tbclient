package com.baidu.tbadk.widget;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class e extends Thread {
    final /* synthetic */ a asX;

    private e(a aVar) {
        this.asX = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, e eVar) {
        this(aVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (a.l(this.asX) == 1 && a.m(this.asX) != null && a.n(this.asX) > 0 && a.o(this.asX) > 0 && a.p(this.asX) > 0) {
            try {
                a.m(this.asX).D(a.q(this.asX));
                f Eg = this.asX.Eg();
                if (Eg.ate == null || (Eg.ate.getWidth() != a.o(this.asX) && Eg.ate.getHeight() != a.p(this.asX))) {
                    Eg.ate = Bitmap.createBitmap(a.o(this.asX), a.p(this.asX), Bitmap.Config.ARGB_8888);
                }
                a.m(this.asX).a(Eg.ate, null);
                Eg.delay = a.m(this.asX).E(a.q(this.asX));
                a aVar = this.asX;
                a.a(aVar, a.q(aVar) + 1);
                if (Eg.ate == null) {
                    a aVar2 = this.asX;
                    a.a(aVar2, a.q(aVar2) + 1);
                }
                a aVar3 = this.asX;
                a.a(aVar3, a.q(aVar3) % a.n(this.asX));
                a.r(this.asX).put(Eg);
                if (a.c(this.asX)) {
                    this.asX.mHandler.sendEmptyMessage(1);
                }
            } catch (Exception e) {
                return;
            }
        }
    }
}
