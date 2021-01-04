package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.base.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.h;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.e.g;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<g, CardViewHolder<h>> {
    private h jyw;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), g.iDb);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<h> e(ViewGroup viewGroup) {
        this.jyw = new h(this.mPageContext);
        return new CardViewHolder<>(this.jyw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, CardViewHolder<h> cardViewHolder) {
        if (cardViewHolder.cvG() == null) {
            return null;
        }
        cardViewHolder.cvG().a(gVar);
        cardViewHolder.cvG().c(new aa<g>() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view2, g gVar2) {
                TiebaStatic.log(new aq("c13047").an("obj_locate", 1).dX("fid", f.this.mForumId));
                be.bwu().a((TbPageContext) j.K(view2.getContext()), new String[]{gVar2.cwz().score_url}, true);
            }
        });
        cardViewHolder.cvG().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.cvG().getView();
    }
}
