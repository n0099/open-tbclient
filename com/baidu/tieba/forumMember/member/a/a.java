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
    private BdTypeListView gpX;
    private o iPW;
    private r iPX;

    public List<com.baidu.adp.widget.ListView.a> bSn() {
        return this.bnf;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.gpX = bdTypeListView;
        this.bnf.add(new i(baseActivity.getPageContext(), j.iPh));
        this.bnf.add(new l(baseActivity.getPageContext(), m.iPs));
        this.bnf.add(new g(baseActivity.getPageContext(), n.iSE));
        this.bnf.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.iOK));
        this.bnf.add(new d(baseActivity.getPageContext(), e.iON));
        this.bnf.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.iPW = new o(baseActivity.getPageContext(), p.iPJ);
        this.bnf.add(this.iPW);
        this.iPX = new r(baseActivity.getPageContext(), s.iPU);
        this.bnf.add(this.iPX);
    }

    public void notifyDataSetChanged() {
        if (this.gpX != null && (this.gpX.getAdapter() instanceof f)) {
            this.gpX.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iPW.onDestroy();
        this.iPX.onDestroy();
    }
}
