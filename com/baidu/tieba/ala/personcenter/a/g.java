package com.baidu.tieba.ala.personcenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaFansFamilyActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes10.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.j, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.j.hZW);
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
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.ala.personcenter.c.j jVar, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a> cardViewHolder) {
        if (cardViewHolder.cvH() == null) {
            return null;
        }
        TiebaStatic.log("c13133");
        a(jVar, cardViewHolder.cvH());
        cardViewHolder.cvH().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.a(jVar);
            }
        });
        return cardViewHolder.cvH().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.j jVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        if (jVar.getPersonCenterData() != null) {
            aVar.xQ(8);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_my_fans_family));
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.personcenter.c.j jVar) {
        if (jVar != null && jVar.getPersonCenterData() != null) {
            TiebaStatic.log("c13134");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaFansFamilyActivityConfig(this.mContext, jVar.getPersonCenterData().cpJ().user_id, true, AlaFansFamilyActivityConfig.FROM_PERSON_CENTER)));
        }
    }
}
