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
    private final int cyL;
    private final RectF cyP;
    private final int cyQ;
    private final int cyR;
    private a cyU;
    private final Rect cyV;
    private final RectF cyN = new RectF();
    private final Rect cyO = new Rect();
    private float cyS = 1.0f;
    private final List<a> cyT = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.cyR = i2;
        this.cyQ = i;
        this.cyP = new RectF(0.0f, 0.0f, i, i2);
        this.cyV = new Rect(0, 0, iArr[0], iArr[1]);
        this.cyL = i / 2;
    }

    public int getBlockSize() {
        return this.cyL;
    }

    public Rect arx() {
        return this.cyV;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.arv();
    }

    public Point[] ary() {
        arA();
        int arw = arw();
        int i = (this.cyO.top / arw) / this.cyL;
        int i2 = (this.cyO.left / arw) / this.cyL;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.cyO.bottom / arw) / this.cyL) * arw) + 1;
        point2.x = (arw * ((this.cyO.right / arw) / this.cyL)) + 1;
        return new Point[]{point, point2};
    }

    public a arz() {
        return new a(this.cyL);
    }

    public Rect arA() {
        this.mMatrix.mapRect(this.cyN, this.cyP);
        a(this.cyO, this.cyN);
        return this.cyO;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.cyQ;
    }

    public int arB() {
        return this.cyR;
    }

    public List<a> arC() {
        return this.cyT;
    }

    public void ap(float f) {
        this.cyS = f;
    }

    public float arD() {
        return this.cyS;
    }

    public int arw() {
        int i = 1;
        while (i < Math.round(this.cyS)) {
            i *= 2;
        }
        return i;
    }

    public void r(Bitmap bitmap) {
        if (bitmap != null) {
            this.cyU = new a(bitmap);
            this.cyU.m(0, 0, this.cyQ, this.cyR);
        }
    }

    public a arE() {
        return this.cyU;
    }

    public void u(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void aq(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void b(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean u(int i, int i2, int i3) {
        if (i3 == arw()) {
            return v(i, i2, i3).intersect(this.cyO);
        }
        return false;
    }

    public Rect v(int i, int i2, int i3) {
        int i4 = this.cyL * i3 * i2;
        int i5 = this.cyL * i3 * i;
        return new Rect(i4, i5, (this.cyL * i3) + i4, (this.cyL * i3) + i5);
    }

    public void h(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.cyV.right) {
            rect.right = this.cyV.right;
        }
        if (rect.bottom > this.cyV.bottom) {
            rect.bottom = this.cyV.bottom;
        }
    }
}
