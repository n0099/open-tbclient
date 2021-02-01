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
    private d juF;
    private c juG;
    private b juH;
    private String mFrom;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    private void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.XW = bdTypeRecyclerView;
        this.juF = new d(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.b.TYPE);
        this.juG = new c(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.c.jvn);
        this.juH = new b(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.a.jvi);
        this.bns.add(this.juF);
        this.bns.add(this.juG);
        this.bns.add(this.juH);
        bdTypeRecyclerView.addAdapters(this.bns);
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.juF != null) {
            this.juF.setFrom(str);
        }
        if (this.juH != null) {
            this.juH.setFrom(str);
        }
    }

    public void setData(List<n> list) {
        if (this.XW != null) {
            this.XW.setData(list);
        }
        if (this.juG != null) {
            this.juG.setData(list);
        }
    }

    public void onChangeSkinType(int i) {
    }
}
