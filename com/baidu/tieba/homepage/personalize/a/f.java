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
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<p>> implements com.baidu.tieba.a.f {
    public BdUniqueId aUU;
    private String bNq;
    private NEGFeedBackView.a boM;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dwN;
    private com.baidu.adp.lib.e.b<TbImageView> dwO;
    private ad eav;
    private p efD;
    private com.baidu.tieba.homepage.personalize.model.e efE;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == this.efD.getView().getId()) {
            TiebaStatic.log(kVar.ali());
            com.baidu.tieba.a.d.SB().a("page_recommend", "clk_", kVar.ali());
        } else if (this.efD.cEQ != null && view.getId() == this.efD.cEQ.getId()) {
            TiebaStatic.log(kVar.alm());
            com.baidu.tieba.a.d.SB().a("page_recommend", "clk_", kVar.alm());
        } else if (this.efD.getHeaderImg() != null && view.getId() == this.efD.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.alk());
            com.baidu.tieba.a.d.SB().a("page_recommend", "clk_", kVar.alk());
        } else if (this.efD.akp() != null && view.getId() == this.efD.akp().getId()) {
            TiebaStatic.log(kVar.alk());
            com.baidu.tieba.a.d.SB().a("page_recommend", "clk_", kVar.alk());
        } else if (this.efD.bND != null && this.efD.bND.getBarNameTv() != null && view.getId() == this.efD.bND.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.alj());
            com.baidu.tieba.a.d.SB().a("page_recommend", "clk_", kVar.alj());
        } else if (this.efD.bOr != null && this.efD.bOr.aBk != null && view.getId() == this.efD.bOr.aBk.getId()) {
            TiebaStatic.log(kVar.alj());
            com.baidu.tieba.a.d.SB().a("page_recommend", "clk_", kVar.alj());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(kVar.all());
            com.baidu.tieba.a.d.SB().a("page_recommend", "clk_", kVar.all());
        } else if (this.efD.ako() != null && view.getId() == this.efD.ako().getId()) {
            TiebaStatic.log(kVar.lL("c10760"));
            com.baidu.tieba.a.d.SB().a("page_recommend", "clk_", kVar.lL("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.k kVar) {
        if (view instanceof TbImageView) {
            am al = new am("c11004").al("tid", kVar.threadData.getTid());
            TiebaStatic.log(al);
            com.baidu.tieba.a.d.SB().a("page_recommend", "clk_", al);
        } else if (view.getId() == this.efD.getView().getId()) {
            am al2 = new am("c11004").al("tid", kVar.threadData.getTid());
            TiebaStatic.log(al2);
            com.baidu.tieba.a.d.SB().a("page_recommend", "clk_", al2);
            am al3 = new am("c10806").w("obj_locate", 1).al("tid", kVar.threadData.getId());
            TiebaStatic.log(al3);
            com.baidu.tieba.a.d.SB().a("page_recommend", "clk_", al3);
        } else {
            am al4 = new am("c11004").al("tid", kVar.threadData.getTid());
            TiebaStatic.log(al4);
            com.baidu.tieba.a.d.SB().a("page_recommend", "clk_", al4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boM = null;
        this.dwN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ayk */
            public ConstrainImageLayout jm() {
                return new ConstrainImageLayout(f.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void r(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout t(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dwO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ca */
            public TbImageView jm() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void r(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView s(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView t(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.eav = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.akM().dc(true);
                if (view != null && f.this.efD != null && f.this.efD.getView() != null && f.this.efE != null && kVar != null && kVar.UT() != null && !StringUtils.isNull(kVar.UT().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.bV(com.baidu.adp.lib.g.b.d(kVar.UT().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.bU(com.baidu.adp.lib.g.b.d(kVar.UT().getTid(), 0L));
                        f.this.efE.a(com.baidu.adp.lib.g.b.d(kVar.UT().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.akW(), kVar.akY(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.cHX) {
                        f.this.c(view, kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aGJ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<p> onCreateViewHolder(ViewGroup viewGroup) {
        final p pVar = new p(this.mPageContext);
        pVar.setConstrainLayoutPool(this.dwN);
        pVar.setConstrainImagePool(this.dwO);
        pVar.j(this.aUU);
        pVar.currentPageType = 2;
        if (pVar.bND != null) {
            pVar.bND.amD = 2;
        }
        if (pVar.bOr != null && pVar.bOr.aBl != null) {
            pVar.bOr.aBl.amD = 2;
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
        this.efD = pVar;
        return new com.baidu.tieba.card.a.a<>(this.efD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (kVar == null || aVar == null || aVar.aln() == null) {
            return null;
        }
        kVar.jv(i + 1);
        v.akM().a(kVar.alh());
        com.baidu.tieba.a.d.SB().a("page_recommend", "show_", kVar.alh());
        if (aVar.aln() instanceof com.baidu.tieba.a.e) {
            aVar.aln().setPage(this.bNq);
        }
        aVar.aln().a(kVar);
        aVar.aln().b(this.eav);
        aVar.aln().a(this.boM);
        return aVar.getView();
    }

    private void aGJ() {
        com.baidu.tieba.card.data.k.cHM = "c10705";
        com.baidu.tieba.card.data.k.cHN = "c10730";
        com.baidu.tieba.card.data.k.cHO = "c10731";
        com.baidu.tieba.card.data.k.cHP = "c10704";
        com.baidu.tieba.card.data.k.cHQ = "c10755";
        com.baidu.tieba.card.data.k.cHR = "c10710";
        com.baidu.tieba.card.data.k.cHS = "c10736";
        com.baidu.tieba.card.data.k.cHT = "c10737";
        com.baidu.tieba.card.data.k.cHU = "c10711";
        com.baidu.tieba.card.data.k.cHV = "c10758";
        com.baidu.tieba.card.data.k.cHW = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.efD != null) {
            this.efD.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.efE = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.boM = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }
}
