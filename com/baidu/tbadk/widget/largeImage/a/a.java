package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private Canvas aIg;
    private final C0246a cyF;
    private final Rect cyG;
    private final Rect cyH;
    private final Rect cyI;
    private int cyJ;
    private Bitmap mBitmap;

    public a(int i) {
        this.cyF = new C0246a();
        this.cyG = new Rect();
        this.cyH = new Rect();
        this.cyI = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.cyJ = i;
        this.aIg = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.cyF = new C0246a();
        this.cyG = new Rect();
        this.cyH = new Rect();
        this.cyI = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.cyG.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.aIg = new Canvas();
    }

    public void aru() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.aIg.setBitmap(this.mBitmap);
            this.aIg.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean g(Rect rect) {
        return rect != null && rect.right - rect.left == this.cyJ && rect.bottom - rect.top == this.cyJ;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect arv() {
        return this.cyG;
    }

    public Rect arw() {
        return this.cyH;
    }

    public void m(int i, int i2, int i3, int i4) {
        this.cyH.set(i, i2, i3, i4);
    }

    public void n(int i, int i2, int i3, int i4) {
        this.cyG.set(i, i2, i3, i4);
    }

    public void t(int i, int i2, int i3) {
        this.cyF.row = i;
        this.cyF.column = i2;
        this.cyF.cyK = i3;
    }

    public C0246a arx() {
        return this.cyF;
    }

    public Rect ary() {
        int i = this.cyJ * this.cyF.column * this.cyF.cyK;
        int i2 = this.cyJ * this.cyF.row * this.cyF.cyK;
        this.cyI.set(i, i2, (this.cyJ * this.cyF.cyK) + i, (this.cyJ * this.cyF.cyK) + i2);
        return this.cyI;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0246a {
        int column;
        int cyK;
        int row;

        public C0246a() {
        }

        public C0246a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.cyK = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.cyK + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0246a) {
                C0246a c0246a = (C0246a) obj;
                return this.row == c0246a.getRow() && this.column == c0246a.amW() && this.cyK == c0246a.arz();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.cyK * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int amW() {
            return this.column;
        }

        public int arz() {
            return this.cyK;
        }
    }
}
