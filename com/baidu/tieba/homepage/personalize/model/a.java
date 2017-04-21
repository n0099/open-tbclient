package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.t;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.homepage.personalize.c.f cBu = new com.baidu.tieba.homepage.personalize.c.f();
    private final d cBs = new d();
    private final int cBt = com.baidu.tbadk.core.sharedPref.b.uL().getInt("home_page_max_thread_count", 300);

    public int akE() {
        return this.cBt;
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
        a(builder, i, this.cBt);
        e.g(builder);
        List<t> e = e.e(builder);
        be(e);
        List<v> h = h(builder.thread_list, e);
        this.cBu.bg(h);
        a(h, builder);
        c.a(builder, h);
        this.cBs.aPM = h;
        return this.cBs;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            a(z, builder.thread_list, builder2.thread_list, i);
            a(builder, builder2, i);
            g(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void g(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
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
            int p = x.p(list);
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
                int p2 = x.p(list2) - 1;
                i2 = 0;
                while (p2 >= 0) {
                    this.cBu.a(z, p2, list, list2);
                    ThreadInfo threadInfo3 = (ThreadInfo) x.c(list2, p2);
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
                    p2--;
                    i2 = i3;
                }
            }
            this.cBs.cBw = (x.p(list) - p) - i2;
        }
    }

    private void be(List<t> list) {
        if (list != null) {
            Collections.sort(list, new b(this));
        }
    }

    private List<v> h(List<ThreadInfo> list, List<t> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                bi biVar = new bi();
                biVar.a(threadInfo);
                biVar.bX(1);
                if (!TextUtils.isEmpty(biVar.tj())) {
                    ah ahVar = new ah();
                    ahVar.co(biVar.tj());
                    linkedList.add(ahVar);
                } else {
                    com.baidu.tieba.card.data.c B = e.B(biVar);
                    if (B != null) {
                        B.WT = biVar.getTid();
                    }
                    if (B != null && B.isValid()) {
                        linkedList.add(B);
                    }
                }
            }
        }
        for (int p = x.p(list2) - 1; p >= 0; p--) {
            t tVar = (t) x.c(list2, p);
            if (tVar != null && linkedList.size() >= tVar.getPosition() && tVar.getPosition() > 0) {
                linkedList.add(tVar.getPosition() - 1, tVar);
            }
        }
        return linkedList;
    }

    private void a(DataRes.Builder builder, int i, int i2) {
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int p = (x.p(list) - i2) + 30;
                while (true) {
                    p--;
                    if (p >= 30) {
                        if (list.size() > p) {
                            list.remove(p);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int p2 = x.p(list) - 1; p2 >= i2; p2--) {
                    list.remove(p2);
                }
            }
        }
    }

    private void a(List<v> list, DataRes.Builder builder) {
        com.baidu.tieba.homepage.personalize.data.f b;
        if (builder != null && list != null) {
            if (!com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("close_new_user_guide_tip", false) && builder.age_sex != null) {
                com.baidu.tieba.homepage.personalize.data.h c = com.baidu.tieba.homepage.personalize.data.h.c(builder);
                if (c != null) {
                    list.add(0, c);
                }
            } else if (builder.interestion != null && builder.interestion.size() > 0 && (b = com.baidu.tieba.homepage.personalize.data.f.b(builder)) != null) {
                list.add(0, b);
            }
        }
    }
}
