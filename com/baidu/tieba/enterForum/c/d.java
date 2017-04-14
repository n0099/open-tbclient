package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bFE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bFE = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bFE.mOffset;
        if (i != 0) {
            c cVar = this.bFE;
            i2 = this.bFE.mOffset;
            if (i2 > 0) {
                i4 = this.bFE.bFB;
            } else {
                i3 = this.bFE.bFB;
                i4 = -i3;
            }
            cVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.g.h.fR().postDelayed(this, 200L);
    }
}
