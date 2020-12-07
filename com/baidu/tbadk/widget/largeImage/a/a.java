package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private final C0615a fLR;
    private Bitmap mBitmap;
    private int mBlockSize;
    private Canvas mCanvas;
    private final Rect mDst;
    private final Rect mPositionInOriginBitmap;
    private final Rect mSrc;

    public a(int i) {
        this.fLR = new C0615a();
        this.mSrc = new Rect();
        this.mDst = new Rect();
        this.mPositionInOriginBitmap = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.mBlockSize = i;
        this.mCanvas = new Canvas();
    }

    public a(Bitmap bitmap) {
        this.fLR = new C0615a();
        this.mSrc = new Rect();
        this.mDst = new Rect();
        this.mPositionInOriginBitmap = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.mSrc.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void clearBitmap() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean isSizeEqual(Rect rect) {
        return rect != null && rect.right - rect.left == this.mBlockSize && rect.bottom - rect.top == this.mBlockSize;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect getSrc() {
        return this.mSrc;
    }

    public Rect getDst() {
        return this.mDst;
    }

    public void setDstRect(int i, int i2, int i3, int i4) {
        this.mDst.set(i, i2, i3, i4);
    }

    public void setSrcRect(int i, int i2, int i3, int i4) {
        this.mSrc.set(i, i2, i3, i4);
    }

    public void setPosition(int i, int i2, int i3) {
        this.fLR.row = i;
        this.fLR.column = i2;
        this.fLR.sampleScale = i3;
    }

    public C0615a bIa() {
        return this.fLR;
    }

    public Rect getPositionInOriginBitmap() {
        int i = this.mBlockSize * this.fLR.column * this.fLR.sampleScale;
        int i2 = this.mBlockSize * this.fLR.row * this.fLR.sampleScale;
        this.mPositionInOriginBitmap.set(i, i2, (this.mBlockSize * this.fLR.sampleScale) + i, (this.mBlockSize * this.fLR.sampleScale) + i2);
        return this.mPositionInOriginBitmap;
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0615a {
        int column;
        int row;
        int sampleScale;

        public C0615a() {
        }

        public C0615a(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.sampleScale = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.sampleScale + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0615a) {
                C0615a c0615a = (C0615a) obj;
                return this.row == c0615a.getRow() && this.column == c0615a.getColumn() && this.sampleScale == c0615a.getSampleScale();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.sampleScale * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int getColumn() {
            return this.column;
        }

        public int getSampleScale() {
            return this.sampleScale;
        }
    }
}
