package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes9.dex */
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.topic.topictab.b.a, ak<com.baidu.tieba.homepage.topic.topictab.b.a>> implements com.baidu.tieba.a.f {
    private String afG;
    private NEGFeedBackView.a eTW;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public v(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak<com.baidu.tieba.homepage.topic.topictab.b.a> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.personalize.view.g gVar = new com.baidu.tieba.homepage.personalize.view.g(this.mContext, this.mPageContext);
        gVar.setTag(this.mPageId);
        aVar.c(gVar);
        aVar.sc().bo(0);
        aVar.sc().bp(0);
        aVar.sc().bq(0);
        aVar.sc().bn(0);
        aVar.sc().bk(0);
        ai sd = aVar.sd();
        sd.setSourceForPb(2);
        ak<com.baidu.tieba.homepage.topic.topictab.b.a> akVar = new ak<>(sd);
        akVar.setPageId(this.eyE);
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topictab.b.a aVar, ak<com.baidu.tieba.homepage.topic.topictab.b.a> akVar) {
        if (aVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        TiebaStatic.log(new ao("c13448").s("topic_id", aVar.topicId));
        akVar.se().setPage(this.afG);
        akVar.aI(false).a(this.eTW);
        akVar.b((ak<com.baidu.tieba.homepage.topic.topictab.b.a>) aVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eTW = aVar;
    }
}
