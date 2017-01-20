package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a byE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.byE = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.byE.mOffset;
        if (i != 0) {
            a aVar = this.byE;
            i2 = this.byE.mOffset;
            if (i2 > 0) {
                i4 = this.byE.byC;
            } else {
                i3 = this.byE.byC;
                i4 = -i3;
            }
            aVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.g.h.eE().postDelayed(this, 200L);
    }
}
