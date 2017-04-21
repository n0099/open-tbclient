package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bHV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bHV = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bHV.mOffset;
        if (i != 0) {
            c cVar = this.bHV;
            i2 = this.bHV.mOffset;
            if (i2 > 0) {
                i4 = this.bHV.bHS;
            } else {
                i3 = this.bHV.bHS;
                i4 = -i3;
            }
            cVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.g.h.fS().postDelayed(this, 200L);
    }
}
