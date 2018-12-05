package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0178a bnp;
    private final Rect bnq;
    private final Rect bnr;
    private final Rect bns;
    private int bnt;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.bnp = new C0178a();
        this.bnq = new Rect();
        this.bnr = new Rect();
        this.bns = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bnt = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bnp = new C0178a();
        this.bnq = new Rect();
        this.bnr = new Rect();
        this.bns = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.bnq.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void Rb() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean f(Rect rect) {
        return rect != null && rect.right - rect.left == this.bnt && rect.bottom - rect.top == this.bnt;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect Rc() {
        return this.bnq;
    }

    public Rect Rd() {
        return this.bnr;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.bnr.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3, int i4) {
        this.bnq.set(i, i2, i3, i4);
    }

    public void q(int i, int i2, int i3) {
        this.bnp.row = i;
        this.bnp.column = i2;
        this.bnp.bnu = i3;
    }

    public C0178a Re() {
        return this.bnp;
    }

    public Rect Rf() {
        int i = this.bnt * this.bnp.column * this.bnp.bnu;
        int i2 = this.bnt * this.bnp.row * this.bnp.bnu;
        this.bns.set(i, i2, (this.bnt * this.bnp.bnu) + i, (this.bnt * this.bnp.bnu) + i2);
        return this.bns;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0178a {
        int bnu;
        int column;
        int row;

        public C0178a() {
        }

        public C0178a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bnu = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bnu + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0178a) {
                C0178a c0178a = (C0178a) obj;
                return this.row == c0178a.getRow() && this.column == c0178a.Na() && this.bnu == c0178a.Rg();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bnu * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Na() {
            return this.column;
        }

        public int Rg() {
            return this.bnu;
        }
    }
}
