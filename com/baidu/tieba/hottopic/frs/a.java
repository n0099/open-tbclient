package com.baidu.tieba.hottopic.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.card.x;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.k;
/* loaded from: classes8.dex */
public class a extends k<cb, CardViewHolder<x>> implements y {
    private ab<cb> gCz;
    private String mFrom;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.gCz = new ab<cb>() { // from class: com.baidu.tieba.hottopic.frs.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, cb cbVar, Object obj) {
            }
        };
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.frs.k
    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mPageContext = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.card.y
    public String csD() {
        return "FrsHottopicVideoDelegateAdapter";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<x> e(ViewGroup viewGroup) {
        return new CardViewHolder<>(new x(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cb cbVar, CardViewHolder<x> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.cti() == null) {
            return null;
        }
        cardViewHolder.cti().c(this.gCz);
        cardViewHolder.cti().a(cbVar);
        return cardViewHolder.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setFrom(String str) {
        this.mFrom = str;
    }
}
