package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aNB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aNB = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aNB.mOffset;
        if (i != 0) {
            i2 = this.aNB.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b IA = com.baidu.tieba.enterForum.c.b.IA();
            c cVar = this.aNB;
            if (z) {
                i4 = this.aNB.aNy;
            } else {
                i3 = this.aNB.aNy;
                i4 = -i3;
            }
            if (!IA.a(cVar, i4, 200)) {
                this.aNB.setSelection(z ? this.aNB.getFirstVisiblePosition() + 1 : this.aNB.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.g.h.hf().postDelayed(this, 200L);
    }
}
