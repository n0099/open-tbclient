package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, ag<com.baidu.tieba.homepage.personalize.data.f>> {
    private com.baidu.adp.widget.ListView.t aib;
    public BdUniqueId epM;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag<com.baidu.tieba.homepage.personalize.data.f> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext, this.epM));
        aVar.rK().bi(0);
        aVar.rK().bk(0);
        aVar.rK().bj(0);
        aVar.rK().be(0);
        ag<com.baidu.tieba.homepage.personalize.data.f> agVar = new ag<>(aVar.a(true, viewGroup, this.aib));
        agVar.setPageId(this.epM);
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.f fVar, ag<com.baidu.tieba.homepage.personalize.data.f> agVar) {
        if (fVar == null || agVar == null || agVar.getView() == null) {
            return null;
        }
        agVar.b((ag<com.baidu.tieba.homepage.personalize.data.f>) fVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.s.bLs().e(fVar.cgA());
        com.baidu.tieba.a.d.bmb().e(fVar.cgA());
        return agVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.epM = bdUniqueId;
    }
}
