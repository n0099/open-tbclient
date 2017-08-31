package com.baidu.tieba.homepage.personalize.model;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.bj;
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
        bE(list);
        b(builder, list);
    }

    public static void bE(List<f> list) {
        if (list != null) {
            int u = v.u(list);
            for (int i = 0; i < u; i++) {
                f fVar = (f) v.c(list, i);
                if (fVar instanceof r) {
                    ((r) fVar).dJ(true);
                }
                f fVar2 = (f) v.c(list, i + 1);
                if ((fVar instanceof r) && (fVar2 instanceof r)) {
                    r rVar = (r) fVar;
                    r rVar2 = (r) fVar2;
                    if (rVar.Yg()) {
                        rVar2.dJ(false);
                        if (rVar2 instanceof com.baidu.tieba.homepage.personalize.c.c) {
                            rVar.dK(false);
                        }
                    }
                }
                if (fVar instanceof com.baidu.tieba.homepage.personalize.c.c) {
                    if ((fVar2 instanceof r) || (fVar2 instanceof h)) {
                        ((com.baidu.tieba.homepage.personalize.c.c) fVar).dK(true);
                    } else {
                        ((com.baidu.tieba.homepage.personalize.c.c) fVar).dK(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<f> list) {
        com.baidu.tieba.card.data.c cVar;
        bj MR;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    hashMap.put(threadPersonalized2.tid, threadPersonalized2);
                }
            }
            int u = v.u(list);
            for (int i = 0; i < u; i++) {
                f fVar = (f) v.c(list, i);
                if ((fVar instanceof com.baidu.tieba.card.data.c) && (MR = (cVar = (com.baidu.tieba.card.data.c) fVar).MR()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.g.b.c(MR.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.jw(threadPersonalized.abtest_tag);
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason);
                        }
                        cVar.Xf = sparseArray;
                    }
                }
            }
        }
    }
}
