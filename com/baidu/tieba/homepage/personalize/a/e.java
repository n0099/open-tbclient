package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, am<com.baidu.tieba.homepage.personalize.data.f>> {
    private com.baidu.adp.widget.ListView.v amH;
    public BdUniqueId fzO;
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
        aVar.c(new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext, this.fzO));
        aVar.tY().bB(0);
        aVar.tY().bD(0);
        aVar.tY().bC(0);
        aVar.tY().bz(0);
        am<com.baidu.tieba.homepage.personalize.data.f> amVar = new am<>(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.amH));
        amVar.setPageId(this.fzO);
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
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.t.csh().e(fVar.cQp());
        com.baidu.tieba.a.d.bLU().e(fVar.cQp());
        return amVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fzO = bdUniqueId;
    }
}
