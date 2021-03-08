package com.baidu.tieba.ala.personcenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaForbiddenListActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.e, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.e.ibC);
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.c.e eVar, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a> cardViewHolder) {
        if (cardViewHolder.cto() == null) {
            return null;
        }
        a(eVar, cardViewHolder.cto());
        cardViewHolder.cto().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.abx();
            }
        });
        return cardViewHolder.cto().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.e eVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        aVar.ww(8);
        aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_forbidden));
        aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaForbiddenListActivityConfig(this.mPageContext.getPageActivity())));
    }
}
