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
import com.baidu.tieba.ala.personcenter.c.k;
/* loaded from: classes3.dex */
public class i extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private com.baidu.tieba.ala.personcenter.d.a ftJ;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext tbPageContext, com.baidu.tieba.ala.personcenter.d.a aVar) {
        super(tbPageContext.getPageActivity(), k.fus);
        this.mPageContext = tbPageContext;
        this.ftJ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.bvK() == null) {
            return null;
        }
        a(kVar, aVar.bvK());
        aVar.bvK().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.a(kVar);
            }
        });
        return aVar.bvK().getView();
    }

    private void a(k kVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        com.baidu.tieba.ala.personcenter.c.b personCenterData = kVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.bsh() != null) {
            aVar.qQ(0);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_real_authen));
            AlaUserInfoData bsh = personCenterData.bsh();
            if (bsh.certify_status == 0) {
                aVar.zI(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_unauthorized));
                aVar.qR(0);
            } else if (1 == bsh.certify_status) {
                aVar.zI(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_in_review));
                aVar.qR(4);
            } else if (2 == bsh.certify_status) {
                aVar.zI(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_authenticated));
                aVar.qR(4);
            } else if (3 == bsh.certify_status) {
                aVar.zI(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_denied));
                aVar.qR(0);
            }
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar) {
        if (kVar != null && kVar.getPersonCenterData() != null && kVar.getPersonCenterData().bsh() != null) {
            AlaUserInfoData bsh = kVar.getPersonCenterData().bsh();
            if (1 != bsh.certify_status && 2 != bsh.certify_status) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterRealAuthenConfig(this.mContext, bsh.user_id, bsh.certify_status + "")));
                if (this.ftJ != null) {
                    this.ftJ.qM(1);
                }
            }
        }
    }
}
