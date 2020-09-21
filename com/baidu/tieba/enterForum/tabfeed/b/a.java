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
/* loaded from: classes21.dex */
public class a {
    private ArrayList<q> hIr;
    private ArrayList<bq> hIs;
    private bj hIt;
    private c hIu;
    private boolean hIv;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hIr = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                bwVar.bfa();
                this.hIr.add(bwVar);
            }
            this.hIs = new ArrayList<>();
            if (!y.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bq bqVar = new bq();
                    bqVar.a(generalResource);
                    this.hIs.add(bqVar);
                }
            }
            this.hIt = new bj();
            this.hIt.aP(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.hIu = new c();
                this.hIu.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.hIu.module_name = dataRes.hot_userrank_entry.module_name;
                this.hIu.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.hIv = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<q> cjQ() {
        return this.hIr;
    }

    public ArrayList<bq> cjR() {
        return this.hIs;
    }

    public bj cjS() {
        return this.hIt;
    }

    public c cjT() {
        return this.hIu;
    }

    public boolean cjU() {
        return this.hIv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cjV */
    public a clone() {
        a aVar = new a();
        aVar.hIr = this.hIr;
        aVar.hIs = this.hIs;
        aVar.hIt = this.hIt;
        aVar.hIu = this.hIu;
        aVar.hIv = this.hIv;
        return aVar;
    }
}
