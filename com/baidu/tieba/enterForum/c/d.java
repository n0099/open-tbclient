package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bFL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bFL = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bFL.mOffset;
        if (i != 0) {
            c cVar = this.bFL;
            i2 = this.bFL.mOffset;
            if (i2 > 0) {
                i4 = this.bFL.bFI;
            } else {
                i3 = this.bFL.bFI;
                i4 = -i3;
            }
            cVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.g.h.fM().postDelayed(this, 200L);
    }
}
