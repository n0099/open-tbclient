package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.o53;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cv1 extends bv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.lu1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cv1(@NonNull ju1 ju1Var) {
        super(ju1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ju1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ju1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public iy1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            r("#hideLoading", false);
            Context i = i();
            if (!(i instanceof SwanAppActivity)) {
                return new iy1(1001, "context not support");
            }
            q52 Y = ((SwanAppActivity) i).Y();
            if (Y == null) {
                return new iy1(1001, "none fragmentManger");
            }
            n52 m = Y.m();
            if (!(m instanceof o53.a)) {
                return new iy1(1001, "fragment not support");
            }
            if (m.z() == null) {
                return new iy1(1001, "fragment has detached");
            }
            p53.c(m);
            h32.i("LoadingViewApi", "hide loading success");
            return iy1.f();
        }
        return (iy1) invokeV.objValue;
    }

    public iy1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#showLoading", false);
            if (o()) {
                h32.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new iy1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<iy1, JSONObject> t = t(str);
            iy1 iy1Var = (iy1) t.first;
            if (!iy1Var.isSuccess()) {
                return iy1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            h32.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new iy1(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context i = i();
            if (!(i instanceof SwanAppActivity)) {
                return new iy1(1001, "context not support");
            }
            q52 Y = ((SwanAppActivity) i).Y();
            if (Y == null) {
                return new iy1(1001, "none fragment");
            }
            n52 m = Y.m();
            if (!(m instanceof o53.a)) {
                return new iy1(1001, "fragment not support");
            }
            o53 floatLayer = ((o53.a) m).getFloatLayer();
            if (floatLayer == null) {
                return new iy1(1001, "can't get floatLayer");
            }
            p53.f(floatLayer, i, optString, optBoolean);
            h32.i("LoadingViewApi", "show loading success");
            return iy1.f();
        }
        return (iy1) invokeL.objValue;
    }
}
