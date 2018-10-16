package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class StringU {
    private static String bui = "stringu";
    private static boolean buj;

    private static native String toUpper(String str);

    static {
        try {
            buj = com.baidu.adp.lib.util.h.kK().n(bui, 2);
            o(StringU.class.getName(), "so_loaded_success", null);
        } catch (Exception e) {
            o(StringU.class.getName(), "so_loaded_fail", e.getMessage());
        }
    }

    public static String iO(String str) {
        String str2 = "";
        if (buj && !TextUtils.isEmpty(str)) {
            try {
                str2 = toUpper(str);
            } catch (Exception e) {
                try {
                    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    if (stackTrace != null && stackTrace.length >= 4) {
                        o(stackTrace[3].toString(), "toUpper_fail", e.getMessage());
                    } else {
                        o(StringU.class.getName(), "toUpper_fail", e.getMessage());
                    }
                } catch (Exception e2) {
                    o(StringU.class.getName(), "toUpper_fail", e.getMessage());
                }
            }
        }
        return str2 == null ? "" : str2;
    }

    private static void o(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("caller");
        arrayList.add(str);
        arrayList.add("msg");
        arrayList.add(str2);
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add("error_msg");
            arrayList.add(str3);
        }
        BdStatisticsManager.getInstance().eventStat(null, "stringu_stat", null, 1, arrayList.toArray());
    }
}
