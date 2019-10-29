package com.baidu.tieba.ala.personcenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.ab;
/* loaded from: classes6.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.d, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.b>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.d.exP);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.b> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.d.b(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.c.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.b> aVar) {
        if (aVar.baZ() == null) {
            return null;
        }
        aVar.baZ().a(dVar);
        aVar.baZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.baZ().d(new ab<com.baidu.tieba.ala.personcenter.c.d>() { // from class: com.baidu.tieba.ala.personcenter.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.ala.personcenter.c.d dVar2) {
                b.this.a(dVar2);
            }
        });
        return aVar.baZ().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.personcenter.c.d dVar) {
        com.baidu.tieba.ala.personcenter.c.b personCenterData;
        if (dVar != null && (personCenterData = dVar.getPersonCenterData()) != null && personCenterData.aXE() != null) {
            if (!personCenterData.isHost()) {
                TiebaStatic.log("c11864");
            } else {
                TiebaStatic.log("c11857");
            }
            int i = personCenterData.aXE().level_id;
            if (i >= 40) {
                i = 40;
            }
            int i2 = i + 1;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterExpActivityConfig(this.mPageContext.getPageActivity(), personCenterData.aXE().level_exp, i, personCenterData.aXE().next_exp, i2 <= 40 ? i2 : 40, personCenterData.isHost())));
        }
    }
}
