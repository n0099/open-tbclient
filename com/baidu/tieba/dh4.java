package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.tieba.gh4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class dh4<T> implements gh4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sf4 a;
    public dj4 b;
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

    public abstract rg4 t(T t);

    public abstract T u(JSONObject jSONObject);

    public dh4(sf4 sf4Var, dj4 dj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sf4Var, dj4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = sf4Var;
        this.b = dj4Var;
    }

    public void a(rg4 rg4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rg4Var, str, str2, str3) == null) {
            d(rg4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.gh4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            sf4 sf4Var = this.a;
            if (sf4Var != null) {
                sf4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.gh4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            sf4 sf4Var = this.a;
            if (sf4Var != null) {
                sf4Var.H(str, i);
            }
            if (i != 200) {
                rg4 rg4Var = new rg4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                rg4Var.f = i;
                sf4 sf4Var2 = this.a;
                if (sf4Var2 != null) {
                    sf4Var2.C(rg4Var);
                }
                a(rg4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            ch4 a = ch4.a(str);
            if (a == null) {
                JSONObject p = el4.p(str);
                rg4 rg4Var2 = new rg4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                sf4 sf4Var3 = this.a;
                if (sf4Var3 != null) {
                    sf4Var3.C(rg4Var2);
                }
                a(rg4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                rg4 rg4Var3 = new rg4(d, a.e(), a.g(), i(a));
                sf4 sf4Var4 = this.a;
                if (sf4Var4 != null) {
                    sf4Var4.C(rg4Var3);
                }
                if (a.d() != 1010) {
                    d(rg4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                rg4 rg4Var4 = new rg4(2102, "response data empty");
                sf4 sf4Var5 = this.a;
                if (sf4Var5 != null) {
                    sf4Var5.C(rg4Var4);
                }
                d(rg4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                rg4 e = e(str, u);
                if (e != null) {
                    sf4 sf4Var6 = this.a;
                    if (sf4Var6 != null) {
                        sf4Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(rg4 rg4Var, String str, String str2, String str3, @Nullable ch4 ch4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, rg4Var, str, str2, str3, ch4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (rg4Var != null) {
                try {
                    if (rg4Var.a != 0) {
                        i = rg4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && rg4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", if4.b().c());
                        jSONObject.put("network", yn4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof zi4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((zi4) this.b).g());
            }
            if (ch4Var != null && ch4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, ch4Var.f());
            }
            gf4 b = if4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            xk4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public rg4 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (!f(t)) {
                return new rg4(2103, str);
            }
            return null;
        }
        return (rg4) invokeLL.objValue;
    }

    public rg4 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new rg4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new rg4(2101, Log.getStackTraceString(exc));
        }
        return (rg4) invokeLL.objValue;
    }

    public void l(sg4 sg4Var, fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, sg4Var, fl4Var) != null) || sg4Var == null) {
            return;
        }
        fl4Var.a(sg4Var, PMSPkgStatus.WAIT);
    }

    public void m(ug4 ug4Var, fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, ug4Var, fl4Var) != null) || ug4Var == null) {
            return;
        }
        fl4Var.a(ug4Var, PMSPkgStatus.WAIT);
    }

    public void n(List<yg4> list, fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, list, fl4Var) == null) && list != null && !list.isEmpty()) {
            for (yg4 yg4Var : list) {
                fl4Var.a(yg4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void o(wg4 wg4Var, fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, wg4Var, fl4Var) != null) || wg4Var == null) {
            return;
        }
        fl4Var.a(wg4Var, PMSPkgStatus.WAIT);
    }

    public void p(List<xg4> list, fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, fl4Var) == null) && list != null && !list.isEmpty()) {
            for (xg4 xg4Var : list) {
                fl4Var.a(xg4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void q(yg4 yg4Var, fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, yg4Var, fl4Var) != null) || yg4Var == null) {
            return;
        }
        fl4Var.a(yg4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<yg4> g(@Nullable List<yg4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (yg4 yg4Var : list) {
                    if (yg4Var != null && !arrayList.contains(yg4Var)) {
                        uf4 i = uf4.i();
                        String str = yg4Var.g;
                        long j = yg4Var.i;
                        if (!if4.b().r(i.q(str, j, j))) {
                            arrayList.add(yg4Var);
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
    public final String i(ch4 ch4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ch4Var)) == null) {
            if (ch4Var == null || ch4Var.c() == null || (optJSONObject = ch4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void r(PMSAppInfo pMSAppInfo) {
        rf4 p;
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

    @Override // com.baidu.tieba.gh4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            rg4 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.gh4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new rg4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }
}
