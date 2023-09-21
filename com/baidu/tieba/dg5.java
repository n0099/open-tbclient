package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class dg5 {
    public static /* synthetic */ Interceptable $ic;
    public static final dg5 a;
    public static final HashMap<String, bg5> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947703607, "Lcom/baidu/tieba/dg5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947703607, "Lcom/baidu/tieba/dg5;");
                return;
            }
        }
        a = new dg5();
        HashMap<String, bg5> hashMap = new HashMap<>();
        b = hashMap;
        hashMap.put("SCENE_HOT_EVENT", a.b());
        b.put("SCENE_TOP_NOTIFY", a.c());
    }

    public final bg5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            bg5 bg5Var = new bg5();
            bg5Var.j(true);
            bg5Var.g(2);
            bg5Var.i(R.dimen.tbds63);
            bg5Var.f(R.color.CAM_X0304);
            bg5Var.h(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
            return bg5Var;
        }
        return (bg5) invokeV.objValue;
    }

    public dg5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final bg5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bg5 bg5Var = new bg5();
            bg5Var.j(false);
            bg5Var.g(1);
            bg5Var.f(R.color.CAM_X0301);
            return bg5Var;
        }
        return (bg5) invokeV.objValue;
    }

    @JvmStatic
    public static final bg5 a(String key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, key)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            if (b.containsKey(key)) {
                return b.get(key);
            }
            return b.get("SCENE_HOT_EVENT");
        }
        return (bg5) invokeL.objValue;
    }
}
