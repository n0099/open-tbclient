package com.baidu.tieba.ala.personcenter.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.personcenter.c.n;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes10.dex */
public class k extends com.baidu.adp.widget.ListView.a<n, CardViewHolder<com.baidu.tieba.ala.personcenter.e.c>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), n.iaa);
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
        if (cardViewHolder.cvG() == null) {
            return null;
        }
        a(nVar, cardViewHolder.cvG());
        return cardViewHolder.cvG().getView();
    }

    private void a(n nVar, com.baidu.tieba.ala.personcenter.e.c cVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = nVar.getPersonCenterData();
        if (personCenterData == null || personCenterData.cpH() == null || TextUtils.isEmpty(personCenterData.cpH().cpG())) {
            cVar.setVisibility(8);
            notifyDataSetChanged();
            return;
        }
        cVar.Ja(personCenterData.cpH().cpG());
        cVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        notifyDataSetChanged();
    }
}
