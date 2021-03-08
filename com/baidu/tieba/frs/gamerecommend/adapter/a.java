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
    private BdTypeListView gAY;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private ab jAY = new ab() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.gAY = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        Kz();
    }

    private void Kz() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.jAY);
        this.boS.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.jAY);
        this.boS.add(cVar);
        this.boS.add(new f(this.mPageContext, this.mForumId));
        this.boS.add(new e(this.mPageContext, this.mForumId));
        this.boS.add(new GameSpecialTopicAdapter(this.mPageContext, h.iGd, this.mPageContext.getUniqueId(), this.mForumId));
        d dVar = new d(this.mPageContext, this.mForumId);
        dVar.d(this.jAY);
        this.boS.add(dVar);
        this.boS.add(new GameCompetitionAdapter(this.mPageContext, com.baidu.tieba.e.c.iFR, this.mPageContext.getUniqueId(), this.mForumId));
        this.boS.add(new GameRecommendGameAdapter(this.mPageContext, com.baidu.tieba.e.f.iFZ, this.mPageContext.getUniqueId(), this.mForumId));
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(this.mPageContext, w.jmc, this.mPageContext.getUniqueId());
        frsUserRecommendAdapter.cGM();
        frsUserRecommendAdapter.setForumId(this.mForumId);
        this.boS.add(frsUserRecommendAdapter);
        this.gAY.addAdapters(this.boS);
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
