package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernTitleView;
/* loaded from: classes10.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.special_forum.data.g, LiveTabConcernTitleView.ViewHolder> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.special_forum.data.g.gEm);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public LiveTabConcernTitleView.ViewHolder e(ViewGroup viewGroup) {
        return new LiveTabConcernTitleView.ViewHolder(new LiveTabConcernTitleView(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.special_forum.data.g gVar, LiveTabConcernTitleView.ViewHolder viewHolder) {
        if (viewHolder == null || viewHolder.gFy == null) {
            return null;
        }
        viewHolder.gFy.a(gVar);
        viewHolder.gFy.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return viewHolder.getView();
    }
}
