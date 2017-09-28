package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.r;
import com.baidu.tieba.homepage.personalize.data.h;
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
    private int daC = 0;
    private com.baidu.tieba.homepage.personalize.b.d cWC = new com.baidu.tieba.homepage.personalize.b.d();
    private final c cWB = new c();
    private final int bgF = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_page_max_thread_count", 300);

    public int apM() {
        return this.bgF;
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
        d.e(builder);
        d.e(builder2);
        b(z, builder, builder2, i);
        a(builder, i, this.bgF);
        d.f(builder);
        List<r> d = d.d(builder);
        bv(d);
        List<f> k = k(builder.thread_list, d);
        this.cWC.bx(k);
        a(k, builder);
        b.a(builder, k);
        this.cWB.aUB = k;
        return this.cWB;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            a(z, builder.thread_list, builder2.thread_list, i);
            c(z, builder, builder2, i);
            j(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void j(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        d.a(z, builder, builder2, i, this.daC);
    }

    private void a(boolean z, List<ThreadInfo> list, List<ThreadInfo> list2, int i) {
        int i2;
        int i3;
        if (list != null && list2 != null) {
            int t = v.t(list);
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
                int t2 = v.t(list2) - 1;
                i2 = 0;
                while (t2 >= 0) {
                    this.cWC.a(z, t2, list, list2);
                    ThreadInfo threadInfo3 = (ThreadInfo) v.c(list2, t2);
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
                    t2--;
                    i2 = i3;
                }
            }
            int t3 = v.t(list);
            this.cWB.daE = (t3 - t) - i2;
            this.daC = t3 - t;
        }
    }

    private void bv(List<r> list) {
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

    private List<f> k(List<ThreadInfo> list, List<r> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                bh bhVar = new bh();
                bhVar.a(threadInfo);
                bhVar.bY(1);
                if (!TextUtils.isEmpty(bhVar.sq())) {
                    af afVar = new af();
                    afVar.cx(bhVar.sq());
                    linkedList.add(afVar);
                } else {
                    com.baidu.tieba.card.data.c S = d.S(bhVar);
                    if (S != null) {
                        S.Xf = bhVar.getTid();
                    }
                    if (S != null && S.isValid()) {
                        linkedList.add(S);
                    }
                }
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= v.t(list2)) {
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
                int t = (v.t(list) - i2) + 30;
                while (true) {
                    t--;
                    if (t >= 30) {
                        if (list.size() > t) {
                            list.remove(t);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int t2 = v.t(list) - 1; t2 >= i2; t2--) {
                    list.remove(t2);
                }
            }
        }
    }

    private void a(List<f> list, DataRes.Builder builder) {
        com.baidu.tieba.homepage.personalize.data.f b;
        if (builder != null && list != null) {
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("close_new_user_guide_tip", false) && builder.age_sex != null) {
                h c = h.c(builder);
                if (c != null) {
                    list.add(0, c);
                }
            } else if (builder.interestion != null && builder.interestion.size() > 0 && (b = com.baidu.tieba.homepage.personalize.data.f.b(builder)) != null) {
                list.add(0, b);
            }
        }
    }
}
