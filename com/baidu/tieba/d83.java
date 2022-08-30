package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.xl2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d83 extends c83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanCoreVersion k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;

    public d83() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        s73.i(this);
        s73.h(this);
        s73.f(this);
        s73.g(this);
    }

    @Override // com.baidu.tieba.c83
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                a13 D = nm2.U().D();
                String i = fa3.i(this.k, TextUtils.equals(this.a, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME) ? 1 : 0);
                if (D != null && D.Y() != null) {
                    xl2.a Y = D.Y();
                    if (TextUtils.isEmpty(this.l)) {
                        this.l = D.k0();
                    }
                    if (TextUtils.isEmpty(this.m)) {
                        this.m = Y.w1();
                    }
                    Bundle P = Y.P();
                    if (P != null) {
                        this.o = P.getString("aiapp_extra_need_download", "");
                    }
                    if (TextUtils.isEmpty(this.p)) {
                        this.p = Y.W();
                    }
                    this.p = s73.b(this.p);
                    if (TextUtils.isEmpty(this.g) && !TextUtils.isEmpty(Y.e0())) {
                        this.s = Y.e0();
                    }
                    String b = s73.b(this.s);
                    this.s = b;
                    if (b == null) {
                        this.s = "";
                    }
                    if (TextUtils.isEmpty(this.u)) {
                        this.u = Y.V();
                    }
                }
                this.n = SwanAppNetworkUtils.f().type;
                if (this.h == null) {
                    this.h = new JSONObject();
                }
                this.h.put("swan", i);
                this.h.put("appversion", this.l);
                this.h.put("thirdversion", this.m);
                this.h.put("net", this.n);
                this.h.put("needdown", this.o);
                this.h.put("scheme", this.p);
                this.h.put("page", this.s);
                this.h.put("launchid", this.u);
                if (!TextUtils.isEmpty(this.t)) {
                    this.h.put("error_code", this.t);
                }
                if (!TextUtils.isEmpty(this.q)) {
                    this.h.put("canceltime", this.q);
                }
                if (!TextUtils.isEmpty(this.r)) {
                    this.h.put("successtime", this.r);
                }
                if (c83.j) {
                    Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.h + "\t " + Thread.currentThread().getId());
                }
            } catch (JSONException e) {
                if (c83.j) {
                    e.printStackTrace();
                }
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public void h(am2 am2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, am2Var) == null) {
            if (am2Var == null) {
                if (c83.j) {
                    Log.w("SwanAppUBCEvent", "launchinfo is null");
                    return;
                }
                return;
            }
            this.f = am2Var.H();
            this.c = am2Var.T();
            this.o = am2Var.s0().getString("aiapp_extra_need_download", "");
            this.p = am2Var.W();
            this.s = am2Var.e0();
            this.u = am2Var.V();
        }
    }

    public void i(am2 am2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, am2Var) == null) {
            h(am2Var);
        }
    }

    public void j(am2 am2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, am2Var) == null) {
            h(am2Var);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.u = str;
        }
    }
}
