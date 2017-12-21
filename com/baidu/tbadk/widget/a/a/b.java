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
    private final int aRM;
    private final RectF aRQ;
    private final int aRR;
    private final int aRS;
    private a aRV;
    private final Rect aRW;
    private final RectF aRO = new RectF();
    private final Rect aRP = new Rect();
    private float aRT = 1.0f;
    private final List<a> aRU = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.aRS = i2;
        this.aRR = i;
        this.aRQ = new RectF(0.0f, 0.0f, i, i2);
        this.aRW = new Rect(0, 0, iArr[0], iArr[1]);
        this.aRM = i / 2;
    }

    public int getBlockSize() {
        return this.aRM;
    }

    public Rect Iw() {
        return this.aRW;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.Iu();
    }

    public Point[] Ix() {
        Iz();
        int Iv = Iv();
        int i = (this.aRP.top / Iv) / this.aRM;
        int i2 = (this.aRP.left / Iv) / this.aRM;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.aRP.bottom / Iv) / this.aRM) * Iv) + 1;
        point2.x = (Iv * ((this.aRP.right / Iv) / this.aRM)) + 1;
        return new Point[]{point, point2};
    }

    public a Iy() {
        return new a(this.aRM);
    }

    public Rect Iz() {
        this.mMatrix.mapRect(this.aRO, this.aRQ);
        a(this.aRP, this.aRO);
        return this.aRP;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int IA() {
        return this.aRR;
    }

    public int IB() {
        return this.aRS;
    }

    public List<a> IC() {
        return this.aRU;
    }

    public void G(float f) {
        this.aRT = f;
    }

    public float ID() {
        return this.aRT;
    }

    public int Iv() {
        int i = 1;
        while (i < Math.round(this.aRT)) {
            i *= 2;
        }
        return i;
    }

    public void i(Bitmap bitmap) {
        if (bitmap != null) {
            this.aRV = new a(bitmap);
            this.aRV.j(0, 0, this.aRR, this.aRS);
        }
    }

    public a IE() {
        return this.aRV;
    }

    public void g(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void H(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void a(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean q(int i, int i2, int i3) {
        if (i3 == Iv()) {
            return r(i, i2, i3).intersect(this.aRP);
        }
        return false;
    }

    public Rect r(int i, int i2, int i3) {
        int i4 = this.aRM * i3 * i2;
        int i5 = this.aRM * i3 * i;
        return new Rect(i4, i5, (this.aRM * i3) + i4, (this.aRM * i3) + i5);
    }

    public void e(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.aRW.right) {
            rect.right = this.aRW.right;
        }
        if (rect.bottom > this.aRW.bottom) {
            rect.bottom = this.aRW.bottom;
        }
    }
}
