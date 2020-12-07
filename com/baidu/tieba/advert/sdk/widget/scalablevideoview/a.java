package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes23.dex */
public class a {
    private b gdQ;
    private b gdR;

    public a(b bVar, b bVar2) {
        this.gdQ = bVar;
        this.gdR = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bNM();
            case FIT_XY:
                return bNF();
            case FIT_CENTER:
                return bNH();
            case FIT_START:
                return bNG();
            case FIT_END:
                return bNI();
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
                return bNJ();
            case CENTER_INSIDE:
                return bNK();
            case END_INSIDE:
                return bNL();
            default:
                return null;
        }
    }

    private Matrix bNF() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bNG() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bNH() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bNI() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.gdQ.getWidth() / this.gdR.getWidth();
        float height = this.gdQ.getHeight() / this.gdR.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.gdR.getWidth() / this.gdQ.getWidth(), this.gdR.getHeight() / this.gdQ.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.gdQ.getWidth() / this.gdR.getWidth();
        float height = this.gdQ.getHeight() / this.gdR.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bNJ() {
        return (this.gdR.getHeight() > this.gdQ.getWidth() || this.gdR.getHeight() > this.gdQ.getHeight()) ? bNG() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bNK() {
        return (this.gdR.getHeight() > this.gdQ.getWidth() || this.gdR.getHeight() > this.gdQ.getHeight()) ? bNH() : b(PivotPoint.CENTER);
    }

    private Matrix bNL() {
        return (this.gdR.getHeight() > this.gdQ.getWidth() || this.gdR.getHeight() > this.gdQ.getHeight()) ? bNI() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bNM() {
        return a(this.gdR.getWidth() / this.gdQ.getWidth(), this.gdR.getHeight() / this.gdQ.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.gdQ.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.gdQ.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.gdQ.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.gdQ.getWidth() / 2.0f, this.gdQ.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.gdQ.getWidth() / 2.0f, this.gdQ.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.gdQ.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.gdQ.getWidth(), this.gdQ.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.gdQ.getWidth(), this.gdQ.getHeight());
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
