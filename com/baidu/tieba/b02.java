package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.oa3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b02 extends a02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b02(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public h32 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new h32(1001, "context not support");
            }
            qa2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new h32(1001, "none fragmentManger");
            }
            na2 m = Y.m();
            if (!(m instanceof oa3.a)) {
                return new h32(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new h32(1001, "fragment has detached");
            }
            pa3.c(m);
            h82.i("LoadingViewApi", "hide loading success");
            return h32.f();
        }
        return (h32) invokeV.objValue;
    }

    public h32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                h82.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new h32(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            h82.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new h32(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new h32(1001, "context not support");
            }
            qa2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new h32(1001, "none fragment");
            }
            na2 m = Y.m();
            if (!(m instanceof oa3.a)) {
                return new h32(1001, "fragment not support");
            }
            oa3 floatLayer = ((oa3.a) m).getFloatLayer();
            if (floatLayer == null) {
                return new h32(1001, "can't get floatLayer");
            }
            pa3.f(floatLayer, context, optString, optBoolean);
            h82.i("LoadingViewApi", "show loading success");
            return h32.f();
        }
        return (h32) invokeL.objValue;
    }
}
