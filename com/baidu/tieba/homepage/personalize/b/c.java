package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.s;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes.dex */
public class c {
    public static void a(DataRes.Builder builder, List<v> list) {
        br(list);
        b(builder, list);
    }

    private static void br(List<v> list) {
        if (list != null) {
            int s = y.s(list);
            for (int i = 0; i < s; i++) {
                v vVar = (v) y.c(list, i);
                if (vVar instanceof s) {
                    ((s) vVar).ck(true);
                }
            }
            for (int i2 = 0; i2 < s; i2++) {
                v vVar2 = (v) y.c(list, i2);
                v vVar3 = (v) y.c(list, i2 + 1);
                if ((vVar2 instanceof s) && (vVar3 instanceof s)) {
                    s sVar = (s) vVar3;
                    if (((s) vVar2).Lm()) {
                        sVar.ck(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<v> list) {
        com.baidu.tieba.card.a.c cVar;
        az Ix;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    hashMap.put(threadPersonalized2.tid, threadPersonalized2);
                }
            }
            int s = y.s(list);
            for (int i = 0; i < s; i++) {
                v vVar = (v) y.c(list, i);
                if ((vVar instanceof com.baidu.tieba.card.a.c) && (Ix = (cVar = (com.baidu.tieba.card.a.c) vVar).Ix()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.h.b.c(Ix.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.hf(threadPersonalized.abtest_tag);
                }
            }
        }
    }
}
