package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private b eSh;
    private b eSi;

    public a(b bVar, b bVar2) {
        this.eSh = bVar;
        this.eSi = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bnW();
            case FIT_XY:
                return bnP();
            case FIT_CENTER:
                return bnR();
            case FIT_START:
                return bnQ();
            case FIT_END:
                return bnS();
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
                return bnT();
            case CENTER_INSIDE:
                return bnU();
            case END_INSIDE:
                return bnV();
            default:
                return null;
        }
    }

    private Matrix bnP() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bnQ() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bnR() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bnS() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.eSh.getWidth() / this.eSi.getWidth();
        float height = this.eSh.getHeight() / this.eSi.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.eSi.getWidth() / this.eSh.getWidth(), this.eSi.getHeight() / this.eSh.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.eSh.getWidth() / this.eSi.getWidth();
        float height = this.eSh.getHeight() / this.eSi.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bnT() {
        return (this.eSi.getHeight() > this.eSh.getWidth() || this.eSi.getHeight() > this.eSh.getHeight()) ? bnQ() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bnU() {
        return (this.eSi.getHeight() > this.eSh.getWidth() || this.eSi.getHeight() > this.eSh.getHeight()) ? bnR() : b(PivotPoint.CENTER);
    }

    private Matrix bnV() {
        return (this.eSi.getHeight() > this.eSh.getWidth() || this.eSi.getHeight() > this.eSh.getHeight()) ? bnS() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bnW() {
        return a(this.eSi.getWidth() / this.eSh.getWidth(), this.eSi.getHeight() / this.eSh.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.eSh.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.eSh.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.eSh.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.eSh.getWidth() / 2.0f, this.eSh.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.eSh.getWidth() / 2.0f, this.eSh.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.eSh.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.eSh.getWidth(), this.eSh.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.eSh.getWidth(), this.eSh.getHeight());
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
