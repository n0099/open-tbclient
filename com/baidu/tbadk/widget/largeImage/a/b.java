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
    private final int beS;
    private final RectF beX;
    private final int beY;
    private final int beZ;
    private a bfd;
    private final Rect bfe;
    private final RectF beV = new RectF();
    private final Rect beW = new Rect();
    private float bfa = 1.0f;
    private final List<a> bfc = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.beZ = i2;
        this.beY = i;
        this.beX = new RectF(0.0f, 0.0f, i, i2);
        this.bfe = new Rect(0, 0, iArr[0], iArr[1]);
        this.beS = i / 2;
    }

    public int getBlockSize() {
        return this.beS;
    }

    public Rect NW() {
        return this.bfe;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.NU();
    }

    public Point[] NX() {
        NZ();
        int NV = NV();
        int i = (this.beW.top / NV) / this.beS;
        int i2 = (this.beW.left / NV) / this.beS;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.beW.bottom / NV) / this.beS) * NV) + 1;
        point2.x = (NV * ((this.beW.right / NV) / this.beS)) + 1;
        return new Point[]{point, point2};
    }

    public a NY() {
        return new a(this.beS);
    }

    public Rect NZ() {
        this.mMatrix.mapRect(this.beV, this.beX);
        a(this.beW, this.beV);
        return this.beW;
    }

    private void a(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.beY;
    }

    public int Oa() {
        return this.beZ;
    }

    public List<a> Ob() {
        return this.bfc;
    }

    public void ab(float f) {
        this.bfa = f;
    }

    public float Oc() {
        return this.bfa;
    }

    public int NV() {
        int i = 1;
        while (i < Math.round(this.bfa)) {
            i *= 2;
        }
        return i;
    }

    public void k(Bitmap bitmap) {
        if (bitmap != null) {
            this.bfd = new a(bitmap);
            this.bfd.i(0, 0, this.beY, this.beZ);
        }
    }

    public a Od() {
        return this.bfd;
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

    public boolean r(int i, int i2, int i3) {
        if (i3 == NV()) {
            return s(i, i2, i3).intersect(this.beW);
        }
        return false;
    }

    public Rect s(int i, int i2, int i3) {
        int i4 = this.beS * i3 * i2;
        int i5 = this.beS * i3 * i;
        return new Rect(i4, i5, (this.beS * i3) + i4, (this.beS * i3) + i5);
    }

    public void g(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.bfe.right) {
            rect.right = this.bfe.right;
        }
        if (rect.bottom > this.bfe.bottom) {
            rect.bottom = this.bfe.bottom;
        }
    }
}
