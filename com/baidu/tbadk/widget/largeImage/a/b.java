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
    private final int cyM;
    private final RectF cyQ;
    private final int cyR;
    private final int cyS;
    private a cyV;
    private final Rect cyW;
    private final RectF cyO = new RectF();
    private final Rect cyP = new Rect();
    private float cyT = 1.0f;
    private final List<a> cyU = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.cyS = i2;
        this.cyR = i;
        this.cyQ = new RectF(0.0f, 0.0f, i, i2);
        this.cyW = new Rect(0, 0, iArr[0], iArr[1]);
        this.cyM = i / 2;
    }

    public int getBlockSize() {
        return this.cyM;
    }

    public Rect arx() {
        return this.cyW;
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
        int i = (this.cyP.top / arw) / this.cyM;
        int i2 = (this.cyP.left / arw) / this.cyM;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.cyP.bottom / arw) / this.cyM) * arw) + 1;
        point2.x = (arw * ((this.cyP.right / arw) / this.cyM)) + 1;
        return new Point[]{point, point2};
    }

    public a arz() {
        return new a(this.cyM);
    }

    public Rect arA() {
        this.mMatrix.mapRect(this.cyO, this.cyQ);
        a(this.cyP, this.cyO);
        return this.cyP;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.cyR;
    }

    public int arB() {
        return this.cyS;
    }

    public List<a> arC() {
        return this.cyU;
    }

    public void ap(float f) {
        this.cyT = f;
    }

    public float arD() {
        return this.cyT;
    }

    public int arw() {
        int i = 1;
        while (i < Math.round(this.cyT)) {
            i *= 2;
        }
        return i;
    }

    public void r(Bitmap bitmap) {
        if (bitmap != null) {
            this.cyV = new a(bitmap);
            this.cyV.m(0, 0, this.cyR, this.cyS);
        }
    }

    public a arE() {
        return this.cyV;
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
            return v(i, i2, i3).intersect(this.cyP);
        }
        return false;
    }

    public Rect v(int i, int i2, int i3) {
        int i4 = this.cyM * i3 * i2;
        int i5 = this.cyM * i3 * i;
        return new Rect(i4, i5, (this.cyM * i3) + i4, (this.cyM * i3) + i5);
    }

    public void h(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.cyW.right) {
            rect.right = this.cyW.right;
        }
        if (rect.bottom > this.cyW.bottom) {
            rect.bottom = this.cyW.bottom;
        }
    }
}
