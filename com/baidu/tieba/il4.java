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
import com.baidu.tieba.ll4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class il4<T> implements ll4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xj4 a;
    public in4 b;
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

    public abstract wk4 s(T t);

    public abstract T t(JSONObject jSONObject);

    public il4(xj4 xj4Var, in4 in4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xj4Var, in4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xj4Var;
        this.b = in4Var;
    }

    public void a(wk4 wk4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, wk4Var, str, str2, str3) == null) {
            c(wk4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.ll4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            xj4 xj4Var = this.a;
            if (xj4Var != null) {
                xj4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    public void c(wk4 wk4Var, String str, String str2, String str3, @Nullable hl4 hl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, wk4Var, str, str2, str3, hl4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (wk4Var != null) {
                try {
                    if (wk4Var.a != 0) {
                        i = wk4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && wk4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", nj4.b().c());
                        jSONObject.put("network", ds4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof en4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((en4) this.b).g());
            }
            if (hl4Var != null && hl4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, hl4Var.f());
            }
            lj4 b = nj4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            cp4.a(this.b.a(), "cs_protocol", g(), i, jSONObject);
        }
    }

    @CallSuper
    public wk4 d(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            if (!e(t)) {
                return new wk4(2103, str);
            }
            return null;
        }
        return (wk4) invokeLL.objValue;
    }

    public wk4 i(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new wk4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new wk4(2101, Log.getStackTraceString(exc));
        }
        return (wk4) invokeLL.objValue;
    }

    public void k(xk4 xk4Var, kp4 kp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, xk4Var, kp4Var) != null) || xk4Var == null) {
            return;
        }
        kp4Var.a(xk4Var, PMSPkgStatus.WAIT);
    }

    public void l(zk4 zk4Var, kp4 kp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, zk4Var, kp4Var) != null) || zk4Var == null) {
            return;
        }
        kp4Var.a(zk4Var, PMSPkgStatus.WAIT);
    }

    public void m(List<dl4> list, kp4 kp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, list, kp4Var) == null) && list != null && !list.isEmpty()) {
            for (dl4 dl4Var : list) {
                kp4Var.a(dl4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void n(bl4 bl4Var, kp4 kp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, bl4Var, kp4Var) != null) || bl4Var == null) {
            return;
        }
        kp4Var.a(bl4Var, PMSPkgStatus.WAIT);
    }

    public void o(List<cl4> list, kp4 kp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, kp4Var) == null) && list != null && !list.isEmpty()) {
            for (cl4 cl4Var : list) {
                kp4Var.a(cl4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void p(dl4 dl4Var, kp4 kp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, dl4Var, kp4Var) != null) || dl4Var == null) {
            return;
        }
        kp4Var.a(dl4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<dl4> f(@Nullable List<dl4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (dl4 dl4Var : list) {
                    if (dl4Var != null && !arrayList.contains(dl4Var)) {
                        zj4 i = zj4.i();
                        String str = dl4Var.g;
                        long j = dl4Var.i;
                        if (!nj4.b().r(i.q(str, j, j))) {
                            arrayList.add(dl4Var);
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
    public final String h(hl4 hl4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hl4Var)) == null) {
            if (hl4Var == null || hl4Var.c() == null || (optJSONObject = hl4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        wj4 p;
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

    @Override // com.baidu.tieba.ll4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            wk4 i = i(exc, j(exc.getMessage()));
            this.a.C(i);
            a(i, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.ll4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new wk4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.ll4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            xj4 xj4Var = this.a;
            if (xj4Var != null) {
                xj4Var.H(str, i);
            }
            if (i != 200) {
                wk4 wk4Var = new wk4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                wk4Var.f = i;
                xj4 xj4Var2 = this.a;
                if (xj4Var2 != null) {
                    xj4Var2.C(wk4Var);
                }
                a(wk4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            hl4 a = hl4.a(str);
            if (a == null) {
                JSONObject p = jp4.p(str);
                wk4 wk4Var2 = new wk4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                xj4 xj4Var3 = this.a;
                if (xj4Var3 != null) {
                    xj4Var3.C(wk4Var2);
                }
                a(wk4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T t = t(a.c());
            if (r(t, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                wk4 wk4Var3 = new wk4(d, a.e(), a.g(), h(a));
                xj4 xj4Var4 = this.a;
                if (xj4Var4 != null) {
                    xj4Var4.C(wk4Var3);
                }
                if (a.d() != 1010) {
                    c(wk4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (t == null) {
                wk4 wk4Var4 = new wk4(2102, "response data empty");
                xj4 xj4Var5 = this.a;
                if (xj4Var5 != null) {
                    xj4Var5.C(wk4Var4);
                }
                c(wk4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                wk4 d2 = d(str, t);
                if (d2 != null) {
                    xj4 xj4Var6 = this.a;
                    if (xj4Var6 != null) {
                        xj4Var6.C(d2);
                    }
                    c(d2, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                s(t);
            }
        }
    }
}
