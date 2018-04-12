package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private final int aSB;
    private final RectF aSF;
    private final int aSG;
    private final int aSH;
    private a aSK;
    private final Rect aSL;
    private final RectF aSD = new RectF();
    private final Rect aSE = new Rect();
    private float aSI = 1.0f;
    private final List<a> aSJ = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.aSH = i2;
        this.aSG = i;
        this.aSF = new RectF(0.0f, 0.0f, i, i2);
        this.aSL = new Rect(0, 0, iArr[0], iArr[1]);
        this.aSB = i / 2;
    }

    public int getBlockSize() {
        return this.aSB;
    }

    public Rect IS() {
        return this.aSL;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.IQ();
    }

    public Point[] IT() {
        IV();
        int IR = IR();
        int i = (this.aSE.top / IR) / this.aSB;
        int i2 = (this.aSE.left / IR) / this.aSB;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.aSE.bottom / IR) / this.aSB) * IR) + 1;
        point2.x = (IR * ((this.aSE.right / IR) / this.aSB)) + 1;
        return new Point[]{point, point2};
    }

    public a IU() {
        return new a(this.aSB);
    }

    public Rect IV() {
        this.mMatrix.mapRect(this.aSD, this.aSF);
        a(this.aSE, this.aSD);
        return this.aSE;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.aSG;
    }

    public int IW() {
        return this.aSH;
    }

    public List<a> IX() {
        return this.aSJ;
    }

    public void Q(float f) {
        this.aSI = f;
    }

    public float IY() {
        return this.aSI;
    }

    public int IR() {
        int i = 1;
        while (i < Math.round(this.aSI)) {
            i *= 2;
        }
        return i;
    }

    public void k(Bitmap bitmap) {
        if (bitmap != null) {
            this.aSK = new a(bitmap);
            this.aSK.i(0, 0, this.aSG, this.aSH);
        }
    }

    public a IZ() {
        return this.aSK;
    }

    public void h(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void R(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void b(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean p(int i, int i2, int i3) {
        if (i3 == IR()) {
            return q(i, i2, i3).intersect(this.aSE);
        }
        return false;
    }

    public Rect q(int i, int i2, int i3) {
        int i4 = this.aSB * i3 * i2;
        int i5 = this.aSB * i3 * i;
        return new Rect(i4, i5, (this.aSB * i3) + i4, (this.aSB * i3) + i5);
    }

    public void f(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.aSL.right) {
            rect.right = this.aSL.right;
        }
        if (rect.bottom > this.aSL.bottom) {
            rect.bottom = this.aSL.bottom;
        }
    }
}
