package com.baidu.tieba.homepage.personalize.model;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.data.r;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes.dex */
public class b {
    public static void a(DataRes.Builder builder, List<f> list) {
        bH(list);
        b(builder, list);
    }

    public static void bH(List<f> list) {
        if (list != null) {
            int v = v.v(list);
            for (int i = 0; i < v; i++) {
                f fVar = (f) v.c(list, i);
                if (fVar instanceof r) {
                    ((r) fVar).dV(true);
                }
                f fVar2 = (f) v.c(list, i + 1);
                if ((fVar instanceof r) && (fVar2 instanceof r)) {
                    r rVar = (r) fVar;
                    r rVar2 = (r) fVar2;
                    if (rVar.aca()) {
                        rVar2.dV(false);
                        if (rVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            rVar.dW(false);
                        }
                    }
                }
                if (fVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    if ((fVar2 instanceof r) || (fVar2 instanceof h)) {
                        ((com.baidu.tieba.homepage.personalize.b.c) fVar).dW(true);
                    } else {
                        ((com.baidu.tieba.homepage.personalize.b.c) fVar).dW(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<f> list) {
        com.baidu.tieba.card.data.c cVar;
        bd Ox;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    hashMap.put(threadPersonalized2.tid, threadPersonalized2);
                }
            }
            int v = v.v(list);
            for (int i = 0; i < v; i++) {
                f fVar = (f) v.c(list, i);
                if ((fVar instanceof com.baidu.tieba.card.data.c) && (Ox = (cVar = (com.baidu.tieba.card.data.c) fVar).Ox()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.g.b.c(Ox.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.jU(threadPersonalized.abtest_tag);
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason);
                        }
                        cVar.XE = sparseArray;
                        cVar.setExtra(threadPersonalized.extra);
                    }
                }
            }
        }
    }
}
