package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bNr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bNr = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bNr.mOffset;
        if (i != 0) {
            a aVar = this.bNr;
            i2 = this.bNr.mOffset;
            if (i2 > 0) {
                i4 = this.bNr.bNp;
            } else {
                i3 = this.bNr.bNp;
                i4 = -i3;
            }
            aVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.g.h.fS().postDelayed(this, 200L);
    }
}
