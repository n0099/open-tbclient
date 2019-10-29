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
    private String GC;
    public BdUniqueId cKf;
    private NEGFeedBackView.a dcY;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public z<com.baidu.tieba.homepage.topic.topictab.b.a> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.personalize.view.e eVar = new com.baidu.tieba.homepage.personalize.view.e(this.mContext, this.mPageContext);
        eVar.setTag(this.mPageId);
        aVar.b(eVar);
        aVar.lT().aI(0);
        aVar.lT().aJ(0);
        aVar.lT().aK(0);
        aVar.lT().aH(0);
        aVar.lT().aG(0);
        x lU = aVar.lU();
        lU.aF(2);
        z<com.baidu.tieba.homepage.topic.topictab.b.a> zVar = new z<>(lU);
        zVar.setPageId(this.cKf);
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topictab.b.a aVar, z<com.baidu.tieba.homepage.topic.topictab.b.a> zVar) {
        if (aVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        TiebaStatic.log(new an("c13448"));
        zVar.lV().setPage(this.GC);
        zVar.lW().a(this.dcY);
        zVar.a(aVar);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dcY = aVar;
    }
}
