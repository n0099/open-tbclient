package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aFP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aFP = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aFP.mOffset;
        if (i != 0) {
            i2 = this.aFP.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b HZ = com.baidu.tieba.enterForum.c.b.HZ();
            c cVar = this.aFP;
            if (z) {
                i4 = this.aFP.aFM;
            } else {
                i3 = this.aFP.aFM;
                i4 = -i3;
            }
            if (!HZ.a(cVar, i4, 200)) {
                this.aFP.setSelection(z ? this.aFP.getFirstVisiblePosition() + 1 : this.aFP.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.g.i.hs().postDelayed(this, 200L);
    }
}
