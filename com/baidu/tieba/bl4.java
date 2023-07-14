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
import com.baidu.tieba.el4;
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
public abstract class bl4<T> implements el4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qj4 a;
    public bn4 b;
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

    public abstract pk4 s(T t);

    public abstract T t(JSONObject jSONObject);

    public bl4(qj4 qj4Var, bn4 bn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qj4Var, bn4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = qj4Var;
        this.b = bn4Var;
    }

    public void a(pk4 pk4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, pk4Var, str, str2, str3) == null) {
            c(pk4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.el4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            qj4 qj4Var = this.a;
            if (qj4Var != null) {
                qj4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    public void c(pk4 pk4Var, String str, String str2, String str3, @Nullable al4 al4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, pk4Var, str, str2, str3, al4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (pk4Var != null) {
                try {
                    if (pk4Var.a != 0) {
                        i = pk4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && pk4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", gj4.b().c());
                        jSONObject.put("network", wr4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof xm4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((xm4) this.b).g());
            }
            if (al4Var != null && al4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, al4Var.f());
            }
            ej4 b = gj4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            vo4.a(this.b.a(), "cs_protocol", g(), i, jSONObject);
        }
    }

    @CallSuper
    public pk4 d(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            if (!e(t)) {
                return new pk4(2103, str);
            }
            return null;
        }
        return (pk4) invokeLL.objValue;
    }

    public pk4 i(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new pk4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new pk4(2101, Log.getStackTraceString(exc));
        }
        return (pk4) invokeLL.objValue;
    }

    public void k(qk4 qk4Var, dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, qk4Var, dp4Var) != null) || qk4Var == null) {
            return;
        }
        dp4Var.a(qk4Var, PMSPkgStatus.WAIT);
    }

    public void l(sk4 sk4Var, dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, sk4Var, dp4Var) != null) || sk4Var == null) {
            return;
        }
        dp4Var.a(sk4Var, PMSPkgStatus.WAIT);
    }

    public void m(List<wk4> list, dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, list, dp4Var) == null) && list != null && !list.isEmpty()) {
            for (wk4 wk4Var : list) {
                dp4Var.a(wk4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void n(uk4 uk4Var, dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, uk4Var, dp4Var) != null) || uk4Var == null) {
            return;
        }
        dp4Var.a(uk4Var, PMSPkgStatus.WAIT);
    }

    public void o(List<vk4> list, dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, dp4Var) == null) && list != null && !list.isEmpty()) {
            for (vk4 vk4Var : list) {
                dp4Var.a(vk4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void p(wk4 wk4Var, dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, wk4Var, dp4Var) != null) || wk4Var == null) {
            return;
        }
        dp4Var.a(wk4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<wk4> f(@Nullable List<wk4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (wk4 wk4Var : list) {
                    if (wk4Var != null && !arrayList.contains(wk4Var)) {
                        sj4 i = sj4.i();
                        String str = wk4Var.g;
                        long j = wk4Var.i;
                        if (!gj4.b().r(i.q(str, j, j))) {
                            arrayList.add(wk4Var);
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
    public final String h(al4 al4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, al4Var)) == null) {
            if (al4Var == null || al4Var.c() == null || (optJSONObject = al4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        pj4 p;
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

    @Override // com.baidu.tieba.el4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            pk4 i = i(exc, j(exc.getMessage()));
            this.a.C(i);
            a(i, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.el4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new pk4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.el4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            qj4 qj4Var = this.a;
            if (qj4Var != null) {
                qj4Var.H(str, i);
            }
            if (i != 200) {
                pk4 pk4Var = new pk4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                pk4Var.f = i;
                qj4 qj4Var2 = this.a;
                if (qj4Var2 != null) {
                    qj4Var2.C(pk4Var);
                }
                a(pk4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            al4 a = al4.a(str);
            if (a == null) {
                JSONObject p = cp4.p(str);
                pk4 pk4Var2 = new pk4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                qj4 qj4Var3 = this.a;
                if (qj4Var3 != null) {
                    qj4Var3.C(pk4Var2);
                }
                a(pk4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T t = t(a.c());
            if (r(t, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                pk4 pk4Var3 = new pk4(d, a.e(), a.g(), h(a));
                qj4 qj4Var4 = this.a;
                if (qj4Var4 != null) {
                    qj4Var4.C(pk4Var3);
                }
                if (a.d() != 1010) {
                    c(pk4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (t == null) {
                pk4 pk4Var4 = new pk4(2102, "response data empty");
                qj4 qj4Var5 = this.a;
                if (qj4Var5 != null) {
                    qj4Var5.C(pk4Var4);
                }
                c(pk4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                pk4 d2 = d(str, t);
                if (d2 != null) {
                    qj4 qj4Var6 = this.a;
                    if (qj4Var6 != null) {
                        qj4Var6.C(d2);
                    }
                    c(d2, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                s(t);
            }
        }
    }
}
