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
    private final int bHJ;
    private final RectF bHN;
    private final int bHO;
    private final int bHP;
    private a bHS;
    private final Rect bHT;
    private final RectF bHL = new RectF();
    private final Rect bHM = new Rect();
    private float bHQ = 1.0f;
    private final List<a> bHR = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.bHP = i2;
        this.bHO = i;
        this.bHN = new RectF(0.0f, 0.0f, i, i2);
        this.bHT = new Rect(0, 0, iArr[0], iArr[1]);
        this.bHJ = i / 2;
    }

    public int getBlockSize() {
        return this.bHJ;
    }

    public Rect Qq() {
        return this.bHT;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.Qo();
    }

    public Point[] Qr() {
        Qt();
        int Qp = Qp();
        int i = (this.bHM.top / Qp) / this.bHJ;
        int i2 = (this.bHM.left / Qp) / this.bHJ;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.bHM.bottom / Qp) / this.bHJ) * Qp) + 1;
        point2.x = (Qp * ((this.bHM.right / Qp) / this.bHJ)) + 1;
        return new Point[]{point, point2};
    }

    public a Qs() {
        return new a(this.bHJ);
    }

    public Rect Qt() {
        this.mMatrix.mapRect(this.bHL, this.bHN);
        a(this.bHM, this.bHL);
        return this.bHM;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.bHO;
    }

    public int Qu() {
        return this.bHP;
    }

    public List<a> Qv() {
        return this.bHR;
    }

    public void ac(float f) {
        this.bHQ = f;
    }

    public float Qw() {
        return this.bHQ;
    }

    public int Qp() {
        int i = 1;
        while (i < Math.round(this.bHQ)) {
            i *= 2;
        }
        return i;
    }

    public void n(Bitmap bitmap) {
        if (bitmap != null) {
            this.bHS = new a(bitmap);
            this.bHS.r(0, 0, this.bHO, this.bHP);
        }
    }

    public a Qx() {
        return this.bHS;
    }

    public void o(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void ad(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void f(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean A(int i, int i2, int i3) {
        if (i3 == Qp()) {
            return B(i, i2, i3).intersect(this.bHM);
        }
        return false;
    }

    public Rect B(int i, int i2, int i3) {
        int i4 = this.bHJ * i3 * i2;
        int i5 = this.bHJ * i3 * i;
        return new Rect(i4, i5, (this.bHJ * i3) + i4, (this.bHJ * i3) + i5);
    }

    public void j(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bHT.right) {
            rect.right = this.bHT.right;
        }
        if (rect.bottom > this.bHT.bottom) {
            rect.bottom = this.bHT.bottom;
        }
    }
}
