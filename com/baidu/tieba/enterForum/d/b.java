package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aFO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aFO = aVar;
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
            com.baidu.tieba.enterForum.c.b HZ = com.baidu.tieba.enterForum.c.b.HZ();
            a aVar = this.aFO;
            if (z) {
                i4 = this.aFO.aFM;
            } else {
                i3 = this.aFO.aFM;
                i4 = -i3;
            }
            if (!HZ.a(aVar, i4, 200)) {
                this.aFO.setSelection(z ? this.aFO.getFirstVisiblePosition() + 2 : this.aFO.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.g.i.hs().postDelayed(this, 200L);
    }
}
