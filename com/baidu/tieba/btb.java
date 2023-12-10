package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class btb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, ftb ftbVar, etb etbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, ftbVar, etbVar) == null) {
            if (twb.a) {
                twb.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + etbVar.toString());
            }
            zsb h = wsb.d().h();
            if (h != null) {
                ArrayList arrayList = null;
                if (etbVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", etbVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", etbVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", etbVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", etbVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", etbVar.d + ""));
                }
                h.a("perf_record_arperf", str, ftbVar.a, ftbVar.b, ftbVar.c, ftbVar.d, ftbVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (twb.a) {
                twb.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            zsb h = wsb.d().h();
            if (h != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", rwb.a(wsb.d().b())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(rwb.b(wsb.d().b()))));
                }
                h.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
