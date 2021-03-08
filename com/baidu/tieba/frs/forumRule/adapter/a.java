package com.baidu.tieba.frs.forumRule.adapter;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Zq;
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private d jwC;
    private c jwD;
    private b jwE;
    private String mFrom;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    private void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.Zq = bdTypeRecyclerView;
        this.jwC = new d(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.b.TYPE);
        this.jwD = new c(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.c.jxk);
        this.jwE = new b(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.b.a.jxf);
        this.boS.add(this.jwC);
        this.boS.add(this.jwD);
        this.boS.add(this.jwE);
        bdTypeRecyclerView.addAdapters(this.boS);
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jwC != null) {
            this.jwC.setFrom(str);
        }
        if (this.jwE != null) {
            this.jwE.setFrom(str);
        }
    }

    public void setData(List<n> list) {
        if (this.Zq != null) {
            this.Zq.setData(list);
        }
        if (this.jwD != null) {
            this.jwD.setData(list);
        }
    }

    public void onChangeSkinType(int i) {
    }
}
