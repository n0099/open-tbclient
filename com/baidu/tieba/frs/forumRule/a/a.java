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
    private f jhd;
    private d jhe;
    private b jhf;
    private String mFrom;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    private void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.Yf = bdTypeRecyclerView;
        this.jhd = new f(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.c.b.TYPE);
        this.jhe = new d(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.c.c.jhL);
        this.jhf = new b(forumRulesShowActivity, com.baidu.tieba.frs.forumRule.c.a.jhG);
        this.bnf.add(this.jhd);
        this.bnf.add(this.jhe);
        this.bnf.add(this.jhf);
        bdTypeRecyclerView.addAdapters(this.bnf);
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jhd != null) {
            this.jhd.setFrom(str);
        }
        if (this.jhf != null) {
            this.jhf.setFrom(str);
        }
    }

    public void setData(List<q> list) {
        if (this.Yf != null) {
            this.Yf.setData(list);
        }
        if (this.jhe != null) {
            this.jhe.setData(list);
        }
    }

    public void onChangeSkinType(int i) {
    }
}
