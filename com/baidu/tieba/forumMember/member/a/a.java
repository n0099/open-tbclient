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
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private BdTypeListView gpZ;
    private o iPY;
    private r iPZ;

    public List<com.baidu.adp.widget.ListView.a> bSo() {
        return this.bnf;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.gpZ = bdTypeListView;
        this.bnf.add(new i(baseActivity.getPageContext(), j.iPj));
        this.bnf.add(new l(baseActivity.getPageContext(), m.iPu));
        this.bnf.add(new g(baseActivity.getPageContext(), n.iSG));
        this.bnf.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.iOM));
        this.bnf.add(new d(baseActivity.getPageContext(), e.iOP));
        this.bnf.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.iPY = new o(baseActivity.getPageContext(), p.iPL);
        this.bnf.add(this.iPY);
        this.iPZ = new r(baseActivity.getPageContext(), s.iPW);
        this.bnf.add(this.iPZ);
    }

    public void notifyDataSetChanged() {
        if (this.gpZ != null && (this.gpZ.getAdapter() instanceof f)) {
            this.gpZ.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iPY.onDestroy();
        this.iPZ.onDestroy();
    }
}
