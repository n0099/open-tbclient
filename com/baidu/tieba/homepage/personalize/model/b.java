package com.baidu.tieba.homepage.personalize.model;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.data.q;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes2.dex */
public class b {
    public static void a(DataRes.Builder builder, List<i> list) {
        bO(list);
        b(builder, list);
    }

    public static void bO(List<i> list) {
        if (list != null) {
            int D = v.D(list);
            for (int i = 0; i < D; i++) {
                i iVar = (i) v.f(list, i);
                if (iVar instanceof q) {
                    ((q) iVar).eQ(true);
                }
                i iVar2 = (i) v.f(list, i + 1);
                if ((iVar instanceof q) && (iVar2 instanceof q)) {
                    q qVar = (q) iVar;
                    q qVar2 = (q) iVar2;
                    if (qVar.alG()) {
                        qVar2.eQ(false);
                        if (qVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            qVar.eR(false);
                        }
                    }
                }
                if (iVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    if ((iVar2 instanceof q) || (iVar2 instanceof h)) {
                        ((com.baidu.tieba.homepage.personalize.b.c) iVar).eR(true);
                    } else {
                        ((com.baidu.tieba.homepage.personalize.b.c) iVar).eR(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<i> list) {
        com.baidu.tieba.card.data.c cVar;
        bd WE;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    hashMap.put(threadPersonalized2.tid, threadPersonalized2);
                }
            }
            int D = v.D(list);
            for (int i = 0; i < D; i++) {
                i iVar = (i) v.f(list, i);
                if ((iVar instanceof com.baidu.tieba.card.data.c) && (WE = (cVar = (com.baidu.tieba.card.data.c) iVar).WE()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.g.b.c(WE.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.kv(threadPersonalized.abtest_tag);
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason);
                        }
                        cVar.aNr = sparseArray;
                        cVar.setExtra(threadPersonalized.extra);
                    }
                }
            }
        }
    }
}
