package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ag;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class r extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> agG;
    private String aiw;
    private boolean alo;
    private NEGFeedBackView.a fWC;
    public BdUniqueId fzO;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iZr;
    private com.baidu.adp.lib.d.b<TbImageView> iZs;
    private com.baidu.tieba.homepage.personalize.model.e jSQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fWC = null;
        this.alo = true;
        this.iZr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cEP */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(r.this.mPageContext.getPageActivity());
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
        this.iZs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.r.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bvP */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(r.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ap.getColor(R.color.common_color_10264));
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
        this.agG = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.r.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.csh().mj(true);
                com.baidu.tieba.a.d.bLU().dS("page_recommend", "show_");
                if (view != null && r.this.jSQ != null && kVar != null && kVar.bmn() != null && !StringUtils.isNull(kVar.bmn().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gA(com.baidu.adp.lib.f.b.toLong(kVar.bmn().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gz(com.baidu.adp.lib.f.b.toLong(kVar.bmn().getTid(), 0L));
                        r.this.jSQ.a(com.baidu.adp.lib.f.b.toLong(kVar.bmn().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.cst(), kVar.csu(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.bmn().getBaijiahaoData());
                    }
                    r.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cNQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 1;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(kVar.csA());
            com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csA());
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.csA());
            com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csA());
            i = 5;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.csK());
            com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csK());
            i = 0;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.csI());
            com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csI());
            i = 2;
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.csI());
            com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csI());
            i = 2;
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.csz());
            com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csz());
            i = 0;
        } else if (id == R.id.god_reply_voice_btn) {
            ar arVar = new ar("c10760");
            arVar.al("obj_locate", 4);
            TiebaStatic.log(arVar);
            i = 0;
        } else if (id == R.id.god_reply_content) {
            ar arVar2 = new ar("c10760");
            arVar2.al("obj_locate", 2);
            TiebaStatic.log(arVar2);
            i = 0;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            ar arVar3 = new ar("c10760");
            arVar3.al("obj_locate", 1);
            TiebaStatic.log(arVar3);
            i = 0;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                ar arVar4 = new ar("c10760");
                arVar4.al("obj_locate", 3);
                TiebaStatic.log(arVar4);
            }
            TiebaStatic.log(kVar.csJ());
            com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csJ());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.eCR, this.fzO, kVar.cst(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fzO);
        eVar.bt(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.r.4
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
        final com.baidu.card.w wVar = new com.baidu.card.w(this.mPageContext.getPageActivity());
        wVar.setFrom("index");
        wVar.setConstrainLayoutPool(this.iZr);
        wVar.setConstrainImagePool(this.iZs);
        wVar.setFromCDN(this.alo);
        aVar.c(wVar);
        aVar.a((com.baidu.card.i) new com.baidu.card.s(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.alo);
        nVar.setForm("index");
        aVar.a((com.baidu.card.i) nVar);
        if (!aN(1) || !aN(2)) {
            wVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.personalize.a.r.5
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    r.this.h(i, i2, i3);
                    if (r.this.aN(1) && r.this.aN(2)) {
                        wVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 1;
        dVar.eEP = 1;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(1);
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(2);
        aVar.b(anVar);
        ak tX = aVar.tX();
        tX.setSourceForPb(2);
        am amVar = new am(tX);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.r.6
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (r.this.agG != null) {
                        r.this.agG.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, am<com.baidu.tieba.card.data.k> amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.eCR == null) {
            return null;
        }
        kVar.ym(kVar.position + 1);
        amVar.tZ().setPage(this.aiw);
        amVar.aN(true).a(this.fWC);
        amVar.a(kVar.bmx(), this.jII);
        amVar.b((am<com.baidu.tieba.card.data.k>) kVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        com.baidu.tieba.card.t.csh().e(kVar.csC());
        com.baidu.tieba.a.d.bLU().a("page_recommend", "show_", kVar.csC());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.eCR, this.fzO, kVar.cst());
        return amVar.getView();
    }

    private void cNQ() {
        com.baidu.tieba.card.data.k.imW = "c10705";
        com.baidu.tieba.card.data.k.imX = "c10730";
        com.baidu.tieba.card.data.k.imY = "c10731";
        com.baidu.tieba.card.data.k.imZ = "c10704";
        com.baidu.tieba.card.data.k.ina = "c10755";
        com.baidu.tieba.card.data.k.inb = "c10710";
        com.baidu.tieba.card.data.k.inc = "c10736";
        com.baidu.tieba.card.data.k.ind = "c10737";
        com.baidu.tieba.card.data.k.ine = "c10711";
        com.baidu.tieba.card.data.k.inf = "c10758";
        com.baidu.tieba.card.data.k.ing = "c10757";
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jSQ = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fWC = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }
}
