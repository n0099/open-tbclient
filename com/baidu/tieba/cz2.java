package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.tr1;
import com.baidu.tieba.u83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cz2 extends yy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements ei3<o83<u83.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x42 a;
        public final /* synthetic */ wy2 b;
        public final /* synthetic */ x83 c;

        public a(cz2 cz2Var, x42 x42Var, wy2 wy2Var, x83 x83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz2Var, x42Var, wy2Var, x83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x42Var;
            this.b = wy2Var;
            this.c = x83Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<u83.d> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                if (o83Var != null && o83Var.c() && !TextUtils.isEmpty(o83Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", o83Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (vj1.a) {
                                dz2.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                dz2.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public cz2() {
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

    @Override // com.baidu.tieba.zy2
    public lv1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (lv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zy2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zy2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yy2
    public void p(SwanAppActivity swanAppActivity, String str, vy2 vy2Var, x83 x83Var, x42<wy2> x42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, vy2Var, x83Var, x42Var) == null) {
            wy2 wy2Var = new wy2(vy2Var.f);
            wy2Var.a = vy2Var.e;
            if (x83Var != null && x83Var.j.a() == 0) {
                dz2.b("obtain user info detail, get login code");
                tr1.d dVar = new tr1.d(vy2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", vy2Var.a);
                k33.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, x42Var, wy2Var, x83Var), "SwanPluginUserInfoFunPage");
                return;
            }
            dz2.b("open data result failure");
            x42Var.a(wy2Var);
        }
    }
}
