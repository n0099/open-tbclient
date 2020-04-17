package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private b eDs;
    private b eDt;

    public a(b bVar, b bVar2) {
        this.eDs = bVar;
        this.eDt = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bhL();
            case FIT_XY:
                return bhE();
            case FIT_CENTER:
                return bhG();
            case FIT_START:
                return bhF();
            case FIT_END:
                return bhH();
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
                return bhI();
            case CENTER_INSIDE:
                return bhJ();
            case END_INSIDE:
                return bhK();
            default:
                return null;
        }
    }

    private Matrix bhE() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bhF() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bhG() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bhH() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.eDs.getWidth() / this.eDt.getWidth();
        float height = this.eDs.getHeight() / this.eDt.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.eDt.getWidth() / this.eDs.getWidth(), this.eDt.getHeight() / this.eDs.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.eDs.getWidth() / this.eDt.getWidth();
        float height = this.eDs.getHeight() / this.eDt.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bhI() {
        return (this.eDt.getHeight() > this.eDs.getWidth() || this.eDt.getHeight() > this.eDs.getHeight()) ? bhF() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bhJ() {
        return (this.eDt.getHeight() > this.eDs.getWidth() || this.eDt.getHeight() > this.eDs.getHeight()) ? bhG() : b(PivotPoint.CENTER);
    }

    private Matrix bhK() {
        return (this.eDt.getHeight() > this.eDs.getWidth() || this.eDt.getHeight() > this.eDs.getHeight()) ? bhH() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bhL() {
        return a(this.eDt.getWidth() / this.eDs.getWidth(), this.eDt.getHeight() / this.eDs.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.eDs.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.eDs.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.eDs.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.eDs.getWidth() / 2.0f, this.eDs.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.eDs.getWidth() / 2.0f, this.eDs.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.eDs.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.eDs.getWidth(), this.eDs.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.eDs.getWidth(), this.eDs.getHeight());
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
