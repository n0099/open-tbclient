package com.baidu.tieba.ala.personcenter.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.personcenter.c.r;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.d, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.d.hmm);
        this.mPageContext = tbPageContext;
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
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.ala.personcenter.c.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.cjq() == null) {
            return null;
        }
        a(dVar, aVar.cjq());
        aVar.cjq().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.a(dVar);
            }
        });
        return aVar.cjq().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.d dVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = dVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.hml != null) {
            aVar.vT(8);
            aVar.setTitle(personCenterData.hml.name);
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.personcenter.c.d dVar) {
        if (dVar != null && dVar.getPersonCenterData() != null && dVar.getPersonCenterData().hml != null) {
            r rVar = dVar.getPersonCenterData().hml;
            com.baidu.tbadk.browser.a.startWebActivity((Context) this.mPageContext.getPageActivity(), true, rVar.url, rVar.name);
        }
    }
}
