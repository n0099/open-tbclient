package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class q extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adX;
    private String afG;
    private boolean aik;
    private NEGFeedBackView.a eTW;
    public BdUniqueId eyE;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hFi;
    private com.baidu.adp.lib.d.b<TbImageView> hFj;
    private com.baidu.tieba.homepage.personalize.model.e iti;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eTW = null;
        this.aik = true;
        this.hFi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.personalize.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: caz */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(q.this.mPageContext.getPageActivity());
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
        this.hFj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.q.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aYG */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(q.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(an.getColor(R.color.common_color_10264));
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
        this.adX = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.q.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.bOB().jI(true);
                com.baidu.tieba.a.d.boB().dh("page_recommend", "show_");
                if (view != null && q.this.iti != null && kVar != null && kVar.aPS() != null && !StringUtils.isNull(kVar.aPS().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.eq(com.baidu.adp.lib.f.b.toLong(kVar.aPS().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.ep(com.baidu.adp.lib.f.b.toLong(kVar.aPS().getTid(), 0L));
                        q.this.iti.a(com.baidu.adp.lib.f.b.toLong(kVar.aPS().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.bOM(), kVar.bON(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.aPS().getBaijiahaoData());
                    }
                    q.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cjQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 1;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(kVar.bOZ());
            com.baidu.tieba.a.d.boB().a("page_recommend", "clk_", kVar.bOZ());
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.bOZ());
            com.baidu.tieba.a.d.boB().a("page_recommend", "clk_", kVar.bOZ());
            i = 5;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.bPd());
            com.baidu.tieba.a.d.boB().a("page_recommend", "clk_", kVar.bPd());
            i = 0;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.bPb());
            com.baidu.tieba.a.d.boB().a("page_recommend", "clk_", kVar.bPb());
            i = 2;
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.bPb());
            com.baidu.tieba.a.d.boB().a("page_recommend", "clk_", kVar.bPb());
            i = 2;
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.bPa());
            com.baidu.tieba.a.d.boB().a("page_recommend", "clk_", kVar.bPa());
            i = 0;
        } else if (id == R.id.god_reply_voice_btn) {
            ao aoVar = new ao("c10760");
            aoVar.ag("obj_locate", 4);
            TiebaStatic.log(aoVar);
            i = 0;
        } else if (id == R.id.god_reply_content) {
            ao aoVar2 = new ao("c10760");
            aoVar2.ag("obj_locate", 2);
            TiebaStatic.log(aoVar2);
            i = 0;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            ao aoVar3 = new ao("c10760");
            aoVar3.ag("obj_locate", 1);
            TiebaStatic.log(aoVar3);
            i = 0;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                ao aoVar4 = new ao("c10760");
                aoVar4.ag("obj_locate", 3);
                TiebaStatic.log(aoVar4);
            }
            TiebaStatic.log(kVar.bPc());
            com.baidu.tieba.a.d.boB().a("page_recommend", "clk_", kVar.bPc());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLi, this.eyE, kVar.bOM(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eyE);
        eVar.be(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.q.4
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
        final com.baidu.card.u uVar = new com.baidu.card.u(this.mPageContext.getPageActivity());
        uVar.setFrom("index");
        uVar.setConstrainLayoutPool(this.hFi);
        uVar.setConstrainImagePool(this.hFj);
        uVar.setFromCDN(this.aik);
        aVar.c(uVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.q(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.ae(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.y(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aik);
        lVar.setForm("index");
        aVar.a((com.baidu.card.h) lVar);
        if (!aA(1) || !aA(2)) {
            uVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.personalize.a.q.5
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    q.this.h(i, i2, i3);
                    if (q.this.aA(1) && q.this.aA(2)) {
                        uVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 1;
        cVar.dHw = 1;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(1);
        alVar.setShareReportFrom(3);
        alVar.setFromForPb(2);
        aVar.b(alVar);
        ai sd = aVar.sd();
        sd.setSourceForPb(2);
        ak akVar = new ak(sd);
        akVar.setPageId(this.eyE);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.q.6
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (q.this.adX != null) {
                        q.this.adX.a(akVar2.getView(), kVar);
                    }
                    aw.a((AbsThreadDataSupport) kVar, view.getContext(), 2, false);
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ak<com.baidu.tieba.card.data.k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLi == null) {
            return null;
        }
        kVar.sR(kVar.position + 1);
        akVar.se().setPage(this.afG);
        akVar.aI(true).a(this.eTW);
        akVar.a(kVar.aQc(), this.ilu);
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.adX);
        com.baidu.tieba.card.s.bOB().e(kVar.bOY());
        com.baidu.tieba.a.d.boB().a("page_recommend", "show_", kVar.bOY());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLi, this.eyE, kVar.bOM());
        return akVar.getView();
    }

    private void cjQ() {
        com.baidu.tieba.card.data.k.gUm = "c10705";
        com.baidu.tieba.card.data.k.gUn = "c10730";
        com.baidu.tieba.card.data.k.gUo = "c10731";
        com.baidu.tieba.card.data.k.gUp = "c10704";
        com.baidu.tieba.card.data.k.gUq = "c10755";
        com.baidu.tieba.card.data.k.gUr = "c10710";
        com.baidu.tieba.card.data.k.gUs = "c10736";
        com.baidu.tieba.card.data.k.gUt = "c10737";
        com.baidu.tieba.card.data.k.gUu = "c10711";
        com.baidu.tieba.card.data.k.gUv = "c10758";
        com.baidu.tieba.card.data.k.gUw = "c10757";
    }

    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iti = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eTW = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }
}
