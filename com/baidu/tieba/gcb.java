package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class gcb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, kcb kcbVar, jcb jcbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, kcbVar, jcbVar) == null) {
            if (yfb.a) {
                yfb.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + jcbVar.toString());
            }
            ecb g = bcb.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (jcbVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", jcbVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", jcbVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", jcbVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", jcbVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", jcbVar.d + ""));
                }
                g.a("perf_record_arperf", str, kcbVar.a, kcbVar.b, kcbVar.c, kcbVar.d, kcbVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (yfb.a) {
                yfb.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            ecb g = bcb.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", wfb.a(bcb.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(wfb.b(bcb.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
