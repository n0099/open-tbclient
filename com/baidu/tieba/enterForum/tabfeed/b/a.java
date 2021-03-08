package com.baidu.tieba.enterForum.tabfeed.b;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class a {
    private ArrayList<n> iQD;
    private ArrayList<bv> iQE;
    private bo iQF;
    private c iQG;
    private boolean iQH;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iQD = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                cb cbVar = new cb();
                cbVar.a(threadInfo);
                cbVar.bnu();
                this.iQD.add(cbVar);
            }
            this.iQE = new ArrayList<>();
            if (!y.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bv bvVar = new bv();
                    bvVar.a(generalResource);
                    this.iQE.add(bvVar);
                }
            }
            this.iQF = new bo();
            this.iQF.bo(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.iQG = new c();
                this.iQG.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.iQG.module_name = dataRes.hot_userrank_entry.module_name;
                this.iQG.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.iQH = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<n> cxo() {
        return this.iQD;
    }

    public ArrayList<bv> cxp() {
        return this.iQE;
    }

    public bo cxq() {
        return this.iQF;
    }

    public c cxr() {
        return this.iQG;
    }

    public boolean cxs() {
        return this.iQH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cxt */
    public a clone() {
        a aVar = new a();
        aVar.iQD = this.iQD;
        aVar.iQE = this.iQE;
        aVar.iQF = this.iQF;
        aVar.iQG = this.iQG;
        aVar.iQH = this.iQH;
        return aVar;
    }
}
