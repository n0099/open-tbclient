package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.ConcernTabRecommendTitleView;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<g, ConcernTabRecommendTitleView.ViewHolder> {
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), g.gzF);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public ConcernTabRecommendTitleView.ViewHolder e(ViewGroup viewGroup) {
        return new ConcernTabRecommendTitleView.ViewHolder(new ConcernTabRecommendTitleView(this.mPageContext, viewGroup).getView());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, ConcernTabRecommendTitleView.ViewHolder viewHolder) {
        if (viewHolder == null || gVar == null) {
            return null;
        }
        return viewHolder.getView();
    }
}
