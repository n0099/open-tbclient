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
    private BdTypeListView gzb;
    private k jdk;
    private m jdl;

    public List<com.baidu.adp.widget.ListView.a> bRD() {
        return this.bns;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.gzb = bdTypeListView;
        this.bns.add(new g(baseActivity.getPageContext(), h.jcv));
        this.bns.add(new i(baseActivity.getPageContext(), j.jcG));
        this.bns.add(new f(baseActivity.getPageContext(), n.jfQ));
        this.bns.add(new com.baidu.tieba.forumMember.manito.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.manito.b.jbY));
        this.bns.add(new c(baseActivity.getPageContext(), d.jcb));
        this.bns.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.jdk = new k(baseActivity.getPageContext(), l.jcX);
        this.bns.add(this.jdk);
        this.jdl = new m(baseActivity.getPageContext(), com.baidu.tieba.forumMember.member.n.jdi);
        this.bns.add(this.jdl);
    }

    public void notifyDataSetChanged() {
        if (this.gzb != null && (this.gzb.getAdapter() instanceof e)) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jdk.onDestroy();
        this.jdl.onDestroy();
    }
}
