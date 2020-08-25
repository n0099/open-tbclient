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
/* loaded from: classes16.dex */
public class a {
    private ArrayList<q> hBj;
    private ArrayList<bq> hBk;
    private bj hBl;
    private c hBm;
    private boolean hBn;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hBj = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                bwVar.beg();
                this.hBj.add(bwVar);
            }
            this.hBk = new ArrayList<>();
            if (!y.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bq bqVar = new bq();
                    bqVar.a(generalResource);
                    this.hBk.add(bqVar);
                }
            }
            this.hBl = new bj();
            this.hBl.aL(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.hBm = new c();
                this.hBm.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.hBm.module_name = dataRes.hot_userrank_entry.module_name;
                this.hBm.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.hBn = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<q> cgA() {
        return this.hBj;
    }

    public ArrayList<bq> cgB() {
        return this.hBk;
    }

    public bj cgC() {
        return this.hBl;
    }

    public c cgD() {
        return this.hBm;
    }

    public boolean cgE() {
        return this.hBn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cgF */
    public a clone() {
        a aVar = new a();
        aVar.hBj = this.hBj;
        aVar.hBk = this.hBk;
        aVar.hBl = this.hBl;
        aVar.hBm = this.hBm;
        aVar.hBn = this.hBn;
        return aVar;
    }
}
