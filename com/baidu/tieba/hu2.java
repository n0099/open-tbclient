package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hu2 extends gu2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hu2(double d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d;
    }

    @Override // com.baidu.tieba.gu2
    public boolean a(Bitmap bitmap, Rect rect) {
        InterceptResult invokeLL;
        Rect rect2;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bitmap, rect)) == null) {
            if (gu2.c) {
                Log.d("ErrorPageParser", "GridErrorPageParser: start error page parse");
            }
            if (bitmap == null) {
                return false;
            }
            if (!b(bitmap, rect)) {
                rect2 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            } else {
                rect2 = rect;
            }
            int width = rect2.width() - 2;
            int height = rect2.height() - 2;
            int i3 = width / 3;
            int i4 = height / i3;
            int ceil = (int) Math.ceil(i4 * 3 * this.a);
            int i5 = 0;
            int i6 = 0;
            while (i6 < 3) {
                int i7 = rect2.left;
                int i8 = (i6 * i3) + 1 + i7;
                if (i6 == 2) {
                    i = width + 1;
                } else {
                    i = ((i6 + 1) * i3) + i7;
                }
                int i9 = i;
                int i10 = i5;
                int i11 = 0;
                while (i11 < i4) {
                    int i12 = rect2.top;
                    int i13 = (i11 * i3) + 1 + i12;
                    if (i11 == i4 - 1) {
                        i2 = height + 1;
                    } else {
                        i2 = ((i11 + 1) * i3) + i12;
                    }
                    int i14 = i11;
                    if (e(bitmap, i8, i13, i9, i2)) {
                        int i15 = i10 + 1;
                        if (i15 >= ceil) {
                            return true;
                        }
                        i10 = i15;
                    }
                    i11 = i14 + 1;
                }
                i6++;
                i5 = i10;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public double d(Bitmap bitmap, Rect rect) {
        InterceptResult invokeLL;
        Rect rect2;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, rect)) == null) {
            if (gu2.c) {
                Log.d("ErrorPageParser", "GridErrorPageParser: start error page parse");
            }
            if (bitmap == null) {
                return 0.0d;
            }
            if (!b(bitmap, rect)) {
                rect2 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            } else {
                rect2 = rect;
            }
            int width = rect2.width() - 2;
            int height = rect2.height() - 2;
            int i3 = width / 3;
            if (i3 == 0) {
                return 0.0d;
            }
            int i4 = height / i3;
            int i5 = 0;
            int i6 = 0;
            while (i5 < 3) {
                int i7 = rect2.left;
                int i8 = (i5 * i3) + 1 + i7;
                if (i5 == 2) {
                    i = width + 1;
                } else {
                    i = ((i5 + 1) * i3) + i7;
                }
                int i9 = i;
                int i10 = i6;
                int i11 = 0;
                while (i11 < i4) {
                    int i12 = rect2.top;
                    int i13 = (i11 * i3) + 1 + i12;
                    if (i11 == i4 - 1) {
                        i2 = height + 1;
                    } else {
                        i2 = ((i11 + 1) * i3) + i12;
                    }
                    int i14 = i11;
                    if (e(bitmap, i8, i13, i9, i2)) {
                        i10++;
                    }
                    i11 = i14 + 1;
                }
                i5++;
                i6 = i10;
            }
            return i6 / (i4 * 3);
        }
        return invokeLL.doubleValue;
    }

    public final boolean e(Bitmap bitmap, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i < 0 || i3 < i || i2 < 0 || i4 < i2) {
                return false;
            }
            int pixel = bitmap.getPixel(i, i2);
            while (i <= i3) {
                for (int i5 = i2; i5 <= i4; i5++) {
                    if (pixel != bitmap.getPixel(i, i5)) {
                        return false;
                    }
                }
                i++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
