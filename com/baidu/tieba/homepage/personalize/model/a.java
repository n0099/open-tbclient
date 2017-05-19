package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.r;
import com.baidu.tieba.homepage.personalize.data.h;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.homepage.personalize.c.f cwB = new com.baidu.tieba.homepage.personalize.c.f();
    private final d cwz = new d();
    private final int cwA = com.baidu.tbadk.core.sharedPref.b.tX().getInt("home_page_max_thread_count", 300);

    public int ahQ() {
        return this.cwA;
    }

    public d a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (i != 0 && i != 1) {
            return null;
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        if (builder2 == null) {
            builder2 = new DataRes.Builder();
        }
        e.f(builder);
        e.f(builder2);
        b(z, builder, builder2, i);
        a(builder, i, this.cwA);
        e.g(builder);
        List<r> e = e.e(builder);
        aW(e);
        List<v> i2 = i(builder.thread_list, e);
        this.cwB.aY(i2);
        a(i2, builder);
        c.a(builder, i2);
        this.cwz.aQf = i2;
        return this.cwz;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            a(z, builder.thread_list, builder2.thread_list, i);
            a(builder, builder2, i);
            h(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void h(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void a(DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (i == 0) {
            e.d(builder);
        }
        e.a(builder, builder2);
    }

    private void a(boolean z, List<ThreadInfo> list, List<ThreadInfo> list2, int i) {
        int i2;
        int i3;
        if (list != null && list2 != null) {
            int q = x.q(list);
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
                int q2 = x.q(list2) - 1;
                i2 = 0;
                while (q2 >= 0) {
                    this.cwB.a(z, q2, list, list2);
                    ThreadInfo threadInfo3 = (ThreadInfo) x.c(list2, q2);
                    if (threadInfo3 == null || TextUtils.isEmpty(threadInfo3.lego_card)) {
                        if (threadInfo3 == null || threadInfo3.tid == null) {
                            i3 = i2;
                        } else if (!hashSet.contains(threadInfo3.tid)) {
                            list.add(0, threadInfo3);
                            i3 = i2;
                        } else {
                            i3 = i2 + 1;
                        }
                    } else if (!hashSet2.contains(threadInfo3.lego_card)) {
                        list.add(0, threadInfo3);
                        i3 = i2;
                    } else {
                        i3 = i2 + 1;
                    }
                    q2--;
                    i2 = i3;
                }
            }
            this.cwz.cwD = (x.q(list) - q) - i2;
        }
    }

    private void aW(List<r> list) {
        if (list != null) {
            Collections.sort(list, new b(this));
        }
    }

    private List<v> i(List<ThreadInfo> list, List<r> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                bk bkVar = new bk();
                bkVar.a(threadInfo);
                bkVar.bV(1);
                if (!TextUtils.isEmpty(bkVar.st())) {
                    ah ahVar = new ah();
                    ahVar.co(bkVar.st());
                    linkedList.add(ahVar);
                } else {
                    com.baidu.tieba.card.data.c G = e.G(bkVar);
                    if (G != null) {
                        G.Wl = bkVar.getTid();
                    }
                    if (G != null && G.isValid()) {
                        linkedList.add(G);
                    }
                }
            }
        }
        for (int q = x.q(list2) - 1; q >= 0; q--) {
            r rVar = (r) x.c(list2, q);
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
                int q = (x.q(list) - i2) + 30;
                while (true) {
                    q--;
                    if (q >= 30) {
                        if (list.size() > q) {
                            list.remove(q);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int q2 = x.q(list) - 1; q2 >= i2; q2--) {
                    list.remove(q2);
                }
            }
        }
    }

    private void a(List<v> list, DataRes.Builder builder) {
        com.baidu.tieba.homepage.personalize.data.f b;
        if (builder != null && list != null) {
            if (!com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("close_new_user_guide_tip", false) && builder.age_sex != null) {
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
