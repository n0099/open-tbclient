package com.baidu.tbadk.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0080a aRF;
    private final Rect aRG;
    private final Rect aRH;
    private final Rect aRI;
    private int aRJ;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.aRF = new C0080a();
        this.aRG = new Rect();
        this.aRH = new Rect();
        this.aRI = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.aRJ = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.aRF = new C0080a();
        this.aRG = new Rect();
        this.aRH = new Rect();
        this.aRI = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.aRG.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void Iq() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean d(Rect rect) {
        return rect != null && rect.right - rect.left == this.aRJ && rect.bottom - rect.top == this.aRJ;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect Ir() {
        return this.aRG;
    }

    public Rect Is() {
        return this.aRH;
    }

    public void j(int i, int i2, int i3, int i4) {
        this.aRH.set(i, i2, i3, i4);
    }

    public void k(int i, int i2, int i3, int i4) {
        this.aRG.set(i, i2, i3, i4);
    }

    public void p(int i, int i2, int i3) {
        this.aRF.row = i;
        this.aRF.column = i2;
        this.aRF.aRK = i3;
    }

    public C0080a It() {
        return this.aRF;
    }

    public Rect Iu() {
        int i = this.aRJ * this.aRF.column * this.aRF.aRK;
        int i2 = this.aRJ * this.aRF.row * this.aRF.aRK;
        this.aRI.set(i, i2, (this.aRJ * this.aRF.aRK) + i, (this.aRJ * this.aRF.aRK) + i2);
        return this.aRI;
    }

    /* renamed from: com.baidu.tbadk.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0080a {
        int aRK;
        int column;
        int row;

        public C0080a() {
        }

        public C0080a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aRK = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.aRK + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0080a) {
                C0080a c0080a = (C0080a) obj;
                return this.row == c0080a.getRow() && this.column == c0080a.Eh() && this.aRK == c0080a.Iv();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.aRK * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Eh() {
            return this.column;
        }

        public int Iv() {
            return this.aRK;
        }
    }
}
