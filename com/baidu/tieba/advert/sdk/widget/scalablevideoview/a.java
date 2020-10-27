package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes23.dex */
public class a {
    private b fQj;
    private b fQk;

    public a(b bVar, b bVar2) {
        this.fQj = bVar;
        this.fQk = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bIm();
            case FIT_XY:
                return bIf();
            case FIT_CENTER:
                return bIh();
            case FIT_START:
                return bIg();
            case FIT_END:
                return bIi();
            case LEFT_TOP:
                return b(PivotPoint.LEFT_TOP);
            case LEFT_CENTER:
                return b(PivotPoint.LEFT_CENTER);
            case LEFT_BOTTOM:
                return b(PivotPoint.LEFT_BOTTOM);
            case CENTER_TOP:
                return b(PivotPoint.CENTER_TOP);
            case CENTER:
                return b(PivotPoint.CENTER);
            case CENTER_BOTTOM:
                return b(PivotPoint.CENTER_BOTTOM);
            case RIGHT_TOP:
                return b(PivotPoint.RIGHT_TOP);
            case RIGHT_CENTER:
                return b(PivotPoint.RIGHT_CENTER);
            case RIGHT_BOTTOM:
                return b(PivotPoint.RIGHT_BOTTOM);
            case LEFT_TOP_CROP:
                return c(PivotPoint.LEFT_TOP);
            case LEFT_CENTER_CROP:
                return c(PivotPoint.LEFT_CENTER);
            case LEFT_BOTTOM_CROP:
                return c(PivotPoint.LEFT_BOTTOM);
            case CENTER_TOP_CROP:
                return c(PivotPoint.CENTER_TOP);
            case CENTER_CROP:
                return c(PivotPoint.CENTER);
            case CENTER_BOTTOM_CROP:
                return c(PivotPoint.CENTER_BOTTOM);
            case RIGHT_TOP_CROP:
                return c(PivotPoint.RIGHT_TOP);
            case RIGHT_CENTER_CROP:
                return c(PivotPoint.RIGHT_CENTER);
            case RIGHT_BOTTOM_CROP:
                return c(PivotPoint.RIGHT_BOTTOM);
            case START_INSIDE:
                return bIj();
            case CENTER_INSIDE:
                return bIk();
            case END_INSIDE:
                return bIl();
            default:
                return null;
        }
    }

    private Matrix bIf() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bIg() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bIh() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bIi() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.fQj.getWidth() / this.fQk.getWidth();
        float height = this.fQj.getHeight() / this.fQk.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.fQk.getWidth() / this.fQj.getWidth(), this.fQk.getHeight() / this.fQj.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.fQj.getWidth() / this.fQk.getWidth();
        float height = this.fQj.getHeight() / this.fQk.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bIj() {
        return (this.fQk.getHeight() > this.fQj.getWidth() || this.fQk.getHeight() > this.fQj.getHeight()) ? bIg() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bIk() {
        return (this.fQk.getHeight() > this.fQj.getWidth() || this.fQk.getHeight() > this.fQj.getHeight()) ? bIh() : b(PivotPoint.CENTER);
    }

    private Matrix bIl() {
        return (this.fQk.getHeight() > this.fQj.getWidth() || this.fQk.getHeight() > this.fQj.getHeight()) ? bIi() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bIm() {
        return a(this.fQk.getWidth() / this.fQj.getWidth(), this.fQk.getHeight() / this.fQj.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.fQj.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.fQj.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.fQj.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.fQj.getWidth() / 2.0f, this.fQj.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.fQj.getWidth() / 2.0f, this.fQj.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.fQj.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.fQj.getWidth(), this.fQj.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.fQj.getWidth(), this.fQj.getHeight());
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    private Matrix e(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }
}
