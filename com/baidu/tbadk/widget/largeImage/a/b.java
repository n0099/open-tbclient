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
    private final int cyJ;
    private final RectF cyN;
    private final int cyO;
    private final int cyP;
    private a cyS;
    private final Rect cyT;
    private final RectF cyL = new RectF();
    private final Rect cyM = new Rect();
    private float cyQ = 1.0f;
    private final List<a> cyR = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.cyP = i2;
        this.cyO = i;
        this.cyN = new RectF(0.0f, 0.0f, i, i2);
        this.cyT = new Rect(0, 0, iArr[0], iArr[1]);
        this.cyJ = i / 2;
    }

    public int getBlockSize() {
        return this.cyJ;
    }

    public Rect arA() {
        return this.cyT;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.ary();
    }

    public Point[] arB() {
        arD();
        int arz = arz();
        int i = (this.cyM.top / arz) / this.cyJ;
        int i2 = (this.cyM.left / arz) / this.cyJ;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.cyM.bottom / arz) / this.cyJ) * arz) + 1;
        point2.x = (arz * ((this.cyM.right / arz) / this.cyJ)) + 1;
        return new Point[]{point, point2};
    }

    public a arC() {
        return new a(this.cyJ);
    }

    public Rect arD() {
        this.mMatrix.mapRect(this.cyL, this.cyN);
        a(this.cyM, this.cyL);
        return this.cyM;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.cyO;
    }

    public int arE() {
        return this.cyP;
    }

    public List<a> arF() {
        return this.cyR;
    }

    public void ap(float f) {
        this.cyQ = f;
    }

    public float arG() {
        return this.cyQ;
    }

    public int arz() {
        int i = 1;
        while (i < Math.round(this.cyQ)) {
            i *= 2;
        }
        return i;
    }

    public void r(Bitmap bitmap) {
        if (bitmap != null) {
            this.cyS = new a(bitmap);
            this.cyS.m(0, 0, this.cyO, this.cyP);
        }
    }

    public a arH() {
        return this.cyS;
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
        if (i3 == arz()) {
            return v(i, i2, i3).intersect(this.cyM);
        }
        return false;
    }

    public Rect v(int i, int i2, int i3) {
        int i4 = this.cyJ * i3 * i2;
        int i5 = this.cyJ * i3 * i;
        return new Rect(i4, i5, (this.cyJ * i3) + i4, (this.cyJ * i3) + i5);
    }

    public void h(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.cyT.right) {
            rect.right = this.cyT.right;
        }
        if (rect.bottom > this.cyT.bottom) {
            rect.bottom = this.cyT.bottom;
        }
    }
}
