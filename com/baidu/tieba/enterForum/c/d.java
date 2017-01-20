package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c byF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.byF = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.byF.mOffset;
        if (i != 0) {
            c cVar = this.byF;
            i2 = this.byF.mOffset;
            if (i2 > 0) {
                i4 = this.byF.byC;
            } else {
                i3 = this.byF.byC;
                i4 = -i3;
            }
            cVar.smoothScrollBy(i4, 200);
        }
        com.baidu.adp.lib.g.h.eE().postDelayed(this, 200L);
    }
}
