package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0178a bog;
    private final Rect boh;
    private final Rect boi;
    private final Rect boj;
    private int bok;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.bog = new C0178a();
        this.boh = new Rect();
        this.boi = new Rect();
        this.boj = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bok = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bog = new C0178a();
        this.boh = new Rect();
        this.boi = new Rect();
        this.boj = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.boh.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
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
        return rect != null && rect.right - rect.left == this.bok && rect.bottom - rect.top == this.bok;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect RA() {
        return this.boh;
    }

    public Rect RB() {
        return this.boi;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.boi.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3, int i4) {
        this.boh.set(i, i2, i3, i4);
    }

    public void q(int i, int i2, int i3) {
        this.bog.row = i;
        this.bog.column = i2;
        this.bog.bol = i3;
    }

    public C0178a RC() {
        return this.bog;
    }

    public Rect RD() {
        int i = this.bok * this.bog.column * this.bog.bol;
        int i2 = this.bok * this.bog.row * this.bog.bol;
        this.boj.set(i, i2, (this.bok * this.bog.bol) + i, (this.bok * this.bog.bol) + i2);
        return this.boj;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0178a {
        int bol;
        int column;
        int row;

        public C0178a() {
        }

        public C0178a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bol = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bol + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0178a) {
                C0178a c0178a = (C0178a) obj;
                return this.row == c0178a.getRow() && this.column == c0178a.Ns() && this.bol == c0178a.RE();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bol * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Ns() {
            return this.column;
        }

        public int RE() {
            return this.bol;
        }
    }
}
