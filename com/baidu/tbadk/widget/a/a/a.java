package com.baidu.tbadk.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0093a bFv;
    private final Rect bFw;
    private final Rect bFx;
    private final Rect bFy;
    private int bFz;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.bFv = new C0093a();
        this.bFw = new Rect();
        this.bFx = new Rect();
        this.bFy = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bFz = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bFv = new C0093a();
        this.bFw = new Rect();
        this.bFx = new Rect();
        this.bFy = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.bFw.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void PP() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean h(Rect rect) {
        return rect != null && rect.right - rect.left == this.bFz && rect.bottom - rect.top == this.bFz;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect PQ() {
        return this.bFw;
    }

    public Rect PR() {
        return this.bFx;
    }

    public void r(int i, int i2, int i3, int i4) {
        this.bFx.set(i, i2, i3, i4);
    }

    public void s(int i, int i2, int i3, int i4) {
        this.bFw.set(i, i2, i3, i4);
    }

    public void y(int i, int i2, int i3) {
        this.bFv.row = i;
        this.bFv.column = i2;
        this.bFv.bFA = i3;
    }

    public C0093a PS() {
        return this.bFv;
    }

    public Rect PT() {
        int i = this.bFz * this.bFv.column * this.bFv.bFA;
        int i2 = this.bFz * this.bFv.row * this.bFv.bFA;
        this.bFy.set(i, i2, (this.bFz * this.bFv.bFA) + i, (this.bFz * this.bFv.bFA) + i2);
        return this.bFy;
    }

    /* renamed from: com.baidu.tbadk.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0093a {
        int bFA;
        int column;
        int row;

        public C0093a() {
        }

        public C0093a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bFA = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bFA + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0093a) {
                C0093a c0093a = (C0093a) obj;
                return this.row == c0093a.getRow() && this.column == c0093a.LI() && this.bFA == c0093a.PU();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bFA * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int LI() {
            return this.column;
        }

        public int PU() {
            return this.bFA;
        }
    }
}
