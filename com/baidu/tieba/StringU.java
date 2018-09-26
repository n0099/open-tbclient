package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class StringU {
    private static String bpZ = "stringu";
    private static boolean bqa;

    private static native String toUpper(String str);

    static {
        try {
            bqa = com.baidu.adp.lib.util.h.kw().n(bpZ, 2);
            l(StringU.class.getName(), "so_loaded_success", null);
        } catch (Exception e) {
            l(StringU.class.getName(), "so_loaded_fail", e.getMessage());
        }
    }

    public static String iB(String str) {
        String str2 = "";
        if (bqa && !TextUtils.isEmpty(str)) {
            try {
                str2 = toUpper(str);
            } catch (Exception e) {
                try {
                    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    if (stackTrace != null && stackTrace.length >= 4) {
                        l(stackTrace[3].toString(), "toUpper_fail", e.getMessage());
                    } else {
                        l(StringU.class.getName(), "toUpper_fail", e.getMessage());
                    }
                } catch (Exception e2) {
                    l(StringU.class.getName(), "toUpper_fail", e.getMessage());
                }
            }
        }
        return str2 == null ? "" : str2;
    }

    private static void l(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("caller");
        arrayList.add(str);
        arrayList.add("msg");
        arrayList.add(str2);
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(PushConstants.EXTRA_ERROR_CODE);
            arrayList.add(str3);
        }
        BdStatisticsManager.getInstance().eventStat(null, "stringu_stat", null, 1, arrayList.toArray());
    }
}
