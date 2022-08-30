package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.tieba.ha4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class ea4<T> implements ha4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t84 a;
    public ec4 b;
    public String c;

    public ea4(t84 t84Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t84Var, ec4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = t84Var;
        this.b = ec4Var;
    }

    public void a(s94 s94Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, s94Var, str, str2, str3) == null) {
            d(s94Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.ha4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            t84 t84Var = this.a;
            if (t84Var != null) {
                t84Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.ha4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            t84 t84Var = this.a;
            if (t84Var != null) {
                t84Var.H(str, i);
            }
            if (i != 200) {
                s94 s94Var = new s94(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                s94Var.f = i;
                t84 t84Var2 = this.a;
                if (t84Var2 != null) {
                    t84Var2.C(s94Var);
                }
                a(s94Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            da4 a = da4.a(str);
            if (a == null) {
                JSONObject p = fe4.p(str);
                s94 s94Var2 = new s94(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                t84 t84Var3 = this.a;
                if (t84Var3 != null) {
                    t84Var3.C(s94Var2);
                }
                a(s94Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                s94 s94Var3 = new s94(d, a.e(), a.g(), i(a));
                t84 t84Var4 = this.a;
                if (t84Var4 != null) {
                    t84Var4.C(s94Var3);
                }
                if (a.d() != 1010) {
                    d(s94Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                s94 s94Var4 = new s94(2102, "response data empty");
                t84 t84Var5 = this.a;
                if (t84Var5 != null) {
                    t84Var5.C(s94Var4);
                }
                d(s94Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                s94 e = e(str, u);
                if (e != null) {
                    t84 t84Var6 = this.a;
                    if (t84Var6 != null) {
                        t84Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(s94 s94Var, String str, String str2, String str3, @Nullable da4 da4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, s94Var, str, str2, str3, da4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (s94Var != null) {
                try {
                    if (s94Var.a != 0) {
                        i = s94Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && s94Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", j84.b().c());
                        jSONObject.put("network", zg4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof ac4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((ac4) this.b).g());
            }
            if (da4Var != null && da4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, da4Var.f());
            }
            h84 b = j84.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            yd4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public s94 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (f(t)) {
                return null;
            }
            return new s94(2103, str);
        }
        return (s94) invokeLL.objValue;
    }

    public abstract boolean f(T t);

    @Nullable
    public List<z94> g(@Nullable List<z94> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (z94 z94Var : list) {
                if (z94Var != null && !arrayList.contains(z94Var)) {
                    v84 i = v84.i();
                    String str = z94Var.g;
                    long j = z94Var.i;
                    if (!j84.b().r(i.q(str, j, j))) {
                        arrayList.add(z94Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public abstract String h();

    @Nullable
    public final String i(da4 da4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, da4Var)) == null) {
            if (da4Var == null || da4Var.c() == null || (optJSONObject = da4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public s94 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new s94(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new s94(2101, Log.getStackTraceString(exc));
        }
        return (s94) invokeLL.objValue;
    }

    public JSONObject k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String[] split = str.split("request fail : ");
                if (split.length > 1) {
                    return new JSONObject(split[1]);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void l(t94 t94Var, ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, t94Var, ge4Var) == null) || t94Var == null) {
            return;
        }
        ge4Var.a(t94Var, PMSPkgStatus.WAIT);
    }

    public void m(v94 v94Var, ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, v94Var, ge4Var) == null) || v94Var == null) {
            return;
        }
        ge4Var.a(v94Var, PMSPkgStatus.WAIT);
    }

    public void n(List<z94> list, ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, ge4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (z94 z94Var : list) {
            ge4Var.a(z94Var, PMSPkgStatus.WAIT);
        }
    }

    public void o(x94 x94Var, ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, x94Var, ge4Var) == null) || x94Var == null) {
            return;
        }
        ge4Var.a(x94Var, PMSPkgStatus.WAIT);
    }

    @Override // com.baidu.tieba.ha4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            s94 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.ha4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new s94(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    public void p(List<y94> list, ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, list, ge4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (y94 y94Var : list) {
            ge4Var.a(y94Var, PMSPkgStatus.WAIT);
        }
    }

    public void q(z94 z94Var, ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, z94Var, ge4Var) == null) || z94Var == null) {
            return;
        }
        ge4Var.a(z94Var, PMSPkgStatus.WAIT);
    }

    public void r(PMSAppInfo pMSAppInfo) {
        s84 p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) || pMSAppInfo == null || (p = this.a.p()) == null) {
            return;
        }
        p.a(pMSAppInfo);
    }

    public boolean s(T t, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, t, i)) == null) {
            return false;
        }
        return invokeLI.booleanValue;
    }

    public abstract s94 t(T t);

    public abstract T u(JSONObject jSONObject);
}
