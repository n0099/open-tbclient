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
    private ArrayList<n> iNF;
    private ArrayList<bt> iNG;
    private bm iNH;
    private c iNI;
    private boolean iNJ;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iNF = new ArrayList<>(x.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bz bzVar = new bz();
                bzVar.a(threadInfo);
                bzVar.bqS();
                this.iNF.add(bzVar);
            }
            this.iNG = new ArrayList<>();
            if (!x.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bt btVar = new bt();
                    btVar.a(generalResource);
                    this.iNG.add(btVar);
                }
            }
            this.iNH = new bm();
            this.iNH.bt(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.iNI = new c();
                this.iNI.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.iNI.module_name = dataRes.hot_userrank_entry.module_name;
                this.iNI.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.iNJ = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<n> czG() {
        return this.iNF;
    }

    public ArrayList<bt> czH() {
        return this.iNG;
    }

    public bm czI() {
        return this.iNH;
    }

    public c czJ() {
        return this.iNI;
    }

    public boolean czK() {
        return this.iNJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: czL */
    public a clone() {
        a aVar = new a();
        aVar.iNF = this.iNF;
        aVar.iNG = this.iNG;
        aVar.iNH = this.iNH;
        aVar.iNI = this.iNI;
        aVar.iNJ = this.iNJ;
        return aVar;
    }
}
