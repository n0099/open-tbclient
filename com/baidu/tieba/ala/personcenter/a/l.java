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
/* loaded from: classes6.dex */
public class l extends com.baidu.adp.widget.ListView.a<o, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private com.baidu.tieba.ala.personcenter.d.a hMM;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext tbPageContext, com.baidu.tieba.ala.personcenter.d.a aVar) {
        super(tbPageContext.getPageActivity(), o.hNF);
        this.mPageContext = tbPageContext;
        this.hMM = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.csN() == null) {
            return null;
        }
        a(oVar, aVar.csN());
        aVar.csN().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                l.this.a(oVar);
            }
        });
        return aVar.csN().getView();
    }

    private void a(o oVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = oVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.cmQ() != null) {
            aVar.xD(0);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_real_authen));
            AlaUserInfoData cmQ = personCenterData.cmQ();
            if (cmQ.certify_status == 0) {
                aVar.Jb(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_unauthorized));
                aVar.xE(0);
            } else if (1 == cmQ.certify_status) {
                aVar.Jb(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_in_review));
                aVar.xE(4);
            } else if (2 == cmQ.certify_status) {
                aVar.Jb(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_authenticated));
                aVar.xE(4);
            } else if (3 == cmQ.certify_status) {
                aVar.Jb(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_denied));
                aVar.xE(0);
            }
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar) {
        if (oVar != null && oVar.getPersonCenterData() != null && oVar.getPersonCenterData().cmQ() != null) {
            AlaUserInfoData cmQ = oVar.getPersonCenterData().cmQ();
            if (1 != cmQ.certify_status && 2 != cmQ.certify_status) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterRealAuthenConfig(this.mContext, cmQ.user_id, cmQ.certify_status + "")));
                if (this.hMM != null) {
                    this.hMM.xz(1);
                }
            }
        }
    }
}
