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
    private final int bHG;
    private final RectF bHK;
    private final int bHL;
    private final int bHM;
    private a bHP;
    private final Rect bHQ;
    private final RectF bHI = new RectF();
    private final Rect bHJ = new Rect();
    private float bHN = 1.0f;
    private final List<a> bHO = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.bHM = i2;
        this.bHL = i;
        this.bHK = new RectF(0.0f, 0.0f, i, i2);
        this.bHQ = new Rect(0, 0, iArr[0], iArr[1]);
        this.bHG = i / 2;
    }

    public int getBlockSize() {
        return this.bHG;
    }

    public Rect Qp() {
        return this.bHQ;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.Qn();
    }

    public Point[] Qq() {
        Qs();
        int Qo = Qo();
        int i = (this.bHJ.top / Qo) / this.bHG;
        int i2 = (this.bHJ.left / Qo) / this.bHG;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.bHJ.bottom / Qo) / this.bHG) * Qo) + 1;
        point2.x = (Qo * ((this.bHJ.right / Qo) / this.bHG)) + 1;
        return new Point[]{point, point2};
    }

    public a Qr() {
        return new a(this.bHG);
    }

    public Rect Qs() {
        this.mMatrix.mapRect(this.bHI, this.bHK);
        a(this.bHJ, this.bHI);
        return this.bHJ;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.bHL;
    }

    public int Qt() {
        return this.bHM;
    }

    public List<a> Qu() {
        return this.bHO;
    }

    public void ac(float f) {
        this.bHN = f;
    }

    public float Qv() {
        return this.bHN;
    }

    public int Qo() {
        int i = 1;
        while (i < Math.round(this.bHN)) {
            i *= 2;
        }
        return i;
    }

    public void n(Bitmap bitmap) {
        if (bitmap != null) {
            this.bHP = new a(bitmap);
            this.bHP.r(0, 0, this.bHL, this.bHM);
        }
    }

    public a Qw() {
        return this.bHP;
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
        if (i3 == Qo()) {
            return B(i, i2, i3).intersect(this.bHJ);
        }
        return false;
    }

    public Rect B(int i, int i2, int i3) {
        int i4 = this.bHG * i3 * i2;
        int i5 = this.bHG * i3 * i;
        return new Rect(i4, i5, (this.bHG * i3) + i4, (this.bHG * i3) + i5);
    }

    public void j(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bHQ.right) {
            rect.right = this.bHQ.right;
        }
        if (rect.bottom > this.bHQ.bottom) {
            rect.bottom = this.bHQ.bottom;
        }
    }
}
