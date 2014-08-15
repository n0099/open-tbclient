package com.baidu.tieba.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private static HashMap<String, e> a;

    static {
        MessageManager.getInstance().registerListener(new c(2001011));
        a = new HashMap<>();
    }

    public static void a(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!a.containsKey(str3)) {
            a.put(str3, new e(str, str2, z));
        }
    }

    public static e b(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!a.containsKey(str3)) {
            a.put(str3, new e(str, str2, z));
        }
        return a.get(str3);
    }

    public static void a(int i) {
        for (String str : a.keySet()) {
            a(a.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.d;
        d dVar2 = eVar.e;
        d dVar3 = eVar.f;
        if (dVar.b + dVar2.b + dVar3.b >= i) {
            q qVar = new q("dbg");
            qVar.a("act", eVar.c);
            qVar.a("httpTimeCost", String.valueOf(dVar.a));
            qVar.a("httpNum", String.valueOf(dVar.b));
            qVar.a("httpFailnum", String.valueOf(dVar.c));
            qVar.a("httpSize", String.valueOf(dVar.d));
            qVar.a("socketTimeCost", String.valueOf(dVar2.a));
            qVar.a("socketNum", String.valueOf(dVar2.b));
            qVar.a("socketFailnum", String.valueOf(dVar2.c));
            qVar.a("socketSize", String.valueOf(dVar2.d));
            qVar.a("abortTimeCost", String.valueOf(dVar3.a));
            qVar.a("abortNum", String.valueOf(dVar3.b));
            qVar.a("netType", eVar.b);
            qVar.a("isJson", eVar.a ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
            f.c().a("frs", qVar);
            dVar.a();
            dVar2.a();
            dVar3.a();
        }
    }
}
