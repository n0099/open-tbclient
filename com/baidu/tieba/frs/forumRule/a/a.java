package com.baidu.tieba.frs.forumRule.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView Yf;
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private f jhf;
    private d jhg;
    private b jhh;
    private String mFrom;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    private void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.Yf = bdTypeRecyclerView;
        this.jhf = new f(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.c.b.TYPE);
        this.jhg = new d(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.c.c.jhN);
        this.jhh = new b(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.c.a.jhI);
        this.bnf.add(this.jhf);
        this.bnf.add(this.jhg);
        this.bnf.add(this.jhh);
        bdTypeRecyclerView.addAdapters(this.bnf);
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jhf != null) {
            this.jhf.setFrom(str);
        }
        if (this.jhh != null) {
            this.jhh.setFrom(str);
        }
    }

    public void setData(List<q> list) {
        if (this.Yf != null) {
            this.Yf.setData(list);
        }
        if (this.jhg != null) {
            this.jhg.setData(list);
        }
    }

    public void onChangeSkinType(int i) {
    }
}
