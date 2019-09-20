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
    private final int cJo;
    private final RectF cJs;
    private final int cJt;
    private final int cJu;
    private a cJx;
    private final Rect cJy;
    private final RectF cJq = new RectF();
    private final Rect cJr = new Rect();
    private float cJv = 1.0f;
    private final List<a> cJw = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.cJu = i2;
        this.cJt = i;
        this.cJs = new RectF(0.0f, 0.0f, i, i2);
        this.cJy = new Rect(0, 0, iArr[0], iArr[1]);
        this.cJo = i / 2;
    }

    public int qf() {
        return this.cJo;
    }

    public Rect aye() {
        return this.cJy;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.ayc();
    }

    public Point[] ayf() {
        ayh();
        int ayd = ayd();
        int i = (this.cJr.top / ayd) / this.cJo;
        int i2 = (this.cJr.left / ayd) / this.cJo;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.cJr.bottom / ayd) / this.cJo) * ayd) + 1;
        point2.x = (ayd * ((this.cJr.right / ayd) / this.cJo)) + 1;
        return new Point[]{point, point2};
    }

    public a ayg() {
        return new a(this.cJo);
    }

    public Rect ayh() {
        this.mMatrix.mapRect(this.cJq, this.cJs);
        a(this.cJr, this.cJq);
        return this.cJr;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.cJt;
    }

    public int ayi() {
        return this.cJu;
    }

    public List<a> ayj() {
        return this.cJw;
    }

    public void ar(float f) {
        this.cJv = f;
    }

    public float ayk() {
        return this.cJv;
    }

    public int ayd() {
        int i = 1;
        while (i < Math.round(this.cJv)) {
            i *= 2;
        }
        return i;
    }

    public void r(Bitmap bitmap) {
        if (bitmap != null) {
            this.cJx = new a(bitmap);
            this.cJx.q(0, 0, this.cJt, this.cJu);
        }
    }

    public a ayl() {
        return this.cJx;
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

    public boolean w(int i, int i2, int i3) {
        if (i3 == ayd()) {
            return x(i, i2, i3).intersect(this.cJr);
        }
        return false;
    }

    public Rect x(int i, int i2, int i3) {
        int i4 = this.cJo * i3 * i2;
        int i5 = this.cJo * i3 * i;
        return new Rect(i4, i5, (this.cJo * i3) + i4, (this.cJo * i3) + i5);
    }

    public void h(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.cJy.right) {
            rect.right = this.cJy.right;
        }
        if (rect.bottom > this.cJy.bottom) {
            rect.bottom = this.cJy.bottom;
        }
    }
}
