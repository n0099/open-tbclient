package com.baidu.tieba.enterForum.tabfeed.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class a {
    private ArrayList<q> hiJ;
    private ArrayList<bo> hiK;
    private bh hiL;
    private c hiM;
    private boolean hiN;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hiJ = new ArrayList<>(w.getCount(dataRes.thread_list));
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                bu buVar = new bu();
                buVar.a(threadInfo);
                buVar.aRR();
                this.hiJ.add(buVar);
            }
            this.hiK = new ArrayList<>();
            if (!w.isEmpty(dataRes.resource_list)) {
                for (GeneralResource generalResource : dataRes.resource_list) {
                    bo boVar = new bo();
                    boVar.a(generalResource);
                    this.hiK.add(boVar);
                }
            }
            this.hiL = new bh();
            this.hiL.aE(dataRes.recommend_forum_info);
            if (dataRes.hot_userrank_entry != null) {
                this.hiM = new c();
                this.hiM.hot_user = dataRes.hot_userrank_entry.hot_user;
                this.hiM.module_name = dataRes.hot_userrank_entry.module_name;
                this.hiM.module_icon = dataRes.hot_userrank_entry.module_icon;
            }
            this.hiN = dataRes.is_new_url.intValue() == 1;
        }
    }

    public ArrayList<q> bSW() {
        return this.hiJ;
    }

    public ArrayList<bo> bSX() {
        return this.hiK;
    }

    public bh bSY() {
        return this.hiL;
    }

    public c bSZ() {
        return this.hiM;
    }

    public boolean bTa() {
        return this.hiN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: bTb */
    public a clone() {
        a aVar = new a();
        aVar.hiJ = this.hiJ;
        aVar.hiK = this.hiK;
        aVar.hiL = this.hiL;
        aVar.hiM = this.hiM;
        aVar.hiN = this.hiN;
        return aVar;
    }
}
