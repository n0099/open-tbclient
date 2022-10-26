package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.t23;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gs1 extends fs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.pr1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gs1(nr1 nr1Var) {
        super(nr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public mv1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new mv1(1001, "context not support");
            }
            v22 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new mv1(1001, "none fragmentManger");
            }
            s22 m = X.m();
            if (!(m instanceof t23.a)) {
                return new mv1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new mv1(1001, "fragment has detached");
            }
            u23.c(m);
            m02.i("LoadingViewApi", "hide loading success");
            return mv1.f();
        }
        return (mv1) invokeV.objValue;
    }

    public mv1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                m02.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new mv1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair s = s(str);
            mv1 mv1Var = (mv1) s.first;
            if (!mv1Var.isSuccess()) {
                return mv1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            m02.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new mv1(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new mv1(1001, "context not support");
            }
            v22 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new mv1(1001, "none fragment");
            }
            s22 m = X.m();
            if (!(m instanceof t23.a)) {
                return new mv1(1001, "fragment not support");
            }
            t23 d = ((t23.a) m).d();
            if (d == null) {
                return new mv1(1001, "can't get floatLayer");
            }
            u23.f(d, context, optString, optBoolean);
            m02.i("LoadingViewApi", "show loading success");
            return mv1.f();
        }
        return (mv1) invokeL.objValue;
    }
}
