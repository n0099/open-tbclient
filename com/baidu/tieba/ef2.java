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
public class ef2 extends gz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Prefetch" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "SwanPrefetchResourcesApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ef2(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#prefetchResources params=" + str, false);
            Pair<d32, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return (d32) s.first;
            }
            if (!SwanAppNetworkUtils.i(ku2.c())) {
                return new d32(1001, "network disconnected");
            }
            JSONArray c = do3.c(jSONObject, "video");
            if (c != null && c.length() > 0) {
                ku2.U().a(c);
            }
            JSONArray c2 = do3.c(jSONObject, "image");
            if (c2 != null && c2.length() > 0) {
                ku2.U().c(c2);
            }
            return d32.f();
        }
        return (d32) invokeL.objValue;
    }
}
