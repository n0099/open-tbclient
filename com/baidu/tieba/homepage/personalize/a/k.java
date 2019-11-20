package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aa;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> EP;
    private String Gc;
    private boolean Hx;
    public BdUniqueId cJo;
    private NEGFeedBackView.a dcg;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fzD;
    private com.baidu.adp.lib.e.b<TbImageView> fzE;
    private com.baidu.tieba.homepage.personalize.model.e gkp;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dcg = null;
        this.Hx = true;
        this.fzD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: blZ */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(k.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.fzE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aoc */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(k.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.EP = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.bau().gF(true);
                com.baidu.tieba.a.d.aDc().bO("page_recommend", "show_");
                if (view != null && k.this.gkp != null && kVar != null && kVar.agG() != null && !StringUtils.isNull(kVar.agG().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cS(com.baidu.adp.lib.g.b.toLong(kVar.agG().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cR(com.baidu.adp.lib.g.b.toLong(kVar.agG().getTid(), 0L));
                        k.this.gkp.a(com.baidu.adp.lib.g.b.toLong(kVar.agG().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.baE(), kVar.baF(), com.baidu.adp.lib.g.b.toInt((String) view.getTag(), 1));
                    }
                    k.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        buW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(kVar.baQ());
            com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baQ());
            com.baidu.tieba.q.c.cni().b(this.cJo, com.baidu.tieba.q.a.a(kVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, kVar.baE(), false, (String) null, (String) null));
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.baQ());
            com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baQ());
            com.baidu.tieba.q.c.cni().b(this.cJo, com.baidu.tieba.q.a.a(kVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 5, kVar.baE(), false, (String) null, (String) null));
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.baU());
            com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baU());
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.baS());
            com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baS());
            com.baidu.tieba.q.c.cni().b(this.cJo, com.baidu.tieba.q.a.a(kVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 2, kVar.baE(), false, (String) null, (String) null));
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.baS());
            com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baS());
            com.baidu.tieba.q.c.cni().b(this.cJo, com.baidu.tieba.q.a.a(kVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 2, kVar.baE(), false, (String) null, (String) null));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.baR());
            com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baR());
        } else if (id == R.id.god_reply_voice_btn) {
            an anVar = new an("c10760");
            anVar.O("obj_locate", 4);
            TiebaStatic.log(anVar);
        } else if (id == R.id.god_reply_content) {
            an anVar2 = new an("c10760");
            anVar2.O("obj_locate", 2);
            TiebaStatic.log(anVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar3 = new an("c10760");
            anVar3.O("obj_locate", 1);
            TiebaStatic.log(anVar3);
        } else if (view instanceof TbImageView) {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                an anVar4 = new an("c10760");
                anVar4.O("obj_locate", 3);
                TiebaStatic.log(anVar4);
            }
            TiebaStatic.log(kVar.baT());
            com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baT());
            com.baidu.tieba.q.c.cni().b(this.cJo, com.baidu.tieba.q.a.a(kVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 3, kVar.baE(), false, (String) null, (String) null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public z b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cJo);
        dVar.aC(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.a.k.4
            @Override // com.baidu.card.d.a
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
        aVar.c(dVar);
        final com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
        oVar.setFrom("index");
        oVar.setConstrainLayoutPool(this.fzD);
        oVar.setConstrainImagePool(this.fzE);
        oVar.setFromCDN(this.Hx);
        aVar.b(oVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.Hx);
        hVar.setForm("index");
        aVar.a((com.baidu.card.f) hVar);
        if (!ab(1) || !ab(2)) {
            oVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.personalize.a.k.5
                @Override // com.baidu.adp.widget.a.b
                public void h(int i, int i2, int i3) {
                    k.this.g(i, i2, i3);
                    if (k.this.ab(1) && k.this.ab(2)) {
                        oVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bWZ = 1;
        dVar2.bXe = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.aL(2);
        aVar.a(aaVar);
        x lU = aVar.lU();
        lU.aF(2);
        z zVar = new z(lU);
        zVar.setPageId(this.cJo);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.k.6
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (k.this.EP != null) {
                        k.this.EP.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.lV().b(new a.C0044a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, z<com.baidu.tieba.card.data.k> zVar) {
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.caz == null) {
            return null;
        }
        kVar.oO(kVar.position + 1);
        zVar.lV().setPage(this.Gc);
        zVar.lW().a(this.dcg);
        zVar.a(kVar);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.EP);
        com.baidu.tieba.card.t.bau().c(kVar.baP());
        com.baidu.tieba.a.d.aDc().a("page_recommend", "show_", kVar.baP());
        com.baidu.tieba.q.c.cni().a(this.cJo, kVar.caz != null ? kVar.caz.getId() : null, com.baidu.tieba.q.a.a(kVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", kVar.baE(), false, null, null));
        return zVar.getView();
    }

    private void buW() {
        com.baidu.tieba.card.data.k.ePg = "c10705";
        com.baidu.tieba.card.data.k.ePh = "c10730";
        com.baidu.tieba.card.data.k.ePi = "c10731";
        com.baidu.tieba.card.data.k.ePj = "c10704";
        com.baidu.tieba.card.data.k.ePk = "c10755";
        com.baidu.tieba.card.data.k.ePl = "c10710";
        com.baidu.tieba.card.data.k.ePm = "c10736";
        com.baidu.tieba.card.data.k.ePn = "c10737";
        com.baidu.tieba.card.data.k.ePo = "c10711";
        com.baidu.tieba.card.data.k.ePp = "c10758";
        com.baidu.tieba.card.data.k.ePq = "c10757";
    }

    public void setFromCDN(boolean z) {
        this.Hx = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gkp = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dcg = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.Gc = str;
    }
}
