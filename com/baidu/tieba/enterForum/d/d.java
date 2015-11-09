package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aMP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aMP = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aMP.mOffset;
        if (i != 0) {
            i2 = this.aMP.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b II = com.baidu.tieba.enterForum.c.b.II();
            c cVar = this.aMP;
            if (z) {
                i4 = this.aMP.aMM;
            } else {
                i3 = this.aMP.aMM;
                i4 = -i3;
            }
            if (!II.a(cVar, i4, 200)) {
                this.aMP.setSelection(z ? this.aMP.getFirstVisiblePosition() + 1 : this.aMP.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.g.h.hh().postDelayed(this, 200L);
    }
}
