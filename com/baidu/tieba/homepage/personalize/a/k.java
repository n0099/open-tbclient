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
    private ab<com.baidu.tieba.card.data.k> Xq;
    private String Yz;
    private boolean ZO;
    private NEGFeedBackView.a cIW;
    public BdUniqueId cnX;
    private com.baidu.tieba.homepage.personalize.model.e fLQ;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdX;
    private com.baidu.adp.lib.e.b<TbImageView> fdY;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cIW = null;
        this.ZO = true;
        this.fdX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beJ */
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
        this.fdY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: afb */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(k.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0236d.common_color_10264));
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
        this.Xq = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aQG().go(true);
                com.baidu.tieba.a.d.awl().bA("page_recommend", "show_");
                if (view != null && k.this.fLQ != null && kVar != null && kVar.WR() != null && !StringUtils.isNull(kVar.WR().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cM(com.baidu.adp.lib.g.b.d(kVar.WR().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cL(com.baidu.adp.lib.g.b.d(kVar.WR().getTid(), 0L));
                        k.this.fLQ.a(com.baidu.adp.lib.g.b.d(kVar.WR().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aQQ(), kVar.aQR(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    k.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bmM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == d.g.thread_card_root) {
            TiebaStatic.log(kVar.aRc());
            com.baidu.tieba.a.d.awl().a("page_recommend", "clk_", kVar.aRc());
            com.baidu.tieba.q.c.cdr().b(this.cnX, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aQQ(), false, null, null));
        } else if (id == d.g.thread_info_commont_container) {
            TiebaStatic.log(kVar.aRc());
            com.baidu.tieba.a.d.awl().a("page_recommend", "clk_", kVar.aRc());
            com.baidu.tieba.q.c.cdr().b(this.cnX, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 5, kVar.aQQ(), false, null, null));
        } else if (id == d.g.thread_card_voice) {
            TiebaStatic.log(kVar.aRg());
            com.baidu.tieba.a.d.awl().a("page_recommend", "clk_", kVar.aRg());
        } else if (id == d.g.user_avatar) {
            TiebaStatic.log(kVar.aRe());
            com.baidu.tieba.a.d.awl().a("page_recommend", "clk_", kVar.aRe());
            com.baidu.tieba.q.c.cdr().b(this.cnX, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aQQ(), false, null, null));
        } else if (id == d.g.user_name) {
            TiebaStatic.log(kVar.aRe());
            com.baidu.tieba.a.d.awl().a("page_recommend", "clk_", kVar.aRe());
            com.baidu.tieba.q.c.cdr().b(this.cnX, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aQQ(), false, null, null));
        } else if (id == d.g.forum_name_text) {
            TiebaStatic.log(kVar.aRd());
            com.baidu.tieba.a.d.awl().a("page_recommend", "clk_", kVar.aRd());
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
            TiebaStatic.log(kVar.aRf());
            com.baidu.tieba.a.d.awl().a("page_recommend", "clk_", kVar.aRf());
            com.baidu.tieba.q.c.cdr().b(this.cnX, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 3, kVar.aQQ(), false, null, null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cnX);
        dVar.bv(1024);
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
        oVar.setConstrainLayoutPool(this.fdX);
        oVar.setConstrainImagePool(this.fdY);
        oVar.setFromCDN(this.ZO);
        aVar.b(oVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.ZO);
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
        dVar2.bxh = 1;
        dVar2.bxm = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bA(2);
        aVar.a(aaVar);
        aVar.rv().setBackgroundResource(d.f.addresslist_item_bg);
        x rw = aVar.rw();
        rw.by(2);
        z zVar = new z(rw);
        zVar.setPageId(this.cnX);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.k.6
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (k.this.Xq != null) {
                        k.this.Xq.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.rx().b(new a.C0037a(1));
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
        kVar.os(kVar.position + 1);
        zVar.rx().setPage(this.Yz);
        zVar.ry().a(this.cIW);
        zVar.a(kVar);
        zVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.rx().a(this.Xq);
        com.baidu.tieba.card.t.aQG().b(kVar.aRb());
        com.baidu.tieba.a.d.awl().a("page_recommend", "show_", kVar.aRb());
        com.baidu.tieba.q.c.cdr().a(this.cnX, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aQQ(), false, null, null));
        return zVar.getView();
    }

    private void bmM() {
        com.baidu.tieba.card.data.k.eli = "c10705";
        com.baidu.tieba.card.data.k.elj = "c10730";
        com.baidu.tieba.card.data.k.elk = "c10731";
        com.baidu.tieba.card.data.k.ell = "c10704";
        com.baidu.tieba.card.data.k.elm = "c10755";
        com.baidu.tieba.card.data.k.eln = "c10710";
        com.baidu.tieba.card.data.k.elo = "c10736";
        com.baidu.tieba.card.data.k.elp = "c10737";
        com.baidu.tieba.card.data.k.elq = "c10711";
        com.baidu.tieba.card.data.k.elr = "c10758";
        com.baidu.tieba.card.data.k.els = "c10757";
    }

    public void setFromCDN(boolean z) {
        this.ZO = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.fLQ = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cIW = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void qN(String str) {
        this.Yz = str;
    }
}
