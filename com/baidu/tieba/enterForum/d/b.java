package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aRV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aRV = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aRV.mOffset;
        if (i != 0) {
            i2 = this.aRV.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b Ka = com.baidu.tieba.enterForum.c.b.Ka();
            a aVar = this.aRV;
            if (z) {
                i4 = this.aRV.aRT;
            } else {
                i3 = this.aRV.aRT;
                i4 = -i3;
            }
            if (!Ka.a(aVar, i4, 200)) {
                this.aRV.setSelection(z ? this.aRV.getFirstVisiblePosition() + 2 : this.aRV.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.h.h.hj().postDelayed(this, 200L);
    }
}
