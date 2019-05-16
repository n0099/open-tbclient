package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private ab fBO = new ab() { // from class: com.baidu.tieba.frs.gamerecommend.a.a.1
        @Override // com.baidu.tieba.card.ab
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
        bVar.e(this.fBO);
        this.mAdapters.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.e(this.fBO);
        this.mAdapters.add(cVar);
        this.mAdapters.add(new h(this.mPageContext, this.mForumId));
        this.mAdapters.add(new f(this.mPageContext, this.mForumId));
        this.mAdapters.add(new i(this.mPageContext, com.baidu.tieba.e.h.eNq, this.mPageContext.getUniqueId(), this.mForumId));
        e eVar = new e(this.mPageContext, this.mForumId);
        eVar.e(this.fBO);
        this.mAdapters.add(eVar);
        this.mAdapters.add(new d(this.mPageContext, com.baidu.tieba.e.c.eNe, this.mPageContext.getUniqueId(), this.mForumId));
        this.mAdapters.add(new g(this.mPageContext, com.baidu.tieba.e.f.eNm, this.mPageContext.getUniqueId(), this.mForumId));
        w wVar = new w(this.mPageContext, q.fsf, this.mPageContext.getUniqueId());
        wVar.bmZ();
        wVar.setForumId(this.mForumId);
        this.mAdapters.add(wVar);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<m> list) {
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
