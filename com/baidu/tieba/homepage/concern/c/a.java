package com.baidu.tieba.homepage.concern.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.homepage.personalize.b.d;
import com.baidu.tieba.homepage.personalize.model.c;
import java.util.LinkedList;
import java.util.List;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class a {
    private d cWC = new d();
    private final c cWB = new c();
    private final int bgF = b.getInstance().getInt("home_page_max_thread_count", 300);

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
                bh bhVar = new bh();
                bhVar.a(concernData.thread_list);
                if (n.A(bhVar)) {
                    n nVar = new n(bhVar);
                    if (nVar != null) {
                        nVar.Xf = bhVar.getTid();
                    }
                    if (nVar != null && nVar.isValid()) {
                        linkedList.add(nVar);
                    }
                } else if (k.A(bhVar)) {
                    k kVar = new k(bhVar);
                    if (kVar != null) {
                        kVar.Xf = bhVar.getTid();
                        kVar.js(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                    }
                    if (kVar != null && kVar.isValid()) {
                        linkedList.add(kVar);
                    }
                } else {
                    l lVar = new l();
                    if (lVar != null) {
                        lVar.threadData = bhVar;
                        lVar.js(lVar.threadData.isLinkThread() ? "4" : "1");
                        lVar.isLinkThread = false;
                    }
                    if (lVar.threadData != null && lVar.isValid() && !StringUtils.isNull(lVar.threadData.getId()) && !"0".equals(lVar.threadData.getTid())) {
                        linkedList.add(lVar);
                    }
                }
            }
        }
        this.cWB.aUB = linkedList;
        return this.cWB;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            a(z, builder.thread_info, builder2.thread_info, i);
        }
    }

    private void a(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        if (list != null && list2 != null) {
            int t = v.t(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (concernData != null && concernData.thread_list.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                list.clear();
                for (int t2 = v.t(list2) - 1; t2 >= 0; t2--) {
                    ConcernData concernData2 = (ConcernData) v.c(list2, t2);
                    if (concernData2 != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.cWB.daE = v.t(list) - t;
        }
    }

    public static void c(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
