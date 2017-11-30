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
    private final int aRG;
    private final RectF aRK;
    private final int aRL;
    private final int aRM;
    private a aRP;
    private final Rect aRQ;
    private final RectF aRI = new RectF();
    private final Rect aRJ = new Rect();
    private float aRN = 1.0f;
    private final List<a> aRO = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.aRM = i2;
        this.aRL = i;
        this.aRK = new RectF(0.0f, 0.0f, i, i2);
        this.aRQ = new Rect(0, 0, iArr[0], iArr[1]);
        this.aRG = i / 2;
    }

    public int getBlockSize() {
        return this.aRG;
    }

    public Rect Iv() {
        return this.aRQ;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.It();
    }

    public Point[] Iw() {
        Iy();
        int Iu = Iu();
        int i = (this.aRJ.top / Iu) / this.aRG;
        int i2 = (this.aRJ.left / Iu) / this.aRG;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.aRJ.bottom / Iu) / this.aRG) * Iu) + 1;
        point2.x = (Iu * ((this.aRJ.right / Iu) / this.aRG)) + 1;
        return new Point[]{point, point2};
    }

    public a Ix() {
        return new a(this.aRG);
    }

    public Rect Iy() {
        this.mMatrix.mapRect(this.aRI, this.aRK);
        a(this.aRJ, this.aRI);
        return this.aRJ;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int Iz() {
        return this.aRL;
    }

    public int IA() {
        return this.aRM;
    }

    public List<a> IB() {
        return this.aRO;
    }

    public void G(float f) {
        this.aRN = f;
    }

    public float IC() {
        return this.aRN;
    }

    public int Iu() {
        int i = 1;
        while (i < Math.round(this.aRN)) {
            i *= 2;
        }
        return i;
    }

    public void i(Bitmap bitmap) {
        if (bitmap != null) {
            this.aRP = new a(bitmap);
            this.aRP.j(0, 0, this.aRL, this.aRM);
        }
    }

    public a ID() {
        return this.aRP;
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
        if (i3 == Iu()) {
            return r(i, i2, i3).intersect(this.aRJ);
        }
        return false;
    }

    public Rect r(int i, int i2, int i3) {
        int i4 = this.aRG * i3 * i2;
        int i5 = this.aRG * i3 * i;
        return new Rect(i4, i5, (this.aRG * i3) + i4, (this.aRG * i3) + i5);
    }

    public void e(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.aRQ.right) {
            rect.right = this.aRQ.right;
        }
        if (rect.bottom > this.aRQ.bottom) {
            rect.bottom = this.aRQ.bottom;
        }
    }
}
