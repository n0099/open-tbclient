package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bcU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bcU = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bcU.mOffset;
        if (i != 0) {
            i2 = this.bcU.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b NY = com.baidu.tieba.enterForum.c.b.NY();
            c cVar = this.bcU;
            if (z) {
                i4 = this.bcU.bcR;
            } else {
                i3 = this.bcU.bcR;
                i4 = -i3;
            }
            if (!NY.a(cVar, i4, 200)) {
                this.bcU.setSelection(z ? this.bcU.getFirstVisiblePosition() + 1 : this.bcU.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.h.h.hx().postDelayed(this, 200L);
    }
}
