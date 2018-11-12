package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.p;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<p>> implements com.baidu.tieba.a.f {
    private String bWE;
    public BdUniqueId bag;
    private NEGFeedBackView.a btz;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dGe;
    private com.baidu.adp.lib.e.b<TbImageView> dGf;
    private ad ejJ;
    private p eoR;
    private com.baidu.tieba.homepage.personalize.model.e eoS;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == this.eoR.getView().getId()) {
            TiebaStatic.log(kVar.aom());
            com.baidu.tieba.a.d.UG().a("page_recommend", "clk_", kVar.aom());
        } else if (this.eoR.cOq != null && view.getId() == this.eoR.cOq.getId()) {
            TiebaStatic.log(kVar.aoq());
            com.baidu.tieba.a.d.UG().a("page_recommend", "clk_", kVar.aoq());
        } else if (this.eoR.getHeaderImg() != null && view.getId() == this.eoR.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.aoo());
            com.baidu.tieba.a.d.UG().a("page_recommend", "clk_", kVar.aoo());
        } else if (this.eoR.ant() != null && view.getId() == this.eoR.ant().getId()) {
            TiebaStatic.log(kVar.aoo());
            com.baidu.tieba.a.d.UG().a("page_recommend", "clk_", kVar.aoo());
        } else if (this.eoR.bWR != null && this.eoR.bWR.getBarNameTv() != null && view.getId() == this.eoR.bWR.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.aon());
            com.baidu.tieba.a.d.UG().a("page_recommend", "clk_", kVar.aon());
        } else if (this.eoR.bXE != null && this.eoR.bXE.aGH != null && view.getId() == this.eoR.bXE.aGH.getId()) {
            TiebaStatic.log(kVar.aon());
            com.baidu.tieba.a.d.UG().a("page_recommend", "clk_", kVar.aon());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(kVar.aop());
            com.baidu.tieba.a.d.UG().a("page_recommend", "clk_", kVar.aop());
        } else if (this.eoR.ans() != null && view.getId() == this.eoR.ans().getId()) {
            TiebaStatic.log(kVar.mo("c10760"));
            com.baidu.tieba.a.d.UG().a("page_recommend", "clk_", kVar.mo("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.k kVar) {
        if (view instanceof TbImageView) {
            am ax = new am("c11004").ax("tid", kVar.threadData.getTid());
            TiebaStatic.log(ax);
            com.baidu.tieba.a.d.UG().a("page_recommend", "clk_", ax);
        } else if (view.getId() == this.eoR.getView().getId()) {
            am ax2 = new am("c11004").ax("tid", kVar.threadData.getTid());
            TiebaStatic.log(ax2);
            com.baidu.tieba.a.d.UG().a("page_recommend", "clk_", ax2);
            am ax3 = new am("c10806").x("obj_locate", 1).ax("tid", kVar.threadData.getId());
            TiebaStatic.log(ax3);
            com.baidu.tieba.a.d.UG().a("page_recommend", "clk_", ax3);
        } else {
            am ax4 = new am("c11004").ax("tid", kVar.threadData.getTid());
            TiebaStatic.log(ax4);
            com.baidu.tieba.a.d.UG().a("page_recommend", "clk_", ax4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.btz = null;
        this.dGe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aBd */
            public ConstrainImageLayout jz() {
                return new ConstrainImageLayout(f.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout v(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout w(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dGf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ep */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView v(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView w(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.ejJ = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.anQ().dP(true);
                if (view != null && f.this.eoR != null && f.this.eoR.getView() != null && f.this.eoS != null && kVar != null && kVar.YL() != null && !StringUtils.isNull(kVar.YL().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bX(com.baidu.adp.lib.g.b.d(kVar.YL().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bW(com.baidu.adp.lib.g.b.d(kVar.YL().getTid(), 0L));
                        f.this.eoS.a(com.baidu.adp.lib.g.b.d(kVar.YL().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aoa(), kVar.aoc(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.cRw) {
                        f.this.c(view, kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aJz();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<p> onCreateViewHolder(ViewGroup viewGroup) {
        final p pVar = new p(this.mPageContext);
        pVar.setConstrainLayoutPool(this.dGe);
        pVar.setConstrainImagePool(this.dGf);
        pVar.j(this.bag);
        pVar.currentPageType = 2;
        if (pVar.bWR != null) {
            pVar.bWR.asl = 2;
        }
        if (pVar.bXE != null && pVar.bXE.aGI != null) {
            pVar.bXE.aGI.asl = 2;
        }
        if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
            pVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.personalize.a.f.4
                @Override // com.baidu.adp.widget.a.b
                public void k(int i, int i2, int i3) {
                    f.this.setPreloadSize(i, i2, i3);
                    if (f.this.isPreloadSizeReady(1) && f.this.isPreloadSizeReady(2)) {
                        pVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        this.eoR = pVar;
        return new com.baidu.tieba.card.a.a<>(this.eoR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (kVar == null || aVar == null || aVar.aor() == null) {
            return null;
        }
        kVar.km(i + 1);
        v.anQ().a(kVar.aol());
        com.baidu.tieba.a.d.UG().a("page_recommend", "show_", kVar.aol());
        if (aVar.aor() instanceof com.baidu.tieba.a.e) {
            aVar.aor().setPage(this.bWE);
        }
        aVar.aor().a(kVar);
        aVar.aor().b(this.ejJ);
        aVar.aor().a(this.btz);
        return aVar.getView();
    }

    private void aJz() {
        com.baidu.tieba.card.data.k.cRl = "c10705";
        com.baidu.tieba.card.data.k.cRm = "c10730";
        com.baidu.tieba.card.data.k.cRn = "c10731";
        com.baidu.tieba.card.data.k.cRo = "c10704";
        com.baidu.tieba.card.data.k.cRp = "c10755";
        com.baidu.tieba.card.data.k.cRq = "c10710";
        com.baidu.tieba.card.data.k.cRr = "c10736";
        com.baidu.tieba.card.data.k.cRs = "c10737";
        com.baidu.tieba.card.data.k.cRt = "c10711";
        com.baidu.tieba.card.data.k.cRu = "c10758";
        com.baidu.tieba.card.data.k.cRv = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.eoR != null) {
            this.eoR.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.eoS = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.btz = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }
}
