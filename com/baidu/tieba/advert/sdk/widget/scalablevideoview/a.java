package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes23.dex */
public class a {
    private b fVZ;
    private b fWa;

    public a(b bVar, b bVar2) {
        this.fVZ = bVar;
        this.fWa = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bKL();
            case FIT_XY:
                return bKE();
            case FIT_CENTER:
                return bKG();
            case FIT_START:
                return bKF();
            case FIT_END:
                return bKH();
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
                return bKI();
            case CENTER_INSIDE:
                return bKJ();
            case END_INSIDE:
                return bKK();
            default:
                return null;
        }
    }

    private Matrix bKE() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bKF() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bKG() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bKH() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.fVZ.getWidth() / this.fWa.getWidth();
        float height = this.fVZ.getHeight() / this.fWa.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.fWa.getWidth() / this.fVZ.getWidth(), this.fWa.getHeight() / this.fVZ.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.fVZ.getWidth() / this.fWa.getWidth();
        float height = this.fVZ.getHeight() / this.fWa.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bKI() {
        return (this.fWa.getHeight() > this.fVZ.getWidth() || this.fWa.getHeight() > this.fVZ.getHeight()) ? bKF() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bKJ() {
        return (this.fWa.getHeight() > this.fVZ.getWidth() || this.fWa.getHeight() > this.fVZ.getHeight()) ? bKG() : b(PivotPoint.CENTER);
    }

    private Matrix bKK() {
        return (this.fWa.getHeight() > this.fVZ.getWidth() || this.fWa.getHeight() > this.fVZ.getHeight()) ? bKH() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bKL() {
        return a(this.fWa.getWidth() / this.fVZ.getWidth(), this.fWa.getHeight() / this.fVZ.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.fVZ.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.fVZ.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.fVZ.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.fVZ.getWidth() / 2.0f, this.fVZ.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.fVZ.getWidth() / 2.0f, this.fVZ.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.fVZ.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.fVZ.getWidth(), this.fVZ.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.fVZ.getWidth(), this.fVZ.getHeight());
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
