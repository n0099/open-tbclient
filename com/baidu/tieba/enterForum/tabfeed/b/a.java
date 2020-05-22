package com.baidu.tieba.enterForum.tabfeed.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.enterForum.data.l;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class a {
    private ArrayList<o> gVH;
    private ArrayList<d> gVI;
    private l gVJ;
    private c gVK;
    private boolean gVL;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gVH = new ArrayList<>(v.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bk bkVar = new bk();
                bkVar.a(threadInfo);
                this.gVH.add(bkVar);
            }
            this.gVI = new ArrayList<>();
            if (!v.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    d dVar = new d();
                    dVar.a(generalResource);
                    this.gVI.add(dVar);
                }
            }
            this.gVJ = new l();
            this.gVJ.bR(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.gVK = new c();
                this.gVK.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.gVK.module_name = dataRes.hot_userrank_entry.module_name;
                this.gVK.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.gVL = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<o> bPQ() {
        return this.gVH;
    }

    public ArrayList<d> bPR() {
        return this.gVI;
    }

    public l bPS() {
        return this.gVJ;
    }

    public c bPT() {
        return this.gVK;
    }

    public boolean bPU() {
        return this.gVL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: bPV */
    public a clone() {
        a aVar = new a();
        aVar.gVH = this.gVH;
        aVar.gVI = this.gVI;
        aVar.gVJ = this.gVJ;
        aVar.gVK = this.gVK;
        aVar.gVL = this.gVL;
        return aVar;
    }
}
