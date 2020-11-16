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
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private BdTypeListView ghN;
    private o iFe;
    private r iFf;

    public List<com.baidu.adp.widget.ListView.a> bOC() {
        return this.biN;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.ghN = bdTypeListView;
        this.biN.add(new i(baseActivity.getPageContext(), j.iEp));
        this.biN.add(new l(baseActivity.getPageContext(), m.iEA));
        this.biN.add(new g(baseActivity.getPageContext(), n.iHM));
        this.biN.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.iDS));
        this.biN.add(new d(baseActivity.getPageContext(), e.iDV));
        this.biN.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.iFe = new o(baseActivity.getPageContext(), p.iER);
        this.biN.add(this.iFe);
        this.iFf = new r(baseActivity.getPageContext(), s.iFc);
        this.biN.add(this.iFf);
    }

    public void notifyDataSetChanged() {
        if (this.ghN != null && (this.ghN.getAdapter() instanceof f)) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iFe.onDestroy();
        this.iFf.onDestroy();
    }
}
