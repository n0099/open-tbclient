package com.baidu.tieba.ala.personcenter.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes9.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.h, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.h.ibF);
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.c.h hVar, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a> cardViewHolder) {
        if (cardViewHolder.cto() == null) {
            return null;
        }
        a(hVar, cardViewHolder.cto());
        cardViewHolder.cto().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                f.this.abx();
            }
        });
        return cardViewHolder.cto().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.h hVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        aVar.ww(8);
        aVar.setTitle(this.mContext.getResources().getString(R.string.ala_income_value));
        aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abx() {
        com.baidu.tbadk.browser.a.startWebActivity((Context) this.mPageContext.getPageActivity(), true, com.baidu.tbadk.core.sharedPref.b.brR().getString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives"), this.mContext.getResources().getString(R.string.ala_income_value));
    }
}
