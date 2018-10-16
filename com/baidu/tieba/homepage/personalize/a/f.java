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
    public BdUniqueId aZt;
    private String bVS;
    private NEGFeedBackView.a bsM;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dEO;
    private com.baidu.adp.lib.e.b<TbImageView> dEP;
    private ad eio;
    private p enw;
    private com.baidu.tieba.homepage.personalize.model.e enx;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == this.enw.getView().getId()) {
            TiebaStatic.log(kVar.aoK());
            com.baidu.tieba.a.d.Ux().a("page_recommend", "clk_", kVar.aoK());
        } else if (this.enw.cNk != null && view.getId() == this.enw.cNk.getId()) {
            TiebaStatic.log(kVar.aoO());
            com.baidu.tieba.a.d.Ux().a("page_recommend", "clk_", kVar.aoO());
        } else if (this.enw.getHeaderImg() != null && view.getId() == this.enw.getHeaderImg().getId()) {
            TiebaStatic.log(kVar.aoM());
            com.baidu.tieba.a.d.Ux().a("page_recommend", "clk_", kVar.aoM());
        } else if (this.enw.anR() != null && view.getId() == this.enw.anR().getId()) {
            TiebaStatic.log(kVar.aoM());
            com.baidu.tieba.a.d.Ux().a("page_recommend", "clk_", kVar.aoM());
        } else if (this.enw.bWf != null && this.enw.bWf.getBarNameTv() != null && view.getId() == this.enw.bWf.getBarNameTv().getId()) {
            TiebaStatic.log(kVar.aoL());
            com.baidu.tieba.a.d.Ux().a("page_recommend", "clk_", kVar.aoL());
        } else if (this.enw.bWS != null && this.enw.bWS.aFR != null && view.getId() == this.enw.bWS.aFR.getId()) {
            TiebaStatic.log(kVar.aoL());
            com.baidu.tieba.a.d.Ux().a("page_recommend", "clk_", kVar.aoL());
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(kVar.aoN());
            com.baidu.tieba.a.d.Ux().a("page_recommend", "clk_", kVar.aoN());
        } else if (this.enw.anQ() != null && view.getId() == this.enw.anQ().getId()) {
            TiebaStatic.log(kVar.mn("c10760"));
            com.baidu.tieba.a.d.Ux().a("page_recommend", "clk_", kVar.mn("c10760"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.k kVar) {
        if (view instanceof TbImageView) {
            am ax = new am("c11004").ax("tid", kVar.threadData.getTid());
            TiebaStatic.log(ax);
            com.baidu.tieba.a.d.Ux().a("page_recommend", "clk_", ax);
        } else if (view.getId() == this.enw.getView().getId()) {
            am ax2 = new am("c11004").ax("tid", kVar.threadData.getTid());
            TiebaStatic.log(ax2);
            com.baidu.tieba.a.d.Ux().a("page_recommend", "clk_", ax2);
            am ax3 = new am("c10806").x("obj_locate", 1).ax("tid", kVar.threadData.getId());
            TiebaStatic.log(ax3);
            com.baidu.tieba.a.d.Ux().a("page_recommend", "clk_", ax3);
        } else {
            am ax4 = new am("c11004").ax("tid", kVar.threadData.getTid());
            TiebaStatic.log(ax4);
            com.baidu.tieba.a.d.Ux().a("page_recommend", "clk_", ax4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bsM = null;
        this.dEO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aBF */
            public ConstrainImageLayout jB() {
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
        this.dEP = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ef */
            public TbImageView jB() {
                TbImageView tbImageView = new TbImageView(f.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds1));
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
        this.eio = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.aoo().dy(true);
                if (view != null && f.this.enw != null && f.this.enw.getView() != null && f.this.enx != null && kVar != null && kVar.YA() != null && !StringUtils.isNull(kVar.YA().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cc(com.baidu.adp.lib.g.b.d(kVar.YA().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cb(com.baidu.adp.lib.g.b.d(kVar.YA().getTid(), 0L));
                        f.this.enx.a(com.baidu.adp.lib.g.b.d(kVar.YA().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aoy(), kVar.aoA(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    if (f.this.mType == com.baidu.tieba.card.data.k.TYPE) {
                        f.this.b(view, kVar);
                    } else if (f.this.mType == com.baidu.tieba.card.data.k.cQq) {
                        f.this.c(view, kVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aKb();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<p> onCreateViewHolder(ViewGroup viewGroup) {
        final p pVar = new p(this.mPageContext);
        pVar.setConstrainLayoutPool(this.dEO);
        pVar.setConstrainImagePool(this.dEP);
        pVar.j(this.aZt);
        pVar.currentPageType = 2;
        if (pVar.bWf != null) {
            pVar.bWf.ary = 2;
        }
        if (pVar.bWS != null && pVar.bWS.aFS != null) {
            pVar.bWS.aFS.ary = 2;
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
        this.enw = pVar;
        return new com.baidu.tieba.card.a.a<>(this.enw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (kVar == null || aVar == null || aVar.aoP() == null) {
            return null;
        }
        kVar.jT(i + 1);
        v.aoo().a(kVar.aoJ());
        com.baidu.tieba.a.d.Ux().a("page_recommend", "show_", kVar.aoJ());
        if (aVar.aoP() instanceof com.baidu.tieba.a.e) {
            aVar.aoP().setPage(this.bVS);
        }
        aVar.aoP().a(kVar);
        aVar.aoP().b(this.eio);
        aVar.aoP().a(this.bsM);
        return aVar.getView();
    }

    private void aKb() {
        com.baidu.tieba.card.data.k.cQf = "c10705";
        com.baidu.tieba.card.data.k.cQg = "c10730";
        com.baidu.tieba.card.data.k.cQh = "c10731";
        com.baidu.tieba.card.data.k.cQi = "c10704";
        com.baidu.tieba.card.data.k.cQj = "c10755";
        com.baidu.tieba.card.data.k.cQk = "c10710";
        com.baidu.tieba.card.data.k.cQl = "c10736";
        com.baidu.tieba.card.data.k.cQm = "c10737";
        com.baidu.tieba.card.data.k.cQn = "c10711";
        com.baidu.tieba.card.data.k.cQo = "c10758";
        com.baidu.tieba.card.data.k.cQp = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.enw != null) {
            this.enw.setFromCDN(z);
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.enx = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bsM = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }
}
