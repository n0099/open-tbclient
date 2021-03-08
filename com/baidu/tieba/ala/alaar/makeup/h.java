package com.baidu.tieba.ala.alaar.makeup;

import android.util.Log;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class h {
    private static Boolean btf = false;

    public static void d(String str, String str2) {
        String str3;
        if (isDebug()) {
            if (str == null) {
                str3 = "L_MUP_";
            } else {
                str3 = "L_MUP_" + str;
            }
            if (str2.length() > 4000) {
                for (int i = 0; i < str2.length(); i += 4000) {
                    if (i + 4000 < str2.length()) {
                        Log.d(str3, str2.substring(i, i + 4000));
                    } else {
                        Log.d(str3, str2.substring(i, str2.length()));
                    }
                }
                return;
            }
            Log.i(str3, str2);
        }
    }

    public static void e(String str, String str2) {
        String str3;
        if (isDebug()) {
            if (str == null) {
                str3 = "L_MUP_";
            } else {
                str3 = "L_MUP_" + str;
            }
            if (str2.length() > 4000) {
                for (int i = 0; i < str2.length(); i += 4000) {
                    if (i + 4000 < str2.length()) {
                        Log.e(str3, str2.substring(i, i + 4000));
                    } else {
                        Log.e(str3, str2.substring(i, str2.length()));
                    }
                }
                return;
            }
            Log.i(str3, str2);
        }
    }

    public static boolean isDebug() {
        if (btf != null) {
            return btf.booleanValue();
        }
        btf = false;
        HashMap hashMap = new HashMap();
        hashMap.put("isDebugBuildType", false);
        Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
        if (process != null && process.containsKey("isDebugBuildType")) {
            btf = Boolean.valueOf(((Boolean) process.get("isDebugBuildType")).booleanValue());
        }
        return btf.booleanValue();
    }
}
