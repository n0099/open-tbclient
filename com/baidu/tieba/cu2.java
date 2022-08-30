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
/* loaded from: classes3.dex */
public class cu2 implements tf3<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947687177, "Lcom/baidu/tieba/cu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947687177, "Lcom/baidu/tieba/cu2;");
                return;
            }
        }
        a = kh1.a;
    }

    public cu2() {
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
    @Override // com.baidu.tieba.tf3
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hybridUbcFlow) == null) {
            a13 M = a13.M();
            if (hybridUbcFlow == null || hybridUbcFlow.f.isEmpty() || !a || M == null) {
                return;
            }
            HybridUbcFlow.SubmitStrategy i = hybridUbcFlow.i();
            String str = hybridUbcFlow.d.contains("fe_route_start") ? "fe_route_start" : "na_first_receive_action";
            int i2 = 2;
            char c = 1;
            char c2 = 0;
            if (i == HybridUbcFlow.SubmitStrategy.ROUTE) {
                f = hybridUbcFlow.f("fe_first_render_start", str);
            } else if (i == HybridUbcFlow.SubmitStrategy.ROUTE_NA) {
                f = hybridUbcFlow.f("na_push_page_end", str);
            } else {
                f = hybridUbcFlow.f("web_widget_first_screen_finish", str);
            }
            if (f < 1) {
                f = 1;
            }
            String Z = M.Z();
            if (TextUtils.isEmpty(Z)) {
                Z = "";
            }
            Log.i("RouteReporter", "\n\n  小程序路由性能报告: " + Z + " appID: " + (!TextUtils.isEmpty(M.b) ? M.b : "") + " launchId ：" + (M.Y() != null ? M.Y().V() : "") + " speedLog\n");
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < 100; i3++) {
                sb.append("&");
            }
            Log.i("RouteReporter", String.format("Delta [%s]  Cost Src  Total Action", sb.toString()));
            long g = hybridUbcFlow.f.get(0).g();
            Iterator<UbcFlowEvent> it = hybridUbcFlow.f.iterator();
            long j = 0;
            long j2 = 0;
            while (it.hasNext()) {
                UbcFlowEvent next = it.next();
                String[] strArr = new String[i2];
                strArr[c2] = next.a;
                strArr[c] = str;
                long f2 = hybridUbcFlow.f(strArr);
                boolean z = f2 < j;
                boolean z2 = f2 > f;
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
                int i4 = round2 > 100 ? 100 : round2;
                StringBuilder sb2 = new StringBuilder();
                Iterator<UbcFlowEvent> it2 = it;
                sb2.append(String.format(Locale.getDefault(), "%5d ", Long.valueOf(j3)));
                sb2.append(z ? "<" : PreferencesUtil.LEFT_MOUNT);
                for (int i5 = 0; i5 < 100; i5++) {
                    if (i5 > round) {
                        sb2.append(".");
                    } else if (i5 > i4) {
                        sb2.append("=");
                    } else {
                        sb2.append("#");
                    }
                }
                sb2.append(z3 ? ">" : PreferencesUtil.RIGHT_MOUNT);
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
                i2 = 2;
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
            sb4.append(TextUtils.equals(h, "0") ? "无需下载分包" : "需要下载分包");
            sb3.append(sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\npreload :");
            sb5.append(TextUtils.equals(h2, "0") ? "未完成" : "已完成");
            sb3.append(sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("\nhasWebViewWidget :");
            sb6.append(TextUtils.equals(h3, "0") ? "无webview组件" : "有webview组件");
            sb3.append(sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("\ntype ：");
            sb7.append(TextUtils.isEmpty(optString) ? "" : optString);
            sb3.append(sb7.toString());
            Log.i("RouteReporter", "Report ： " + sb3.toString());
        }
    }
}
