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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<p>> implements com.baidu.tieba.a.f {
    public BdUniqueId aRC;
    private String bHB;
    private NEGFeedBackView.a bjc;
    private ad dTe;
    private p dYj;
    private com.baidu.tieba.homepage.personalize.model.e dYk;
    private com.baidu.adp.lib.e.b<TbImageView> dqA;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dqz;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == this.dYj.getView().getId()) {
            TiebaStatic.log(kVar.ajx());
            com.baidu.tieba.a.d.QN().a("page_recommend", "clk_", kVar.ajx());
        } else if (this.dYj.cyY != null && view.getId() == this.dYj.cyY.getId()) {
            TiebaStatic.log(kVar.ajB());
            com.baidu.tieba.a.d.QN().a("page_recommend", "clk_", kVar.ajB());
        } else if (this.dYj.getHeaderImg() != null && view.getId() == this.dYj.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.ajz());
            com.baidu.tieba.a.d.QN().a("page_recommend", "clk_", kVar.ajz());
        } else if (this.dYj.aiF() != null && view.getId() == this.dYj.aiF().getId()) {
            TiebaStatic.log(kVar.ajz());
            com.baidu.tieba.a.d.QN().a("page_recommend", "clk_", kVar.ajz());
        } else if (this.dYj.bHO != null && this.dYj.bHO.getBarNameTv() != null && view.getId() == this.dYj.bHO.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.ajy());
            com.baidu.tieba.a.d.QN().a("page_recommend", "clk_", kVar.ajy());
        } else if (this.dYj.bIC != null && this.dYj.bIC.ayn != null && view.getId() == this.dYj.bIC.ayn.getId()) {
            TiebaStatic.log(kVar.ajy());
            com.baidu.tieba.a.d.QN().a("page_recommend", "clk_", kVar.ajy());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(kVar.ajA());
            com.baidu.tieba.a.d.QN().a("page_recommend", "clk_", kVar.ajA());
        } else if (this.dYj.aiE() != null && view.getId() == this.dYj.aiE().getId()) {
            TiebaStatic.log(kVar.lj("c10760"));
            com.baidu.tieba.a.d.QN().a("page_recommend", "clk_", kVar.lj("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.k kVar) {
        if (view instanceof TbImageView) {
            an ae = new an("c11004").ae("tid", kVar.threadData.getTid());
            TiebaStatic.log(ae);
            com.baidu.tieba.a.d.QN().a("page_recommend", "clk_", ae);
        } else if (view.getId() == this.dYj.getView().getId()) {
            an ae2 = new an("c11004").ae("tid", kVar.threadData.getTid());
            TiebaStatic.log(ae2);
            com.baidu.tieba.a.d.QN().a("page_recommend", "clk_", ae2);
            an ae3 = new an("c10806").r("obj_locate", 1).ae("tid", kVar.threadData.getId());
            TiebaStatic.log(ae3);
            com.baidu.tieba.a.d.QN().a("page_recommend", "clk_", ae3);
        } else {
            an ae4 = new an("c11004").ae("tid", kVar.threadData.getTid());
            TiebaStatic.log(ae4);
            com.baidu.tieba.a.d.QN().a("page_recommend", "clk_", ae4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bjc = null;
        this.dqz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avZ */
            public ConstrainImageLayout ig() {
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
        this.dqA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AO */
            public TbImageView ig() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(f.d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds1));
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
        this.dTe = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.ajb().cL(true);
                if (view != null && f.this.dYj != null && f.this.dYj.getView() != null && f.this.dYk != null && kVar != null && kVar.Tg() != null && !StringUtils.isNull(kVar.Tg().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.e.bR(com.baidu.adp.lib.g.b.c(kVar.Tg().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.e.bQ(com.baidu.adp.lib.g.b.c(kVar.Tg().getTid(), 0L));
                        f.this.dYk.a(com.baidu.adp.lib.g.b.c(kVar.Tg().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.ajl(), kVar.ajn(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.cCg) {
                        f.this.c(view, kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aEu();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<p> onCreateViewHolder(ViewGroup viewGroup) {
        this.dYj = new p(this.mPageContext);
        this.dYj.setConstrainLayoutPool(this.dqz);
        this.dYj.setConstrainImagePool(this.dqA);
        this.dYj.j(this.aRC);
        this.dYj.currentPageType = 2;
        if (this.dYj.bHO != null) {
            this.dYj.bHO.ajY = 2;
        }
        if (this.dYj.bIC != null && this.dYj.bIC.ayo != null) {
            this.dYj.bIC.ayo.ajY = 2;
        }
        return new com.baidu.tieba.card.a.a<>(this.dYj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (kVar == null || aVar == null || aVar.ajC() == null) {
            return null;
        }
        kVar.iW(i + 1);
        v.ajb().a(kVar.ajw());
        com.baidu.tieba.a.d.QN().a("page_recommend", "show_", kVar.ajw());
        if (aVar.ajC() instanceof com.baidu.tieba.a.e) {
            aVar.ajC().setPage(this.bHB);
        }
        aVar.ajC().a(kVar);
        aVar.ajC().b(this.dTe);
        aVar.ajC().a(this.bjc);
        return aVar.getView();
    }

    private void aEu() {
        com.baidu.tieba.card.data.k.cBV = "c10705";
        com.baidu.tieba.card.data.k.cBW = "c10730";
        com.baidu.tieba.card.data.k.cBX = "c10731";
        com.baidu.tieba.card.data.k.cBY = "c10704";
        com.baidu.tieba.card.data.k.cBZ = "c10755";
        com.baidu.tieba.card.data.k.cCa = "c10710";
        com.baidu.tieba.card.data.k.cCb = "c10736";
        com.baidu.tieba.card.data.k.cCc = "c10737";
        com.baidu.tieba.card.data.k.cCd = "c10711";
        com.baidu.tieba.card.data.k.cCe = "c10758";
        com.baidu.tieba.card.data.k.cCf = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.dYj != null) {
            this.dYj.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dYk = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bjc = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void iB(String str) {
        this.bHB = str;
    }
}
