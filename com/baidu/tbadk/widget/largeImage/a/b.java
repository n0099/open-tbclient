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
    private final RectF bbE;
    private final int bbF;
    private final int bbG;
    private a bbJ;
    private final Rect bbK;
    private final int bbz;
    private final RectF bbC = new RectF();
    private final Rect bbD = new Rect();
    private float bbH = 1.0f;
    private final List<a> bbI = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.bbG = i2;
        this.bbF = i;
        this.bbE = new RectF(0.0f, 0.0f, i, i2);
        this.bbK = new Rect(0, 0, iArr[0], iArr[1]);
        this.bbz = i / 2;
    }

    public int getBlockSize() {
        return this.bbz;
    }

    public Rect ME() {
        return this.bbK;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.MC();
    }

    public Point[] MF() {
        MH();
        int MD = MD();
        int i = (this.bbD.top / MD) / this.bbz;
        int i2 = (this.bbD.left / MD) / this.bbz;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.bbD.bottom / MD) / this.bbz) * MD) + 1;
        point2.x = (MD * ((this.bbD.right / MD) / this.bbz)) + 1;
        return new Point[]{point, point2};
    }

    public a MG() {
        return new a(this.bbz);
    }

    public Rect MH() {
        this.mMatrix.mapRect(this.bbC, this.bbE);
        a(this.bbD, this.bbC);
        return this.bbD;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.bbF;
    }

    public int MI() {
        return this.bbG;
    }

    public List<a> MJ() {
        return this.bbI;
    }

    public void ab(float f) {
        this.bbH = f;
    }

    public float MK() {
        return this.bbH;
    }

    public int MD() {
        int i = 1;
        while (i < Math.round(this.bbH)) {
            i *= 2;
        }
        return i;
    }

    public void j(Bitmap bitmap) {
        if (bitmap != null) {
            this.bbJ = new a(bitmap);
            this.bbJ.h(0, 0, this.bbF, this.bbG);
        }
    }

    public a ML() {
        return this.bbJ;
    }

    public void o(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void ac(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void b(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean p(int i, int i2, int i3) {
        if (i3 == MD()) {
            return q(i, i2, i3).intersect(this.bbD);
        }
        return false;
    }

    public Rect q(int i, int i2, int i3) {
        int i4 = this.bbz * i3 * i2;
        int i5 = this.bbz * i3 * i;
        return new Rect(i4, i5, (this.bbz * i3) + i4, (this.bbz * i3) + i5);
    }

    public void g(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bbK.right) {
            rect.right = this.bbK.right;
        }
        if (rect.bottom > this.bbK.bottom) {
            rect.bottom = this.bbK.bottom;
        }
    }
}
