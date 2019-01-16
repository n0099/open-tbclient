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
    private final int bok;
    private final RectF boo;
    private final int bop;
    private final int boq;
    private a bot;
    private final Rect bou;
    private final RectF bom = new RectF();
    private final Rect bon = new Rect();
    private float bor = 1.0f;
    private final List<a> bos = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.boq = i2;
        this.bop = i;
        this.boo = new RectF(0.0f, 0.0f, i, i2);
        this.bou = new Rect(0, 0, iArr[0], iArr[1]);
        this.bok = i / 2;
    }

    public int getBlockSize() {
        return this.bok;
    }

    public Rect RF() {
        return this.bou;
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
        int i = (this.bon.top / RE) / this.bok;
        int i2 = (this.bon.left / RE) / this.bok;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.bon.bottom / RE) / this.bok) * RE) + 1;
        point2.x = (RE * ((this.bon.right / RE) / this.bok)) + 1;
        return new Point[]{point, point2};
    }

    public a RH() {
        return new a(this.bok);
    }

    public Rect RI() {
        this.mMatrix.mapRect(this.bom, this.boo);
        a(this.bon, this.bom);
        return this.bon;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.bop;
    }

    public int RJ() {
        return this.boq;
    }

    public List<a> RK() {
        return this.bos;
    }

    public void ac(float f) {
        this.bor = f;
    }

    public float RL() {
        return this.bor;
    }

    public int RE() {
        int i = 1;
        while (i < Math.round(this.bor)) {
            i *= 2;
        }
        return i;
    }

    public void k(Bitmap bitmap) {
        if (bitmap != null) {
            this.bot = new a(bitmap);
            this.bot.i(0, 0, this.bop, this.boq);
        }
    }

    public a RM() {
        return this.bot;
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
            return s(i, i2, i3).intersect(this.bon);
        }
        return false;
    }

    public Rect s(int i, int i2, int i3) {
        int i4 = this.bok * i3 * i2;
        int i5 = this.bok * i3 * i;
        return new Rect(i4, i5, (this.bok * i3) + i4, (this.bok * i3) + i5);
    }

    public void g(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bou.right) {
            rect.right = this.bou.right;
        }
        if (rect.bottom > this.bou.bottom) {
            rect.bottom = this.bou.bottom;
        }
    }
}
