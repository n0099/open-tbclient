package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aNA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aNA = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aNA.mOffset;
        if (i != 0) {
            i2 = this.aNA.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b IA = com.baidu.tieba.enterForum.c.b.IA();
            a aVar = this.aNA;
            if (z) {
                i4 = this.aNA.aNy;
            } else {
                i3 = this.aNA.aNy;
                i4 = -i3;
            }
            if (!IA.a(aVar, i4, 200)) {
                this.aNA.setSelection(z ? this.aNA.getFirstVisiblePosition() + 2 : this.aNA.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.g.h.hf().postDelayed(this, 200L);
    }
}
