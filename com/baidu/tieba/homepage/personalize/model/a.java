package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.w;
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
    private int dRI = 0;
    private com.baidu.tieba.homepage.personalize.b.d dRJ = new com.baidu.tieba.homepage.personalize.b.d();
    private final c dNJ = new c();
    private final int buT = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_page_max_thread_count", 300);

    public int aCV() {
        return this.buT;
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
        a(builder, i, this.buT);
        d.e(builder);
        List<p> b = d.b(builder);
        bP(b);
        List<h> m = m(builder.thread_list, b);
        this.dRJ.bS(m);
        b.a(builder, m);
        this.dNJ.bfM = m;
        return this.dNJ;
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
        d.a(z, builder, builder2, i, this.dRI);
    }

    private void a(boolean z, List<ThreadInfo> list, List<ThreadInfo> list2, int i) {
        int i2;
        int i3;
        if (list != null && list2 != null) {
            int y = w.y(list);
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
                int y2 = w.y(list2) - 1;
                i2 = 0;
                while (y2 >= 0) {
                    this.dRJ.a(z, y2, list, list2);
                    ThreadInfo threadInfo3 = (ThreadInfo) w.c(list2, y2);
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
                    y2--;
                    i2 = i3;
                }
            }
            int y3 = w.y(list);
            this.dNJ.dRL = (y3 - y) - i2;
            this.dRI = y3 - y;
        }
    }

    private void bP(List<p> list) {
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
                bd bdVar = new bd();
                bdVar.a(threadInfo);
                bdVar.bX(1);
                if (!TextUtils.isEmpty(bdVar.wd())) {
                    ac acVar = new ac();
                    acVar.dg(bdVar.wd());
                    linkedList.add(acVar);
                } else {
                    com.baidu.tieba.card.data.c ab = d.ab(bdVar);
                    if (ab != null) {
                        ab.tid = bdVar.getTid();
                    }
                    if (ab != null && ab.isValid()) {
                        linkedList.add(ab);
                    }
                }
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= w.y(list2)) {
                return linkedList;
            }
            p pVar = (p) w.c(list2, i2);
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
                int y = (w.y(list) - i2) + 30;
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
                for (int y2 = w.y(list) - 1; y2 >= i2; y2--) {
                    list.remove(y2);
                }
            }
        }
    }
}
