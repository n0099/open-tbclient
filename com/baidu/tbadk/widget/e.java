package com.baidu.tbadk.widget;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class e extends Thread {
    final /* synthetic */ a aiK;

    private e(a aVar) {
        this.aiK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, e eVar) {
        this(aVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (a.l(this.aiK) == 1 && a.m(this.aiK) != null && a.n(this.aiK) > 0 && a.o(this.aiK) > 0 && a.p(this.aiK) > 0) {
            try {
                a.m(this.aiK).B(a.q(this.aiK));
                f zU = this.aiK.zU();
                if (zU.aiR == null || (zU.aiR.getWidth() != a.o(this.aiK) && zU.aiR.getHeight() != a.p(this.aiK))) {
                    zU.aiR = Bitmap.createBitmap(a.o(this.aiK), a.p(this.aiK), Bitmap.Config.ARGB_8888);
                }
                a.m(this.aiK).a(zU.aiR, null);
                zU.delay = a.m(this.aiK).C(a.q(this.aiK));
                a aVar = this.aiK;
                a.a(aVar, a.q(aVar) + 1);
                if (zU.aiR == null) {
                    a aVar2 = this.aiK;
                    a.a(aVar2, a.q(aVar2) + 1);
                }
                a aVar3 = this.aiK;
                a.a(aVar3, a.q(aVar3) % a.n(this.aiK));
                a.r(this.aiK).put(zU);
                if (a.c(this.aiK)) {
                    this.aiK.mHandler.sendEmptyMessage(1);
                }
            } catch (Exception e) {
                return;
            }
        }
    }
}
