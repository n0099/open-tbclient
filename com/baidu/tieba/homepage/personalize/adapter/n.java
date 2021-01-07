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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class n extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> ahf;
    private String aji;
    private boolean alQ;
    public BdUniqueId fJu;
    private NEGFeedBackView.a ggi;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jlE;
    private com.baidu.adp.lib.d.b<TbImageView> jlF;
    private com.baidu.tieba.homepage.personalize.model.e kgb;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ggi = null;
        this.alQ = true;
        this.jlE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.adapter.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cHL */
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
        this.jlF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.adapter.n.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: byl */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(n.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ao.getColor(R.color.common_color_10264));
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
        this.ahf = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.adapter.n.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.cvb().mG(true);
                com.baidu.tieba.a.d.bOn().dR("page_recommend", "show_");
                if (view != null && n.this.kgb != null && kVar != null && kVar.boP() != null && !StringUtils.isNull(kVar.boP().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gA(com.baidu.adp.lib.f.b.toLong(kVar.boP().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gz(com.baidu.adp.lib.f.b.toLong(kVar.boP().getTid(), 0L));
                        n.this.kgb.a(com.baidu.adp.lib.f.b.toLong(kVar.boP().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.cvn(), kVar.cvo(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.boP().getBaijiahaoData());
                    }
                    n.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cQX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 1;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(kVar.cvu());
            com.baidu.tieba.a.d.bOn().a("page_recommend", "clk_", kVar.cvu());
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.cvu());
            com.baidu.tieba.a.d.bOn().a("page_recommend", "clk_", kVar.cvu());
            i = 5;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.cvE());
            com.baidu.tieba.a.d.bOn().a("page_recommend", "clk_", kVar.cvE());
            i = 0;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.cvC());
            com.baidu.tieba.a.d.bOn().a("page_recommend", "clk_", kVar.cvC());
            i = 2;
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.cvC());
            com.baidu.tieba.a.d.bOn().a("page_recommend", "clk_", kVar.cvC());
            i = 2;
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.cvt());
            com.baidu.tieba.a.d.bOn().a("page_recommend", "clk_", kVar.cvt());
            i = 0;
        } else if (id == R.id.god_reply_voice_btn) {
            aq aqVar = new aq("c10760");
            aqVar.an("obj_locate", 4);
            TiebaStatic.log(aqVar);
            i = 0;
        } else if (id == R.id.god_reply_content) {
            aq aqVar2 = new aq("c10760");
            aqVar2.an("obj_locate", 2);
            TiebaStatic.log(aqVar2);
            i = 0;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            aq aqVar3 = new aq("c10760");
            aqVar3.an("obj_locate", 1);
            TiebaStatic.log(aqVar3);
            i = 0;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                aq aqVar4 = new aq("c10760");
                aqVar4.an("obj_locate", 3);
                TiebaStatic.log(aqVar4);
            }
            TiebaStatic.log(kVar.cvD());
            com.baidu.tieba.a.d.bOn().a("page_recommend", "clk_", kVar.cvD());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.a.a.a(kVar.eMv, this.fJu, kVar.cvn(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fJu);
        dVar.bt(1024);
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
        wVar.setConstrainLayoutPool(this.jlE);
        wVar.setConstrainImagePool(this.jlF);
        wVar.setFromCDN(this.alQ);
        aVar.c(wVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.s(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.alQ);
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
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.eOz = 1;
        dVar2.eOF = 1;
        amVar.setAgreeStatisticData(dVar2);
        amVar.setFrom(1);
        amVar.setShareReportFrom(3);
        amVar.setFromForPb(2);
        aVar.b(amVar);
        ak tw = aVar.tw();
        tw.setSourceForPb(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(tw);
        threadCardViewHolder.setPageId(this.fJu);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.n.6
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar2;
                    kVar.objType = 1;
                    if (n.this.ahf != null) {
                        n.this.ahf.a(threadCardViewHolder2.getView(), kVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eMv == null) {
            return null;
        }
        kVar.yA(kVar.position + 1);
        threadCardViewHolder.ty().setPage(this.aji);
        threadCardViewHolder.aK(true).a(this.ggi);
        threadCardViewHolder.a(kVar.boZ(), this.jVS);
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.ahf);
        com.baidu.tieba.card.s.cvb().e(kVar.cvw());
        com.baidu.tieba.a.d.bOn().a("page_recommend", "show_", kVar.cvw());
        com.baidu.tieba.homepage.personalize.a.a.a(kVar.eMv, this.fJu, kVar.cvn());
        return threadCardViewHolder.getView();
    }

    private void cQX() {
        com.baidu.tieba.card.data.k.izr = "c10705";
        com.baidu.tieba.card.data.k.izs = "c10730";
        com.baidu.tieba.card.data.k.izt = "c10731";
        com.baidu.tieba.card.data.k.izu = "c10704";
        com.baidu.tieba.card.data.k.izv = "c10755";
        com.baidu.tieba.card.data.k.izw = "c10710";
        com.baidu.tieba.card.data.k.izx = "c10736";
        com.baidu.tieba.card.data.k.izy = "c10737";
        com.baidu.tieba.card.data.k.izz = "c10711";
        com.baidu.tieba.card.data.k.izA = "c10758";
        com.baidu.tieba.card.data.k.izB = "c10757";
    }

    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kgb = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.ggi = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Fl(String str) {
        this.aji = str;
    }
}
