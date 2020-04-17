package com.baidu.tieba.enterForum.tabfeed.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.enterForum.data.l;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class a {
    private ArrayList<m> gGU;
    private ArrayList<d> gGV;
    private l gGW;
    private c gGX;
    private boolean gGY;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gGU = new ArrayList<>(v.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bj bjVar = new bj();
                bjVar.a(threadInfo);
                this.gGU.add(bjVar);
            }
            this.gGV = new ArrayList<>();
            if (!v.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    d dVar = new d();
                    dVar.a(generalResource);
                    this.gGV.add(dVar);
                }
            }
            this.gGW = new l();
            this.gGW.bU(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.gGX = new c();
                this.gGX.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.gGX.module_name = dataRes.hot_userrank_entry.module_name;
                this.gGX.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.gGY = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<m> bJy() {
        return this.gGU;
    }

    public ArrayList<d> bJz() {
        return this.gGV;
    }

    public l bJA() {
        return this.gGW;
    }

    public c bJB() {
        return this.gGX;
    }

    public boolean bJC() {
        return this.gGY;
    }
}
