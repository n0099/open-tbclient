package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aMw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aMw = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aMw.mOffset;
        if (i != 0) {
            i2 = this.aMw.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b Iw = com.baidu.tieba.enterForum.c.b.Iw();
            c cVar = this.aMw;
            if (z) {
                i4 = this.aMw.aMt;
            } else {
                i3 = this.aMw.aMt;
                i4 = -i3;
            }
            if (!Iw.a(cVar, i4, 200)) {
                this.aMw.setSelection(z ? this.aMw.getFirstVisiblePosition() + 1 : this.aMw.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.g.h.hg().postDelayed(this, 200L);
    }
}
