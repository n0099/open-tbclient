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
    private ArrayList<q> iBr;
    private ArrayList<bs> iBs;
    private bl iBt;
    private c iBu;
    private boolean iBv;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iBr = new ArrayList<>(y.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                by byVar = new by();
                byVar.a(threadInfo);
                byVar.bor();
                this.iBr.add(byVar);
            }
            this.iBs = new ArrayList<>();
            if (!y.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bs bsVar = new bs();
                    bsVar.a(generalResource);
                    this.iBs.add(bsVar);
                }
            }
            this.iBt = new bl();
            this.iBt.bm(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.iBu = new c();
                this.iBu.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.iBu.module_name = dataRes.hot_userrank_entry.module_name;
                this.iBu.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.iBv = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<q> cwM() {
        return this.iBr;
    }

    public ArrayList<bs> cwN() {
        return this.iBs;
    }

    public bl cwO() {
        return this.iBt;
    }

    public c cwP() {
        return this.iBu;
    }

    public boolean cwQ() {
        return this.iBv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cwR */
    public a clone() {
        a aVar = new a();
        aVar.iBr = this.iBr;
        aVar.iBs = this.iBs;
        aVar.iBt = this.iBt;
        aVar.iBu = this.iBu;
        aVar.iBv = this.iBv;
        return aVar;
    }
}
