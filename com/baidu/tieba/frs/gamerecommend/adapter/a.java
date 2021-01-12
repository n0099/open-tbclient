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
    private BdTypeListView gwr;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private aa jtv = new aa() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.notifyDataSetChanged();
        }
    };
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.gwr = bdTypeListView;
        this.mForumId = str;
        this.mForumName = str2;
        IY();
    }

    private void IY() {
        b bVar = new b(this.mPageContext, this.mForumId, this.mForumName);
        bVar.d(this.jtv);
        this.bjZ.add(bVar);
        c cVar = new c(this.mPageContext, this.mForumId);
        cVar.d(this.jtv);
        this.bjZ.add(cVar);
        this.bjZ.add(new f(this.mPageContext, this.mForumId));
        this.bjZ.add(new e(this.mPageContext, this.mForumId));
        this.bjZ.add(new GameSpecialTopicAdapter(this.mPageContext, h.iyw, this.mPageContext.getUniqueId(), this.mForumId));
        d dVar = new d(this.mPageContext, this.mForumId);
        dVar.d(this.jtv);
        this.bjZ.add(dVar);
        this.bjZ.add(new GameCompetitionAdapter(this.mPageContext, com.baidu.tieba.e.c.iyk, this.mPageContext.getUniqueId(), this.mForumId));
        this.bjZ.add(new GameRecommendGameAdapter(this.mPageContext, com.baidu.tieba.e.f.iys, this.mPageContext.getUniqueId(), this.mForumId));
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(this.mPageContext, w.jey, this.mPageContext.getUniqueId());
        frsUserRecommendAdapter.cFm();
        frsUserRecommendAdapter.setForumId(this.mForumId);
        this.bjZ.add(frsUserRecommendAdapter);
        this.gwr.addAdapters(this.bjZ);
    }

    public void setData(List<n> list) {
        if (this.gwr != null) {
            this.gwr.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gwr.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }
}
