package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes22.dex */
public class a {
    private b fVG;
    private b fVH;

    public a(b bVar, b bVar2) {
        this.fVG = bVar;
        this.fVH = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bKe();
            case FIT_XY:
                return bJX();
            case FIT_CENTER:
                return bJZ();
            case FIT_START:
                return bJY();
            case FIT_END:
                return bKa();
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
                return bKb();
            case CENTER_INSIDE:
                return bKc();
            case END_INSIDE:
                return bKd();
            default:
                return null;
        }
    }

    private Matrix bJX() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bJY() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bJZ() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bKa() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.fVG.getWidth() / this.fVH.getWidth();
        float height = this.fVG.getHeight() / this.fVH.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.fVH.getWidth() / this.fVG.getWidth(), this.fVH.getHeight() / this.fVG.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.fVG.getWidth() / this.fVH.getWidth();
        float height = this.fVG.getHeight() / this.fVH.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bKb() {
        return (this.fVH.getHeight() > this.fVG.getWidth() || this.fVH.getHeight() > this.fVG.getHeight()) ? bJY() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bKc() {
        return (this.fVH.getHeight() > this.fVG.getWidth() || this.fVH.getHeight() > this.fVG.getHeight()) ? bJZ() : b(PivotPoint.CENTER);
    }

    private Matrix bKd() {
        return (this.fVH.getHeight() > this.fVG.getWidth() || this.fVH.getHeight() > this.fVG.getHeight()) ? bKa() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bKe() {
        return a(this.fVH.getWidth() / this.fVG.getWidth(), this.fVH.getHeight() / this.fVG.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.fVG.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.fVG.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.fVG.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.fVG.getWidth() / 2.0f, this.fVG.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.fVG.getWidth() / 2.0f, this.fVG.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.fVG.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.fVG.getWidth(), this.fVG.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.fVG.getWidth(), this.fVG.getHeight());
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
