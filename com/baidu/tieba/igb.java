package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class igb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, mgb mgbVar, lgb lgbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, mgbVar, lgbVar) == null) {
            if (akb.a) {
                akb.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + lgbVar.toString());
            }
            ggb g = dgb.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (lgbVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", lgbVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", lgbVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", lgbVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", lgbVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", lgbVar.d + ""));
                }
                g.a("perf_record_arperf", str, mgbVar.a, mgbVar.b, mgbVar.c, mgbVar.d, mgbVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (akb.a) {
                akb.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            ggb g = dgb.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", yjb.a(dgb.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(yjb.b(dgb.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
