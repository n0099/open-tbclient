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
/* loaded from: classes5.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private BdTypeListView dvB;
    private o fsK;
    private r fsL;

    public List<com.baidu.adp.widget.ListView.a> aJs() {
        return this.agQ;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.dvB = bdTypeListView;
        this.agQ.add(new i(baseActivity.getPageContext(), j.frW));
        this.agQ.add(new l(baseActivity.getPageContext(), m.fsi));
        this.agQ.add(new g(baseActivity.getPageContext(), com.baidu.tieba.frs.i.fuY));
        this.agQ.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.frz));
        this.agQ.add(new d(baseActivity.getPageContext(), e.frC));
        this.agQ.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.fsK = new o(baseActivity.getPageContext(), p.fsy);
        this.agQ.add(this.fsK);
        this.fsL = new r(baseActivity.getPageContext(), s.fsI);
        this.agQ.add(this.fsL);
    }

    public void notifyDataSetChanged() {
        if (this.dvB != null && (this.dvB.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dvB.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fsK.onDestroy();
        this.fsL.onDestroy();
    }
}
