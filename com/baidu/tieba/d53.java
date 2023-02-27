package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.ux1;
import com.baidu.tieba.ve3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d53 extends z43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.a53
    public m12 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (m12) invokeL.objValue;
    }

    @Override // com.baidu.tieba.a53
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a53
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements fo3<pe3<ve3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya2 a;
        public final /* synthetic */ x43 b;
        public final /* synthetic */ ye3 c;

        public a(d53 d53Var, ya2 ya2Var, x43 x43Var, ye3 ye3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d53Var, ya2Var, x43Var, ye3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya2Var;
            this.b = x43Var;
            this.c = ye3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(pe3<ve3.d> pe3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pe3Var) == null) {
                if (pe3Var != null && pe3Var.c() && !TextUtils.isEmpty(pe3Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", pe3Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (wp1.a) {
                                e53.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                e53.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public d53() {
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

    @Override // com.baidu.tieba.z43
    public void p(SwanAppActivity swanAppActivity, String str, w43 w43Var, ye3 ye3Var, ya2<x43> ya2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, w43Var, ye3Var, ya2Var) == null) {
            x43 x43Var = new x43(w43Var.f);
            x43Var.a = w43Var.e;
            if (ye3Var != null && ye3Var.j.a() == 0) {
                e53.b("obtain user info detail, get login code");
                ux1.d dVar = new ux1.d(w43Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", w43Var.a);
                l93.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, ya2Var, x43Var, ye3Var), "SwanPluginUserInfoFunPage");
                return;
            }
            e53.b("open data result failure");
            ya2Var.a(x43Var);
        }
    }
}
