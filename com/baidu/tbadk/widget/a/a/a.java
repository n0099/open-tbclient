package com.baidu.tbadk.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0092a bFD;
    private final Rect bFE;
    private final Rect bFF;
    private final Rect bFG;
    private int bFH;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.bFD = new C0092a();
        this.bFE = new Rect();
        this.bFF = new Rect();
        this.bFG = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bFH = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bFD = new C0092a();
        this.bFE = new Rect();
        this.bFF = new Rect();
        this.bFG = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.bFE.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void PD() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean h(Rect rect) {
        return rect != null && rect.right - rect.left == this.bFH && rect.bottom - rect.top == this.bFH;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect PE() {
        return this.bFE;
    }

    public Rect PF() {
        return this.bFF;
    }

    public void r(int i, int i2, int i3, int i4) {
        this.bFF.set(i, i2, i3, i4);
    }

    public void s(int i, int i2, int i3, int i4) {
        this.bFE.set(i, i2, i3, i4);
    }

    public void y(int i, int i2, int i3) {
        this.bFD.row = i;
        this.bFD.column = i2;
        this.bFD.bFI = i3;
    }

    public C0092a PG() {
        return this.bFD;
    }

    public Rect PH() {
        int i = this.bFH * this.bFD.column * this.bFD.bFI;
        int i2 = this.bFH * this.bFD.row * this.bFD.bFI;
        this.bFG.set(i, i2, (this.bFH * this.bFD.bFI) + i, (this.bFH * this.bFD.bFI) + i2);
        return this.bFG;
    }

    /* renamed from: com.baidu.tbadk.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0092a {
        int bFI;
        int column;
        int row;

        public C0092a() {
        }

        public C0092a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bFI = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bFI + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0092a) {
                C0092a c0092a = (C0092a) obj;
                return this.row == c0092a.getRow() && this.column == c0092a.Lw() && this.bFI == c0092a.PI();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bFI * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Lw() {
            return this.column;
        }

        public int PI() {
            return this.bFI;
        }
    }
}
