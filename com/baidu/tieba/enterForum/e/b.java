package com.baidu.tieba.enterForum.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bHR = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bHR.mOffset;
        if (i != 0) {
            i2 = this.bHR.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b XI = com.baidu.tieba.enterForum.c.b.XI();
            a aVar = this.bHR;
            if (z) {
                i4 = this.bHR.bHP;
            } else {
                i3 = this.bHR.bHP;
                i4 = -i3;
            }
            if (!XI.a(aVar, i4, 200)) {
                this.bHR.setSelection(z ? this.bHR.getFirstVisiblePosition() + 2 : this.bHR.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(this, 200L);
    }
}
