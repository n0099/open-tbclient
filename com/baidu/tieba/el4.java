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
import com.baidu.tieba.hl4;
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
public abstract class el4<T> implements hl4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tj4 a;
    public en4 b;
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

    public abstract sk4 s(T t);

    public abstract T t(JSONObject jSONObject);

    public el4(tj4 tj4Var, en4 en4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tj4Var, en4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tj4Var;
        this.b = en4Var;
    }

    public void a(sk4 sk4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, sk4Var, str, str2, str3) == null) {
            c(sk4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.hl4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            tj4 tj4Var = this.a;
            if (tj4Var != null) {
                tj4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    public void c(sk4 sk4Var, String str, String str2, String str3, @Nullable dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, sk4Var, str, str2, str3, dl4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (sk4Var != null) {
                try {
                    if (sk4Var.a != 0) {
                        i = sk4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && sk4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", jj4.b().c());
                        jSONObject.put("network", zr4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof an4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((an4) this.b).g());
            }
            if (dl4Var != null && dl4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, dl4Var.f());
            }
            hj4 b = jj4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            yo4.a(this.b.a(), "cs_protocol", g(), i, jSONObject);
        }
    }

    @CallSuper
    public sk4 d(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            if (!e(t)) {
                return new sk4(2103, str);
            }
            return null;
        }
        return (sk4) invokeLL.objValue;
    }

    public sk4 i(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new sk4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new sk4(2101, Log.getStackTraceString(exc));
        }
        return (sk4) invokeLL.objValue;
    }

    public void k(tk4 tk4Var, gp4 gp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, tk4Var, gp4Var) != null) || tk4Var == null) {
            return;
        }
        gp4Var.a(tk4Var, PMSPkgStatus.WAIT);
    }

    public void l(vk4 vk4Var, gp4 gp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, vk4Var, gp4Var) != null) || vk4Var == null) {
            return;
        }
        gp4Var.a(vk4Var, PMSPkgStatus.WAIT);
    }

    public void m(List<zk4> list, gp4 gp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, list, gp4Var) == null) && list != null && !list.isEmpty()) {
            for (zk4 zk4Var : list) {
                gp4Var.a(zk4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void n(xk4 xk4Var, gp4 gp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, xk4Var, gp4Var) != null) || xk4Var == null) {
            return;
        }
        gp4Var.a(xk4Var, PMSPkgStatus.WAIT);
    }

    public void o(List<yk4> list, gp4 gp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, gp4Var) == null) && list != null && !list.isEmpty()) {
            for (yk4 yk4Var : list) {
                gp4Var.a(yk4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void p(zk4 zk4Var, gp4 gp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, zk4Var, gp4Var) != null) || zk4Var == null) {
            return;
        }
        gp4Var.a(zk4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<zk4> f(@Nullable List<zk4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (zk4 zk4Var : list) {
                    if (zk4Var != null && !arrayList.contains(zk4Var)) {
                        vj4 i = vj4.i();
                        String str = zk4Var.g;
                        long j = zk4Var.i;
                        if (!jj4.b().r(i.q(str, j, j))) {
                            arrayList.add(zk4Var);
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
    public final String h(dl4 dl4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, dl4Var)) == null) {
            if (dl4Var == null || dl4Var.c() == null || (optJSONObject = dl4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        sj4 p;
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

    @Override // com.baidu.tieba.hl4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            sk4 i = i(exc, j(exc.getMessage()));
            this.a.C(i);
            a(i, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.hl4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new sk4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.hl4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            tj4 tj4Var = this.a;
            if (tj4Var != null) {
                tj4Var.H(str, i);
            }
            if (i != 200) {
                sk4 sk4Var = new sk4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                sk4Var.f = i;
                tj4 tj4Var2 = this.a;
                if (tj4Var2 != null) {
                    tj4Var2.C(sk4Var);
                }
                a(sk4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            dl4 a = dl4.a(str);
            if (a == null) {
                JSONObject p = fp4.p(str);
                sk4 sk4Var2 = new sk4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                tj4 tj4Var3 = this.a;
                if (tj4Var3 != null) {
                    tj4Var3.C(sk4Var2);
                }
                a(sk4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T t = t(a.c());
            if (r(t, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                sk4 sk4Var3 = new sk4(d, a.e(), a.g(), h(a));
                tj4 tj4Var4 = this.a;
                if (tj4Var4 != null) {
                    tj4Var4.C(sk4Var3);
                }
                if (a.d() != 1010) {
                    c(sk4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (t == null) {
                sk4 sk4Var4 = new sk4(2102, "response data empty");
                tj4 tj4Var5 = this.a;
                if (tj4Var5 != null) {
                    tj4Var5.C(sk4Var4);
                }
                c(sk4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                sk4 d2 = d(str, t);
                if (d2 != null) {
                    tj4 tj4Var6 = this.a;
                    if (tj4Var6 != null) {
                        tj4Var6.C(d2);
                    }
                    c(d2, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                s(t);
            }
        }
    }
}
