package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.u;
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
    private com.baidu.tieba.homepage.personalize.c.d cPn = new com.baidu.tieba.homepage.personalize.c.d();
    private final c cPm = new c();
    private final int bdL = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_page_max_thread_count", 300);

    public int aoy() {
        return this.bdL;
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
        d.f(builder);
        d.f(builder2);
        b(z, builder, builder2, i);
        a(builder, i, this.bdL);
        d.g(builder);
        List<r> e = d.e(builder);
        bw(e);
        List<f> m = m(builder.thread_list, e);
        this.cPn.by(m);
        a(m, builder);
        b.a(builder, m);
        this.cPm.aSH = m;
        return this.cPm;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            a(z, builder.thread_list, builder2.thread_list, i);
            a(builder, builder2, i);
            l(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void l(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void a(DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (i == 0) {
            d.d(builder);
        }
        d.a(builder, builder2);
    }

    private void a(boolean z, List<ThreadInfo> list, List<ThreadInfo> list2, int i) {
        int i2;
        int i3;
        if (list != null && list2 != null) {
            int u = u.u(list);
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
                int u2 = u.u(list2) - 1;
                i2 = 0;
                while (u2 >= 0) {
                    this.cPn.a(z, u2, list, list2);
                    ThreadInfo threadInfo3 = (ThreadInfo) u.c(list2, u2);
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
                    u2--;
                    i2 = i3;
                }
            }
            this.cPm.cTw = (u.u(list) - u) - i2;
        }
    }

    private void bw(List<r> list) {
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
                bl blVar = new bl();
                blVar.a(threadInfo);
                blVar.bV(1);
                if (!TextUtils.isEmpty(blVar.sq())) {
                    ah ahVar = new ah();
                    ahVar.cy(blVar.sq());
                    linkedList.add(ahVar);
                } else {
                    com.baidu.tieba.card.data.c S = d.S(blVar);
                    if (S != null) {
                        S.Ww = blVar.getTid();
                    }
                    if (S != null && S.isValid()) {
                        linkedList.add(S);
                    }
                }
            }
        }
        for (int u = u.u(list2) - 1; u >= 0; u--) {
            r rVar = (r) u.c(list2, u);
            if (rVar != null && linkedList.size() >= rVar.getPosition() && rVar.getPosition() > 0) {
                linkedList.add(rVar.getPosition() - 1, rVar);
            }
        }
        return linkedList;
    }

    private void a(DataRes.Builder builder, int i, int i2) {
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int u = (u.u(list) - i2) + 30;
                while (true) {
                    u--;
                    if (u >= 30) {
                        if (list.size() > u) {
                            list.remove(u);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int u2 = u.u(list) - 1; u2 >= i2; u2--) {
                    list.remove(u2);
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
