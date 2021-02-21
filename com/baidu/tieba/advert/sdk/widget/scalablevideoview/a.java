package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes8.dex */
public class a {
    private b glx;
    private b gly;

    public a(b bVar, b bVar2) {
        this.glx = bVar;
        this.gly = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bMX();
            case FIT_XY:
                return bMQ();
            case FIT_CENTER:
                return bMS();
            case FIT_START:
                return bMR();
            case FIT_END:
                return bMT();
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
                return bMU();
            case CENTER_INSIDE:
                return bMV();
            case END_INSIDE:
                return bMW();
            default:
                return null;
        }
    }

    private Matrix bMQ() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bMR() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bMS() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bMT() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.glx.getWidth() / this.gly.getWidth();
        float height = this.glx.getHeight() / this.gly.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.gly.getWidth() / this.glx.getWidth(), this.gly.getHeight() / this.glx.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.glx.getWidth() / this.gly.getWidth();
        float height = this.glx.getHeight() / this.gly.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bMU() {
        return (this.gly.getHeight() > this.glx.getWidth() || this.gly.getHeight() > this.glx.getHeight()) ? bMR() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bMV() {
        return (this.gly.getHeight() > this.glx.getWidth() || this.gly.getHeight() > this.glx.getHeight()) ? bMS() : b(PivotPoint.CENTER);
    }

    private Matrix bMW() {
        return (this.gly.getHeight() > this.glx.getWidth() || this.gly.getHeight() > this.glx.getHeight()) ? bMT() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bMX() {
        return a(this.gly.getWidth() / this.glx.getWidth(), this.gly.getHeight() / this.glx.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.glx.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.glx.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.glx.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.glx.getWidth() / 2.0f, this.glx.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.glx.getWidth() / 2.0f, this.glx.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.glx.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.glx.getWidth(), this.glx.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.glx.getWidth(), this.glx.getHeight());
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
