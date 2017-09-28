package com.baidu.tbadk.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0066a aOD;
    private final Rect aOE;
    private final Rect aOF;
    private final Rect aOG;
    private int aOH;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.aOD = new C0066a();
        this.aOE = new Rect();
        this.aOF = new Rect();
        this.aOG = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.aOH = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.aOD = new C0066a();
        this.aOE = new Rect();
        this.aOF = new Rect();
        this.aOG = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.aOE.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void HF() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean d(Rect rect) {
        return rect != null && rect.right - rect.left == this.aOH && rect.bottom - rect.top == this.aOH;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect HG() {
        return this.aOE;
    }

    public Rect HH() {
        return this.aOF;
    }

    public void j(int i, int i2, int i3, int i4) {
        this.aOF.set(i, i2, i3, i4);
    }

    public void k(int i, int i2, int i3, int i4) {
        this.aOE.set(i, i2, i3, i4);
    }

    public void p(int i, int i2, int i3) {
        this.aOD.row = i;
        this.aOD.column = i2;
        this.aOD.aOI = i3;
    }

    public C0066a HI() {
        return this.aOD;
    }

    public Rect HJ() {
        int i = this.aOH * this.aOD.column * this.aOD.aOI;
        int i2 = this.aOH * this.aOD.row * this.aOD.aOI;
        this.aOG.set(i, i2, (this.aOH * this.aOD.aOI) + i, (this.aOH * this.aOD.aOI) + i2);
        return this.aOG;
    }

    /* renamed from: com.baidu.tbadk.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0066a {
        int aOI;
        int column;
        int row;

        public C0066a() {
        }

        public C0066a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aOI = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.aOI + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0066a) {
                C0066a c0066a = (C0066a) obj;
                return this.row == c0066a.getRow() && this.column == c0066a.DD() && this.aOI == c0066a.HK();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.aOI * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int DD() {
            return this.column;
        }

        public int HK() {
            return this.aOI;
        }
    }
}
