package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bKN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bKN = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bKN.mOffset;
        if (i != 0) {
            a aVar = this.bKN;
            i2 = this.bKN.mOffset;
            if (i2 > 0) {
                i4 = this.bKN.bKL;
            } else {
                i3 = this.bKN.bKL;
                i4 = -i3;
            }
            aVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(this, 200L);
    }
}
