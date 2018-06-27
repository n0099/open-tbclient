package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0123a bbo;
    private final Rect bbp;
    private final Rect bbq;
    private final Rect bbr;
    private int bbs;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.bbo = new C0123a();
        this.bbp = new Rect();
        this.bbq = new Rect();
        this.bbr = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bbs = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bbo = new C0123a();
        this.bbp = new Rect();
        this.bbq = new Rect();
        this.bbr = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.bbp.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void My() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean e(Rect rect) {
        return rect != null && rect.right - rect.left == this.bbs && rect.bottom - rect.top == this.bbs;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect Mz() {
        return this.bbp;
    }

    public Rect MA() {
        return this.bbq;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.bbq.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3, int i4) {
        this.bbp.set(i, i2, i3, i4);
    }

    public void o(int i, int i2, int i3) {
        this.bbo.row = i;
        this.bbo.column = i2;
        this.bbo.bbt = i3;
    }

    public C0123a MB() {
        return this.bbo;
    }

    public Rect MC() {
        int i = this.bbs * this.bbo.column * this.bbo.bbt;
        int i2 = this.bbs * this.bbo.row * this.bbo.bbt;
        this.bbr.set(i, i2, (this.bbs * this.bbo.bbt) + i, (this.bbs * this.bbo.bbt) + i2);
        return this.bbr;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0123a {
        int bbt;
        int column;
        int row;

        public C0123a() {
        }

        public C0123a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bbt = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bbt + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0123a) {
                C0123a c0123a = (C0123a) obj;
                return this.row == c0123a.getRow() && this.column == c0123a.IB() && this.bbt == c0123a.MD();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bbt * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int IB() {
            return this.column;
        }

        public int MD() {
            return this.bbt;
        }
    }
}
