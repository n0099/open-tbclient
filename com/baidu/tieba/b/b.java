package com.baidu.tieba.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private static HashMap<String, e> anc;

    static {
        MessageManager.getInstance().registerListener(new c(2001011));
        anc = new HashMap<>();
    }

    public static void c(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!anc.containsKey(str3)) {
            anc.put(str3, new e(str, str2, z));
        }
    }

    public static e d(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!anc.containsKey(str3)) {
            anc.put(str3, new e(str, str2, z));
        }
        return anc.get(str3);
    }

    public static void AJ() {
    }

    public static void el(int i) {
        for (String str : anc.keySet()) {
            a(anc.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.anh;
        d dVar2 = eVar.ani;
        d dVar3 = eVar.anj;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            q qVar = new q("dbg");
            qVar.n("act", eVar.type);
            qVar.n("httpTimeCost", String.valueOf(dVar.and));
            qVar.n("httpNum", String.valueOf(dVar.num));
            qVar.n("httpFailnum", String.valueOf(dVar.ane));
            qVar.n("httpSize", String.valueOf(dVar.size));
            qVar.n("socketTimeCost", String.valueOf(dVar2.and));
            qVar.n("socketNum", String.valueOf(dVar2.num));
            qVar.n("socketFailnum", String.valueOf(dVar2.ane));
            qVar.n("socketSize", String.valueOf(dVar2.size));
            qVar.n("abortTimeCost", String.valueOf(dVar3.and));
            qVar.n("abortNum", String.valueOf(dVar3.num));
            qVar.n("netType", eVar.ang);
            qVar.n("isJson", eVar.anf ? "1" : "0");
            f.er().a("frs", qVar);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
