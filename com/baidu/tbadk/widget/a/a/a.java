package com.baidu.tbadk.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0066a aOq;
    private final Rect aOr;
    private final Rect aOs;
    private final Rect aOt;
    private int aOu;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public a(int i) {
        this.aOq = new C0066a();
        this.aOr = new Rect();
        this.aOs = new Rect();
        this.aOt = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.aOu = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.aOq = new C0066a();
        this.aOr = new Rect();
        this.aOs = new Rect();
        this.aOt = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.aOr.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void Hz() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean d(Rect rect) {
        return rect != null && rect.right - rect.left == this.aOu && rect.bottom - rect.top == this.aOu;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect HA() {
        return this.aOr;
    }

    public Rect HB() {
        return this.aOs;
    }

    public void j(int i, int i2, int i3, int i4) {
        this.aOs.set(i, i2, i3, i4);
    }

    public void k(int i, int i2, int i3, int i4) {
        this.aOr.set(i, i2, i3, i4);
    }

    public void p(int i, int i2, int i3) {
        this.aOq.row = i;
        this.aOq.column = i2;
        this.aOq.aOv = i3;
    }

    public C0066a HC() {
        return this.aOq;
    }

    public Rect HD() {
        int i = this.aOu * this.aOq.column * this.aOq.aOv;
        int i2 = this.aOu * this.aOq.row * this.aOq.aOv;
        this.aOt.set(i, i2, (this.aOu * this.aOq.aOv) + i, (this.aOu * this.aOq.aOv) + i2);
        return this.aOt;
    }

    /* renamed from: com.baidu.tbadk.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0066a {
        int aOv;
        int column;
        int row;

        public C0066a() {
        }

        public C0066a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.aOv = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.aOv + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0066a) {
                C0066a c0066a = (C0066a) obj;
                return this.row == c0066a.getRow() && this.column == c0066a.Dx() && this.aOv == c0066a.HE();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.aOv * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int Dx() {
            return this.column;
        }

        public int HE() {
            return this.aOv;
        }
    }
}
