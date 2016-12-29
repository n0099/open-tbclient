package com.baidu.tieba.b.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.b.a.c {
    final /* synthetic */ g aYO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.aYO = gVar;
    }

    @Override // com.baidu.tieba.b.a.a
    public boolean b(float f, float f2, float f3, int i) {
        return this.aYO.aYC >= 0.0f || ((double) i) > 15.0d;
    }

    @Override // com.baidu.tieba.b.a.a
    public void d(float f, float f2, float f3, int i) {
    }

    @Override // com.baidu.tieba.b.a.c
    public float g(float f, float f2, float f3, int i) {
        float f4;
        float f5;
        double sin = Math.sin((((float) com.baidu.tieba.b.c.a.c(i / 15.0d)) * 3.141592653589793d) / 2.0d);
        f4 = this.aYO.mRadius;
        double abs = sin * Math.abs(f4);
        f5 = this.aYO.mRadius;
        return (float) (abs - Math.abs(f5));
    }

    @Override // com.baidu.tieba.b.a.c
    public float h(float f, float f2, float f3, int i) {
        float f4;
        float f5;
        f4 = this.aYO.mRadius;
        if (f3 >= f4) {
            f5 = this.aYO.mRadius;
            return ((float) Math.cos((((float) com.baidu.tieba.b.c.a.c(i / 15.0d)) * 3.141592653589793d) / 2.0d)) * f5;
        }
        return f3;
    }
}
