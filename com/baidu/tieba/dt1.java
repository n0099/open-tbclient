package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.q33;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class dt1 extends ct1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ms1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dt1(@NonNull ks1 ks1Var) {
        super(ks1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ks1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ks1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public jw1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new jw1(1001, "context not support");
            }
            s32 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new jw1(1001, "none fragmentManger");
            }
            p32 m = X.m();
            if (!(m instanceof q33.a)) {
                return new jw1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new jw1(1001, "fragment has detached");
            }
            r33.c(m);
            j12.i("LoadingViewApi", "hide loading success");
            return jw1.f();
        }
        return (jw1) invokeV.objValue;
    }

    public jw1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                j12.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new jw1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<jw1, JSONObject> s = s(str);
            jw1 jw1Var = (jw1) s.first;
            if (!jw1Var.isSuccess()) {
                return jw1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            j12.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new jw1(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new jw1(1001, "context not support");
            }
            s32 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new jw1(1001, "none fragment");
            }
            p32 m = X.m();
            if (!(m instanceof q33.a)) {
                return new jw1(1001, "fragment not support");
            }
            q33 d = ((q33.a) m).d();
            if (d == null) {
                return new jw1(1001, "can't get floatLayer");
            }
            r33.f(d, context, optString, optBoolean);
            j12.i("LoadingViewApi", "show loading success");
            return jw1.f();
        }
        return (jw1) invokeL.objValue;
    }
}
