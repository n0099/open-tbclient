package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.e;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class o extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> JE;
    private boolean Nj;
    private NEGFeedBackView.a dQj;
    public BdUniqueId dxg;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gri;
    private com.baidu.adp.lib.d.b<TbImageView> grj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Nj = true;
        this.dQj = null;
        this.gri = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bEy */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(o.this.mPageContext.getPageActivity());
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
        this.grj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.o.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aFP */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(o.this.mPageContext.getPageActivity());
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
        this.JE = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.o.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.cNb != null && kVar.cNb.aAJ() != null) {
                    o.this.a(kVar.cNb, view);
                    TiebaStatic.log(kVar.btW());
                    TiebaStatic.log(kVar.btX());
                    o.this.d(kVar.cNb, kVar.btK());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        bNs();
    }

    private void bNs() {
        com.baidu.tieba.card.data.k.fKr = "c13388";
        com.baidu.tieba.card.data.k.fKs = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public af<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dxg);
        eVar.Y(false);
        eVar.Z(false);
        eVar.aI(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.o.3
            @Override // com.baidu.card.e.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.s sVar = new com.baidu.card.s(this.mPageContext.getPageActivity());
        sVar.setFrom("index");
        sVar.setConstrainLayoutPool(this.gri);
        sVar.setConstrainImagePool(this.grj);
        sVar.setFromCDN(this.Nj);
        aVar.c(sVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        aVar.mS().aQ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62));
        aVar.mS().aN(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        aVar.mS().aP(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds23));
        af<com.baidu.tieba.card.data.k> afVar = new af<>(aVar.mT());
        afVar.setPageId(this.dxg);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.o.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                if (kVar != null && kVar.cNb != null && kVar.cNb.aAJ() != null) {
                    o.this.a(kVar.cNb, view);
                    TiebaStatic.log(kVar.btW());
                    TiebaStatic.log(kVar.btX());
                    o.this.d(kVar.cNb, kVar.btK());
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cNb == null) {
            return null;
        }
        kVar.rm(kVar.position + 1);
        com.baidu.card.w ad = afVar.ad(false);
        ad.aL(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47));
        ad.a(this.dQj);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mU().a(this.JE);
        com.baidu.tieba.card.r.btA().c(kVar.btV());
        com.baidu.tieba.a.d.aVo().a("page_recommend", "show_", kVar.btV());
        e(kVar.cNb, kVar.btK());
        return afVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dQj = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bj bjVar, View view) {
        if (bjVar != null && bjVar.aAJ() != null) {
            String str = bjVar.aAJ().id;
            String str2 = bjVar.aAJ().link;
            String str3 = bjVar.aAJ().h5_url;
            Long l = bjVar.aAJ().swan_app_id;
            long parseLong = Long.parseLong(bjVar.getTid());
            String str4 = bjVar.aAJ().name;
            long fid = bjVar.getFid();
            com.baidu.tbadk.core.sharedPref.b.aDr().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.aDr().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.aDr().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bjVar.aAJ().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.l.zC(bjVar.getTid());
                TiebaStatic.log(new an("c13274").s("fid", fid).s("tid", parseLong).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", str4).s("obj_id", l.longValue()).cp("obj_source", "index_card").Z("obj_param1", bjVar.aAJ().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bj bjVar, int i) {
        if (bjVar != null && bjVar.aAJ() != null) {
            com.baidu.tieba.r.c.cIs().b(this.dxg, com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bjVar.aAJ().id));
        }
    }

    private void e(bj bjVar, int i) {
        if (bjVar != null && bjVar.aAJ() != null) {
            String str = bjVar.aAJ().id;
            com.baidu.tieba.r.c.cIs().a(this.dxg, com.baidu.tieba.r.a.a(bjVar.getTid(), "", str, null), com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
