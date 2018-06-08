package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0122a bat;
    private final Rect bau;
    private final Rect bav;
    private final Rect baw;
    private int bax;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.bat = new C0122a();
        this.bau = new Rect();
        this.bav = new Rect();
        this.baw = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bax = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bat = new C0122a();
        this.bau = new Rect();
        this.bav = new Rect();
        this.baw = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.bau.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void Mg() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean e(Rect rect) {
        return rect != null && rect.right - rect.left == this.bax && rect.bottom - rect.top == this.bax;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect Mh() {
        return this.bau;
    }

    public Rect Mi() {
        return this.bav;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.bav.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3, int i4) {
        this.bau.set(i, i2, i3, i4);
    }

    public void o(int i, int i2, int i3) {
        this.bat.row = i;
        this.bat.column = i2;
        this.bat.bay = i3;
    }

    public C0122a Mj() {
        return this.bat;
    }

    public Rect Mk() {
        int i = this.bax * this.bat.column * this.bat.bay;
        int i2 = this.bax * this.bat.row * this.bat.bay;
        this.baw.set(i, i2, (this.bax * this.bat.bay) + i, (this.bax * this.bat.bay) + i2);
        return this.baw;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0122a {
        int bay;
        int column;
        int row;

        public C0122a() {
        }

        public C0122a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bay = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bay + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0122a) {
                C0122a c0122a = (C0122a) obj;
                return this.row == c0122a.getRow() && this.column == c0122a.Ij() && this.bay == c0122a.Ml();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bay * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Ij() {
            return this.column;
        }

        public int Ml() {
            return this.bay;
        }
    }
}
