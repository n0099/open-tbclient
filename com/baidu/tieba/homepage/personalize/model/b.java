package com.baidu.tieba.homepage.personalize.model;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.data.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes2.dex */
public class b {
    public static void a(DataRes.Builder builder, List<h> list) {
        bU(list);
        b(builder, list);
    }

    public static void bU(List<h> list) {
        if (list != null) {
            int z = w.z(list);
            for (int i = 0; i < z; i++) {
                h hVar = (h) w.d(list, i);
                if (hVar instanceof p) {
                    ((p) hVar).eA(true);
                }
                h hVar2 = (h) w.d(list, i + 1);
                if ((hVar instanceof p) && (hVar2 instanceof p)) {
                    p pVar = (p) hVar;
                    p pVar2 = (p) hVar2;
                    if (pVar.aiQ()) {
                        pVar2.eA(false);
                        if (pVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            pVar.eB(false);
                        }
                    }
                }
                if (hVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    if ((hVar2 instanceof p) || (hVar2 instanceof com.baidu.tieba.card.data.h)) {
                        ((com.baidu.tieba.homepage.personalize.b.c) hVar).eB(true);
                    } else {
                        ((com.baidu.tieba.homepage.personalize.b.c) hVar).eB(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<h> list) {
        com.baidu.tieba.card.data.c cVar;
        bc SV;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int z = w.z(list);
            for (int i = 0; i < z; i++) {
                h hVar = (h) w.d(list, i);
                if ((hVar instanceof com.baidu.tieba.card.data.c) && (SV = (cVar = (com.baidu.tieba.card.data.c) hVar).SV()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.g.b.c(SV.getTid(), 0L))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.lb(threadPersonalized.abtest_tag);
                    if (SV.vN() != null) {
                        cVar.c(SV.vN().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason);
                        }
                        cVar.agZ = sparseArray;
                        cVar.setExtra(threadPersonalized.extra);
                    }
                }
            }
        }
    }
}
