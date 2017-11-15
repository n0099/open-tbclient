package com.baidu.tbadk.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0066a aOF;
    private final Rect aOG;
    private final Rect aOH;
    private final Rect aOI;
    private int aOJ;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.aOF = new C0066a();
        this.aOG = new Rect();
        this.aOH = new Rect();
        this.aOI = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.aOJ = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.aOF = new C0066a();
        this.aOG = new Rect();
        this.aOH = new Rect();
        this.aOI = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.aOG.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void HS() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean d(Rect rect) {
        return rect != null && rect.right - rect.left == this.aOJ && rect.bottom - rect.top == this.aOJ;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect HT() {
        return this.aOG;
    }

    public Rect HU() {
        return this.aOH;
    }

    public void j(int i, int i2, int i3, int i4) {
        this.aOH.set(i, i2, i3, i4);
    }

    public void k(int i, int i2, int i3, int i4) {
        this.aOG.set(i, i2, i3, i4);
    }

    public void o(int i, int i2, int i3) {
        this.aOF.row = i;
        this.aOF.column = i2;
        this.aOF.aOK = i3;
    }

    public C0066a HV() {
        return this.aOF;
    }

    public Rect HW() {
        int i = this.aOJ * this.aOF.column * this.aOF.aOK;
        int i2 = this.aOJ * this.aOF.row * this.aOF.aOK;
        this.aOI.set(i, i2, (this.aOJ * this.aOF.aOK) + i, (this.aOJ * this.aOF.aOK) + i2);
        return this.aOI;
    }

    /* renamed from: com.baidu.tbadk.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0066a {
        int aOK;
        int column;
        int row;

        public C0066a() {
        }

        public C0066a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aOK = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.aOK + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0066a) {
                C0066a c0066a = (C0066a) obj;
                return this.row == c0066a.getRow() && this.column == c0066a.DY() && this.aOK == c0066a.HX();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.aOK * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int DY() {
            return this.column;
        }

        public int HX() {
            return this.aOK;
        }
    }
}
