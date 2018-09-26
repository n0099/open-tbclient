package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.p;
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
    private int egM = 0;
    private com.baidu.tieba.homepage.personalize.b.d egN = new com.baidu.tieba.homepage.personalize.b.d();
    private final c ebc = new c();
    private final int bCL = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_page_max_thread_count", 300);

    public int aGR() {
        return this.bCL;
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
        a(builder, i, this.bCL);
        d.e(builder);
        List<p> b = d.b(builder);
        bU(b);
        List<h> m = m(builder.thread_list, b);
        this.egN.bX(m);
        b.a(builder, m);
        this.ebc.bny = m;
        return this.ebc;
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
        d.a(z, builder, builder2, i, this.egM);
    }

    private void a(boolean z, List<ThreadInfo> list, List<ThreadInfo> list2, int i) {
        if (list != null && list2 != null) {
            int y = v.y(list);
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
            } else {
                for (int y2 = v.y(list2) - 1; y2 >= 0; y2--) {
                    this.egN.a(z, y2, list, list2);
                    ThreadInfo threadInfo3 = (ThreadInfo) v.d(list2, y2);
                    if (threadInfo3 != null && !TextUtils.isEmpty(threadInfo3.lego_card)) {
                        if (!hashSet2.contains(threadInfo3.lego_card)) {
                            list.add(0, threadInfo3);
                        }
                    } else if (threadInfo3 != null && threadInfo3.tid != null && !hashSet.contains(threadInfo3.tid)) {
                        list.add(0, threadInfo3);
                    }
                }
            }
            int y3 = v.y(list);
            this.ebc.egP = y3 - y;
            this.egM = y3 - y;
        }
    }

    private void bU(List<p> list) {
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

    private List<h> m(List<ThreadInfo> list, List<p> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                bb bbVar = new bb();
                bbVar.a(threadInfo);
                bbVar.cj(1);
                if (!TextUtils.isEmpty(bbVar.xg())) {
                    ab abVar = new ab();
                    abVar.dz(bbVar.xg());
                    linkedList.add(abVar);
                } else {
                    com.baidu.tieba.card.data.c ai = d.ai(bbVar);
                    if (ai != null) {
                        ai.tid = bbVar.getTid();
                    }
                    if (ai != null && ai.isValid()) {
                        linkedList.add(ai);
                    }
                }
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= v.y(list2)) {
                return linkedList;
            }
            p pVar = (p) v.d(list2, i2);
            if (pVar != null && linkedList.size() >= pVar.getPosition() && pVar.getPosition() > 0) {
                linkedList.add(pVar.getPosition() - 1, pVar);
            }
            i = i2 + 1;
        }
    }

    private void a(DataRes.Builder builder, int i, int i2) {
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int y = (v.y(list) - i2) + 30;
                while (true) {
                    y--;
                    if (y >= 30) {
                        if (list.size() > y) {
                            list.remove(y);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int y2 = v.y(list) - 1; y2 >= i2; y2--) {
                    list.remove(y2);
                }
            }
        }
    }
}
