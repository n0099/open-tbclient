package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.p;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<p>> implements com.baidu.tieba.a.f {
    public BdUniqueId aTr;
    private NEGFeedBackView.a aYO;
    private String bvX;
    private ab dAS;
    private p dEB;
    private com.baidu.tieba.homepage.personalize.model.e dEC;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> ddJ;
    private com.baidu.adp.lib.e.b<TbImageView> ddK;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view2, com.baidu.tieba.card.data.k kVar) {
        if (view2.getId() == this.dEB.getView().getId()) {
            TiebaStatic.log(kVar.afT());
            com.baidu.tieba.a.d.MH().a("page_recommend", "clk_", kVar.afT());
        } else if (this.dEB.coU != null && view2.getId() == this.dEB.coU.getId()) {
            TiebaStatic.log(kVar.afX());
            com.baidu.tieba.a.d.MH().a("page_recommend", "clk_", kVar.afX());
        } else if (this.dEB.getHeaderImg() != null && view2.getId() == this.dEB.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.afV());
            com.baidu.tieba.a.d.MH().a("page_recommend", "clk_", kVar.afV());
        } else if (this.dEB.afc() != null && view2.getId() == this.dEB.afc().getId()) {
            TiebaStatic.log(kVar.afV());
            com.baidu.tieba.a.d.MH().a("page_recommend", "clk_", kVar.afV());
        } else if (this.dEB.bwk != null && this.dEB.bwk.getBarNameTv() != null && view2.getId() == this.dEB.bwk.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.afU());
            com.baidu.tieba.a.d.MH().a("page_recommend", "clk_", kVar.afU());
        } else if (this.dEB.bwZ != null && this.dEB.bwZ.apF != null && view2.getId() == this.dEB.bwZ.apF.getId()) {
            TiebaStatic.log(kVar.afU());
            com.baidu.tieba.a.d.MH().a("page_recommend", "clk_", kVar.afU());
        } else if (view2 instanceof TbImageView) {
            TiebaStatic.log(kVar.afW());
            com.baidu.tieba.a.d.MH().a("page_recommend", "clk_", kVar.afW());
        } else if (this.dEB.afb() != null && view2.getId() == this.dEB.afb().getId()) {
            TiebaStatic.log(kVar.kF("c10760"));
            com.baidu.tieba.a.d.MH().a("page_recommend", "clk_", kVar.kF("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view2, com.baidu.tieba.card.data.k kVar) {
        if (view2 instanceof TbImageView) {
            al ac = new al("c11004").ac("tid", kVar.threadData.getTid());
            TiebaStatic.log(ac);
            com.baidu.tieba.a.d.MH().a("page_recommend", "clk_", ac);
        } else if (view2.getId() == this.dEB.getView().getId()) {
            al ac2 = new al("c11004").ac("tid", kVar.threadData.getTid());
            TiebaStatic.log(ac2);
            com.baidu.tieba.a.d.MH().a("page_recommend", "clk_", ac2);
            al ac3 = new al("c10806").r("obj_locate", 1).ac("tid", kVar.threadData.getId());
            TiebaStatic.log(ac3);
            com.baidu.tieba.a.d.MH().a("page_recommend", "clk_", ac3);
        } else {
            al ac4 = new al("c11004").ac("tid", kVar.threadData.getTid());
            TiebaStatic.log(ac4);
            com.baidu.tieba.a.d.MH().a("page_recommend", "clk_", ac4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYO = null;
        this.ddJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: arU */
            public ConstrainImageLayout fo() {
                return new ConstrainImageLayout(f.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void n(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout o(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout p(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.ddK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xi */
            public TbImageView fo() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ak.getColor(d.C0126d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView o(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView p(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.dAS = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.card.data.k kVar) {
                v.afy().cB(true);
                if (view2 != null && f.this.dEB != null && f.this.dEB.getView() != null && f.this.dEC != null && kVar != null && kVar.Pe() != null && !StringUtils.isNull(kVar.Pe().getTid())) {
                    if ((view2.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.e.bK(com.baidu.adp.lib.g.b.c(kVar.Pe().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.e.bJ(com.baidu.adp.lib.g.b.c(kVar.Pe().getTid(), 0L));
                        f.this.dEC.a(com.baidu.adp.lib.g.b.c(kVar.Pe().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.afI(), kVar.afK(), com.baidu.adp.lib.g.b.g((String) view2.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view2, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.crY) {
                        f.this.c(view2, kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        axZ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<p> onCreateViewHolder(ViewGroup viewGroup) {
        this.dEB = new p(this.mPageContext);
        this.dEB.setConstrainLayoutPool(this.ddJ);
        this.dEB.setConstrainImagePool(this.ddK);
        this.dEB.j(this.aTr);
        this.dEB.currentPageType = 2;
        if (this.dEB.bwk != null) {
            this.dEB.bwk.abV = 2;
        }
        if (this.dEB.bwZ != null && this.dEB.bwZ.apG != null) {
            this.dEB.bwZ.apG.abV = 2;
        }
        return new com.baidu.tieba.card.a.a<>(this.dEB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (kVar == null || aVar == null || aVar.afY() == null) {
            return null;
        }
        kVar.iO(i + 1);
        v.afy().a(kVar.afS());
        com.baidu.tieba.a.d.MH().a("page_recommend", "show_", kVar.afS());
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bvX);
        }
        aVar.afY().a(kVar);
        aVar.afY().b(this.dAS);
        aVar.afY().a(this.aYO);
        return aVar.getView();
    }

    private void axZ() {
        com.baidu.tieba.card.data.k.crN = "c10705";
        com.baidu.tieba.card.data.k.crO = "c10730";
        com.baidu.tieba.card.data.k.crP = "c10731";
        com.baidu.tieba.card.data.k.crQ = "c10704";
        com.baidu.tieba.card.data.k.crR = "c10755";
        com.baidu.tieba.card.data.k.crS = "c10710";
        com.baidu.tieba.card.data.k.crT = "c10736";
        com.baidu.tieba.card.data.k.crU = "c10737";
        com.baidu.tieba.card.data.k.crV = "c10711";
        com.baidu.tieba.card.data.k.crW = "c10758";
        com.baidu.tieba.card.data.k.crX = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.dEB != null) {
            this.dEB.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dEC = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.aYO = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void hY(String str) {
        this.bvX = str;
    }
}
