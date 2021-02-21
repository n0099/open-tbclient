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
    private ArrayList<n> iOU;
    private ArrayList<bv> iOV;
    private bo iOW;
    private c iOX;
    private boolean iOY;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iOU = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                cb cbVar = new cb();
                cbVar.a(threadInfo);
                cbVar.bns();
                this.iOU.add(cbVar);
            }
            this.iOV = new ArrayList<>();
            if (!y.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bv bvVar = new bv();
                    bvVar.a(generalResource);
                    this.iOV.add(bvVar);
                }
            }
            this.iOW = new bo();
            this.iOW.bo(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.iOX = new c();
                this.iOX.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.iOX.module_name = dataRes.hot_userrank_entry.module_name;
                this.iOX.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.iOY = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<n> cxi() {
        return this.iOU;
    }

    public ArrayList<bv> cxj() {
        return this.iOV;
    }

    public bo cxk() {
        return this.iOW;
    }

    public c cxl() {
        return this.iOX;
    }

    public boolean cxm() {
        return this.iOY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cxn */
    public a clone() {
        a aVar = new a();
        aVar.iOU = this.iOU;
        aVar.iOV = this.iOV;
        aVar.iOW = this.iOW;
        aVar.iOX = this.iOX;
        aVar.iOY = this.iOY;
        return aVar;
    }
}
