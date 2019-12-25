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
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private BdTypeListView efM;
    private o ggp;
    private r ggq;

    public List<com.baidu.adp.widget.ListView.a> aZO() {
        return this.aoz;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.efM = bdTypeListView;
        this.aoz.add(new i(baseActivity.getPageContext(), j.gfB));
        this.aoz.add(new l(baseActivity.getPageContext(), m.gfN));
        this.aoz.add(new g(baseActivity.getPageContext(), com.baidu.tieba.frs.j.giJ));
        this.aoz.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.gfd));
        this.aoz.add(new d(baseActivity.getPageContext(), e.gfg));
        this.aoz.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.ggp = new o(baseActivity.getPageContext(), p.ggd);
        this.aoz.add(this.ggp);
        this.ggq = new r(baseActivity.getPageContext(), s.ggn);
        this.aoz.add(this.ggq);
    }

    public void notifyDataSetChanged() {
        if (this.efM != null && (this.efM.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.efM.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.ggp.onDestroy();
        this.ggq.onDestroy();
    }
}
