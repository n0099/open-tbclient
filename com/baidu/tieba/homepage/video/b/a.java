package com.baidu.tieba.homepage.video.b;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.c;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes22.dex */
public class a {
    public static void x(List<ThreadPersonalized> list, List<q> list2) {
        y(list, list2);
    }

    private static void y(List<ThreadPersonalized> list, List<q> list2) {
        c cVar;
        bw bjZ;
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
                if ((qVar instanceof c) && (bjZ = (cVar = (c) qVar).bjZ()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(bjZ.getTid())) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.Jb(threadPersonalized.abtest_tag);
                    bjZ.mRecomAbTag = threadPersonalized.abtest_tag;
                    bjZ.mRecomSource = threadPersonalized.source;
                    bjZ.mRecomWeight = threadPersonalized.weight;
                    if (bjZ.bmS() != null) {
                        cVar.n(bjZ.bmS().is_vertical);
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
