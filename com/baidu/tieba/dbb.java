package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class dbb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, hbb hbbVar, gbb gbbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, hbbVar, gbbVar) == null) {
            if (veb.a) {
                veb.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + gbbVar.toString());
            }
            bbb h = yab.d().h();
            if (h != null) {
                ArrayList arrayList = null;
                if (gbbVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", gbbVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", gbbVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", gbbVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", gbbVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", gbbVar.d + ""));
                }
                h.a("perf_record_arperf", str, hbbVar.a, hbbVar.b, hbbVar.c, hbbVar.d, hbbVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (veb.a) {
                veb.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            bbb h = yab.d().h();
            if (h != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", teb.a(yab.d().b())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(teb.b(yab.d().b()))));
                }
                h.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
