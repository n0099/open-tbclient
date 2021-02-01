package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes8.dex */
public class a {
    private b glj;
    private b glk;

    public a(b bVar, b bVar2) {
        this.glj = bVar;
        this.glk = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bMQ();
            case FIT_XY:
                return bMJ();
            case FIT_CENTER:
                return bML();
            case FIT_START:
                return bMK();
            case FIT_END:
                return bMM();
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
                return bMN();
            case CENTER_INSIDE:
                return bMO();
            case END_INSIDE:
                return bMP();
            default:
                return null;
        }
    }

    private Matrix bMJ() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bMK() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bML() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bMM() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.glj.getWidth() / this.glk.getWidth();
        float height = this.glj.getHeight() / this.glk.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.glk.getWidth() / this.glj.getWidth(), this.glk.getHeight() / this.glj.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.glj.getWidth() / this.glk.getWidth();
        float height = this.glj.getHeight() / this.glk.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bMN() {
        return (this.glk.getHeight() > this.glj.getWidth() || this.glk.getHeight() > this.glj.getHeight()) ? bMK() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bMO() {
        return (this.glk.getHeight() > this.glj.getWidth() || this.glk.getHeight() > this.glj.getHeight()) ? bML() : b(PivotPoint.CENTER);
    }

    private Matrix bMP() {
        return (this.glk.getHeight() > this.glj.getWidth() || this.glk.getHeight() > this.glj.getHeight()) ? bMM() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bMQ() {
        return a(this.glk.getWidth() / this.glj.getWidth(), this.glk.getHeight() / this.glj.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.glj.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.glj.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.glj.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.glj.getWidth() / 2.0f, this.glj.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.glj.getWidth() / 2.0f, this.glj.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.glj.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.glj.getWidth(), this.glj.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.glj.getWidth(), this.glj.getHeight());
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
