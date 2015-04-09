package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aDL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aDL = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aDL.mOffset;
        if (i != 0) {
            i2 = this.aDL.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b GW = com.baidu.tieba.enterForum.c.b.GW();
            a aVar = this.aDL;
            if (z) {
                i4 = this.aDL.aDJ;
            } else {
                i3 = this.aDL.aDJ;
                i4 = -i3;
            }
            if (!GW.a(aVar, i4, 200)) {
                this.aDL.setSelection(z ? this.aDL.getFirstVisiblePosition() + 2 : this.aDL.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.g.i.hI().postDelayed(this, 200L);
    }
}
