package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f {
    public BdUniqueId aRF;
    private String bHB;
    private k cwx;
    private ad dTj;
    private x duq;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dTj = new ad<bc>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                k kVar = g.this.cwx;
                if (view != null && g.this.duq != null && g.this.duq.getView() != null && kVar != null && kVar.Td() != null && !StringUtils.isNull(kVar.Td().getTid())) {
                    an anVar = new an("c12352");
                    if ((g.this.duq.getHeaderImg() == null || view.getId() != g.this.duq.getHeaderImg().getId()) && (g.this.duq.aiC() == null || view.getId() != g.this.duq.aiC().getId())) {
                        if (view.getId() == g.this.duq.cAp.getId()) {
                            anVar.r("obj_locate", 3);
                        } else {
                            anVar.r("obj_locate", 2);
                        }
                    } else {
                        anVar.r("obj_locate", 1);
                    }
                    anVar.r("obj_type", 5);
                    anVar.af("tid", kVar.threadData.getTid());
                    anVar.f(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(anVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.duq = new x(this.mPageContext);
        this.duq.j(this.aRF);
        this.duq.ev(false);
        this.duq.setIsFromConcern(true);
        this.duq.b(this.dTj);
        this.duq.currentPageType = 1;
        if (this.duq.bHO != null) {
            this.duq.bHO.ajY = 1;
        }
        if (this.duq.bIC != null && this.duq.bIC.ayr != null) {
            this.duq.bIC.ayr.ajY = 1;
        }
        if (this.duq.cAp != null) {
            this.duq.cAp.cBc = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.duq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || aVar == null || aVar.ajz() == null) {
            return null;
        }
        this.cwx = kVar;
        kVar.iX(i + 1);
        v.aiY().a(kVar.le("c12351"));
        bc bcVar = new bc(kVar.Td());
        bcVar.stType = "personalize_page";
        bcVar.ajW = 9;
        bcVar.ajX = 4;
        if (aVar.ajz() instanceof com.baidu.tieba.a.e) {
            aVar.ajz().setPage(this.bHB);
        }
        aVar.ajz().a(bcVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iA(String str) {
        this.bHB = str;
    }
}
