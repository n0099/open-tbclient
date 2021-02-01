package com.baidu.tieba.ala.personcenter.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.personcenter.c.r;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.d, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.d.hZE);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.ala.personcenter.e.a> e(ViewGroup viewGroup) {
        return new CardViewHolder<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.ala.personcenter.c.d dVar, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a> cardViewHolder) {
        if (cardViewHolder.ctb() == null) {
            return null;
        }
        a(dVar, cardViewHolder.ctb());
        cardViewHolder.ctb().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.a(dVar);
            }
        });
        return cardViewHolder.ctb().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.d dVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = dVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.hZD != null) {
            aVar.wv(8);
            aVar.setTitle(personCenterData.hZD.name);
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.personcenter.c.d dVar) {
        if (dVar != null && dVar.getPersonCenterData() != null && dVar.getPersonCenterData().hZD != null) {
            r rVar = dVar.getPersonCenterData().hZD;
            com.baidu.tbadk.browser.a.startWebActivity((Context) this.mPageContext.getPageActivity(), true, rVar.url, rVar.name);
        }
    }
}
