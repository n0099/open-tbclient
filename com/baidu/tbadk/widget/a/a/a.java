package com.baidu.tbadk.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0117a bHF;
    private final Rect bHG;
    private final Rect bHH;
    private final Rect bHI;
    private int bHJ;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.bHF = new C0117a();
        this.bHG = new Rect();
        this.bHH = new Rect();
        this.bHI = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bHJ = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bHF = new C0117a();
        this.bHG = new Rect();
        this.bHH = new Rect();
        this.bHI = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.bHG.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void Qk() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean i(Rect rect) {
        return rect != null && rect.right - rect.left == this.bHJ && rect.bottom - rect.top == this.bHJ;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect Ql() {
        return this.bHG;
    }

    public Rect Qm() {
        return this.bHH;
    }

    public void r(int i, int i2, int i3, int i4) {
        this.bHH.set(i, i2, i3, i4);
    }

    public void s(int i, int i2, int i3, int i4) {
        this.bHG.set(i, i2, i3, i4);
    }

    public void z(int i, int i2, int i3) {
        this.bHF.row = i;
        this.bHF.column = i2;
        this.bHF.bHK = i3;
    }

    public C0117a Qn() {
        return this.bHF;
    }

    public Rect Qo() {
        int i = this.bHJ * this.bHF.column * this.bHF.bHK;
        int i2 = this.bHJ * this.bHF.row * this.bHF.bHK;
        this.bHI.set(i, i2, (this.bHJ * this.bHF.bHK) + i, (this.bHJ * this.bHF.bHK) + i2);
        return this.bHI;
    }

    /* renamed from: com.baidu.tbadk.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0117a {
        int bHK;
        int column;
        int row;

        public C0117a() {
        }

        public C0117a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bHK = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bHK + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0117a) {
                C0117a c0117a = (C0117a) obj;
                return this.row == c0117a.getRow() && this.column == c0117a.Me() && this.bHK == c0117a.Qp();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bHK * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Me() {
            return this.column;
        }

        public int Qp() {
            return this.bHK;
        }
    }
}
