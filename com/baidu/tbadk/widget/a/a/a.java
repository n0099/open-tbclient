package com.baidu.tbadk.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final Rect aOA;
    private int aOB;
    private final C0066a aOx;
    private final Rect aOy;
    private final Rect aOz;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.aOx = new C0066a();
        this.aOy = new Rect();
        this.aOz = new Rect();
        this.aOA = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.aOB = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.aOx = new C0066a();
        this.aOy = new Rect();
        this.aOz = new Rect();
        this.aOA = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.aOy.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void HH() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean d(Rect rect) {
        return rect != null && rect.right - rect.left == this.aOB && rect.bottom - rect.top == this.aOB;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect HI() {
        return this.aOy;
    }

    public Rect HJ() {
        return this.aOz;
    }

    public void j(int i, int i2, int i3, int i4) {
        this.aOz.set(i, i2, i3, i4);
    }

    public void k(int i, int i2, int i3, int i4) {
        this.aOy.set(i, i2, i3, i4);
    }

    public void o(int i, int i2, int i3) {
        this.aOx.row = i;
        this.aOx.column = i2;
        this.aOx.aOC = i3;
    }

    public C0066a HK() {
        return this.aOx;
    }

    public Rect HL() {
        int i = this.aOB * this.aOx.column * this.aOx.aOC;
        int i2 = this.aOB * this.aOx.row * this.aOx.aOC;
        this.aOA.set(i, i2, (this.aOB * this.aOx.aOC) + i, (this.aOB * this.aOx.aOC) + i2);
        return this.aOA;
    }

    /* renamed from: com.baidu.tbadk.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0066a {
        int aOC;
        int column;
        int row;

        public C0066a() {
        }

        public C0066a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aOC = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.aOC + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0066a) {
                C0066a c0066a = (C0066a) obj;
                return this.row == c0066a.getRow() && this.column == c0066a.DM() && this.aOC == c0066a.HM();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.aOC * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int DM() {
            return this.column;
        }

        public int HM() {
            return this.aOC;
        }
    }
}
