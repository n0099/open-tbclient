package com.baidu.tieba.compatible;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class BlurDrawable {
    public static /* synthetic */ Interceptable $ic;
    public static boolean enabled;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap mBitmapToBlur;
    public Allocation mBlurInput;
    public Allocation mBlurOutput;
    public ScriptIntrinsicBlur mBlurScript;
    public Bitmap mBlurredBitmap;
    public RenderScript mRenderScript;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1642874263, "Lcom/baidu/tieba/compatible/BlurDrawable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1642874263, "Lcom/baidu/tieba/compatible/BlurDrawable;");
                return;
            }
        }
        enabled = Build.VERSION.SDK_INT >= 17;
    }

    public BlurDrawable(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context == null) {
            return;
        }
        initializeRenderScript(context);
    }

    @TargetApi(17)
    private void initializeRenderScript(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            try {
                if (enabled) {
                    RenderScript create = RenderScript.create(context);
                    this.mRenderScript = create;
                    this.mBlurScript = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                enabled = false;
            }
        }
    }

    @TargetApi(17)
    public void blur(Bitmap bitmap, Bitmap bitmap2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bitmap, bitmap2) == null) && enabled) {
            this.mBlurInput.copyFrom(bitmap);
            this.mBlurScript.setInput(this.mBlurInput);
            this.mBlurScript.forEach(this.mBlurOutput);
            this.mBlurOutput.copyTo(bitmap2);
        }
    }

    @TargetApi(17)
    public boolean drawBlur() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (enabled && prepare()) {
                blur(this.mBitmapToBlur, this.mBlurredBitmap);
                Canvas canvas = new Canvas(this.mBlurredBitmap);
                Rect rect = new Rect(0, 0, this.mBlurredBitmap.getWidth(), this.mBlurredBitmap.getHeight());
                Paint paint = new Paint();
                paint.setColor(Color.parseColor("#4C000000"));
                canvas.drawRect(rect, paint);
                canvas.scale(0.0625f, 0.0625f);
            }
            return enabled;
        }
        return invokeV.booleanValue;
    }

    public Bitmap getBlurredBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBlurredBitmap : (Bitmap) invokeV.objValue;
    }

    @TargetApi(17)
    public void init(int i2, int i3, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, bitmap) == null) && enabled && i2 > 0 && i3 > 0 && bitmap != null) {
            try {
                this.mBlurScript.setRadius(i2);
                Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                Matrix matrix = new Matrix();
                float f2 = 1.0f / i3;
                matrix.postScale(f2, f2);
                this.mBitmapToBlur = Bitmap.createBitmap(copy, 0, 0, copy.getWidth(), copy.getHeight(), matrix, true);
            } catch (Exception unused) {
            }
        }
    }

    @TargetApi(17)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && enabled) {
            RenderScript renderScript = this.mRenderScript;
            if (renderScript != null) {
                renderScript.destroy();
            }
            Bitmap bitmap = this.mBitmapToBlur;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.mBitmapToBlur.recycle();
                this.mBitmapToBlur = null;
            }
            Bitmap bitmap2 = this.mBlurredBitmap;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            this.mBlurredBitmap.recycle();
            this.mBlurredBitmap = null;
        }
    }

    public boolean prepare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Bitmap bitmap = this.mBitmapToBlur;
            if (bitmap == null || bitmap.isRecycled()) {
                return false;
            }
            this.mBlurredBitmap = Bitmap.createBitmap(this.mBitmapToBlur.getWidth(), this.mBitmapToBlur.getHeight(), Bitmap.Config.ARGB_8888);
            Allocation createFromBitmap = Allocation.createFromBitmap(this.mRenderScript, this.mBitmapToBlur, Allocation.MipmapControl.MIPMAP_NONE, 1);
            this.mBlurInput = createFromBitmap;
            this.mBlurOutput = Allocation.createTyped(this.mRenderScript, createFromBitmap.getType());
            return true;
        }
        return invokeV.booleanValue;
    }
}
