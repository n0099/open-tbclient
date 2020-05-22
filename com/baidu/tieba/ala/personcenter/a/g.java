package com.baidu.tieba.ala.personcenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaLoveFamilyActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.j, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.j.goH);
        this.mPageContext = tbPageContext;
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
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.ala.personcenter.c.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.bLU() == null) {
            return null;
        }
        a(jVar, aVar.bLU());
        aVar.bLU().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.a(jVar);
            }
        });
        return aVar.bLU().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.j jVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        if (jVar.getPersonCenterData() != null) {
            aVar.rO(8);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_my_love_family));
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.personcenter.c.j jVar) {
        if (jVar != null && jVar.getPersonCenterData() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLoveFamilyActivityConfig(this.mContext, jVar.getPersonCenterData().bIn().user_id)));
        }
    }
}
