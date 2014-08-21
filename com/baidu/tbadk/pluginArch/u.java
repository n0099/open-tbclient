package com.baidu.tbadk.pluginArch;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class u {
    private static HashMap<String, Integer> a = new HashMap<>();

    public static void a(String str) {
        if (str != null) {
            Integer num = a.get(str);
            if (num == null) {
                num = 0;
            }
            a.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public static void a(String str, String str2, String str3) {
        com.baidu.adp.lib.stats.q b = b();
        if (str != null) {
            b.a("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            b.a("reason", str2);
        }
        if (str3 != null) {
            b.a("pname", str3);
        }
        b(b);
        a(b);
        com.baidu.adp.lib.stats.f.c().a("pluginarch", b);
    }

    public static void a() {
        com.baidu.adp.lib.stats.q b = b();
        b(b);
        a(b);
        com.baidu.adp.lib.stats.f.c().a("pluginarch", b);
    }

    private static void a(com.baidu.adp.lib.stats.q qVar) {
        if (qVar != null && n.a != null) {
            qVar.a("arch", n.a);
        }
    }

    private static void b(com.baidu.adp.lib.stats.q qVar) {
        if (qVar != null) {
            for (Map.Entry<String, Integer> entry : a.entrySet()) {
                qVar.a(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            a.clear();
        }
    }

    public static com.baidu.adp.lib.stats.q b() {
        return com.baidu.adp.lib.stats.f.c().a("dbg");
    }
}
