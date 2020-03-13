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
    private List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private BdTypeListView eko;
    private o glP;
    private r glQ;

    public List<com.baidu.adp.widget.ListView.a> bcF() {
        return this.asF;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.eko = bdTypeListView;
        this.asF.add(new i(baseActivity.getPageContext(), j.glb));
        this.asF.add(new l(baseActivity.getPageContext(), m.gln));
        this.asF.add(new g(baseActivity.getPageContext(), com.baidu.tieba.frs.j.goi));
        this.asF.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.gkD));
        this.asF.add(new d(baseActivity.getPageContext(), e.gkG));
        this.asF.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.glP = new o(baseActivity.getPageContext(), p.glD);
        this.asF.add(this.glP);
        this.glQ = new r(baseActivity.getPageContext(), s.glN);
        this.asF.add(this.glQ);
    }

    public void notifyDataSetChanged() {
        if (this.eko != null && (this.eko.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.eko.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.glP.onDestroy();
        this.glQ.onDestroy();
    }
}
