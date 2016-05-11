package com.baidu.tieba.enterForum.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aYy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aYy = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.aYy.mOffset;
        if (i != 0) {
            i2 = this.aYy.mOffset;
            boolean z = i2 > 0;
            com.baidu.tieba.enterForum.c.b ML = com.baidu.tieba.enterForum.c.b.ML();
            c cVar = this.aYy;
            if (z) {
                i4 = this.aYy.aYv;
            } else {
                i3 = this.aYy.aYv;
                i4 = -i3;
            }
            if (!ML.a(cVar, i4, 200)) {
                this.aYy.setSelection(z ? this.aYy.getFirstVisiblePosition() + 1 : this.aYy.getFirstVisiblePosition() - 1);
            }
        }
        com.baidu.adp.lib.h.h.dL().postDelayed(this, 200L);
    }
}
