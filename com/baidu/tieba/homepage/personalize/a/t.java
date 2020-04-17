package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.topic.topictab.b.a, af<com.baidu.tieba.homepage.topic.topictab.b.a>> implements com.baidu.tieba.a.f {
    private String aey;
    public BdUniqueId ebv;
    private NEGFeedBackView.a euS;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public af<com.baidu.tieba.homepage.topic.topictab.b.a> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.personalize.view.g gVar = new com.baidu.tieba.homepage.personalize.view.g(this.mContext, this.mPageContext);
        gVar.setTag(this.mPageId);
        aVar.c(gVar);
        aVar.rB().bh(0);
        aVar.rB().bi(0);
        aVar.rB().bj(0);
        aVar.rB().bg(0);
        aVar.rB().bd(0);
        com.baidu.card.ad rC = aVar.rC();
        rC.bc(2);
        af<com.baidu.tieba.homepage.topic.topictab.b.a> afVar = new af<>(rC);
        afVar.setPageId(this.ebv);
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topictab.b.a aVar, af<com.baidu.tieba.homepage.topic.topictab.b.a> afVar) {
        if (aVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        TiebaStatic.log(new an("c13448").t("topic_id", aVar.topicId));
        afVar.rD().setPage(this.aey);
        com.baidu.card.w aF = afVar.aF(false);
        aF.bb(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds19));
        aF.a(this.euS);
        afVar.b((af<com.baidu.tieba.homepage.topic.topictab.b.a>) aVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.euS = aVar;
    }
}
