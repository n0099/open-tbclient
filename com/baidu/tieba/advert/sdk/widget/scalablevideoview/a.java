package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes22.dex */
public class a {
    private b fvF;
    private b fvG;

    public a(b bVar, b bVar2) {
        this.fvF = bVar;
        this.fvG = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bDH();
            case FIT_XY:
                return bDA();
            case FIT_CENTER:
                return bDC();
            case FIT_START:
                return bDB();
            case FIT_END:
                return bDD();
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
                return bDE();
            case CENTER_INSIDE:
                return bDF();
            case END_INSIDE:
                return bDG();
            default:
                return null;
        }
    }

    private Matrix bDA() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bDB() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bDC() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bDD() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.fvF.getWidth() / this.fvG.getWidth();
        float height = this.fvF.getHeight() / this.fvG.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.fvG.getWidth() / this.fvF.getWidth(), this.fvG.getHeight() / this.fvF.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.fvF.getWidth() / this.fvG.getWidth();
        float height = this.fvF.getHeight() / this.fvG.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bDE() {
        return (this.fvG.getHeight() > this.fvF.getWidth() || this.fvG.getHeight() > this.fvF.getHeight()) ? bDB() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bDF() {
        return (this.fvG.getHeight() > this.fvF.getWidth() || this.fvG.getHeight() > this.fvF.getHeight()) ? bDC() : b(PivotPoint.CENTER);
    }

    private Matrix bDG() {
        return (this.fvG.getHeight() > this.fvF.getWidth() || this.fvG.getHeight() > this.fvF.getHeight()) ? bDD() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bDH() {
        return a(this.fvG.getWidth() / this.fvF.getWidth(), this.fvG.getHeight() / this.fvF.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.fvF.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.fvF.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.fvF.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.fvF.getWidth() / 2.0f, this.fvF.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.fvF.getWidth() / 2.0f, this.fvF.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.fvF.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.fvF.getWidth(), this.fvF.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.fvF.getWidth(), this.fvF.getHeight());
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
