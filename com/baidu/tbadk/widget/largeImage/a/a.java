package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private Canvas aLj;
    private final C0272a cJk;
    private final Rect cJl;
    private final Rect cJm;
    private final Rect cJn;
    private int cJo;
    private Bitmap mBitmap;

    public a(int i) {
        this.cJk = new C0272a();
        this.cJl = new Rect();
        this.cJm = new Rect();
        this.cJn = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.cJo = i;
        this.aLj = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.cJk = new C0272a();
        this.cJl = new Rect();
        this.cJm = new Rect();
        this.cJn = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.cJl.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.aLj = new Canvas();
    }

    public void axY() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.aLj.setBitmap(this.mBitmap);
            this.aLj.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean g(Rect rect) {
        return rect != null && rect.right - rect.left == this.cJo && rect.bottom - rect.top == this.cJo;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect axZ() {
        return this.cJl;
    }

    public Rect aya() {
        return this.cJm;
    }

    public void q(int i, int i2, int i3, int i4) {
        this.cJm.set(i, i2, i3, i4);
    }

    public void r(int i, int i2, int i3, int i4) {
        this.cJl.set(i, i2, i3, i4);
    }

    public void v(int i, int i2, int i3) {
        this.cJk.cvQ = i;
        this.cJk.KX = i2;
        this.cJk.cJp = i3;
    }

    public C0272a ayb() {
        return this.cJk;
    }

    public Rect ayc() {
        int i = this.cJo * this.cJk.KX * this.cJk.cJp;
        int i2 = this.cJo * this.cJk.cvQ * this.cJk.cJp;
        this.cJn.set(i, i2, (this.cJo * this.cJk.cJp) + i, (this.cJo * this.cJk.cJp) + i2);
        return this.cJn;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0272a {
        int KX;
        int cJp;
        int cvQ;

        public C0272a() {
        }

        public C0272a(int i, int i2, int i3) {
            this.cvQ = i;
            this.KX = i2;
            this.cJp = i3;
        }

        public String toString() {
            return "Position{row=" + this.cvQ + ", column=" + this.KX + ", sampleScale=" + this.cJp + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0272a) {
                C0272a c0272a = (C0272a) obj;
                return this.cvQ == c0272a.atr() && this.KX == c0272a.atq() && this.cJp == c0272a.ayd();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.cvQ + 119) * 17) + this.KX)) + (this.cJp * 100);
        }

        public int atr() {
            return this.cvQ;
        }

        public int atq() {
            return this.KX;
        }

        public int ayd() {
            return this.cJp;
        }
    }
}
