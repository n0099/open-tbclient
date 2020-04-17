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
    private List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private BdTypeListView eOe;
    private o gVD;
    private r gVE;

    public List<com.baidu.adp.widget.ListView.a> blA() {
        return this.aMd;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.eOe = bdTypeListView;
        this.aMd.add(new i(baseActivity.getPageContext(), j.gUP));
        this.aMd.add(new l(baseActivity.getPageContext(), m.gVb));
        this.aMd.add(new g(baseActivity.getPageContext(), k.gXZ));
        this.aMd.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.gUs));
        this.aMd.add(new d(baseActivity.getPageContext(), e.gUv));
        this.aMd.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.gVD = new o(baseActivity.getPageContext(), p.gVr);
        this.aMd.add(this.gVD);
        this.gVE = new r(baseActivity.getPageContext(), s.gVB);
        this.aMd.add(this.gVE);
    }

    public void notifyDataSetChanged() {
        if (this.eOe != null && (this.eOe.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.eOe.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gVD.onDestroy();
        this.gVE.onDestroy();
    }
}
