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
    private final int cGW;
    private final RectF cHa;
    private final int cHb;
    private final int cHc;
    private a cHf;
    private final Rect cHg;
    private final RectF cGY = new RectF();
    private final Rect cGZ = new Rect();
    private float cHd = 1.0f;
    private final List<a> cHe = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.cHc = i2;
        this.cHb = i;
        this.cHa = new RectF(0.0f, 0.0f, i, i2);
        this.cHg = new Rect(0, 0, iArr[0], iArr[1]);
        this.cGW = i / 2;
    }

    public int getBlockSize() {
        return this.cGW;
    }

    public Rect awE() {
        return this.cHg;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.awC();
    }

    public Point[] awF() {
        awH();
        int awD = awD();
        int i = (this.cGZ.top / awD) / this.cGW;
        int i2 = (this.cGZ.left / awD) / this.cGW;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.cGZ.bottom / awD) / this.cGW) * awD) + 1;
        point2.x = (awD * ((this.cGZ.right / awD) / this.cGW)) + 1;
        return new Point[]{point, point2};
    }

    public a awG() {
        return new a(this.cGW);
    }

    public Rect awH() {
        this.mMatrix.mapRect(this.cGY, this.cHa);
        a(this.cGZ, this.cGY);
        return this.cGZ;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.cHb;
    }

    public int awI() {
        return this.cHc;
    }

    public List<a> awJ() {
        return this.cHe;
    }

    public void ar(float f) {
        this.cHd = f;
    }

    public float awK() {
        return this.cHd;
    }

    public int awD() {
        int i = 1;
        while (i < Math.round(this.cHd)) {
            i *= 2;
        }
        return i;
    }

    public void r(Bitmap bitmap) {
        if (bitmap != null) {
            this.cHf = new a(bitmap);
            this.cHf.m(0, 0, this.cHb, this.cHc);
        }
    }

    public a awL() {
        return this.cHf;
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
        if (i3 == awD()) {
            return w(i, i2, i3).intersect(this.cGZ);
        }
        return false;
    }

    public Rect w(int i, int i2, int i3) {
        int i4 = this.cGW * i3 * i2;
        int i5 = this.cGW * i3 * i;
        return new Rect(i4, i5, (this.cGW * i3) + i4, (this.cGW * i3) + i5);
    }

    public void h(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.cHg.right) {
            rect.right = this.cHg.right;
        }
        if (rect.bottom > this.cHg.bottom) {
            rect.bottom = this.cHg.bottom;
        }
    }
}
