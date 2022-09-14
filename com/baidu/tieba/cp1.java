package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public final class cp1 extends bo2<cp1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface a {
        public static final String a = bo2.r("SwanFileFetcher.Params", "file_url");
        public static final String b = bo2.r("SwanFileFetcher.Params", "file_save_path");
        public static final String c = bo2.r("SwanFileFetcher.Params", "file_head_map");
        public static final String d = bo2.r("SwanFileFetcher.Params", "image_save_gallery");
        public static final String e = bo2.r("SwanFileFetcher.Params", "file_cancel_tag");
    }

    public cp1() {
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

    public cp1 E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? z(a.e, str) : (cp1) invokeL.objValue;
    }

    public cp1 F(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Bundle bundle = new Bundle();
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    bundle.putString(entry.getKey(), entry.getValue());
                }
            }
            return u(a.c, bundle);
        }
        return (cp1) invokeL.objValue;
    }

    public cp1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? z(a.b, str) : (cp1) invokeL.objValue;
    }

    public cp1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? z(a.a, str) : (cp1) invokeL.objValue;
    }

    public cp1 I(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? t(a.d, z) : (cp1) invokeZ.objValue;
    }

    public cp1 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (cp1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uh3
    public /* bridge */ /* synthetic */ uh3 a() {
        J();
        return this;
    }
}
