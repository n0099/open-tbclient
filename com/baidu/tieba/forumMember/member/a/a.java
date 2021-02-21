package com.baidu.tieba.forumMember.member.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.forumMember.manito.c;
import com.baidu.tieba.forumMember.manito.d;
import com.baidu.tieba.forumMember.member.f;
import com.baidu.tieba.forumMember.member.g;
import com.baidu.tieba.forumMember.member.h;
import com.baidu.tieba.forumMember.member.i;
import com.baidu.tieba.forumMember.member.j;
import com.baidu.tieba.forumMember.member.k;
import com.baidu.tieba.forumMember.member.l;
import com.baidu.tieba.forumMember.member.m;
import com.baidu.tieba.frs.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private BdTypeListView gzp;
    private k jdy;
    private m jdz;

    public List<com.baidu.adp.widget.ListView.a> bRK() {
        return this.bns;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.gzp = bdTypeListView;
        this.bns.add(new g(baseActivity.getPageContext(), h.jcJ));
        this.bns.add(new i(baseActivity.getPageContext(), j.jcU));
        this.bns.add(new f(baseActivity.getPageContext(), n.jge));
        this.bns.add(new com.baidu.tieba.forumMember.manito.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.manito.b.jcm));
        this.bns.add(new c(baseActivity.getPageContext(), d.jcp));
        this.bns.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.jdy = new k(baseActivity.getPageContext(), l.jdl);
        this.bns.add(this.jdy);
        this.jdz = new m(baseActivity.getPageContext(), com.baidu.tieba.forumMember.member.n.jdw);
        this.bns.add(this.jdz);
    }

    public void notifyDataSetChanged() {
        if (this.gzp != null && (this.gzp.getAdapter() instanceof e)) {
            this.gzp.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jdy.onDestroy();
        this.jdz.onDestroy();
    }
}
