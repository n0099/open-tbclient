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
    private final int bHT;
    private final RectF bHX;
    private final int bHY;
    private final int bHZ;
    private a bIc;
    private final Rect bId;
    private final RectF bHV = new RectF();
    private final Rect bHW = new Rect();
    private float bIa = 1.0f;
    private final List<a> bIb = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.bHZ = i2;
        this.bHY = i;
        this.bHX = new RectF(0.0f, 0.0f, i, i2);
        this.bId = new Rect(0, 0, iArr[0], iArr[1]);
        this.bHT = i / 2;
    }

    public int getBlockSize() {
        return this.bHT;
    }

    public Rect Qq() {
        return this.bId;
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
        int i = (this.bHW.top / Qp) / this.bHT;
        int i2 = (this.bHW.left / Qp) / this.bHT;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.bHW.bottom / Qp) / this.bHT) * Qp) + 1;
        point2.x = (Qp * ((this.bHW.right / Qp) / this.bHT)) + 1;
        return new Point[]{point, point2};
    }

    public a Qs() {
        return new a(this.bHT);
    }

    public Rect Qt() {
        this.mMatrix.mapRect(this.bHV, this.bHX);
        a(this.bHW, this.bHV);
        return this.bHW;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.bHY;
    }

    public int Qu() {
        return this.bHZ;
    }

    public List<a> Qv() {
        return this.bIb;
    }

    public void ac(float f) {
        this.bIa = f;
    }

    public float Qw() {
        return this.bIa;
    }

    public int Qp() {
        int i = 1;
        while (i < Math.round(this.bIa)) {
            i *= 2;
        }
        return i;
    }

    public void n(Bitmap bitmap) {
        if (bitmap != null) {
            this.bIc = new a(bitmap);
            this.bIc.r(0, 0, this.bHY, this.bHZ);
        }
    }

    public a Qx() {
        return this.bIc;
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
            return B(i, i2, i3).intersect(this.bHW);
        }
        return false;
    }

    public Rect B(int i, int i2, int i3) {
        int i4 = this.bHT * i3 * i2;
        int i5 = this.bHT * i3 * i;
        return new Rect(i4, i5, (this.bHT * i3) + i4, (this.bHT * i3) + i5);
    }

    public void j(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bId.right) {
            rect.right = this.bId.right;
        }
        if (rect.bottom > this.bId.bottom) {
            rect.bottom = this.bId.bottom;
        }
    }
}
