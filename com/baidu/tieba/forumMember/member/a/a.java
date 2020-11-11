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
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private BdTypeListView gih;
    private o iEq;
    private r iEr;

    public List<com.baidu.adp.widget.ListView.a> bPj() {
        return this.bky;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.gih = bdTypeListView;
        this.bky.add(new i(baseActivity.getPageContext(), j.iDB));
        this.bky.add(new l(baseActivity.getPageContext(), m.iDM));
        this.bky.add(new g(baseActivity.getPageContext(), n.iGY));
        this.bky.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.iDe));
        this.bky.add(new d(baseActivity.getPageContext(), e.iDh));
        this.bky.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.iEq = new o(baseActivity.getPageContext(), p.iEd);
        this.bky.add(this.iEq);
        this.iEr = new r(baseActivity.getPageContext(), s.iEo);
        this.bky.add(this.iEr);
    }

    public void notifyDataSetChanged() {
        if (this.gih != null && (this.gih.getAdapter() instanceof f)) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iEq.onDestroy();
        this.iEr.onDestroy();
    }
}
