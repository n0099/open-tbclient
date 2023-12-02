package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.tb3;
import com.baidu.tieba.tu1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b23 extends x13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.y13
    public ly1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (ly1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y13
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.y13
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements dl3<nb3<tb3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w72 a;
        public final /* synthetic */ v13 b;
        public final /* synthetic */ wb3 c;

        public a(b23 b23Var, w72 w72Var, v13 v13Var, wb3 wb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b23Var, w72Var, v13Var, wb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w72Var;
            this.b = v13Var;
            this.c = wb3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<tb3.d> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (nb3Var != null && nb3Var.c() && !TextUtils.isEmpty(nb3Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", nb3Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (vm1.a) {
                                c23.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                c23.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public b23() {
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

    @Override // com.baidu.tieba.x13
    public void p(SwanAppActivity swanAppActivity, String str, u13 u13Var, wb3 wb3Var, w72<v13> w72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, u13Var, wb3Var, w72Var) == null) {
            v13 v13Var = new v13(u13Var.f);
            v13Var.a = u13Var.e;
            if (wb3Var != null && wb3Var.j.a() == 0) {
                c23.b("obtain user info detail, get login code");
                tu1.d dVar = new tu1.d(u13Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", u13Var.a);
                j63.K().q().f0().r(swanAppActivity, dVar, bundle, new a(this, w72Var, v13Var, wb3Var), "SwanPluginUserInfoFunPage");
                return;
            }
            c23.b("open data result failure");
            w72Var.a(v13Var);
        }
    }
}
