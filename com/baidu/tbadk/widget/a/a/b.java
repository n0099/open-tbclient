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
    private final int bFH;
    private final RectF bFL;
    private final int bFM;
    private final int bFN;
    private a bFQ;
    private final Rect bFR;
    private final RectF bFJ = new RectF();
    private final Rect bFK = new Rect();
    private float bFO = 1.0f;
    private final List<a> bFP = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.bFN = i2;
        this.bFM = i;
        this.bFL = new RectF(0.0f, 0.0f, i, i2);
        this.bFR = new Rect(0, 0, iArr[0], iArr[1]);
        this.bFH = i / 2;
    }

    public int getBlockSize() {
        return this.bFH;
    }

    public Rect PJ() {
        return this.bFR;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.PH();
    }

    public Point[] PK() {
        PM();
        int PI = PI();
        int i = (this.bFK.top / PI) / this.bFH;
        int i2 = (this.bFK.left / PI) / this.bFH;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.bFK.bottom / PI) / this.bFH) * PI) + 1;
        point2.x = (PI * ((this.bFK.right / PI) / this.bFH)) + 1;
        return new Point[]{point, point2};
    }

    public a PL() {
        return new a(this.bFH);
    }

    public Rect PM() {
        this.mMatrix.mapRect(this.bFJ, this.bFL);
        a(this.bFK, this.bFJ);
        return this.bFK;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.bFM;
    }

    public int PN() {
        return this.bFN;
    }

    public List<a> PO() {
        return this.bFP;
    }

    public void W(float f) {
        this.bFO = f;
    }

    public float PP() {
        return this.bFO;
    }

    public int PI() {
        int i = 1;
        while (i < Math.round(this.bFO)) {
            i *= 2;
        }
        return i;
    }

    public void l(Bitmap bitmap) {
        if (bitmap != null) {
            this.bFQ = new a(bitmap);
            this.bFQ.r(0, 0, this.bFM, this.bFN);
        }
    }

    public a PQ() {
        return this.bFQ;
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
        if (i3 == PI()) {
            return A(i, i2, i3).intersect(this.bFK);
        }
        return false;
    }

    public Rect A(int i, int i2, int i3) {
        int i4 = this.bFH * i3 * i2;
        int i5 = this.bFH * i3 * i;
        return new Rect(i4, i5, (this.bFH * i3) + i4, (this.bFH * i3) + i5);
    }

    public void i(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bFR.right) {
            rect.right = this.bFR.right;
        }
        if (rect.bottom > this.bFR.bottom) {
            rect.bottom = this.bFR.bottom;
        }
    }
}
