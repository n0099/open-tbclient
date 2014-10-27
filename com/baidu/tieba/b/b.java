package com.baidu.tieba.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private static HashMap<String, e> amT;

    static {
        MessageManager.getInstance().registerListener(new c(2001011));
        amT = new HashMap<>();
    }

    public static void c(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!amT.containsKey(str3)) {
            amT.put(str3, new e(str, str2, z));
        }
    }

    public static e d(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!amT.containsKey(str3)) {
            amT.put(str3, new e(str, str2, z));
        }
        return amT.get(str3);
    }

    public static void AH() {
    }

    public static void el(int i) {
        for (String str : amT.keySet()) {
            a(amT.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.amY;
        d dVar2 = eVar.amZ;
        d dVar3 = eVar.ana;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            q qVar = new q("dbg");
            qVar.n("act", eVar.type);
            qVar.n("httpTimeCost", String.valueOf(dVar.amU));
            qVar.n("httpNum", String.valueOf(dVar.num));
            qVar.n("httpFailnum", String.valueOf(dVar.amV));
            qVar.n("httpSize", String.valueOf(dVar.size));
            qVar.n("socketTimeCost", String.valueOf(dVar2.amU));
            qVar.n("socketNum", String.valueOf(dVar2.num));
            qVar.n("socketFailnum", String.valueOf(dVar2.amV));
            qVar.n("socketSize", String.valueOf(dVar2.size));
            qVar.n("abortTimeCost", String.valueOf(dVar3.amU));
            qVar.n("abortNum", String.valueOf(dVar3.num));
            qVar.n("netType", eVar.amX);
            qVar.n("isJson", eVar.amW ? "1" : "0");
            f.er().a("frs", qVar);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
