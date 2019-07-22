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
    private o frk;
    private r frl;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public List<com.baidu.adp.widget.ListView.a> aJm() {
        return this.mAdapters;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        this.mAdapters.add(new i(baseActivity.getPageContext(), j.fqw));
        this.mAdapters.add(new l(baseActivity.getPageContext(), m.fqI));
        this.mAdapters.add(new g(baseActivity.getPageContext(), com.baidu.tieba.frs.i.ftz));
        this.mAdapters.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.fpZ));
        this.mAdapters.add(new d(baseActivity.getPageContext(), e.fqc));
        this.mAdapters.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.frk = new o(baseActivity.getPageContext(), p.fqY);
        this.mAdapters.add(this.frk);
        this.frl = new r(baseActivity.getPageContext(), s.fri);
        this.mAdapters.add(this.frl);
    }

    public void notifyDataSetChanged() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.frk.onDestroy();
        this.frl.onDestroy();
    }
}
