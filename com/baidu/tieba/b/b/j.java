package com.baidu.tieba.b.b;

import android.os.Handler;
import com.baidu.tieba.b.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends b.a {
    final /* synthetic */ g bsK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.bsK = gVar;
    }

    @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.b
    public double e(float f, float f2, float f3, int i) {
        return (com.baidu.tieba.b.c.a.e(i / 15.0d) * 90.0d) - f;
    }

    @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
    public boolean b(float f, float f2, float f3, int i) {
        return ((double) i) > 15.0d;
    }

    @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
    public void d(float f, float f2, float f3, int i) {
        Handler handler;
        this.bsK.Sg();
        this.bsK.gW(3);
        this.bsK.Sm();
        handler = this.bsK.mHandler;
        handler.sendEmptyMessage(2);
    }
}
