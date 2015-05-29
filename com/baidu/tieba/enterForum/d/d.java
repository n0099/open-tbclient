package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aFO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aFO = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aFO.mOffset;
        if (i != 0) {
            i2 = this.aFO.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b HY = com.baidu.tieba.enterForum.c.b.HY();
            c cVar = this.aFO;
            if (z) {
                i4 = this.aFO.aFL;
            } else {
                i3 = this.aFO.aFL;
                i4 = -i3;
            }
            if (!HY.a(cVar, i4, 200)) {
                this.aFO.setSelection(z ? this.aFO.getFirstVisiblePosition() + 1 : this.aFO.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.g.i.hs().postDelayed(this, 200L);
    }
}
