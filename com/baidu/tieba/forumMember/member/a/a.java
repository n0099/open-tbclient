package com.baidu.tieba.forumMember.member.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
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
import com.baidu.tieba.frs.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private BdTypeListView gcr;
    private o iyt;
    private r iyu;

    public List<com.baidu.adp.widget.ListView.a> bMJ() {
        return this.bje;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.gcr = bdTypeListView;
        this.bje.add(new i(baseActivity.getPageContext(), j.ixE));
        this.bje.add(new l(baseActivity.getPageContext(), m.ixP));
        this.bje.add(new g(baseActivity.getPageContext(), n.iBb));
        this.bje.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.ixh));
        this.bje.add(new d(baseActivity.getPageContext(), e.ixk));
        this.bje.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.iyt = new o(baseActivity.getPageContext(), p.iyg);
        this.bje.add(this.iyt);
        this.iyu = new r(baseActivity.getPageContext(), s.iyr);
        this.bje.add(this.iyu);
    }

    public void notifyDataSetChanged() {
        if (this.gcr != null && (this.gcr.getAdapter() instanceof f)) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iyt.onDestroy();
        this.iyu.onDestroy();
    }
}
