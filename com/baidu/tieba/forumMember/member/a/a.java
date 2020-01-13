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
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private BdTypeListView efW;
    private r gjA;
    private o gjz;

    public List<com.baidu.adp.widget.ListView.a> ban() {
        return this.apl;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.efW = bdTypeListView;
        this.apl.add(new i(baseActivity.getPageContext(), j.giL));
        this.apl.add(new l(baseActivity.getPageContext(), m.giX));
        this.apl.add(new g(baseActivity.getPageContext(), com.baidu.tieba.frs.j.glS));
        this.apl.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.gin));
        this.apl.add(new d(baseActivity.getPageContext(), e.giq));
        this.apl.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.gjz = new o(baseActivity.getPageContext(), p.gjn);
        this.apl.add(this.gjz);
        this.gjA = new r(baseActivity.getPageContext(), s.gjx);
        this.apl.add(this.gjA);
    }

    public void notifyDataSetChanged() {
        if (this.efW != null && (this.efW.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.efW.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gjz.onDestroy();
        this.gjA.onDestroy();
    }
}
