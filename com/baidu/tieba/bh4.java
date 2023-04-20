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
import com.baidu.tieba.eh4;
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
public abstract class bh4<T> implements eh4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qf4 a;
    public bj4 b;
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

    public abstract pg4 t(T t);

    public abstract T u(JSONObject jSONObject);

    public bh4(qf4 qf4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qf4Var, bj4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = qf4Var;
        this.b = bj4Var;
    }

    public void a(pg4 pg4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, pg4Var, str, str2, str3) == null) {
            d(pg4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.eh4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            qf4 qf4Var = this.a;
            if (qf4Var != null) {
                qf4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.eh4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            qf4 qf4Var = this.a;
            if (qf4Var != null) {
                qf4Var.H(str, i);
            }
            if (i != 200) {
                pg4 pg4Var = new pg4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                pg4Var.f = i;
                qf4 qf4Var2 = this.a;
                if (qf4Var2 != null) {
                    qf4Var2.C(pg4Var);
                }
                a(pg4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            ah4 a = ah4.a(str);
            if (a == null) {
                JSONObject p = cl4.p(str);
                pg4 pg4Var2 = new pg4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                qf4 qf4Var3 = this.a;
                if (qf4Var3 != null) {
                    qf4Var3.C(pg4Var2);
                }
                a(pg4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                pg4 pg4Var3 = new pg4(d, a.e(), a.g(), i(a));
                qf4 qf4Var4 = this.a;
                if (qf4Var4 != null) {
                    qf4Var4.C(pg4Var3);
                }
                if (a.d() != 1010) {
                    d(pg4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                pg4 pg4Var4 = new pg4(2102, "response data empty");
                qf4 qf4Var5 = this.a;
                if (qf4Var5 != null) {
                    qf4Var5.C(pg4Var4);
                }
                d(pg4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                pg4 e = e(str, u);
                if (e != null) {
                    qf4 qf4Var6 = this.a;
                    if (qf4Var6 != null) {
                        qf4Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(pg4 pg4Var, String str, String str2, String str3, @Nullable ah4 ah4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, pg4Var, str, str2, str3, ah4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (pg4Var != null) {
                try {
                    if (pg4Var.a != 0) {
                        i = pg4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && pg4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", gf4.b().c());
                        jSONObject.put("network", wn4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof xi4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((xi4) this.b).g());
            }
            if (ah4Var != null && ah4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, ah4Var.f());
            }
            ef4 b = gf4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            vk4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public pg4 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (!f(t)) {
                return new pg4(2103, str);
            }
            return null;
        }
        return (pg4) invokeLL.objValue;
    }

    public pg4 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new pg4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new pg4(2101, Log.getStackTraceString(exc));
        }
        return (pg4) invokeLL.objValue;
    }

    public void l(qg4 qg4Var, dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, qg4Var, dl4Var) != null) || qg4Var == null) {
            return;
        }
        dl4Var.a(qg4Var, PMSPkgStatus.WAIT);
    }

    public void m(sg4 sg4Var, dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, sg4Var, dl4Var) != null) || sg4Var == null) {
            return;
        }
        dl4Var.a(sg4Var, PMSPkgStatus.WAIT);
    }

    public void n(List<wg4> list, dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, list, dl4Var) == null) && list != null && !list.isEmpty()) {
            for (wg4 wg4Var : list) {
                dl4Var.a(wg4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void o(ug4 ug4Var, dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, ug4Var, dl4Var) != null) || ug4Var == null) {
            return;
        }
        dl4Var.a(ug4Var, PMSPkgStatus.WAIT);
    }

    public void p(List<vg4> list, dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, dl4Var) == null) && list != null && !list.isEmpty()) {
            for (vg4 vg4Var : list) {
                dl4Var.a(vg4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void q(wg4 wg4Var, dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, wg4Var, dl4Var) != null) || wg4Var == null) {
            return;
        }
        dl4Var.a(wg4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<wg4> g(@Nullable List<wg4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (wg4 wg4Var : list) {
                    if (wg4Var != null && !arrayList.contains(wg4Var)) {
                        sf4 i = sf4.i();
                        String str = wg4Var.g;
                        long j = wg4Var.i;
                        if (!gf4.b().r(i.q(str, j, j))) {
                            arrayList.add(wg4Var);
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
    public final String i(ah4 ah4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ah4Var)) == null) {
            if (ah4Var == null || ah4Var.c() == null || (optJSONObject = ah4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void r(PMSAppInfo pMSAppInfo) {
        pf4 p;
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

    @Override // com.baidu.tieba.eh4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            pg4 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.eh4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new pg4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }
}
