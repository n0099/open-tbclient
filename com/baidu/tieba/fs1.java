package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.s23;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fs1 extends es1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fs1(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    public lv1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new lv1(1001, "context not support");
            }
            u22 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new lv1(1001, "none fragmentManger");
            }
            r22 m = X.m();
            if (!(m instanceof s23.a)) {
                return new lv1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new lv1(1001, "fragment has detached");
            }
            t23.c(m);
            l02.i("LoadingViewApi", "hide loading success");
            return lv1.f();
        }
        return (lv1) invokeV.objValue;
    }

    public lv1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                l02.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new lv1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (lv1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                l02.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
                String optString = jSONObject.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    return new lv1(202, "none title");
                }
                boolean optBoolean = jSONObject.optBoolean("mask", false);
                Context context = getContext();
                if (!(context instanceof SwanAppActivity)) {
                    return new lv1(1001, "context not support");
                }
                u22 X = ((SwanAppActivity) context).X();
                if (X == null) {
                    return new lv1(1001, "none fragment");
                }
                r22 m = X.m();
                if (!(m instanceof s23.a)) {
                    return new lv1(1001, "fragment not support");
                }
                s23 d = ((s23.a) m).d();
                if (d == null) {
                    return new lv1(1001, "can't get floatLayer");
                }
                t23.f(d, context, optString, optBoolean);
                l02.i("LoadingViewApi", "show loading success");
                return lv1.f();
            }
            return lv1Var;
        }
        return (lv1) invokeL.objValue;
    }
}
