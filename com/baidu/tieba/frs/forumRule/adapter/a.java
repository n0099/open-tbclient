package com.baidu.tieba.frs.forumRule.adapter;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView XW;
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private d juT;
    private c juU;
    private b juV;
    private String mFrom;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    private void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.XW = bdTypeRecyclerView;
        this.juT = new d(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.b.TYPE);
        this.juU = new c(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.c.jvB);
        this.juV = new b(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.a.jvw);
        this.bns.add(this.juT);
        this.bns.add(this.juU);
        this.bns.add(this.juV);
        bdTypeRecyclerView.addAdapters(this.bns);
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.juT != null) {
            this.juT.setFrom(str);
        }
        if (this.juV != null) {
            this.juV.setFrom(str);
        }
    }

    public void setData(List<n> list) {
        if (this.XW != null) {
            this.XW.setData(list);
        }
        if (this.juU != null) {
            this.juU.setData(list);
        }
    }

    public void onChangeSkinType(int i) {
    }
}
