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
    private final int bjV;
    private final RectF bjZ;
    private final int bka;
    private final int bkb;
    private a bke;
    private final Rect bkf;
    private final RectF bjX = new RectF();
    private final Rect bjY = new Rect();
    private float bkc = 1.0f;
    private final List<a> bkd = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.bkb = i2;
        this.bka = i;
        this.bjZ = new RectF(0.0f, 0.0f, i, i2);
        this.bkf = new Rect(0, 0, iArr[0], iArr[1]);
        this.bjV = i / 2;
    }

    public int getBlockSize() {
        return this.bjV;
    }

    public Rect Qb() {
        return this.bkf;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.PZ();
    }

    public Point[] Qc() {
        Qe();
        int Qa = Qa();
        int i = (this.bjY.top / Qa) / this.bjV;
        int i2 = (this.bjY.left / Qa) / this.bjV;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.bjY.bottom / Qa) / this.bjV) * Qa) + 1;
        point2.x = (Qa * ((this.bjY.right / Qa) / this.bjV)) + 1;
        return new Point[]{point, point2};
    }

    public a Qd() {
        return new a(this.bjV);
    }

    public Rect Qe() {
        this.mMatrix.mapRect(this.bjX, this.bjZ);
        a(this.bjY, this.bjX);
        return this.bjY;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.bka;
    }

    public int Qf() {
        return this.bkb;
    }

    public List<a> Qg() {
        return this.bkd;
    }

    public void ac(float f) {
        this.bkc = f;
    }

    public float Qh() {
        return this.bkc;
    }

    public int Qa() {
        int i = 1;
        while (i < Math.round(this.bkc)) {
            i *= 2;
        }
        return i;
    }

    public void k(Bitmap bitmap) {
        if (bitmap != null) {
            this.bke = new a(bitmap);
            this.bke.i(0, 0, this.bka, this.bkb);
        }
    }

    public a Qi() {
        return this.bke;
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
        if (i3 == Qa()) {
            return s(i, i2, i3).intersect(this.bjY);
        }
        return false;
    }

    public Rect s(int i, int i2, int i3) {
        int i4 = this.bjV * i3 * i2;
        int i5 = this.bjV * i3 * i;
        return new Rect(i4, i5, (this.bjV * i3) + i4, (this.bjV * i3) + i5);
    }

    public void g(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bkf.right) {
            rect.right = this.bkf.right;
        }
        if (rect.bottom > this.bkf.bottom) {
            rect.bottom = this.bkf.bottom;
        }
    }
}
