package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0144a bjg;
    private final Rect bjh;
    private final Rect bji;
    private final Rect bjj;
    private int bjk;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.bjg = new C0144a();
        this.bjh = new Rect();
        this.bji = new Rect();
        this.bjj = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bjk = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bjg = new C0144a();
        this.bjh = new Rect();
        this.bji = new Rect();
        this.bjj = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.bjh.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void PM() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean f(Rect rect) {
        return rect != null && rect.right - rect.left == this.bjk && rect.bottom - rect.top == this.bjk;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect PN() {
        return this.bjh;
    }

    public Rect PO() {
        return this.bji;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.bji.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3, int i4) {
        this.bjh.set(i, i2, i3, i4);
    }

    public void q(int i, int i2, int i3) {
        this.bjg.row = i;
        this.bjg.column = i2;
        this.bjg.bjl = i3;
    }

    public C0144a PP() {
        return this.bjg;
    }

    public Rect PQ() {
        int i = this.bjk * this.bjg.column * this.bjg.bjl;
        int i2 = this.bjk * this.bjg.row * this.bjg.bjl;
        this.bjj.set(i, i2, (this.bjk * this.bjg.bjl) + i, (this.bjk * this.bjg.bjl) + i2);
        return this.bjj;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0144a {
        int bjl;
        int column;
        int row;

        public C0144a() {
        }

        public C0144a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bjl = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bjl + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0144a) {
                C0144a c0144a = (C0144a) obj;
                return this.row == c0144a.getRow() && this.column == c0144a.LK() && this.bjl == c0144a.PR();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bjl * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int LK() {
            return this.column;
        }

        public int PR() {
            return this.bjl;
        }
    }
}
