package com.baidu.tieba.ala.alasquare.special_forum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.RecommendActivityView;
/* loaded from: classes10.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.special_forum.data.c, RecommendActivityView.ViewHolder> {
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.special_forum.data.c.TYPE);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public RecommendActivityView.ViewHolder e(ViewGroup viewGroup) {
        return new RecommendActivityView.ViewHolder(new RecommendActivityView(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.special_forum.data.c cVar, RecommendActivityView.ViewHolder viewHolder) {
        if (viewHolder == null || cVar == null) {
            return null;
        }
        viewHolder.gID.a(cVar);
        return viewHolder.getView();
    }
}
