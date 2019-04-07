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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Xr;
    private String YA;
    private boolean ZQ;
    private NEGFeedBackView.a cIV;
    public BdUniqueId cnZ;
    private com.baidu.tieba.homepage.personalize.model.e fLD;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdJ;
    private com.baidu.adp.lib.e.b<TbImageView> fdK;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cIV = null;
        this.ZQ = true;
        this.fdJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beG */
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
        this.fdK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aeY */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(k.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0277d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
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
        this.Xr = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aQD().go(true);
                com.baidu.tieba.a.d.awh().bA("page_recommend", "show_");
                if (view != null && k.this.fLD != null && kVar != null && kVar.WO() != null && !StringUtils.isNull(kVar.WO().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cM(com.baidu.adp.lib.g.b.d(kVar.WO().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cL(com.baidu.adp.lib.g.b.d(kVar.WO().getTid(), 0L));
                        k.this.fLD.a(com.baidu.adp.lib.g.b.d(kVar.WO().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aQN(), kVar.aQO(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    k.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bmI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == d.g.thread_card_root) {
            TiebaStatic.log(kVar.aQZ());
            com.baidu.tieba.a.d.awh().a("page_recommend", "clk_", kVar.aQZ());
            com.baidu.tieba.q.c.cdp().b(this.cnZ, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aQN(), false, null, null));
        } else if (id == d.g.thread_info_commont_container) {
            TiebaStatic.log(kVar.aQZ());
            com.baidu.tieba.a.d.awh().a("page_recommend", "clk_", kVar.aQZ());
            com.baidu.tieba.q.c.cdp().b(this.cnZ, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 5, kVar.aQN(), false, null, null));
        } else if (id == d.g.thread_card_voice) {
            TiebaStatic.log(kVar.aRd());
            com.baidu.tieba.a.d.awh().a("page_recommend", "clk_", kVar.aRd());
        } else if (id == d.g.user_avatar) {
            TiebaStatic.log(kVar.aRb());
            com.baidu.tieba.a.d.awh().a("page_recommend", "clk_", kVar.aRb());
            com.baidu.tieba.q.c.cdp().b(this.cnZ, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aQN(), false, null, null));
        } else if (id == d.g.user_name) {
            TiebaStatic.log(kVar.aRb());
            com.baidu.tieba.a.d.awh().a("page_recommend", "clk_", kVar.aRb());
            com.baidu.tieba.q.c.cdp().b(this.cnZ, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aQN(), false, null, null));
        } else if (id == d.g.forum_name_text) {
            TiebaStatic.log(kVar.aRa());
            com.baidu.tieba.a.d.awh().a("page_recommend", "clk_", kVar.aRa());
        } else if (id == d.g.god_reply_voice_btn) {
            am amVar = new am("c10760");
            amVar.T("obj_locate", 4);
            TiebaStatic.log(amVar);
        } else if (id == d.g.god_reply_content) {
            am amVar2 = new am("c10760");
            amVar2.T("obj_locate", 2);
            TiebaStatic.log(amVar2);
        } else if (id == d.g.god_reply_user_pendant_header || id == d.g.god_reply_username_text) {
            am amVar3 = new am("c10760");
            amVar3.T("obj_locate", 1);
            TiebaStatic.log(amVar3);
        } else if (view instanceof TbImageView) {
            if (view.getTag(d.g.god_reply_image_layout) instanceof Integer) {
                am amVar4 = new am("c10760");
                amVar4.T("obj_locate", 3);
                TiebaStatic.log(amVar4);
            }
            TiebaStatic.log(kVar.aRc());
            com.baidu.tieba.a.d.awh().a("page_recommend", "clk_", kVar.aRc());
            com.baidu.tieba.q.c.cdp().b(this.cnZ, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 3, kVar.aQN(), false, null, null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cnZ);
        dVar.bu(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.a.k.4
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == d.g.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == d.g.user_avatar) {
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
        oVar.setConstrainLayoutPool(this.fdJ);
        oVar.setConstrainImagePool(this.fdK);
        oVar.setFromCDN(this.ZQ);
        aVar.b(oVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.ZQ);
        hVar.setForm("index");
        aVar.a((com.baidu.card.f) hVar);
        if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
            oVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.personalize.a.k.5
                @Override // com.baidu.adp.widget.a.b
                public void k(int i, int i2, int i3) {
                    k.this.setPreloadSize(i, i2, i3);
                    if (k.this.isPreloadSizeReady(1) && k.this.isPreloadSizeReady(2)) {
                        oVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bxm = 1;
        dVar2.bxr = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bz(2);
        aVar.a(aaVar);
        aVar.rv().setBackgroundResource(d.f.addresslist_item_bg);
        x rw = aVar.rw();
        rw.bx(2);
        z zVar = new z(rw);
        zVar.setPageId(this.cnZ);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.k.6
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (k.this.Xr != null) {
                        k.this.Xr.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.rx().b(new a.C0039a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, z<com.baidu.tieba.card.data.k> zVar) {
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.threadData == null) {
            return null;
        }
        kVar.oo(kVar.position + 1);
        zVar.rx().setPage(this.YA);
        zVar.ry().a(this.cIV);
        zVar.a(kVar);
        zVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.rx().a(this.Xr);
        com.baidu.tieba.card.t.aQD().b(kVar.aQY());
        com.baidu.tieba.a.d.awh().a("page_recommend", "show_", kVar.aQY());
        com.baidu.tieba.q.c.cdp().a(this.cnZ, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aQN(), false, null, null));
        return zVar.getView();
    }

    private void bmI() {
        com.baidu.tieba.card.data.k.ekQ = "c10705";
        com.baidu.tieba.card.data.k.ekR = "c10730";
        com.baidu.tieba.card.data.k.ekS = "c10731";
        com.baidu.tieba.card.data.k.ekT = "c10704";
        com.baidu.tieba.card.data.k.ekU = "c10755";
        com.baidu.tieba.card.data.k.ekV = "c10710";
        com.baidu.tieba.card.data.k.ekW = "c10736";
        com.baidu.tieba.card.data.k.ekX = "c10737";
        com.baidu.tieba.card.data.k.ekY = "c10711";
        com.baidu.tieba.card.data.k.ekZ = "c10758";
        com.baidu.tieba.card.data.k.ela = "c10757";
    }

    public void setFromCDN(boolean z) {
        this.ZQ = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.fLD = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cIV = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YA = str;
    }
}
