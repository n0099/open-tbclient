package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bHT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bHT = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bHT.mOffset;
        if (i != 0) {
            a aVar = this.bHT;
            i2 = this.bHT.mOffset;
            if (i2 > 0) {
                i4 = this.bHT.bHR;
            } else {
                i3 = this.bHT.bHR;
                i4 = -i3;
            }
            aVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(this, 200L);
    }
}
