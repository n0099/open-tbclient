package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private Canvas aIj;
    private final C0246a cyH;
    private final Rect cyI;
    private final Rect cyJ;
    private final Rect cyK;
    private int cyL;
    private Bitmap mBitmap;

    public a(int i) {
        this.cyH = new C0246a();
        this.cyI = new Rect();
        this.cyJ = new Rect();
        this.cyK = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.cyL = i;
        this.aIj = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.cyH = new C0246a();
        this.cyI = new Rect();
        this.cyJ = new Rect();
        this.cyK = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.cyI.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.aIj = new Canvas();
    }

    public void arr() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.aIj.setBitmap(this.mBitmap);
            this.aIj.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean g(Rect rect) {
        return rect != null && rect.right - rect.left == this.cyL && rect.bottom - rect.top == this.cyL;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect ars() {
        return this.cyI;
    }

    public Rect art() {
        return this.cyJ;
    }

    public void m(int i, int i2, int i3, int i4) {
        this.cyJ.set(i, i2, i3, i4);
    }

    public void n(int i, int i2, int i3, int i4) {
        this.cyI.set(i, i2, i3, i4);
    }

    public void t(int i, int i2, int i3) {
        this.cyH.row = i;
        this.cyH.column = i2;
        this.cyH.cyM = i3;
    }

    public C0246a aru() {
        return this.cyH;
    }

    public Rect arv() {
        int i = this.cyL * this.cyH.column * this.cyH.cyM;
        int i2 = this.cyL * this.cyH.row * this.cyH.cyM;
        this.cyK.set(i, i2, (this.cyL * this.cyH.cyM) + i, (this.cyL * this.cyH.cyM) + i2);
        return this.cyK;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0246a {
        int column;
        int cyM;
        int row;

        public C0246a() {
        }

        public C0246a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.cyM = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.cyM + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0246a) {
                C0246a c0246a = (C0246a) obj;
                return this.row == c0246a.getRow() && this.column == c0246a.amT() && this.cyM == c0246a.arw();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.cyM * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int amT() {
            return this.column;
        }

        public int arw() {
            return this.cyM;
        }
    }
}
