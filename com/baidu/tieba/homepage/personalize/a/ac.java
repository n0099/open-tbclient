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
public class ac extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.g, ak<com.baidu.tieba.homepage.personalize.data.g>> {
    public BdUniqueId eyE;
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
    public ak<com.baidu.tieba.homepage.personalize.data.g> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.personalize.view.d dVar = new com.baidu.tieba.homepage.personalize.view.d(this.mPageContext.getPageActivity(), this.mPageContext);
        dVar.setTag(this.mPageId);
        aVar.c(dVar);
        aVar.sc().bo(0);
        aVar.sc().bp(0);
        aVar.sc().bq(0);
        aVar.sc().bn(0);
        aVar.sc().bk(0);
        ai sd = aVar.sd();
        sd.setSourceForPb(2);
        ak<com.baidu.tieba.homepage.personalize.data.g> akVar = new ak<>(sd);
        akVar.setPageId(this.eyE);
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.g gVar, ak<com.baidu.tieba.homepage.personalize.data.g> akVar) {
        if (gVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        TiebaStatic.log(new ao("c13742").ag("obj_source", 3).ag("obj_type", 1));
        akVar.b((ak<com.baidu.tieba.homepage.personalize.data.g>) gVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return akVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
    }
}
