package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.r53;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fv1 extends ev1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fv1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ly1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            r("#hideLoading", false);
            Context i = i();
            if (!(i instanceof SwanAppActivity)) {
                return new ly1(1001, "context not support");
            }
            t52 Y = ((SwanAppActivity) i).Y();
            if (Y == null) {
                return new ly1(1001, "none fragmentManger");
            }
            q52 m = Y.m();
            if (!(m instanceof r53.a)) {
                return new ly1(1001, "fragment not support");
            }
            if (m.z() == null) {
                return new ly1(1001, "fragment has detached");
            }
            s53.c(m);
            k32.i("LoadingViewApi", "hide loading success");
            return ly1.f();
        }
        return (ly1) invokeV.objValue;
    }

    public ly1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#showLoading", false);
            if (o()) {
                k32.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new ly1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            k32.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new ly1(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context i = i();
            if (!(i instanceof SwanAppActivity)) {
                return new ly1(1001, "context not support");
            }
            t52 Y = ((SwanAppActivity) i).Y();
            if (Y == null) {
                return new ly1(1001, "none fragment");
            }
            q52 m = Y.m();
            if (!(m instanceof r53.a)) {
                return new ly1(1001, "fragment not support");
            }
            r53 floatLayer = ((r53.a) m).getFloatLayer();
            if (floatLayer == null) {
                return new ly1(1001, "can't get floatLayer");
            }
            s53.f(floatLayer, i, optString, optBoolean);
            k32.i("LoadingViewApi", "show loading success");
            return ly1.f();
        }
        return (ly1) invokeL.objValue;
    }
}
