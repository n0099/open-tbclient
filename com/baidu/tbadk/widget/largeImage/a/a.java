package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private Canvas bbA;
    private final C0120a bbv;
    private final Rect bbw;
    private final Rect bbx;
    private final Rect bby;
    private int bbz;
    private Bitmap mBitmap;

    public a(int i) {
        this.bbv = new C0120a();
        this.bbw = new Rect();
        this.bbx = new Rect();
        this.bby = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.bbz = i;
        this.bbA = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.bbv = new C0120a();
        this.bbw = new Rect();
        this.bbx = new Rect();
        this.bby = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.bbw.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.bbA = new Canvas();
    }

    public void My() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.bbA.setBitmap(this.mBitmap);
            this.bbA.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean f(Rect rect) {
        return rect != null && rect.right - rect.left == this.bbz && rect.bottom - rect.top == this.bbz;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect Mz() {
        return this.bbw;
    }

    public Rect MA() {
        return this.bbx;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.bbx.set(i, i2, i3, i4);
    }

    public void i(int i, int i2, int i3, int i4) {
        this.bbw.set(i, i2, i3, i4);
    }

    public void o(int i, int i2, int i3) {
        this.bbv.row = i;
        this.bbv.column = i2;
        this.bbv.bbB = i3;
    }

    public C0120a MB() {
        return this.bbv;
    }

    public Rect MC() {
        int i = this.bbz * this.bbv.column * this.bbv.bbB;
        int i2 = this.bbz * this.bbv.row * this.bbv.bbB;
        this.bby.set(i, i2, (this.bbz * this.bbv.bbB) + i, (this.bbz * this.bbv.bbB) + i2);
        return this.bby;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0120a {
        int bbB;
        int column;
        int row;

        public C0120a() {
        }

        public C0120a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.bbB = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.bbB + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0120a) {
                C0120a c0120a = (C0120a) obj;
                return this.row == c0120a.getRow() && this.column == c0120a.Iw() && this.bbB == c0120a.MD();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.bbB * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Iw() {
            return this.column;
        }

        public int MD() {
            return this.bbB;
        }
    }
}
