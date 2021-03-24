package com.baidu.tieba.barselect.idCard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.WindowManager;
import com.baidu.wallet.qrcodescanner.beans.QRCodeScannerBeanFactory;
import d.b.i0.v.e.c;
import java.io.IOException;
/* loaded from: classes4.dex */
public class CropView extends View {

    /* renamed from: e  reason: collision with root package name */
    public float f15166e;

    /* renamed from: f  reason: collision with root package name */
    public float f15167f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f15168g;

    /* renamed from: h  reason: collision with root package name */
    public Matrix f15169h;
    public Bitmap i;
    public GestureDetector j;
    public ScaleGestureDetector k;
    public ScaleGestureDetector.OnScaleGestureListener l;
    public Rect m;

    /* loaded from: classes4.dex */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            CropView.this.h(scaleGestureDetector);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            CropView.this.f15169h.postScale(scaleFactor, scaleFactor);
            CropView.this.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements GestureDetector.OnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            CropView.this.i(f2, f3);
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    public CropView(Context context) {
        super(context);
        this.f15166e = 0.2f;
        this.f15167f = 4.0f;
        this.f15168g = new float[9];
        this.f15169h = new Matrix();
        this.l = new a();
        f();
    }

    private Rect getRestrictedBound() {
        return this.m;
    }

    private float getScale() {
        this.f15169h.getValues(this.f15168g);
        float f2 = this.f15168g[0];
        if (Math.abs(f2) <= 0.1d) {
            f2 = this.f15168g[1];
        }
        return Math.abs(f2);
    }

    private void setBitmap(Bitmap bitmap) {
        this.i = bitmap;
        this.f15169h.reset();
        d(getWidth(), getHeight());
        invalidate();
    }

    public final void d(int i, int i2) {
        Bitmap bitmap;
        if (i <= 0 || i2 <= 0 || (bitmap = this.i) == null) {
            return;
        }
        float min = Math.min((i2 * 1.0f) / bitmap.getHeight(), (i * 1.0f) / this.i.getWidth());
        this.f15169h.setTranslate(0.0f, 0.0f);
        this.f15169h.setScale(min, min, this.i.getWidth() / 2, this.i.getHeight() / 2);
        this.f15169h.postTranslate((i - this.i.getWidth()) / 2, (i2 - this.i.getHeight()) / 2);
        invalidate();
    }

    public Bitmap e(Rect rect) {
        float scale = getScale();
        float[] fArr = {rect.left, rect.top};
        float[] fArr2 = {0.0f, 0.0f};
        Matrix matrix = new Matrix();
        this.f15169h.invert(matrix);
        matrix.mapPoints(fArr2, fArr);
        Matrix matrix2 = new Matrix();
        Bitmap createBitmap = Bitmap.createBitmap((int) (rect.width() / scale), (int) (rect.height() / scale), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Bitmap bitmap = this.i;
        matrix2.postTranslate(-fArr2[0], -fArr2[1]);
        canvas.drawBitmap(bitmap, matrix2, null);
        return createBitmap;
    }

    public final void f() {
        this.k = new ScaleGestureDetector(getContext(), this.l);
        this.j = new GestureDetector(getContext(), new b());
    }

    public void g(int i) {
        if (this.i == null) {
            return;
        }
        Matrix matrix = new Matrix();
        int width = this.i.getWidth() / 2;
        int height = this.i.getHeight() / 2;
        matrix.postTranslate(-width, -height);
        matrix.postRotate(i);
        matrix.postTranslate(height, width);
        Bitmap bitmap = this.i;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(this.i, matrix, null);
        this.i.recycle();
        this.i = createBitmap;
        d(getWidth(), getHeight());
        invalidate();
    }

    public final void h(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float scale = getScale();
        float f2 = this.f15166e;
        if (scale * scaleFactor < f2) {
            scaleFactor = f2 / scale;
        }
        float f3 = this.f15167f;
        if (scale * scaleFactor > f3) {
            scaleFactor = f3 / scale;
        }
        this.f15169h.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        invalidate();
    }

    public final void i(float f2, float f3) {
        this.f15169h.getValues(this.f15168g);
        float[] fArr = this.f15168g;
        float f4 = fArr[2];
        float f5 = fArr[5];
        Rect restrictedBound = getRestrictedBound();
        if (restrictedBound != null) {
            float scale = getScale();
            float width = ((int) (this.i.getWidth() / scale)) + f4;
            float height = ((int) (this.i.getHeight() / scale)) + f5;
            int i = restrictedBound.left;
            if (f4 - f2 > i) {
                f2 = f4 - i;
            }
            int i2 = restrictedBound.top;
            if (f5 - f3 > i2) {
                f3 = f5 - i2;
            }
            if (f2 > 0.0f) {
                int i3 = restrictedBound.right;
                if (width - f2 < i3) {
                    f2 = width - i3;
                }
            }
            if (f3 > 0.0f) {
                int i4 = restrictedBound.bottom;
                if (height - f3 < i4) {
                    f3 = height - i4;
                }
            }
        }
        this.f15169h.postTranslate(-f2, -f3);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.i;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.f15169h, null);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        d(i, i2);
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.j.onTouchEvent(motionEvent) || this.k.onTouchEvent(motionEvent)) || super.onTouchEvent(motionEvent);
    }

    public void setFilePath(String str) {
        Bitmap bitmap = this.i;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.i.recycle();
        }
        if (str == null) {
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            Matrix matrix = new Matrix();
            int b2 = c.b(attributeInt);
            if (attributeInt != 0.0f) {
                matrix.preRotate(b2);
            }
            int min = Math.min(Math.min(options.outWidth, options.outHeight), (int) QRCodeScannerBeanFactory.QRCODE_WHITE_LIST);
            Point point = new Point();
            ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getSize(point);
            int min2 = Math.min(min, (point.x * 2) / 3);
            int a2 = c.a(options, min2, min2);
            options.inSampleSize = a2;
            options.inScaled = true;
            options.inDensity = options.outWidth;
            options.inTargetDensity = min2 * a2;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inJustDecodeBounds = false;
            this.i = BitmapFactory.decodeFile(str, options);
        } catch (IOException e2) {
            e2.printStackTrace();
            this.i = decodeFile;
        } catch (NullPointerException e3) {
            e3.printStackTrace();
        }
        setBitmap(this.i);
    }

    public void setMaximumScale(float f2) {
        this.f15167f = f2;
    }

    public void setMinimumScale(float f2) {
        this.f15166e = f2;
    }

    public void setRestrictBound(Rect rect) {
        this.m = rect;
    }

    public CropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15166e = 0.2f;
        this.f15167f = 4.0f;
        this.f15168g = new float[9];
        this.f15169h = new Matrix();
        this.l = new a();
        f();
    }

    public CropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15166e = 0.2f;
        this.f15167f = 4.0f;
        this.f15168g = new float[9];
        this.f15169h = new Matrix();
        this.l = new a();
        f();
    }
}
