package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.z;
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
    private com.baidu.tieba.homepage.personalize.c.f cKQ = new com.baidu.tieba.homepage.personalize.c.f();
    private final d cKP = new d();
    private final int bbY = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_page_max_thread_count", 300);

    public int amR() {
        return this.bbY;
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
        a(builder, i, this.bbY);
        e.g(builder);
        List<r> e = e.e(builder);
        bh(e);
        List<v> l = l(builder.thread_list, e);
        this.cKQ.bj(l);
        a(l, builder);
        c.a(builder, l);
        this.cKP.aRy = l;
        return this.cKP;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            a(z, builder.thread_list, builder2.thread_list, i);
            a(builder, builder2, i);
            k(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void k(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
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
            int s = z.s(list);
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
                int s2 = z.s(list2) - 1;
                i2 = 0;
                while (s2 >= 0) {
                    this.cKQ.a(z, s2, list, list2);
                    ThreadInfo threadInfo3 = (ThreadInfo) z.c(list2, s2);
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
            this.cKP.cKS = (z.s(list) - s) - i2;
        }
    }

    private void bh(List<r> list) {
        if (list != null) {
            Collections.sort(list, new b(this));
        }
    }

    private List<v> l(List<ThreadInfo> list, List<r> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                bm bmVar = new bm();
                bmVar.a(threadInfo);
                bmVar.bW(1);
                if (!TextUtils.isEmpty(bmVar.sm())) {
                    ai aiVar = new ai();
                    aiVar.ct(bmVar.sm());
                    linkedList.add(aiVar);
                } else {
                    com.baidu.tieba.card.data.c M = e.M(bmVar);
                    if (M != null) {
                        M.Wg = bmVar.getTid();
                    }
                    if (M != null && M.isValid()) {
                        linkedList.add(M);
                    }
                }
            }
        }
        for (int s = z.s(list2) - 1; s >= 0; s--) {
            r rVar = (r) z.c(list2, s);
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
                int s = (z.s(list) - i2) + 30;
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
                for (int s2 = z.s(list) - 1; s2 >= i2; s2--) {
                    list.remove(s2);
                }
            }
        }
    }

    private void a(List<v> list, DataRes.Builder builder) {
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
