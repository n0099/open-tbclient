package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aMv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aMv = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aMv.mOffset;
        if (i != 0) {
            i2 = this.aMv.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b Iw = com.baidu.tieba.enterForum.c.b.Iw();
            a aVar = this.aMv;
            if (z) {
                i4 = this.aMv.aMt;
            } else {
                i3 = this.aMv.aMt;
                i4 = -i3;
            }
            if (!Iw.a(aVar, i4, 200)) {
                this.aMv.setSelection(z ? this.aMv.getFirstVisiblePosition() + 2 : this.aMv.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.g.h.hg().postDelayed(this, 200L);
    }
}
