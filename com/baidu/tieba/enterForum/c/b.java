package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bFD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bFD = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bFD.mOffset;
        if (i != 0) {
            a aVar = this.bFD;
            i2 = this.bFD.mOffset;
            if (i2 > 0) {
                i4 = this.bFD.bFB;
            } else {
                i3 = this.bFD.bFB;
                i4 = -i3;
            }
            aVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.g.h.fR().postDelayed(this, 200L);
    }
}
