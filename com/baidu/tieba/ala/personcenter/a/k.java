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
import com.baidu.tieba.ala.personcenter.c.n;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.widget.ListView.a<n, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private com.baidu.tieba.ala.personcenter.d.a gnT;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext tbPageContext, com.baidu.tieba.ala.personcenter.d.a aVar) {
        super(tbPageContext.getPageActivity(), n.goL);
        this.mPageContext = tbPageContext;
        this.gnT = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final n nVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.bLU() == null) {
            return null;
        }
        a(nVar, aVar.bLU());
        aVar.bLU().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.a(nVar);
            }
        });
        return aVar.bLU().getView();
    }

    private void a(n nVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = nVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.bIn() != null) {
            aVar.rO(0);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_real_authen));
            AlaUserInfoData bIn = personCenterData.bIn();
            if (bIn.certify_status == 0) {
                aVar.Dc(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_unauthorized));
                aVar.rP(0);
            } else if (1 == bIn.certify_status) {
                aVar.Dc(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_in_review));
                aVar.rP(4);
            } else if (2 == bIn.certify_status) {
                aVar.Dc(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_authenticated));
                aVar.rP(4);
            } else if (3 == bIn.certify_status) {
                aVar.Dc(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_denied));
                aVar.rP(0);
            }
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar != null && nVar.getPersonCenterData() != null && nVar.getPersonCenterData().bIn() != null) {
            AlaUserInfoData bIn = nVar.getPersonCenterData().bIn();
            if (1 != bIn.certify_status && 2 != bIn.certify_status) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterRealAuthenConfig(this.mContext, bIn.user_id, bIn.certify_status + "")));
                if (this.gnT != null) {
                    this.gnT.rK(1);
                }
            }
        }
    }
}
