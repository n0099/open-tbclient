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
    private final C0263a cIt;
    private final Rect cIu;
    private final Rect cIv;
    private final Rect cIw;
    private int cIx;
    private Bitmap mBitmap;

    public a(int i) {
        this.cIt = new C0263a();
        this.cIu = new Rect();
        this.cIv = new Rect();
        this.cIw = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.cIx = i;
        this.aKL = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.cIt = new C0263a();
        this.cIu = new Rect();
        this.cIv = new Rect();
        this.cIw = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.cIu.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.aKL = new Canvas();
    }

    public void axM() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.aKL.setBitmap(this.mBitmap);
            this.aKL.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean g(Rect rect) {
        return rect != null && rect.right - rect.left == this.cIx && rect.bottom - rect.top == this.cIx;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect axN() {
        return this.cIu;
    }

    public Rect axO() {
        return this.cIv;
    }

    public void n(int i, int i2, int i3, int i4) {
        this.cIv.set(i, i2, i3, i4);
    }

    public void o(int i, int i2, int i3, int i4) {
        this.cIu.set(i, i2, i3, i4);
    }

    public void u(int i, int i2, int i3) {
        this.cIt.cuU = i;
        this.cIt.KX = i2;
        this.cIt.cIy = i3;
    }

    public C0263a axP() {
        return this.cIt;
    }

    public Rect axQ() {
        int i = this.cIx * this.cIt.KX * this.cIt.cIy;
        int i2 = this.cIx * this.cIt.cuU * this.cIt.cIy;
        this.cIw.set(i, i2, (this.cIx * this.cIt.cIy) + i, (this.cIx * this.cIt.cIy) + i2);
        return this.cIw;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0263a {
        int KX;
        int cIy;
        int cuU;

        public C0263a() {
        }

        public C0263a(int i, int i2, int i3) {
            this.cuU = i;
            this.KX = i2;
            this.cIy = i3;
        }

        public String toString() {
            return "Position{row=" + this.cuU + ", column=" + this.KX + ", sampleScale=" + this.cIy + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0263a) {
                C0263a c0263a = (C0263a) obj;
                return this.cuU == c0263a.atf() && this.KX == c0263a.ate() && this.cIy == c0263a.axR();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.cuU + 119) * 17) + this.KX)) + (this.cIy * 100);
        }

        public int atf() {
            return this.cuU;
        }

        public int ate() {
            return this.KX;
        }

        public int axR() {
            return this.cIy;
        }
    }
}
