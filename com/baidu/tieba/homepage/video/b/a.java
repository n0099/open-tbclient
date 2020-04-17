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
/* loaded from: classes9.dex */
public class a {
    public static void n(List<ThreadPersonalized> list, List<m> list2) {
        o(list, list2);
    }

    private static void o(List<ThreadPersonalized> list, List<m> list2) {
        c cVar;
        bj aIw;
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
                if ((mVar instanceof c) && (aIw = (cVar = (c) mVar).aIw()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(aIw.getTid())) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.BD(threadPersonalized.abtest_tag);
                    aIw.mRecomAbTag = threadPersonalized.abtest_tag;
                    aIw.mRecomSource = threadPersonalized.source;
                    aIw.mRecomWeight = threadPersonalized.weight;
                    if (aIw.aKV() != null) {
                        cVar.j(aIw.aKV().is_vertical);
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
