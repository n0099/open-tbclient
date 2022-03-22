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
import java.io.IOException;
/* loaded from: classes5.dex */
public class CropView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f31536b;

    /* renamed from: c  reason: collision with root package name */
    public float[] f31537c;

    /* renamed from: d  reason: collision with root package name */
    public Matrix f31538d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f31539e;

    /* renamed from: f  reason: collision with root package name */
    public GestureDetector f31540f;

    /* renamed from: g  reason: collision with root package name */
    public ScaleGestureDetector f31541g;

    /* renamed from: h  reason: collision with root package name */
    public ScaleGestureDetector.OnScaleGestureListener f31542h;
    public Rect i;

    /* loaded from: classes5.dex */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CropView a;

        public a(CropView cropView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cropView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cropView;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scaleGestureDetector)) == null) {
                this.a.h(scaleGestureDetector);
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
                this.a.f31538d.postScale(scaleFactor, scaleFactor);
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements GestureDetector.OnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CropView a;

        public b(CropView cropView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cropView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cropView;
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
                this.a.i(f2, f3);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0.2f;
        this.f31536b = 4.0f;
        this.f31537c = new float[9];
        this.f31538d = new Matrix();
        this.f31542h = new a(this);
        f();
    }

    private Rect getRestrictedBound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.i : (Rect) invokeV.objValue;
    }

    private float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            this.f31538d.getValues(this.f31537c);
            float f2 = this.f31537c[0];
            if (Math.abs(f2) <= 0.1d) {
                f2 = this.f31537c[1];
            }
            return Math.abs(f2);
        }
        return invokeV.floatValue;
    }

    private void setBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, bitmap) == null) {
            this.f31539e = bitmap;
            this.f31538d.reset();
            d(getWidth(), getHeight());
            invalidate();
        }
    }

    public final void d(int i, int i2) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || i <= 0 || i2 <= 0 || (bitmap = this.f31539e) == null) {
            return;
        }
        float min = Math.min((i2 * 1.0f) / bitmap.getHeight(), (i * 1.0f) / this.f31539e.getWidth());
        this.f31538d.setTranslate(0.0f, 0.0f);
        this.f31538d.setScale(min, min, this.f31539e.getWidth() / 2, this.f31539e.getHeight() / 2);
        this.f31538d.postTranslate((i - this.f31539e.getWidth()) / 2, (i2 - this.f31539e.getHeight()) / 2);
        invalidate();
    }

    public Bitmap e(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect)) == null) {
            float scale = getScale();
            float[] fArr = {rect.left, rect.top};
            float[] fArr2 = {0.0f, 0.0f};
            Matrix matrix = new Matrix();
            this.f31538d.invert(matrix);
            matrix.mapPoints(fArr2, fArr);
            Matrix matrix2 = new Matrix();
            Bitmap createBitmap = Bitmap.createBitmap((int) (rect.width() / scale), (int) (rect.height() / scale), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            Bitmap bitmap = this.f31539e;
            matrix2.postTranslate(-fArr2[0], -fArr2[1]);
            canvas.drawBitmap(bitmap, matrix2, null);
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f31541g = new ScaleGestureDetector(getContext(), this.f31542h);
            this.f31540f = new GestureDetector(getContext(), new b(this));
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.f31539e == null) {
            return;
        }
        Matrix matrix = new Matrix();
        int width = this.f31539e.getWidth() / 2;
        int height = this.f31539e.getHeight() / 2;
        matrix.postTranslate(-width, -height);
        matrix.postRotate(i);
        matrix.postTranslate(height, width);
        Bitmap bitmap = this.f31539e;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(this.f31539e, matrix, null);
        this.f31539e.recycle();
        this.f31539e = createBitmap;
        d(getWidth(), getHeight());
        invalidate();
    }

    public final void h(ScaleGestureDetector scaleGestureDetector) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, scaleGestureDetector) == null) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            float scale = getScale();
            float f2 = this.a;
            if (scale * scaleFactor < f2) {
                scaleFactor = f2 / scale;
            }
            float f3 = this.f31536b;
            if (scale * scaleFactor > f3) {
                scaleFactor = f3 / scale;
            }
            this.f31538d.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            invalidate();
        }
    }

    public final void i(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f31538d.getValues(this.f31537c);
            float[] fArr = this.f31537c;
            float f4 = fArr[2];
            float f5 = fArr[5];
            Rect restrictedBound = getRestrictedBound();
            if (restrictedBound != null) {
                float scale = getScale();
                float width = ((int) (this.f31539e.getWidth() / scale)) + f4;
                float height = ((int) (this.f31539e.getHeight() / scale)) + f5;
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
            this.f31538d.postTranslate(-f2, -f3);
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.onDraw(canvas);
            Bitmap bitmap = this.f31539e;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, this.f31538d, null);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            d(i, i2);
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            return (this.f31540f.onTouchEvent(motionEvent) || this.f31541g.onTouchEvent(motionEvent)) || super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setFilePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            Bitmap bitmap = this.f31539e;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f31539e.recycle();
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
                int min = Math.min(Math.min(options.outWidth, options.outHeight), 2560);
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
                this.f31539e = BitmapFactory.decodeFile(str, options);
            } catch (IOException e2) {
                e2.printStackTrace();
                this.f31539e = decodeFile;
            } catch (NullPointerException e3) {
                e3.printStackTrace();
            }
            setBitmap(this.f31539e);
        }
    }

    public void setMaximumScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            this.f31536b = f2;
        }
    }

    public void setMinimumScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            this.a = f2;
        }
    }

    public void setRestrictBound(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, rect) == null) {
            this.i = rect;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0.2f;
        this.f31536b = 4.0f;
        this.f31537c = new float[9];
        this.f31538d = new Matrix();
        this.f31542h = new a(this);
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 0.2f;
        this.f31536b = 4.0f;
        this.f31537c = new float[9];
        this.f31538d = new Matrix();
        this.f31542h = new a(this);
        f();
    }
}
