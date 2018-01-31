package com.baidu.tbadk.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0093a bFL;
    private final Rect bFM;
    private final Rect bFN;
    private final Rect bFO;
    private int bFP;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.bFL = new C0093a();
        this.bFM = new Rect();
        this.bFN = new Rect();
        this.bFO = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bFP = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bFL = new C0093a();
        this.bFM = new Rect();
        this.bFN = new Rect();
        this.bFO = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.bFM.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void PF() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean h(Rect rect) {
        return rect != null && rect.right - rect.left == this.bFP && rect.bottom - rect.top == this.bFP;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect PG() {
        return this.bFM;
    }

    public Rect PH() {
        return this.bFN;
    }

    public void r(int i, int i2, int i3, int i4) {
        this.bFN.set(i, i2, i3, i4);
    }

    public void s(int i, int i2, int i3, int i4) {
        this.bFM.set(i, i2, i3, i4);
    }

    public void y(int i, int i2, int i3) {
        this.bFL.row = i;
        this.bFL.column = i2;
        this.bFL.bFQ = i3;
    }

    public C0093a PI() {
        return this.bFL;
    }

    public Rect PJ() {
        int i = this.bFP * this.bFL.column * this.bFL.bFQ;
        int i2 = this.bFP * this.bFL.row * this.bFL.bFQ;
        this.bFO.set(i, i2, (this.bFP * this.bFL.bFQ) + i, (this.bFP * this.bFL.bFQ) + i2);
        return this.bFO;
    }

    /* renamed from: com.baidu.tbadk.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0093a {
        int bFQ;
        int column;
        int row;

        public C0093a() {
        }

        public C0093a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bFQ = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bFQ + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0093a) {
                C0093a c0093a = (C0093a) obj;
                return this.row == c0093a.getRow() && this.column == c0093a.Ly() && this.bFQ == c0093a.PK();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bFQ * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Ly() {
            return this.column;
        }

        public int PK() {
            return this.bFQ;
        }
    }
}
