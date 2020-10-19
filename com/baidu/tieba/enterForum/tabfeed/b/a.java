package com.baidu.tieba.enterForum.tabfeed.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes22.dex */
public class a {
    private ArrayList<q> hXm;
    private ArrayList<bq> hXn;
    private bj hXo;
    private c hXp;
    private boolean hXq;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hXm = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                bwVar.bhJ();
                this.hXm.add(bwVar);
            }
            this.hXn = new ArrayList<>();
            if (!y.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bq bqVar = new bq();
                    bqVar.a(generalResource);
                    this.hXn.add(bqVar);
                }
            }
            this.hXo = new bj();
            this.hXo.aS(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.hXp = new c();
                this.hXp.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.hXp.module_name = dataRes.hot_userrank_entry.module_name;
                this.hXp.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.hXq = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<q> cnm() {
        return this.hXm;
    }

    public ArrayList<bq> cnn() {
        return this.hXn;
    }

    public bj cno() {
        return this.hXo;
    }

    public c cnp() {
        return this.hXp;
    }

    public boolean cnq() {
        return this.hXq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cnr */
    public a clone() {
        a aVar = new a();
        aVar.hXm = this.hXm;
        aVar.hXn = this.hXn;
        aVar.hXo = this.hXo;
        aVar.hXp = this.hXp;
        aVar.hXq = this.hXq;
        return aVar;
    }
}
