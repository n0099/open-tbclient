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
import com.baidu.tieba.il4;
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
public abstract class fl4<T> implements il4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uj4 a;
    public fn4 b;
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

    public abstract tk4 s(T t);

    public abstract T t(JSONObject jSONObject);

    public fl4(uj4 uj4Var, fn4 fn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uj4Var, fn4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = uj4Var;
        this.b = fn4Var;
    }

    public void a(tk4 tk4Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, tk4Var, str, str2, str3) == null) {
            c(tk4Var, str, str2, str3, null);
        }
    }

    @Override // com.baidu.tieba.il4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            uj4 uj4Var = this.a;
            if (uj4Var != null) {
                uj4Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    public void c(tk4 tk4Var, String str, String str2, String str3, @Nullable el4 el4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, tk4Var, str, str2, str3, el4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (tk4Var != null) {
                try {
                    if (tk4Var.a != 0) {
                        i = tk4Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && tk4Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", kj4.b().c());
                        jSONObject.put("network", as4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof bn4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((bn4) this.b).g());
            }
            if (el4Var != null && el4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, el4Var.f());
            }
            ij4 b = kj4.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            zo4.a(this.b.a(), "cs_protocol", g(), i, jSONObject);
        }
    }

    @CallSuper
    public tk4 d(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) {
            if (!e(t)) {
                return new tk4(2103, str);
            }
            return null;
        }
        return (tk4) invokeLL.objValue;
    }

    public tk4 i(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new tk4(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new tk4(2101, Log.getStackTraceString(exc));
        }
        return (tk4) invokeLL.objValue;
    }

    public void k(uk4 uk4Var, hp4 hp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, uk4Var, hp4Var) != null) || uk4Var == null) {
            return;
        }
        hp4Var.a(uk4Var, PMSPkgStatus.WAIT);
    }

    public void l(wk4 wk4Var, hp4 hp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, wk4Var, hp4Var) != null) || wk4Var == null) {
            return;
        }
        hp4Var.a(wk4Var, PMSPkgStatus.WAIT);
    }

    public void m(List<al4> list, hp4 hp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, list, hp4Var) == null) && list != null && !list.isEmpty()) {
            for (al4 al4Var : list) {
                hp4Var.a(al4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void n(yk4 yk4Var, hp4 hp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, yk4Var, hp4Var) != null) || yk4Var == null) {
            return;
        }
        hp4Var.a(yk4Var, PMSPkgStatus.WAIT);
    }

    public void o(List<zk4> list, hp4 hp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, hp4Var) == null) && list != null && !list.isEmpty()) {
            for (zk4 zk4Var : list) {
                hp4Var.a(zk4Var, PMSPkgStatus.WAIT);
            }
        }
    }

    public void p(al4 al4Var, hp4 hp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, al4Var, hp4Var) != null) || al4Var == null) {
            return;
        }
        hp4Var.a(al4Var, PMSPkgStatus.WAIT);
    }

    @Nullable
    public List<al4> f(@Nullable List<al4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (al4 al4Var : list) {
                    if (al4Var != null && !arrayList.contains(al4Var)) {
                        wj4 i = wj4.i();
                        String str = al4Var.g;
                        long j = al4Var.i;
                        if (!kj4.b().r(i.q(str, j, j))) {
                            arrayList.add(al4Var);
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
    public final String h(el4 el4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, el4Var)) == null) {
            if (el4Var == null || el4Var.c() == null || (optJSONObject = el4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        tj4 p;
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

    @Override // com.baidu.tieba.il4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            tk4 i = i(exc, j(exc.getMessage()));
            this.a.C(i);
            a(i, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.il4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new tk4(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.baidu.tieba.il4.a
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            uj4 uj4Var = this.a;
            if (uj4Var != null) {
                uj4Var.H(str, i);
            }
            if (i != 200) {
                tk4 tk4Var = new tk4(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                tk4Var.f = i;
                uj4 uj4Var2 = this.a;
                if (uj4Var2 != null) {
                    uj4Var2.C(tk4Var);
                }
                a(tk4Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            el4 a = el4.a(str);
            if (a == null) {
                JSONObject p = gp4.p(str);
                tk4 tk4Var2 = new tk4(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                uj4 uj4Var3 = this.a;
                if (uj4Var3 != null) {
                    uj4Var3.C(tk4Var2);
                }
                a(tk4Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T t = t(a.c());
            if (r(t, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                tk4 tk4Var3 = new tk4(d, a.e(), a.g(), h(a));
                uj4 uj4Var4 = this.a;
                if (uj4Var4 != null) {
                    uj4Var4.C(tk4Var3);
                }
                if (a.d() != 1010) {
                    c(tk4Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (t == null) {
                tk4 tk4Var4 = new tk4(2102, "response data empty");
                uj4 uj4Var5 = this.a;
                if (uj4Var5 != null) {
                    uj4Var5.C(tk4Var4);
                }
                c(tk4Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                tk4 d2 = d(str, t);
                if (d2 != null) {
                    uj4 uj4Var6 = this.a;
                    if (uj4Var6 != null) {
                        uj4Var6.C(d2);
                    }
                    c(d2, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                s(t);
            }
        }
    }
}
