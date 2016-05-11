package com.baidu.tieba.enterForum.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aYx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aYx = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aYx.mOffset;
        if (i != 0) {
            i2 = this.aYx.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b ML = com.baidu.tieba.enterForum.c.b.ML();
            a aVar = this.aYx;
            if (z) {
                i4 = this.aYx.aYv;
            } else {
                i3 = this.aYx.aYv;
                i4 = -i3;
            }
            if (!ML.a(aVar, i4, 200)) {
                this.aYx.setSelection(z ? this.aYx.getFirstVisiblePosition() + 2 : this.aYx.getFirstVisiblePosition() - 2);
            }
        }
        com.baidu.adp.lib.h.h.dL().postDelayed(this, 200L);
    }
}
