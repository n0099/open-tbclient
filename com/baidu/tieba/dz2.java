package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.ur1;
import com.baidu.tieba.v83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dz2 extends zy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.az2
    public mv1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (mv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.az2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.az2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y42 a;
        public final /* synthetic */ xy2 b;
        public final /* synthetic */ y83 c;

        public a(dz2 dz2Var, y42 y42Var, xy2 xy2Var, y83 y83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dz2Var, y42Var, xy2Var, y83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y42Var;
            this.b = xy2Var;
            this.c = y83Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(p83 p83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p83Var) == null) {
                if (p83Var != null && p83Var.c() && !TextUtils.isEmpty(((v83.d) p83Var.a).a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", ((v83.d) p83Var.a).a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (wj1.a) {
                                ez2.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                ez2.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public dz2() {
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
    public void p(SwanAppActivity swanAppActivity, String str, wy2 wy2Var, y83 y83Var, y42 y42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, wy2Var, y83Var, y42Var) == null) {
            xy2 xy2Var = new xy2(wy2Var.f);
            xy2Var.a = wy2Var.e;
            if (y83Var != null && y83Var.j.a() == 0) {
                ez2.b("obtain user info detail, get login code");
                ur1.d dVar = new ur1.d(wy2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", wy2Var.a);
                l33.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, y42Var, xy2Var, y83Var), "SwanPluginUserInfoFunPage");
                return;
            }
            ez2.b("open data result failure");
            y42Var.a(xy2Var);
        }
    }
}
