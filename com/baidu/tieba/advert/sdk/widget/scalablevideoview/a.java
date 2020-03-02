package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class a {
    private b ecY;
    private b ecZ;

    public a(b bVar, b bVar2) {
        this.ecY = bVar;
        this.ecZ = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return aZC();
            case FIT_XY:
                return aZv();
            case FIT_CENTER:
                return aZx();
            case FIT_START:
                return aZw();
            case FIT_END:
                return aZy();
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
                return aZz();
            case CENTER_INSIDE:
                return aZA();
            case END_INSIDE:
                return aZB();
            default:
                return null;
        }
    }

    private Matrix aZv() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix aZw() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix aZx() {
        return a(PivotPoint.CENTER);
    }

    private Matrix aZy() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.ecY.getWidth() / this.ecZ.getWidth();
        float height = this.ecY.getHeight() / this.ecZ.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.ecZ.getWidth() / this.ecY.getWidth(), this.ecZ.getHeight() / this.ecY.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.ecY.getWidth() / this.ecZ.getWidth();
        float height = this.ecY.getHeight() / this.ecZ.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix aZz() {
        return (this.ecZ.getHeight() > this.ecY.getWidth() || this.ecZ.getHeight() > this.ecY.getHeight()) ? aZw() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix aZA() {
        return (this.ecZ.getHeight() > this.ecY.getWidth() || this.ecZ.getHeight() > this.ecY.getHeight()) ? aZx() : b(PivotPoint.CENTER);
    }

    private Matrix aZB() {
        return (this.ecZ.getHeight() > this.ecY.getWidth() || this.ecZ.getHeight() > this.ecY.getHeight()) ? aZy() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix aZC() {
        return a(this.ecZ.getWidth() / this.ecY.getWidth(), this.ecZ.getHeight() / this.ecY.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return h(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return h(f, f2, 0.0f, this.ecY.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return h(f, f2, 0.0f, this.ecY.getHeight());
            case CENTER_TOP:
                return h(f, f2, this.ecY.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return h(f, f2, this.ecY.getWidth() / 2.0f, this.ecY.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return h(f, f2, this.ecY.getWidth() / 2.0f, this.ecY.getHeight());
            case RIGHT_TOP:
                return h(f, f2, this.ecY.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return h(f, f2, this.ecY.getWidth(), this.ecY.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return h(f, f2, this.ecY.getWidth(), this.ecY.getHeight());
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    private Matrix h(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }
}
