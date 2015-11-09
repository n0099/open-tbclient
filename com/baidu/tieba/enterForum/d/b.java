package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aMO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aMO = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aMO.mOffset;
        if (i != 0) {
            i2 = this.aMO.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b II = com.baidu.tieba.enterForum.c.b.II();
            a aVar = this.aMO;
            if (z) {
                i4 = this.aMO.aMM;
            } else {
                i3 = this.aMO.aMM;
                i4 = -i3;
            }
            if (!II.a(aVar, i4, 200)) {
                this.aMO.setSelection(z ? this.aMO.getFirstVisiblePosition() + 2 : this.aMO.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.g.h.hh().postDelayed(this, 200L);
    }
}
