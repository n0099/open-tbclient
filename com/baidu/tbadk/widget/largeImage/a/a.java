package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0178a bns;
    private final Rect bnt;
    private final Rect bnu;
    private final Rect bnv;
    private int bnw;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.bns = new C0178a();
        this.bnt = new Rect();
        this.bnu = new Rect();
        this.bnv = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bnw = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bns = new C0178a();
        this.bnt = new Rect();
        this.bnu = new Rect();
        this.bnv = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.bnt.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void Rd() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean f(Rect rect) {
        return rect != null && rect.right - rect.left == this.bnw && rect.bottom - rect.top == this.bnw;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect Re() {
        return this.bnt;
    }

    public Rect Rf() {
        return this.bnu;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.bnu.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3, int i4) {
        this.bnt.set(i, i2, i3, i4);
    }

    public void q(int i, int i2, int i3) {
        this.bns.row = i;
        this.bns.column = i2;
        this.bns.bnx = i3;
    }

    public C0178a Rg() {
        return this.bns;
    }

    public Rect Rh() {
        int i = this.bnw * this.bns.column * this.bns.bnx;
        int i2 = this.bnw * this.bns.row * this.bns.bnx;
        this.bnv.set(i, i2, (this.bnw * this.bns.bnx) + i, (this.bnw * this.bns.bnx) + i2);
        return this.bnv;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0178a {
        int bnx;
        int column;
        int row;

        public C0178a() {
        }

        public C0178a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bnx = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bnx + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0178a) {
                C0178a c0178a = (C0178a) obj;
                return this.row == c0178a.getRow() && this.column == c0178a.Nb() && this.bnx == c0178a.Ri();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bnx * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Nb() {
            return this.column;
        }

        public int Ri() {
            return this.bnx;
        }
    }
}
