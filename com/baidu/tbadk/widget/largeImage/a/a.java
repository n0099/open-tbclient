package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0178a boh;
    private final Rect boi;
    private final Rect boj;
    private final Rect bok;
    private int bol;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.boh = new C0178a();
        this.boi = new Rect();
        this.boj = new Rect();
        this.bok = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bol = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.boh = new C0178a();
        this.boi = new Rect();
        this.boj = new Rect();
        this.bok = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.boi.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void Rz() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean f(Rect rect) {
        return rect != null && rect.right - rect.left == this.bol && rect.bottom - rect.top == this.bol;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect RA() {
        return this.boi;
    }

    public Rect RB() {
        return this.boj;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.boj.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3, int i4) {
        this.boi.set(i, i2, i3, i4);
    }

    public void q(int i, int i2, int i3) {
        this.boh.row = i;
        this.boh.column = i2;
        this.boh.bom = i3;
    }

    public C0178a RC() {
        return this.boh;
    }

    public Rect RD() {
        int i = this.bol * this.boh.column * this.boh.bom;
        int i2 = this.bol * this.boh.row * this.boh.bom;
        this.bok.set(i, i2, (this.bol * this.boh.bom) + i, (this.bol * this.boh.bom) + i2);
        return this.bok;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0178a {
        int bom;
        int column;
        int row;

        public C0178a() {
        }

        public C0178a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bom = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bom + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0178a) {
                C0178a c0178a = (C0178a) obj;
                return this.row == c0178a.getRow() && this.column == c0178a.Ns() && this.bom == c0178a.RE();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bom * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Ns() {
            return this.column;
        }

        public int RE() {
            return this.bom;
        }
    }
}
