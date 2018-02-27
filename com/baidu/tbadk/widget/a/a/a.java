package com.baidu.tbadk.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0117a bHC;
    private final Rect bHD;
    private final Rect bHE;
    private final Rect bHF;
    private int bHG;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.bHC = new C0117a();
        this.bHD = new Rect();
        this.bHE = new Rect();
        this.bHF = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bHG = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bHC = new C0117a();
        this.bHD = new Rect();
        this.bHE = new Rect();
        this.bHF = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.bHD.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void Qj() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean i(Rect rect) {
        return rect != null && rect.right - rect.left == this.bHG && rect.bottom - rect.top == this.bHG;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect Qk() {
        return this.bHD;
    }

    public Rect Ql() {
        return this.bHE;
    }

    public void r(int i, int i2, int i3, int i4) {
        this.bHE.set(i, i2, i3, i4);
    }

    public void s(int i, int i2, int i3, int i4) {
        this.bHD.set(i, i2, i3, i4);
    }

    public void z(int i, int i2, int i3) {
        this.bHC.row = i;
        this.bHC.column = i2;
        this.bHC.bHH = i3;
    }

    public C0117a Qm() {
        return this.bHC;
    }

    public Rect Qn() {
        int i = this.bHG * this.bHC.column * this.bHC.bHH;
        int i2 = this.bHG * this.bHC.row * this.bHC.bHH;
        this.bHF.set(i, i2, (this.bHG * this.bHC.bHH) + i, (this.bHG * this.bHC.bHH) + i2);
        return this.bHF;
    }

    /* renamed from: com.baidu.tbadk.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0117a {
        int bHH;
        int column;
        int row;

        public C0117a() {
        }

        public C0117a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bHH = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bHH + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0117a) {
                C0117a c0117a = (C0117a) obj;
                return this.row == c0117a.getRow() && this.column == c0117a.Md() && this.bHH == c0117a.Qo();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bHH * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Md() {
            return this.column;
        }

        public int Qo() {
            return this.bHH;
        }
    }
}
