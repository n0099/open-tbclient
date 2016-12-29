package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bqS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bqS = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bqS.mOffset;
        if (i != 0) {
            c cVar = this.bqS;
            i2 = this.bqS.mOffset;
            if (i2 > 0) {
                i4 = this.bqS.bqP;
            } else {
                i3 = this.bqS.bqP;
                i4 = -i3;
            }
            cVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(this, 200L);
    }
}
