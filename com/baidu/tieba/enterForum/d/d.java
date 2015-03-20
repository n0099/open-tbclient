package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aDE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aDE = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aDE.mOffset;
        if (i != 0) {
            i2 = this.aDE.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b GQ = com.baidu.tieba.enterForum.c.b.GQ();
            c cVar = this.aDE;
            if (z) {
                i4 = this.aDE.aDB;
            } else {
                i3 = this.aDE.aDB;
                i4 = -i3;
            }
            if (!GQ.a(cVar, i4, 200)) {
                this.aDE.setSelection(z ? this.aDE.getFirstVisiblePosition() + 1 : this.aDE.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.g.i.hI().postDelayed(this, 200L);
    }
}
