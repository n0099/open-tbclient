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
    private com.baidu.tieba.ala.personcenter.d.a hxz;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext tbPageContext, com.baidu.tieba.ala.personcenter.d.a aVar) {
        super(tbPageContext.getPageActivity(), o.hys);
        this.mPageContext = tbPageContext;
        this.hxz = aVar;
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
        if (aVar.cmx() == null) {
            return null;
        }
        a(oVar, aVar.cmx());
        aVar.cmx().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                l.this.a(oVar);
            }
        });
        return aVar.cmx().getView();
    }

    private void a(o oVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = oVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.cha() != null) {
            aVar.wn(0);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_real_authen));
            AlaUserInfoData cha = personCenterData.cha();
            if (cha.certify_status == 0) {
                aVar.Iu(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_unauthorized));
                aVar.wo(0);
            } else if (1 == cha.certify_status) {
                aVar.Iu(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_in_review));
                aVar.wo(4);
            } else if (2 == cha.certify_status) {
                aVar.Iu(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_authenticated));
                aVar.wo(4);
            } else if (3 == cha.certify_status) {
                aVar.Iu(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_denied));
                aVar.wo(0);
            }
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar) {
        if (oVar != null && oVar.getPersonCenterData() != null && oVar.getPersonCenterData().cha() != null) {
            AlaUserInfoData cha = oVar.getPersonCenterData().cha();
            if (1 != cha.certify_status && 2 != cha.certify_status) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterRealAuthenConfig(this.mContext, cha.user_id, cha.certify_status + "")));
                if (this.hxz != null) {
                    this.hxz.wj(1);
                }
            }
        }
    }
}
