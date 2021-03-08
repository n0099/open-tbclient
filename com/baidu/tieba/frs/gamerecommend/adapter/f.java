package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.base.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.h;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.e.g;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<g, CardViewHolder<h>> {
    private h jBt;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), g.iGb);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<h> e(ViewGroup viewGroup) {
        this.jBt = new h(this.mPageContext);
        return new CardViewHolder<>(this.jBt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, CardViewHolder<h> cardViewHolder) {
        if (cardViewHolder.cto() == null) {
            return null;
        }
        cardViewHolder.cto().a(gVar);
        cardViewHolder.cto().c(new ab<g>() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, g gVar2) {
                TiebaStatic.log(new ar("c13047").aq("obj_locate", 1).dR("fid", f.this.mForumId));
                bf.bsY().a((TbPageContext) j.J(view2.getContext()), new String[]{gVar2.cuh().score_url}, true);
            }
        });
        cardViewHolder.cto().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.cto().getView();
    }
}
