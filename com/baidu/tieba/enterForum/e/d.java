package com.baidu.tieba.enterForum.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bHS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bHS = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bHS.mOffset;
        if (i != 0) {
            i2 = this.bHS.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b XI = com.baidu.tieba.enterForum.c.b.XI();
            c cVar = this.bHS;
            if (z) {
                i4 = this.bHS.bHP;
            } else {
                i3 = this.bHS.bHP;
                i4 = -i3;
            }
            if (!XI.a(cVar, i4, 200)) {
                this.bHS.setSelection(z ? this.bHS.getFirstVisiblePosition() + 1 : this.bHS.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(this, 200L);
    }
}
