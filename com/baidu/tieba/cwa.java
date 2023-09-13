package com.baidu.tieba;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cwa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Matrix a;
    public RectF b;

    public cwa(CameraCharacteristics cameraCharacteristics, RectF rectF) {
        int intValue;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cameraCharacteristics, rectF};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (a(rectF)) {
            Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
            if (num == null) {
                intValue = 90;
            } else {
                intValue = num.intValue();
            }
            this.b = new RectF(rect);
            Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            if (num2 != null && num2.intValue() == 0) {
                z = true;
            } else {
                z = false;
            }
            this.a = b(z, intValue, rectF);
            return;
        }
        throw new IllegalArgumentException("previewRect");
    }

    public final boolean a(RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rectF)) == null) {
            if (rectF.width() != 0.0f && rectF.height() != 0.0f) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public RectF c(RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rectF)) == null) {
            RectF rectF2 = new RectF();
            this.a.mapRect(rectF2, rectF);
            return rectF2;
        }
        return (RectF) invokeL.objValue;
    }

    public final Matrix b(boolean z, int i, RectF rectF) {
        InterceptResult invokeCommon;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), rectF})) == null) {
            Matrix matrix = new Matrix();
            if (z) {
                f = -1.0f;
            } else {
                f = 1.0f;
            }
            matrix.setScale(f, 1.0f);
            matrix.postRotate(-i);
            matrix.mapRect(rectF);
            Matrix matrix2 = new Matrix();
            matrix2.setRectToRect(rectF, this.b, Matrix.ScaleToFit.FILL);
            matrix.setConcat(matrix2, matrix);
            return matrix;
        }
        return (Matrix) invokeCommon.objValue;
    }
}
