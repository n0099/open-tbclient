package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes16.dex */
public class ac extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.g, al<com.baidu.tieba.homepage.personalize.data.g>> {
    public BdUniqueId ePz;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<com.baidu.tieba.homepage.personalize.data.g> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.personalize.view.d dVar = new com.baidu.tieba.homepage.personalize.view.d(this.mPageContext.getPageActivity(), this.mPageContext);
        dVar.setTag(this.mPageId);
        aVar.c(dVar);
        aVar.tP().bv(0);
        aVar.tP().bw(0);
        aVar.tP().bx(0);
        aVar.tP().bu(0);
        aVar.tP().br(0);
        aj tQ = aVar.tQ();
        tQ.setSourceForPb(2);
        al<com.baidu.tieba.homepage.personalize.data.g> alVar = new al<>(tQ);
        alVar.setPageId(this.ePz);
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.g gVar, al<com.baidu.tieba.homepage.personalize.data.g> alVar) {
        if (gVar == null || alVar == null || alVar.getView() == null) {
            return null;
        }
        TiebaStatic.log(new aq("c13742").ai("obj_source", 3).ai("obj_type", 1));
        alVar.b((al<com.baidu.tieba.homepage.personalize.data.g>) gVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return alVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
    }
}
