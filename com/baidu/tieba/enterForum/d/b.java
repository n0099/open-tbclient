package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aNn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aNn = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aNn.mOffset;
        if (i != 0) {
            i2 = this.aNn.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b IM = com.baidu.tieba.enterForum.c.b.IM();
            a aVar = this.aNn;
            if (z) {
                i4 = this.aNn.aNl;
            } else {
                i3 = this.aNn.aNl;
                i4 = -i3;
            }
            if (!IM.a(aVar, i4, 200)) {
                this.aNn.setSelection(z ? this.aNn.getFirstVisiblePosition() + 2 : this.aNn.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.g.h.hi().postDelayed(this, 200L);
    }
}
