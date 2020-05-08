package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, af<com.baidu.tieba.homepage.personalize.data.f>> {
    private com.baidu.adp.widget.ListView.r ahy;
    public BdUniqueId ebA;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public af<com.baidu.tieba.homepage.personalize.data.f> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext, this.ebA));
        aVar.rB().bh(0);
        aVar.rB().bj(0);
        aVar.rB().bi(0);
        aVar.rB().bd(0);
        af<com.baidu.tieba.homepage.personalize.data.f> afVar = new af<>(aVar.a(true, viewGroup, this.ahy));
        afVar.setPageId(this.ebA);
        an anVar = new an("c13620");
        anVar.t("uid", TbadkApplication.getCurrentAccountId());
        anVar.af("fid", 0);
        TiebaStatic.log(anVar);
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.f fVar, af<com.baidu.tieba.homepage.personalize.data.f> afVar) {
        if (fVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        afVar.b((af<com.baidu.tieba.homepage.personalize.data.f>) fVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return afVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ebA = bdUniqueId;
    }
}
