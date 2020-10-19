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
/* loaded from: classes4.dex */
public class l extends com.baidu.adp.widget.ListView.a<o, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private com.baidu.tieba.ala.personcenter.d.a hlE;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext tbPageContext, com.baidu.tieba.ala.personcenter.d.a aVar) {
        super(tbPageContext.getPageActivity(), o.hmx);
        this.mPageContext = tbPageContext;
        this.hlE = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.cjq() == null) {
            return null;
        }
        a(oVar, aVar.cjq());
        aVar.cjq().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                l.this.a(oVar);
            }
        });
        return aVar.cjq().getView();
    }

    private void a(o oVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = oVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.cdY() != null) {
            aVar.vT(0);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_real_authen));
            AlaUserInfoData cdY = personCenterData.cdY();
            if (cdY.certify_status == 0) {
                aVar.HV(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_unauthorized));
                aVar.vU(0);
            } else if (1 == cdY.certify_status) {
                aVar.HV(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_in_review));
                aVar.vU(4);
            } else if (2 == cdY.certify_status) {
                aVar.HV(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_authenticated));
                aVar.vU(4);
            } else if (3 == cdY.certify_status) {
                aVar.HV(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_denied));
                aVar.vU(0);
            }
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar) {
        if (oVar != null && oVar.getPersonCenterData() != null && oVar.getPersonCenterData().cdY() != null) {
            AlaUserInfoData cdY = oVar.getPersonCenterData().cdY();
            if (1 != cdY.certify_status && 2 != cdY.certify_status) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterRealAuthenConfig(this.mContext, cdY.user_id, cdY.certify_status + "")));
                if (this.hlE != null) {
                    this.hlE.vP(1);
                }
            }
        }
    }
}
