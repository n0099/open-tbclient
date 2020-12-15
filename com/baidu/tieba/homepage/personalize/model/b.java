package com.baidu.tieba.homepage.personalize.model;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes22.dex */
public class b {
    public static void a(DataRes.Builder builder, List<q> list) {
        dZ(list);
        b(builder, list);
    }

    public static void dZ(List<q> list) {
        if (list != null) {
            int count = y.getCount(list);
            for (int i = 0; i < count; i++) {
                q qVar = (q) y.getItem(list, i);
                if (qVar instanceof p) {
                    ((p) qVar).pa(true);
                }
                q qVar2 = (q) y.getItem(list, i + 1);
                if ((qVar instanceof p) && (qVar2 instanceof p)) {
                    p pVar = (p) qVar;
                    p pVar2 = (p) qVar2;
                    if (pVar.csD()) {
                        pVar2.pa(false);
                        if (pVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            pVar.pb(false);
                        }
                    }
                }
                if (qVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    ((com.baidu.tieba.homepage.personalize.b.c) qVar).pb(false);
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<q> list) {
        com.baidu.tieba.card.data.b bVar;
        by bmn;
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
                q qVar = (q) y.getItem(list, i);
                if ((qVar instanceof com.baidu.tieba.card.data.b) && (bmn = (bVar = (com.baidu.tieba.card.data.b) qVar).bmn()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.f.b.toLong(bmn.getTid(), 0L))) != null) {
                    bVar.setSource(threadPersonalized.source);
                    bVar.setWeight(threadPersonalized.weight);
                    bVar.Js(threadPersonalized.abtest_tag);
                    bmn.mRecomAbTag = threadPersonalized.abtest_tag;
                    bmn.mRecomSource = threadPersonalized.source;
                    bmn.mRecomWeight = threadPersonalized.weight;
                    if (bmn.bph() != null) {
                        bVar.n(bmn.bph().is_vertical);
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
