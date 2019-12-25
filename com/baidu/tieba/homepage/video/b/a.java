package com.baidu.tieba.homepage.video.b;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.c;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes6.dex */
public class a {
    public static void o(List<ThreadPersonalized> list, List<m> list2) {
        p(list, list2);
    }

    private static void p(List<ThreadPersonalized> list, List<m> list2) {
        c cVar;
        bj axx;
        ThreadPersonalized threadPersonalized;
        if (list != null && list2 != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : list) {
                if (threadPersonalized2 != null) {
                    hashMap.put(String.valueOf(threadPersonalized2.tid), threadPersonalized2);
                }
            }
            int count = v.getCount(list2);
            for (int i = 0; i < count; i++) {
                m mVar = (m) v.getItem(list2, i);
                if ((mVar instanceof c) && (axx = (cVar = (c) mVar).axx()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(axx.getTid())) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.zu(threadPersonalized.abtest_tag);
                    axx.mRecomAbTag = threadPersonalized.abtest_tag;
                    axx.mRecomSource = threadPersonalized.source;
                    axx.mRecomWeight = threadPersonalized.weight;
                    if (axx.azV() != null) {
                        cVar.j(axx.azV().is_vertical);
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
