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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f {
    public BdUniqueId aUU;
    private String bNq;
    private k cCk;
    private x dAU;
    private ad eav;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eav = new ad<bc>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                k kVar = g.this.cCk;
                if (view != null && g.this.dAU != null && g.this.dAU.getView() != null && kVar != null && kVar.UT() != null && !StringUtils.isNull(kVar.UT().getTid())) {
                    am amVar = new am("c12352");
                    if ((g.this.dAU.getHeaderImg() == null || view.getId() != g.this.dAU.getHeaderImg().getId()) && (g.this.dAU.akp() == null || view.getId() != g.this.dAU.akp().getId())) {
                        if (view.getId() == g.this.dAU.cGe.getId()) {
                            amVar.w("obj_locate", 3);
                        } else {
                            amVar.w("obj_locate", 2);
                        }
                    } else {
                        amVar.w("obj_locate", 1);
                    }
                    amVar.w("obj_type", 5);
                    amVar.al("tid", kVar.threadData.getTid());
                    amVar.g(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
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
        this.dAU = new x(this.mPageContext);
        this.dAU.j(this.aUU);
        this.dAU.eM(false);
        this.dAU.setIsFromConcern(true);
        this.dAU.b(this.eav);
        this.dAU.currentPageType = 1;
        if (this.dAU.bND != null) {
            this.dAU.bND.amD = 1;
        }
        if (this.dAU.bOr != null && this.dAU.bOr.aBl != null) {
            this.dAU.bOr.aBl.amD = 1;
        }
        if (this.dAU.cGe != null) {
            this.dAU.cGe.cGR = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dAU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || aVar == null || aVar.aln() == null) {
            return null;
        }
        this.cCk = kVar;
        kVar.jv(i + 1);
        v.akM().a(kVar.lI("c12351"));
        bc bcVar = new bc(kVar.UT());
        bcVar.stType = "personalize_page";
        bcVar.amB = 9;
        bcVar.amC = 4;
        bcVar.amE = 4;
        if (aVar.aln() instanceof com.baidu.tieba.a.e) {
            aVar.aln().setPage(this.bNq);
        }
        aVar.aln().a(bcVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }
}
