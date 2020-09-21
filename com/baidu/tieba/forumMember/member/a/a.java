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
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private BdTypeListView fGf;
    private o hWW;
    private r hWX;

    public List<com.baidu.adp.widget.ListView.a> bHv() {
        return this.bdV;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.fGf = bdTypeListView;
        this.bdV.add(new i(baseActivity.getPageContext(), j.hWh));
        this.bdV.add(new l(baseActivity.getPageContext(), m.hWs));
        this.bdV.add(new g(baseActivity.getPageContext(), n.hZE));
        this.bdV.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.hVK));
        this.bdV.add(new d(baseActivity.getPageContext(), e.hVN));
        this.bdV.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.hWW = new o(baseActivity.getPageContext(), p.hWJ);
        this.bdV.add(this.hWW);
        this.hWX = new r(baseActivity.getPageContext(), s.hWU);
        this.bdV.add(this.hWX);
    }

    public void notifyDataSetChanged() {
        if (this.fGf != null && (this.fGf.getAdapter() instanceof f)) {
            this.fGf.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hWW.onDestroy();
        this.hWX.onDestroy();
    }
}
