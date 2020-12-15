package com.baidu.tieba.enterForum.tabfeed.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes22.dex */
public class a {
    private ArrayList<q> iBt;
    private ArrayList<bs> iBu;
    private bl iBv;
    private c iBw;
    private boolean iBx;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iBt = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                by byVar = new by();
                byVar.a(threadInfo);
                byVar.bor();
                this.iBt.add(byVar);
            }
            this.iBu = new ArrayList<>();
            if (!y.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bs bsVar = new bs();
                    bsVar.a(generalResource);
                    this.iBu.add(bsVar);
                }
            }
            this.iBv = new bl();
            this.iBv.bm(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.iBw = new c();
                this.iBw.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.iBw.module_name = dataRes.hot_userrank_entry.module_name;
                this.iBw.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.iBx = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<q> cwN() {
        return this.iBt;
    }

    public ArrayList<bs> cwO() {
        return this.iBu;
    }

    public bl cwP() {
        return this.iBv;
    }

    public c cwQ() {
        return this.iBw;
    }

    public boolean cwR() {
        return this.iBx;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cwS */
    public a clone() {
        a aVar = new a();
        aVar.iBt = this.iBt;
        aVar.iBu = this.iBu;
        aVar.iBv = this.iBv;
        aVar.iBw = this.iBw;
        aVar.iBx = this.iBx;
        return aVar;
    }
}
