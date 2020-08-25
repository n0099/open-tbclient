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
/* loaded from: classes4.dex */
public class k extends com.baidu.adp.widget.ListView.a<n, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private com.baidu.tieba.ala.personcenter.d.a gST;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext tbPageContext, com.baidu.tieba.ala.personcenter.d.a aVar) {
        super(tbPageContext.getPageActivity(), n.gTL);
        this.mPageContext = tbPageContext;
        this.gST = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final n nVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.ccE() == null) {
            return null;
        }
        a(nVar, aVar.ccE());
        aVar.ccE().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.a(nVar);
            }
        });
        return aVar.ccE().getView();
    }

    private void a(n nVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = nVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.bYD() != null) {
            aVar.uU(0);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_real_authen));
            AlaUserInfoData bYD = personCenterData.bYD();
            if (bYD.certify_status == 0) {
                aVar.GN(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_unauthorized));
                aVar.uV(0);
            } else if (1 == bYD.certify_status) {
                aVar.GN(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_in_review));
                aVar.uV(4);
            } else if (2 == bYD.certify_status) {
                aVar.GN(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_authenticated));
                aVar.uV(4);
            } else if (3 == bYD.certify_status) {
                aVar.GN(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_denied));
                aVar.uV(0);
            }
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar != null && nVar.getPersonCenterData() != null && nVar.getPersonCenterData().bYD() != null) {
            AlaUserInfoData bYD = nVar.getPersonCenterData().bYD();
            if (1 != bYD.certify_status && 2 != bYD.certify_status) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterRealAuthenConfig(this.mContext, bYD.user_id, bYD.certify_status + "")));
                if (this.gST != null) {
                    this.gST.uQ(1);
                }
            }
        }
    }
}
