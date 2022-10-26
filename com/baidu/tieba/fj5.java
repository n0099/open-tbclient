package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Random;
/* loaded from: classes4.dex */
public class fj5 {
    public static /* synthetic */ Interceptable $ic;
    public static final float a;
    public static final Random b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947766072, "Lcom/baidu/tieba/fj5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947766072, "Lcom/baidu/tieba/fj5;");
                return;
            }
        }
        a = ux4.k().l("key_tb_image_view_track_sample", 0);
        b = new Random();
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str) || !str.contains("tiebapic.baidu.com") || str.contains("w%3D120%3Bh%3D120")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a > b.nextInt(100000)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void c(String str, float f) {
        String simpleName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLF(65539, null, str, f) != null) || !a(str) || !b()) {
            return;
        }
        Activity f2 = n9.g().f(n9.g().h() - 1);
        if (f2 == null) {
            simpleName = "unknown";
        } else {
            simpleName = f2.getClass().getSimpleName();
        }
        TiebaStatic.log(new StatisticItem("TbImageViewTrack").param("obj_name", str).param("obj_source", simpleName).param("obj_param1", String.format("%.2f", Float.valueOf(f))).param(TiebaStatic.Params.OBJ_PARAM2, ma.c(simpleName)));
    }
}
