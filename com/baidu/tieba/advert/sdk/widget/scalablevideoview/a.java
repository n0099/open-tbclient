package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes17.dex */
public class a {
    private b fst;
    private b fsu;

    public a(b bVar, b bVar2) {
        this.fst = bVar;
        this.fsu = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return bCv();
            case FIT_XY:
                return bCo();
            case FIT_CENTER:
                return bCq();
            case FIT_START:
                return bCp();
            case FIT_END:
                return bCr();
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
                return bCs();
            case CENTER_INSIDE:
                return bCt();
            case END_INSIDE:
                return bCu();
            default:
                return null;
        }
    }

    private Matrix bCo() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix bCp() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix bCq() {
        return a(PivotPoint.CENTER);
    }

    private Matrix bCr() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.fst.getWidth() / this.fsu.getWidth();
        float height = this.fst.getHeight() / this.fsu.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.fsu.getWidth() / this.fst.getWidth(), this.fsu.getHeight() / this.fst.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.fst.getWidth() / this.fsu.getWidth();
        float height = this.fst.getHeight() / this.fsu.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix bCs() {
        return (this.fsu.getHeight() > this.fst.getWidth() || this.fsu.getHeight() > this.fst.getHeight()) ? bCp() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix bCt() {
        return (this.fsu.getHeight() > this.fst.getWidth() || this.fsu.getHeight() > this.fst.getHeight()) ? bCq() : b(PivotPoint.CENTER);
    }

    private Matrix bCu() {
        return (this.fsu.getHeight() > this.fst.getWidth() || this.fsu.getHeight() > this.fst.getHeight()) ? bCr() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix bCv() {
        return a(this.fsu.getWidth() / this.fst.getWidth(), this.fsu.getHeight() / this.fst.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return e(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return e(f, f2, 0.0f, this.fst.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return e(f, f2, 0.0f, this.fst.getHeight());
            case CENTER_TOP:
                return e(f, f2, this.fst.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return e(f, f2, this.fst.getWidth() / 2.0f, this.fst.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return e(f, f2, this.fst.getWidth() / 2.0f, this.fst.getHeight());
            case RIGHT_TOP:
                return e(f, f2, this.fst.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return e(f, f2, this.fst.getWidth(), this.fst.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return e(f, f2, this.fst.getWidth(), this.fst.getHeight());
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
