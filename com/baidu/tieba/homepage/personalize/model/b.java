package com.baidu.tieba.homepage.personalize.model;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes6.dex */
public class b {
    public static void a(DataRes.Builder builder, List<h> list) {
        cp(list);
        b(builder, list);
    }

    public static void cp(List<h> list) {
        if (list != null) {
            int H = v.H(list);
            for (int i = 0; i < H; i++) {
                h hVar = (h) v.d(list, i);
                if (hVar instanceof p) {
                    ((p) hVar).fB(true);
                }
                h hVar2 = (h) v.d(list, i + 1);
                if ((hVar instanceof p) && (hVar2 instanceof p)) {
                    p pVar = (p) hVar;
                    p pVar2 = (p) hVar2;
                    if (pVar.arg()) {
                        pVar2.fB(false);
                        if (pVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            pVar.fC(false);
                        }
                    }
                }
                if (hVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    if ((hVar2 instanceof p) || (hVar2 instanceof com.baidu.tieba.card.data.h)) {
                        ((com.baidu.tieba.homepage.personalize.b.c) hVar).fC(true);
                    } else {
                        ((com.baidu.tieba.homepage.personalize.b.c) hVar).fC(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<h> list) {
        com.baidu.tieba.card.data.c cVar;
        bb aaq;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int H = v.H(list);
            for (int i = 0; i < H; i++) {
                h hVar = (h) v.d(list, i);
                if ((hVar instanceof com.baidu.tieba.card.data.c) && (aaq = (cVar = (com.baidu.tieba.card.data.c) hVar).aaq()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.g.b.d(aaq.getTid(), 0L))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.mZ(threadPersonalized.abtest_tag);
                    aaq.mRecomAbTag = threadPersonalized.abtest_tag;
                    aaq.mRecomSource = threadPersonalized.source;
                    aaq.mRecomWeight = threadPersonalized.weight;
                    if (aaq.Al() != null) {
                        cVar.c(aaq.Al().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason);
                        }
                        cVar.asF = sparseArray;
                        cVar.setExtra(threadPersonalized.extra);
                    }
                }
            }
        }
    }
}
