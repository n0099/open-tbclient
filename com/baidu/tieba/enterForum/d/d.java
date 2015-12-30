package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aVY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aVY = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aVY.mOffset;
        if (i != 0) {
            i2 = this.aVY.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b Kt = com.baidu.tieba.enterForum.c.b.Kt();
            c cVar = this.aVY;
            if (z) {
                i4 = this.aVY.aVV;
            } else {
                i3 = this.aVY.aVV;
                i4 = -i3;
            }
            if (!Kt.a(cVar, i4, 200)) {
                this.aVY.setSelection(z ? this.aVY.getFirstVisiblePosition() + 1 : this.aVY.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.h.h.hj().postDelayed(this, 200L);
    }
}
