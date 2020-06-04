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
    private ArrayList<o> gVS;
    private ArrayList<d> gVT;
    private l gVU;
    private c gVV;
    private boolean gVW;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gVS = new ArrayList<>(v.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bk bkVar = new bk();
                bkVar.a(threadInfo);
                this.gVS.add(bkVar);
            }
            this.gVT = new ArrayList<>();
            if (!v.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    d dVar = new d();
                    dVar.a(generalResource);
                    this.gVT.add(dVar);
                }
            }
            this.gVU = new l();
            this.gVU.bR(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.gVV = new c();
                this.gVV.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.gVV.module_name = dataRes.hot_userrank_entry.module_name;
                this.gVV.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.gVW = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<o> bPS() {
        return this.gVS;
    }

    public ArrayList<d> bPT() {
        return this.gVT;
    }

    public l bPU() {
        return this.gVU;
    }

    public c bPV() {
        return this.gVV;
    }

    public boolean bPW() {
        return this.gVW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: bPX */
    public a clone() {
        a aVar = new a();
        aVar.gVS = this.gVS;
        aVar.gVT = this.gVT;
        aVar.gVU = this.gVU;
        aVar.gVV = this.gVV;
        aVar.gVW = this.gVW;
        return aVar;
    }
}
