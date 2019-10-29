package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {
    private b dlW;
    private b dlX;

    public a(b bVar, b bVar2) {
        this.dlW = bVar;
        this.dlX = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return aFd();
            case FIT_XY:
                return aEW();
            case FIT_CENTER:
                return aEY();
            case FIT_START:
                return aEX();
            case FIT_END:
                return aEZ();
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
                return aFa();
            case CENTER_INSIDE:
                return aFb();
            case END_INSIDE:
                return aFc();
            default:
                return null;
        }
    }

    private Matrix aEW() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix aEX() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix aEY() {
        return a(PivotPoint.CENTER);
    }

    private Matrix aEZ() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.dlW.getWidth() / this.dlX.getWidth();
        float height = this.dlW.getHeight() / this.dlX.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.dlX.getWidth() / this.dlW.getWidth(), this.dlX.getHeight() / this.dlW.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.dlW.getWidth() / this.dlX.getWidth();
        float height = this.dlW.getHeight() / this.dlX.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix aFa() {
        return (this.dlX.getHeight() > this.dlW.getWidth() || this.dlX.getHeight() > this.dlW.getHeight()) ? aEX() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix aFb() {
        return (this.dlX.getHeight() > this.dlW.getWidth() || this.dlX.getHeight() > this.dlW.getHeight()) ? aEY() : b(PivotPoint.CENTER);
    }

    private Matrix aFc() {
        return (this.dlX.getHeight() > this.dlW.getWidth() || this.dlX.getHeight() > this.dlW.getHeight()) ? aEZ() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix aFd() {
        return a(this.dlX.getWidth() / this.dlW.getWidth(), this.dlX.getHeight() / this.dlW.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return h(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return h(f, f2, 0.0f, this.dlW.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return h(f, f2, 0.0f, this.dlW.getHeight());
            case CENTER_TOP:
                return h(f, f2, this.dlW.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return h(f, f2, this.dlW.getWidth() / 2.0f, this.dlW.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return h(f, f2, this.dlW.getWidth() / 2.0f, this.dlW.getHeight());
            case RIGHT_TOP:
                return h(f, f2, this.dlW.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return h(f, f2, this.dlW.getWidth(), this.dlW.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return h(f, f2, this.dlW.getWidth(), this.dlW.getHeight());
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    private Matrix h(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }
}
