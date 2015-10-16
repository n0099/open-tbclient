package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aMH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aMH = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aMH.mOffset;
        if (i != 0) {
            i2 = this.aMH.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b Iw = com.baidu.tieba.enterForum.c.b.Iw();
            c cVar = this.aMH;
            if (z) {
                i4 = this.aMH.aME;
            } else {
                i3 = this.aMH.aME;
                i4 = -i3;
            }
            if (!Iw.a(cVar, i4, 200)) {
                this.aMH.setSelection(z ? this.aMH.getFirstVisiblePosition() + 1 : this.aMH.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.g.h.hg().postDelayed(this, 200L);
    }
}
