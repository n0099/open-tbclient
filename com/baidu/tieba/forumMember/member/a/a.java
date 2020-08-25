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
/* loaded from: classes17.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private BdTypeListView fCP;
    private o hPQ;
    private r hPR;

    public List<com.baidu.adp.widget.ListView.a> bGe() {
        return this.bbu;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.fCP = bdTypeListView;
        this.bbu.add(new i(baseActivity.getPageContext(), j.hPb));
        this.bbu.add(new l(baseActivity.getPageContext(), m.hPm));
        this.bbu.add(new g(baseActivity.getPageContext(), n.hSy));
        this.bbu.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.hOE));
        this.bbu.add(new d(baseActivity.getPageContext(), e.hOH));
        this.bbu.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.hPQ = new o(baseActivity.getPageContext(), p.hPD);
        this.bbu.add(this.hPQ);
        this.hPR = new r(baseActivity.getPageContext(), s.hPO);
        this.bbu.add(this.hPR);
    }

    public void notifyDataSetChanged() {
        if (this.fCP != null && (this.fCP.getAdapter() instanceof f)) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hPQ.onDestroy();
        this.hPR.onDestroy();
    }
}
