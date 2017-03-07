package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bFK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bFK = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bFK.mOffset;
        if (i != 0) {
            a aVar = this.bFK;
            i2 = this.bFK.mOffset;
            if (i2 > 0) {
                i4 = this.bFK.bFI;
            } else {
                i3 = this.bFK.bFI;
                i4 = -i3;
            }
            aVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.g.h.fM().postDelayed(this, 200L);
    }
}
