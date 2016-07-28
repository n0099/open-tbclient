package com.baidu.tieba.enterForum.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bwD = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bwD.mOffset;
        if (i != 0) {
            i2 = this.bwD.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b SX = com.baidu.tieba.enterForum.c.b.SX();
            a aVar = this.bwD;
            if (z) {
                i4 = this.bwD.bwB;
            } else {
                i3 = this.bwD.bwB;
                i4 = -i3;
            }
            if (!SX.a(aVar, i4, 200)) {
                this.bwD.setSelection(z ? this.bwD.getFirstVisiblePosition() + 2 : this.bwD.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.h.h.dL().postDelayed(this, 200L);
    }
}
