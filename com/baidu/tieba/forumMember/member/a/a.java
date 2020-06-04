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
import com.baidu.tieba.frs.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private BdTypeListView fbb;
    private o hkG;
    private r hkH;

    public List<com.baidu.adp.widget.ListView.a> bqY() {
        return this.aSj;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.fbb = bdTypeListView;
        this.aSj.add(new i(baseActivity.getPageContext(), j.hjS));
        this.aSj.add(new l(baseActivity.getPageContext(), m.hke));
        this.aSj.add(new g(baseActivity.getPageContext(), k.hnc));
        this.aSj.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.hjv));
        this.aSj.add(new d(baseActivity.getPageContext(), e.hjy));
        this.aSj.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.hkG = new o(baseActivity.getPageContext(), p.hku);
        this.aSj.add(this.hkG);
        this.hkH = new r(baseActivity.getPageContext(), s.hkE);
        this.aSj.add(this.hkH);
    }

    public void notifyDataSetChanged() {
        if (this.fbb != null && (this.fbb.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.fbb.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hkG.onDestroy();
        this.hkH.onDestroy();
    }
}
