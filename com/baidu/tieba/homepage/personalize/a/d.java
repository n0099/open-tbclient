package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, ak<com.baidu.tieba.homepage.personalize.data.f>> {
    private com.baidu.adp.widget.ListView.v ajy;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak<com.baidu.tieba.homepage.personalize.data.f> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext, this.eyE));
        aVar.sc().bo(0);
        aVar.sc().bq(0);
        aVar.sc().bp(0);
        aVar.sc().bk(0);
        ak<com.baidu.tieba.homepage.personalize.data.f> akVar = new ak<>(aVar.a(true, viewGroup, this.ajy));
        akVar.setPageId(this.eyE);
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
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.s.bOA().e(fVar.cka());
        com.baidu.tieba.a.d.boA().e(fVar.cka());
        return akVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eyE = bdUniqueId;
    }
}
