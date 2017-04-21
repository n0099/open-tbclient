package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bHU = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bHU.mOffset;
        if (i != 0) {
            a aVar = this.bHU;
            i2 = this.bHU.mOffset;
            if (i2 > 0) {
                i4 = this.bHU.bHS;
            } else {
                i3 = this.bHU.bHS;
                i4 = -i3;
            }
            aVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.g.h.fS().postDelayed(this, 200L);
    }
}
