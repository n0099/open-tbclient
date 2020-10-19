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
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private BdTypeListView fSo;
    private o ilV;
    private r ilW;

    public List<com.baidu.adp.widget.ListView.a> bKh() {
        return this.bhH;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.fSo = bdTypeListView;
        this.bhH.add(new i(baseActivity.getPageContext(), j.ilg));
        this.bhH.add(new l(baseActivity.getPageContext(), m.ilr));
        this.bhH.add(new g(baseActivity.getPageContext(), n.ioF));
        this.bhH.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.ikJ));
        this.bhH.add(new d(baseActivity.getPageContext(), e.ikM));
        this.bhH.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.ilV = new o(baseActivity.getPageContext(), p.ilI);
        this.bhH.add(this.ilV);
        this.ilW = new r(baseActivity.getPageContext(), s.ilT);
        this.bhH.add(this.ilW);
    }

    public void notifyDataSetChanged() {
        if (this.fSo != null && (this.fSo.getAdapter() instanceof f)) {
            this.fSo.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.ilV.onDestroy();
        this.ilW.onDestroy();
    }
}
