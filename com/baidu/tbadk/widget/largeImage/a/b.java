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
    private final RectF bnA;
    private final int bnB;
    private final int bnC;
    private a bnF;
    private final Rect bnG;
    private final int bnw;
    private final RectF bny = new RectF();
    private final Rect bnz = new Rect();
    private float bnD = 1.0f;
    private final List<a> bnE = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.bnC = i2;
        this.bnB = i;
        this.bnA = new RectF(0.0f, 0.0f, i, i2);
        this.bnG = new Rect(0, 0, iArr[0], iArr[1]);
        this.bnw = i / 2;
    }

    public int getBlockSize() {
        return this.bnw;
    }

    public Rect Rj() {
        return this.bnG;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.Rh();
    }

    public Point[] Rk() {
        Rm();
        int Ri = Ri();
        int i = (this.bnz.top / Ri) / this.bnw;
        int i2 = (this.bnz.left / Ri) / this.bnw;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.bnz.bottom / Ri) / this.bnw) * Ri) + 1;
        point2.x = (Ri * ((this.bnz.right / Ri) / this.bnw)) + 1;
        return new Point[]{point, point2};
    }

    public a Rl() {
        return new a(this.bnw);
    }

    public Rect Rm() {
        this.mMatrix.mapRect(this.bny, this.bnA);
        a(this.bnz, this.bny);
        return this.bnz;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.bnB;
    }

    public int Rn() {
        return this.bnC;
    }

    public List<a> Ro() {
        return this.bnE;
    }

    public void ac(float f) {
        this.bnD = f;
    }

    public float Rp() {
        return this.bnD;
    }

    public int Ri() {
        int i = 1;
        while (i < Math.round(this.bnD)) {
            i *= 2;
        }
        return i;
    }

    public void k(Bitmap bitmap) {
        if (bitmap != null) {
            this.bnF = new a(bitmap);
            this.bnF.i(0, 0, this.bnB, this.bnC);
        }
    }

    public a Rq() {
        return this.bnF;
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
        if (i3 == Ri()) {
            return s(i, i2, i3).intersect(this.bnz);
        }
        return false;
    }

    public Rect s(int i, int i2, int i3) {
        int i4 = this.bnw * i3 * i2;
        int i5 = this.bnw * i3 * i;
        return new Rect(i4, i5, (this.bnw * i3) + i4, (this.bnw * i3) + i5);
    }

    public void g(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bnG.right) {
            rect.right = this.bnG.right;
        }
        if (rect.bottom > this.bnG.bottom) {
            rect.bottom = this.bnG.bottom;
        }
    }
}
