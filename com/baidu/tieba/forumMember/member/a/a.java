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
    private List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private BdTypeListView ekE;
    private o gmx;
    private r gmy;

    public List<com.baidu.adp.widget.ListView.a> bcJ() {
        return this.asP;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.ekE = bdTypeListView;
        this.asP.add(new i(baseActivity.getPageContext(), j.glJ));
        this.asP.add(new l(baseActivity.getPageContext(), m.glV));
        this.asP.add(new g(baseActivity.getPageContext(), k.goS));
        this.asP.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.gll));
        this.asP.add(new d(baseActivity.getPageContext(), e.glo));
        this.asP.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.gmx = new o(baseActivity.getPageContext(), p.gml);
        this.asP.add(this.gmx);
        this.gmy = new r(baseActivity.getPageContext(), s.gmv);
        this.asP.add(this.gmy);
    }

    public void notifyDataSetChanged() {
        if (this.ekE != null && (this.ekE.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.ekE.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gmx.onDestroy();
        this.gmy.onDestroy();
    }
}
