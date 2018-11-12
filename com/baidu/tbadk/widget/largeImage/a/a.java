package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0168a bjR;
    private final Rect bjS;
    private final Rect bjT;
    private final Rect bjU;
    private int bjV;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.bjR = new C0168a();
        this.bjS = new Rect();
        this.bjT = new Rect();
        this.bjU = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bjV = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bjR = new C0168a();
        this.bjS = new Rect();
        this.bjT = new Rect();
        this.bjU = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.bjS.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void PV() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean f(Rect rect) {
        return rect != null && rect.right - rect.left == this.bjV && rect.bottom - rect.top == this.bjV;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect PW() {
        return this.bjS;
    }

    public Rect PX() {
        return this.bjT;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.bjT.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3, int i4) {
        this.bjS.set(i, i2, i3, i4);
    }

    public void q(int i, int i2, int i3) {
        this.bjR.row = i;
        this.bjR.column = i2;
        this.bjR.bjW = i3;
    }

    public C0168a PY() {
        return this.bjR;
    }

    public Rect PZ() {
        int i = this.bjV * this.bjR.column * this.bjR.bjW;
        int i2 = this.bjV * this.bjR.row * this.bjR.bjW;
        this.bjU.set(i, i2, (this.bjV * this.bjR.bjW) + i, (this.bjV * this.bjR.bjW) + i2);
        return this.bjU;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0168a {
        int bjW;
        int column;
        int row;

        public C0168a() {
        }

        public C0168a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bjW = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bjW + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0168a) {
                C0168a c0168a = (C0168a) obj;
                return this.row == c0168a.getRow() && this.column == c0168a.LW() && this.bjW == c0168a.Qa();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bjW * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int LW() {
            return this.column;
        }

        public int Qa() {
            return this.bjW;
        }
    }
}
