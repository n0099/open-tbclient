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
import com.baidu.tieba.hc4;
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
public abstract class ec4<T> implements hc4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ta4 a;
    public ee4 b;
    public String c;

    public ec4(ta4 ta4Var, ee4 ee4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ta4Var, ee4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ta4Var;
        this.b = ee4Var;
    }

    public void a(sb4 sb4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, sb4Var, str, str2, str3) == null) {
            d(sb4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.hc4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            ta4 ta4Var = this.a;
            if (ta4Var != null) {
                ta4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.hc4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            ta4 ta4Var = this.a;
            if (ta4Var != null) {
                ta4Var.H(str, i);
            }
            if (i != 200) {
                sb4 sb4Var = new sb4(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                sb4Var.f = i;
                ta4 ta4Var2 = this.a;
                if (ta4Var2 != null) {
                    ta4Var2.C(sb4Var);
                }
                a(sb4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            dc4 a = dc4.a(str);
            if (a == null) {
                JSONObject p = fg4.p(str);
                sb4 sb4Var2 = new sb4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                ta4 ta4Var3 = this.a;
                if (ta4Var3 != null) {
                    ta4Var3.C(sb4Var2);
                }
                a(sb4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                sb4 sb4Var3 = new sb4(d, a.e(), a.g(), i(a));
                ta4 ta4Var4 = this.a;
                if (ta4Var4 != null) {
                    ta4Var4.C(sb4Var3);
                }
                if (a.d() != 1010) {
                    d(sb4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                sb4 sb4Var4 = new sb4(2102, "response data empty");
                ta4 ta4Var5 = this.a;
                if (ta4Var5 != null) {
                    ta4Var5.C(sb4Var4);
                }
                d(sb4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                sb4 e = e(str, u);
                if (e != null) {
                    ta4 ta4Var6 = this.a;
                    if (ta4Var6 != null) {
                        ta4Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(sb4 sb4Var, String str, String str2, String str3, @Nullable dc4 dc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, sb4Var, str, str2, str3, dc4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (sb4Var != null) {
                try {
                    if (sb4Var.a != 0) {
                        i = sb4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && sb4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", ja4.b().c());
                        jSONObject.put("network", zi4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof ae4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((ae4) this.b).g());
            }
            if (dc4Var != null && dc4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, dc4Var.f());
            }
            ha4 b = ja4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            yf4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public sb4 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (f(t)) {
                return null;
            }
            return new sb4(2103, str);
        }
        return (sb4) invokeLL.objValue;
    }

    public abstract boolean f(T t);

    @Nullable
    public List<zb4> g(@Nullable List<zb4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (zb4 zb4Var : list) {
                if (zb4Var != null && !arrayList.contains(zb4Var)) {
                    va4 i = va4.i();
                    String str = zb4Var.g;
                    long j = zb4Var.i;
                    if (!ja4.b().r(i.q(str, j, j))) {
                        arrayList.add(zb4Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public abstract String h();

    @Nullable
    public final String i(dc4 dc4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dc4Var)) == null) {
            if (dc4Var == null || dc4Var.c() == null || (optJSONObject = dc4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public sb4 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new sb4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new sb4(2101, Log.getStackTraceString(exc));
        }
        return (sb4) invokeLL.objValue;
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

    public void l(tb4 tb4Var, gg4 gg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, tb4Var, gg4Var) == null) || tb4Var == null) {
            return;
        }
        gg4Var.a(tb4Var, PMSPkgStatus.WAIT);
    }

    public void m(vb4 vb4Var, gg4 gg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, vb4Var, gg4Var) == null) || vb4Var == null) {
            return;
        }
        gg4Var.a(vb4Var, PMSPkgStatus.WAIT);
    }

    public void n(List<zb4> list, gg4 gg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, gg4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (zb4 zb4Var : list) {
            gg4Var.a(zb4Var, PMSPkgStatus.WAIT);
        }
    }

    public void o(xb4 xb4Var, gg4 gg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, xb4Var, gg4Var) == null) || xb4Var == null) {
            return;
        }
        gg4Var.a(xb4Var, PMSPkgStatus.WAIT);
    }

    @Override // com.baidu.tieba.hc4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            sb4 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.hc4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new sb4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    public void p(List<yb4> list, gg4 gg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, list, gg4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (yb4 yb4Var : list) {
            gg4Var.a(yb4Var, PMSPkgStatus.WAIT);
        }
    }

    public void q(zb4 zb4Var, gg4 gg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, zb4Var, gg4Var) == null) || zb4Var == null) {
            return;
        }
        gg4Var.a(zb4Var, PMSPkgStatus.WAIT);
    }

    public void r(PMSAppInfo pMSAppInfo) {
        sa4 p;
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

    public abstract sb4 t(T t);

    public abstract T u(JSONObject jSONObject);
}
