package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {
    private b dlf;
    private b dlg;

    public a(b bVar, b bVar2) {
        this.dlf = bVar;
        this.dlg = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return aFb();
            case FIT_XY:
                return aEU();
            case FIT_CENTER:
                return aEW();
            case FIT_START:
                return aEV();
            case FIT_END:
                return aEX();
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
                return aEY();
            case CENTER_INSIDE:
                return aEZ();
            case END_INSIDE:
                return aFa();
            default:
                return null;
        }
    }

    private Matrix aEU() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix aEV() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix aEW() {
        return a(PivotPoint.CENTER);
    }

    private Matrix aEX() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.dlf.getWidth() / this.dlg.getWidth();
        float height = this.dlf.getHeight() / this.dlg.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.dlg.getWidth() / this.dlf.getWidth(), this.dlg.getHeight() / this.dlf.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.dlf.getWidth() / this.dlg.getWidth();
        float height = this.dlf.getHeight() / this.dlg.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix aEY() {
        return (this.dlg.getHeight() > this.dlf.getWidth() || this.dlg.getHeight() > this.dlf.getHeight()) ? aEV() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix aEZ() {
        return (this.dlg.getHeight() > this.dlf.getWidth() || this.dlg.getHeight() > this.dlf.getHeight()) ? aEW() : b(PivotPoint.CENTER);
    }

    private Matrix aFa() {
        return (this.dlg.getHeight() > this.dlf.getWidth() || this.dlg.getHeight() > this.dlf.getHeight()) ? aEX() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix aFb() {
        return a(this.dlg.getWidth() / this.dlf.getWidth(), this.dlg.getHeight() / this.dlf.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return h(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return h(f, f2, 0.0f, this.dlf.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return h(f, f2, 0.0f, this.dlf.getHeight());
            case CENTER_TOP:
                return h(f, f2, this.dlf.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return h(f, f2, this.dlf.getWidth() / 2.0f, this.dlf.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return h(f, f2, this.dlf.getWidth() / 2.0f, this.dlf.getHeight());
            case RIGHT_TOP:
                return h(f, f2, this.dlf.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return h(f, f2, this.dlf.getWidth(), this.dlf.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return h(f, f2, this.dlf.getWidth(), this.dlf.getHeight());
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
