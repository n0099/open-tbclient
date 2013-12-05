package com.baidu.tieba.home;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* loaded from: classes.dex */
public class bi extends Animation {

    /* renamed from: a  reason: collision with root package name */
    private Camera f1473a = new Camera();
    private View b;

    public bi(View view) {
        this.b = view;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        int width = this.b.getWidth() / 2;
        int height = this.b.getHeight() / 2;
        Matrix matrix = transformation.getMatrix();
        this.f1473a.save();
        this.f1473a.translate(0.0f, 0.0f, (-150.0f) * (1.0f - f));
        this.f1473a.getMatrix(matrix);
        this.f1473a.restore();
        matrix.preTranslate(-width, -height);
        matrix.postTranslate(width, height);
    }
}
