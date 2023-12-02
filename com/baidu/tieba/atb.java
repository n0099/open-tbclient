package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class atb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, etb etbVar, dtb dtbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, etbVar, dtbVar) == null) {
            if (swb.a) {
                swb.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + dtbVar.toString());
            }
            ysb h = vsb.d().h();
            if (h != null) {
                ArrayList arrayList = null;
                if (dtbVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", dtbVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", dtbVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", dtbVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", dtbVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", dtbVar.d + ""));
                }
                h.a("perf_record_arperf", str, etbVar.a, etbVar.b, etbVar.c, etbVar.d, etbVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (swb.a) {
                swb.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            ysb h = vsb.d().h();
            if (h != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", qwb.a(vsb.d().b())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(qwb.b(vsb.d().b()))));
                }
                h.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
