package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaFrsLiveListGatherNoDataTitleView;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.frsgamelive.b.a, AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder e(ViewGroup viewGroup) {
        return new AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder(new AlaFrsLiveListGatherNoDataTitleView(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.frsgamelive.b.a aVar, AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder alaFrsLiveListNoDataViewHolder) {
        return alaFrsLiveListNoDataViewHolder.getView();
    }
}
