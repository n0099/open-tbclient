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
import com.baidu.tieba.hk4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class ek4<T> implements hk4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ti4 a;
    public em4 b;
    public String c;

    public abstract boolean e(T t);

    public abstract String g();

    public boolean r(T t, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, t, i)) == null) {
            return false;
        }
        return invokeLI.booleanValue;
    }

    public abstract sj4 s(T t);

    public abstract T t(JSONObject jSONObject);

    public ek4(ti4 ti4Var, em4 em4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ti4Var, em4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ti4Var;
        this.b = em4Var;
    }

    public void a(sj4 sj4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, sj4Var, str, str2, str3) == null) {
            c(sj4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.hk4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            ti4 ti4Var = this.a;
            if (ti4Var != null) {
                ti4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    public void c(sj4 sj4Var, String str, String str2, String str3, @Nullable dk4 dk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, sj4Var, str, str2, str3, dk4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (sj4Var != null) {
                try {
                    if (sj4Var.a != 0) {
                        i = sj4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && sj4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", ji4.b().c());
                        jSONObject.put("network", zq4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof am4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((am4) this.b).g());
            }
            if (dk4Var != null && dk4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, dk4Var.f());
            }
            hi4 b = ji4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            yn4.a(this.b.a(), "cs_protocol", g(), i, jSONObject);
        }
    }

    @CallSuper
    public sj4 d(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            if (!e(t)) {
                return new sj4(2103, str);
            }
            return null;
        }
        return (sj4) invokeLL.objValue;
    }

    public sj4 i(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new sj4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new sj4(2101, Log.getStackTraceString(exc));
        }
        return (sj4) invokeLL.objValue;
    }

    public void k(tj4 tj4Var, go4 go4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, tj4Var, go4Var) != null) || tj4Var == null) {
            return;
        }
        go4Var.a(tj4Var, PMSPkgStatus.WAIT);
    }

    public void l(vj4 vj4Var, go4 go4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, vj4Var, go4Var) != null) || vj4Var == null) {
            return;
        }
        go4Var.a(vj4Var, PMSPkgStatus.WAIT);
    }

    public void m(List<zj4> list, go4 go4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, list, go4Var) == null) && list != null && !list.isEmpty()) {
            for (zj4 zj4Var : list) {
                go4Var.a(zj4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void n(xj4 xj4Var, go4 go4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, xj4Var, go4Var) != null) || xj4Var == null) {
            return;
        }
        go4Var.a(xj4Var, PMSPkgStatus.WAIT);
    }

    public void o(List<yj4> list, go4 go4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, go4Var) == null) && list != null && !list.isEmpty()) {
            for (yj4 yj4Var : list) {
                go4Var.a(yj4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void p(zj4 zj4Var, go4 go4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, zj4Var, go4Var) != null) || zj4Var == null) {
            return;
        }
        go4Var.a(zj4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<zj4> f(@Nullable List<zj4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (zj4 zj4Var : list) {
                    if (zj4Var != null && !arrayList.contains(zj4Var)) {
                        vi4 i = vi4.i();
                        String str = zj4Var.g;
                        long j = zj4Var.i;
                        if (!ji4.b().r(i.q(str, j, j))) {
                            arrayList.add(zj4Var);
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
    public final String h(dk4 dk4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, dk4Var)) == null) {
            if (dk4Var == null || dk4Var.c() == null || (optJSONObject = dk4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        si4 p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) && pMSAppInfo != null && (p = this.a.p()) != null) {
            p.a(pMSAppInfo);
        }
    }

    public JSONObject j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
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

    @Override // com.baidu.tieba.hk4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            sj4 i = i(exc, j(exc.getMessage()));
            this.a.C(i);
            a(i, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.hk4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new sj4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.hk4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            ti4 ti4Var = this.a;
            if (ti4Var != null) {
                ti4Var.H(str, i);
            }
            if (i != 200) {
                sj4 sj4Var = new sj4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                sj4Var.f = i;
                ti4 ti4Var2 = this.a;
                if (ti4Var2 != null) {
                    ti4Var2.C(sj4Var);
                }
                a(sj4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            dk4 a = dk4.a(str);
            if (a == null) {
                JSONObject p = fo4.p(str);
                sj4 sj4Var2 = new sj4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                ti4 ti4Var3 = this.a;
                if (ti4Var3 != null) {
                    ti4Var3.C(sj4Var2);
                }
                a(sj4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T t = t(a.c());
            if (r(t, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                sj4 sj4Var3 = new sj4(d, a.e(), a.g(), h(a));
                ti4 ti4Var4 = this.a;
                if (ti4Var4 != null) {
                    ti4Var4.C(sj4Var3);
                }
                if (a.d() != 1010) {
                    c(sj4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (t == null) {
                sj4 sj4Var4 = new sj4(2102, "response data empty");
                ti4 ti4Var5 = this.a;
                if (ti4Var5 != null) {
                    ti4Var5.C(sj4Var4);
                }
                c(sj4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                sj4 d2 = d(str, t);
                if (d2 != null) {
                    ti4 ti4Var6 = this.a;
                    if (ti4Var6 != null) {
                        ti4Var6.C(d2);
                    }
                    c(d2, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                s(t);
            }
        }
    }
}
