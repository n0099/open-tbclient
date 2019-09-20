package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {
    private b dcB;
    private b dcC;

    public a(b bVar, b bVar2) {
        this.dcB = bVar;
        this.dcC = bVar2;
    }

    public Matrix a(ScalableType scalableType) {
        switch (scalableType) {
            case NONE:
                return aES();
            case FIT_XY:
                return aEL();
            case FIT_CENTER:
                return aEN();
            case FIT_START:
                return aEM();
            case FIT_END:
                return aEO();
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
                return aEP();
            case CENTER_INSIDE:
                return aEQ();
            case END_INSIDE:
                return aER();
            default:
                return null;
        }
    }

    private Matrix aEL() {
        return a(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix aEM() {
        return a(PivotPoint.LEFT_TOP);
    }

    private Matrix aEN() {
        return a(PivotPoint.CENTER);
    }

    private Matrix aEO() {
        return a(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix a(PivotPoint pivotPoint) {
        float width = this.dcB.getWidth() / this.dcC.getWidth();
        float height = this.dcB.getHeight() / this.dcC.getHeight();
        float min = Math.min(width, height);
        return a(min / width, min / height, pivotPoint);
    }

    private Matrix b(PivotPoint pivotPoint) {
        return a(this.dcC.getWidth() / this.dcB.getWidth(), this.dcC.getHeight() / this.dcB.getHeight(), pivotPoint);
    }

    private Matrix c(PivotPoint pivotPoint) {
        float width = this.dcB.getWidth() / this.dcC.getWidth();
        float height = this.dcB.getHeight() / this.dcC.getHeight();
        float max = Math.max(width, height);
        return a(max / width, max / height, pivotPoint);
    }

    private Matrix aEP() {
        return (this.dcC.getHeight() > this.dcB.getWidth() || this.dcC.getHeight() > this.dcB.getHeight()) ? aEM() : b(PivotPoint.LEFT_TOP);
    }

    private Matrix aEQ() {
        return (this.dcC.getHeight() > this.dcB.getWidth() || this.dcC.getHeight() > this.dcB.getHeight()) ? aEN() : b(PivotPoint.CENTER);
    }

    private Matrix aER() {
        return (this.dcC.getHeight() > this.dcB.getWidth() || this.dcC.getHeight() > this.dcB.getHeight()) ? aEO() : b(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix aES() {
        return a(this.dcC.getWidth() / this.dcB.getWidth(), this.dcC.getHeight() / this.dcB.getHeight(), PivotPoint.LEFT_TOP);
    }

    private Matrix a(float f, float f2, PivotPoint pivotPoint) {
        switch (pivotPoint) {
            case LEFT_TOP:
                return i(f, f2, 0.0f, 0.0f);
            case LEFT_CENTER:
                return i(f, f2, 0.0f, this.dcB.getHeight() / 2.0f);
            case LEFT_BOTTOM:
                return i(f, f2, 0.0f, this.dcB.getHeight());
            case CENTER_TOP:
                return i(f, f2, this.dcB.getWidth() / 2.0f, 0.0f);
            case CENTER:
                return i(f, f2, this.dcB.getWidth() / 2.0f, this.dcB.getHeight() / 2.0f);
            case CENTER_BOTTOM:
                return i(f, f2, this.dcB.getWidth() / 2.0f, this.dcB.getHeight());
            case RIGHT_TOP:
                return i(f, f2, this.dcB.getWidth(), 0.0f);
            case RIGHT_CENTER:
                return i(f, f2, this.dcB.getWidth(), this.dcB.getHeight() / 2.0f);
            case RIGHT_BOTTOM:
                return i(f, f2, this.dcB.getWidth(), this.dcB.getHeight());
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
