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
    private final RectF cIB;
    private final int cIC;
    private final int cID;
    private a cIG;
    private final Rect cIH;
    private final int cIx;
    private final RectF cIz = new RectF();
    private final Rect cIA = new Rect();
    private float cIE = 1.0f;
    private final List<a> cIF = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.cID = i2;
        this.cIC = i;
        this.cIB = new RectF(0.0f, 0.0f, i, i2);
        this.cIH = new Rect(0, 0, iArr[0], iArr[1]);
        this.cIx = i / 2;
    }

    public int qe() {
        return this.cIx;
    }

    public Rect axS() {
        return this.cIH;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.axQ();
    }

    public Point[] axT() {
        axV();
        int axR = axR();
        int i = (this.cIA.top / axR) / this.cIx;
        int i2 = (this.cIA.left / axR) / this.cIx;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.cIA.bottom / axR) / this.cIx) * axR) + 1;
        point2.x = (axR * ((this.cIA.right / axR) / this.cIx)) + 1;
        return new Point[]{point, point2};
    }

    public a axU() {
        return new a(this.cIx);
    }

    public Rect axV() {
        this.mMatrix.mapRect(this.cIz, this.cIB);
        a(this.cIA, this.cIz);
        return this.cIA;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.cIC;
    }

    public int axW() {
        return this.cID;
    }

    public List<a> axX() {
        return this.cIF;
    }

    public void ar(float f) {
        this.cIE = f;
    }

    public float axY() {
        return this.cIE;
    }

    public int axR() {
        int i = 1;
        while (i < Math.round(this.cIE)) {
            i *= 2;
        }
        return i;
    }

    public void r(Bitmap bitmap) {
        if (bitmap != null) {
            this.cIG = new a(bitmap);
            this.cIG.n(0, 0, this.cIC, this.cID);
        }
    }

    public a axZ() {
        return this.cIG;
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
        if (i3 == axR()) {
            return w(i, i2, i3).intersect(this.cIA);
        }
        return false;
    }

    public Rect w(int i, int i2, int i3) {
        int i4 = this.cIx * i3 * i2;
        int i5 = this.cIx * i3 * i;
        return new Rect(i4, i5, (this.cIx * i3) + i4, (this.cIx * i3) + i5);
    }

    public void h(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.cIH.right) {
            rect.right = this.cIH.right;
        }
        if (rect.bottom > this.cIH.bottom) {
            rect.bottom = this.cIH.bottom;
        }
    }
}
