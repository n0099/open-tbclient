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
    private a bbB;
    private final Rect bbC;
    private final int bbs;
    private final RectF bbw;
    private final int bbx;
    private final int bby;
    private final RectF bbu = new RectF();
    private final Rect bbv = new Rect();
    private float bbz = 1.0f;
    private final List<a> bbA = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.bby = i2;
        this.bbx = i;
        this.bbw = new RectF(0.0f, 0.0f, i, i2);
        this.bbC = new Rect(0, 0, iArr[0], iArr[1]);
        this.bbs = i / 2;
    }

    public int getBlockSize() {
        return this.bbs;
    }

    public Rect ME() {
        return this.bbC;
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
        int i = (this.bbv.top / MD) / this.bbs;
        int i2 = (this.bbv.left / MD) / this.bbs;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.bbv.bottom / MD) / this.bbs) * MD) + 1;
        point2.x = (MD * ((this.bbv.right / MD) / this.bbs)) + 1;
        return new Point[]{point, point2};
    }

    public a MG() {
        return new a(this.bbs);
    }

    public Rect MH() {
        this.mMatrix.mapRect(this.bbu, this.bbw);
        a(this.bbv, this.bbu);
        return this.bbv;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.bbx;
    }

    public int MI() {
        return this.bby;
    }

    public List<a> MJ() {
        return this.bbA;
    }

    public void aa(float f) {
        this.bbz = f;
    }

    public float MK() {
        return this.bbz;
    }

    public int MD() {
        int i = 1;
        while (i < Math.round(this.bbz)) {
            i *= 2;
        }
        return i;
    }

    public void j(Bitmap bitmap) {
        if (bitmap != null) {
            this.bbB = new a(bitmap);
            this.bbB.i(0, 0, this.bbx, this.bby);
        }
    }

    public a ML() {
        return this.bbB;
    }

    public void o(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void ab(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void b(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean p(int i, int i2, int i3) {
        if (i3 == MD()) {
            return q(i, i2, i3).intersect(this.bbv);
        }
        return false;
    }

    public Rect q(int i, int i2, int i3) {
        int i4 = this.bbs * i3 * i2;
        int i5 = this.bbs * i3 * i;
        return new Rect(i4, i5, (this.bbs * i3) + i4, (this.bbs * i3) + i5);
    }

    public void f(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bbC.right) {
            rect.right = this.bbC.right;
        }
        if (rect.bottom > this.bbC.bottom) {
            rect.bottom = this.bbC.bottom;
        }
    }
}
