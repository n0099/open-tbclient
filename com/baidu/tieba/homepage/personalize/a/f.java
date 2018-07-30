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
    private String bHB;
    private NEGFeedBackView.a biW;
    private ad dTj;
    private p dYm;
    private com.baidu.tieba.homepage.personalize.model.e dYn;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dqB;
    private com.baidu.adp.lib.e.b<TbImageView> dqC;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == this.dYm.getView().getId()) {
            TiebaStatic.log(kVar.aju());
            com.baidu.tieba.a.d.QI().a("page_recommend", "clk_", kVar.aju());
        } else if (this.dYm.czb != null && view.getId() == this.dYm.czb.getId()) {
            TiebaStatic.log(kVar.ajy());
            com.baidu.tieba.a.d.QI().a("page_recommend", "clk_", kVar.ajy());
        } else if (this.dYm.getHeaderImg() != null && view.getId() == this.dYm.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.ajw());
            com.baidu.tieba.a.d.QI().a("page_recommend", "clk_", kVar.ajw());
        } else if (this.dYm.aiC() != null && view.getId() == this.dYm.aiC().getId()) {
            TiebaStatic.log(kVar.ajw());
            com.baidu.tieba.a.d.QI().a("page_recommend", "clk_", kVar.ajw());
        } else if (this.dYm.bHO != null && this.dYm.bHO.getBarNameTv() != null && view.getId() == this.dYm.bHO.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.ajv());
            com.baidu.tieba.a.d.QI().a("page_recommend", "clk_", kVar.ajv());
        } else if (this.dYm.bIC != null && this.dYm.bIC.ayq != null && view.getId() == this.dYm.bIC.ayq.getId()) {
            TiebaStatic.log(kVar.ajv());
            com.baidu.tieba.a.d.QI().a("page_recommend", "clk_", kVar.ajv());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(kVar.ajx());
            com.baidu.tieba.a.d.QI().a("page_recommend", "clk_", kVar.ajx());
        } else if (this.dYm.aiB() != null && view.getId() == this.dYm.aiB().getId()) {
            TiebaStatic.log(kVar.lh("c10760"));
            com.baidu.tieba.a.d.QI().a("page_recommend", "clk_", kVar.lh("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.k kVar) {
        if (view instanceof TbImageView) {
            an af = new an("c11004").af("tid", kVar.threadData.getTid());
            TiebaStatic.log(af);
            com.baidu.tieba.a.d.QI().a("page_recommend", "clk_", af);
        } else if (view.getId() == this.dYm.getView().getId()) {
            an af2 = new an("c11004").af("tid", kVar.threadData.getTid());
            TiebaStatic.log(af2);
            com.baidu.tieba.a.d.QI().a("page_recommend", "clk_", af2);
            an af3 = new an("c10806").r("obj_locate", 1).af("tid", kVar.threadData.getId());
            TiebaStatic.log(af3);
            com.baidu.tieba.a.d.QI().a("page_recommend", "clk_", af3);
        } else {
            an af4 = new an("c11004").af("tid", kVar.threadData.getTid());
            TiebaStatic.log(af4);
            com.baidu.tieba.a.d.QI().a("page_recommend", "clk_", af4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.biW = null;
        this.dqB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awa */
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
        this.dqC = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AR */
            public TbImageView ig() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(d.C0140d.common_color_10264));
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
        this.dTj = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.aiY().cK(true);
                if (view != null && f.this.dYm != null && f.this.dYm.getView() != null && f.this.dYn != null && kVar != null && kVar.Td() != null && !StringUtils.isNull(kVar.Td().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.e.bR(com.baidu.adp.lib.g.b.c(kVar.Td().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.e.bQ(com.baidu.adp.lib.g.b.c(kVar.Td().getTid(), 0L));
                        f.this.dYn.a(com.baidu.adp.lib.g.b.c(kVar.Td().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aji(), kVar.ajk(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.cCj) {
                        f.this.c(view, kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aEx();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<p> onCreateViewHolder(ViewGroup viewGroup) {
        this.dYm = new p(this.mPageContext);
        this.dYm.setConstrainLayoutPool(this.dqB);
        this.dYm.setConstrainImagePool(this.dqC);
        this.dYm.j(this.aRF);
        this.dYm.currentPageType = 2;
        if (this.dYm.bHO != null) {
            this.dYm.bHO.ajY = 2;
        }
        if (this.dYm.bIC != null && this.dYm.bIC.ayr != null) {
            this.dYm.bIC.ayr.ajY = 2;
        }
        return new com.baidu.tieba.card.a.a<>(this.dYm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (kVar == null || aVar == null || aVar.ajz() == null) {
            return null;
        }
        kVar.iX(i + 1);
        v.aiY().a(kVar.ajt());
        com.baidu.tieba.a.d.QI().a("page_recommend", "show_", kVar.ajt());
        if (aVar.ajz() instanceof com.baidu.tieba.a.e) {
            aVar.ajz().setPage(this.bHB);
        }
        aVar.ajz().a(kVar);
        aVar.ajz().b(this.dTj);
        aVar.ajz().a(this.biW);
        return aVar.getView();
    }

    private void aEx() {
        com.baidu.tieba.card.data.k.cBY = "c10705";
        com.baidu.tieba.card.data.k.cBZ = "c10730";
        com.baidu.tieba.card.data.k.cCa = "c10731";
        com.baidu.tieba.card.data.k.cCb = "c10704";
        com.baidu.tieba.card.data.k.cCc = "c10755";
        com.baidu.tieba.card.data.k.cCd = "c10710";
        com.baidu.tieba.card.data.k.cCe = "c10736";
        com.baidu.tieba.card.data.k.cCf = "c10737";
        com.baidu.tieba.card.data.k.cCg = "c10711";
        com.baidu.tieba.card.data.k.cCh = "c10758";
        com.baidu.tieba.card.data.k.cCi = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.dYm != null) {
            this.dYm.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dYn = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.biW = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void iA(String str) {
        this.bHB = str;
    }
}
