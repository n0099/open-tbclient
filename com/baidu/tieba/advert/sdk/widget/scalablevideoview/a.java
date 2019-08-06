package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {
    private b daO;
    private b daP;

    public a(b bVar, b bVar2) {
        this.daO = bVar;
        this.daP = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return aEo();
            case FIT_XY:
                return aEh();
            case FIT_CENTER:
                return aEj();
            case FIT_START:
                return aEi();
            case FIT_END:
                return aEk();
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
                return aEl();
            case CENTER_INSIDE:
                return aEm();
            case END_INSIDE:
                return aEn();
            default:
                return null;
        }
    }

    private Matrix aEh() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix aEi() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix aEj() {
        return a(PivotPoint.CENTER);
    }

    private Matrix aEk() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.daO.getWidth() / this.daP.getWidth();
        float height = this.daO.getHeight() / this.daP.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.daP.getWidth() / this.daO.getWidth(), this.daP.getHeight() / this.daO.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.daO.getWidth() / this.daP.getWidth();
        float height = this.daO.getHeight() / this.daP.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix aEl() {
        return (this.daP.getHeight() > this.daO.getWidth() || this.daP.getHeight() > this.daO.getHeight()) ? aEi() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix aEm() {
        return (this.daP.getHeight() > this.daO.getWidth() || this.daP.getHeight() > this.daO.getHeight()) ? aEj() : b(PivotPoint.CENTER);
    }

    private Matrix aEn() {
        return (this.daP.getHeight() > this.daO.getWidth() || this.daP.getHeight() > this.daO.getHeight()) ? aEk() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix aEo() {
        return a(this.daP.getWidth() / this.daO.getWidth(), this.daP.getHeight() / this.daO.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return i(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return i(f, f2, 0.0f, this.daO.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.daO.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.daO.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.daO.getWidth() / 2.0f, this.daO.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.daO.getWidth() / 2.0f, this.daO.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.daO.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.daO.getWidth(), this.daO.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.daO.getWidth(), this.daO.getHeight());
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    private Matrix i(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }
}
