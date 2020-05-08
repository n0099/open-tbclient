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
    private List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private BdTypeListView eOj;
    private o gVJ;
    private r gVK;

    public List<com.baidu.adp.widget.ListView.a> bly() {
        return this.aMj;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.eOj = bdTypeListView;
        this.aMj.add(new i(baseActivity.getPageContext(), j.gUV));
        this.aMj.add(new l(baseActivity.getPageContext(), m.gVh));
        this.aMj.add(new g(baseActivity.getPageContext(), k.gYf));
        this.aMj.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.gUy));
        this.aMj.add(new d(baseActivity.getPageContext(), e.gUB));
        this.aMj.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.gVJ = new o(baseActivity.getPageContext(), p.gVx);
        this.aMj.add(this.gVJ);
        this.gVK = new r(baseActivity.getPageContext(), s.gVH);
        this.aMj.add(this.gVK);
    }

    public void notifyDataSetChanged() {
        if (this.eOj != null && (this.eOj.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.eOj.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gVJ.onDestroy();
        this.gVK.onDestroy();
    }
}
