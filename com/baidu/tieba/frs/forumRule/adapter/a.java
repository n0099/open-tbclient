package com.baidu.tieba.frs.forumRule.adapter;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Yc;
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private d jtF;
    private c jtG;
    private b jtH;
    private String mFrom;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    private void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.Yc = bdTypeRecyclerView;
        this.jtF = new d(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.b.TYPE);
        this.jtG = new c(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.c.jun);
        this.jtH = new b(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.a.jui);
        this.boM.add(this.jtF);
        this.boM.add(this.jtG);
        this.boM.add(this.jtH);
        bdTypeRecyclerView.addAdapters(this.boM);
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jtF != null) {
            this.jtF.setFrom(str);
        }
        if (this.jtH != null) {
            this.jtH.setFrom(str);
        }
    }

    public void setData(List<n> list) {
        if (this.Yc != null) {
            this.Yc.setData(list);
        }
        if (this.jtG != null) {
            this.jtG.setData(list);
        }
    }

    public void onChangeSkinType(int i) {
    }
}
