package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes4.dex */
public class hx2 implements yi3<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947839015, "Lcom/baidu/tieba/hx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947839015, "Lcom/baidu/tieba/hx2;");
                return;
            }
        }
        a = pk1.a;
    }

    public hx2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yi3
    /* renamed from: b */
    public void a(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            c(hybridUbcFlow);
        }
    }

    @SuppressLint({"SwanDebugLog", "LogConditional"})
    public void c(HybridUbcFlow hybridUbcFlow) {
        long f;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        boolean z2;
        int i;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hybridUbcFlow) == null) {
            f43 M = f43.M();
            if (hybridUbcFlow != null && !hybridUbcFlow.f.isEmpty() && a && M != null) {
                HybridUbcFlow.SubmitStrategy i2 = hybridUbcFlow.i();
                String str8 = "fe_route_start";
                if (!hybridUbcFlow.d.contains("fe_route_start")) {
                    str8 = "na_first_receive_action";
                }
                int i3 = 2;
                char c = 1;
                char c2 = 0;
                if (i2 == HybridUbcFlow.SubmitStrategy.ROUTE) {
                    f = hybridUbcFlow.f("fe_first_render_start", str8);
                } else if (i2 == HybridUbcFlow.SubmitStrategy.ROUTE_NA) {
                    f = hybridUbcFlow.f("na_push_page_end", str8);
                } else {
                    f = hybridUbcFlow.f("web_widget_first_screen_finish", str8);
                }
                if (f < 1) {
                    f = 1;
                }
                String Z = M.Z();
                String str9 = "";
                if (TextUtils.isEmpty(Z)) {
                    Z = "";
                }
                if (TextUtils.isEmpty(M.b)) {
                    str = "";
                } else {
                    str = M.b;
                }
                if (M.Y() == null) {
                    str2 = "";
                } else {
                    str2 = M.Y().V();
                }
                Log.i("RouteReporter", "\n\n  小程序路由性能报告: " + Z + " appID: " + str + " launchId ：" + str2 + " speedLog\n");
                StringBuilder sb = new StringBuilder();
                for (int i4 = 0; i4 < 100; i4++) {
                    sb.append("&");
                }
                Log.i("RouteReporter", String.format("Delta [%s]  Cost Src  Total Action", sb.toString()));
                long g = hybridUbcFlow.f.get(0).g();
                Iterator<UbcFlowEvent> it = hybridUbcFlow.f.iterator();
                long j = 0;
                long j2 = 0;
                while (it.hasNext()) {
                    UbcFlowEvent next = it.next();
                    String[] strArr = new String[i3];
                    strArr[c2] = next.a;
                    strArr[c] = str8;
                    long f2 = hybridUbcFlow.f(strArr);
                    if (f2 < j) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (f2 > f) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z) {
                        f2 = j;
                    }
                    if (z2) {
                        f2 = f;
                    }
                    long j3 = f2 - j2;
                    boolean z3 = z2;
                    if (j3 < j) {
                        j3 = j;
                    }
                    long j4 = 100;
                    int round = Math.round((float) ((f2 * j4) / f));
                    if (round > 100) {
                        round = 100;
                    }
                    int round2 = Math.round((float) ((j3 * j4) / f));
                    if (round2 > 100) {
                        i = 100;
                    } else {
                        i = round2;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    Iterator<UbcFlowEvent> it2 = it;
                    sb2.append(String.format(Locale.getDefault(), "%5d ", Long.valueOf(j3)));
                    if (z) {
                        str6 = "<";
                    } else {
                        str6 = PreferencesUtil.LEFT_MOUNT;
                    }
                    sb2.append(str6);
                    for (int i5 = 0; i5 < 100; i5++) {
                        if (i5 > round) {
                            sb2.append(".");
                        } else if (i5 > i) {
                            sb2.append("=");
                        } else {
                            sb2.append("#");
                        }
                    }
                    if (z3) {
                        str7 = ">";
                    } else {
                        str7 = PreferencesUtil.RIGHT_MOUNT;
                    }
                    sb2.append(str7);
                    c = 1;
                    sb2.append(String.format(Locale.getDefault(), " %5d", Long.valueOf(f2)));
                    sb2.append(String.format("  %s", next.f()));
                    sb2.append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(next.g() - g)));
                    sb2.append(next.a);
                    if (next.b()) {
                        sb2.append("(LocalRecord)");
                    }
                    Log.i("RouteReporter", sb2.toString());
                    j2 = f2;
                    it = it2;
                    i3 = 2;
                    c2 = 0;
                    j = 0;
                }
                Log.i("RouteReporter", "Total  ： " + hybridUbcFlow.f.size());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\n\n小程序路由总时长：========> " + f);
                String optString = hybridUbcFlow.m().optString("type");
                String h = hybridUbcFlow.h("sub_state");
                String h2 = hybridUbcFlow.h("preload");
                String h3 = hybridUbcFlow.h("web_widget_state");
                StringBuilder sb4 = new StringBuilder();
                sb4.append("\nsub_state :");
                if (TextUtils.equals(h, "0")) {
                    str3 = "无需下载分包";
                } else {
                    str3 = "需要下载分包";
                }
                sb4.append(str3);
                sb3.append(sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\npreload :");
                if (TextUtils.equals(h2, "0")) {
                    str4 = "未完成";
                } else {
                    str4 = "已完成";
                }
                sb5.append(str4);
                sb3.append(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("\nhasWebViewWidget :");
                if (TextUtils.equals(h3, "0")) {
                    str5 = "无webview组件";
                } else {
                    str5 = "有webview组件";
                }
                sb6.append(str5);
                sb3.append(sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append("\ntype ：");
                if (!TextUtils.isEmpty(optString)) {
                    str9 = optString;
                }
                sb7.append(str9);
                sb3.append(sb7.toString());
                Log.i("RouteReporter", "Report ： " + sb3.toString());
            }
        }
    }
}
