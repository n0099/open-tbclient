package com.baidu.tieba.b.b;

import android.os.Handler;
import com.baidu.tieba.b.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends b.a {
    final /* synthetic */ g brD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.brD = gVar;
    }

    @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.b
    public double e(float f, float f2, float f3, int i) {
        return -(f - (com.baidu.tieba.b.c.a.e((15.0d - i) / 15.0d) * 90.0d));
    }

    @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
    public boolean b(float f, float f2, float f3, int i) {
        return ((double) i) > 15.0d;
    }

    @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
    public void d(float f, float f2, float f3, int i) {
        Handler handler;
        this.brD.RU();
        this.brD.gF(1);
        this.brD.Sa();
        handler = this.brD.mHandler;
        handler.sendEmptyMessage(1);
    }
}
