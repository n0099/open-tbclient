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
    private final int aRJ;
    private final RectF aRN;
    private final int aRO;
    private final int aRP;
    private a aRS;
    private final Rect aRT;
    private final RectF aRL = new RectF();
    private final Rect aRM = new Rect();
    private float aRQ = 1.0f;
    private final List<a> aRR = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.aRP = i2;
        this.aRO = i;
        this.aRN = new RectF(0.0f, 0.0f, i, i2);
        this.aRT = new Rect(0, 0, iArr[0], iArr[1]);
        this.aRJ = i / 2;
    }

    public int getBlockSize() {
        return this.aRJ;
    }

    public Rect Iw() {
        return this.aRT;
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
        int i = (this.aRM.top / Iv) / this.aRJ;
        int i2 = (this.aRM.left / Iv) / this.aRJ;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.aRM.bottom / Iv) / this.aRJ) * Iv) + 1;
        point2.x = (Iv * ((this.aRM.right / Iv) / this.aRJ)) + 1;
        return new Point[]{point, point2};
    }

    public a Iy() {
        return new a(this.aRJ);
    }

    public Rect Iz() {
        this.mMatrix.mapRect(this.aRL, this.aRN);
        a(this.aRM, this.aRL);
        return this.aRM;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int IA() {
        return this.aRO;
    }

    public int IB() {
        return this.aRP;
    }

    public List<a> IC() {
        return this.aRR;
    }

    public void G(float f) {
        this.aRQ = f;
    }

    public float ID() {
        return this.aRQ;
    }

    public int Iv() {
        int i = 1;
        while (i < Math.round(this.aRQ)) {
            i *= 2;
        }
        return i;
    }

    public void i(Bitmap bitmap) {
        if (bitmap != null) {
            this.aRS = new a(bitmap);
            this.aRS.j(0, 0, this.aRO, this.aRP);
        }
    }

    public a IE() {
        return this.aRS;
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
            return r(i, i2, i3).intersect(this.aRM);
        }
        return false;
    }

    public Rect r(int i, int i2, int i3) {
        int i4 = this.aRJ * i3 * i2;
        int i5 = this.aRJ * i3 * i;
        return new Rect(i4, i5, (this.aRJ * i3) + i4, (this.aRJ * i3) + i5);
    }

    public void e(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.aRT.right) {
            rect.right = this.aRT.right;
        }
        if (rect.bottom > this.aRT.bottom) {
            rect.bottom = this.aRT.bottom;
        }
    }
}
