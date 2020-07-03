package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private b fcs;
    private b fct;

    public a(b bVar, b bVar2) {
        this.fcs = bVar;
        this.fct = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bqw();
            case FIT_XY:
                return bqp();
            case FIT_CENTER:
                return bqr();
            case FIT_START:
                return bqq();
            case FIT_END:
                return bqs();
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
                return bqt();
            case CENTER_INSIDE:
                return bqu();
            case END_INSIDE:
                return bqv();
            default:
                return null;
        }
    }

    private Matrix bqp() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bqq() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bqr() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bqs() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.fcs.getWidth() / this.fct.getWidth();
        float height = this.fcs.getHeight() / this.fct.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.fct.getWidth() / this.fcs.getWidth(), this.fct.getHeight() / this.fcs.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.fcs.getWidth() / this.fct.getWidth();
        float height = this.fcs.getHeight() / this.fct.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bqt() {
        return (this.fct.getHeight() > this.fcs.getWidth() || this.fct.getHeight() > this.fcs.getHeight()) ? bqq() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bqu() {
        return (this.fct.getHeight() > this.fcs.getWidth() || this.fct.getHeight() > this.fcs.getHeight()) ? bqr() : b(PivotPoint.CENTER);
    }

    private Matrix bqv() {
        return (this.fct.getHeight() > this.fcs.getWidth() || this.fct.getHeight() > this.fcs.getHeight()) ? bqs() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bqw() {
        return a(this.fct.getWidth() / this.fcs.getWidth(), this.fct.getHeight() / this.fcs.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.fcs.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.fcs.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.fcs.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.fcs.getWidth() / 2.0f, this.fcs.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.fcs.getWidth() / 2.0f, this.fcs.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.fcs.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.fcs.getWidth(), this.fcs.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.fcs.getWidth(), this.fcs.getHeight());
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
