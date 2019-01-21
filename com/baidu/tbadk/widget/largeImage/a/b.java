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
    private final int bol;
    private final RectF bop;
    private final int boq;
    private final int bor;
    private a bou;
    private final Rect bov;
    private final RectF bon = new RectF();
    private final Rect boo = new Rect();
    private float bos = 1.0f;
    private final List<a> bot = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.bor = i2;
        this.boq = i;
        this.bop = new RectF(0.0f, 0.0f, i, i2);
        this.bov = new Rect(0, 0, iArr[0], iArr[1]);
        this.bol = i / 2;
    }

    public int getBlockSize() {
        return this.bol;
    }

    public Rect RF() {
        return this.bov;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.RD();
    }

    public Point[] RG() {
        RI();
        int RE = RE();
        int i = (this.boo.top / RE) / this.bol;
        int i2 = (this.boo.left / RE) / this.bol;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.boo.bottom / RE) / this.bol) * RE) + 1;
        point2.x = (RE * ((this.boo.right / RE) / this.bol)) + 1;
        return new Point[]{point, point2};
    }

    public a RH() {
        return new a(this.bol);
    }

    public Rect RI() {
        this.mMatrix.mapRect(this.bon, this.bop);
        a(this.boo, this.bon);
        return this.boo;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.boq;
    }

    public int RJ() {
        return this.bor;
    }

    public List<a> RK() {
        return this.bot;
    }

    public void ac(float f) {
        this.bos = f;
    }

    public float RL() {
        return this.bos;
    }

    public int RE() {
        int i = 1;
        while (i < Math.round(this.bos)) {
            i *= 2;
        }
        return i;
    }

    public void k(Bitmap bitmap) {
        if (bitmap != null) {
            this.bou = new a(bitmap);
            this.bou.i(0, 0, this.boq, this.bor);
        }
    }

    public a RM() {
        return this.bou;
    }

    public void r(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void ad(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void b(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean r(int i, int i2, int i3) {
        if (i3 == RE()) {
            return s(i, i2, i3).intersect(this.boo);
        }
        return false;
    }

    public Rect s(int i, int i2, int i3) {
        int i4 = this.bol * i3 * i2;
        int i5 = this.bol * i3 * i;
        return new Rect(i4, i5, (this.bol * i3) + i4, (this.bol * i3) + i5);
    }

    public void g(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bov.right) {
            rect.right = this.bov.right;
        }
        if (rect.bottom > this.bov.bottom) {
            rect.bottom = this.bov.bottom;
        }
    }
}
