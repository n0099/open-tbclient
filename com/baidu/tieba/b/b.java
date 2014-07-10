package com.baidu.tieba.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.stats.o;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private static HashMap<String, e> a;

    static {
        MessageManager.getInstance().registerListener(new c(2001011));
        a = new HashMap<>();
    }

    public static void a(String str) {
        if (!a.containsKey(str)) {
            a.put(str, new e(str));
        }
    }

    public static e b(String str) {
        if (!a.containsKey(str)) {
            a.put(str, new e(str));
        }
        return a.get(str);
    }

    public static void a(int i) {
        for (String str : a.keySet()) {
            a(a.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.b;
        d dVar2 = eVar.c;
        d dVar3 = eVar.d;
        if (dVar.b + dVar2.b + dVar3.b >= i) {
            o oVar = new o("dbg");
            oVar.a("act", eVar.a);
            oVar.a("httpTimeCost", String.valueOf(dVar.a));
            oVar.a("httpNum", String.valueOf(dVar.b));
            oVar.a("httpFailnum", String.valueOf(dVar.c));
            oVar.a("httpSize", String.valueOf(dVar.d));
            oVar.a("socketTimeCost", String.valueOf(dVar2.a));
            oVar.a("socketNum", String.valueOf(dVar2.b));
            oVar.a("socketFailnum", String.valueOf(dVar2.c));
            oVar.a("socketSize", String.valueOf(dVar2.d));
            oVar.a("abortTimeCost", String.valueOf(dVar3.a));
            oVar.a("abortNum", String.valueOf(dVar3.b));
            com.baidu.adp.lib.stats.d.b().a("frs", oVar);
            dVar.a();
            dVar2.a();
            dVar3.a();
        }
    }
}
