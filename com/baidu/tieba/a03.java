package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.rs1;
import com.baidu.tieba.s93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a03 extends wz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.xz2
    public jw1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (jw1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xz2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements cj3<m93<s93.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v52 a;
        public final /* synthetic */ uz2 b;
        public final /* synthetic */ v93 c;

        public a(a03 a03Var, v52 v52Var, uz2 uz2Var, v93 v93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a03Var, v52Var, uz2Var, v93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v52Var;
            this.b = uz2Var;
            this.c = v93Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(m93<s93.d> m93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m93Var) == null) {
                if (m93Var != null && m93Var.c() && !TextUtils.isEmpty(m93Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", m93Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (tk1.a) {
                                b03.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                b03.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public a03() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.wz2
    public void p(SwanAppActivity swanAppActivity, String str, tz2 tz2Var, v93 v93Var, v52<uz2> v52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, tz2Var, v93Var, v52Var) == null) {
            uz2 uz2Var = new uz2(tz2Var.f);
            uz2Var.a = tz2Var.e;
            if (v93Var != null && v93Var.j.a() == 0) {
                b03.b("obtain user info detail, get login code");
                rs1.d dVar = new rs1.d(tz2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", tz2Var.a);
                i43.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, v52Var, uz2Var, v93Var), "SwanPluginUserInfoFunPage");
                return;
            }
            b03.b("open data result failure");
            v52Var.a(uz2Var);
        }
    }
}
