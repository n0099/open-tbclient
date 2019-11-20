package com.baidu.tbadk.widget.largeImage.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a cSz;
    private final int mBlockSize;
    private final Rect mOriginalBitmapRect;
    private final int mRealHeight;
    private final int mRealWidth;
    private final RectF mStartWindow;
    private final RectF mWindowInOriginalBitmapRecF = new RectF();
    private final Rect mWindowInOriginalBitmap = new Rect();
    private float mScaleLevel = 1.0f;
    private final List<a> mBlockBitmapList = new ArrayList();
    private final Matrix mMatrix = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.mRealHeight = i2;
        this.mRealWidth = i;
        this.mStartWindow = new RectF(0.0f, 0.0f, i, i2);
        this.mOriginalBitmapRect = new Rect(0, 0, iArr[0], iArr[1]);
        this.mBlockSize = i / 2;
    }

    public int getBlockSize() {
        return this.mBlockSize;
    }

    public Rect getOriginalBitmapRect() {
        return this.mOriginalBitmapRect;
    }

    public Rect a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.getPositionInOriginBitmap();
    }

    public Point[] getStartAndEndPosition() {
        getWindowInOriginalBitmap();
        int sampleScale = getSampleScale();
        int i = (this.mWindowInOriginalBitmap.top / sampleScale) / this.mBlockSize;
        int i2 = (this.mWindowInOriginalBitmap.left / sampleScale) / this.mBlockSize;
        Point point = new Point();
        point.y = i;
        point.x = i2;
        Point point2 = new Point();
        point2.y = (((this.mWindowInOriginalBitmap.bottom / sampleScale) / this.mBlockSize) * sampleScale) + 1;
        point2.x = (sampleScale * ((this.mWindowInOriginalBitmap.right / sampleScale) / this.mBlockSize)) + 1;
        return new Point[]{point, point2};
    }

    public a ayH() {
        return new a(this.mBlockSize);
    }

    public Rect getWindowInOriginalBitmap() {
        this.mMatrix.mapRect(this.mWindowInOriginalBitmapRecF, this.mStartWindow);
        transFormRectToRectF(this.mWindowInOriginalBitmap, this.mWindowInOriginalBitmapRecF);
        return this.mWindowInOriginalBitmap;
    }

    private void transFormRectToRectF(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public int getRealWidth() {
        return this.mRealWidth;
    }

    public int getRealHeight() {
        return this.mRealHeight;
    }

    public List<a> getBlockBitmapList() {
        return this.mBlockBitmapList;
    }

    public void setScaleLevel(float f) {
        this.mScaleLevel = f;
    }

    public float getScaleLevel() {
        return this.mScaleLevel;
    }

    public int getSampleScale() {
        int i = 1;
        while (i < Math.round(this.mScaleLevel)) {
            i *= 2;
        }
        return i;
    }

    public void setThumbnail(Bitmap bitmap) {
        if (bitmap != null) {
            this.cSz = new a(bitmap);
            this.cSz.setDstRect(0, 0, this.mRealWidth, this.mRealHeight);
        }
    }

    public a ayI() {
        return this.cSz;
    }

    public void moveWindow(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    public void postScaleWindow(float f) {
        this.mMatrix.postScale(f, f);
    }

    public void postScaleWindow(float f, float f2, float f3) {
        this.mMatrix.postScale(f, f, f2, f3);
    }

    public boolean checkIsVisiable(int i, int i2, int i3) {
        if (i3 == getSampleScale()) {
            return getRect(i, i2, i3).intersect(this.mWindowInOriginalBitmap);
        }
        return false;
    }

    public Rect getRect(int i, int i2, int i3) {
        int i4 = this.mBlockSize * i3 * i2;
        int i5 = this.mBlockSize * i3 * i;
        return new Rect(i4, i5, (this.mBlockSize * i3) + i4, (this.mBlockSize * i3) + i5);
    }

    public void checkAndResizeBitmapRegion(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.right > this.mOriginalBitmapRect.right) {
            rect.right = this.mOriginalBitmapRect.right;
        }
        if (rect.bottom > this.mOriginalBitmapRect.bottom) {
            rect.bottom = this.mOriginalBitmapRect.bottom;
        }
    }
}
