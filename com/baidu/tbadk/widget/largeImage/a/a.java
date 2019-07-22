package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private Canvas aKL;
    private final C0258a cIm;
    private final Rect cIn;
    private final Rect cIo;
    private final Rect cIp;
    private int cIq;
    private Bitmap mBitmap;

    public a(int i) {
        this.cIm = new C0258a();
        this.cIn = new Rect();
        this.cIo = new Rect();
        this.cIp = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.cIq = i;
        this.aKL = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.cIm = new C0258a();
        this.cIn = new Rect();
        this.cIo = new Rect();
        this.cIp = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.cIn.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.aKL = new Canvas();
    }

    public void axK() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.aKL.setBitmap(this.mBitmap);
            this.aKL.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean g(Rect rect) {
        return rect != null && rect.right - rect.left == this.cIq && rect.bottom - rect.top == this.cIq;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect axL() {
        return this.cIn;
    }

    public Rect axM() {
        return this.cIo;
    }

    public void n(int i, int i2, int i3, int i4) {
        this.cIo.set(i, i2, i3, i4);
    }

    public void o(int i, int i2, int i3, int i4) {
        this.cIn.set(i, i2, i3, i4);
    }

    public void u(int i, int i2, int i3) {
        this.cIm.cuN = i;
        this.cIm.KX = i2;
        this.cIm.cIr = i3;
    }

    public C0258a axN() {
        return this.cIm;
    }

    public Rect axO() {
        int i = this.cIq * this.cIm.KX * this.cIm.cIr;
        int i2 = this.cIq * this.cIm.cuN * this.cIm.cIr;
        this.cIp.set(i, i2, (this.cIq * this.cIm.cIr) + i, (this.cIq * this.cIm.cIr) + i2);
        return this.cIp;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0258a {
        int KX;
        int cIr;
        int cuN;

        public C0258a() {
        }

        public C0258a(int i, int i2, int i3) {
            this.cuN = i;
            this.KX = i2;
            this.cIr = i3;
        }

        public String toString() {
            return "Position{row=" + this.cuN + ", column=" + this.KX + ", sampleScale=" + this.cIr + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0258a) {
                C0258a c0258a = (C0258a) obj;
                return this.cuN == c0258a.atd() && this.KX == c0258a.atc() && this.cIr == c0258a.axP();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.cuN + 119) * 17) + this.KX)) + (this.cIr * 100);
        }

        public int atd() {
            return this.cuN;
        }

        public int atc() {
            return this.KX;
        }

        public int axP() {
            return this.cIr;
        }
    }
}
