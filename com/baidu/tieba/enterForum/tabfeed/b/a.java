package com.baidu.tieba.enterForum.tabfeed.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes21.dex */
public class a {
    private ArrayList<br> iqA;
    private bk iqB;
    private c iqC;
    private boolean iqD;
    private ArrayList<q> iqz;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iqz = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bx bxVar = new bx();
                bxVar.a(threadInfo);
                bxVar.ble();
                this.iqz.add(bxVar);
            }
            this.iqA = new ArrayList<>();
            if (!y.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    br brVar = new br();
                    brVar.a(generalResource);
                    this.iqA.add(brVar);
                }
            }
            this.iqB = new bk();
            this.iqB.bj(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.iqC = new c();
                this.iqC.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.iqC.module_name = dataRes.hot_userrank_entry.module_name;
                this.iqC.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.iqD = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<q> csx() {
        return this.iqz;
    }

    public ArrayList<br> csy() {
        return this.iqA;
    }

    public bk csz() {
        return this.iqB;
    }

    public c csA() {
        return this.iqC;
    }

    public boolean csB() {
        return this.iqD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: csC */
    public a clone() {
        a aVar = new a();
        aVar.iqz = this.iqz;
        aVar.iqA = this.iqA;
        aVar.iqB = this.iqB;
        aVar.iqC = this.iqC;
        aVar.iqD = this.iqD;
        return aVar;
    }
}
