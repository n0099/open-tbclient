package com.baidu.tieba.ala.personcenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaPersonCenterRealAuthenConfig;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.o;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes10.dex */
public class l extends com.baidu.adp.widget.ListView.a<o, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a>> {
    private com.baidu.tieba.ala.personcenter.d.a hZl;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext tbPageContext, com.baidu.tieba.ala.personcenter.d.a aVar) {
        super(tbPageContext.getPageActivity(), o.iad);
        this.mPageContext = tbPageContext;
        this.hZl = aVar;
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
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, CardViewHolder<com.baidu.tieba.ala.personcenter.e.a> cardViewHolder) {
        if (cardViewHolder.cti() == null) {
            return null;
        }
        a(oVar, cardViewHolder.cti());
        cardViewHolder.cti().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                l.this.a(oVar);
            }
        });
        return cardViewHolder.cti().getView();
    }

    private void a(o oVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = oVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.cmW() != null) {
            aVar.wv(0);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_real_authen));
            AlaUserInfoData cmW = personCenterData.cmW();
            if (cmW.certify_status == 0) {
                aVar.Is(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_unauthorized));
                aVar.ww(0);
            } else if (1 == cmW.certify_status) {
                aVar.Is(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_in_review));
                aVar.ww(4);
            } else if (2 == cmW.certify_status) {
                aVar.Is(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_authenticated));
                aVar.ww(4);
            } else if (3 == cmW.certify_status) {
                aVar.Is(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_denied));
                aVar.ww(0);
            }
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar) {
        if (oVar != null && oVar.getPersonCenterData() != null && oVar.getPersonCenterData().cmW() != null) {
            AlaUserInfoData cmW = oVar.getPersonCenterData().cmW();
            if (1 != cmW.certify_status && 2 != cmW.certify_status) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterRealAuthenConfig(this.mContext, cmW.user_id, cmW.certify_status + "")));
                if (this.hZl != null) {
                    this.hZl.wr(1);
                }
            }
        }
    }
}
