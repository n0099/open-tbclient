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
    private final int bFP;
    private final RectF bFT;
    private final int bFU;
    private final int bFV;
    private a bFY;
    private final Rect bFZ;
    private final RectF bFR = new RectF();
    private final Rect bFS = new Rect();
    private float bFW = 1.0f;
    private final List<a> bFX = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.bFV = i2;
        this.bFU = i;
        this.bFT = new RectF(0.0f, 0.0f, i, i2);
        this.bFZ = new Rect(0, 0, iArr[0], iArr[1]);
        this.bFP = i / 2;
    }

    public int getBlockSize() {
        return this.bFP;
    }

    public Rect PL() {
        return this.bFZ;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.PJ();
    }

    public Point[] PM() {
        PO();
        int PK = PK();
        int i = (this.bFS.top / PK) / this.bFP;
        int i2 = (this.bFS.left / PK) / this.bFP;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.bFS.bottom / PK) / this.bFP) * PK) + 1;
        point2.x = (PK * ((this.bFS.right / PK) / this.bFP)) + 1;
        return new Point[]{point, point2};
    }

    public a PN() {
        return new a(this.bFP);
    }

    public Rect PO() {
        this.mMatrix.mapRect(this.bFR, this.bFT);
        a(this.bFS, this.bFR);
        return this.bFS;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.bFU;
    }

    public int PP() {
        return this.bFV;
    }

    public List<a> PQ() {
        return this.bFX;
    }

    public void W(float f) {
        this.bFW = f;
    }

    public float PR() {
        return this.bFW;
    }

    public int PK() {
        int i = 1;
        while (i < Math.round(this.bFW)) {
            i *= 2;
        }
        return i;
    }

    public void l(Bitmap bitmap) {
        if (bitmap != null) {
            this.bFY = new a(bitmap);
            this.bFY.r(0, 0, this.bFU, this.bFV);
        }
    }

    public a PS() {
        return this.bFY;
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
        if (i3 == PK()) {
            return A(i, i2, i3).intersect(this.bFS);
        }
        return false;
    }

    public Rect A(int i, int i2, int i3) {
        int i4 = this.bFP * i3 * i2;
        int i5 = this.bFP * i3 * i;
        return new Rect(i4, i5, (this.bFP * i3) + i4, (this.bFP * i3) + i5);
    }

    public void i(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bFZ.right) {
            rect.right = this.bFZ.right;
        }
        if (rect.bottom > this.bFZ.bottom) {
            rect.bottom = this.bFZ.bottom;
        }
    }
}
