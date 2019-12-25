package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes7.dex */
public class a {
    private b dYK;
    private b dYL;

    public a(b bVar, b bVar2) {
        this.dYK = bVar;
        this.dYL = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return aWR();
            case FIT_XY:
                return aWK();
            case FIT_CENTER:
                return aWM();
            case FIT_START:
                return aWL();
            case FIT_END:
                return aWN();
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
                return aWO();
            case CENTER_INSIDE:
                return aWP();
            case END_INSIDE:
                return aWQ();
            default:
                return null;
        }
    }

    private Matrix aWK() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix aWL() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix aWM() {
        return a(PivotPoint.CENTER);
    }

    private Matrix aWN() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.dYK.getWidth() / this.dYL.getWidth();
        float height = this.dYK.getHeight() / this.dYL.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.dYL.getWidth() / this.dYK.getWidth(), this.dYL.getHeight() / this.dYK.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.dYK.getWidth() / this.dYL.getWidth();
        float height = this.dYK.getHeight() / this.dYL.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix aWO() {
        return (this.dYL.getHeight() > this.dYK.getWidth() || this.dYL.getHeight() > this.dYK.getHeight()) ? aWL() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix aWP() {
        return (this.dYL.getHeight() > this.dYK.getWidth() || this.dYL.getHeight() > this.dYK.getHeight()) ? aWM() : b(PivotPoint.CENTER);
    }

    private Matrix aWQ() {
        return (this.dYL.getHeight() > this.dYK.getWidth() || this.dYL.getHeight() > this.dYK.getHeight()) ? aWN() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix aWR() {
        return a(this.dYL.getWidth() / this.dYK.getWidth(), this.dYL.getHeight() / this.dYK.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return h(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return h(f, f2, 0.0f, this.dYK.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return h(f, f2, 0.0f, this.dYK.getHeight());
            case CENTER_TOP:
                return h(f, f2, this.dYK.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return h(f, f2, this.dYK.getWidth() / 2.0f, this.dYK.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return h(f, f2, this.dYK.getWidth() / 2.0f, this.dYK.getHeight());
            case RIGHT_TOP:
                return h(f, f2, this.dYK.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return h(f, f2, this.dYK.getWidth(), this.dYK.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return h(f, f2, this.dYK.getWidth(), this.dYK.getHeight());
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
