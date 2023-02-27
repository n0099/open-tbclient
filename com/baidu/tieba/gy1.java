package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.t83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gy1 extends fy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.px1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gy1(@NonNull nx1 nx1Var) {
        super(nx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nx1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nx1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public m12 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new m12(1001, "context not support");
            }
            v82 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new m12(1001, "none fragmentManger");
            }
            s82 m = X.m();
            if (!(m instanceof t83.a)) {
                return new m12(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new m12(1001, "fragment has detached");
            }
            u83.c(m);
            m62.i("LoadingViewApi", "hide loading success");
            return m12.f();
        }
        return (m12) invokeV.objValue;
    }

    public m12 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                m62.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new m12(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<m12, JSONObject> s = s(str);
            m12 m12Var = (m12) s.first;
            if (!m12Var.isSuccess()) {
                return m12Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            m62.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new m12(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new m12(1001, "context not support");
            }
            v82 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new m12(1001, "none fragment");
            }
            s82 m = X.m();
            if (!(m instanceof t83.a)) {
                return new m12(1001, "fragment not support");
            }
            t83 d = ((t83.a) m).d();
            if (d == null) {
                return new m12(1001, "can't get floatLayer");
            }
            u83.f(d, context, optString, optBoolean);
            m62.i("LoadingViewApi", "show loading success");
            return m12.f();
        }
        return (m12) invokeL.objValue;
    }
}
