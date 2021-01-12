package com.baidu.tieba.enterForum.tabfeed.b;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class a {
    private ArrayList<n> iIY;
    private ArrayList<bt> iIZ;
    private bm iJa;
    private c iJb;
    private boolean iJc;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iIY = new ArrayList<>(x.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bz bzVar = new bz();
                bzVar.a(threadInfo);
                bzVar.bmZ();
                this.iIY.add(bzVar);
            }
            this.iIZ = new ArrayList<>();
            if (!x.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bt btVar = new bt();
                    btVar.a(generalResource);
                    this.iIZ.add(btVar);
                }
            }
            this.iJa = new bm();
            this.iJa.bt(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.iJb = new c();
                this.iJb.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.iJb.module_name = dataRes.hot_userrank_entry.module_name;
                this.iJb.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.iJc = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<n> cvP() {
        return this.iIY;
    }

    public ArrayList<bt> cvQ() {
        return this.iIZ;
    }

    public bm cvR() {
        return this.iJa;
    }

    public c cvS() {
        return this.iJb;
    }

    public boolean cvT() {
        return this.iJc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cvU */
    public a clone() {
        a aVar = new a();
        aVar.iIY = this.iIY;
        aVar.iIZ = this.iIZ;
        aVar.iJa = this.iJa;
        aVar.iJb = this.iJb;
        aVar.iJc = this.iJc;
        return aVar;
    }
}
