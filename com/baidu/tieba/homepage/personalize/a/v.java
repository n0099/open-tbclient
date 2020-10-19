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
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.topic.topictab.b.a, am<com.baidu.tieba.homepage.topic.topictab.b.a>> implements com.baidu.tieba.a.f {
    private String aht;
    private NEGFeedBackView.a fAU;
    public BdUniqueId fey;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public v(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public am<com.baidu.tieba.homepage.topic.topictab.b.a> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.personalize.view.g gVar = new com.baidu.tieba.homepage.personalize.view.g(this.mContext, this.mPageContext);
        gVar.setTag(this.mPageId);
        aVar.c(gVar);
        aVar.tU().bz(0);
        aVar.tU().bA(0);
        aVar.tU().bB(0);
        aVar.tU().by(0);
        aVar.tU().bv(0);
        ak tV = aVar.tV();
        tV.setSourceForPb(2);
        am<com.baidu.tieba.homepage.topic.topictab.b.a> amVar = new am<>(tV);
        amVar.setPageId(this.fey);
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topictab.b.a aVar, am<com.baidu.tieba.homepage.topic.topictab.b.a> amVar) {
        if (aVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        TiebaStatic.log(new aq("c13448").u("topic_id", aVar.topicId));
        amVar.tW().setPage(this.aht);
        amVar.aL(false).a(this.fAU);
        amVar.b((am<com.baidu.tieba.homepage.topic.topictab.b.a>) aVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
        this.aht = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fAU = aVar;
    }
}
