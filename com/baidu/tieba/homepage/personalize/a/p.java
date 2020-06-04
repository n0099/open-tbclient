package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.e;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ag<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adt;
    private boolean aha;
    private NEGFeedBackView.a eJK;
    public BdUniqueId epM;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hss;
    private com.baidu.adp.lib.d.b<TbImageView> hst;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aha = true;
        this.eJK = null;
        this.hss = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bXn */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(p.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.hst = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aWN */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(p.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.adt = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.dEA != null && kVar.dEA.aRn() != null) {
                    p.this.a(kVar.dEA, view);
                    TiebaStatic.log(kVar.bLO());
                    TiebaStatic.log(kVar.bLP());
                    p.this.e(kVar.dEA, kVar.bLB());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        cgp();
    }

    private void cgp() {
        com.baidu.tieba.card.data.k.gHx = "c13388";
        com.baidu.tieba.card.data.k.gHy = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.epM);
        eVar.aC(false);
        eVar.aD(false);
        eVar.aY(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.p.3
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.t tVar = new com.baidu.card.t(this.mPageContext.getPageActivity());
        tVar.setFrom("index");
        tVar.setConstrainLayoutPool(this.hss);
        tVar.setConstrainImagePool(this.hst);
        tVar.setFromCDN(this.aha);
        aVar.c(tVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ab(this.mPageContext.getPageActivity()));
        aVar.rK().bh(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62));
        aVar.rK().be(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        aVar.rK().bg(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds23));
        ag<com.baidu.tieba.card.data.k> agVar = new ag<>(aVar.rL());
        agVar.setPageId(this.epM);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.homepage.personalize.a.p.4
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) oVar;
                if (kVar != null && kVar.dEA != null && kVar.dEA.aRn() != null) {
                    p.this.a(kVar.dEA, view);
                    TiebaStatic.log(kVar.bLO());
                    TiebaStatic.log(kVar.bLP());
                    p.this.e(kVar.dEA, kVar.bLB());
                }
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ag<com.baidu.tieba.card.data.k> agVar) {
        if (kVar == null || agVar == null || agVar.getView() == null || kVar.dEA == null) {
            return null;
        }
        kVar.st(kVar.position + 1);
        agVar.aH(false).a(this.eJK);
        agVar.b((ag<com.baidu.tieba.card.data.k>) kVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.adt);
        com.baidu.tieba.card.s.bLs().e(kVar.bLN());
        com.baidu.tieba.a.d.bmb().a("page_recommend", "show_", kVar.bLN());
        f(kVar.dEA, kVar.bLB());
        return agVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eJK = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bk bkVar, View view) {
        if (bkVar != null && bkVar.aRn() != null) {
            String str = bkVar.aRn().id;
            String str2 = bkVar.aRn().link;
            String str3 = bkVar.aRn().h5_url;
            Long l = bkVar.aRn().swan_app_id;
            long parseLong = Long.parseLong(bkVar.getTid());
            String str4 = bkVar.aRn().name;
            long fid = bkVar.getFid();
            com.baidu.tbadk.core.sharedPref.b.aTX().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.aTX().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.aTX().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bkVar.aRn().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.m.Dn(bkVar.getTid());
                TiebaStatic.log(new an("c13274").s("fid", fid).s("tid", parseLong).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("obj_name", str4).s("obj_id", l.longValue()).dh("obj_source", "index_card").ag("obj_param1", bkVar.aRn().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bk bkVar, int i) {
        if (bkVar != null && bkVar.aRn() != null) {
            com.baidu.tieba.s.c.dcI().b(this.epM, com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bkVar.aRn().id));
        }
    }

    private void f(bk bkVar, int i) {
        if (bkVar != null && bkVar.aRn() != null) {
            String str = bkVar.aRn().id;
            com.baidu.tieba.s.c.dcI().a(this.epM, com.baidu.tieba.s.a.a(bkVar.getTid(), "", str, (BaijiahaoData) null), com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
