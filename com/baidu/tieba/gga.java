package com.baidu.tieba;

import com.baidu.tieba.push.guide.Scene;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
/* compiled from: Scene.kt */
/* loaded from: classes6.dex */
public final /* synthetic */ class gga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmStatic
    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? Scene.c.c(str) : invokeL.intValue;
    }
}
