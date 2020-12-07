package com.baidu.tieba.homepage.video.b;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes22.dex */
public class a {
    public static void w(List<ThreadPersonalized> list, List<q> list2) {
        x(list, list2);
    }

    private static void x(List<ThreadPersonalized> list, List<q> list2) {
        com.baidu.tieba.card.data.b bVar;
        by bmn;
        ThreadPersonalized threadPersonalized;
        if (list != null && list2 != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : list) {
                if (threadPersonalized2 != null) {
                    hashMap.put(String.valueOf(threadPersonalized2.tid), threadPersonalized2);
                }
            }
            int count = y.getCount(list2);
            for (int i = 0; i < count; i++) {
                q qVar = (q) y.getItem(list2, i);
                if ((qVar instanceof com.baidu.tieba.card.data.b) && (bmn = (bVar = (com.baidu.tieba.card.data.b) qVar).bmn()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(bmn.getTid())) != null) {
                    bVar.setSource(threadPersonalized.source);
                    bVar.setWeight(threadPersonalized.weight);
                    bVar.Js(threadPersonalized.abtest_tag);
                    bmn.mRecomAbTag = threadPersonalized.abtest_tag;
                    bmn.mRecomSource = threadPersonalized.source;
                    bmn.mRecomWeight = threadPersonalized.weight;
                    if (bmn.bph() != null) {
                        bVar.n(bmn.bph().is_vertical);
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
