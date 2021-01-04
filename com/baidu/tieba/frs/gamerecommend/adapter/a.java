package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.e.h;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeListView gAY;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private aa jyb = new aa() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.gAY = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        MT();
    }

    private void MT() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.jyb);
        this.boM.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.jyb);
        this.boM.add(cVar);
        this.boM.add(new f(this.mPageContext, this.mForumId));
        this.boM.add(new e(this.mPageContext, this.mForumId));
        this.boM.add(new GameSpecialTopicAdapter(this.mPageContext, h.iDd, this.mPageContext.getUniqueId(), this.mForumId));
        d dVar = new d(this.mPageContext, this.mForumId);
        dVar.d(this.jyb);
        this.boM.add(dVar);
        this.boM.add(new GameCompetitionAdapter(this.mPageContext, com.baidu.tieba.e.c.iCR, this.mPageContext.getUniqueId(), this.mForumId));
        this.boM.add(new GameRecommendGameAdapter(this.mPageContext, com.baidu.tieba.e.f.iCZ, this.mPageContext.getUniqueId(), this.mForumId));
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(this.mPageContext, w.jjg, this.mPageContext.getUniqueId());
        frsUserRecommendAdapter.cJd();
        frsUserRecommendAdapter.setForumId(this.mForumId);
        this.boM.add(frsUserRecommendAdapter);
        this.gAY.addAdapters(this.boM);
    }

    public void setData(List<n> list) {
        if (this.gAY != null) {
            this.gAY.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }
}
