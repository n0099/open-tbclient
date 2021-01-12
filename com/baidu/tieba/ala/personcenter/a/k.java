package com.baidu.tieba.ala.personcenter.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.personcenter.c.n;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes9.dex */
public class k extends com.baidu.adp.widget.ListView.a<n, CardViewHolder<com.baidu.tieba.ala.personcenter.e.c>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), n.hVt);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.ala.personcenter.e.c> e(ViewGroup viewGroup) {
        return new CardViewHolder<>(new com.baidu.tieba.ala.personcenter.e.c(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, CardViewHolder<com.baidu.tieba.ala.personcenter.e.c> cardViewHolder) {
        if (cardViewHolder.crP() == null) {
            return null;
        }
        a(nVar, cardViewHolder.crP());
        return cardViewHolder.crP().getView();
    }

    private void a(n nVar, com.baidu.tieba.ala.personcenter.e.c cVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = nVar.getPersonCenterData();
        if (personCenterData == null || personCenterData.clQ() == null || TextUtils.isEmpty(personCenterData.clQ().clP())) {
            cVar.setVisibility(8);
            notifyDataSetChanged();
            return;
        }
        cVar.HO(personCenterData.clQ().clP());
        cVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        notifyDataSetChanged();
    }
}
