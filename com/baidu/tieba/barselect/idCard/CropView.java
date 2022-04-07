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
/* loaded from: classes3.dex */
public class CropView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float[] c;
    public Matrix d;
    public Bitmap e;
    public GestureDetector f;
    public ScaleGestureDetector g;
    public ScaleGestureDetector.OnScaleGestureListener h;
    public Rect i;

    /* loaded from: classes3.dex */
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
                this.a.d.postScale(scaleFactor, scaleFactor);
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
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
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.i(f, f2);
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
        this.b = 4.0f;
        this.c = new float[9];
        this.d = new Matrix();
        this.h = new a(this);
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
            this.d.getValues(this.c);
            float f = this.c[0];
            if (Math.abs(f) <= 0.1d) {
                f = this.c[1];
            }
            return Math.abs(f);
        }
        return invokeV.floatValue;
    }

    private void setBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, bitmap) == null) {
            this.e = bitmap;
            this.d.reset();
            d(getWidth(), getHeight());
            invalidate();
        }
    }

    public final void d(int i, int i2) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || i <= 0 || i2 <= 0 || (bitmap = this.e) == null) {
            return;
        }
        float min = Math.min((i2 * 1.0f) / bitmap.getHeight(), (i * 1.0f) / this.e.getWidth());
        this.d.setTranslate(0.0f, 0.0f);
        this.d.setScale(min, min, this.e.getWidth() / 2, this.e.getHeight() / 2);
        this.d.postTranslate((i - this.e.getWidth()) / 2, (i2 - this.e.getHeight()) / 2);
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
            this.d.invert(matrix);
            matrix.mapPoints(fArr2, fArr);
            Matrix matrix2 = new Matrix();
            Bitmap createBitmap = Bitmap.createBitmap((int) (rect.width() / scale), (int) (rect.height() / scale), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            Bitmap bitmap = this.e;
            matrix2.postTranslate(-fArr2[0], -fArr2[1]);
            canvas.drawBitmap(bitmap, matrix2, null);
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g = new ScaleGestureDetector(getContext(), this.h);
            this.f = new GestureDetector(getContext(), new b(this));
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.e == null) {
            return;
        }
        Matrix matrix = new Matrix();
        int width = this.e.getWidth() / 2;
        int height = this.e.getHeight() / 2;
        matrix.postTranslate(-width, -height);
        matrix.postRotate(i);
        matrix.postTranslate(height, width);
        Bitmap bitmap = this.e;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(this.e, matrix, null);
        this.e.recycle();
        this.e = createBitmap;
        d(getWidth(), getHeight());
        invalidate();
    }

    public final void h(ScaleGestureDetector scaleGestureDetector) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, scaleGestureDetector) == null) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            float scale = getScale();
            float f = this.a;
            if (scale * scaleFactor < f) {
                scaleFactor = f / scale;
            }
            float f2 = this.b;
            if (scale * scaleFactor > f2) {
                scaleFactor = f2 / scale;
            }
            this.d.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            invalidate();
        }
    }

    public final void i(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.d.getValues(this.c);
            float[] fArr = this.c;
            float f3 = fArr[2];
            float f4 = fArr[5];
            Rect restrictedBound = getRestrictedBound();
            if (restrictedBound != null) {
                float scale = getScale();
                float width = ((int) (this.e.getWidth() / scale)) + f3;
                float height = ((int) (this.e.getHeight() / scale)) + f4;
                int i = restrictedBound.left;
                if (f3 - f > i) {
                    f = f3 - i;
                }
                int i2 = restrictedBound.top;
                if (f4 - f2 > i2) {
                    f2 = f4 - i2;
                }
                if (f > 0.0f) {
                    int i3 = restrictedBound.right;
                    if (width - f < i3) {
                        f = width - i3;
                    }
                }
                if (f2 > 0.0f) {
                    int i4 = restrictedBound.bottom;
                    if (height - f2 < i4) {
                        f2 = height - i4;
                    }
                }
            }
            this.d.postTranslate(-f, -f2);
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.onDraw(canvas);
            Bitmap bitmap = this.e;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, this.d, null);
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
            return (this.f.onTouchEvent(motionEvent) || this.g.onTouchEvent(motionEvent)) || super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setFilePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            Bitmap bitmap = this.e;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.e.recycle();
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
                this.e = BitmapFactory.decodeFile(str, options);
            } catch (IOException e) {
                e.printStackTrace();
                this.e = decodeFile;
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
            setBitmap(this.e);
        }
    }

    public void setMaximumScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            this.b = f;
        }
    }

    public void setMinimumScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f) == null) {
            this.a = f;
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
        this.b = 4.0f;
        this.c = new float[9];
        this.d = new Matrix();
        this.h = new a(this);
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
        this.b = 4.0f;
        this.c = new float[9];
        this.d = new Matrix();
        this.h = new a(this);
        f();
    }
}
