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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private BdTypeListView frv;
    private o hCB;
    private r hCC;

    public List<com.baidu.adp.widget.ListView.a> bxf() {
        return this.aWf;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.frv = bdTypeListView;
        this.aWf.add(new i(baseActivity.getPageContext(), j.hBM));
        this.aWf.add(new l(baseActivity.getPageContext(), m.hBX));
        this.aWf.add(new g(baseActivity.getPageContext(), com.baidu.tieba.frs.m.hFi));
        this.aWf.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.hBp));
        this.aWf.add(new d(baseActivity.getPageContext(), e.hBs));
        this.aWf.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.hCB = new o(baseActivity.getPageContext(), p.hCo);
        this.aWf.add(this.hCB);
        this.hCC = new r(baseActivity.getPageContext(), s.hCz);
        this.aWf.add(this.hCC);
    }

    public void notifyDataSetChanged() {
        if (this.frv != null && (this.frv.getAdapter() instanceof f)) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hCB.onDestroy();
        this.hCC.onDestroy();
    }
}
