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
/* loaded from: classes10.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private BdTypeListView fml;
    private o hwN;
    private r hwO;

    public List<com.baidu.adp.widget.ListView.a> btW() {
        return this.aUP;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.fml = bdTypeListView;
        this.aUP.add(new i(baseActivity.getPageContext(), j.hwa));
        this.aUP.add(new l(baseActivity.getPageContext(), m.hwl));
        this.aUP.add(new g(baseActivity.getPageContext(), com.baidu.tieba.frs.m.hzt));
        this.aUP.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.hvD));
        this.aUP.add(new d(baseActivity.getPageContext(), e.hvG));
        this.aUP.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.hwN = new o(baseActivity.getPageContext(), p.hwB);
        this.aUP.add(this.hwN);
        this.hwO = new r(baseActivity.getPageContext(), s.hwL);
        this.aUP.add(this.hwO);
    }

    public void notifyDataSetChanged() {
        if (this.fml != null && (this.fml.getAdapter() instanceof f)) {
            this.fml.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hwN.onDestroy();
        this.hwO.onDestroy();
    }
}
