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
    private ArrayList<q> ijM;
    private ArrayList<bq> ijN;
    private bj ijO;
    private c ijP;
    private boolean ijQ;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ijM = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                bwVar.bjC();
                this.ijM.add(bwVar);
            }
            this.ijN = new ArrayList<>();
            if (!y.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bq bqVar = new bq();
                    bqVar.a(generalResource);
                    this.ijN.add(bqVar);
                }
            }
            this.ijO = new bj();
            this.ijO.bc(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.ijP = new c();
                this.ijP.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.ijP.module_name = dataRes.hot_userrank_entry.module_name;
                this.ijP.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.ijQ = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<q> cqt() {
        return this.ijM;
    }

    public ArrayList<bq> cqu() {
        return this.ijN;
    }

    public bj cqv() {
        return this.ijO;
    }

    public c cqw() {
        return this.ijP;
    }

    public boolean cqx() {
        return this.ijQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cqy */
    public a clone() {
        a aVar = new a();
        aVar.ijM = this.ijM;
        aVar.ijN = this.ijN;
        aVar.ijO = this.ijO;
        aVar.ijP = this.ijP;
        aVar.ijQ = this.ijQ;
        return aVar;
    }
}
