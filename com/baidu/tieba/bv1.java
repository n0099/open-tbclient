package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.n53;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bv1 extends av1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ku1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv1(@NonNull iu1 iu1Var) {
        super(iu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public hy1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            r("#hideLoading", false);
            Context i = i();
            if (!(i instanceof SwanAppActivity)) {
                return new hy1(1001, "context not support");
            }
            p52 Y = ((SwanAppActivity) i).Y();
            if (Y == null) {
                return new hy1(1001, "none fragmentManger");
            }
            m52 m = Y.m();
            if (!(m instanceof n53.a)) {
                return new hy1(1001, "fragment not support");
            }
            if (m.z() == null) {
                return new hy1(1001, "fragment has detached");
            }
            o53.c(m);
            g32.i("LoadingViewApi", "hide loading success");
            return hy1.f();
        }
        return (hy1) invokeV.objValue;
    }

    public hy1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#showLoading", false);
            if (o()) {
                g32.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new hy1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                return hy1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            g32.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new hy1(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context i = i();
            if (!(i instanceof SwanAppActivity)) {
                return new hy1(1001, "context not support");
            }
            p52 Y = ((SwanAppActivity) i).Y();
            if (Y == null) {
                return new hy1(1001, "none fragment");
            }
            m52 m = Y.m();
            if (!(m instanceof n53.a)) {
                return new hy1(1001, "fragment not support");
            }
            n53 floatLayer = ((n53.a) m).getFloatLayer();
            if (floatLayer == null) {
                return new hy1(1001, "can't get floatLayer");
            }
            o53.f(floatLayer, i, optString, optBoolean);
            g32.i("LoadingViewApi", "show loading success");
            return hy1.f();
        }
        return (hy1) invokeL.objValue;
    }
}
