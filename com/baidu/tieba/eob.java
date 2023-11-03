package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class eob {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, iob iobVar, hob hobVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, iobVar, hobVar) == null) {
            if (wrb.a) {
                wrb.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + hobVar.toString());
            }
            cob h = znb.d().h();
            if (h != null) {
                ArrayList arrayList = null;
                if (hobVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", hobVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", hobVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", hobVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", hobVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", hobVar.d + ""));
                }
                h.a("perf_record_arperf", str, iobVar.a, iobVar.b, iobVar.c, iobVar.d, iobVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (wrb.a) {
                wrb.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            cob h = znb.d().h();
            if (h != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", urb.a(znb.d().b())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(urb.b(znb.d().b()))));
                }
                h.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
