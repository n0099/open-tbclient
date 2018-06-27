package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f {
    public BdUniqueId aRF;
    private String bGM;
    private NEGFeedBackView.a bir;
    private com.baidu.tieba.card.data.k ctU;
    private ad dQw;
    private x drD;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bir = null;
        this.dQw = new ad<bd>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bd bdVar) {
                com.baidu.tieba.card.data.k kVar = h.this.ctU;
                v.aiz().cK(true);
                if (view != null && h.this.drD != null && h.this.drD.getView() != null && kVar != null && kVar.SV() != null && !StringUtils.isNull(kVar.SV().getTid())) {
                    if (view.getId() != h.this.drD.getView().getId()) {
                        if (h.this.drD.getHeaderImg() == null || view.getId() != h.this.drD.getHeaderImg().getId()) {
                            if (h.this.drD.aid() == null || view.getId() != h.this.drD.aid().getId()) {
                                if (h.this.drD.bHN != null && h.this.drD.bHN.ayD != null && view.getId() == h.this.drD.bHN.ayD.getId()) {
                                    TiebaStatic.log(kVar.aiW());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(kVar.aiX());
                            return;
                        }
                        TiebaStatic.log(kVar.aiX());
                        return;
                    }
                    TiebaStatic.log(kVar.lk("c12642"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aDx();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.drD = new x(this.mPageContext);
        this.drD.currentPageType = 2;
        if (this.drD.bGZ != null) {
            this.drD.bGZ.akz = 2;
        }
        if (this.drD.bHN != null && this.drD.bHN.ayE != null) {
            this.drD.bHN.ayE.akz = 2;
        }
        if (this.drD.cxM != null) {
            this.drD.cxM.cyz = 2;
        }
        this.drD.j(this.aRF);
        this.drD.b(this.dQw);
        return new com.baidu.tieba.card.a.a<>(this.drD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.SV() == null || aVar == null || aVar.aja() == null) {
            return null;
        }
        this.ctU = kVar;
        kVar.iL(i + 1);
        v.aiz().a(kVar.lj("c12641"));
        if (kVar.agZ != null && kVar.agZ.size() > 0) {
            kVar.SV().a(kVar.agZ);
        }
        bd bdVar = new bd(kVar.SV());
        bdVar.stType = "personalize_page";
        bdVar.akx = 1;
        bdVar.aky = 3;
        aVar.aja().a(this.bir);
        if (aVar.aja() instanceof com.baidu.tieba.a.e) {
            aVar.aja().setPage(this.bGM);
        }
        aVar.aja().a(bdVar);
        return aVar.getView();
    }

    private void aDx() {
        com.baidu.tieba.card.data.k.czs = "c10705";
        com.baidu.tieba.card.data.k.czt = "c10730";
        com.baidu.tieba.card.data.k.czu = "c10731";
        com.baidu.tieba.card.data.k.czv = "c10704";
        com.baidu.tieba.card.data.k.czw = "c10755";
        com.baidu.tieba.card.data.k.czx = "c10710";
        com.baidu.tieba.card.data.k.czy = "c10736";
        com.baidu.tieba.card.data.k.czz = "c10737";
        com.baidu.tieba.card.data.k.czA = "c10711";
        com.baidu.tieba.card.data.k.czB = "c10758";
        com.baidu.tieba.card.data.k.czC = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bir = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }
}
