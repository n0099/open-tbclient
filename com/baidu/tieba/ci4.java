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
import com.baidu.tieba.fi4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class ci4<T> implements fi4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rg4 a;
    public ck4 b;
    public String c;

    public abstract boolean f(T t);

    public abstract String h();

    public boolean s(T t, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, t, i)) == null) {
            return false;
        }
        return invokeLI.booleanValue;
    }

    public abstract qh4 t(T t);

    public abstract T u(JSONObject jSONObject);

    public ci4(rg4 rg4Var, ck4 ck4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rg4Var, ck4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = rg4Var;
        this.b = ck4Var;
    }

    public void a(qh4 qh4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, qh4Var, str, str2, str3) == null) {
            d(qh4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.fi4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            rg4 rg4Var = this.a;
            if (rg4Var != null) {
                rg4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.fi4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            rg4 rg4Var = this.a;
            if (rg4Var != null) {
                rg4Var.H(str, i);
            }
            if (i != 200) {
                qh4 qh4Var = new qh4(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                qh4Var.f = i;
                rg4 rg4Var2 = this.a;
                if (rg4Var2 != null) {
                    rg4Var2.C(qh4Var);
                }
                a(qh4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            bi4 a = bi4.a(str);
            if (a == null) {
                JSONObject p = dm4.p(str);
                qh4 qh4Var2 = new qh4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                rg4 rg4Var3 = this.a;
                if (rg4Var3 != null) {
                    rg4Var3.C(qh4Var2);
                }
                a(qh4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                qh4 qh4Var3 = new qh4(d, a.e(), a.g(), i(a));
                rg4 rg4Var4 = this.a;
                if (rg4Var4 != null) {
                    rg4Var4.C(qh4Var3);
                }
                if (a.d() != 1010) {
                    d(qh4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                qh4 qh4Var4 = new qh4(2102, "response data empty");
                rg4 rg4Var5 = this.a;
                if (rg4Var5 != null) {
                    rg4Var5.C(qh4Var4);
                }
                d(qh4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                qh4 e = e(str, u);
                if (e != null) {
                    rg4 rg4Var6 = this.a;
                    if (rg4Var6 != null) {
                        rg4Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(qh4 qh4Var, String str, String str2, String str3, @Nullable bi4 bi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, qh4Var, str, str2, str3, bi4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (qh4Var != null) {
                try {
                    if (qh4Var.a != 0) {
                        i = qh4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && qh4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", hg4.b().c());
                        jSONObject.put("network", xo4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof yj4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((yj4) this.b).g());
            }
            if (bi4Var != null && bi4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, bi4Var.f());
            }
            fg4 b = hg4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            wl4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public qh4 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (!f(t)) {
                return new qh4(2103, str);
            }
            return null;
        }
        return (qh4) invokeLL.objValue;
    }

    public qh4 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new qh4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new qh4(2101, Log.getStackTraceString(exc));
        }
        return (qh4) invokeLL.objValue;
    }

    public void l(rh4 rh4Var, em4 em4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, rh4Var, em4Var) != null) || rh4Var == null) {
            return;
        }
        em4Var.a(rh4Var, PMSPkgStatus.WAIT);
    }

    public void m(th4 th4Var, em4 em4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, th4Var, em4Var) != null) || th4Var == null) {
            return;
        }
        em4Var.a(th4Var, PMSPkgStatus.WAIT);
    }

    public void n(List<xh4> list, em4 em4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, list, em4Var) == null) && list != null && !list.isEmpty()) {
            for (xh4 xh4Var : list) {
                em4Var.a(xh4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void o(vh4 vh4Var, em4 em4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, vh4Var, em4Var) != null) || vh4Var == null) {
            return;
        }
        em4Var.a(vh4Var, PMSPkgStatus.WAIT);
    }

    public void p(List<wh4> list, em4 em4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, em4Var) == null) && list != null && !list.isEmpty()) {
            for (wh4 wh4Var : list) {
                em4Var.a(wh4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void q(xh4 xh4Var, em4 em4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, xh4Var, em4Var) != null) || xh4Var == null) {
            return;
        }
        em4Var.a(xh4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<xh4> g(@Nullable List<xh4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (xh4 xh4Var : list) {
                    if (xh4Var != null && !arrayList.contains(xh4Var)) {
                        tg4 i = tg4.i();
                        String str = xh4Var.g;
                        long j = xh4Var.i;
                        if (!hg4.b().r(i.q(str, j, j))) {
                            arrayList.add(xh4Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public final String i(bi4 bi4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bi4Var)) == null) {
            if (bi4Var == null || bi4Var.c() == null || (optJSONObject = bi4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void r(PMSAppInfo pMSAppInfo) {
        qg4 p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) && pMSAppInfo != null && (p = this.a.p()) != null) {
            p.a(pMSAppInfo);
        }
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
                if (split.length <= 1) {
                    return null;
                }
                return new JSONObject(split[1]);
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fi4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            qh4 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.fi4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new qh4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }
}
