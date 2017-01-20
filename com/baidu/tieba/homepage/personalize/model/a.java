package com.baidu.tieba.homepage.personalize.model;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.w;
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
    private com.baidu.tieba.homepage.personalize.c.f czh = new com.baidu.tieba.homepage.personalize.c.f();
    private final d czf = new d();
    private final int czg = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("home_page_max_thread_count", 300);

    public int akx() {
        return this.czg;
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
        e.e(builder);
        e.e(builder2);
        b(z, builder, builder2, i);
        a(builder, i, this.czg);
        e.f(builder);
        List<t> d = e.d(builder);
        bx(d);
        List<v> i2 = i(builder.thread_list, d);
        this.czh.bz(i2);
        a(i2, builder);
        c.a(builder, i2);
        this.czf.aJL = i2;
        return this.czf;
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
            int r = w.r(list);
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
                int r2 = w.r(list2) - 1;
                i2 = 0;
                while (r2 >= 0) {
                    this.czh.a(z, r2, list, list2);
                    ThreadInfo threadInfo3 = (ThreadInfo) w.c(list2, r2);
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
                    r2--;
                    i2 = i3;
                }
            }
            this.czf.czj = (w.r(list) - r) - i2;
        }
    }

    private void bx(List<t> list) {
        if (list != null) {
            Collections.sort(list, new b(this));
        }
    }

    private List<v> i(List<ThreadInfo> list, List<t> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                bh bhVar = new bh();
                bhVar.a(threadInfo);
                bhVar.aW(1);
                if (!TextUtils.isEmpty(bhVar.sq())) {
                    ah ahVar = new ah();
                    ahVar.co(bhVar.sq());
                    linkedList.add(ahVar);
                } else {
                    com.baidu.tieba.card.data.c D = e.D(bhVar);
                    if (D != null) {
                        D.SK = bhVar.getTid();
                    }
                    if (D != null && D.isValid()) {
                        linkedList.add(D);
                    }
                }
            }
        }
        for (int r = w.r(list2) - 1; r >= 0; r--) {
            t tVar = (t) w.c(list2, r);
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
                int r = (w.r(list) - i2) + 30;
                while (true) {
                    r--;
                    if (r >= 30) {
                        if (list.size() > r) {
                            list.remove(r);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int r2 = w.r(list) - 1; r2 >= i2; r2--) {
                    list.remove(r2);
                }
            }
        }
    }

    private void a(List<v> list, DataRes.Builder builder) {
        com.baidu.tieba.homepage.personalize.data.f a;
        if (builder != null && list != null) {
            if (!com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("close_new_user_guide_tip", false) && builder.age_sex != null) {
                com.baidu.tieba.homepage.personalize.data.h b = com.baidu.tieba.homepage.personalize.data.h.b(builder);
                if (b != null) {
                    list.add(0, b);
                }
            } else if (builder.interestion != null && builder.interestion.size() > 0 && (a = com.baidu.tieba.homepage.personalize.data.f.a(builder)) != null) {
                list.add(0, a);
            }
        }
    }
}
