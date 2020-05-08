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
    private ArrayList<m> gHa;
    private ArrayList<d> gHb;
    private l gHc;
    private c gHd;
    private boolean gHe;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gHa = new ArrayList<>(v.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bj bjVar = new bj();
                bjVar.a(threadInfo);
                this.gHa.add(bjVar);
            }
            this.gHb = new ArrayList<>();
            if (!v.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    d dVar = new d();
                    dVar.a(generalResource);
                    this.gHb.add(dVar);
                }
            }
            this.gHc = new l();
            this.gHc.bU(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.gHd = new c();
                this.gHd.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.gHd.module_name = dataRes.hot_userrank_entry.module_name;
                this.gHd.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.gHe = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<m> bJw() {
        return this.gHa;
    }

    public ArrayList<d> bJx() {
        return this.gHb;
    }

    public l bJy() {
        return this.gHc;
    }

    public c bJz() {
        return this.gHd;
    }

    public boolean bJA() {
        return this.gHe;
    }
}
