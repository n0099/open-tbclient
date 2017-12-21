package com.baidu.tbadk.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0079a aRI;
    private final Rect aRJ;
    private final Rect aRK;
    private final Rect aRL;
    private int aRM;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.aRI = new C0079a();
        this.aRJ = new Rect();
        this.aRK = new Rect();
        this.aRL = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.aRM = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.aRI = new C0079a();
        this.aRJ = new Rect();
        this.aRK = new Rect();
        this.aRL = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.aRJ.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
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
        return rect != null && rect.right - rect.left == this.aRM && rect.bottom - rect.top == this.aRM;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect Ir() {
        return this.aRJ;
    }

    public Rect Is() {
        return this.aRK;
    }

    public void j(int i, int i2, int i3, int i4) {
        this.aRK.set(i, i2, i3, i4);
    }

    public void k(int i, int i2, int i3, int i4) {
        this.aRJ.set(i, i2, i3, i4);
    }

    public void p(int i, int i2, int i3) {
        this.aRI.row = i;
        this.aRI.column = i2;
        this.aRI.aRN = i3;
    }

    public C0079a It() {
        return this.aRI;
    }

    public Rect Iu() {
        int i = this.aRM * this.aRI.column * this.aRI.aRN;
        int i2 = this.aRM * this.aRI.row * this.aRI.aRN;
        this.aRL.set(i, i2, (this.aRM * this.aRI.aRN) + i, (this.aRM * this.aRI.aRN) + i2);
        return this.aRL;
    }

    /* renamed from: com.baidu.tbadk.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0079a {
        int aRN;
        int column;
        int row;

        public C0079a() {
        }

        public C0079a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aRN = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.aRN + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0079a) {
                C0079a c0079a = (C0079a) obj;
                return this.row == c0079a.getRow() && this.column == c0079a.Eh() && this.aRN == c0079a.Iv();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.aRN * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Eh() {
            return this.column;
        }

        public int Iv() {
            return this.aRN;
        }
    }
}
