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
    private a bnC;
    private final Rect bnD;
    private final int bnt;
    private final RectF bnx;
    private final int bny;
    private final int bnz;
    private final RectF bnv = new RectF();
    private final Rect bnw = new Rect();
    private float bnA = 1.0f;
    private final List<a> bnB = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.bnz = i2;
        this.bny = i;
        this.bnx = new RectF(0.0f, 0.0f, i, i2);
        this.bnD = new Rect(0, 0, iArr[0], iArr[1]);
        this.bnt = i / 2;
    }

    public int getBlockSize() {
        return this.bnt;
    }

    public Rect Rh() {
        return this.bnD;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.Rf();
    }

    public Point[] Ri() {
        Rk();
        int Rg = Rg();
        int i = (this.bnw.top / Rg) / this.bnt;
        int i2 = (this.bnw.left / Rg) / this.bnt;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.bnw.bottom / Rg) / this.bnt) * Rg) + 1;
        point2.x = (Rg * ((this.bnw.right / Rg) / this.bnt)) + 1;
        return new Point[]{point, point2};
    }

    public a Rj() {
        return new a(this.bnt);
    }

    public Rect Rk() {
        this.mMatrix.mapRect(this.bnv, this.bnx);
        a(this.bnw, this.bnv);
        return this.bnw;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.bny;
    }

    public int Rl() {
        return this.bnz;
    }

    public List<a> Rm() {
        return this.bnB;
    }

    public void ac(float f) {
        this.bnA = f;
    }

    public float Rn() {
        return this.bnA;
    }

    public int Rg() {
        int i = 1;
        while (i < Math.round(this.bnA)) {
            i *= 2;
        }
        return i;
    }

    public void k(Bitmap bitmap) {
        if (bitmap != null) {
            this.bnC = new a(bitmap);
            this.bnC.i(0, 0, this.bny, this.bnz);
        }
    }

    public a Ro() {
        return this.bnC;
    }

    public void r(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void ad(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void b(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean r(int i, int i2, int i3) {
        if (i3 == Rg()) {
            return s(i, i2, i3).intersect(this.bnw);
        }
        return false;
    }

    public Rect s(int i, int i2, int i3) {
        int i4 = this.bnt * i3 * i2;
        int i5 = this.bnt * i3 * i;
        return new Rect(i4, i5, (this.bnt * i3) + i4, (this.bnt * i3) + i5);
    }

    public void g(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bnD.right) {
            rect.right = this.bnD.right;
        }
        if (rect.bottom > this.bnD.bottom) {
            rect.bottom = this.bnD.bottom;
        }
    }
}
