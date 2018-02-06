package com.baidu.tbadk.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0116a bHP;
    private final Rect bHQ;
    private final Rect bHR;
    private final Rect bHS;
    private int bHT;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.bHP = new C0116a();
        this.bHQ = new Rect();
        this.bHR = new Rect();
        this.bHS = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bHT = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bHP = new C0116a();
        this.bHQ = new Rect();
        this.bHR = new Rect();
        this.bHS = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.bHQ.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
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
        return rect != null && rect.right - rect.left == this.bHT && rect.bottom - rect.top == this.bHT;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect Ql() {
        return this.bHQ;
    }

    public Rect Qm() {
        return this.bHR;
    }

    public void r(int i, int i2, int i3, int i4) {
        this.bHR.set(i, i2, i3, i4);
    }

    public void s(int i, int i2, int i3, int i4) {
        this.bHQ.set(i, i2, i3, i4);
    }

    public void z(int i, int i2, int i3) {
        this.bHP.row = i;
        this.bHP.column = i2;
        this.bHP.bHU = i3;
    }

    public C0116a Qn() {
        return this.bHP;
    }

    public Rect Qo() {
        int i = this.bHT * this.bHP.column * this.bHP.bHU;
        int i2 = this.bHT * this.bHP.row * this.bHP.bHU;
        this.bHS.set(i, i2, (this.bHT * this.bHP.bHU) + i, (this.bHT * this.bHP.bHU) + i2);
        return this.bHS;
    }

    /* renamed from: com.baidu.tbadk.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0116a {
        int bHU;
        int column;
        int row;

        public C0116a() {
        }

        public C0116a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bHU = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bHU + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0116a) {
                C0116a c0116a = (C0116a) obj;
                return this.row == c0116a.getRow() && this.column == c0116a.Me() && this.bHU == c0116a.Qp();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bHU * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Me() {
            return this.column;
        }

        public int Qp() {
            return this.bHU;
        }
    }
}
