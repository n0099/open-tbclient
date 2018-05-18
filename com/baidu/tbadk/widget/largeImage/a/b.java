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
    private final int aSC;
    private final RectF aSG;
    private final int aSH;
    private final int aSI;
    private a aSL;
    private final Rect aSM;
    private final RectF aSE = new RectF();
    private final Rect aSF = new Rect();
    private float aSJ = 1.0f;
    private final List<a> aSK = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.aSI = i2;
        this.aSH = i;
        this.aSG = new RectF(0.0f, 0.0f, i, i2);
        this.aSM = new Rect(0, 0, iArr[0], iArr[1]);
        this.aSC = i / 2;
    }

    public int getBlockSize() {
        return this.aSC;
    }

    public Rect IQ() {
        return this.aSM;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.IO();
    }

    public Point[] IR() {
        IT();
        int IP = IP();
        int i = (this.aSF.top / IP) / this.aSC;
        int i2 = (this.aSF.left / IP) / this.aSC;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.aSF.bottom / IP) / this.aSC) * IP) + 1;
        point2.x = (IP * ((this.aSF.right / IP) / this.aSC)) + 1;
        return new Point[]{point, point2};
    }

    public a IS() {
        return new a(this.aSC);
    }

    public Rect IT() {
        this.mMatrix.mapRect(this.aSE, this.aSG);
        a(this.aSF, this.aSE);
        return this.aSF;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.aSH;
    }

    public int IU() {
        return this.aSI;
    }

    public List<a> IV() {
        return this.aSK;
    }

    public void Q(float f) {
        this.aSJ = f;
    }

    public float IW() {
        return this.aSJ;
    }

    public int IP() {
        int i = 1;
        while (i < Math.round(this.aSJ)) {
            i *= 2;
        }
        return i;
    }

    public void k(Bitmap bitmap) {
        if (bitmap != null) {
            this.aSL = new a(bitmap);
            this.aSL.i(0, 0, this.aSH, this.aSI);
        }
    }

    public a IX() {
        return this.aSL;
    }

    public void h(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void R(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void b(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean p(int i, int i2, int i3) {
        if (i3 == IP()) {
            return q(i, i2, i3).intersect(this.aSF);
        }
        return false;
    }

    public Rect q(int i, int i2, int i3) {
        int i4 = this.aSC * i3 * i2;
        int i5 = this.aSC * i3 * i;
        return new Rect(i4, i5, (this.aSC * i3) + i4, (this.aSC * i3) + i5);
    }

    public void f(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.aSM.right) {
            rect.right = this.aSM.right;
        }
        if (rect.bottom > this.aSM.bottom) {
            rect.bottom = this.aSM.bottom;
        }
    }
}
