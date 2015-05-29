package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aFN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aFN = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aFN.mOffset;
        if (i != 0) {
            i2 = this.aFN.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b HY = com.baidu.tieba.enterForum.c.b.HY();
            a aVar = this.aFN;
            if (z) {
                i4 = this.aFN.aFL;
            } else {
                i3 = this.aFN.aFL;
                i4 = -i3;
            }
            if (!HY.a(aVar, i4, 200)) {
                this.aFN.setSelection(z ? this.aFN.getFirstVisiblePosition() + 2 : this.aFN.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.g.i.hs().postDelayed(this, 200L);
    }
}
