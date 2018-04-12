package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final Rect aSA;
    private int aSB;
    private final C0106a aSx;
    private final Rect aSy;
    private final Rect aSz;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.aSx = new C0106a();
        this.aSy = new Rect();
        this.aSz = new Rect();
        this.aSA = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.aSB = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.aSx = new C0106a();
        this.aSy = new Rect();
        this.aSz = new Rect();
        this.aSA = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.aSy.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void IM() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean e(Rect rect) {
        return rect != null && rect.right - rect.left == this.aSB && rect.bottom - rect.top == this.aSB;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect IN() {
        return this.aSy;
    }

    public Rect IO() {
        return this.aSz;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.aSz.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3, int i4) {
        this.aSy.set(i, i2, i3, i4);
    }

    public void o(int i, int i2, int i3) {
        this.aSx.row = i;
        this.aSx.column = i2;
        this.aSx.aSC = i3;
    }

    public C0106a IP() {
        return this.aSx;
    }

    public Rect IQ() {
        int i = this.aSB * this.aSx.column * this.aSx.aSC;
        int i2 = this.aSB * this.aSx.row * this.aSx.aSC;
        this.aSA.set(i, i2, (this.aSB * this.aSx.aSC) + i, (this.aSB * this.aSx.aSC) + i2);
        return this.aSA;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0106a {
        int aSC;
        int column;
        int row;

        public C0106a() {
        }

        public C0106a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aSC = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.aSC + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0106a) {
                C0106a c0106a = (C0106a) obj;
                return this.row == c0106a.getRow() && this.column == c0106a.EH() && this.aSC == c0106a.IR();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.aSC * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int EH() {
            return this.column;
        }

        public int IR() {
            return this.aSC;
        }
    }
}
