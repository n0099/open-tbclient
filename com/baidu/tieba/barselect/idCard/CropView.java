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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ImageUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.qrcodescanner.beans.QRCodeScannerBeanFactory;
import java.io.IOException;
/* loaded from: classes12.dex */
public class CropView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f42226e;

    /* renamed from: f  reason: collision with root package name */
    public float f42227f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f42228g;

    /* renamed from: h  reason: collision with root package name */
    public Matrix f42229h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f42230i;

    /* renamed from: j  reason: collision with root package name */
    public GestureDetector f42231j;
    public ScaleGestureDetector k;
    public ScaleGestureDetector.OnScaleGestureListener l;
    public Rect m;

    /* loaded from: classes12.dex */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CropView f42232e;

        public a(CropView cropView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cropView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42232e = cropView;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scaleGestureDetector)) == null) {
                this.f42232e.f(scaleGestureDetector);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, scaleGestureDetector)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, scaleGestureDetector) == null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                this.f42232e.f42229h.postScale(scaleFactor, scaleFactor);
                this.f42232e.invalidate();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements GestureDetector.OnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CropView f42233e;

        public b(CropView cropView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cropView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42233e = cropView;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f42233e.g(f2, f3);
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) {
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42226e = 0.2f;
        this.f42227f = 4.0f;
        this.f42228g = new float[9];
        this.f42229h = new Matrix();
        this.l = new a(this);
        e();
    }

    private Rect getRestrictedBound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.m : (Rect) invokeV.objValue;
    }

    private float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            this.f42229h.getValues(this.f42228g);
            float f2 = this.f42228g[0];
            if (Math.abs(f2) <= 0.1d) {
                f2 = this.f42228g[1];
            }
            return Math.abs(f2);
        }
        return invokeV.floatValue;
    }

    private void setBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, bitmap) == null) {
            this.f42230i = bitmap;
            this.f42229h.reset();
            d(getWidth(), getHeight());
            invalidate();
        }
    }

    public Bitmap crop(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rect)) == null) {
            float scale = getScale();
            float[] fArr = {rect.left, rect.top};
            float[] fArr2 = {0.0f, 0.0f};
            Matrix matrix = new Matrix();
            this.f42229h.invert(matrix);
            matrix.mapPoints(fArr2, fArr);
            Matrix matrix2 = new Matrix();
            Bitmap createBitmap = Bitmap.createBitmap((int) (rect.width() / scale), (int) (rect.height() / scale), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            Bitmap bitmap = this.f42230i;
            matrix2.postTranslate(-fArr2[0], -fArr2[1]);
            canvas.drawBitmap(bitmap, matrix2, null);
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void d(int i2, int i3) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || i2 <= 0 || i3 <= 0 || (bitmap = this.f42230i) == null) {
            return;
        }
        float min = Math.min((i3 * 1.0f) / bitmap.getHeight(), (i2 * 1.0f) / this.f42230i.getWidth());
        this.f42229h.setTranslate(0.0f, 0.0f);
        this.f42229h.setScale(min, min, this.f42230i.getWidth() / 2, this.f42230i.getHeight() / 2);
        this.f42229h.postTranslate((i2 - this.f42230i.getWidth()) / 2, (i3 - this.f42230i.getHeight()) / 2);
        invalidate();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k = new ScaleGestureDetector(getContext(), this.l);
            this.f42231j = new GestureDetector(getContext(), new b(this));
        }
    }

    public final void f(ScaleGestureDetector scaleGestureDetector) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, scaleGestureDetector) == null) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            float scale = getScale();
            float f2 = this.f42226e;
            if (scale * scaleFactor < f2) {
                scaleFactor = f2 / scale;
            }
            float f3 = this.f42227f;
            if (scale * scaleFactor > f3) {
                scaleFactor = f3 / scale;
            }
            this.f42229h.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            invalidate();
        }
    }

    public final void g(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f42229h.getValues(this.f42228g);
            float[] fArr = this.f42228g;
            float f4 = fArr[2];
            float f5 = fArr[5];
            Rect restrictedBound = getRestrictedBound();
            if (restrictedBound != null) {
                float scale = getScale();
                float width = ((int) (this.f42230i.getWidth() / scale)) + f4;
                float height = ((int) (this.f42230i.getHeight() / scale)) + f5;
                int i2 = restrictedBound.left;
                if (f4 - f2 > i2) {
                    f2 = f4 - i2;
                }
                int i3 = restrictedBound.top;
                if (f5 - f3 > i3) {
                    f3 = f5 - i3;
                }
                if (f2 > 0.0f) {
                    int i4 = restrictedBound.right;
                    if (width - f2 < i4) {
                        f2 = width - i4;
                    }
                }
                if (f3 > 0.0f) {
                    int i5 = restrictedBound.bottom;
                    if (height - f3 < i5) {
                        f3 = height - i5;
                    }
                }
            }
            this.f42229h.postTranslate(-f2, -f3);
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            Bitmap bitmap = this.f42230i;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, this.f42229h, null);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            d(i2, i3);
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            return (this.f42231j.onTouchEvent(motionEvent) || this.k.onTouchEvent(motionEvent)) || super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void rotate(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f42230i == null) {
            return;
        }
        Matrix matrix = new Matrix();
        int width = this.f42230i.getWidth() / 2;
        int height = this.f42230i.getHeight() / 2;
        matrix.postTranslate(-width, -height);
        matrix.postRotate(i2);
        matrix.postTranslate(height, width);
        Bitmap bitmap = this.f42230i;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(this.f42230i, matrix, null);
        this.f42230i.recycle();
        this.f42230i = createBitmap;
        d(getWidth(), getHeight());
        invalidate();
    }

    public void setFilePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            Bitmap bitmap = this.f42230i;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f42230i.recycle();
            }
            if (str == null) {
                return;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
                Matrix matrix = new Matrix();
                int exifToDegrees = ImageUtil.exifToDegrees(attributeInt);
                if (attributeInt != 0.0f) {
                    matrix.preRotate(exifToDegrees);
                }
                int min = Math.min(Math.min(options.outWidth, options.outHeight), (int) QRCodeScannerBeanFactory.QRCODE_WHITE_LIST);
                Point point = new Point();
                ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getSize(point);
                int min2 = Math.min(min, (point.x * 2) / 3);
                int calculateInSampleSize = ImageUtil.calculateInSampleSize(options, min2, min2);
                options.inSampleSize = calculateInSampleSize;
                options.inScaled = true;
                options.inDensity = options.outWidth;
                options.inTargetDensity = min2 * calculateInSampleSize;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                options.inJustDecodeBounds = false;
                this.f42230i = BitmapFactory.decodeFile(str, options);
            } catch (IOException e2) {
                e2.printStackTrace();
                this.f42230i = decodeFile;
            } catch (NullPointerException e3) {
                e3.printStackTrace();
            }
            setBitmap(this.f42230i);
        }
    }

    public void setMaximumScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            this.f42227f = f2;
        }
    }

    public void setMinimumScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            this.f42226e = f2;
        }
    }

    public void setRestrictBound(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, rect) == null) {
            this.m = rect;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42226e = 0.2f;
        this.f42227f = 4.0f;
        this.f42228g = new float[9];
        this.f42229h = new Matrix();
        this.l = new a(this);
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f42226e = 0.2f;
        this.f42227f = 4.0f;
        this.f42228g = new float[9];
        this.f42229h = new Matrix();
        this.l = new a(this);
        e();
    }
}
