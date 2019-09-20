package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes4.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.o, com.baidu.tieba.card.a.a<com.baidu.tieba.card.s>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.o.eIC);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.card.s sVar = new com.baidu.tieba.card.s(this.mPageContext);
        sVar.S("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.a.a(sVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, com.baidu.tieba.card.a.a aVar) {
        aVar.baX().a(oVar);
        aVar.baX().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.t.bat().c(new an("c10718").bT(VideoPlayActivityConfig.OBJ_ID, String.valueOf(oVar.eID)));
        return aVar.getView();
    }
}
