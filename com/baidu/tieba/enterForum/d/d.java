package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bHU = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bHU.mOffset;
        if (i != 0) {
            c cVar = this.bHU;
            i2 = this.bHU.mOffset;
            if (i2 > 0) {
                i4 = this.bHU.bHR;
            } else {
                i3 = this.bHU.bHR;
                i4 = -i3;
            }
            cVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(this, 200L);
    }
}
