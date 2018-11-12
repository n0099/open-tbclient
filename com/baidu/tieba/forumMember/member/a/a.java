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
    private o dzi;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public List<com.baidu.adp.widget.ListView.a> axQ() {
        return this.mAdapters;
    }

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        this.mAdapters.add(new i(baseActivity.getPageContext(), j.dyp));
        this.mAdapters.add(new l(baseActivity.getPageContext(), m.dyD));
        this.mAdapters.add(new g(baseActivity.getPageContext(), com.baidu.tieba.frs.i.dBo));
        this.mAdapters.add(new com.baidu.tieba.forumMember.a.a(baseActivity.getPageContext(), com.baidu.tieba.forumMember.a.b.dxT));
        this.mAdapters.add(new d(baseActivity.getPageContext(), e.dxW));
        this.mAdapters.add(new com.baidu.tieba.forumMember.member.a(baseActivity.getPageContext()));
        this.dzi = new o(baseActivity.getPageContext(), p.dyW);
        this.mAdapters.add(this.dzi);
    }

    public void notifyDataSetChanged() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dzi.onDestroy();
    }
}
