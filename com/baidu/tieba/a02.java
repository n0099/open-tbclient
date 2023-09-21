package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.na3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a02 extends zz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a02(@NonNull hz1 hz1Var) {
        super(hz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((hz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public g32 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new g32(1001, "context not support");
            }
            pa2 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new g32(1001, "none fragmentManger");
            }
            ma2 m = X.m();
            if (!(m instanceof na3.a)) {
                return new g32(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new g32(1001, "fragment has detached");
            }
            oa3.c(m);
            g82.i("LoadingViewApi", "hide loading success");
            return g32.f();
        }
        return (g32) invokeV.objValue;
    }

    public g32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                g82.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new g32(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<g32, JSONObject> s = s(str);
            g32 g32Var = (g32) s.first;
            if (!g32Var.isSuccess()) {
                return g32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            g82.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new g32(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new g32(1001, "context not support");
            }
            pa2 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new g32(1001, "none fragment");
            }
            ma2 m = X.m();
            if (!(m instanceof na3.a)) {
                return new g32(1001, "fragment not support");
            }
            na3 floatLayer = ((na3.a) m).getFloatLayer();
            if (floatLayer == null) {
                return new g32(1001, "can't get floatLayer");
            }
            oa3.f(floatLayer, context, optString, optBoolean);
            g82.i("LoadingViewApi", "show loading success");
            return g32.f();
        }
        return (g32) invokeL.objValue;
    }
}
