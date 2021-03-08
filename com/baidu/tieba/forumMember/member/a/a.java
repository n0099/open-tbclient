package com.baidu.tieba.forumMember.member.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.forumMember.manito.c;
import com.baidu.tieba.forumMember.manito.d;
import com.baidu.tieba.forumMember.member.f;
import com.baidu.tieba.forumMember.member.g;
import com.baidu.tieba.forumMember.member.h;
import com.baidu.tieba.forumMember.member.i;
import com.baidu.tieba.forumMember.member.j;
import com.baidu.tieba.forumMember.member.k;
import com.baidu.tieba.forumMember.member.l;
import com.baidu.tieba.forumMember.member.m;
import com.baidu.tieba.frs.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private BdTypeListView gAY;
    private k jfh;
    private m jfi;

    public List<com.baidu.adp.widget.ListView.a> bRQ() {
        return this.boS;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.gAY = bdTypeListView;
        this.boS.add(new g(baseActivity.getPageContext(), h.jes));
        this.boS.add(new i(baseActivity.getPageContext(), j.jeD));
        this.boS.add(new f(baseActivity.getPageContext(), n.jhN));
        this.boS.add(new com.baidu.tieba.forumMember.manito.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.manito.b.jdV));
        this.boS.add(new c(baseActivity.getPageContext(), d.jdY));
        this.boS.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.jfh = new k(baseActivity.getPageContext(), l.jeU);
        this.boS.add(this.jfh);
        this.jfi = new m(baseActivity.getPageContext(), com.baidu.tieba.forumMember.member.n.jff);
        this.boS.add(this.jfi);
    }

    public void notifyDataSetChanged() {
        if (this.gAY != null && (this.gAY.getAdapter() instanceof e)) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jfh.onDestroy();
        this.jfi.onDestroy();
    }
}
