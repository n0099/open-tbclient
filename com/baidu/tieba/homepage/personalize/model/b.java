package com.baidu.tieba.homepage.personalize.model;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes2.dex */
public class b {
    public static void a(DataRes.Builder builder, List<n> list) {
        eg(list);
        b(builder, list);
    }

    public static void eg(List<n> list) {
        if (list != null) {
            int count = x.getCount(list);
            for (int i = 0; i < count; i++) {
                n nVar = (n) x.getItem(list, i);
                if (nVar instanceof p) {
                    ((p) nVar).py(true);
                }
                n nVar2 = (n) x.getItem(list, i + 1);
                if ((nVar instanceof p) && (nVar2 instanceof p)) {
                    p pVar = (p) nVar;
                    p pVar2 = (p) nVar2;
                    if (pVar.cvx()) {
                        pVar2.py(false);
                        if (pVar2 instanceof com.baidu.tieba.homepage.personalize.readProgressBar.b) {
                            pVar.pz(false);
                        }
                    }
                }
                if (nVar instanceof com.baidu.tieba.homepage.personalize.readProgressBar.b) {
                    ((com.baidu.tieba.homepage.personalize.readProgressBar.b) nVar).pz(false);
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<n> list) {
        com.baidu.tieba.card.data.b bVar;
        bz boP;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int count = x.getCount(list);
            for (int i = 0; i < count; i++) {
                n nVar = (n) x.getItem(list, i);
                if ((nVar instanceof com.baidu.tieba.card.data.b) && (boP = (bVar = (com.baidu.tieba.card.data.b) nVar).boP()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.f.b.toLong(boP.getTid(), 0L))) != null) {
                    bVar.setSource(threadPersonalized.source);
                    bVar.setWeight(threadPersonalized.weight);
                    bVar.Jp(threadPersonalized.abtest_tag);
                    boP.mRecomAbTag = threadPersonalized.abtest_tag;
                    boP.mRecomSource = threadPersonalized.source;
                    boP.mRecomWeight = threadPersonalized.weight;
                    if (boP.brI() != null) {
                        bVar.p(boP.brI().is_vertical);
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
