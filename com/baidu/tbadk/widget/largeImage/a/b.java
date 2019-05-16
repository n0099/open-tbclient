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
    private final int cGV;
    private final RectF cGZ;
    private final int cHa;
    private final int cHb;
    private a cHe;
    private final Rect cHf;
    private final RectF cGX = new RectF();
    private final Rect cGY = new Rect();
    private float cHc = 1.0f;
    private final List<a> cHd = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.cHb = i2;
        this.cHa = i;
        this.cGZ = new RectF(0.0f, 0.0f, i, i2);
        this.cHf = new Rect(0, 0, iArr[0], iArr[1]);
        this.cGV = i / 2;
    }

    public int getBlockSize() {
        return this.cGV;
    }

    public Rect awD() {
        return this.cHf;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.awB();
    }

    public Point[] awE() {
        awG();
        int awC = awC();
        int i = (this.cGY.top / awC) / this.cGV;
        int i2 = (this.cGY.left / awC) / this.cGV;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.cGY.bottom / awC) / this.cGV) * awC) + 1;
        point2.x = (awC * ((this.cGY.right / awC) / this.cGV)) + 1;
        return new Point[]{point, point2};
    }

    public a awF() {
        return new a(this.cGV);
    }

    public Rect awG() {
        this.mMatrix.mapRect(this.cGX, this.cGZ);
        a(this.cGY, this.cGX);
        return this.cGY;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.cHa;
    }

    public int awH() {
        return this.cHb;
    }

    public List<a> awI() {
        return this.cHd;
    }

    public void ar(float f) {
        this.cHc = f;
    }

    public float awJ() {
        return this.cHc;
    }

    public int awC() {
        int i = 1;
        while (i < Math.round(this.cHc)) {
            i *= 2;
        }
        return i;
    }

    public void r(Bitmap bitmap) {
        if (bitmap != null) {
            this.cHe = new a(bitmap);
            this.cHe.m(0, 0, this.cHa, this.cHb);
        }
    }

    public a awK() {
        return this.cHe;
    }

    public void u(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void as(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void b(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean v(int i, int i2, int i3) {
        if (i3 == awC()) {
            return w(i, i2, i3).intersect(this.cGY);
        }
        return false;
    }

    public Rect w(int i, int i2, int i3) {
        int i4 = this.cGV * i3 * i2;
        int i5 = this.cGV * i3 * i;
        return new Rect(i4, i5, (this.cGV * i3) + i4, (this.cGV * i3) + i5);
    }

    public void h(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.cHf.right) {
            rect.right = this.cHf.right;
        }
        if (rect.bottom > this.cHf.bottom) {
            rect.bottom = this.cHf.bottom;
        }
    }
}
