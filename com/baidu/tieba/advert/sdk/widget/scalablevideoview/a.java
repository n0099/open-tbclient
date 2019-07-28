package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {
    private b daH;
    private b daI;

    public a(b bVar, b bVar2) {
        this.daH = bVar;
        this.daI = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return aEm();
            case FIT_XY:
                return aEf();
            case FIT_CENTER:
                return aEh();
            case FIT_START:
                return aEg();
            case FIT_END:
                return aEi();
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
                return aEj();
            case CENTER_INSIDE:
                return aEk();
            case END_INSIDE:
                return aEl();
            default:
                return null;
        }
    }

    private Matrix aEf() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix aEg() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix aEh() {
        return a(PivotPoint.CENTER);
    }

    private Matrix aEi() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.daH.getWidth() / this.daI.getWidth();
        float height = this.daH.getHeight() / this.daI.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.daI.getWidth() / this.daH.getWidth(), this.daI.getHeight() / this.daH.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.daH.getWidth() / this.daI.getWidth();
        float height = this.daH.getHeight() / this.daI.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix aEj() {
        return (this.daI.getHeight() > this.daH.getWidth() || this.daI.getHeight() > this.daH.getHeight()) ? aEg() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix aEk() {
        return (this.daI.getHeight() > this.daH.getWidth() || this.daI.getHeight() > this.daH.getHeight()) ? aEh() : b(PivotPoint.CENTER);
    }

    private Matrix aEl() {
        return (this.daI.getHeight() > this.daH.getWidth() || this.daI.getHeight() > this.daH.getHeight()) ? aEi() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix aEm() {
        return a(this.daI.getWidth() / this.daH.getWidth(), this.daI.getHeight() / this.daH.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return i(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return i(f, f2, 0.0f, this.daH.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.daH.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.daH.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.daH.getWidth() / 2.0f, this.daH.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.daH.getWidth() / 2.0f, this.daH.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.daH.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.daH.getWidth(), this.daH.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.daH.getWidth(), this.daH.getHeight());
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    private Matrix i(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }
}
