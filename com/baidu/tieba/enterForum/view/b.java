package com.baidu.tieba.enterForum.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bup = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.bup.mOffset;
        if (i != 0) {
            i2 = this.bup.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b Sp = com.baidu.tieba.enterForum.c.b.Sp();
            a aVar = this.bup;
            if (z) {
                i4 = this.bup.bun;
            } else {
                i3 = this.bup.bun;
                i4 = -i3;
            }
            if (!Sp.a(aVar, i4, 200)) {
                this.bup.setSelection(z ? this.bup.getFirstVisiblePosition() + 2 : this.bup.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.h.h.dM().postDelayed(this, 200L);
    }
}
