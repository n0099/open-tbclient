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
    private ArrayList<q> hBp;
    private ArrayList<bq> hBq;
    private bj hBr;
    private c hBs;
    private boolean hBt;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hBp = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                bwVar.beg();
                this.hBp.add(bwVar);
            }
            this.hBq = new ArrayList<>();
            if (!y.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bq bqVar = new bq();
                    bqVar.a(generalResource);
                    this.hBq.add(bqVar);
                }
            }
            this.hBr = new bj();
            this.hBr.aL(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.hBs = new c();
                this.hBs.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.hBs.module_name = dataRes.hot_userrank_entry.module_name;
                this.hBs.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.hBt = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<q> cgB() {
        return this.hBp;
    }

    public ArrayList<bq> cgC() {
        return this.hBq;
    }

    public bj cgD() {
        return this.hBr;
    }

    public c cgE() {
        return this.hBs;
    }

    public boolean cgF() {
        return this.hBt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cgG */
    public a clone() {
        a aVar = new a();
        aVar.hBp = this.hBp;
        aVar.hBq = this.hBq;
        aVar.hBr = this.hBr;
        aVar.hBs = this.hBs;
        aVar.hBt = this.hBt;
        return aVar;
    }
}
