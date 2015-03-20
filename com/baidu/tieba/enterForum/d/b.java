package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aDD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aDD = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aDD.mOffset;
        if (i != 0) {
            i2 = this.aDD.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b GQ = com.baidu.tieba.enterForum.c.b.GQ();
            a aVar = this.aDD;
            if (z) {
                i4 = this.aDD.aDB;
            } else {
                i3 = this.aDD.aDB;
                i4 = -i3;
            }
            if (!GQ.a(aVar, i4, 200)) {
                this.aDD.setSelection(z ? this.aDD.getFirstVisiblePosition() + 2 : this.aDD.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.g.i.hI().postDelayed(this, 200L);
    }
}
