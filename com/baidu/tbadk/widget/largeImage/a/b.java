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
    private final RectF baB;
    private final int baC;
    private final int baD;
    private a baG;
    private final Rect baH;
    private final int bax;
    private final RectF baz = new RectF();
    private final Rect baA = new Rect();
    private float baE = 1.0f;
    private final List<a> baF = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.baD = i2;
        this.baC = i;
        this.baB = new RectF(0.0f, 0.0f, i, i2);
        this.baH = new Rect(0, 0, iArr[0], iArr[1]);
        this.bax = i / 2;
    }

    public int getBlockSize() {
        return this.bax;
    }

    public Rect Mm() {
        return this.baH;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.Mk();
    }

    public Point[] Mn() {
        Mp();
        int Ml = Ml();
        int i = (this.baA.top / Ml) / this.bax;
        int i2 = (this.baA.left / Ml) / this.bax;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.baA.bottom / Ml) / this.bax) * Ml) + 1;
        point2.x = (Ml * ((this.baA.right / Ml) / this.bax)) + 1;
        return new Point[]{point, point2};
    }

    public a Mo() {
        return new a(this.bax);
    }

    public Rect Mp() {
        this.mMatrix.mapRect(this.baz, this.baB);
        a(this.baA, this.baz);
        return this.baA;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.baC;
    }

    public int Mq() {
        return this.baD;
    }

    public List<a> Mr() {
        return this.baF;
    }

    public void aa(float f) {
        this.baE = f;
    }

    public float Ms() {
        return this.baE;
    }

    public int Ml() {
        int i = 1;
        while (i < Math.round(this.baE)) {
            i *= 2;
        }
        return i;
    }

    public void j(Bitmap bitmap) {
        if (bitmap != null) {
            this.baG = new a(bitmap);
            this.baG.i(0, 0, this.baC, this.baD);
        }
    }

    public a Mt() {
        return this.baG;
    }

    public void o(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void ab(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void b(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean p(int i, int i2, int i3) {
        if (i3 == Ml()) {
            return q(i, i2, i3).intersect(this.baA);
        }
        return false;
    }

    public Rect q(int i, int i2, int i3) {
        int i4 = this.bax * i3 * i2;
        int i5 = this.bax * i3 * i;
        return new Rect(i4, i5, (this.bax * i3) + i4, (this.bax * i3) + i5);
    }

    public void f(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.baH.right) {
            rect.right = this.baH.right;
        }
        if (rect.bottom > this.baH.bottom) {
            rect.bottom = this.baH.bottom;
        }
    }
}
