package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aNo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aNo = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aNo.mOffset;
        if (i != 0) {
            i2 = this.aNo.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b IM = com.baidu.tieba.enterForum.c.b.IM();
            c cVar = this.aNo;
            if (z) {
                i4 = this.aNo.aNl;
            } else {
                i3 = this.aNo.aNl;
                i4 = -i3;
            }
            if (!IM.a(cVar, i4, 200)) {
                this.aNo.setSelection(z ? this.aNo.getFirstVisiblePosition() + 1 : this.aNo.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.g.h.hi().postDelayed(this, 200L);
    }
}
