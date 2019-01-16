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
    public BdUniqueId bes;
    private NEGFeedBackView.a bxO;
    private String cbk;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dQa;
    private com.baidu.adp.lib.e.b<TbImageView> dQb;
    private ad eub;
    private p ezo;
    private com.baidu.tieba.homepage.personalize.model.e ezp;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == this.ezo.getView().getId()) {
            TiebaStatic.log(kVar.kR(1));
            com.baidu.tieba.a.d.Wk().a("page_recommend", "clk_", kVar.arl());
            com.baidu.tieba.q.c.bCC().b(this.bes, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqZ(), false, null, null));
        } else if (this.ezo.cYy != null && view.getId() == this.ezo.cYy.getId()) {
            TiebaStatic.log(kVar.arp());
            com.baidu.tieba.a.d.Wk().a("page_recommend", "clk_", kVar.arp());
        } else if (this.ezo.getHeaderImg() != null && view.getId() == this.ezo.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.arn());
            com.baidu.tieba.a.d.Wk().a("page_recommend", "clk_", kVar.arn());
            com.baidu.tieba.q.c.bCC().b(this.bes, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqZ(), false, null, null));
        } else if (this.ezo.aqs() != null && view.getId() == this.ezo.aqs().getId()) {
            TiebaStatic.log(kVar.arn());
            com.baidu.tieba.a.d.Wk().a("page_recommend", "clk_", kVar.arn());
            com.baidu.tieba.q.c.bCC().b(this.bes, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqZ(), false, null, null));
        } else if (this.ezo.cbx != null && this.ezo.cbx.getBarNameTv() != null && view.getId() == this.ezo.cbx.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.arm());
            com.baidu.tieba.a.d.Wk().a("page_recommend", "clk_", kVar.arm());
        } else if (this.ezo.cck != null && this.ezo.cck.aKL != null && view.getId() == this.ezo.cck.aKL.getId()) {
            TiebaStatic.log(kVar.arm());
            com.baidu.tieba.a.d.Wk().a("page_recommend", "clk_", kVar.arm());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(kVar.aro());
            com.baidu.tieba.a.d.Wk().a("page_recommend", "clk_", kVar.aro());
            com.baidu.tieba.q.c.bCC().b(this.bes, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 3, kVar.aqZ(), false, null, null));
        } else if (this.ezo.aqr() != null && view.getId() == this.ezo.aqr().getId()) {
            TiebaStatic.log(kVar.ng("c10760"));
            com.baidu.tieba.a.d.Wk().a("page_recommend", "clk_", kVar.ng("c10760"));
        } else if (this.ezo.cbx.getCommentContainer() != null && view.getId() == this.ezo.cbx.getCommentContainer().getId()) {
            TiebaStatic.log(kVar.kR(2));
            com.baidu.tieba.q.c.bCC().b(this.bes, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 5, kVar.aqZ(), false, null, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.k kVar) {
        if (view instanceof TbImageView) {
            am aB = new am("c11004").aB("tid", kVar.threadData.getTid());
            TiebaStatic.log(aB);
            com.baidu.tieba.a.d.Wk().a("page_recommend", "clk_", aB);
            com.baidu.tieba.q.c.bCC().b(this.bes, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 3, kVar.aqZ(), false, null, null));
        } else if (view.getId() == this.ezo.getView().getId()) {
            am aB2 = new am("c11004").aB("tid", kVar.threadData.getTid());
            TiebaStatic.log(aB2);
            com.baidu.tieba.a.d.Wk().a("page_recommend", "clk_", aB2);
            am aB3 = new am("c10806").y("obj_locate", 1).aB("tid", kVar.threadData.getId());
            TiebaStatic.log(aB3);
            com.baidu.tieba.a.d.Wk().a("page_recommend", "clk_", aB3);
            com.baidu.tieba.q.c.bCC().b(this.bes, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqZ(), false, null, null));
        } else {
            am aB4 = new am("c11004").aB("tid", kVar.threadData.getTid());
            TiebaStatic.log(aB4);
            com.baidu.tieba.a.d.Wk().a("page_recommend", "clk_", aB4);
            com.baidu.tieba.q.c.bCC().b(this.bes, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqZ(), false, null, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bxO = null;
        this.dQa = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aDZ */
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
        this.dQb = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: FH */
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
        this.eub = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.aqP().dT(true);
                if (view != null && f.this.ezo != null && f.this.ezo.getView() != null && f.this.ezp != null && kVar != null && kVar.aaq() != null && !StringUtils.isNull(kVar.aaq().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cj(com.baidu.adp.lib.g.b.d(kVar.aaq().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.ci(com.baidu.adp.lib.g.b.d(kVar.aaq().getTid(), 0L));
                        f.this.ezp.a(com.baidu.adp.lib.g.b.d(kVar.aaq().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aqZ(), kVar.arb(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.dbG) {
                        f.this.c(view, kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aME();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<p> onCreateViewHolder(ViewGroup viewGroup) {
        final p pVar = new p(this.mPageContext);
        pVar.setConstrainLayoutPool(this.dQa);
        pVar.setConstrainImagePool(this.dQb);
        pVar.j(this.bes);
        pVar.currentPageType = 2;
        if (pVar.cbx != null) {
            pVar.cbx.awo = 2;
        }
        if (pVar.cck != null && pVar.cck.aKM != null) {
            pVar.cck.aKM.awo = 2;
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
        this.ezo = pVar;
        return new com.baidu.tieba.card.a.a<>(this.ezo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (kVar == null || aVar == null || aVar.arr() == null) {
            return null;
        }
        kVar.kP(i + 1);
        v.aqP().a(kVar.ark());
        com.baidu.tieba.a.d.Wk().a("page_recommend", "show_", kVar.ark());
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbk);
        }
        aVar.arr().kL(i + 1);
        aVar.arr().a(kVar);
        aVar.arr().b(this.eub);
        aVar.arr().a(this.bxO);
        com.baidu.tieba.q.c.bCC().a(this.bes, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aqZ(), false, null, null));
        return aVar.getView();
    }

    private void aME() {
        com.baidu.tieba.card.data.k.dbv = "c10705";
        com.baidu.tieba.card.data.k.dbw = "c10730";
        com.baidu.tieba.card.data.k.dbx = "c10731";
        com.baidu.tieba.card.data.k.dby = "c10704";
        com.baidu.tieba.card.data.k.dbz = "c10755";
        com.baidu.tieba.card.data.k.dbA = "c10710";
        com.baidu.tieba.card.data.k.dbB = "c10736";
        com.baidu.tieba.card.data.k.dbC = "c10737";
        com.baidu.tieba.card.data.k.dbD = "c10711";
        com.baidu.tieba.card.data.k.dbE = "c10758";
        com.baidu.tieba.card.data.k.dbF = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.ezo != null) {
            this.ezo.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ezp = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bxO = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbk = str;
    }
}
