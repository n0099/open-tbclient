package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class av6 {
    public static /* synthetic */ Interceptable $ic;
    public static final av6 a;
    public static final k0 b;
    public static final Class<? extends ct6>[] c;
    public static final k0 d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947628680, "Lcom/baidu/tieba/av6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947628680, "Lcom/baidu/tieba/av6;");
                return;
            }
        }
        a = new av6();
        k0 b2 = k0.d(ht6.class).b();
        Intrinsics.checkNotNullExpressionValue(b2, "all(ItemDataComponent::class.java).get()");
        b = b2;
        c = new Class[]{ht6.class, gt6.class};
        k0.b d2 = k0.d(ht6.class, gt6.class);
        d2.c(it6.class, kt6.class);
        k0 b3 = d2.b();
        Intrinsics.checkNotNullExpressionValue(b3, "all(\n        ItemDataCom…t::class.java\n    ).get()");
        d = b3;
    }

    public av6() {
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

    public final k0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return b;
        }
        return (k0) invokeV.objValue;
    }

    public final Class<? extends ct6>[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return c;
        }
        return (Class[]) invokeV.objValue;
    }

    public final k0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return d;
        }
        return (k0) invokeV.objValue;
    }
}
