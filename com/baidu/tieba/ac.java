package com.baidu.tieba;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* loaded from: classes.dex */
public class ac extends Animation {
    private final float alj;
    private final float alk;
    private final float alm;
    private final float aln;
    private final float alo;
    private final boolean alp;
    private Camera alq;

    public ac(float f, float f2, float f3, float f4, float f5, boolean z) {
        this.alj = f;
        this.alk = f2;
        this.alm = f3;
        this.aln = f4;
        this.alo = f5;
        this.alp = z;
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.alq = new Camera();
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.alj;
        float f3 = f2 + ((this.alk - f2) * f);
        float f4 = this.alm;
        float f5 = this.aln;
        Camera camera = this.alq;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.alp) {
            camera.translate(0.0f, 0.0f, this.alo * f);
        } else {
            camera.translate(0.0f, 0.0f, this.alo * (1.0f - f));
        }
        camera.rotateY(f3);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
    }
}
