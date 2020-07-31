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
import java.io.IOException;
/* loaded from: classes15.dex */
public class CropView extends View {
    private Bitmap bitmap;
    private float gRO;
    private float gRP;
    private float[] gRQ;
    private ScaleGestureDetector gRR;
    private ScaleGestureDetector.OnScaleGestureListener gRS;
    private Rect gRT;
    private GestureDetector gestureDetector;
    private Matrix matrix;
    int rotation;

    public CropView(Context context) {
        super(context);
        this.gRO = 0.2f;
        this.gRP = 4.0f;
        this.gRQ = new float[9];
        this.matrix = new Matrix();
        this.gRS = new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.baidu.tieba.barselect.idCard.CropView.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                CropView.this.a(scaleGestureDetector);
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                CropView.this.matrix.postScale(scaleFactor, scaleFactor);
                CropView.this.invalidate();
            }
        };
        this.rotation = 0;
        init();
    }

    public CropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gRO = 0.2f;
        this.gRP = 4.0f;
        this.gRQ = new float[9];
        this.matrix = new Matrix();
        this.gRS = new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.baidu.tieba.barselect.idCard.CropView.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                CropView.this.a(scaleGestureDetector);
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                CropView.this.matrix.postScale(scaleFactor, scaleFactor);
                CropView.this.invalidate();
            }
        };
        this.rotation = 0;
        init();
    }

    public CropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gRO = 0.2f;
        this.gRP = 4.0f;
        this.gRQ = new float[9];
        this.matrix = new Matrix();
        this.gRS = new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.baidu.tieba.barselect.idCard.CropView.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                CropView.this.a(scaleGestureDetector);
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                CropView.this.matrix.postScale(scaleFactor, scaleFactor);
                CropView.this.invalidate();
            }
        };
        this.rotation = 0;
        init();
    }

    public void setFilePath(String str) {
        if (this.bitmap != null && !this.bitmap.isRecycled()) {
            this.bitmap.recycle();
        }
        if (str != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt(android.support.media.ExifInterface.TAG_ORIENTATION, 1);
                Matrix matrix = new Matrix();
                int sZ = com.baidu.tieba.barselect.a.c.sZ(attributeInt);
                if (attributeInt != 0.0f) {
                    matrix.preRotate(sZ);
                }
                int min = Math.min(Math.min(options.outWidth, options.outHeight), 2560);
                Point point = new Point();
                ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getSize(point);
                int min2 = Math.min(min, (point.x * 2) / 3);
                options.inSampleSize = com.baidu.tieba.barselect.a.c.calculateInSampleSize(options, min2, min2);
                options.inScaled = true;
                options.inDensity = options.outWidth;
                options.inTargetDensity = min2 * options.inSampleSize;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                options.inJustDecodeBounds = false;
                this.bitmap = BitmapFactory.decodeFile(str, options);
            } catch (IOException e) {
                e.printStackTrace();
                this.bitmap = decodeFile;
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
            setBitmap(this.bitmap);
        }
    }

    private void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.matrix.reset();
        bN(getWidth(), getHeight());
        this.rotation = 0;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bN(i, i2);
        invalidate();
    }

    public Bitmap e(Rect rect) {
        float scale = getScale();
        float[] fArr = {rect.left, rect.top};
        float[] fArr2 = {0.0f, 0.0f};
        Matrix matrix = new Matrix();
        this.matrix.invert(matrix);
        matrix.mapPoints(fArr2, fArr);
        Matrix matrix2 = new Matrix();
        Bitmap createBitmap = Bitmap.createBitmap((int) (rect.width() / scale), (int) (rect.height() / scale), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Bitmap bitmap = this.bitmap;
        matrix2.postTranslate(-fArr2[0], -fArr2[1]);
        canvas.drawBitmap(bitmap, matrix2, null);
        return createBitmap;
    }

    public void setMinimumScale(float f) {
        this.gRO = f;
    }

    public void setMaximumScale(float f) {
        this.gRP = f;
    }

    private void init() {
        this.gRR = new ScaleGestureDetector(getContext(), this.gRS);
        this.gestureDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.barselect.idCard.CropView.2
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                CropView.this.v(f, f2);
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        });
    }

    public void rotate(int i) {
        if (this.bitmap != null) {
            Matrix matrix = new Matrix();
            int width = this.bitmap.getWidth() / 2;
            int height = this.bitmap.getHeight() / 2;
            matrix.postTranslate(-width, -height);
            matrix.postRotate(i);
            matrix.postTranslate(height, width);
            Bitmap bitmap = this.bitmap;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.bitmap, matrix, null);
            this.bitmap.recycle();
            this.bitmap = createBitmap;
            bN(getWidth(), getHeight());
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f, float f2) {
        this.matrix.getValues(this.gRQ);
        float f3 = this.gRQ[2];
        float f4 = this.gRQ[5];
        Rect restrictedBound = getRestrictedBound();
        if (restrictedBound != null) {
            float scale = getScale();
            float width = ((int) (this.bitmap.getWidth() / scale)) + f3;
            float height = ((int) (this.bitmap.getHeight() / scale)) + f4;
            if (f3 - f > restrictedBound.left) {
                f = f3 - restrictedBound.left;
            }
            if (f4 - f2 > restrictedBound.top) {
                f2 = f4 - restrictedBound.top;
            }
            if (f > 0.0f && width - f < restrictedBound.right) {
                f = width - restrictedBound.right;
            }
            if (f2 > 0.0f && height - f2 < restrictedBound.bottom) {
                f2 = height - restrictedBound.bottom;
            }
        }
        this.matrix.postTranslate(-f, -f2);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float scale = getScale();
        if (scale * scaleFactor < this.gRO) {
            scaleFactor = this.gRO / scale;
        }
        if (scale * scaleFactor > this.gRP) {
            scaleFactor = this.gRP / scale;
        }
        this.matrix.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        invalidate();
    }

    private void bN(int i, int i2) {
        if (i > 0 && i2 > 0 && this.bitmap != null) {
            float min = Math.min((i2 * 1.0f) / this.bitmap.getHeight(), (i * 1.0f) / this.bitmap.getWidth());
            this.matrix.setTranslate(0.0f, 0.0f);
            this.matrix.setScale(min, min, this.bitmap.getWidth() / 2, this.bitmap.getHeight() / 2);
            this.matrix.postTranslate((i - this.bitmap.getWidth()) / 2, (i2 - this.bitmap.getHeight()) / 2);
            invalidate();
        }
    }

    private float getScale() {
        this.matrix.getValues(this.gRQ);
        float f = this.gRQ[0];
        if (Math.abs(f) <= 0.1d) {
            f = this.gRQ[1];
        }
        return Math.abs(f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bitmap != null) {
            canvas.drawBitmap(this.bitmap, this.matrix, null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.gestureDetector.onTouchEvent(motionEvent) || this.gRR.onTouchEvent(motionEvent)) || super.onTouchEvent(motionEvent);
    }

    private Rect getRestrictedBound() {
        return this.gRT;
    }

    public void setRestrictBound(Rect rect) {
        this.gRT = rect;
    }
}
