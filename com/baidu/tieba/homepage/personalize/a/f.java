package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.p;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<p>> implements com.baidu.tieba.a.f {
    public BdUniqueId aRF;
    private String bGM;
    private NEGFeedBackView.a bir;
    private ad dQw;
    private p dUu;
    private com.baidu.tieba.homepage.personalize.model.e dUv;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dnI;
    private com.baidu.adp.lib.e.b<TbImageView> dnJ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == this.dUu.getView().getId()) {
            TiebaStatic.log(kVar.aiV());
            com.baidu.tieba.a.d.QB().a("page_recommend", "clk_", kVar.aiV());
        } else if (this.dUu.cwy != null && view.getId() == this.dUu.cwy.getId()) {
            TiebaStatic.log(kVar.aiZ());
            com.baidu.tieba.a.d.QB().a("page_recommend", "clk_", kVar.aiZ());
        } else if (this.dUu.getHeaderImg() != null && view.getId() == this.dUu.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.aiX());
            com.baidu.tieba.a.d.QB().a("page_recommend", "clk_", kVar.aiX());
        } else if (this.dUu.aid() != null && view.getId() == this.dUu.aid().getId()) {
            TiebaStatic.log(kVar.aiX());
            com.baidu.tieba.a.d.QB().a("page_recommend", "clk_", kVar.aiX());
        } else if (this.dUu.bGZ != null && this.dUu.bGZ.getBarNameTv() != null && view.getId() == this.dUu.bGZ.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.aiW());
            com.baidu.tieba.a.d.QB().a("page_recommend", "clk_", kVar.aiW());
        } else if (this.dUu.bHN != null && this.dUu.bHN.ayD != null && view.getId() == this.dUu.bHN.ayD.getId()) {
            TiebaStatic.log(kVar.aiW());
            com.baidu.tieba.a.d.QB().a("page_recommend", "clk_", kVar.aiW());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(kVar.aiY());
            com.baidu.tieba.a.d.QB().a("page_recommend", "clk_", kVar.aiY());
        } else if (this.dUu.aic() != null && view.getId() == this.dUu.aic().getId()) {
            TiebaStatic.log(kVar.li("c10760"));
            com.baidu.tieba.a.d.QB().a("page_recommend", "clk_", kVar.li("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.k kVar) {
        if (view instanceof TbImageView) {
            an ah = new an("c11004").ah("tid", kVar.threadData.getTid());
            TiebaStatic.log(ah);
            com.baidu.tieba.a.d.QB().a("page_recommend", "clk_", ah);
        } else if (view.getId() == this.dUu.getView().getId()) {
            an ah2 = new an("c11004").ah("tid", kVar.threadData.getTid());
            TiebaStatic.log(ah2);
            com.baidu.tieba.a.d.QB().a("page_recommend", "clk_", ah2);
            an ah3 = new an("c10806").r("obj_locate", 1).ah("tid", kVar.threadData.getId());
            TiebaStatic.log(ah3);
            com.baidu.tieba.a.d.QB().a("page_recommend", "clk_", ah3);
        } else {
            an ah4 = new an("c11004").ah("tid", kVar.threadData.getTid());
            TiebaStatic.log(ah4);
            com.baidu.tieba.a.d.QB().a("page_recommend", "clk_", ah4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bir = null;
        this.dnI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avv */
            public ConstrainImageLayout mo9if() {
                return new ConstrainImageLayout(f.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void q(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout r(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dnJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ba */
            public TbImageView mo9if() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(d.C0142d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView r(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView s(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.dQw = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.aiz().cK(true);
                if (view != null && f.this.dUu != null && f.this.dUu.getView() != null && f.this.dUv != null && kVar != null && kVar.SV() != null && !StringUtils.isNull(kVar.SV().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.e.bM(com.baidu.adp.lib.g.b.c(kVar.SV().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.e.bL(com.baidu.adp.lib.g.b.c(kVar.SV().getTid(), 0L));
                        f.this.dUv.a(com.baidu.adp.lib.g.b.c(kVar.SV().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aiJ(), kVar.aiL(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.czD) {
                        f.this.c(view, kVar);
                    }
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
    public com.baidu.tieba.card.a.a<p> onCreateViewHolder(ViewGroup viewGroup) {
        this.dUu = new p(this.mPageContext);
        this.dUu.setConstrainLayoutPool(this.dnI);
        this.dUu.setConstrainImagePool(this.dnJ);
        this.dUu.j(this.aRF);
        this.dUu.currentPageType = 2;
        if (this.dUu.bGZ != null) {
            this.dUu.bGZ.akz = 2;
        }
        if (this.dUu.bHN != null && this.dUu.bHN.ayE != null) {
            this.dUu.bHN.ayE.akz = 2;
        }
        return new com.baidu.tieba.card.a.a<>(this.dUu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (kVar == null || aVar == null || aVar.aja() == null) {
            return null;
        }
        kVar.iL(i + 1);
        v.aiz().a(kVar.aiU());
        com.baidu.tieba.a.d.QB().a("page_recommend", "show_", kVar.aiU());
        if (aVar.aja() instanceof com.baidu.tieba.a.e) {
            aVar.aja().setPage(this.bGM);
        }
        aVar.aja().a(kVar);
        aVar.aja().b(this.dQw);
        aVar.aja().a(this.bir);
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

    public void setFromCDN(boolean z) {
        if (this.dUu != null) {
            this.dUu.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dUv = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bir = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }
}
