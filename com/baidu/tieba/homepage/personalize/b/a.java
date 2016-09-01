package com.baidu.tieba.homepage.personalize.b;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.s;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.homepage.personalize.c.f cGU = new com.baidu.tieba.homepage.personalize.c.f();
    private final d cGS = new d();
    private final int cGT = com.baidu.tbadk.core.sharedPref.b.tS().getInt("home_page_max_thread_count", 300);

    public int amH() {
        return this.cGT;
    }

    public d a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        return a(z, builder, builder2, i, this.cGT);
    }

    public d a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i, int i2) {
        if (i != 0 && i != 1) {
            return null;
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        if (builder2 == null) {
            builder2 = new DataRes.Builder();
        }
        e.e(builder);
        e.e(builder2);
        b(z, builder, builder2, i);
        a(builder, i, i2);
        e.f(builder);
        e.f(builder2);
        List<s> d = e.d(builder);
        bw(d);
        List<v> i3 = i(builder.thread_list, d);
        this.cGU.by(i3);
        a(i3, builder);
        c.a(builder, i3);
        this.cGS.cGW = i3;
        return this.cGS;
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
            e.c(builder);
        }
        e.a(builder, builder2);
    }

    private void a(boolean z, List<ThreadInfo> list, List<ThreadInfo> list2, int i) {
        int i2;
        int i3;
        if (list != null && list2 != null) {
            int s = y.s(list);
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
                int s2 = y.s(list2) - 1;
                i2 = 0;
                while (s2 >= 0) {
                    this.cGU.a(z, s2, list, list2);
                    ThreadInfo threadInfo3 = (ThreadInfo) y.c(list2, s2);
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
                    s2--;
                    i2 = i3;
                }
            }
            this.cGS.cGX = (y.s(list) - s) - i2;
        }
    }

    private void bw(List<s> list) {
        if (list != null) {
            Collections.sort(list, new b(this));
        }
    }

    private List<v> i(List<ThreadInfo> list, List<s> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                bg bgVar = new bg();
                bgVar.a(threadInfo);
                if (!TextUtils.isEmpty(bgVar.sv())) {
                    ad adVar = new ad();
                    adVar.cn(bgVar.sv());
                    linkedList.add(adVar);
                } else {
                    com.baidu.tieba.card.data.c q = e.q(bgVar);
                    if (q != null) {
                        q.Tt = bgVar.getTid();
                    }
                    if (q != null && q.isValid()) {
                        linkedList.add(q);
                    }
                }
            }
        }
        for (int s = y.s(list2) - 1; s >= 0; s--) {
            s sVar = (s) y.c(list2, s);
            if (sVar != null && linkedList.size() >= sVar.getPosition() && sVar.getPosition() > 0) {
                linkedList.add(sVar.getPosition() - 1, sVar);
            }
        }
        return linkedList;
    }

    private void a(DataRes.Builder builder, int i, int i2) {
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int s = (y.s(list) - i2) + 30;
                while (true) {
                    s--;
                    if (s >= 30) {
                        if (list.size() > s) {
                            list.remove(s);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int s2 = y.s(list) - 1; s2 >= i2; s2--) {
                    list.remove(s2);
                }
            }
        }
    }

    private void a(List<v> list, DataRes.Builder builder) {
        com.baidu.tieba.homepage.personalize.data.h a;
        if (builder != null && list != null) {
            if (!com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("close_new_user_guide_tip", false) && builder.age_sex != null) {
                com.baidu.tieba.homepage.personalize.data.j b = com.baidu.tieba.homepage.personalize.data.j.b(builder);
                if (b != null) {
                    list.add(0, b);
                }
            } else if (builder.interestion != null && builder.interestion.size() > 0 && (a = com.baidu.tieba.homepage.personalize.data.h.a(builder)) != null) {
                list.add(0, a);
            }
        }
    }
}
