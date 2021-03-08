package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ag;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.d;
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
/* loaded from: classes2.dex */
public class n extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> ahy;
    private String ajx;
    private boolean amh;
    public BdUniqueId fIy;
    private NEGFeedBackView.a gfx;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> joC;
    private com.baidu.adp.lib.d.b<TbImageView> joD;
    private com.baidu.tieba.homepage.personalize.model.e klV;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gfx = null;
        this.amh = true;
        this.joC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.adapter.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFs */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(n.this.mPageContext.getPageActivity());
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
        this.joD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.adapter.n.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: buO */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(n.this.mPageContext.getPageActivity());
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
        this.ahy = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.adapter.n.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.csH().mG(true);
                com.baidu.tieba.a.d.bKY().dK("page_recommend", "show_");
                if (view != null && n.this.klV != null && kVar != null && kVar.blp() != null && !StringUtils.isNull(kVar.blp().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gF(com.baidu.adp.lib.f.b.toLong(kVar.blp().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gE(com.baidu.adp.lib.f.b.toLong(kVar.blp().getTid(), 0L));
                        n.this.klV.a(com.baidu.adp.lib.f.b.toLong(kVar.blp().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.csU(), kVar.csV(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.blp().getBaijiahaoData());
                    }
                    n.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cPp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 1;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(kVar.ctb());
            com.baidu.tieba.a.d.bKY().a("page_recommend", "clk_", kVar.ctb());
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.ctb());
            com.baidu.tieba.a.d.bKY().a("page_recommend", "clk_", kVar.ctb());
            i = 5;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.ctl());
            com.baidu.tieba.a.d.bKY().a("page_recommend", "clk_", kVar.ctl());
            i = 0;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.ctj());
            com.baidu.tieba.a.d.bKY().a("page_recommend", "clk_", kVar.ctj());
            i = 2;
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.ctj());
            com.baidu.tieba.a.d.bKY().a("page_recommend", "clk_", kVar.ctj());
            i = 2;
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.cta());
            com.baidu.tieba.a.d.bKY().a("page_recommend", "clk_", kVar.cta());
            i = 0;
        } else if (id == R.id.god_reply_voice_btn) {
            ar arVar = new ar("c10760");
            arVar.aq("obj_locate", 4);
            TiebaStatic.log(arVar);
            i = 0;
        } else if (id == R.id.god_reply_content) {
            ar arVar2 = new ar("c10760");
            arVar2.aq("obj_locate", 2);
            TiebaStatic.log(arVar2);
            i = 0;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            ar arVar3 = new ar("c10760");
            arVar3.aq("obj_locate", 1);
            TiebaStatic.log(arVar3);
            i = 0;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                ar arVar4 = new ar("c10760");
                arVar4.aq("obj_locate", 3);
                TiebaStatic.log(arVar4);
            }
            TiebaStatic.log(kVar.ctk());
            com.baidu.tieba.a.d.bKY().a("page_recommend", "clk_", kVar.ctk());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.a.a.a(kVar.eLr, this.fIy, kVar.csU(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fIy);
        dVar.bs(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.adapter.n.4
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
        aVar.a(dVar);
        final com.baidu.card.w wVar = new com.baidu.card.w(this.mPageContext.getPageActivity());
        wVar.setFrom("index");
        wVar.setConstrainLayoutPool(this.joC);
        wVar.setConstrainImagePool(this.joD);
        wVar.setFromCDN(this.amh);
        aVar.c(wVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.s(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.amh);
        nVar.setForm("index");
        aVar.a((com.baidu.card.h) nVar);
        if (!aO(1) || !aO(2)) {
            wVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.personalize.adapter.n.5
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    n.this.h(i, i2, i3);
                    if (n.this.aO(1) && n.this.aO(2)) {
                        wVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNB = 1;
        eVar.eNH = 1;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(1);
        amVar.setShareReportFrom(3);
        amVar.setFromForPb(2);
        aVar.b(amVar);
        ak th = aVar.th();
        th.setSourceForPb(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(th);
        threadCardViewHolder.setPageId(this.fIy);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.n.6
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar2;
                    kVar.objType = 1;
                    if (n.this.ahy != null) {
                        n.this.ahy.a(threadCardViewHolder2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    threadCardViewHolder2.tj().b(new a.C0095a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eLr == null) {
            return null;
        }
        kVar.xe(kVar.position + 1);
        threadCardViewHolder.tj().setPage(this.ajx);
        threadCardViewHolder.aK(true).a(this.gfx);
        threadCardViewHolder.a(kVar.blz(), this.kbf);
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.ahy);
        com.baidu.tieba.card.t.csH().e(kVar.ctd());
        com.baidu.tieba.a.d.bKY().a("page_recommend", "show_", kVar.ctd());
        com.baidu.tieba.homepage.personalize.a.a.a(kVar.eLr, this.fIy, kVar.csU());
        return threadCardViewHolder.getView();
    }

    private void cPp() {
        com.baidu.tieba.card.data.k.iCr = "c10705";
        com.baidu.tieba.card.data.k.iCs = "c10730";
        com.baidu.tieba.card.data.k.iCt = "c10731";
        com.baidu.tieba.card.data.k.iCu = "c10704";
        com.baidu.tieba.card.data.k.iCv = "c10755";
        com.baidu.tieba.card.data.k.iCw = "c10710";
        com.baidu.tieba.card.data.k.iCx = "c10736";
        com.baidu.tieba.card.data.k.iCy = "c10737";
        com.baidu.tieba.card.data.k.iCz = "c10711";
        com.baidu.tieba.card.data.k.iCA = "c10758";
        com.baidu.tieba.card.data.k.iCB = "c10757";
    }

    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.klV = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gfx = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }
}
