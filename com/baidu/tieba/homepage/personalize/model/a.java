package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.be;
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
/* loaded from: classes2.dex */
public class a {
    private int eeI = 0;
    private com.baidu.tieba.homepage.personalize.b.d eeJ = new com.baidu.tieba.homepage.personalize.b.d();
    private final c eaY = new c();
    private final int cai = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_page_max_thread_count", 300);

    public int aBA() {
        return this.cai;
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
        a(builder, i, this.cai);
        d.e(builder);
        List<r> b = d.b(builder);
        bS(b);
        List<i> m = m(builder.thread_list, b);
        this.eeJ.bV(m);
        b.a(builder, m);
        this.eaY.bLw = m;
        return this.eaY;
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
        d.a(z, builder, builder2, i, this.eeI);
    }

    private void a(boolean z, List<ThreadInfo> list, List<ThreadInfo> list2, int i) {
        int i2;
        int i3;
        if (list != null && list2 != null) {
            int F = v.F(list);
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
                int F2 = v.F(list2) - 1;
                i2 = 0;
                while (F2 >= 0) {
                    this.eeJ.a(z, F2, list, list2);
                    ThreadInfo threadInfo3 = (ThreadInfo) v.f(list2, F2);
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
                    F2--;
                    i2 = i3;
                }
            }
            int F3 = v.F(list);
            this.eaY.eeL = (F3 - F) - i2;
            this.eeI = F3 - F;
        }
    }

    private void bS(List<r> list) {
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

    private List<i> m(List<ThreadInfo> list, List<r> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                be beVar = new be();
                beVar.a(threadInfo);
                beVar.eY(1);
                if (!TextUtils.isEmpty(beVar.zT())) {
                    ac acVar = new ac();
                    acVar.cJ(beVar.zT());
                    linkedList.add(acVar);
                } else {
                    com.baidu.tieba.card.data.c V = d.V(beVar);
                    if (V != null) {
                        V.tid = beVar.getTid();
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
            if (i2 >= v.F(list2)) {
                return linkedList;
            }
            r rVar = (r) v.f(list2, i2);
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
                int F = (v.F(list) - i2) + 30;
                while (true) {
                    F--;
                    if (F >= 30) {
                        if (list.size() > F) {
                            list.remove(F);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int F2 = v.F(list) - 1; F2 >= i2; F2--) {
                    list.remove(F2);
                }
            }
        }
    }
}
