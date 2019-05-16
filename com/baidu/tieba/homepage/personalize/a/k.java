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
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Vj;
    private String Wt;
    private boolean XJ;
    private NEGFeedBackView.a cRf;
    public BdUniqueId cwh;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> ftX;
    private com.baidu.adp.lib.e.b<TbImageView> ftY;
    private com.baidu.tieba.homepage.personalize.model.e gcL;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cRf = null;
        this.XJ = true;
        this.ftX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: blY */
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
        this.ftY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajX */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(k.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(R.color.common_color_10264));
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
        this.Vj = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aXM().gM(true);
                com.baidu.tieba.a.d.aBn().bJ("page_recommend", "show_");
                if (view != null && k.this.gcL != null && kVar != null && kVar.abv() != null && !StringUtils.isNull(kVar.abv().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dj(com.baidu.adp.lib.g.b.c(kVar.abv().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.di(com.baidu.adp.lib.g.b.c(kVar.abv().getTid(), 0L));
                        k.this.gcL.a(com.baidu.adp.lib.g.b.c(kVar.abv().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aXW(), kVar.aXX(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    k.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        buk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(kVar.aYi());
            com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYi());
            com.baidu.tieba.q.c.clt().b(this.cwh, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aXW(), false, (String) null, (String) null));
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.aYi());
            com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYi());
            com.baidu.tieba.q.c.clt().b(this.cwh, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 5, kVar.aXW(), false, (String) null, (String) null));
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.aYm());
            com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYm());
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.aYk());
            com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYk());
            com.baidu.tieba.q.c.clt().b(this.cwh, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aXW(), false, (String) null, (String) null));
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.aYk());
            com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYk());
            com.baidu.tieba.q.c.clt().b(this.cwh, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aXW(), false, (String) null, (String) null));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.aYj());
            com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYj());
        } else if (id == R.id.god_reply_voice_btn) {
            am amVar = new am("c10760");
            amVar.P("obj_locate", 4);
            TiebaStatic.log(amVar);
        } else if (id == R.id.god_reply_content) {
            am amVar2 = new am("c10760");
            amVar2.P("obj_locate", 2);
            TiebaStatic.log(amVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            am amVar3 = new am("c10760");
            amVar3.P("obj_locate", 1);
            TiebaStatic.log(amVar3);
        } else if (view instanceof TbImageView) {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                am amVar4 = new am("c10760");
                amVar4.P("obj_locate", 3);
                TiebaStatic.log(amVar4);
            }
            TiebaStatic.log(kVar.aYl());
            com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYl());
            com.baidu.tieba.q.c.clt().b(this.cwh, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 3, kVar.aXW(), false, (String) null, (String) null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cwh);
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
        oVar.setConstrainLayoutPool(this.ftX);
        oVar.setConstrainImagePool(this.ftY);
        oVar.setFromCDN(this.XJ);
        aVar.b(oVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.XJ);
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
        dVar2.bEy = 1;
        dVar2.bED = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bw(2);
        aVar.a(aaVar);
        aVar.qq().setBackgroundResource(R.drawable.addresslist_item_bg);
        x qr = aVar.qr();
        qr.bq(2);
        z zVar = new z(qr);
        zVar.setPageId(this.cwh);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.k.6
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (k.this.Vj != null) {
                        k.this.Vj.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.qs().b(new a.C0038a(1));
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
        kVar.ps(kVar.position + 1);
        zVar.qs().setPage(this.Wt);
        zVar.qt().a(this.cRf);
        zVar.a(kVar);
        zVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qs().a(this.Vj);
        com.baidu.tieba.card.t.aXM().b(kVar.aYh());
        com.baidu.tieba.a.d.aBn().a("page_recommend", "show_", kVar.aYh());
        com.baidu.tieba.q.c.clt().a(this.cwh, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aXW(), false, null, null));
        return zVar.getView();
    }

    private void buk() {
        com.baidu.tieba.card.data.k.eAF = "c10705";
        com.baidu.tieba.card.data.k.eAG = "c10730";
        com.baidu.tieba.card.data.k.eAH = "c10731";
        com.baidu.tieba.card.data.k.eAI = "c10704";
        com.baidu.tieba.card.data.k.eAJ = "c10755";
        com.baidu.tieba.card.data.k.eAK = "c10710";
        com.baidu.tieba.card.data.k.eAL = "c10736";
        com.baidu.tieba.card.data.k.eAM = "c10737";
        com.baidu.tieba.card.data.k.eAN = "c10711";
        com.baidu.tieba.card.data.k.eAO = "c10758";
        com.baidu.tieba.card.data.k.eAP = "c10757";
    }

    public void setFromCDN(boolean z) {
        this.XJ = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gcL = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cRf = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }
}
