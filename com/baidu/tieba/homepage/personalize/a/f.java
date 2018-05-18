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
    public BdUniqueId aTs;
    private NEGFeedBackView.a aYP;
    private String bwO;
    private ab dBW;
    private p dFE;
    private com.baidu.tieba.homepage.personalize.model.e dFF;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> deO;
    private com.baidu.adp.lib.e.b<TbImageView> deP;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view2, com.baidu.tieba.card.data.k kVar) {
        if (view2.getId() == this.dFE.getView().getId()) {
            TiebaStatic.log(kVar.afT());
            com.baidu.tieba.a.d.MF().a("page_recommend", "clk_", kVar.afT());
        } else if (this.dFE.cqb != null && view2.getId() == this.dFE.cqb.getId()) {
            TiebaStatic.log(kVar.afX());
            com.baidu.tieba.a.d.MF().a("page_recommend", "clk_", kVar.afX());
        } else if (this.dFE.getHeaderImg() != null && view2.getId() == this.dFE.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.afV());
            com.baidu.tieba.a.d.MF().a("page_recommend", "clk_", kVar.afV());
        } else if (this.dFE.afc() != null && view2.getId() == this.dFE.afc().getId()) {
            TiebaStatic.log(kVar.afV());
            com.baidu.tieba.a.d.MF().a("page_recommend", "clk_", kVar.afV());
        } else if (this.dFE.bxb != null && this.dFE.bxb.getBarNameTv() != null && view2.getId() == this.dFE.bxb.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.afU());
            com.baidu.tieba.a.d.MF().a("page_recommend", "clk_", kVar.afU());
        } else if (this.dFE.bxQ != null && this.dFE.bxQ.apF != null && view2.getId() == this.dFE.bxQ.apF.getId()) {
            TiebaStatic.log(kVar.afU());
            com.baidu.tieba.a.d.MF().a("page_recommend", "clk_", kVar.afU());
        } else if (view2 instanceof TbImageView) {
            TiebaStatic.log(kVar.afW());
            com.baidu.tieba.a.d.MF().a("page_recommend", "clk_", kVar.afW());
        } else if (this.dFE.afb() != null && view2.getId() == this.dFE.afb().getId()) {
            TiebaStatic.log(kVar.kI("c10760"));
            com.baidu.tieba.a.d.MF().a("page_recommend", "clk_", kVar.kI("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view2, com.baidu.tieba.card.data.k kVar) {
        if (view2 instanceof TbImageView) {
            al ac = new al("c11004").ac("tid", kVar.threadData.getTid());
            TiebaStatic.log(ac);
            com.baidu.tieba.a.d.MF().a("page_recommend", "clk_", ac);
        } else if (view2.getId() == this.dFE.getView().getId()) {
            al ac2 = new al("c11004").ac("tid", kVar.threadData.getTid());
            TiebaStatic.log(ac2);
            com.baidu.tieba.a.d.MF().a("page_recommend", "clk_", ac2);
            al ac3 = new al("c10806").r("obj_locate", 1).ac("tid", kVar.threadData.getId());
            TiebaStatic.log(ac3);
            com.baidu.tieba.a.d.MF().a("page_recommend", "clk_", ac3);
        } else {
            al ac4 = new al("c11004").ac("tid", kVar.threadData.getTid());
            TiebaStatic.log(ac4);
            com.baidu.tieba.a.d.MF().a("page_recommend", "clk_", ac4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYP = null;
        this.deO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: arT */
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
        this.deP = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xh */
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
        this.dBW = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.card.data.k kVar) {
                v.afy().cB(true);
                if (view2 != null && f.this.dFE != null && f.this.dFE.getView() != null && f.this.dFF != null && kVar != null && kVar.Pb() != null && !StringUtils.isNull(kVar.Pb().getTid())) {
                    if ((view2.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.e.bK(com.baidu.adp.lib.g.b.c(kVar.Pb().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.e.bJ(com.baidu.adp.lib.g.b.c(kVar.Pb().getTid(), 0L));
                        f.this.dFF.a(com.baidu.adp.lib.g.b.c(kVar.Pb().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.afI(), kVar.afK(), com.baidu.adp.lib.g.b.g((String) view2.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view2, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.cte) {
                        f.this.c(view2, kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        axX();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<p> onCreateViewHolder(ViewGroup viewGroup) {
        this.dFE = new p(this.mPageContext);
        this.dFE.setConstrainLayoutPool(this.deO);
        this.dFE.setConstrainImagePool(this.deP);
        this.dFE.j(this.aTs);
        this.dFE.currentPageType = 2;
        if (this.dFE.bxb != null) {
            this.dFE.bxb.abW = 2;
        }
        if (this.dFE.bxQ != null && this.dFE.bxQ.apG != null) {
            this.dFE.bxQ.apG.abW = 2;
        }
        return new com.baidu.tieba.card.a.a<>(this.dFE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (kVar == null || aVar == null || aVar.afY() == null) {
            return null;
        }
        kVar.iM(i + 1);
        v.afy().a(kVar.afS());
        com.baidu.tieba.a.d.MF().a("page_recommend", "show_", kVar.afS());
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bwO);
        }
        aVar.afY().a(kVar);
        aVar.afY().b(this.dBW);
        aVar.afY().a(this.aYP);
        return aVar.getView();
    }

    private void axX() {
        com.baidu.tieba.card.data.k.csT = "c10705";
        com.baidu.tieba.card.data.k.csU = "c10730";
        com.baidu.tieba.card.data.k.csV = "c10731";
        com.baidu.tieba.card.data.k.csW = "c10704";
        com.baidu.tieba.card.data.k.csX = "c10755";
        com.baidu.tieba.card.data.k.csY = "c10710";
        com.baidu.tieba.card.data.k.csZ = "c10736";
        com.baidu.tieba.card.data.k.cta = "c10737";
        com.baidu.tieba.card.data.k.ctb = "c10711";
        com.baidu.tieba.card.data.k.ctc = "c10758";
        com.baidu.tieba.card.data.k.ctd = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.dFE != null) {
            this.dFE.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dFF = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.aYP = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void hZ(String str) {
        this.bwO = str;
    }
}
