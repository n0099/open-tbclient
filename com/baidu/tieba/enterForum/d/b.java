package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aVX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aVX = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aVX.mOffset;
        if (i != 0) {
            i2 = this.aVX.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b Kt = com.baidu.tieba.enterForum.c.b.Kt();
            a aVar = this.aVX;
            if (z) {
                i4 = this.aVX.aVV;
            } else {
                i3 = this.aVX.aVV;
                i4 = -i3;
            }
            if (!Kt.a(aVar, i4, 200)) {
                this.aVX.setSelection(z ? this.aVX.getFirstVisiblePosition() + 2 : this.aVX.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.h.h.hj().postDelayed(this, 200L);
    }
}
