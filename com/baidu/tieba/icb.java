package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class icb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, mcb mcbVar, lcb lcbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, mcbVar, lcbVar) == null) {
            if (agb.a) {
                agb.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + lcbVar.toString());
            }
            gcb g = dcb.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (lcbVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", lcbVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", lcbVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", lcbVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", lcbVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", lcbVar.d + ""));
                }
                g.a("perf_record_arperf", str, mcbVar.a, mcbVar.b, mcbVar.c, mcbVar.d, mcbVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (agb.a) {
                agb.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            gcb g = dcb.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", yfb.a(dcb.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(yfb.b(dcb.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
