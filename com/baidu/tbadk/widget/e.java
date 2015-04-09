package com.baidu.tbadk.widget;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class e extends Thread {
    final /* synthetic */ a aru;

    private e(a aVar) {
        this.aru = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, e eVar) {
        this(aVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (a.l(this.aru) == 1 && a.m(this.aru) != null && a.n(this.aru) > 0 && a.o(this.aru) > 0 && a.p(this.aru) > 0) {
            try {
                a.m(this.aru).C(a.q(this.aru));
                f Dv = this.aru.Dv();
                if (Dv.arB == null || (Dv.arB.getWidth() != a.o(this.aru) && Dv.arB.getHeight() != a.p(this.aru))) {
                    Dv.arB = Bitmap.createBitmap(a.o(this.aru), a.p(this.aru), Bitmap.Config.ARGB_8888);
                }
                a.m(this.aru).a(Dv.arB, null);
                Dv.delay = a.m(this.aru).D(a.q(this.aru));
                a aVar = this.aru;
                a.a(aVar, a.q(aVar) + 1);
                if (Dv.arB == null) {
                    a aVar2 = this.aru;
                    a.a(aVar2, a.q(aVar2) + 1);
                }
                a aVar3 = this.aru;
                a.a(aVar3, a.q(aVar3) % a.n(this.aru));
                a.r(this.aru).put(Dv);
                if (a.c(this.aru)) {
                    this.aru.mHandler.sendEmptyMessage(1);
                }
            } catch (Exception e) {
                return;
            }
        }
    }
}
