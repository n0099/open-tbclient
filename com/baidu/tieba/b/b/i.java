package com.baidu.tieba.b.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.b.a.c {
    final /* synthetic */ g bin;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bin = gVar;
    }

    @Override // com.baidu.tieba.b.a.a
    public boolean b(float f, float f2, float f3, int i) {
        return this.bin.bhZ >= 0.0f || ((double) i) > 15.0d;
    }

    @Override // com.baidu.tieba.b.a.a
    public void d(float f, float f2, float f3, int i) {
    }

    @Override // com.baidu.tieba.b.a.c
    public float g(float f, float f2, float f3, int i) {
        float f4;
        float f5;
        double sin = Math.sin((((float) com.baidu.tieba.b.c.a.d(i / 15.0d)) * 3.141592653589793d) / 2.0d);
        f4 = this.bin.mRadius;
        double abs = sin * Math.abs(f4);
        f5 = this.bin.mRadius;
        return (float) (abs - Math.abs(f5));
    }

    @Override // com.baidu.tieba.b.a.c
    public float h(float f, float f2, float f3, int i) {
        float f4;
        float f5;
        f4 = this.bin.mRadius;
        if (f3 >= f4) {
            f5 = this.bin.mRadius;
            return ((float) Math.cos((((float) com.baidu.tieba.b.c.a.d(i / 15.0d)) * 3.141592653589793d) / 2.0d)) * f5;
        }
        return f3;
    }
}
