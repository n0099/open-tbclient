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
/* loaded from: classes6.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.h, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.h.exb);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.a> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.d.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.ala.personcenter.c.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.a> aVar) {
        if (aVar.baX() == null) {
            return null;
        }
        TiebaStatic.log("c13133");
        a(hVar, aVar.baX());
        aVar.baX().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                f.this.a(hVar);
            }
        });
        return aVar.baX().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.h hVar, com.baidu.tieba.ala.personcenter.d.a aVar) {
        if (hVar.getPersonCenterData() != null) {
            aVar.ol(8);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_my_fans_family));
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.personcenter.c.h hVar) {
        if (hVar != null && hVar.getPersonCenterData() != null) {
            TiebaStatic.log("c13134");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaFansFamilyActivityConfig(this.mContext, hVar.getPersonCenterData().aXC().user_id, true, AlaFansFamilyActivityConfig.FROM_PERSON_CENTER)));
        }
    }
}
