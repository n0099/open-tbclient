package com.baidu.tieba.frs.forumRule.adapter;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Ya;
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private d joZ;
    private c jpa;
    private b jpb;
    private String mFrom;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    private void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.Ya = bdTypeRecyclerView;
        this.joZ = new d(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.b.TYPE);
        this.jpa = new c(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.c.jpH);
        this.jpb = new b(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.a.jpC);
        this.bjZ.add(this.joZ);
        this.bjZ.add(this.jpa);
        this.bjZ.add(this.jpb);
        bdTypeRecyclerView.addAdapters(this.bjZ);
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.joZ != null) {
            this.joZ.setFrom(str);
        }
        if (this.jpb != null) {
            this.jpb.setFrom(str);
        }
    }

    public void setData(List<n> list) {
        if (this.Ya != null) {
            this.Ya.setData(list);
        }
        if (this.jpa != null) {
            this.jpa.setData(list);
        }
    }

    public void onChangeSkinType(int i) {
    }
}
