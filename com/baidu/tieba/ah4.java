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
import com.baidu.tieba.dh4;
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
/* loaded from: classes3.dex */
public abstract class ah4<T> implements dh4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pf4 a;
    public aj4 b;
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

    public abstract og4 t(T t);

    public abstract T u(JSONObject jSONObject);

    public ah4(pf4 pf4Var, aj4 aj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pf4Var, aj4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pf4Var;
        this.b = aj4Var;
    }

    public void a(og4 og4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, og4Var, str, str2, str3) == null) {
            d(og4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.dh4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            pf4 pf4Var = this.a;
            if (pf4Var != null) {
                pf4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.dh4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            pf4 pf4Var = this.a;
            if (pf4Var != null) {
                pf4Var.H(str, i);
            }
            if (i != 200) {
                og4 og4Var = new og4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                og4Var.f = i;
                pf4 pf4Var2 = this.a;
                if (pf4Var2 != null) {
                    pf4Var2.C(og4Var);
                }
                a(og4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            zg4 a = zg4.a(str);
            if (a == null) {
                JSONObject p = bl4.p(str);
                og4 og4Var2 = new og4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                pf4 pf4Var3 = this.a;
                if (pf4Var3 != null) {
                    pf4Var3.C(og4Var2);
                }
                a(og4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                og4 og4Var3 = new og4(d, a.e(), a.g(), i(a));
                pf4 pf4Var4 = this.a;
                if (pf4Var4 != null) {
                    pf4Var4.C(og4Var3);
                }
                if (a.d() != 1010) {
                    d(og4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                og4 og4Var4 = new og4(2102, "response data empty");
                pf4 pf4Var5 = this.a;
                if (pf4Var5 != null) {
                    pf4Var5.C(og4Var4);
                }
                d(og4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                og4 e = e(str, u);
                if (e != null) {
                    pf4 pf4Var6 = this.a;
                    if (pf4Var6 != null) {
                        pf4Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(og4 og4Var, String str, String str2, String str3, @Nullable zg4 zg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, og4Var, str, str2, str3, zg4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (og4Var != null) {
                try {
                    if (og4Var.a != 0) {
                        i = og4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && og4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", ff4.b().c());
                        jSONObject.put("network", vn4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof wi4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((wi4) this.b).g());
            }
            if (zg4Var != null && zg4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, zg4Var.f());
            }
            df4 b = ff4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            uk4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public og4 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (!f(t)) {
                return new og4(2103, str);
            }
            return null;
        }
        return (og4) invokeLL.objValue;
    }

    public og4 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new og4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new og4(2101, Log.getStackTraceString(exc));
        }
        return (og4) invokeLL.objValue;
    }

    public void l(pg4 pg4Var, cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, pg4Var, cl4Var) != null) || pg4Var == null) {
            return;
        }
        cl4Var.a(pg4Var, PMSPkgStatus.WAIT);
    }

    public void m(rg4 rg4Var, cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, rg4Var, cl4Var) != null) || rg4Var == null) {
            return;
        }
        cl4Var.a(rg4Var, PMSPkgStatus.WAIT);
    }

    public void n(List<vg4> list, cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, list, cl4Var) == null) && list != null && !list.isEmpty()) {
            for (vg4 vg4Var : list) {
                cl4Var.a(vg4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void o(tg4 tg4Var, cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, tg4Var, cl4Var) != null) || tg4Var == null) {
            return;
        }
        cl4Var.a(tg4Var, PMSPkgStatus.WAIT);
    }

    public void p(List<ug4> list, cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, cl4Var) == null) && list != null && !list.isEmpty()) {
            for (ug4 ug4Var : list) {
                cl4Var.a(ug4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void q(vg4 vg4Var, cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, vg4Var, cl4Var) != null) || vg4Var == null) {
            return;
        }
        cl4Var.a(vg4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<vg4> g(@Nullable List<vg4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (vg4 vg4Var : list) {
                    if (vg4Var != null && !arrayList.contains(vg4Var)) {
                        rf4 i = rf4.i();
                        String str = vg4Var.g;
                        long j = vg4Var.i;
                        if (!ff4.b().r(i.q(str, j, j))) {
                            arrayList.add(vg4Var);
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
    public final String i(zg4 zg4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zg4Var)) == null) {
            if (zg4Var == null || zg4Var.c() == null || (optJSONObject = zg4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void r(PMSAppInfo pMSAppInfo) {
        of4 p;
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

    @Override // com.baidu.tieba.dh4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            og4 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.dh4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new og4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }
}
