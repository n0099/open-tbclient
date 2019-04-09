package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private Canvas aIk;
    private final C0246a cyI;
    private final Rect cyJ;
    private final Rect cyK;
    private final Rect cyL;
    private int cyM;
    private Bitmap mBitmap;

    public a(int i) {
        this.cyI = new C0246a();
        this.cyJ = new Rect();
        this.cyK = new Rect();
        this.cyL = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.cyM = i;
        this.aIk = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.cyI = new C0246a();
        this.cyJ = new Rect();
        this.cyK = new Rect();
        this.cyL = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.cyJ.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.aIk = new Canvas();
    }

    public void arr() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.aIk.setBitmap(this.mBitmap);
            this.aIk.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean g(Rect rect) {
        return rect != null && rect.right - rect.left == this.cyM && rect.bottom - rect.top == this.cyM;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect ars() {
        return this.cyJ;
    }

    public Rect art() {
        return this.cyK;
    }

    public void m(int i, int i2, int i3, int i4) {
        this.cyK.set(i, i2, i3, i4);
    }

    public void n(int i, int i2, int i3, int i4) {
        this.cyJ.set(i, i2, i3, i4);
    }

    public void t(int i, int i2, int i3) {
        this.cyI.row = i;
        this.cyI.column = i2;
        this.cyI.cyN = i3;
    }

    public C0246a aru() {
        return this.cyI;
    }

    public Rect arv() {
        int i = this.cyM * this.cyI.column * this.cyI.cyN;
        int i2 = this.cyM * this.cyI.row * this.cyI.cyN;
        this.cyL.set(i, i2, (this.cyM * this.cyI.cyN) + i, (this.cyM * this.cyI.cyN) + i2);
        return this.cyL;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0246a {
        int column;
        int cyN;
        int row;

        public C0246a() {
        }

        public C0246a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.cyN = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.cyN + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0246a) {
                C0246a c0246a = (C0246a) obj;
                return this.row == c0246a.getRow() && this.column == c0246a.amT() && this.cyN == c0246a.arw();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.cyN * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int amT() {
            return this.column;
        }

        public int arw() {
            return this.cyN;
        }
    }
}
