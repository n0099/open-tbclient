package com.baidu.tieba;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* loaded from: classes.dex */
public class ac extends Animation {
    private final float aln;
    private final float alo;
    private final float alp;
    private final float alq;
    private final float alr;
    private final boolean als;
    private Camera alt;

    public ac(float f, float f2, float f3, float f4, float f5, boolean z) {
        this.aln = f;
        this.alo = f2;
        this.alp = f3;
        this.alq = f4;
        this.alr = f5;
        this.als = z;
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.alt = new Camera();
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.aln;
        float f3 = f2 + ((this.alo - f2) * f);
        float f4 = this.alp;
        float f5 = this.alq;
        Camera camera = this.alt;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.als) {
            camera.translate(0.0f, 0.0f, this.alr * f);
        } else {
            camera.translate(0.0f, 0.0f, this.alr * (1.0f - f));
        }
        camera.rotateY(f3);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
    }
}
