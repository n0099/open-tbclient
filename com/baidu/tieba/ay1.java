package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.n83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ay1 extends zx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jx1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay1(@NonNull hx1 hx1Var) {
        super(hx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hx1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((hx1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public g12 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new g12(1001, "context not support");
            }
            p82 Z = ((SwanAppActivity) context).Z();
            if (Z == null) {
                return new g12(1001, "none fragmentManger");
            }
            m82 m = Z.m();
            if (!(m instanceof n83.a)) {
                return new g12(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new g12(1001, "fragment has detached");
            }
            o83.c(m);
            g62.i("LoadingViewApi", "hide loading success");
            return g12.f();
        }
        return (g12) invokeV.objValue;
    }

    public g12 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                g62.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new g12(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<g12, JSONObject> s = s(str);
            g12 g12Var = (g12) s.first;
            if (!g12Var.isSuccess()) {
                return g12Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            g62.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new g12(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new g12(1001, "context not support");
            }
            p82 Z = ((SwanAppActivity) context).Z();
            if (Z == null) {
                return new g12(1001, "none fragment");
            }
            m82 m = Z.m();
            if (!(m instanceof n83.a)) {
                return new g12(1001, "fragment not support");
            }
            n83 d = ((n83.a) m).d();
            if (d == null) {
                return new g12(1001, "can't get floatLayer");
            }
            o83.f(d, context, optString, optBoolean);
            g62.i("LoadingViewApi", "show loading success");
            return g12.f();
        }
        return (g12) invokeL.objValue;
    }
}
