package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bcT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bcT = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bcT.mOffset;
        if (i != 0) {
            i2 = this.bcT.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b NY = com.baidu.tieba.enterForum.c.b.NY();
            a aVar = this.bcT;
            if (z) {
                i4 = this.bcT.bcR;
            } else {
                i3 = this.bcT.bcR;
                i4 = -i3;
            }
            if (!NY.a(aVar, i4, 200)) {
                this.bcT.setSelection(z ? this.bcT.getFirstVisiblePosition() + 2 : this.bcT.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.h.h.hx().postDelayed(this, 200L);
    }
}
