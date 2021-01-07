package com.baidu.tieba.homepage.video.b;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes2.dex */
public class a {
    public static void z(List<ThreadPersonalized> list, List<n> list2) {
        A(list, list2);
    }

    private static void A(List<ThreadPersonalized> list, List<n> list2) {
        com.baidu.tieba.card.data.b bVar;
        bz boP;
        ThreadPersonalized threadPersonalized;
        if (list != null && list2 != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : list) {
                if (threadPersonalized2 != null) {
                    hashMap.put(String.valueOf(threadPersonalized2.tid), threadPersonalized2);
                }
            }
            int count = x.getCount(list2);
            for (int i = 0; i < count; i++) {
                n nVar = (n) x.getItem(list2, i);
                if ((nVar instanceof com.baidu.tieba.card.data.b) && (boP = (bVar = (com.baidu.tieba.card.data.b) nVar).boP()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(boP.getTid())) != null) {
                    bVar.setSource(threadPersonalized.source);
                    bVar.setWeight(threadPersonalized.weight);
                    bVar.Jp(threadPersonalized.abtest_tag);
                    boP.mRecomAbTag = threadPersonalized.abtest_tag;
                    boP.mRecomSource = threadPersonalized.source;
                    boP.mRecomWeight = threadPersonalized.weight;
                    if (boP.brI() != null) {
                        bVar.p(boP.brI().is_vertical);
                    }
                    List<DislikeReason> list3 = threadPersonalized.dislike_resource;
                    if (list3 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list3) {
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
