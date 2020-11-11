package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, am<com.baidu.tieba.homepage.personalize.data.f>> {
    private com.baidu.adp.widget.ListView.v alD;
    public BdUniqueId fsQ;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public am<com.baidu.tieba.homepage.personalize.data.f> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext, this.fsQ));
        aVar.tU().bz(0);
        aVar.tU().bB(0);
        aVar.tU().bA(0);
        aVar.tU().bv(0);
        am<com.baidu.tieba.homepage.personalize.data.f> amVar = new am<>(aVar.a(true, viewGroup, this.alD));
        amVar.setPageId(this.fsQ);
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.f fVar, am<com.baidu.tieba.homepage.personalize.data.f> amVar) {
        if (fVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.b((am<com.baidu.tieba.homepage.personalize.data.f>) fVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.t.cor().e(fVar.cLu());
        com.baidu.tieba.a.d.bIR().e(fVar.cLu());
        return amVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fsQ = bdUniqueId;
    }
}
