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
    private final RectF bFD;
    private final int bFE;
    private final int bFF;
    private a bFI;
    private final Rect bFJ;
    private final int bFz;
    private final RectF bFB = new RectF();
    private final Rect bFC = new Rect();
    private float bFG = 1.0f;
    private final List<a> bFH = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.bFF = i2;
        this.bFE = i;
        this.bFD = new RectF(0.0f, 0.0f, i, i2);
        this.bFJ = new Rect(0, 0, iArr[0], iArr[1]);
        this.bFz = i / 2;
    }

    public int getBlockSize() {
        return this.bFz;
    }

    public Rect PV() {
        return this.bFJ;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.PT();
    }

    public Point[] PW() {
        PY();
        int PU = PU();
        int i = (this.bFC.top / PU) / this.bFz;
        int i2 = (this.bFC.left / PU) / this.bFz;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.bFC.bottom / PU) / this.bFz) * PU) + 1;
        point2.x = (PU * ((this.bFC.right / PU) / this.bFz)) + 1;
        return new Point[]{point, point2};
    }

    public a PX() {
        return new a(this.bFz);
    }

    public Rect PY() {
        this.mMatrix.mapRect(this.bFB, this.bFD);
        a(this.bFC, this.bFB);
        return this.bFC;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.bFE;
    }

    public int PZ() {
        return this.bFF;
    }

    public List<a> Qa() {
        return this.bFH;
    }

    public void W(float f) {
        this.bFG = f;
    }

    public float Qb() {
        return this.bFG;
    }

    public int PU() {
        int i = 1;
        while (i < Math.round(this.bFG)) {
            i *= 2;
        }
        return i;
    }

    public void l(Bitmap bitmap) {
        if (bitmap != null) {
            this.bFI = new a(bitmap);
            this.bFI.r(0, 0, this.bFE, this.bFF);
        }
    }

    public a Qc() {
        return this.bFI;
    }

    public void o(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void X(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void e(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean z(int i, int i2, int i3) {
        if (i3 == PU()) {
            return A(i, i2, i3).intersect(this.bFC);
        }
        return false;
    }

    public Rect A(int i, int i2, int i3) {
        int i4 = this.bFz * i3 * i2;
        int i5 = this.bFz * i3 * i;
        return new Rect(i4, i5, (this.bFz * i3) + i4, (this.bFz * i3) + i5);
    }

    public void i(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bFJ.right) {
            rect.right = this.bFJ.right;
        }
        if (rect.bottom > this.bFJ.bottom) {
            rect.bottom = this.bFJ.bottom;
        }
    }
}
