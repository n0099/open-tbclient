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
    private ArrayList<n> iOG;
    private ArrayList<bv> iOH;
    private bo iOI;
    private c iOJ;
    private boolean iOK;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iOG = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                cb cbVar = new cb();
                cbVar.a(threadInfo);
                cbVar.bns();
                this.iOG.add(cbVar);
            }
            this.iOH = new ArrayList<>();
            if (!y.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bv bvVar = new bv();
                    bvVar.a(generalResource);
                    this.iOH.add(bvVar);
                }
            }
            this.iOI = new bo();
            this.iOI.bo(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.iOJ = new c();
                this.iOJ.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.iOJ.module_name = dataRes.hot_userrank_entry.module_name;
                this.iOJ.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.iOK = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<n> cxb() {
        return this.iOG;
    }

    public ArrayList<bv> cxc() {
        return this.iOH;
    }

    public bo cxd() {
        return this.iOI;
    }

    public c cxe() {
        return this.iOJ;
    }

    public boolean cxf() {
        return this.iOK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cxg */
    public a clone() {
        a aVar = new a();
        aVar.iOG = this.iOG;
        aVar.iOH = this.iOH;
        aVar.iOI = this.iOI;
        aVar.iOJ = this.iOJ;
        aVar.iOK = this.iOK;
        return aVar;
    }
}
