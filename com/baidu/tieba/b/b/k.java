package com.baidu.tieba.b.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.b.a.c {
    final /* synthetic */ g bsK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.bsK = gVar;
    }

    @Override // com.baidu.tieba.b.a.a
    public boolean b(float f, float f2, float f3, int i) {
        float f4;
        float f5 = this.bsK.bsy;
        f4 = this.bsK.mRadius;
        return f5 < f4 || ((double) i) > 15.0d;
    }

    @Override // com.baidu.tieba.b.a.a
    public void d(float f, float f2, float f3, int i) {
    }

    @Override // com.baidu.tieba.b.a.c
    public float g(float f, float f2, float f3, int i) {
        float f4;
        float f5;
        double sin = Math.sin((((float) com.baidu.tieba.b.c.a.e((15.0d - i) / 15.0d)) * 3.141592653589793d) / 2.0d);
        f4 = this.bsK.mRadius;
        double abs = sin * Math.abs(f4);
        f5 = this.bsK.mRadius;
        return (float) (abs - Math.abs(f5));
    }

    @Override // com.baidu.tieba.b.a.c
    public float h(float f, float f2, float f3, int i) {
        float f4;
        float f5;
        f4 = this.bsK.mRadius;
        if (f3 >= f4) {
            f5 = this.bsK.mRadius;
            return ((float) Math.cos((((float) com.baidu.tieba.b.c.a.e((15.0d - i) / 15.0d)) * 3.141592653589793d) / 2.0d)) * f5;
        }
        return f3;
    }
}
