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
    private final int aOA;
    private a aOD;
    private final Rect aOE;
    private final int aOu;
    private final RectF aOy;
    private final int aOz;
    private final RectF aOw = new RectF();
    private final Rect aOx = new Rect();
    private float aOB = 1.0f;
    private final List<a> aOC = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.aOA = i2;
        this.aOz = i;
        this.aOy = new RectF(0.0f, 0.0f, i, i2);
        this.aOE = new Rect(0, 0, iArr[0], iArr[1]);
        this.aOu = i / 2;
    }

    public int getBlockSize() {
        return this.aOu;
    }

    public Rect HF() {
        return this.aOE;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.HD();
    }

    public Point[] HG() {
        HI();
        int HE = HE();
        int i = (this.aOx.top / HE) / this.aOu;
        int i2 = (this.aOx.left / HE) / this.aOu;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.aOx.bottom / HE) / this.aOu) * HE) + 1;
        point2.x = (HE * ((this.aOx.right / HE) / this.aOu)) + 1;
        return new Point[]{point, point2};
    }

    public a HH() {
        return new a(this.aOu);
    }

    public Rect HI() {
        this.mMatrix.mapRect(this.aOw, this.aOy);
        a(this.aOx, this.aOw);
        return this.aOx;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int HJ() {
        return this.aOz;
    }

    public int HK() {
        return this.aOA;
    }

    public List<a> HL() {
        return this.aOC;
    }

    public void G(float f) {
        this.aOB = f;
    }

    public float HM() {
        return this.aOB;
    }

    public int HE() {
        int i = 1;
        while (i < Math.round(this.aOB)) {
            i *= 2;
        }
        return i;
    }

    public void i(Bitmap bitmap) {
        if (bitmap != null) {
            this.aOD = new a(bitmap);
            this.aOD.j(0, 0, this.aOz, this.aOA);
        }
    }

    public a HN() {
        return this.aOD;
    }

    public void e(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void H(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void a(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean q(int i, int i2, int i3) {
        if (i3 == HE()) {
            return r(i, i2, i3).intersect(this.aOx);
        }
        return false;
    }

    public Rect r(int i, int i2, int i3) {
        int i4 = this.aOu * i3 * i2;
        int i5 = this.aOu * i3 * i;
        return new Rect(i4, i5, (this.aOu * i3) + i4, (this.aOu * i3) + i5);
    }

    public void e(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.aOE.right) {
            rect.right = this.aOE.right;
        }
        if (rect.bottom > this.aOE.bottom) {
            rect.bottom = this.aOE.bottom;
        }
    }
}
