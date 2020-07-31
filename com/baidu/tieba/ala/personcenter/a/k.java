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
    private com.baidu.tieba.ala.personcenter.d.a gGr;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext tbPageContext, com.baidu.tieba.ala.personcenter.d.a aVar) {
        super(tbPageContext.getPageActivity(), n.gHi);
        this.mPageContext = tbPageContext;
        this.gGr = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final n nVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.bSs() == null) {
            return null;
        }
        a(nVar, aVar.bSs());
        aVar.bSs().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.a(nVar);
            }
        });
        return aVar.bSs().getView();
    }

    private void a(n nVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = nVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.bOD() != null) {
            aVar.sG(0);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_real_authen));
            AlaUserInfoData bOD = personCenterData.bOD();
            if (bOD.certify_status == 0) {
                aVar.Eo(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_unauthorized));
                aVar.sH(0);
            } else if (1 == bOD.certify_status) {
                aVar.Eo(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_in_review));
                aVar.sH(4);
            } else if (2 == bOD.certify_status) {
                aVar.Eo(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_authenticated));
                aVar.sH(4);
            } else if (3 == bOD.certify_status) {
                aVar.Eo(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_denied));
                aVar.sH(0);
            }
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar != null && nVar.getPersonCenterData() != null && nVar.getPersonCenterData().bOD() != null) {
            AlaUserInfoData bOD = nVar.getPersonCenterData().bOD();
            if (1 != bOD.certify_status && 2 != bOD.certify_status) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterRealAuthenConfig(this.mContext, bOD.user_id, bOD.certify_status + "")));
                if (this.gGr != null) {
                    this.gGr.sC(1);
                }
            }
        }
    }
}
