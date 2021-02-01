package com.baidu.tieba.homepage.video.b;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes2.dex */
public class a {
    public static void y(List<ThreadPersonalized> list, List<n> list2) {
        z(list, list2);
    }

    private static void z(List<ThreadPersonalized> list, List<n> list2) {
        com.baidu.tieba.card.data.b bVar;
        cb bln;
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
                n nVar = (n) y.getItem(list2, i);
                if ((nVar instanceof com.baidu.tieba.card.data.b) && (bln = (bVar = (com.baidu.tieba.card.data.b) nVar).bln()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(bln.getTid())) != null) {
                    bVar.setSource(threadPersonalized.source);
                    bVar.setWeight(threadPersonalized.weight);
                    bVar.IP(threadPersonalized.abtest_tag);
                    bln.mRecomAbTag = threadPersonalized.abtest_tag;
                    bln.mRecomSource = threadPersonalized.source;
                    bln.mRecomWeight = threadPersonalized.weight;
                    if (bln.boh() != null) {
                        bVar.p(bln.boh().is_vertical);
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
