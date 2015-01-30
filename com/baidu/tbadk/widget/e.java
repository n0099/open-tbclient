package com.baidu.tbadk.widget;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class e extends Thread {
    final /* synthetic */ a aiN;

    private e(a aVar) {
        this.aiN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, e eVar) {
        this(aVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (a.l(this.aiN) == 1 && a.m(this.aiN) != null && a.n(this.aiN) > 0 && a.o(this.aiN) > 0 && a.p(this.aiN) > 0) {
            try {
                a.m(this.aiN).B(a.q(this.aiN));
                f Aa = this.aiN.Aa();
                if (Aa.aiU == null || (Aa.aiU.getWidth() != a.o(this.aiN) && Aa.aiU.getHeight() != a.p(this.aiN))) {
                    Aa.aiU = Bitmap.createBitmap(a.o(this.aiN), a.p(this.aiN), Bitmap.Config.ARGB_8888);
                }
                a.m(this.aiN).a(Aa.aiU, null);
                Aa.delay = a.m(this.aiN).C(a.q(this.aiN));
                a aVar = this.aiN;
                a.a(aVar, a.q(aVar) + 1);
                if (Aa.aiU == null) {
                    a aVar2 = this.aiN;
                    a.a(aVar2, a.q(aVar2) + 1);
                }
                a aVar3 = this.aiN;
                a.a(aVar3, a.q(aVar3) % a.n(this.aiN));
                a.r(this.aiN).put(Aa);
                if (a.c(this.aiN)) {
                    this.aiN.mHandler.sendEmptyMessage(1);
                }
            } catch (Exception e) {
                return;
            }
        }
    }
}
