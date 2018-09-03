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
    public BdUniqueId aRC;
    private String bHB;
    private k cwu;
    private ad dTe;
    private x dun;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dTe = new ad<bc>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                k kVar = g.this.cwu;
                if (view != null && g.this.dun != null && g.this.dun.getView() != null && kVar != null && kVar.Tg() != null && !StringUtils.isNull(kVar.Tg().getTid())) {
                    an anVar = new an("c12352");
                    if ((g.this.dun.getHeaderImg() == null || view.getId() != g.this.dun.getHeaderImg().getId()) && (g.this.dun.aiF() == null || view.getId() != g.this.dun.aiF().getId())) {
                        if (view.getId() == g.this.dun.cAm.getId()) {
                            anVar.r("obj_locate", 3);
                        } else {
                            anVar.r("obj_locate", 2);
                        }
                    } else {
                        anVar.r("obj_locate", 1);
                    }
                    anVar.r("obj_type", 5);
                    anVar.ae("tid", kVar.threadData.getTid());
                    anVar.f(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
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
        this.dun = new x(this.mPageContext);
        this.dun.j(this.aRC);
        this.dun.ev(false);
        this.dun.setIsFromConcern(true);
        this.dun.b(this.dTe);
        this.dun.currentPageType = 1;
        if (this.dun.bHO != null) {
            this.dun.bHO.ajY = 1;
        }
        if (this.dun.bIC != null && this.dun.bIC.ayo != null) {
            this.dun.bIC.ayo.ajY = 1;
        }
        if (this.dun.cAm != null) {
            this.dun.cAm.cAZ = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dun);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || aVar == null || aVar.ajC() == null) {
            return null;
        }
        this.cwu = kVar;
        kVar.iW(i + 1);
        v.ajb().a(kVar.lg("c12351"));
        bc bcVar = new bc(kVar.Tg());
        bcVar.stType = "personalize_page";
        bcVar.ajW = 9;
        bcVar.ajX = 4;
        if (aVar.ajC() instanceof com.baidu.tieba.a.e) {
            aVar.ajC().setPage(this.bHB);
        }
        aVar.ajC().a(bcVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iB(String str) {
        this.bHB = str;
    }
}
