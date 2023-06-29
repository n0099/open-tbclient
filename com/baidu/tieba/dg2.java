package com.baidu.tieba;

import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dg2 extends f02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.f02
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Prefetch" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "SwanPrefetchResourcesApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg2(@NonNull d02 d02Var) {
        super(d02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c42 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#prefetchResources params=" + str, false);
            Pair<c42, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return (c42) s.first;
            }
            if (!SwanAppNetworkUtils.i(jv2.c())) {
                return new c42(1001, "network disconnected");
            }
            JSONArray c = cp3.c(jSONObject, "video");
            if (c != null && c.length() > 0) {
                jv2.U().a(c);
            }
            JSONArray c2 = cp3.c(jSONObject, "image");
            if (c2 != null && c2.length() > 0) {
                jv2.U().c(c2);
            }
            return c42.f();
        }
        return (c42) invokeL.objValue;
    }
}
