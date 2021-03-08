package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveNormalCardView;
/* loaded from: classes9.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.frsgamelive.b.c, AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder> {
    private com.baidu.tieba.ala.h gWU;
    private TbPageContext gXc;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gXc = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder e(ViewGroup viewGroup) {
        return new AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder(new AlaGameFrsLiveNormalCardView(this.gXc));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.frsgamelive.b.c cVar, AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder alaGameFrsNormalViewHolder) {
        alaGameFrsNormalViewHolder.gYC.a(cVar);
        alaGameFrsNormalViewHolder.gYC.c(this.gWU);
        return alaGameFrsNormalViewHolder.getView();
    }

    public void a(com.baidu.tieba.ala.h hVar) {
        this.gWU = hVar;
    }
}
