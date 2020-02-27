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
/* loaded from: classes10.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private BdTypeListView eka;
    private o glA;
    private r glB;

    public List<com.baidu.adp.widget.ListView.a> bcC() {
        return this.asE;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.eka = bdTypeListView;
        this.asE.add(new i(baseActivity.getPageContext(), j.gkM));
        this.asE.add(new l(baseActivity.getPageContext(), m.gkY));
        this.asE.add(new g(baseActivity.getPageContext(), com.baidu.tieba.frs.j.gnT));
        this.asE.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.gko));
        this.asE.add(new d(baseActivity.getPageContext(), e.gkr));
        this.asE.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.glA = new o(baseActivity.getPageContext(), p.glo);
        this.asE.add(this.glA);
        this.glB = new r(baseActivity.getPageContext(), s.gly);
        this.asE.add(this.glB);
    }

    public void notifyDataSetChanged() {
        if (this.eka != null && (this.eka.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.eka.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.glA.onDestroy();
        this.glB.onDestroy();
    }
}
