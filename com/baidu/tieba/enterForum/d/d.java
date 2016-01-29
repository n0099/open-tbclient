package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aYl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aYl = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aYl.mOffset;
        if (i != 0) {
            i2 = this.aYl.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b Mk = com.baidu.tieba.enterForum.c.b.Mk();
            c cVar = this.aYl;
            if (z) {
                i4 = this.aYl.aYi;
            } else {
                i3 = this.aYl.aYi;
                i4 = -i3;
            }
            if (!Mk.a(cVar, i4, 200)) {
                this.aYl.setSelection(z ? this.aYl.getFirstVisiblePosition() + 1 : this.aYl.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.h.h.hr().postDelayed(this, 200L);
    }
}
