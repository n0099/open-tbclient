package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveNormalCardView;
/* loaded from: classes10.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.frsgamelive.b.c, AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder> {
    private com.baidu.tieba.ala.g gWT;
    private TbPageContext gXb;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gXb = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder e(ViewGroup viewGroup) {
        return new AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder(new AlaGameFrsLiveNormalCardView(this.gXb));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.frsgamelive.b.c cVar, AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder alaGameFrsNormalViewHolder) {
        alaGameFrsNormalViewHolder.gYB.a(cVar);
        alaGameFrsNormalViewHolder.gYB.c(this.gWT);
        return alaGameFrsNormalViewHolder.getView();
    }

    public void a(com.baidu.tieba.ala.g gVar) {
        this.gWT = gVar;
    }
}
