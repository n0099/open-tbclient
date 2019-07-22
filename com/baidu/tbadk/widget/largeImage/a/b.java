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
    private final Rect cIA;
    private final int cIq;
    private final RectF cIu;
    private final int cIv;
    private final int cIw;
    private a cIz;
    private final RectF cIs = new RectF();
    private final Rect cIt = new Rect();
    private float cIx = 1.0f;
    private final List<a> cIy = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.cIw = i2;
        this.cIv = i;
        this.cIu = new RectF(0.0f, 0.0f, i, i2);
        this.cIA = new Rect(0, 0, iArr[0], iArr[1]);
        this.cIq = i / 2;
    }

    public int qe() {
        return this.cIq;
    }

    public Rect axQ() {
        return this.cIA;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.axO();
    }

    public Point[] axR() {
        axT();
        int axP = axP();
        int i = (this.cIt.top / axP) / this.cIq;
        int i2 = (this.cIt.left / axP) / this.cIq;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.cIt.bottom / axP) / this.cIq) * axP) + 1;
        point2.x = (axP * ((this.cIt.right / axP) / this.cIq)) + 1;
        return new Point[]{point, point2};
    }

    public a axS() {
        return new a(this.cIq);
    }

    public Rect axT() {
        this.mMatrix.mapRect(this.cIs, this.cIu);
        a(this.cIt, this.cIs);
        return this.cIt;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.cIv;
    }

    public int axU() {
        return this.cIw;
    }

    public List<a> axV() {
        return this.cIy;
    }

    public void ar(float f) {
        this.cIx = f;
    }

    public float axW() {
        return this.cIx;
    }

    public int axP() {
        int i = 1;
        while (i < Math.round(this.cIx)) {
            i *= 2;
        }
        return i;
    }

    public void r(Bitmap bitmap) {
        if (bitmap != null) {
            this.cIz = new a(bitmap);
            this.cIz.n(0, 0, this.cIv, this.cIw);
        }
    }

    public a axX() {
        return this.cIz;
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
        if (i3 == axP()) {
            return w(i, i2, i3).intersect(this.cIt);
        }
        return false;
    }

    public Rect w(int i, int i2, int i3) {
        int i4 = this.cIq * i3 * i2;
        int i5 = this.cIq * i3 * i;
        return new Rect(i4, i5, (this.cIq * i3) + i4, (this.cIq * i3) + i5);
    }

    public void h(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.cIA.right) {
            rect.right = this.cIA.right;
        }
        if (rect.bottom > this.cIA.bottom) {
            rect.bottom = this.cIA.bottom;
        }
    }
}
