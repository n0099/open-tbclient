package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes16.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, al<com.baidu.tieba.homepage.personalize.data.f>> {
    private com.baidu.adp.widget.ListView.v akK;
    public BdUniqueId ePz;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<com.baidu.tieba.homepage.personalize.data.f> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext, this.ePz));
        aVar.tP().bv(0);
        aVar.tP().bx(0);
        aVar.tP().bw(0);
        aVar.tP().br(0);
        al<com.baidu.tieba.homepage.personalize.data.f> alVar = new al<>(aVar.a(true, viewGroup, this.akK));
        alVar.setPageId(this.ePz);
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.f fVar, al<com.baidu.tieba.homepage.personalize.data.f> alVar) {
        if (fVar == null || alVar == null || alVar.getView() == null) {
            return null;
        }
        alVar.b((al<com.baidu.tieba.homepage.personalize.data.f>) fVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.s.cbY().e(fVar.cyw());
        com.baidu.tieba.a.d.bAB().e(fVar.cyw());
        return alVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ePz = bdUniqueId;
    }
}
