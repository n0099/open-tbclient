package com.baidu.tieba.homepage.personalize.model;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes2.dex */
public class b {
    public static void a(DataRes.Builder builder, List<n> list) {
        ee(list);
        b(builder, list);
    }

    public static void ee(List<n> list) {
        if (list != null) {
            int count = y.getCount(list);
            for (int i = 0; i < count; i++) {
                n nVar = (n) y.getItem(list, i);
                if (nVar instanceof p) {
                    ((p) nVar).pE(true);
                }
                n nVar2 = (n) y.getItem(list, i + 1);
                if ((nVar instanceof p) && (nVar2 instanceof p)) {
                    p pVar = (p) nVar;
                    p pVar2 = (p) nVar2;
                    if (pVar.cte()) {
                        pVar2.pE(false);
                        if (pVar2 instanceof com.baidu.tieba.homepage.personalize.readProgressBar.b) {
                            pVar.pF(false);
                        }
                    }
                }
                if (nVar instanceof com.baidu.tieba.homepage.personalize.readProgressBar.b) {
                    ((com.baidu.tieba.homepage.personalize.readProgressBar.b) nVar).pF(false);
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<n> list) {
        com.baidu.tieba.card.data.b bVar;
        cb blp;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int count = y.getCount(list);
            for (int i = 0; i < count; i++) {
                n nVar = (n) y.getItem(list, i);
                if ((nVar instanceof com.baidu.tieba.card.data.b) && (blp = (bVar = (com.baidu.tieba.card.data.b) nVar).blp()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.f.b.toLong(blp.getTid(), 0L))) != null) {
                    bVar.setSource(threadPersonalized.source);
                    bVar.setWeight(threadPersonalized.weight);
                    bVar.IZ(threadPersonalized.abtest_tag);
                    blp.mRecomAbTag = threadPersonalized.abtest_tag;
                    blp.mRecomSource = threadPersonalized.source;
                    blp.mRecomWeight = threadPersonalized.weight;
                    if (blp.boj() != null) {
                        bVar.p(blp.boj().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        bVar.feedBackReasonMap = sparseArray;
                        bVar.setExtra(threadPersonalized.extra);
                    }
                }
            }
        }
    }
}
