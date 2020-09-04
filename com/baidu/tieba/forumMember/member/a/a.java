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
/* loaded from: classes17.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private BdTypeListView fCT;
    private o hPW;
    private r hPX;

    public List<com.baidu.adp.widget.ListView.a> bGf() {
        return this.bbw;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.fCT = bdTypeListView;
        this.bbw.add(new i(baseActivity.getPageContext(), j.hPh));
        this.bbw.add(new l(baseActivity.getPageContext(), m.hPs));
        this.bbw.add(new g(baseActivity.getPageContext(), n.hSE));
        this.bbw.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.hOK));
        this.bbw.add(new d(baseActivity.getPageContext(), e.hON));
        this.bbw.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.hPW = new o(baseActivity.getPageContext(), p.hPJ);
        this.bbw.add(this.hPW);
        this.hPX = new r(baseActivity.getPageContext(), s.hPU);
        this.bbw.add(this.hPX);
    }

    public void notifyDataSetChanged() {
        if (this.fCT != null && (this.fCT.getAdapter() instanceof f)) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hPW.onDestroy();
        this.hPX.onDestroy();
    }
}
