package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes16.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, ak<com.baidu.tieba.homepage.personalize.data.f>> {
    private com.baidu.adp.widget.ListView.v ajt;
    public BdUniqueId eEU;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak<com.baidu.tieba.homepage.personalize.data.f> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext, this.eEU));
        aVar.se().bq(0);
        aVar.se().bs(0);
        aVar.se().br(0);
        aVar.se().bm(0);
        ak<com.baidu.tieba.homepage.personalize.data.f> akVar = new ak<>(aVar.a(true, viewGroup, this.ajt));
        akVar.setPageId(this.eEU);
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.f fVar, ak<com.baidu.tieba.homepage.personalize.data.f> akVar) {
        if (fVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        akVar.b((ak<com.baidu.tieba.homepage.personalize.data.f>) fVar);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.s.bRL().e(fVar.cnC());
        com.baidu.tieba.a.d.brD().e(fVar.cnC());
        return akVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eEU = bdUniqueId;
    }
}
