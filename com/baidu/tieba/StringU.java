package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.h;
/* loaded from: classes.dex */
public class StringU {
    private static boolean eKK;

    private static native String toUpper(String str);

    static {
        try {
            eKK = h.mn().loadLibrary("stringu", 2);
            if (eKK) {
                D("stringu_so_load_success", null);
            } else {
                D("stringu_so_load_retry_fail", "retry to load so failed at 2 times");
            }
        } catch (Exception e) {
            D("stringu_so_load_fail", e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String zk(String str) {
        String str2;
        String str3 = "";
        if (eKK && !TextUtils.isEmpty(str)) {
            try {
                str3 = toUpper(str);
                if (TextUtils.isEmpty(str3)) {
                    D("stringu_m_result_null", null);
                }
                str2 = str3;
            } catch (Exception e) {
                D("stringu_m_call_fail", e.getMessage());
            }
            return str2 != null ? "" : str2;
        }
        str2 = str3;
        if (str2 != null) {
        }
    }

    private static void D(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            BdStatisticsManager.getInstance().eventStat(null, str, null, 1, new Object[0]);
        } else {
            BdStatisticsManager.getInstance().eventStat(null, str, null, 1, "err_msg", str2);
        }
    }
}
