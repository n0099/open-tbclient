package com.baidu.tieba.homepage.concern.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.homepage.personalize.model.c;
import java.util.LinkedList;
import java.util.List;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class a {
    private final c eaY = new c();
    private final int cai = b.getInstance().getInt("home_page_max_thread_count", 300);

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
        c(builder);
        c(builder2);
        b(z, builder, builder2, i);
        LinkedList linkedList = new LinkedList();
        for (ConcernData concernData : builder.thread_info) {
            if (concernData != null) {
                be beVar = new be();
                beVar.a(concernData.thread_list);
                if (beVar.isShareThread) {
                    l lVar = new l();
                    lVar.threadData = beVar;
                    linkedList.add(lVar);
                } else if (n.J(beVar)) {
                    n nVar = new n(beVar);
                    if (nVar != null) {
                        nVar.tid = beVar.getTid();
                    }
                    if (nVar != null && nVar.isValid()) {
                        linkedList.add(nVar);
                    }
                } else if (k.J(beVar)) {
                    k kVar = new k(beVar);
                    if (kVar != null) {
                        kVar.tid = beVar.getTid();
                        kVar.jY("3");
                    }
                    if (kVar != null && kVar.isValid()) {
                        linkedList.add(kVar);
                    }
                } else {
                    l lVar2 = new l();
                    if (lVar2 != null) {
                        lVar2.threadData = beVar;
                        lVar2.jY(lVar2.threadData.isLinkThread() ? "4" : "1");
                        lVar2.isLinkThread = false;
                    }
                    if (lVar2.threadData != null && lVar2.isValid() && !StringUtils.isNull(lVar2.threadData.getId()) && !"0".equals(lVar2.threadData.getTid())) {
                        linkedList.add(lVar2);
                    }
                }
            }
        }
        this.eaY.bLw = linkedList;
        return this.eaY;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            a(z, builder.thread_info, builder2.thread_info, i);
        }
    }

    private void a(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        if (list != null && list2 != null) {
            int F = v.F(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (concernData != null && concernData.thread_list.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                list.clear();
                for (int F2 = v.F(list2) - 1; F2 >= 0; F2--) {
                    ConcernData concernData2 = (ConcernData) v.f(list2, F2);
                    if (concernData2 != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.eaY.eeL = v.F(list) - F;
        }
    }

    public static void c(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
