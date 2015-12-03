package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aRW = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aRW.mOffset;
        if (i != 0) {
            i2 = this.aRW.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b Ka = com.baidu.tieba.enterForum.c.b.Ka();
            c cVar = this.aRW;
            if (z) {
                i4 = this.aRW.aRT;
            } else {
                i3 = this.aRW.aRT;
                i4 = -i3;
            }
            if (!Ka.a(cVar, i4, 200)) {
                this.aRW.setSelection(z ? this.aRW.getFirstVisiblePosition() + 1 : this.aRW.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.h.h.hj().postDelayed(this, 200L);
    }
}
