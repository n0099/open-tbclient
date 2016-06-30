package com.baidu.tieba.enterForum.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c buq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.buq = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.buq.mOffset;
        if (i != 0) {
            i2 = this.buq.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b Sp = com.baidu.tieba.enterForum.c.b.Sp();
            c cVar = this.buq;
            if (z) {
                i4 = this.buq.bun;
            } else {
                i3 = this.buq.bun;
                i4 = -i3;
            }
            if (!Sp.a(cVar, i4, 200)) {
                this.buq.setSelection(z ? this.buq.getFirstVisiblePosition() + 1 : this.buq.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.h.h.dM().postDelayed(this, 200L);
    }
}
