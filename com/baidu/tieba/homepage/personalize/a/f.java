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
    public BdUniqueId bdH;
    private NEGFeedBackView.a bxa;
    private String caz;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dPr;
    private com.baidu.adp.lib.e.b<TbImageView> dPs;
    private ad etv;
    private p eyE;
    private com.baidu.tieba.homepage.personalize.model.e eyF;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == this.eyE.getView().getId()) {
            TiebaStatic.log(kVar.aqO());
            com.baidu.tieba.a.d.VO().a("page_recommend", "clk_", kVar.aqO());
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqC(), false, null, null));
        } else if (this.eyE.cXN != null && view.getId() == this.eyE.cXN.getId()) {
            TiebaStatic.log(kVar.aqS());
            com.baidu.tieba.a.d.VO().a("page_recommend", "clk_", kVar.aqS());
        } else if (this.eyE.getHeaderImg() != null && view.getId() == this.eyE.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.aqQ());
            com.baidu.tieba.a.d.VO().a("page_recommend", "clk_", kVar.aqQ());
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqC(), false, null, null));
        } else if (this.eyE.apV() != null && view.getId() == this.eyE.apV().getId()) {
            TiebaStatic.log(kVar.aqQ());
            com.baidu.tieba.a.d.VO().a("page_recommend", "clk_", kVar.aqQ());
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqC(), false, null, null));
        } else if (this.eyE.caM != null && this.eyE.caM.getBarNameTv() != null && view.getId() == this.eyE.caM.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.aqP());
            com.baidu.tieba.a.d.VO().a("page_recommend", "clk_", kVar.aqP());
        } else if (this.eyE.cbz != null && this.eyE.cbz.aKj != null && view.getId() == this.eyE.cbz.aKj.getId()) {
            TiebaStatic.log(kVar.aqP());
            com.baidu.tieba.a.d.VO().a("page_recommend", "clk_", kVar.aqP());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(kVar.aqR());
            com.baidu.tieba.a.d.VO().a("page_recommend", "clk_", kVar.aqR());
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 3, kVar.aqC(), false, null, null));
        } else if (this.eyE.apU() != null && view.getId() == this.eyE.apU().getId()) {
            TiebaStatic.log(kVar.mQ("c10760"));
            com.baidu.tieba.a.d.VO().a("page_recommend", "clk_", kVar.mQ("c10760"));
        } else if (this.eyE.caM.getCommentContainer() != null && view.getId() == this.eyE.caM.getCommentContainer().getId()) {
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 5, kVar.aqC(), false, null, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.k kVar) {
        if (view instanceof TbImageView) {
            am aA = new am("c11004").aA("tid", kVar.threadData.getTid());
            TiebaStatic.log(aA);
            com.baidu.tieba.a.d.VO().a("page_recommend", "clk_", aA);
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 3, kVar.aqC(), false, null, null));
        } else if (view.getId() == this.eyE.getView().getId()) {
            am aA2 = new am("c11004").aA("tid", kVar.threadData.getTid());
            TiebaStatic.log(aA2);
            com.baidu.tieba.a.d.VO().a("page_recommend", "clk_", aA2);
            am aA3 = new am("c10806").x("obj_locate", 1).aA("tid", kVar.threadData.getId());
            TiebaStatic.log(aA3);
            com.baidu.tieba.a.d.VO().a("page_recommend", "clk_", aA3);
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqC(), false, null, null));
        } else {
            am aA4 = new am("c11004").aA("tid", kVar.threadData.getTid());
            TiebaStatic.log(aA4);
            com.baidu.tieba.a.d.VO().a("page_recommend", "clk_", aA4);
            com.baidu.tieba.q.c.bBT().b(this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqC(), false, null, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bxa = null;
        this.dPr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aDC */
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
        this.dPs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Fu */
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
        this.etv = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.aqs().dQ(true);
                if (view != null && f.this.eyE != null && f.this.eyE.getView() != null && f.this.eyF != null && kVar != null && kVar.ZT() != null && !StringUtils.isNull(kVar.ZT().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cj(com.baidu.adp.lib.g.b.d(kVar.ZT().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.ci(com.baidu.adp.lib.g.b.d(kVar.ZT().getTid(), 0L));
                        f.this.eyF.a(com.baidu.adp.lib.g.b.d(kVar.ZT().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aqC(), kVar.aqE(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.daV) {
                        f.this.c(view, kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aMe();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<p> onCreateViewHolder(ViewGroup viewGroup) {
        final p pVar = new p(this.mPageContext);
        pVar.setConstrainLayoutPool(this.dPr);
        pVar.setConstrainImagePool(this.dPs);
        pVar.j(this.bdH);
        pVar.currentPageType = 2;
        if (pVar.caM != null) {
            pVar.caM.avM = 2;
        }
        if (pVar.cbz != null && pVar.cbz.aKk != null) {
            pVar.cbz.aKk.avM = 2;
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
        this.eyE = pVar;
        return new com.baidu.tieba.card.a.a<>(this.eyE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (kVar == null || aVar == null || aVar.aqT() == null) {
            return null;
        }
        kVar.kP(i + 1);
        v.aqs().a(kVar.aqN());
        com.baidu.tieba.a.d.VO().a("page_recommend", "show_", kVar.aqN());
        if (aVar.aqT() instanceof com.baidu.tieba.a.e) {
            aVar.aqT().setPage(this.caz);
        }
        aVar.aqT().kL(i + 1);
        aVar.aqT().a(kVar);
        aVar.aqT().b(this.etv);
        aVar.aqT().a(this.bxa);
        com.baidu.tieba.q.c.bBT().a(this.bdH, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aqC(), false, null, null));
        return aVar.getView();
    }

    private void aMe() {
        com.baidu.tieba.card.data.k.daK = "c10705";
        com.baidu.tieba.card.data.k.daL = "c10730";
        com.baidu.tieba.card.data.k.daM = "c10731";
        com.baidu.tieba.card.data.k.daN = "c10704";
        com.baidu.tieba.card.data.k.daO = "c10755";
        com.baidu.tieba.card.data.k.daP = "c10710";
        com.baidu.tieba.card.data.k.daQ = "c10736";
        com.baidu.tieba.card.data.k.daR = "c10737";
        com.baidu.tieba.card.data.k.daS = "c10711";
        com.baidu.tieba.card.data.k.daT = "c10758";
        com.baidu.tieba.card.data.k.daU = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.eyE != null) {
            this.eyE.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.eyF = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bxa = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jL(String str) {
        this.caz = str;
    }
}
