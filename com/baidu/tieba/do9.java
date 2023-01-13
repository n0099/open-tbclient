package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class do9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, ho9 ho9Var, go9 go9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, ho9Var, go9Var) == null) {
            if (vr9.a) {
                vr9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + go9Var.toString());
            }
            bo9 g = yn9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (go9Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", go9Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", go9Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", go9Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", go9Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", go9Var.d + ""));
                }
                g.a("perf_record_arperf", str, ho9Var.a, ho9Var.b, ho9Var.c, ho9Var.d, ho9Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (vr9.a) {
                vr9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            bo9 g = yn9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", tr9.a(yn9.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(tr9.b(yn9.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
