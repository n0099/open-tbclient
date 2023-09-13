package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c92 implements j82 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public c92() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void d() {
        hb3 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65537, null) != null) || (M = hb3.M()) == null) {
            return;
        }
        qn3.j(M.getActivity());
        System.exit(0);
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j82
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return a92.e().getPath();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j82
    public void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            a = go3.i(bundle, "extraWSUrl");
            k82.i(go3.i(bundle, PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD));
            k82.j(go3.i(bundle, "slavePreload"));
        }
    }

    @Override // com.baidu.tieba.j82
    public void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            bundle.putString("extraWSUrl", a);
            bundle.putString("slavePreload", k82.c());
            bundle.putString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, k82.a());
        }
    }
}
