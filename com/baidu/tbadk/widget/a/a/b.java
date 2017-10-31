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
    private final int aOB;
    private final RectF aOF;
    private final int aOG;
    private final int aOH;
    private a aOK;
    private final Rect aOL;
    private final RectF aOD = new RectF();
    private final Rect aOE = new Rect();
    private float aOI = 1.0f;
    private final List<a> aOJ = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.aOH = i2;
        this.aOG = i;
        this.aOF = new RectF(0.0f, 0.0f, i, i2);
        this.aOL = new Rect(0, 0, iArr[0], iArr[1]);
        this.aOB = i / 2;
    }

    public int getBlockSize() {
        return this.aOB;
    }

    public Rect HN() {
        return this.aOL;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.HL();
    }

    public Point[] HO() {
        HQ();
        int HM = HM();
        int i = (this.aOE.top / HM) / this.aOB;
        int i2 = (this.aOE.left / HM) / this.aOB;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.aOE.bottom / HM) / this.aOB) * HM) + 1;
        point2.x = (HM * ((this.aOE.right / HM) / this.aOB)) + 1;
        return new Point[]{point, point2};
    }

    public a HP() {
        return new a(this.aOB);
    }

    public Rect HQ() {
        this.mMatrix.mapRect(this.aOD, this.aOF);
        a(this.aOE, this.aOD);
        return this.aOE;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int HR() {
        return this.aOG;
    }

    public int HS() {
        return this.aOH;
    }

    public List<a> HT() {
        return this.aOJ;
    }

    public void F(float f) {
        this.aOI = f;
    }

    public float HU() {
        return this.aOI;
    }

    public int HM() {
        int i = 1;
        while (i < Math.round(this.aOI)) {
            i *= 2;
        }
        return i;
    }

    public void i(Bitmap bitmap) {
        if (bitmap != null) {
            this.aOK = new a(bitmap);
            this.aOK.j(0, 0, this.aOG, this.aOH);
        }
    }

    public a HV() {
        return this.aOK;
    }

    public void f(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void G(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void a(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean p(int i, int i2, int i3) {
        if (i3 == HM()) {
            return q(i, i2, i3).intersect(this.aOE);
        }
        return false;
    }

    public Rect q(int i, int i2, int i3) {
        int i4 = this.aOB * i3 * i2;
        int i5 = this.aOB * i3 * i;
        return new Rect(i4, i5, (this.aOB * i3) + i4, (this.aOB * i3) + i5);
    }

    public void e(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.aOL.right) {
            rect.right = this.aOL.right;
        }
        if (rect.bottom > this.aOL.bottom) {
            rect.bottom = this.aOL.bottom;
        }
    }
}
