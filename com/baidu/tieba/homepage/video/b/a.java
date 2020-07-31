package com.baidu.tieba.homepage.video.b;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.c;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes16.dex */
public class a {
    public static void p(List<ThreadPersonalized> list, List<q> list2) {
        q(list, list2);
    }

    private static void q(List<ThreadPersonalized> list, List<q> list2) {
        c cVar;
        bv aTN;
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
                q qVar = (q) x.getItem(list2, i);
                if ((qVar instanceof c) && (aTN = (cVar = (c) qVar).aTN()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(aTN.getTid())) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.EB(threadPersonalized.abtest_tag);
                    aTN.mRecomAbTag = threadPersonalized.abtest_tag;
                    aTN.mRecomSource = threadPersonalized.source;
                    aTN.mRecomWeight = threadPersonalized.weight;
                    if (aTN.aWD() != null) {
                        cVar.k(aTN.aWD().is_vertical);
                    }
                    List<DislikeReason> list3 = threadPersonalized.dislike_resource;
                    if (list3 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list3) {
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
