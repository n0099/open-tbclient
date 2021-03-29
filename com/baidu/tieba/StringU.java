package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.searchbox.pms.constants.PmsConstant;
import d.b.b.e.p.h;
/* loaded from: classes4.dex */
public class StringU {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f14449a;

    static {
        try {
            boolean j = h.f().j("stringu", 2);
            f14449a = j;
            if (j) {
                a("stringu_so_load_success", null);
            } else {
                a("stringu_so_load_retry_fail", "retry to load so failed at 2 times");
            }
        } catch (Exception e2) {
            a("stringu_so_load_fail", e2.getMessage());
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            BdStatisticsManager.getInstance().eventStat(null, str, null, 1, new Object[0]);
        } else {
            BdStatisticsManager.getInstance().eventStat(null, str, null, 1, PmsConstant.Statistic.STATISTIC_ERRMSG, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) {
        String str2;
        if (!f14449a || TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            try {
                str2 = toUpper(str);
            } catch (Exception e2) {
                e = e2;
                str2 = "";
            }
            try {
                if (TextUtils.isEmpty(str2)) {
                    a("stringu_m_result_null", null);
                }
            } catch (Exception e3) {
                e = e3;
                a("stringu_m_call_fail", e.getMessage());
                if (str2 != null) {
                }
            }
        }
        return str2 != null ? "" : str2;
    }

    public static native String toUpper(String str);
}
