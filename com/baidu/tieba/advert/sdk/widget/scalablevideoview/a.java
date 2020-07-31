package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes17.dex */
public class a {
    private b fgU;
    private b fgV;

    public a(b bVar, b bVar2) {
        this.fgU = bVar;
        this.fgV = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return btz();
            case FIT_XY:
                return bts();
            case FIT_CENTER:
                return btu();
            case FIT_START:
                return btt();
            case FIT_END:
                return btv();
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
                return btw();
            case CENTER_INSIDE:
                return btx();
            case END_INSIDE:
                return bty();
            default:
                return null;
        }
    }

    private Matrix bts() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix btt() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix btu() {
        return a(PivotPoint.CENTER);
    }

    private Matrix btv() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.fgU.getWidth() / this.fgV.getWidth();
        float height = this.fgU.getHeight() / this.fgV.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.fgV.getWidth() / this.fgU.getWidth(), this.fgV.getHeight() / this.fgU.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.fgU.getWidth() / this.fgV.getWidth();
        float height = this.fgU.getHeight() / this.fgV.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix btw() {
        return (this.fgV.getHeight() > this.fgU.getWidth() || this.fgV.getHeight() > this.fgU.getHeight()) ? btt() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix btx() {
        return (this.fgV.getHeight() > this.fgU.getWidth() || this.fgV.getHeight() > this.fgU.getHeight()) ? btu() : b(PivotPoint.CENTER);
    }

    private Matrix bty() {
        return (this.fgV.getHeight() > this.fgU.getWidth() || this.fgV.getHeight() > this.fgU.getHeight()) ? btv() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix btz() {
        return a(this.fgV.getWidth() / this.fgU.getWidth(), this.fgV.getHeight() / this.fgU.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.fgU.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.fgU.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.fgU.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.fgU.getWidth() / 2.0f, this.fgU.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.fgU.getWidth() / 2.0f, this.fgU.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.fgU.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.fgU.getWidth(), this.fgU.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.fgU.getWidth(), this.fgU.getHeight());
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
