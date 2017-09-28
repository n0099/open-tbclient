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
    private final int aOH;
    private final RectF aOL;
    private final int aOM;
    private final int aON;
    private a aOQ;
    private final Rect aOR;
    private final RectF aOJ = new RectF();
    private final Rect aOK = new Rect();
    private float aOO = 1.0f;
    private final List<a> aOP = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.aON = i2;
        this.aOM = i;
        this.aOL = new RectF(0.0f, 0.0f, i, i2);
        this.aOR = new Rect(0, 0, iArr[0], iArr[1]);
        this.aOH = i / 2;
    }

    public int getBlockSize() {
        return this.aOH;
    }

    public Rect HL() {
        return this.aOR;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.HJ();
    }

    public Point[] HM() {
        HO();
        int HK = HK();
        int i = (this.aOK.top / HK) / this.aOH;
        int i2 = (this.aOK.left / HK) / this.aOH;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.aOK.bottom / HK) / this.aOH) * HK) + 1;
        point2.x = (HK * ((this.aOK.right / HK) / this.aOH)) + 1;
        return new Point[]{point, point2};
    }

    public a HN() {
        return new a(this.aOH);
    }

    public Rect HO() {
        this.mMatrix.mapRect(this.aOJ, this.aOL);
        a(this.aOK, this.aOJ);
        return this.aOK;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int HP() {
        return this.aOM;
    }

    public int HQ() {
        return this.aON;
    }

    public List<a> HR() {
        return this.aOP;
    }

    public void G(float f) {
        this.aOO = f;
    }

    public float HS() {
        return this.aOO;
    }

    public int HK() {
        int i = 1;
        while (i < Math.round(this.aOO)) {
            i *= 2;
        }
        return i;
    }

    public void i(Bitmap bitmap) {
        if (bitmap != null) {
            this.aOQ = new a(bitmap);
            this.aOQ.j(0, 0, this.aOM, this.aON);
        }
    }

    public a HT() {
        return this.aOQ;
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
        if (i3 == HK()) {
            return r(i, i2, i3).intersect(this.aOK);
        }
        return false;
    }

    public Rect r(int i, int i2, int i3) {
        int i4 = this.aOH * i3 * i2;
        int i5 = this.aOH * i3 * i;
        return new Rect(i4, i5, (this.aOH * i3) + i4, (this.aOH * i3) + i5);
    }

    public void e(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.aOR.right) {
            rect.right = this.aOR.right;
        }
        if (rect.bottom > this.aOR.bottom) {
            rect.bottom = this.aOR.bottom;
        }
    }
}
