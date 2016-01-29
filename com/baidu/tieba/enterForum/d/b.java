package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aYk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aYk = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aYk.mOffset;
        if (i != 0) {
            i2 = this.aYk.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b Mk = com.baidu.tieba.enterForum.c.b.Mk();
            a aVar = this.aYk;
            if (z) {
                i4 = this.aYk.aYi;
            } else {
                i3 = this.aYk.aYi;
                i4 = -i3;
            }
            if (!Mk.a(aVar, i4, 200)) {
                this.aYk.setSelection(z ? this.aYk.getFirstVisiblePosition() + 2 : this.aYk.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.h.h.hr().postDelayed(this, 200L);
    }
}
