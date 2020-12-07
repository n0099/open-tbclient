package com.baidu.tieba.ala.personcenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.ab;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.f, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.b>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.f.hNu);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.b> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.b(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.c.f fVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.b> aVar) {
        if (aVar.csM() == null) {
            return null;
        }
        aVar.csM().a(fVar);
        aVar.csM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.csM().c(new ab<com.baidu.tieba.ala.personcenter.c.f>() { // from class: com.baidu.tieba.ala.personcenter.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.ala.personcenter.c.f fVar2) {
                c.this.a(fVar2);
            }
        });
        return aVar.csM().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.personcenter.c.f fVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData;
        if (fVar != null && (personCenterData = fVar.getPersonCenterData()) != null && personCenterData.cmP() != null) {
            if (!personCenterData.isHost()) {
                TiebaStatic.log("c11864");
            } else {
                TiebaStatic.log("c11857");
            }
            String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
            if (string != null) {
                if (string.endsWith("/")) {
                    string = string.substring(0, string.length() - 1);
                }
                com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), string);
            }
        }
    }
}
