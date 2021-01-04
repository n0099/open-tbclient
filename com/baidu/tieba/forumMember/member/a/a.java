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
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private BdTypeListView gAY;
    private k jck;
    private m jcl;

    public List<com.baidu.adp.widget.ListView.a> bUQ() {
        return this.boM;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.gAY = bdTypeListView;
        this.boM.add(new g(baseActivity.getPageContext(), h.jbv));
        this.boM.add(new i(baseActivity.getPageContext(), j.jbG));
        this.boM.add(new f(baseActivity.getPageContext(), n.jeR));
        this.boM.add(new com.baidu.tieba.forumMember.manito.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.manito.b.jaY));
        this.boM.add(new c(baseActivity.getPageContext(), d.jbb));
        this.boM.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.jck = new k(baseActivity.getPageContext(), l.jbX);
        this.boM.add(this.jck);
        this.jcl = new m(baseActivity.getPageContext(), com.baidu.tieba.forumMember.member.n.jci);
        this.boM.add(this.jcl);
    }

    public void notifyDataSetChanged() {
        if (this.gAY != null && (this.gAY.getAdapter() instanceof e)) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jck.onDestroy();
        this.jcl.onDestroy();
    }
}
