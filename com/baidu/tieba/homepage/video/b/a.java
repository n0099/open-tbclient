package com.baidu.tieba.homepage.video.b;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.c;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes9.dex */
public class a {
    public static void o(List<ThreadPersonalized> list, List<o> list2) {
        p(list, list2);
    }

    private static void p(List<ThreadPersonalized> list, List<o> list2) {
        c cVar;
        bk aOi;
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
                o oVar = (o) v.getItem(list2, i);
                if ((oVar instanceof c) && (aOi = (cVar = (c) oVar).aOi()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(aOi.getTid())) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.Dp(threadPersonalized.abtest_tag);
                    aOi.mRecomAbTag = threadPersonalized.abtest_tag;
                    aOi.mRecomSource = threadPersonalized.source;
                    aOi.mRecomWeight = threadPersonalized.weight;
                    if (aOi.aQQ() != null) {
                        cVar.k(aOi.aQQ().is_vertical);
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
