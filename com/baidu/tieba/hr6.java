package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class hr6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Bitmap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947833373, "Lcom/baidu/tieba/hr6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947833373, "Lcom/baidu/tieba/hr6;");
                return;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        a = createBitmap;
    }

    public static final Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (Bitmap) invokeV.objValue;
    }

    public static final boolean a(zp6 zp6Var, zp6 zp6Var2, zr6 zr6Var, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{zp6Var, zp6Var2, zr6Var, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int width = zr6Var.getWidth();
            float q = zp6Var.f().q();
            float q2 = zp6Var2.f().q();
            long j3 = j - zp6Var.j();
            float f = width;
            float f2 = (float) j2;
            if (f - ((q2 + f) * (((float) (j - zp6Var2.j())) / f2)) < (f - ((f + q) * (((float) j3) / f2))) + q) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static final boolean c(zp6 zp6Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, zp6Var, j)) == null) {
            Intrinsics.checkNotNullParameter(zp6Var, "<this>");
            if (j - zp6Var.j() < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean d(zp6 zp6Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, zp6Var, j)) == null) {
            Intrinsics.checkNotNullParameter(zp6Var, "<this>");
            if (!e(zp6Var, j) && !c(zp6Var, j)) {
                return false;
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean e(zp6 zp6Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, zp6Var, j)) == null) {
            Intrinsics.checkNotNullParameter(zp6Var, "<this>");
            if (j - zp6Var.j() > zp6Var.g()) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean f(zp6 zp6Var, zp6 danmaku, zr6 displayer, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{zp6Var, danmaku, displayer, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Intrinsics.checkNotNullParameter(zp6Var, "<this>");
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            if (d(zp6Var, j)) {
                return false;
            }
            long j3 = danmaku.j() - zp6Var.j();
            if (j3 <= 0) {
                return true;
            }
            if (Math.abs(j3) >= j2 || e(zp6Var, j) || e(danmaku, j)) {
                return false;
            }
            if (zp6Var.e().j() != 5 && zp6Var.e().j() != 4 && !a(zp6Var, danmaku, displayer, j, j2) && !a(zp6Var, danmaku, displayer, j + j2, j2)) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
