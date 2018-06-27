package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f {
    public BdUniqueId aRF;
    private String bGM;
    private k ctU;
    private ad dQw;
    private x drD;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQw = new ad<bd>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bd bdVar) {
                k kVar = g.this.ctU;
                if (view != null && g.this.drD != null && g.this.drD.getView() != null && kVar != null && kVar.SV() != null && !StringUtils.isNull(kVar.SV().getTid())) {
                    an anVar = new an("c12352");
                    if ((g.this.drD.getHeaderImg() == null || view.getId() != g.this.drD.getHeaderImg().getId()) && (g.this.drD.aid() == null || view.getId() != g.this.drD.aid().getId())) {
                        if (view.getId() == g.this.drD.cxM.getId()) {
                            anVar.r("obj_locate", 3);
                        } else {
                            anVar.r("obj_locate", 2);
                        }
                    } else {
                        anVar.r("obj_locate", 1);
                    }
                    anVar.r("obj_type", 5);
                    anVar.ah("tid", kVar.threadData.getTid());
                    anVar.f(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(anVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.drD = new x(this.mPageContext);
        this.drD.j(this.aRF);
        this.drD.eu(false);
        this.drD.setIsFromConcern(true);
        this.drD.b(this.dQw);
        this.drD.currentPageType = 1;
        if (this.drD.bGZ != null) {
            this.drD.bGZ.akz = 1;
        }
        if (this.drD.bHN != null && this.drD.bHN.ayE != null) {
            this.drD.bHN.ayE.akz = 1;
        }
        if (this.drD.cxM != null) {
            this.drD.cxM.cyz = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.drD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || aVar == null || aVar.aja() == null) {
            return null;
        }
        this.ctU = kVar;
        kVar.iL(i + 1);
        v.aiz().a(kVar.lf("c12351"));
        bd bdVar = new bd(kVar.SV());
        bdVar.stType = "personalize_page";
        bdVar.akx = 9;
        bdVar.aky = 4;
        if (aVar.aja() instanceof com.baidu.tieba.a.e) {
            aVar.aja().setPage(this.bGM);
        }
        aVar.aja().a(bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }
}
