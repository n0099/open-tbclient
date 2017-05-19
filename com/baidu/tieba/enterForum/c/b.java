package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bHD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bHD = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bHD.mOffset;
        if (i != 0) {
            a aVar = this.bHD;
            i2 = this.bHD.mOffset;
            if (i2 > 0) {
                i4 = this.bHD.bHB;
            } else {
                i3 = this.bHD.bHB;
                i4 = -i3;
            }
            aVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.g.h.fS().postDelayed(this, 200L);
    }
}
