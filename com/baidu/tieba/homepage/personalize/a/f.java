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
    public BdUniqueId bdE;
    private NEGFeedBackView.a bwX;
    private String caw;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dMD;
    private com.baidu.adp.lib.e.b<TbImageView> dME;
    private ad eqD;
    private p evL;
    private com.baidu.tieba.homepage.personalize.model.e evM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == this.evL.getView().getId()) {
            TiebaStatic.log(kVar.apZ());
            com.baidu.tieba.a.d.VM().a("page_recommend", "clk_", kVar.apZ());
        } else if (this.evL.cUX != null && view.getId() == this.evL.cUX.getId()) {
            TiebaStatic.log(kVar.aqd());
            com.baidu.tieba.a.d.VM().a("page_recommend", "clk_", kVar.aqd());
        } else if (this.evL.getHeaderImg() != null && view.getId() == this.evL.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.aqb());
            com.baidu.tieba.a.d.VM().a("page_recommend", "clk_", kVar.aqb());
        } else if (this.evL.apf() != null && view.getId() == this.evL.apf().getId()) {
            TiebaStatic.log(kVar.aqb());
            com.baidu.tieba.a.d.VM().a("page_recommend", "clk_", kVar.aqb());
        } else if (this.evL.caJ != null && this.evL.caJ.getBarNameTv() != null && view.getId() == this.evL.caJ.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.aqa());
            com.baidu.tieba.a.d.VM().a("page_recommend", "clk_", kVar.aqa());
        } else if (this.evL.cbw != null && this.evL.cbw.aKh != null && view.getId() == this.evL.cbw.aKh.getId()) {
            TiebaStatic.log(kVar.aqa());
            com.baidu.tieba.a.d.VM().a("page_recommend", "clk_", kVar.aqa());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(kVar.aqc());
            com.baidu.tieba.a.d.VM().a("page_recommend", "clk_", kVar.aqc());
        } else if (this.evL.ape() != null && view.getId() == this.evL.ape().getId()) {
            TiebaStatic.log(kVar.mN("c10760"));
            com.baidu.tieba.a.d.VM().a("page_recommend", "clk_", kVar.mN("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.k kVar) {
        if (view instanceof TbImageView) {
            am aA = new am("c11004").aA("tid", kVar.threadData.getTid());
            TiebaStatic.log(aA);
            com.baidu.tieba.a.d.VM().a("page_recommend", "clk_", aA);
        } else if (view.getId() == this.evL.getView().getId()) {
            am aA2 = new am("c11004").aA("tid", kVar.threadData.getTid());
            TiebaStatic.log(aA2);
            com.baidu.tieba.a.d.VM().a("page_recommend", "clk_", aA2);
            am aA3 = new am("c10806").x("obj_locate", 1).aA("tid", kVar.threadData.getId());
            TiebaStatic.log(aA3);
            com.baidu.tieba.a.d.VM().a("page_recommend", "clk_", aA3);
        } else {
            am aA4 = new am("c11004").aA("tid", kVar.threadData.getTid());
            TiebaStatic.log(aA4);
            com.baidu.tieba.a.d.VM().a("page_recommend", "clk_", aA4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bwX = null;
        this.dMD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aCN */
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
        this.dME = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ft */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1));
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
        this.eqD = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.apD().dQ(true);
                if (view != null && f.this.evL != null && f.this.evL.getView() != null && f.this.evM != null && kVar != null && kVar.ZR() != null && !StringUtils.isNull(kVar.ZR().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.ce(com.baidu.adp.lib.g.b.d(kVar.ZR().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cd(com.baidu.adp.lib.g.b.d(kVar.ZR().getTid(), 0L));
                        f.this.evM.a(com.baidu.adp.lib.g.b.d(kVar.ZR().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.apN(), kVar.apP(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.cYd) {
                        f.this.c(view, kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aLq();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<p> onCreateViewHolder(ViewGroup viewGroup) {
        final p pVar = new p(this.mPageContext);
        pVar.setConstrainLayoutPool(this.dMD);
        pVar.setConstrainImagePool(this.dME);
        pVar.j(this.bdE);
        pVar.currentPageType = 2;
        if (pVar.caJ != null) {
            pVar.caJ.avL = 2;
        }
        if (pVar.cbw != null && pVar.cbw.aKi != null) {
            pVar.cbw.aKi.avL = 2;
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
        this.evL = pVar;
        return new com.baidu.tieba.card.a.a<>(this.evL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (kVar == null || aVar == null || aVar.aqe() == null) {
            return null;
        }
        kVar.kC(i + 1);
        v.apD().a(kVar.apY());
        com.baidu.tieba.a.d.VM().a("page_recommend", "show_", kVar.apY());
        if (aVar.aqe() instanceof com.baidu.tieba.a.e) {
            aVar.aqe().setPage(this.caw);
        }
        aVar.aqe().a(kVar);
        aVar.aqe().b(this.eqD);
        aVar.aqe().a(this.bwX);
        return aVar.getView();
    }

    private void aLq() {
        com.baidu.tieba.card.data.k.cXS = "c10705";
        com.baidu.tieba.card.data.k.cXT = "c10730";
        com.baidu.tieba.card.data.k.cXU = "c10731";
        com.baidu.tieba.card.data.k.cXV = "c10704";
        com.baidu.tieba.card.data.k.cXW = "c10755";
        com.baidu.tieba.card.data.k.cXX = "c10710";
        com.baidu.tieba.card.data.k.cXY = "c10736";
        com.baidu.tieba.card.data.k.cXZ = "c10737";
        com.baidu.tieba.card.data.k.cYa = "c10711";
        com.baidu.tieba.card.data.k.cYb = "c10758";
        com.baidu.tieba.card.data.k.cYc = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.evL != null) {
            this.evL.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.evM = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bwX = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jK(String str) {
        this.caw = str;
    }
}
