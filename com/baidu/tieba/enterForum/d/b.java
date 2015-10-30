package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aMG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aMG = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aMG.mOffset;
        if (i != 0) {
            i2 = this.aMG.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b Is = com.baidu.tieba.enterForum.c.b.Is();
            a aVar = this.aMG;
            if (z) {
                i4 = this.aMG.aME;
            } else {
                i3 = this.aMG.aME;
                i4 = -i3;
            }
            if (!Is.a(aVar, i4, 200)) {
                this.aMG.setSelection(z ? this.aMG.getFirstVisiblePosition() + 2 : this.aMG.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.g.h.hg().postDelayed(this, 200L);
    }
}
