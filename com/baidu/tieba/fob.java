package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class fob {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, job jobVar, iob iobVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, jobVar, iobVar) == null) {
            if (xrb.a) {
                xrb.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + iobVar.toString());
            }
            dob h = aob.d().h();
            if (h != null) {
                ArrayList arrayList = null;
                if (iobVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", iobVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", iobVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", iobVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", iobVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", iobVar.d + ""));
                }
                h.a("perf_record_arperf", str, jobVar.a, jobVar.b, jobVar.c, jobVar.d, jobVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (xrb.a) {
                xrb.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            dob h = aob.d().h();
            if (h != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", vrb.a(aob.d().b())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(vrb.b(aob.d().b()))));
                }
                h.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
