package com.baidu.tieba.homepage.personalize.model;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.data.r;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes2.dex */
public class b {
    public static void a(DataRes.Builder builder, List<i> list) {
        bM(list);
        b(builder, list);
    }

    public static void bM(List<i> list) {
        if (list != null) {
            int D = v.D(list);
            for (int i = 0; i < D; i++) {
                i iVar = (i) v.f(list, i);
                if (iVar instanceof r) {
                    ((r) iVar).eH(true);
                }
                i iVar2 = (i) v.f(list, i + 1);
                if ((iVar instanceof r) && (iVar2 instanceof r)) {
                    r rVar = (r) iVar;
                    r rVar2 = (r) iVar2;
                    if (rVar.akS()) {
                        rVar2.eH(false);
                        if (rVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            rVar.eI(false);
                        }
                    }
                }
                if (iVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    if ((iVar2 instanceof r) || (iVar2 instanceof h)) {
                        ((com.baidu.tieba.homepage.personalize.b.c) iVar).eI(true);
                    } else {
                        ((com.baidu.tieba.homepage.personalize.b.c) iVar).eI(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<i> list) {
        com.baidu.tieba.card.data.c cVar;
        bd VK;
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
                if ((iVar instanceof com.baidu.tieba.card.data.c) && (VK = (cVar = (com.baidu.tieba.card.data.c) iVar).VK()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.g.b.c(VK.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.kg(threadPersonalized.abtest_tag);
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason);
                        }
                        cVar.aLV = sparseArray;
                        cVar.setExtra(threadPersonalized.extra);
                    }
                }
            }
        }
    }
}
