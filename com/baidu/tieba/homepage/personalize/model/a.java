package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.q;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class a {
    private int eku = 0;
    private com.baidu.tieba.homepage.personalize.b.d ekv = new com.baidu.tieba.homepage.personalize.b.d();
    private final c egD = new c();
    private final int ccw = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_page_max_thread_count", 300);

    public int aDd() {
        return this.ccw;
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
        a(builder, i, this.ccw);
        d.e(builder);
        List<q> b = d.b(builder);
        bN(b);
        List<i> l = l(builder.thread_list, b);
        this.ekv.bQ(l);
        b.a(builder, l);
        this.egD.bND = l;
        return this.egD;
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
        d.a(z, builder, builder2, i, this.eku);
    }

    private void a(boolean z, List<ThreadInfo> list, List<ThreadInfo> list2, int i) {
        int i2;
        int i3;
        if (list != null && list2 != null) {
            int D = v.D(list);
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
                for (ThreadInfo threadInfo2 : list2) {
                    if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                        if (!hashSet2.contains(threadInfo2.lego_card)) {
                            list.add(threadInfo2);
                        }
                    } else if (threadInfo2 != null && threadInfo2.tid != null && !hashSet.contains(threadInfo2.tid)) {
                        list.add(threadInfo2);
                    }
                }
                i2 = 0;
            } else {
                int D2 = v.D(list2) - 1;
                i2 = 0;
                while (D2 >= 0) {
                    this.ekv.a(z, D2, list, list2);
                    ThreadInfo threadInfo3 = (ThreadInfo) v.f(list2, D2);
                    if (threadInfo3 != null && !TextUtils.isEmpty(threadInfo3.lego_card)) {
                        if (!hashSet2.contains(threadInfo3.lego_card)) {
                            list.add(0, threadInfo3);
                            i3 = i2;
                        } else {
                            i3 = i2 + 1;
                        }
                    } else if (threadInfo3 == null || threadInfo3.tid == null) {
                        i3 = i2;
                    } else if (!hashSet.contains(threadInfo3.tid)) {
                        list.add(0, threadInfo3);
                        i3 = i2;
                    } else {
                        i3 = i2 + 1;
                    }
                    D2--;
                    i2 = i3;
                }
            }
            int D3 = v.D(list);
            this.egD.ekx = (D3 - D) - i2;
            this.eku = D3 - D;
        }
    }

    private void bN(List<q> list) {
        if (list != null) {
            Collections.sort(list, new Comparator<q>() { // from class: com.baidu.tieba.homepage.personalize.model.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(q qVar, q qVar2) {
                    if (qVar == null || qVar2 == null) {
                        return 0;
                    }
                    if (qVar.getPosition() > qVar2.getPosition()) {
                        return 1;
                    }
                    return qVar.getPosition() < qVar2.getPosition() ? -1 : 0;
                }
            });
        }
    }

    private List<i> l(List<ThreadInfo> list, List<q> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                bd bdVar = new bd();
                bdVar.a(threadInfo);
                bdVar.eW(1);
                if (!TextUtils.isEmpty(bdVar.Af())) {
                    ab abVar = new ab();
                    abVar.cU(bdVar.Af());
                    linkedList.add(abVar);
                } else {
                    com.baidu.tieba.card.data.c Y = d.Y(bdVar);
                    if (Y != null) {
                        Y.tid = bdVar.getTid();
                    }
                    if (Y != null && Y.isValid()) {
                        linkedList.add(Y);
                    }
                }
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= v.D(list2)) {
                return linkedList;
            }
            q qVar = (q) v.f(list2, i2);
            if (qVar != null && linkedList.size() >= qVar.getPosition() && qVar.getPosition() > 0) {
                linkedList.add(qVar.getPosition() - 1, qVar);
            }
            i = i2 + 1;
        }
    }

    private void a(DataRes.Builder builder, int i, int i2) {
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int D = (v.D(list) - i2) + 30;
                while (true) {
                    D--;
                    if (D >= 30) {
                        if (list.size() > D) {
                            list.remove(D);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int D2 = v.D(list) - 1; D2 >= i2; D2--) {
                    list.remove(D2);
                }
            }
        }
    }
}
