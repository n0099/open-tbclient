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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private o dhh;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public List<com.baidu.adp.widget.ListView.a> asF() {
        return this.mAdapters;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        this.mAdapters.add(new i(baseActivity.getPageContext(), j.dgo));
        this.mAdapters.add(new l(baseActivity.getPageContext(), m.dgC));
        this.mAdapters.add(new g(baseActivity.getPageContext(), com.baidu.tieba.frs.i.djk));
        this.mAdapters.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.dfS));
        this.mAdapters.add(new d(baseActivity.getPageContext(), e.dfV));
        this.mAdapters.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.dhh = new o(baseActivity.getPageContext(), p.dgV);
        this.mAdapters.add(this.dhh);
    }

    public void notifyDataSetChanged() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dhh.onDestroy();
    }
}
