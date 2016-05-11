package com.baidu.tieba.a.b;

import android.os.Handler;
import com.baidu.tieba.a.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends b.a {
    final /* synthetic */ g aMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.aMD = gVar;
    }

    @Override // com.baidu.tieba.a.a.b.a, com.baidu.tieba.a.a.b
    public double e(float f, float f2, float f3, int i) {
        return (com.baidu.tieba.a.c.a.c(i / 15.0d) * 90.0d) - f;
    }

    @Override // com.baidu.tieba.a.a.b.a, com.baidu.tieba.a.a.a
    public boolean b(float f, float f2, float f3, int i) {
        return ((double) i) > 15.0d;
    }

    @Override // com.baidu.tieba.a.a.b.a, com.baidu.tieba.a.a.a
    public void d(float f, float f2, float f3, int i) {
        Handler handler;
        this.aMD.IZ();
        this.aMD.fr(3);
        handler = this.aMD.mHandler;
        handler.sendEmptyMessage(2);
    }
}
