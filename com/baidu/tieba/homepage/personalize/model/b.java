package com.baidu.tieba.homepage.personalize.model;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes7.dex */
public class b {
    public static void a(DataRes.Builder builder, List<m> list) {
        cJ(list);
        b(builder, list);
    }

    public static void cJ(List<m> list) {
        if (list != null) {
            int count = v.getCount(list);
            for (int i = 0; i < count; i++) {
                m mVar = (m) v.getItem(list, i);
                if (mVar instanceof p) {
                    ((p) mVar).kq(true);
                }
                m mVar2 = (m) v.getItem(list, i + 1);
                if ((mVar instanceof p) && (mVar2 instanceof p)) {
                    p pVar = (p) mVar;
                    p pVar2 = (p) mVar2;
                    if (pVar.btQ()) {
                        pVar2.kq(false);
                        if (pVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            pVar.kr(false);
                        }
                    }
                }
                if (mVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    ((com.baidu.tieba.homepage.personalize.b.c) mVar).kr(false);
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<m> list) {
        com.baidu.tieba.card.data.c cVar;
        bj axQ;
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
                m mVar = (m) v.getItem(list, i);
                if ((mVar instanceof com.baidu.tieba.card.data.c) && (axQ = (cVar = (com.baidu.tieba.card.data.c) mVar).axQ()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.f.b.toLong(axQ.getTid(), 0L))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.zE(threadPersonalized.abtest_tag);
                    axQ.mRecomAbTag = threadPersonalized.abtest_tag;
                    axQ.mRecomSource = threadPersonalized.source;
                    axQ.mRecomWeight = threadPersonalized.weight;
                    if (axQ.aAo() != null) {
                        cVar.j(axQ.aAo().is_vertical);
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
