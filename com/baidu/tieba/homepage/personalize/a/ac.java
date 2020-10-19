package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes22.dex */
public class ac extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.g, am<com.baidu.tieba.homepage.personalize.data.g>> {
    public BdUniqueId fey;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public am<com.baidu.tieba.homepage.personalize.data.g> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.personalize.view.d dVar = new com.baidu.tieba.homepage.personalize.view.d(this.mPageContext.getPageActivity(), this.mPageContext);
        dVar.setTag(this.mPageId);
        aVar.c(dVar);
        aVar.tU().bz(0);
        aVar.tU().bA(0);
        aVar.tU().bB(0);
        aVar.tU().by(0);
        aVar.tU().bv(0);
        ak tV = aVar.tV();
        tV.setSourceForPb(2);
        am<com.baidu.tieba.homepage.personalize.data.g> amVar = new am<>(tV);
        amVar.setPageId(this.fey);
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.g gVar, am<com.baidu.tieba.homepage.personalize.data.g> amVar) {
        if (gVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        TiebaStatic.log(new aq("c13742").aj("obj_source", 3).aj("obj_type", 1));
        amVar.b((am<com.baidu.tieba.homepage.personalize.data.g>) gVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return amVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
    }
}
