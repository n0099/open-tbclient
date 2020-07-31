package com.baidu.tieba.enterForum.tabfeed.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes16.dex */
public class a {
    private ArrayList<q> hos;
    private ArrayList<bp> hot;
    private bi hou;
    private c hov;
    private boolean how;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hos = new ArrayList<>(x.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bv bvVar = new bv();
                bvVar.a(threadInfo);
                bvVar.aVN();
                this.hos.add(bvVar);
            }
            this.hot = new ArrayList<>();
            if (!x.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bp bpVar = new bp();
                    bpVar.a(generalResource);
                    this.hot.add(bpVar);
                }
            }
            this.hou = new bi();
            this.hou.aL(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.hov = new c();
                this.hov.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.hov.module_name = dataRes.hot_userrank_entry.module_name;
                this.hov.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.how = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<q> bWn() {
        return this.hos;
    }

    public ArrayList<bp> bWo() {
        return this.hot;
    }

    public bi bWp() {
        return this.hou;
    }

    public c bWq() {
        return this.hov;
    }

    public boolean bWr() {
        return this.how;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: bWs */
    public a clone() {
        a aVar = new a();
        aVar.hos = this.hos;
        aVar.hot = this.hot;
        aVar.hou = this.hou;
        aVar.hov = this.hov;
        aVar.how = this.how;
        return aVar;
    }
}
