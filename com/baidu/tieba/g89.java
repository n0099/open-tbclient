package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, k89 k89Var, j89 j89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, k89Var, j89Var) == null) {
            if (yb9.a) {
                yb9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + j89Var.toString());
            }
            e89 g = b89.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (j89Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", j89Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", j89Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", j89Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", j89Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", j89Var.d + ""));
                }
                g.a("perf_record_arperf", str, k89Var.a, k89Var.b, k89Var.c, k89Var.d, k89Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (yb9.a) {
                yb9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            e89 g = b89.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", wb9.a(b89.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(wb9.b(b89.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
