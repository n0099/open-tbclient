package com.baidu.tieba.forumMember.member.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.forumMember.a.d;
import com.baidu.tieba.forumMember.a.e;
import com.baidu.tieba.forumMember.member.g;
import com.baidu.tieba.forumMember.member.i;
import com.baidu.tieba.forumMember.member.j;
import com.baidu.tieba.forumMember.member.l;
import com.baidu.tieba.forumMember.member.m;
import com.baidu.tieba.forumMember.member.o;
import com.baidu.tieba.forumMember.member.p;
import com.baidu.tieba.forumMember.member.r;
import com.baidu.tieba.forumMember.member.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private BdTypeListView duK;
    private o frT;
    private r frU;

    public List<com.baidu.adp.widget.ListView.a> aJq() {
        return this.agy;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.duK = bdTypeListView;
        this.agy.add(new i(baseActivity.getPageContext(), j.fre));
        this.agy.add(new l(baseActivity.getPageContext(), m.frq));
        this.agy.add(new g(baseActivity.getPageContext(), com.baidu.tieba.frs.i.fuh));
        this.agy.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.fqH));
        this.agy.add(new d(baseActivity.getPageContext(), e.fqK));
        this.agy.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.frT = new o(baseActivity.getPageContext(), p.frH);
        this.agy.add(this.frT);
        this.frU = new r(baseActivity.getPageContext(), s.frR);
        this.agy.add(this.frU);
    }

    public void notifyDataSetChanged() {
        if (this.duK != null && (this.duK.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.duK.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.frT.onDestroy();
        this.frU.onDestroy();
    }
}
