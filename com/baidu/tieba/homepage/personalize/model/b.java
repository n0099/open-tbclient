package com.baidu.tieba.homepage.personalize.model;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes9.dex */
public class b {
    public static void a(DataRes.Builder builder, List<o> list) {
        cO(list);
        b(builder, list);
    }

    public static void cO(List<o> list) {
        if (list != null) {
            int count = v.getCount(list);
            for (int i = 0; i < count; i++) {
                o oVar = (o) v.getItem(list, i);
                if (oVar instanceof p) {
                    ((p) oVar).lW(true);
                }
                o oVar2 = (o) v.getItem(list, i + 1);
                if ((oVar instanceof p) && (oVar2 instanceof p)) {
                    p pVar = (p) oVar;
                    p pVar2 = (p) oVar2;
                    if (pVar.bLI()) {
                        pVar2.lW(false);
                        if (pVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            pVar.lX(false);
                        }
                    }
                }
                if (oVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    ((com.baidu.tieba.homepage.personalize.b.c) oVar).lX(false);
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<o> list) {
        com.baidu.tieba.card.data.c cVar;
        bk aOi;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int count = v.getCount(list);
            for (int i = 0; i < count; i++) {
                o oVar = (o) v.getItem(list, i);
                if ((oVar instanceof com.baidu.tieba.card.data.c) && (aOi = (cVar = (com.baidu.tieba.card.data.c) oVar).aOi()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.f.b.toLong(aOi.getTid(), 0L))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.Dp(threadPersonalized.abtest_tag);
                    aOi.mRecomAbTag = threadPersonalized.abtest_tag;
                    aOi.mRecomSource = threadPersonalized.source;
                    aOi.mRecomWeight = threadPersonalized.weight;
                    if (aOi.aQQ() != null) {
                        cVar.k(aOi.aQQ().is_vertical);
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
