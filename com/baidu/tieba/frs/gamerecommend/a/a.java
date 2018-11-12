package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.frs.entelechy.a.m;
import com.baidu.tieba.frs.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private ad dOe = new ad() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.ad
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            super.a(view, bVar);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private String mForumId;
    private String mForumName;
    private BdTypeListView mListView;
    private TbPageContext mPageContext;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        initAdapters();
    }

    private void initAdapters() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.dOe);
        this.mAdapters.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.dOe);
        this.mAdapters.add(cVar);
        this.mAdapters.add(new h(this.mPageContext, this.mForumId));
        this.mAdapters.add(new f(this.mPageContext, this.mForumId));
        this.mAdapters.add(new i(this.mPageContext, com.baidu.tieba.e.h.ddW, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.d(this.dOe);
        this.mAdapters.add(eVar);
        this.mAdapters.add(new d(this.mPageContext, com.baidu.tieba.e.c.ddK, this.mPageContext.getUniqueId(), this.mForumId));
        this.mAdapters.add(new g(this.mPageContext, com.baidu.tieba.e.f.ddS, this.mPageContext.getUniqueId(), this.mForumId));
        m mVar = new m(this.mPageContext, q.dEs, this.mPageContext.getUniqueId());
        mVar.aCi();
        mVar.setForumId(this.mForumId);
        this.mAdapters.add(mVar);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.adp.widget.ListView.h> list) {
        if (this.mListView != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}
