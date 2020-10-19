package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes23.dex */
public class a {
    private b fHO;
    private b fHP;

    public a(b bVar, b bVar2) {
        this.fHO = bVar;
        this.fHP = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bGt();
            case FIT_XY:
                return bGm();
            case FIT_CENTER:
                return bGo();
            case FIT_START:
                return bGn();
            case FIT_END:
                return bGp();
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
                return bGq();
            case CENTER_INSIDE:
                return bGr();
            case END_INSIDE:
                return bGs();
            default:
                return null;
        }
    }

    private Matrix bGm() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bGn() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bGo() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bGp() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.fHO.getWidth() / this.fHP.getWidth();
        float height = this.fHO.getHeight() / this.fHP.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.fHP.getWidth() / this.fHO.getWidth(), this.fHP.getHeight() / this.fHO.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.fHO.getWidth() / this.fHP.getWidth();
        float height = this.fHO.getHeight() / this.fHP.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bGq() {
        return (this.fHP.getHeight() > this.fHO.getWidth() || this.fHP.getHeight() > this.fHO.getHeight()) ? bGn() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bGr() {
        return (this.fHP.getHeight() > this.fHO.getWidth() || this.fHP.getHeight() > this.fHO.getHeight()) ? bGo() : b(PivotPoint.CENTER);
    }

    private Matrix bGs() {
        return (this.fHP.getHeight() > this.fHO.getWidth() || this.fHP.getHeight() > this.fHO.getHeight()) ? bGp() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bGt() {
        return a(this.fHP.getWidth() / this.fHO.getWidth(), this.fHP.getHeight() / this.fHO.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.fHO.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.fHO.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.fHO.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.fHO.getWidth() / 2.0f, this.fHO.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.fHO.getWidth() / 2.0f, this.fHO.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.fHO.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.fHO.getWidth(), this.fHO.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.fHO.getWidth(), this.fHO.getHeight());
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
