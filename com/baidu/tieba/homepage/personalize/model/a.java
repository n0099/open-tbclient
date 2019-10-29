package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.p;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {
    private int gmO = 0;
    private com.baidu.tieba.homepage.personalize.b.d gmP = new com.baidu.tieba.homepage.personalize.b.d();
    private final c gfi = new c();
    private final int gmN = com.baidu.tbadk.core.sharedPref.b.alR().getInt("home_page_max_thread_count", 300);

    public int bvk() {
        return this.gmN;
    }

    public c a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (i != 0 && i != 1) {
            return null;
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        if (builder2 == null) {
            builder2 = new DataRes.Builder();
        }
        d.c(builder);
        d.c(builder2);
        b(z, builder, builder2, i);
        a(builder, i, this.gmN);
        d.e(builder);
        List<p> b = d.b(builder);
        cT(b);
        List<m> l = l(builder.thread_list, b);
        this.gmP.cW(l);
        b.a(builder, l);
        this.gfi.dbM = l;
        return this.gfi;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            a(z, builder.thread_list, builder2.thread_list, i);
            c(z, builder, builder2, i);
            k(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void k(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        d.a(z, builder, builder2, i, this.gmO);
    }

    private void a(boolean z, List<ThreadInfo> list, List<ThreadInfo> list2, int i) {
        if (list != null && list2 != null) {
            int count = v.getCount(list);
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null && !TextUtils.isEmpty(threadInfo.lego_card)) {
                    hashSet2.add(threadInfo.lego_card);
                } else if (threadInfo != null && threadInfo.tid != null) {
                    hashSet.add(threadInfo.tid);
                }
            }
            if (i == 1) {
                this.gmP.aY(list);
                for (ThreadInfo threadInfo2 : list2) {
                    if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                        if (!hashSet2.contains(threadInfo2.lego_card)) {
                            list.add(threadInfo2);
                        }
                    } else if (threadInfo2 != null && threadInfo2.tid != null && !hashSet.contains(threadInfo2.tid)) {
                        list.add(threadInfo2);
                    }
                }
            } else {
                this.gmP.a(z, list2.size() - 1, list, list2);
                for (int count2 = v.getCount(list2) - 1; count2 >= 0; count2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) v.getItem(list2, count2);
                    if (threadInfo3 != null && !TextUtils.isEmpty(threadInfo3.lego_card)) {
                        if (!hashSet2.contains(threadInfo3.lego_card)) {
                            list.add(0, threadInfo3);
                        }
                    } else if (threadInfo3 != null && threadInfo3.tid != null && !hashSet.contains(threadInfo3.tid)) {
                        list.add(0, threadInfo3);
                    }
                }
            }
            int count3 = v.getCount(list);
            this.gfi.gmR = count3 - count;
            this.gmO = count3 - count;
        }
    }

    private void cT(List<p> list) {
        if (list != null) {
            Collections.sort(list, new Comparator<p>() { // from class: com.baidu.tieba.homepage.personalize.model.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(p pVar, p pVar2) {
                    if (pVar == null || pVar2 == null) {
                        return 0;
                    }
                    if (pVar.getPosition() > pVar2.getPosition()) {
                        return 1;
                    }
                    return pVar.getPosition() < pVar2.getPosition() ? -1 : 0;
                }
            });
        }
    }

    private List<m> l(List<ThreadInfo> list, List<p> list2) {
        int i;
        int i2;
        int i3;
        int[] imageWidthAndHeight;
        int i4 = 0;
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int i5 = 0;
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                bh bhVar = new bh();
                bhVar.a(threadInfo);
                bhVar.setCurrentPage(1);
                if (!TextUtils.isEmpty(bhVar.ajI())) {
                    ad adVar = new ad();
                    adVar.mP(bhVar.ajI());
                    adVar.position = i5;
                    linkedList.add(adVar);
                } else if (com.baidu.tieba.homepage.topic.topictab.b.a.V(bhVar)) {
                    if (!StringUtils.isNull(bhVar.akx().topic_name)) {
                        com.baidu.tieba.homepage.topic.topictab.b.a aVar = new com.baidu.tieba.homepage.topic.topictab.b.a();
                        aVar.a(bhVar.akx());
                        aVar.from = 1;
                        aVar.position = i5;
                        aVar.ai(bhVar);
                        linkedList.add(aVar);
                    }
                } else if (k.V(bhVar) || l.V(bhVar)) {
                    if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 4) != 0) {
                        imageWidthAndHeight = bhVar.aky();
                    } else {
                        imageWidthAndHeight = bhVar.getImageWidthAndHeight();
                    }
                    k ap = d.ap(bhVar);
                    if (ap != null) {
                        ap.tid = bhVar.getTid();
                        ap.position = i5;
                        d.a(ap);
                    }
                    if (ap != null && ap.isValid()) {
                        linkedList.add(ap);
                    }
                    com.baidu.tieba.card.data.c ao = d.ao(bhVar);
                    if (ao != null) {
                        ao.tid = bhVar.getTid();
                        ao.position = i5;
                        if (ao instanceof k) {
                            if (bhVar.ajE() == 1) {
                                d.b(ao);
                                ao.cbr = imageWidthAndHeight[0];
                                ao.cbs = imageWidthAndHeight[1];
                            } else if (bhVar.ajE() >= 2) {
                                d.c(ao);
                            } else {
                                d.d(ao);
                            }
                        } else if (ao instanceof l) {
                            d.e(ao);
                        }
                    }
                    if (ao != null && ao.isValid()) {
                        linkedList.add(ao);
                    }
                    k ap2 = d.ap(bhVar);
                    if (ap2 != null) {
                        ap2.tid = bhVar.getTid();
                        ap2.position = i5;
                        d.f(ap2);
                    }
                    if (ap2 != null && ap2.isValid()) {
                        linkedList.add(ap2);
                    }
                    if (threadInfo.top_agree_post != null) {
                        k ap3 = d.ap(bhVar);
                        if (ap3 != null) {
                            ap3.tid = bhVar.getTid();
                            ap3.position = i5;
                            d.g(ap3);
                        }
                        if (ap3 != null && ap3.isValid()) {
                            linkedList.add(ap3);
                        }
                    }
                    k ap4 = d.ap(bhVar);
                    if (ap4 != null) {
                        ap4.tid = bhVar.getTid();
                        ap4.position = i5;
                        d.h(ap4);
                    }
                    if (ap4 != null && ap4.isValid()) {
                        linkedList.add(ap4);
                    }
                } else {
                    com.baidu.tieba.card.data.c ao2 = d.ao(bhVar);
                    if (ao2 != null) {
                        ao2.tid = bhVar.getTid();
                        ao2.position = i5;
                    }
                    if (ao2 != null && ao2.isValid()) {
                        linkedList.add(ao2);
                    }
                }
                i3 = i5 + 1;
            } else {
                i3 = i5;
            }
            i5 = i3;
        }
        int i6 = 0;
        int i7 = 0;
        while (i4 < v.getCount(list2)) {
            p pVar = (p) v.getItem(list2, i4);
            if (pVar == null || i7 >= linkedList.size()) {
                i = i6;
            } else {
                while (true) {
                    i2 = i7;
                    if ((i2 >= linkedList.size() || (linkedList.get(i2) instanceof com.baidu.tieba.card.data.c)) && (i2 >= linkedList.size() || ((com.baidu.tieba.card.data.c) linkedList.get(i2)).position + i6 == pVar.getPosition() - 1)) {
                        break;
                    }
                    i7 = i2 + 1;
                }
                if (linkedList.size() <= i2 || i2 <= 0) {
                    i = i6;
                    i7 = i2;
                } else {
                    linkedList.add(i2, pVar);
                    i = i6 + 1;
                    i7 = i2;
                }
            }
            i4++;
            i6 = i;
        }
        return linkedList;
    }

    private void a(DataRes.Builder builder, int i, int i2) {
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int count = (v.getCount(list) - i2) + 30;
                while (true) {
                    count--;
                    if (count >= 30) {
                        if (list.size() > count) {
                            list.remove(count);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int count2 = v.getCount(list) - 1; count2 >= i2; count2--) {
                    list.remove(count2);
                }
            }
        }
    }
}
