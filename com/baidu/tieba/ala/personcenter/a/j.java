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
import com.baidu.tieba.ala.personcenter.c.l;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private com.baidu.tieba.ala.personcenter.d.a fuw;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext tbPageContext, com.baidu.tieba.ala.personcenter.d.a aVar) {
        super(tbPageContext.getPageActivity(), l.fvl);
        this.mPageContext = tbPageContext;
        this.fuw = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.bvQ() == null) {
            return null;
        }
        a(lVar, aVar.bvQ());
        aVar.bvQ().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.a(lVar);
            }
        });
        return aVar.bvQ().getView();
    }

    private void a(l lVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        com.baidu.tieba.ala.personcenter.c.b personCenterData = lVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.bso() != null) {
            aVar.qS(0);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_real_authen));
            AlaUserInfoData bso = personCenterData.bso();
            if (bso.certify_status == 0) {
                aVar.zK(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_unauthorized));
                aVar.qT(0);
            } else if (1 == bso.certify_status) {
                aVar.zK(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_in_review));
                aVar.qT(4);
            } else if (2 == bso.certify_status) {
                aVar.zK(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_authenticated));
                aVar.qT(4);
            } else if (3 == bso.certify_status) {
                aVar.zK(this.mContext.getResources().getString(R.string.ala_person_live_real_authen_denied));
                aVar.qT(0);
            }
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        if (lVar != null && lVar.getPersonCenterData() != null && lVar.getPersonCenterData().bso() != null) {
            AlaUserInfoData bso = lVar.getPersonCenterData().bso();
            if (1 != bso.certify_status && 2 != bso.certify_status) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterRealAuthenConfig(this.mContext, bso.user_id, bso.certify_status + "")));
                if (this.fuw != null) {
                    this.fuw.qO(1);
                }
            }
        }
    }
}
