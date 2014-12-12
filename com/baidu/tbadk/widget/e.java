package com.baidu.tbadk.widget;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class e extends Thread {
    final /* synthetic */ a aik;

    private e(a aVar) {
        this.aik = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, e eVar) {
        this(aVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (a.l(this.aik) == 1 && a.m(this.aik) != null && a.n(this.aik) > 0 && a.o(this.aik) > 0 && a.p(this.aik) > 0) {
            try {
                a.m(this.aik).w(a.q(this.aik));
                f zG = this.aik.zG();
                if (zG.air == null || (zG.air.getWidth() != a.o(this.aik) && zG.air.getHeight() != a.p(this.aik))) {
                    zG.air = Bitmap.createBitmap(a.o(this.aik), a.p(this.aik), Bitmap.Config.ARGB_8888);
                }
                a.m(this.aik).a(zG.air, null);
                zG.delay = a.m(this.aik).x(a.q(this.aik));
                a aVar = this.aik;
                a.a(aVar, a.q(aVar) + 1);
                if (zG.air == null) {
                    a aVar2 = this.aik;
                    a.a(aVar2, a.q(aVar2) + 1);
                }
                a aVar3 = this.aik;
                a.a(aVar3, a.q(aVar3) % a.n(this.aik));
                a.r(this.aik).put(zG);
                if (a.c(this.aik)) {
                    this.aik.mHandler.sendEmptyMessage(1);
                }
            } catch (Exception e) {
                return;
            }
        }
    }
}
