package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes4.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.topic.topictab.b.a, z<com.baidu.tieba.homepage.topic.topictab.b.a>> implements com.baidu.tieba.a.f {
    private String WM;
    private NEGFeedBackView.a cTD;
    public BdUniqueId cyA;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public z<com.baidu.tieba.homepage.topic.topictab.b.a> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.personalize.view.e eVar = new com.baidu.tieba.homepage.personalize.view.e(this.mContext, this.mPageContext);
        eVar.setTag(this.mPageId);
        aVar.b(eVar);
        aVar.qO().bt(0);
        aVar.qO().bu(0);
        aVar.qO().bv(0);
        aVar.qO().bs(0);
        aVar.qO().br(0);
        x qP = aVar.qP();
        qP.bq(2);
        z<com.baidu.tieba.homepage.topic.topictab.b.a> zVar = new z<>(qP);
        zVar.setPageId(this.cyA);
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topictab.b.a aVar, z<com.baidu.tieba.homepage.topic.topictab.b.a> zVar) {
        if (aVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        TiebaStatic.log(new an("c13448"));
        zVar.qQ().setPage(this.WM);
        zVar.qR().a(this.cTD);
        zVar.a(aVar);
        zVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void sy(String str) {
        this.WM = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cTD = aVar;
    }
}
