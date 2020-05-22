package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private b eRW;
    private b eRX;

    public a(b bVar, b bVar2) {
        this.eRW = bVar;
        this.eRX = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bnU();
            case FIT_XY:
                return bnN();
            case FIT_CENTER:
                return bnP();
            case FIT_START:
                return bnO();
            case FIT_END:
                return bnQ();
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
                return bnR();
            case CENTER_INSIDE:
                return bnS();
            case END_INSIDE:
                return bnT();
            default:
                return null;
        }
    }

    private Matrix bnN() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bnO() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bnP() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bnQ() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.eRW.getWidth() / this.eRX.getWidth();
        float height = this.eRW.getHeight() / this.eRX.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.eRX.getWidth() / this.eRW.getWidth(), this.eRX.getHeight() / this.eRW.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.eRW.getWidth() / this.eRX.getWidth();
        float height = this.eRW.getHeight() / this.eRX.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bnR() {
        return (this.eRX.getHeight() > this.eRW.getWidth() || this.eRX.getHeight() > this.eRW.getHeight()) ? bnO() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bnS() {
        return (this.eRX.getHeight() > this.eRW.getWidth() || this.eRX.getHeight() > this.eRW.getHeight()) ? bnP() : b(PivotPoint.CENTER);
    }

    private Matrix bnT() {
        return (this.eRX.getHeight() > this.eRW.getWidth() || this.eRX.getHeight() > this.eRW.getHeight()) ? bnQ() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bnU() {
        return a(this.eRX.getWidth() / this.eRW.getWidth(), this.eRX.getHeight() / this.eRW.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.eRW.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.eRW.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.eRW.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.eRW.getWidth() / 2.0f, this.eRW.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.eRW.getWidth() / 2.0f, this.eRW.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.eRW.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.eRW.getWidth(), this.eRW.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.eRW.getWidth(), this.eRW.getHeight());
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
