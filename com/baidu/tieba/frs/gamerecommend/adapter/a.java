package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.e.h;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeListView gzb;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private ab jzb = new ab() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.gzb = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        Kw();
    }

    private void Kw() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.jzb);
        this.bns.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.jzb);
        this.bns.add(cVar);
        this.bns.add(new f(this.mPageContext, this.mForumId));
        this.bns.add(new e(this.mPageContext, this.mForumId));
        this.bns.add(new GameSpecialTopicAdapter(this.mPageContext, h.iEg, this.mPageContext.getUniqueId(), this.mForumId));
        d dVar = new d(this.mPageContext, this.mForumId);
        dVar.d(this.jzb);
        this.bns.add(dVar);
        this.bns.add(new GameCompetitionAdapter(this.mPageContext, com.baidu.tieba.e.c.iDU, this.mPageContext.getUniqueId(), this.mForumId));
        this.bns.add(new GameRecommendGameAdapter(this.mPageContext, com.baidu.tieba.e.f.iEc, this.mPageContext.getUniqueId(), this.mForumId));
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(this.mPageContext, w.jkf, this.mPageContext.getUniqueId());
        frsUserRecommendAdapter.cGz();
        frsUserRecommendAdapter.setForumId(this.mForumId);
        this.bns.add(frsUserRecommendAdapter);
        this.gzb.addAdapters(this.bns);
    }

    public void setData(List<n> list) {
        if (this.gzb != null) {
            this.gzb.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gzb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }
}
