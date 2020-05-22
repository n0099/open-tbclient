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
    private BdTypeListView faQ;
    private o hkv;
    private r hkw;

    public List<com.baidu.adp.widget.ListView.a> bqW() {
        return this.aSj;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.faQ = bdTypeListView;
        this.aSj.add(new i(baseActivity.getPageContext(), j.hjH));
        this.aSj.add(new l(baseActivity.getPageContext(), m.hjT));
        this.aSj.add(new g(baseActivity.getPageContext(), k.hmR));
        this.aSj.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.hjk));
        this.aSj.add(new d(baseActivity.getPageContext(), e.hjn));
        this.aSj.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.hkv = new o(baseActivity.getPageContext(), p.hkj);
        this.aSj.add(this.hkv);
        this.hkw = new r(baseActivity.getPageContext(), s.hkt);
        this.aSj.add(this.hkw);
    }

    public void notifyDataSetChanged() {
        if (this.faQ != null && (this.faQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.faQ.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hkv.onDestroy();
        this.hkw.onDestroy();
    }
}
