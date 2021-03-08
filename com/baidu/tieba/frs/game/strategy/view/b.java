package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemView;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.game.strategy.data.b, FrsGameStrategyItemView.FrsGameStrategyItemViewHolder> {
    private TbPageContext mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public FrsGameStrategyItemView.FrsGameStrategyItemViewHolder e(ViewGroup viewGroup) {
        return new FrsGameStrategyItemView.FrsGameStrategyItemViewHolder(new FrsGameStrategyItemView(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.game.strategy.data.b bVar, FrsGameStrategyItemView.FrsGameStrategyItemViewHolder frsGameStrategyItemViewHolder) {
        frsGameStrategyItemViewHolder.jAs.a(bVar);
        return frsGameStrategyItemViewHolder.getView();
    }
}
