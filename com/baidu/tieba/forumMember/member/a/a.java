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
    private o eWh;
    private r eWi;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public List<com.baidu.adp.widget.ListView.a> aBv() {
        return this.mAdapters;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        this.mAdapters.add(new i(baseActivity.getPageContext(), j.eVn));
        this.mAdapters.add(new l(baseActivity.getPageContext(), m.eVz));
        this.mAdapters.add(new g(baseActivity.getPageContext(), com.baidu.tieba.frs.i.eYp));
        this.mAdapters.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.eUQ));
        this.mAdapters.add(new d(baseActivity.getPageContext(), e.eUT));
        this.mAdapters.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.eWh = new o(baseActivity.getPageContext(), p.eVR);
        this.mAdapters.add(this.eWh);
        this.eWi = new r(baseActivity.getPageContext(), s.eWf);
        this.mAdapters.add(this.eWi);
    }

    public void notifyDataSetChanged() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.eWh.onDestroy();
        this.eWi.onDestroy();
    }
}
