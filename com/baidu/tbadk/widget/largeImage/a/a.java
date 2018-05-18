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
    private final Rect aSB;
    private int aSC;
    private final C0106a aSy;
    private final Rect aSz;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.aSy = new C0106a();
        this.aSz = new Rect();
        this.aSA = new Rect();
        this.aSB = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.aSC = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.aSy = new C0106a();
        this.aSz = new Rect();
        this.aSA = new Rect();
        this.aSB = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.aSz.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void IK() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean e(Rect rect) {
        return rect != null && rect.right - rect.left == this.aSC && rect.bottom - rect.top == this.aSC;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect IL() {
        return this.aSz;
    }

    public Rect IM() {
        return this.aSA;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.aSA.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3, int i4) {
        this.aSz.set(i, i2, i3, i4);
    }

    public void o(int i, int i2, int i3) {
        this.aSy.row = i;
        this.aSy.column = i2;
        this.aSy.aSD = i3;
    }

    public C0106a IN() {
        return this.aSy;
    }

    public Rect IO() {
        int i = this.aSC * this.aSy.column * this.aSy.aSD;
        int i2 = this.aSC * this.aSy.row * this.aSy.aSD;
        this.aSB.set(i, i2, (this.aSC * this.aSy.aSD) + i, (this.aSC * this.aSy.aSD) + i2);
        return this.aSB;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0106a {
        int aSD;
        int column;
        int row;

        public C0106a() {
        }

        public C0106a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aSD = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.aSD + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0106a) {
                C0106a c0106a = (C0106a) obj;
                return this.row == c0106a.getRow() && this.column == c0106a.EF() && this.aSD == c0106a.IP();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.aSD * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int EF() {
            return this.column;
        }

        public int IP() {
            return this.aSD;
        }
    }
}
