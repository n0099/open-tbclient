package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        zn6 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65536, null) == null) && (b = b()) != null) {
            b.c();
        }
    }

    public static zn6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return (zn6) ServiceManager.getService(zn6.a);
        }
        return (zn6) invokeV.objValue;
    }

    public static void c() {
        zn6 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b = b()) != null) {
            b.b();
        }
    }

    public static JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            zn6 b = b();
            if (b != null) {
                return b.a();
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }
}
