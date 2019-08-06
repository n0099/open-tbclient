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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> VC;
    private String WN;
    private boolean Yd;
    private NEGFeedBackView.a cSK;
    public BdUniqueId cxE;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fzt;
    private com.baidu.adp.lib.e.b<TbImageView> fzu;
    private com.baidu.tieba.homepage.personalize.model.e gjQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cSK = null;
        this.Yd = true;
        this.fzt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bom */
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
        this.fzu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ale */
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
        this.VC = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aZP().gS(true);
                com.baidu.tieba.a.d.aCH().bJ("page_recommend", "show_");
                if (view != null && k.this.gjQ != null && kVar != null && kVar.acy() != null && !StringUtils.isNull(kVar.acy().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dq(com.baidu.adp.lib.g.b.c(kVar.acy().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dp(com.baidu.adp.lib.g.b.c(kVar.acy().getTid(), 0L));
                        k.this.gjQ.a(com.baidu.adp.lib.g.b.c(kVar.acy().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aZZ(), kVar.baa(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    k.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bxg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(kVar.bam());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.bam());
            com.baidu.tieba.q.c.coG().b(this.cxE, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aZZ(), false, (String) null, (String) null));
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.bam());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.bam());
            com.baidu.tieba.q.c.coG().b(this.cxE, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 5, kVar.aZZ(), false, (String) null, (String) null));
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.baq());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.baq());
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.bao());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.bao());
            com.baidu.tieba.q.c.coG().b(this.cxE, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aZZ(), false, (String) null, (String) null));
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.bao());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.bao());
            com.baidu.tieba.q.c.coG().b(this.cxE, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aZZ(), false, (String) null, (String) null));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.ban());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.ban());
        } else if (id == R.id.god_reply_voice_btn) {
            an anVar = new an("c10760");
            anVar.P("obj_locate", 4);
            TiebaStatic.log(anVar);
        } else if (id == R.id.god_reply_content) {
            an anVar2 = new an("c10760");
            anVar2.P("obj_locate", 2);
            TiebaStatic.log(anVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar3 = new an("c10760");
            anVar3.P("obj_locate", 1);
            TiebaStatic.log(anVar3);
        } else if (view instanceof TbImageView) {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                an anVar4 = new an("c10760");
                anVar4.P("obj_locate", 3);
                TiebaStatic.log(anVar4);
            }
            TiebaStatic.log(kVar.bap());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.bap());
            com.baidu.tieba.q.c.coG().b(this.cxE, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 3, kVar.aZZ(), false, (String) null, (String) null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cxE);
        dVar.bn(1024);
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
        oVar.setConstrainLayoutPool(this.fzt);
        oVar.setConstrainImagePool(this.fzu);
        oVar.setFromCDN(this.Yd);
        aVar.b(oVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.Yd);
        hVar.setForm("index");
        aVar.a((com.baidu.card.f) hVar);
        if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
            oVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.personalize.a.k.5
                @Override // com.baidu.adp.widget.a.b
                public void j(int i, int i2, int i3) {
                    k.this.setPreloadSize(i, i2, i3);
                    if (k.this.isPreloadSizeReady(1) && k.this.isPreloadSizeReady(2)) {
                        oVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bFA = 1;
        dVar2.bFF = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bw(2);
        aVar.a(aaVar);
        aVar.qN().setBackgroundResource(R.drawable.addresslist_item_bg);
        x qO = aVar.qO();
        qO.bq(2);
        z zVar = new z(qO);
        zVar.setPageId(this.cxE);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.k.6
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (k.this.VC != null) {
                        k.this.VC.a(zVar2.getView(), kVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.qP().b(new a.C0038a(1));
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
        kVar.pJ(kVar.position + 1);
        zVar.qP().setPage(this.WN);
        zVar.qQ().a(this.cSK);
        zVar.a(kVar);
        zVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qP().a(this.VC);
        com.baidu.tieba.card.t.aZP().c(kVar.bal());
        com.baidu.tieba.a.d.aCH().a("page_recommend", "show_", kVar.bal());
        com.baidu.tieba.q.c.coG().a(this.cxE, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aZZ(), false, null, null));
        return zVar.getView();
    }

    private void bxg() {
        com.baidu.tieba.card.data.k.eFJ = "c10705";
        com.baidu.tieba.card.data.k.eFK = "c10730";
        com.baidu.tieba.card.data.k.eFL = "c10731";
        com.baidu.tieba.card.data.k.eFM = "c10704";
        com.baidu.tieba.card.data.k.eFN = "c10755";
        com.baidu.tieba.card.data.k.eFO = "c10710";
        com.baidu.tieba.card.data.k.eFP = "c10736";
        com.baidu.tieba.card.data.k.eFQ = "c10737";
        com.baidu.tieba.card.data.k.eFR = "c10711";
        com.baidu.tieba.card.data.k.eFS = "c10758";
        com.baidu.tieba.card.data.k.eFT = "c10757";
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gjQ = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cSK = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }
}
