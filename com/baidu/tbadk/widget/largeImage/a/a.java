package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0120a beO;
    private final Rect beP;
    private final Rect beQ;
    private final Rect beR;
    private int beS;
    private Canvas beT;
    private Bitmap mBitmap;

    public a(int i) {
        this.beO = new C0120a();
        this.beP = new Rect();
        this.beQ = new Rect();
        this.beR = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.beS = i;
        this.beT = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.beO = new C0120a();
        this.beP = new Rect();
        this.beQ = new Rect();
        this.beR = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.beP.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.beT = new Canvas();
    }

    public void NQ() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.beT.setBitmap(this.mBitmap);
            this.beT.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean f(Rect rect) {
        return rect != null && rect.right - rect.left == this.beS && rect.bottom - rect.top == this.beS;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect NR() {
        return this.beP;
    }

    public Rect NS() {
        return this.beQ;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.beQ.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3, int i4) {
        this.beP.set(i, i2, i3, i4);
    }

    public void q(int i, int i2, int i3) {
        this.beO.row = i;
        this.beO.column = i2;
        this.beO.beU = i3;
    }

    public C0120a NT() {
        return this.beO;
    }

    public Rect NU() {
        int i = this.beS * this.beO.column * this.beO.beU;
        int i2 = this.beS * this.beO.row * this.beO.beU;
        this.beR.set(i, i2, (this.beS * this.beO.beU) + i, (this.beS * this.beO.beU) + i2);
        return this.beR;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0120a {
        int beU;
        int column;
        int row;

        public C0120a() {
        }

        public C0120a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.beU = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.beU + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0120a) {
                C0120a c0120a = (C0120a) obj;
                return this.row == c0120a.getRow() && this.column == c0120a.JM() && this.beU == c0120a.NV();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.beU * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int JM() {
            return this.column;
        }

        public int NV() {
            return this.beU;
        }
    }
}
