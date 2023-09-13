package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ie2 extends he2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean F;
    public transient /* synthetic */ FieldHolder $fh;
    public final hb3 D;
    public final fc2 E;

    @Override // com.baidu.tieba.le2
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.he2
    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 200;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947850547, "Lcom/baidu/tieba/ie2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947850547, "Lcom/baidu/tieba/ie2;");
                return;
            }
        }
        F = rr1.a;
    }

    @Override // com.baidu.tieba.he2, com.baidu.tieba.cj4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            J0();
            m43.p("startup").F(new UbcFlowEvent("aps_start_req"));
            super.D();
        }
    }

    @Override // com.baidu.tieba.he2, com.baidu.tieba.cj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            m43.p("startup").F(new UbcFlowEvent("aps_end_req"));
            K0();
        }
    }

    @Override // com.baidu.tieba.cj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.F();
            if (this.n != null) {
                u0();
            }
            an3 an3Var = new an3();
            an3Var.k(10L);
            an3Var.i(2901L);
            an3Var.d("同步获取-> Server无包");
            t0(true, an3Var);
        }
    }

    public ew2 I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.D.W();
        }
        return (ew2) invokeV.objValue;
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.D.k() != 1) {
            this.E.f();
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.D.k() != 1) {
            this.E.g();
            if (F) {
                Log.d("PkgSyncDownloadCallback", "PMS CS协议信息获取成功");
            }
        }
    }

    @Override // com.baidu.tieba.he2
    public PMSDownloadType k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return PMSDownloadType.SYNC;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ie2(hb3 hb3Var) {
        super(hb3Var.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hb3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = hb3Var;
        this.E = new fc2();
    }

    public static void H0(ew2 ew2Var, an3 an3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, ew2Var, an3Var) != null) || ew2Var == null) {
            return;
        }
        ki3 ki3Var = new ki3();
        ki3Var.a = ai3.n(ew2Var.G());
        ki3Var.f = ew2Var.H();
        ki3Var.c = ew2Var.T();
        ki3Var.b = "launch";
        ki3Var.e = "success";
        ki3Var.a("status", "1");
        if (an3Var != null) {
            ki3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, String.valueOf(an3Var.a()));
            ki3Var.a("msg", an3Var.g().toString());
        }
        ki3Var.d(ew2Var.s0().getString("ubc"));
        ki3Var.j(ew2Var);
        ai3.onEvent(ki3Var);
        HybridUbcFlow d = m43.d("startup");
        if (d != null) {
            d.E("value", "na_success");
        }
    }

    @Override // com.baidu.tieba.he2, com.baidu.tieba.cj4
    public void C(bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bk4Var) == null) {
            super.C(bk4Var);
            if (F) {
                Log.e("PkgSyncDownloadCallback", "onFetchError: " + bk4Var.toString());
            }
            L0(bk4Var);
            an3 an3Var = new an3();
            an3Var.k(10L);
            an3Var.c(bk4Var);
            if (ze2.j(bk4Var) && ou2.T().a(ou2.c(), this.o, an3Var)) {
                t0(false, an3Var);
                H0(this.D.W(), an3Var);
            } else if (bk4Var != null && bk4Var.a == 1020) {
                t0(false, an3Var);
                H0(this.D.W(), an3Var);
            } else {
                t0(true, an3Var);
            }
        }
    }

    @Override // com.baidu.tieba.he2
    public void w0(Throwable th) {
        an3 an3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
                if (F) {
                    Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
                }
                an3Var = pkgDownloadError.getErrCode();
            } else {
                if (F) {
                    Log.e("PkgSyncDownloadCallback", "未知错误");
                }
                an3Var = new an3();
                an3Var.k(10L);
                an3Var.i(2900L);
                an3Var.d("包下载过程未知错误");
            }
            t0(true, an3Var);
        }
    }

    @Override // com.baidu.tieba.he2, com.baidu.tieba.cj4
    public void G(po4 po4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, po4Var) == null) {
            m43.p("startup").F(new UbcFlowEvent("aps_start_download"));
            super.G(po4Var);
        }
    }

    @Override // com.baidu.tieba.cj4
    public void H(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            super.H(str, i);
            mk4 a = mk4.a(str);
            if (a == null) {
                return;
            }
            boolean b = oo4.b(a.c());
            h82.i("PkgSyncDownloadCallback", "resetCore: " + b + ";statusCode:" + i);
            if (b) {
                x73 e = x73.e();
                z73 z73Var = new z73(129);
                z73Var.f(true);
                e.h(z73Var);
            }
        }
    }

    @Override // com.baidu.tieba.cj4, com.baidu.tieba.zi4
    public void n(String str, String str2) {
        List<UbcFlowEvent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            super.n(str, str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 53647) {
                    if (hashCode == 54608 && str.equals("770")) {
                        c = 1;
                    }
                } else if (str.equals("670")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c == 1 && (list = this.p) != null) {
                        list.add(new UbcFlowEvent(str2));
                        return;
                    }
                    return;
                }
                m43.p("startup").F(new UbcFlowEvent(str2));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0017 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // com.baidu.tieba.cj4
    public void I(String str, String str2, JSONObject jSONObject) {
        String jSONObject2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, str, str2, jSONObject) != null) || jSONObject == null) {
            return;
        }
        if (F) {
            String str3 = 0;
            str3 = 0;
            try {
                try {
                    jSONObject2 = jSONObject.toString(4);
                    str3 = new StringBuilder();
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject2 = jSONObject.toString();
                    str3 = new StringBuilder();
                }
                str3.append("onStatRecord: url:");
                str3.append(str);
                str3.append(" networkStatRecord:\n");
                str3.append(jSONObject2);
                Log.i("PkgSyncDownloadCallback", str3.toString());
            } catch (Throwable th) {
                Log.i("PkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + str3);
                throw th;
            }
        }
        long optLong = jSONObject.optLong("stat_recode_start_time", System.currentTimeMillis());
        long optLong2 = jSONObject.optLong("dnsEndTime", optLong);
        long optLong3 = jSONObject.optLong("dnsStartTime", optLong);
        long optLong4 = jSONObject.optLong("connectedTime", optLong);
        long optLong5 = jSONObject.optLong("startTime", optLong);
        HybridUbcFlow p = m43.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("pms_network_start");
        ubcFlowEvent.h(optLong5);
        p.F(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("pms_network_conn");
        ubcFlowEvent2.h(optLong4);
        p.F(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("pms_dns_start");
        ubcFlowEvent3.h(optLong3);
        p.F(ubcFlowEvent3);
        UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("pms_dns_end");
        ubcFlowEvent4.h(optLong2);
        p.F(ubcFlowEvent4);
        UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("pms_network_response");
        ubcFlowEvent5.h(jSONObject.optLong("responseTime", optLong));
        p.F(ubcFlowEvent5);
        UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("pms_send_header");
        ubcFlowEvent6.h(jSONObject.optLong("sendHeaderTime", optLong));
        p.F(ubcFlowEvent6);
        UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("pms_receive_header");
        ubcFlowEvent7.h(jSONObject.optLong("receiveHeaderTime", optLong));
        p.F(ubcFlowEvent7);
        h82.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
        h82.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
    }

    public final void L0(bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, bk4Var) != null) || bk4Var == null) {
            return;
        }
        try {
            PMSAppInfo a = oo4.a(new JSONObject(bk4Var.c));
            a.appId = a.appKey;
            gb3.K().q().N0(a);
            h82.i("PkgSyncDownloadCallback", "onFetchError: pms info:" + a.toString());
        } catch (Exception e) {
            if (F) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.cj4, com.baidu.tieba.aj4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, bundle, set)) == null) {
            Bundle m = super.m(bundle, set);
            if (set.contains("get_launch_id")) {
                m.putString("launch_id", this.D.W().V());
            }
            return m;
        }
        return (Bundle) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.he2
    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.v0();
            if (F) {
                Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
            }
            HybridUbcFlow p = m43.p("startup");
            p.F(new UbcFlowEvent("aps_end_download"));
            p.E("type", "0");
            mt2.d("0");
            this.p.add(new UbcFlowEvent("na_start_update_db"));
            an3 F0 = F0();
            this.p.add(new UbcFlowEvent("na_end_update_db"));
            if (F0 == null) {
                if (F) {
                    Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
                }
                ew2 I0 = I0();
                ek4 ek4Var = this.l;
                if (ek4Var != null && ek4Var.h == 0) {
                    I0.Z0(mk3.e(0));
                    I0.E(1);
                }
                ek4 ek4Var2 = this.l;
                if (ek4Var2 != null && ek4Var2.h == 1) {
                    I0.Z0(mk3.e(1));
                    I0.E(1);
                }
                ck4 ck4Var = this.m;
                if (ck4Var != null && ck4Var.h == 0) {
                    I0.C0(ql2.c(0));
                    I0.E(2);
                }
                ck4 ck4Var2 = this.m;
                if (ck4Var2 != null && ck4Var2.h == 1) {
                    I0.C0(ql2.c(1));
                    I0.E(2);
                }
                hk4 hk4Var = this.q;
                if (hk4Var != null) {
                    I0.F0(hk4Var.r);
                    I0.V0(this.q.p);
                }
                s0(this.n);
                A0("main_download", "0");
                return;
            }
            if (F) {
                Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
            }
            t0(true, F0);
        }
    }
}
