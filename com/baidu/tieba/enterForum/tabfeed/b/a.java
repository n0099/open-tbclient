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
    private ArrayList<q> ipL;
    private ArrayList<bq> ipM;
    private bj ipN;
    private c ipO;
    private boolean ipP;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ipL = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                bwVar.bmc();
                this.ipL.add(bwVar);
            }
            this.ipM = new ArrayList<>();
            if (!y.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bq bqVar = new bq();
                    bqVar.a(generalResource);
                    this.ipM.add(bqVar);
                }
            }
            this.ipN = new bj();
            this.ipN.bj(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.ipO = new c();
                this.ipO.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.ipO.module_name = dataRes.hot_userrank_entry.module_name;
                this.ipO.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.ipP = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<q> csU() {
        return this.ipL;
    }

    public ArrayList<bq> csV() {
        return this.ipM;
    }

    public bj csW() {
        return this.ipN;
    }

    public c csX() {
        return this.ipO;
    }

    public boolean csY() {
        return this.ipP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: csZ */
    public a clone() {
        a aVar = new a();
        aVar.ipL = this.ipL;
        aVar.ipM = this.ipM;
        aVar.ipN = this.ipN;
        aVar.ipO = this.ipO;
        aVar.ipP = this.ipP;
        return aVar;
    }
}
