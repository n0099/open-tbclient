package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.r;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a {
    private int drt = 0;
    private com.baidu.tieba.homepage.personalize.b.d dru = new com.baidu.tieba.homepage.personalize.b.d();
    private final c dnG = new c();
    private final int bmQ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_page_max_thread_count", 300);

    public int aun() {
        return this.bmQ;
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
        a(builder, i, this.bmQ);
        d.e(builder);
        List<r> b = d.b(builder);
        bG(b);
        List<f> m = m(builder.thread_list, b);
        this.dru.bI(m);
        b.a(builder, m);
        this.dnG.aXC = m;
        return this.dnG;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            a(z, builder.thread_list, builder2.thread_list, i);
            c(z, builder, builder2, i);
            l(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void l(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        d.a(z, builder, builder2, i, this.drt);
    }

    private void a(boolean z, List<ThreadInfo> list, List<ThreadInfo> list2, int i) {
        int i2;
        int i3;
        if (list != null && list2 != null) {
            int v = v.v(list);
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
                int v2 = v.v(list2) - 1;
                i2 = 0;
                while (v2 >= 0) {
                    this.dru.a(z, v2, list, list2);
                    ThreadInfo threadInfo3 = (ThreadInfo) v.c(list2, v2);
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
                    v2--;
                    i2 = i3;
                }
            }
            int v3 = v.v(list);
            this.dnG.drw = (v3 - v) - i2;
            this.drt = v3 - v;
        }
    }

    private void bG(List<r> list) {
        if (list != null) {
            Collections.sort(list, new Comparator<r>() { // from class: com.baidu.tieba.homepage.personalize.model.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar, r rVar2) {
                    if (rVar == null || rVar2 == null) {
                        return 0;
                    }
                    if (rVar.getPosition() > rVar2.getPosition()) {
                        return 1;
                    }
                    return rVar.getPosition() < rVar2.getPosition() ? -1 : 0;
                }
            });
        }
    }

    private List<f> m(List<ThreadInfo> list, List<r> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                bd bdVar = new bd();
                bdVar.a(threadInfo);
                bdVar.bY(1);
                if (!TextUtils.isEmpty(bdVar.st())) {
                    ab abVar = new ab();
                    abVar.cC(bdVar.st());
                    linkedList.add(abVar);
                } else {
                    com.baidu.tieba.card.data.c V = d.V(bdVar);
                    if (V != null) {
                        V.tid = bdVar.getTid();
                    }
                    if (V != null && V.isValid()) {
                        linkedList.add(V);
                    }
                }
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= v.v(list2)) {
                return linkedList;
            }
            r rVar = (r) v.c(list2, i2);
            if (rVar != null && linkedList.size() >= rVar.getPosition() && rVar.getPosition() > 0) {
                linkedList.add(rVar.getPosition() - 1, rVar);
            }
            i = i2 + 1;
        }
    }

    private void a(DataRes.Builder builder, int i, int i2) {
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int v = (v.v(list) - i2) + 30;
                while (true) {
                    v--;
                    if (v >= 30) {
                        if (list.size() > v) {
                            list.remove(v);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int v2 = v.v(list) - 1; v2 >= i2; v2--) {
                    list.remove(v2);
                }
            }
        }
    }
}
