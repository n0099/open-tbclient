package com.baidu.tbadk.widget.a.a;

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
    private final int aOJ;
    private final RectF aON;
    private final int aOO;
    private final int aOP;
    private a aOS;
    private final Rect aOT;
    private final RectF aOL = new RectF();
    private final Rect aOM = new Rect();
    private float aOQ = 1.0f;
    private final List<a> aOR = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.aOP = i2;
        this.aOO = i;
        this.aON = new RectF(0.0f, 0.0f, i, i2);
        this.aOT = new Rect(0, 0, iArr[0], iArr[1]);
        this.aOJ = i / 2;
    }

    public int getBlockSize() {
        return this.aOJ;
    }

    public Rect HY() {
        return this.aOT;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.HW();
    }

    public Point[] HZ() {
        Ib();
        int HX = HX();
        int i = (this.aOM.top / HX) / this.aOJ;
        int i2 = (this.aOM.left / HX) / this.aOJ;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.aOM.bottom / HX) / this.aOJ) * HX) + 1;
        point2.x = (HX * ((this.aOM.right / HX) / this.aOJ)) + 1;
        return new Point[]{point, point2};
    }

    public a Ia() {
        return new a(this.aOJ);
    }

    public Rect Ib() {
        this.mMatrix.mapRect(this.aOL, this.aON);
        a(this.aOM, this.aOL);
        return this.aOM;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int Ic() {
        return this.aOO;
    }

    public int Id() {
        return this.aOP;
    }

    public List<a> Ie() {
        return this.aOR;
    }

    public void F(float f) {
        this.aOQ = f;
    }

    public float If() {
        return this.aOQ;
    }

    public int HX() {
        int i = 1;
        while (i < Math.round(this.aOQ)) {
            i *= 2;
        }
        return i;
    }

    public void i(Bitmap bitmap) {
        if (bitmap != null) {
            this.aOS = new a(bitmap);
            this.aOS.j(0, 0, this.aOO, this.aOP);
        }
    }

    public a Ig() {
        return this.aOS;
    }

    public void f(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void G(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void a(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean p(int i, int i2, int i3) {
        if (i3 == HX()) {
            return q(i, i2, i3).intersect(this.aOM);
        }
        return false;
    }

    public Rect q(int i, int i2, int i3) {
        int i4 = this.aOJ * i3 * i2;
        int i5 = this.aOJ * i3 * i;
        return new Rect(i4, i5, (this.aOJ * i3) + i4, (this.aOJ * i3) + i5);
    }

    public void e(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.aOT.right) {
            rect.right = this.aOT.right;
        }
        if (rect.bottom > this.aOT.bottom) {
            rect.bottom = this.aOT.bottom;
        }
    }
}
