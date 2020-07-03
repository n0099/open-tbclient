package com.baidu.tieba.homepage.personalize.model;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.data.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes9.dex */
public class b {
    public static void a(DataRes.Builder builder, List<q> list) {
        da(list);
        b(builder, list);
    }

    public static void da(List<q> list) {
        if (list != null) {
            int count = w.getCount(list);
            for (int i = 0; i < count; i++) {
                q qVar = (q) w.getItem(list, i);
                if (qVar instanceof p) {
                    ((p) qVar).mf(true);
                }
                q qVar2 = (q) w.getItem(list, i + 1);
                if ((qVar instanceof p) && (qVar2 instanceof p)) {
                    p pVar = (p) qVar;
                    p pVar2 = (p) qVar2;
                    if (pVar.bOS()) {
                        pVar2.mf(false);
                        if (pVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            pVar.mg(false);
                        }
                    }
                }
                if (qVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    ((com.baidu.tieba.homepage.personalize.b.c) qVar).mg(false);
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<q> list) {
        com.baidu.tieba.card.data.c cVar;
        bu aPS;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int count = w.getCount(list);
            for (int i = 0; i < count; i++) {
                q qVar = (q) w.getItem(list, i);
                if ((qVar instanceof com.baidu.tieba.card.data.c) && (aPS = (cVar = (com.baidu.tieba.card.data.c) qVar).aPS()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.f.b.toLong(aPS.getTid(), 0L))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.DQ(threadPersonalized.abtest_tag);
                    aPS.mRecomAbTag = threadPersonalized.abtest_tag;
                    aPS.mRecomSource = threadPersonalized.source;
                    aPS.mRecomWeight = threadPersonalized.weight;
                    if (aPS.aSH() != null) {
                        cVar.k(aPS.aSH().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        cVar.feedBackReasonMap = sparseArray;
                        cVar.setExtra(threadPersonalized.extra);
                    }
                }
            }
        }
    }
}
