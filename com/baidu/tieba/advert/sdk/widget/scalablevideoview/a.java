package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private b eDx;
    private b eDy;

    public a(b bVar, b bVar2) {
        this.eDx = bVar;
        this.eDy = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bhJ();
            case FIT_XY:
                return bhC();
            case FIT_CENTER:
                return bhE();
            case FIT_START:
                return bhD();
            case FIT_END:
                return bhF();
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
                return bhG();
            case CENTER_INSIDE:
                return bhH();
            case END_INSIDE:
                return bhI();
            default:
                return null;
        }
    }

    private Matrix bhC() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bhD() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bhE() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bhF() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.eDx.getWidth() / this.eDy.getWidth();
        float height = this.eDx.getHeight() / this.eDy.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.eDy.getWidth() / this.eDx.getWidth(), this.eDy.getHeight() / this.eDx.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.eDx.getWidth() / this.eDy.getWidth();
        float height = this.eDx.getHeight() / this.eDy.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bhG() {
        return (this.eDy.getHeight() > this.eDx.getWidth() || this.eDy.getHeight() > this.eDx.getHeight()) ? bhD() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bhH() {
        return (this.eDy.getHeight() > this.eDx.getWidth() || this.eDy.getHeight() > this.eDx.getHeight()) ? bhE() : b(PivotPoint.CENTER);
    }

    private Matrix bhI() {
        return (this.eDy.getHeight() > this.eDx.getWidth() || this.eDy.getHeight() > this.eDx.getHeight()) ? bhF() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bhJ() {
        return a(this.eDy.getWidth() / this.eDx.getWidth(), this.eDy.getHeight() / this.eDx.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.eDx.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.eDx.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.eDx.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.eDx.getWidth() / 2.0f, this.eDx.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.eDx.getWidth() / 2.0f, this.eDx.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.eDx.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.eDx.getWidth(), this.eDx.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.eDx.getWidth(), this.eDx.getHeight());
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
