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
/* loaded from: classes5.dex */
public class ee2 extends de2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean F;
    public transient /* synthetic */ FieldHolder $fh;
    public final db3 D;
    public final bc2 E;

    @Override // com.baidu.tieba.he2
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.de2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947731383, "Lcom/baidu/tieba/ee2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947731383, "Lcom/baidu/tieba/ee2;");
                return;
            }
        }
        F = nr1.a;
    }

    @Override // com.baidu.tieba.de2, com.baidu.tieba.yi4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            J0();
            i43.p("startup").F(new UbcFlowEvent("aps_start_req"));
            super.D();
        }
    }

    @Override // com.baidu.tieba.de2, com.baidu.tieba.yi4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            i43.p("startup").F(new UbcFlowEvent("aps_end_req"));
            K0();
        }
    }

    @Override // com.baidu.tieba.yi4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.F();
            if (this.n != null) {
                u0();
            }
            wm3 wm3Var = new wm3();
            wm3Var.k(10L);
            wm3Var.i(2901L);
            wm3Var.d("同步获取-> Server无包");
            t0(true, wm3Var);
        }
    }

    public aw2 I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.D.W();
        }
        return (aw2) invokeV.objValue;
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

    @Override // com.baidu.tieba.de2
    public PMSDownloadType k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return PMSDownloadType.SYNC;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ee2(db3 db3Var) {
        super(db3Var.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {db3Var};
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
        this.D = db3Var;
        this.E = new bc2();
    }

    public static void H0(aw2 aw2Var, wm3 wm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, aw2Var, wm3Var) != null) || aw2Var == null) {
            return;
        }
        gi3 gi3Var = new gi3();
        gi3Var.a = wh3.n(aw2Var.G());
        gi3Var.f = aw2Var.H();
        gi3Var.c = aw2Var.T();
        gi3Var.b = "launch";
        gi3Var.e = "success";
        gi3Var.a("status", "1");
        if (wm3Var != null) {
            gi3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, String.valueOf(wm3Var.a()));
            gi3Var.a("msg", wm3Var.g().toString());
        }
        gi3Var.d(aw2Var.s0().getString("ubc"));
        gi3Var.j(aw2Var);
        wh3.onEvent(gi3Var);
        HybridUbcFlow d = i43.d("startup");
        if (d != null) {
            d.E("value", "na_success");
        }
    }

    @Override // com.baidu.tieba.de2, com.baidu.tieba.yi4
    public void C(xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xj4Var) == null) {
            super.C(xj4Var);
            if (F) {
                Log.e("PkgSyncDownloadCallback", "onFetchError: " + xj4Var.toString());
            }
            L0(xj4Var);
            wm3 wm3Var = new wm3();
            wm3Var.k(10L);
            wm3Var.c(xj4Var);
            if (ve2.j(xj4Var) && ku2.T().a(ku2.c(), this.o, wm3Var)) {
                t0(false, wm3Var);
                H0(this.D.W(), wm3Var);
            } else if (xj4Var != null && xj4Var.a == 1020) {
                t0(false, wm3Var);
                H0(this.D.W(), wm3Var);
            } else {
                t0(true, wm3Var);
            }
        }
    }

    @Override // com.baidu.tieba.de2
    public void w0(Throwable th) {
        wm3 wm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
                if (F) {
                    Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
                }
                wm3Var = pkgDownloadError.getErrCode();
            } else {
                if (F) {
                    Log.e("PkgSyncDownloadCallback", "未知错误");
                }
                wm3Var = new wm3();
                wm3Var.k(10L);
                wm3Var.i(2900L);
                wm3Var.d("包下载过程未知错误");
            }
            t0(true, wm3Var);
        }
    }

    @Override // com.baidu.tieba.de2, com.baidu.tieba.yi4
    public void G(lo4 lo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lo4Var) == null) {
            i43.p("startup").F(new UbcFlowEvent("aps_start_download"));
            super.G(lo4Var);
        }
    }

    @Override // com.baidu.tieba.yi4
    public void H(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            super.H(str, i);
            ik4 a = ik4.a(str);
            if (a == null) {
                return;
            }
            boolean b = ko4.b(a.c());
            d82.i("PkgSyncDownloadCallback", "resetCore: " + b + ";statusCode:" + i);
            if (b) {
                t73 e = t73.e();
                v73 v73Var = new v73(129);
                v73Var.f(true);
                e.h(v73Var);
            }
        }
    }

    @Override // com.baidu.tieba.yi4, com.baidu.tieba.vi4
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
                i43.p("startup").F(new UbcFlowEvent(str2));
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
    @Override // com.baidu.tieba.yi4
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
        HybridUbcFlow p = i43.p("startup");
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
        d82.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
        d82.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
    }

    public final void L0(xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, xj4Var) != null) || xj4Var == null) {
            return;
        }
        try {
            PMSAppInfo a = ko4.a(new JSONObject(xj4Var.c));
            a.appId = a.appKey;
            cb3.K().q().N0(a);
            d82.i("PkgSyncDownloadCallback", "onFetchError: pms info:" + a.toString());
        } catch (Exception e) {
            if (F) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.yi4, com.baidu.tieba.wi4
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

    @Override // com.baidu.tieba.de2
    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.v0();
            if (F) {
                Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
            }
            HybridUbcFlow p = i43.p("startup");
            p.F(new UbcFlowEvent("aps_end_download"));
            p.E("type", "0");
            it2.d("0");
            this.p.add(new UbcFlowEvent("na_start_update_db"));
            wm3 F0 = F0();
            this.p.add(new UbcFlowEvent("na_end_update_db"));
            if (F0 == null) {
                if (F) {
                    Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
                }
                aw2 I0 = I0();
                ak4 ak4Var = this.l;
                if (ak4Var != null && ak4Var.h == 0) {
                    I0.Z0(ik3.e(0));
                    I0.E(1);
                }
                ak4 ak4Var2 = this.l;
                if (ak4Var2 != null && ak4Var2.h == 1) {
                    I0.Z0(ik3.e(1));
                    I0.E(1);
                }
                yj4 yj4Var = this.m;
                if (yj4Var != null && yj4Var.h == 0) {
                    I0.C0(ml2.c(0));
                    I0.E(2);
                }
                yj4 yj4Var2 = this.m;
                if (yj4Var2 != null && yj4Var2.h == 1) {
                    I0.C0(ml2.c(1));
                    I0.E(2);
                }
                dk4 dk4Var = this.q;
                if (dk4Var != null) {
                    I0.F0(dk4Var.r);
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
