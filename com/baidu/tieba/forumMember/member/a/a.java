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
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private BdTypeListView gwr;
    private k iXD;
    private m iXE;

    public List<com.baidu.adp.widget.ListView.a> bQZ() {
        return this.bjZ;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.gwr = bdTypeListView;
        this.bjZ.add(new g(baseActivity.getPageContext(), h.iWO));
        this.bjZ.add(new i(baseActivity.getPageContext(), j.iWZ));
        this.bjZ.add(new f(baseActivity.getPageContext(), n.jak));
        this.bjZ.add(new com.baidu.tieba.forumMember.manito.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.manito.b.iWr));
        this.bjZ.add(new c(baseActivity.getPageContext(), d.iWu));
        this.bjZ.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.iXD = new k(baseActivity.getPageContext(), l.iXq);
        this.bjZ.add(this.iXD);
        this.iXE = new m(baseActivity.getPageContext(), com.baidu.tieba.forumMember.member.n.iXB);
        this.bjZ.add(this.iXE);
    }

    public void notifyDataSetChanged() {
        if (this.gwr != null && (this.gwr.getAdapter() instanceof e)) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iXD.onDestroy();
        this.iXE.onDestroy();
    }
}
