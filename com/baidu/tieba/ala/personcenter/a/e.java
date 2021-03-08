package com.baidu.tieba.ala.personcenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaAdminListActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.g, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.g.ibE);
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
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.ala.personcenter.c.g gVar, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a> cardViewHolder) {
        if (cardViewHolder.cto() == null) {
            return null;
        }
        a(gVar, cardViewHolder.cto());
        cardViewHolder.cto().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.a(gVar);
            }
        });
        return cardViewHolder.cto().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.g gVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        if (gVar.getPersonCenterData() != null) {
            aVar.ww(0);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_admin));
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.personcenter.c.g gVar) {
        if (gVar != null && gVar.getPersonCenterData() != null) {
            com.baidu.tieba.ala.personcenter.c.c personCenterData = gVar.getPersonCenterData();
            String str = "";
            if (personCenterData.cnc() != null && personCenterData.isHost()) {
                str = personCenterData.cnc().live_id;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaAdminListActivityConfig(this.mPageContext.getPageActivity(), str)));
        }
    }
}
