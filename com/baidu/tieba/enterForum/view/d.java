package com.baidu.tieba.enterForum.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bwE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bwE = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bwE.mOffset;
        if (i != 0) {
            i2 = this.bwE.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b SX = com.baidu.tieba.enterForum.c.b.SX();
            c cVar = this.bwE;
            if (z) {
                i4 = this.bwE.bwB;
            } else {
                i3 = this.bwE.bwB;
                i4 = -i3;
            }
            if (!SX.a(cVar, i4, 200)) {
                this.bwE.setSelection(z ? this.bwE.getFirstVisiblePosition() + 1 : this.bwE.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.h.h.dL().postDelayed(this, 200L);
    }
}
