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
    private BdTypeListView ekb;
    private o glC;
    private r glD;

    public List<com.baidu.adp.widget.ListView.a> bcE() {
        return this.asE;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.ekb = bdTypeListView;
        this.asE.add(new i(baseActivity.getPageContext(), j.gkO));
        this.asE.add(new l(baseActivity.getPageContext(), m.gla));
        this.asE.add(new g(baseActivity.getPageContext(), com.baidu.tieba.frs.j.gnV));
        this.asE.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.gkq));
        this.asE.add(new d(baseActivity.getPageContext(), e.gkt));
        this.asE.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.glC = new o(baseActivity.getPageContext(), p.glq);
        this.asE.add(this.glC);
        this.glD = new r(baseActivity.getPageContext(), s.glA);
        this.asE.add(this.glD);
    }

    public void notifyDataSetChanged() {
        if (this.ekb != null && (this.ekb.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.ekb.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.glC.onDestroy();
        this.glD.onDestroy();
    }
}
