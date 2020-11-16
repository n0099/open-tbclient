package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, am<com.baidu.tieba.homepage.personalize.data.f>> {
    private com.baidu.adp.widget.ListView.v alH;
    public BdUniqueId fsa;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<com.baidu.tieba.homepage.personalize.data.f> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.c(new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext, this.fsa));
        aVar.tV().bx(0);
        aVar.tV().bz(0);
        aVar.tV().by(0);
        aVar.tV().bv(0);
        am<com.baidu.tieba.homepage.personalize.data.f> amVar = new am<>(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.alH));
        amVar.setPageId(this.fsa);
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
        com.baidu.tieba.card.t.cnT().e(fVar.cLa());
        com.baidu.tieba.a.d.bIl().e(fVar.cLa());
        return amVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fsa = bdUniqueId;
    }
}
