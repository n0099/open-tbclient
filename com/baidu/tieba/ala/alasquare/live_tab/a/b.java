package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.OfficialRecommendLiveViewHolder;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.c, OfficialRecommendLiveViewHolder> {
    private com.baidu.tieba.ala.alasquare.live_tab.view.b gCB;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.c.gCG);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: T */
    public OfficialRecommendLiveViewHolder e(ViewGroup viewGroup) {
        this.gCB = new com.baidu.tieba.ala.alasquare.live_tab.view.b(this.mPageContext, viewGroup);
        return new OfficialRecommendLiveViewHolder(this.gCB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.c cVar, OfficialRecommendLiveViewHolder officialRecommendLiveViewHolder) {
        if (officialRecommendLiveViewHolder == null || officialRecommendLiveViewHolder.gCB == null) {
            return null;
        }
        officialRecommendLiveViewHolder.gCB.a(cVar);
        officialRecommendLiveViewHolder.gCB.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return officialRecommendLiveViewHolder.getView();
    }
}
