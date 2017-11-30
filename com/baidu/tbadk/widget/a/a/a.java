package com.baidu.tbadk.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0066a aRC;
    private final Rect aRD;
    private final Rect aRE;
    private final Rect aRF;
    private int aRG;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.aRC = new C0066a();
        this.aRD = new Rect();
        this.aRE = new Rect();
        this.aRF = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.aRG = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.aRC = new C0066a();
        this.aRD = new Rect();
        this.aRE = new Rect();
        this.aRF = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.aRD.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void Ip() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean d(Rect rect) {
        return rect != null && rect.right - rect.left == this.aRG && rect.bottom - rect.top == this.aRG;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect Iq() {
        return this.aRD;
    }

    public Rect Ir() {
        return this.aRE;
    }

    public void j(int i, int i2, int i3, int i4) {
        this.aRE.set(i, i2, i3, i4);
    }

    public void k(int i, int i2, int i3, int i4) {
        this.aRD.set(i, i2, i3, i4);
    }

    public void p(int i, int i2, int i3) {
        this.aRC.row = i;
        this.aRC.column = i2;
        this.aRC.aRH = i3;
    }

    public C0066a Is() {
        return this.aRC;
    }

    public Rect It() {
        int i = this.aRG * this.aRC.column * this.aRC.aRH;
        int i2 = this.aRG * this.aRC.row * this.aRC.aRH;
        this.aRF.set(i, i2, (this.aRG * this.aRC.aRH) + i, (this.aRG * this.aRC.aRH) + i2);
        return this.aRF;
    }

    /* renamed from: com.baidu.tbadk.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0066a {
        int aRH;
        int column;
        int row;

        public C0066a() {
        }

        public C0066a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aRH = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.aRH + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0066a) {
                C0066a c0066a = (C0066a) obj;
                return this.row == c0066a.getRow() && this.column == c0066a.Eg() && this.aRH == c0066a.Iu();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.aRH * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Eg() {
            return this.column;
        }

        public int Iu() {
            return this.aRH;
        }
    }
}
