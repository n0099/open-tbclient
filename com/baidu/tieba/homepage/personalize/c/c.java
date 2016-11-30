package com.baidu.tieba.homepage.personalize.c;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.s;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes.dex */
public class c {
    public static void a(DataRes.Builder builder, List<v> list) {
        bA(list);
        b(builder, list);
    }

    public static void bA(List<v> list) {
        if (list != null) {
            int s = x.s(list);
            for (int i = 0; i < s; i++) {
                v vVar = (v) x.c(list, i);
                if (vVar instanceof s) {
                    ((s) vVar).cy(true);
                }
                v vVar2 = (v) x.c(list, i + 1);
                if ((vVar instanceof s) && (vVar2 instanceof s)) {
                    s sVar = (s) vVar;
                    s sVar2 = (s) vVar2;
                    if (sVar.Ps()) {
                        sVar2.cy(false);
                        if (sVar2 instanceof com.baidu.tieba.homepage.personalize.d.e) {
                            sVar.cz(false);
                        }
                    }
                }
                if (vVar instanceof com.baidu.tieba.homepage.personalize.d.e) {
                    if ((vVar2 instanceof s) || (vVar2 instanceof com.baidu.tieba.card.data.k)) {
                        ((com.baidu.tieba.homepage.personalize.d.e) vVar).cz(true);
                    } else {
                        ((com.baidu.tieba.homepage.personalize.d.e) vVar).cz(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<v> list) {
        com.baidu.tieba.card.data.c cVar;
        bk Jz;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    hashMap.put(threadPersonalized2.tid, threadPersonalized2);
                }
            }
            int s = x.s(list);
            for (int i = 0; i < s; i++) {
                v vVar = (v) x.c(list, i);
                if ((vVar instanceof com.baidu.tieba.card.data.c) && (Jz = (cVar = (com.baidu.tieba.card.data.c) vVar).Jz()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.h.b.c(Jz.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.hV(threadPersonalized.abtest_tag);
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason);
                        }
                        cVar.beP = sparseArray;
                    }
                }
            }
        }
    }
}
