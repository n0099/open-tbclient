package com.baidu.tbadk.pluginArch;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class o {
    public static String a;

    public static String a() {
        return TbadkApplication.m252getInst().isMainProcess(false) ? TbadkApplication.getCurrentAccount() : a;
    }

    public static boolean b() {
        return !TextUtils.isEmpty(m.a) && m.a.equals("arm");
    }

    public static String c() {
        String substring = System.getProperty("os.arch", "arm").substring(0, 3);
        if (substring.equals("i68")) {
            return "x86";
        }
        return substring;
    }
}
