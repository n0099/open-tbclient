package com.baidu.tieba.homepage.personalize.model;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.t;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes.dex */
public class c {
    public static void a(DataRes.Builder builder, List<v> list) {
        be(list);
        b(builder, list);
    }

    public static void be(List<v> list) {
        if (list != null) {
            int p = x.p(list);
            for (int i = 0; i < p; i++) {
                v vVar = (v) x.c(list, i);
                if (vVar instanceof t) {
                    ((t) vVar).cR(true);
                }
                v vVar2 = (v) x.c(list, i + 1);
                if ((vVar instanceof t) && (vVar2 instanceof t)) {
                    t tVar = (t) vVar;
                    t tVar2 = (t) vVar2;
                    if (tVar.Ta()) {
                        tVar2.cR(false);
                        if (tVar2 instanceof com.baidu.tieba.homepage.personalize.c.e) {
                            tVar.cS(false);
                        }
                    }
                }
                if (vVar instanceof com.baidu.tieba.homepage.personalize.c.e) {
                    if ((vVar2 instanceof t) || (vVar2 instanceof com.baidu.tieba.card.data.j)) {
                        ((com.baidu.tieba.homepage.personalize.c.e) vVar).cS(true);
                    } else {
                        ((com.baidu.tieba.homepage.personalize.c.e) vVar).cS(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<v> list) {
        com.baidu.tieba.card.data.c cVar;
        bi Kn;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    hashMap.put(threadPersonalized2.tid, threadPersonalized2);
                }
            }
            int p = x.p(list);
            for (int i = 0; i < p; i++) {
                v vVar = (v) x.c(list, i);
                if ((vVar instanceof com.baidu.tieba.card.data.c) && (Kn = (cVar = (com.baidu.tieba.card.data.c) vVar).Kn()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.g.b.c(Kn.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.ic(threadPersonalized.abtest_tag);
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason);
                        }
                        cVar.WT = sparseArray;
                    }
                }
            }
        }
    }
}
