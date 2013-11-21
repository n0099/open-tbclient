package com.baidu.tieba.home;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* loaded from: classes.dex */
public class bn extends Animation {

    /* renamed from: a  reason: collision with root package name */
    private Camera f1423a = new Camera();
    private View b;

    public bn(View view) {
        this.b = view;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        int width = this.b.getWidth() / 2;
        int height = this.b.getHeight() / 2;
        Matrix matrix = transformation.getMatrix();
        this.f1423a.save();
        this.f1423a.translate(0.0f, 0.0f, (-150.0f) * (1.0f - f));
        this.f1423a.getMatrix(matrix);
        this.f1423a.restore();
        matrix.preTranslate(-width, -height);
        matrix.postTranslate(width, height);
    }
}
