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
    private final int bjk;
    private final RectF bjo;
    private final int bjp;
    private final int bjq;
    private a bjt;
    private final Rect bju;
    private final RectF bjm = new RectF();
    private final Rect bjn = new Rect();
    private float bjr = 1.0f;
    private final List<a> bjs = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.bjq = i2;
        this.bjp = i;
        this.bjo = new RectF(0.0f, 0.0f, i, i2);
        this.bju = new Rect(0, 0, iArr[0], iArr[1]);
        this.bjk = i / 2;
    }

    public int getBlockSize() {
        return this.bjk;
    }

    public Rect PS() {
        return this.bju;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.PQ();
    }

    public Point[] PT() {
        PV();
        int PR = PR();
        int i = (this.bjn.top / PR) / this.bjk;
        int i2 = (this.bjn.left / PR) / this.bjk;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.bjn.bottom / PR) / this.bjk) * PR) + 1;
        point2.x = (PR * ((this.bjn.right / PR) / this.bjk)) + 1;
        return new Point[]{point, point2};
    }

    public a PU() {
        return new a(this.bjk);
    }

    public Rect PV() {
        this.mMatrix.mapRect(this.bjm, this.bjo);
        a(this.bjn, this.bjm);
        return this.bjn;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.bjp;
    }

    public int PW() {
        return this.bjq;
    }

    public List<a> PX() {
        return this.bjs;
    }

    public void ac(float f) {
        this.bjr = f;
    }

    public float PY() {
        return this.bjr;
    }

    public int PR() {
        int i = 1;
        while (i < Math.round(this.bjr)) {
            i *= 2;
        }
        return i;
    }

    public void k(Bitmap bitmap) {
        if (bitmap != null) {
            this.bjt = new a(bitmap);
            this.bjt.i(0, 0, this.bjp, this.bjq);
        }
    }

    public a PZ() {
        return this.bjt;
    }

    public void o(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void ad(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void b(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean r(int i, int i2, int i3) {
        if (i3 == PR()) {
            return s(i, i2, i3).intersect(this.bjn);
        }
        return false;
    }

    public Rect s(int i, int i2, int i3) {
        int i4 = this.bjk * i3 * i2;
        int i5 = this.bjk * i3 * i;
        return new Rect(i4, i5, (this.bjk * i3) + i4, (this.bjk * i3) + i5);
    }

    public void g(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bju.right) {
            rect.right = this.bju.right;
        }
        if (rect.bottom > this.bju.bottom) {
            rect.bottom = this.bju.bottom;
        }
    }
}
