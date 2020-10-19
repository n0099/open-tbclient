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
import com.baidu.tieba.card.aa;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.f, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.b>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.f.hmo);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.b> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.b(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.c.f fVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.b> aVar) {
        if (aVar.cjq() == null) {
            return null;
        }
        aVar.cjq().a(fVar);
        aVar.cjq().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.cjq().c(new aa<com.baidu.tieba.ala.personcenter.c.f>() { // from class: com.baidu.tieba.ala.personcenter.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view2, com.baidu.tieba.ala.personcenter.c.f fVar2) {
                c.this.a(fVar2);
            }
        });
        return aVar.cjq().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.personcenter.c.f fVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData;
        if (fVar != null && (personCenterData = fVar.getPersonCenterData()) != null && personCenterData.cdY() != null) {
            if (!personCenterData.isHost()) {
                TiebaStatic.log("c11864");
            } else {
                TiebaStatic.log("c11857");
            }
            int i = personCenterData.cdY().level_id;
            if (i >= 40) {
                i = 40;
            }
            int i2 = i + 1;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterExpActivityConfig(this.mPageContext.getPageActivity(), personCenterData.cdY().level_exp, i, personCenterData.cdY().next_exp, i2 <= 40 ? i2 : 40, personCenterData.isHost())));
        }
    }
}
