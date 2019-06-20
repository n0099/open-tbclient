package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private Canvas aKd;
    private final C0261a cGS;
    private final Rect cGT;
    private final Rect cGU;
    private final Rect cGV;
    private int cGW;
    private Bitmap mBitmap;

    public a(int i) {
        this.cGS = new C0261a();
        this.cGT = new Rect();
        this.cGU = new Rect();
        this.cGV = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.cGW = i;
        this.aKd = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.cGS = new C0261a();
        this.cGT = new Rect();
        this.cGU = new Rect();
        this.cGV = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.cGT.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.aKd = new Canvas();
    }

    public void awy() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.aKd.setBitmap(this.mBitmap);
            this.aKd.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean g(Rect rect) {
        return rect != null && rect.right - rect.left == this.cGW && rect.bottom - rect.top == this.cGW;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect awz() {
        return this.cGT;
    }

    public Rect awA() {
        return this.cGU;
    }

    public void m(int i, int i2, int i3, int i4) {
        this.cGU.set(i, i2, i3, i4);
    }

    public void n(int i, int i2, int i3, int i4) {
        this.cGT.set(i, i2, i3, i4);
    }

    public void u(int i, int i2, int i3) {
        this.cGS.row = i;
        this.cGS.column = i2;
        this.cGS.cGX = i3;
    }

    public C0261a awB() {
        return this.cGS;
    }

    public Rect awC() {
        int i = this.cGW * this.cGS.column * this.cGS.cGX;
        int i2 = this.cGW * this.cGS.row * this.cGS.cGX;
        this.cGV.set(i, i2, (this.cGW * this.cGS.cGX) + i, (this.cGW * this.cGS.cGX) + i2);
        return this.cGV;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0261a {
        int cGX;
        int column;
        int row;

        public C0261a() {
        }

        public C0261a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.cGX = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.cGX + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0261a) {
                C0261a c0261a = (C0261a) obj;
                return this.row == c0261a.getRow() && this.column == c0261a.arW() && this.cGX == c0261a.awD();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.cGX * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int arW() {
            return this.column;
        }

        public int awD() {
            return this.cGX;
        }
    }
}
