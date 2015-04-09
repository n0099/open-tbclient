package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aDM = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aDM.mOffset;
        if (i != 0) {
            i2 = this.aDM.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b GW = com.baidu.tieba.enterForum.c.b.GW();
            c cVar = this.aDM;
            if (z) {
                i4 = this.aDM.aDJ;
            } else {
                i3 = this.aDM.aDJ;
                i4 = -i3;
            }
            if (!GW.a(cVar, i4, 200)) {
                this.aDM.setSelection(z ? this.aDM.getFirstVisiblePosition() + 1 : this.aDM.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.g.i.hI().postDelayed(this, 200L);
    }
}
