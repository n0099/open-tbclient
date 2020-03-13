package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> JZ;
    private String LC;
    private com.baidu.adp.widget.ListView.r OR;
    public BdUniqueId dBx;
    private NEGFeedBackView.a dUD;
    private com.baidu.tieba.homepage.personalize.model.e hdx;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.v$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        return a2(i, view, viewGroup, kVar, (af) afVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.bvh().ib(true);
                com.baidu.tieba.a.d.aXG().cv("page_recommend", "show_");
                if (view != null && q.this.hdx != null && kVar != null && kVar.aAg() != null && !StringUtils.isNull(kVar.aAg().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dD(com.baidu.adp.lib.f.b.toLong(kVar.aAg().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dC(com.baidu.adp.lib.f.b.toLong(kVar.aAg().getTid(), 0L));
                        q.this.hdx.a(com.baidu.adp.lib.f.b.toLong(kVar.aAg().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.bvr(), kVar.bvs(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.aAg().getBaijiahaoData());
                    }
                    q.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bOX();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.OR = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        an bvD;
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.l.aa(kVar.cRg)) {
                bvD = kVar.bvI();
                TiebaStatic.log(bvD);
            } else {
                bvD = kVar.bvD();
                TiebaStatic.log(bvD);
            }
            com.baidu.tieba.a.d.aXG().a("page_recommend", "clk_", bvD);
            i = 1;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.bvH());
            com.baidu.tieba.a.d.aXG().a("page_recommend", "clk_", kVar.bvH());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.bvF());
            com.baidu.tieba.a.d.aXG().a("page_recommend", "clk_", kVar.bvF());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.bvF());
            com.baidu.tieba.a.d.aXG().a("page_recommend", "clk_", kVar.bvF());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.bvE());
            com.baidu.tieba.a.d.aXG().a("page_recommend", "clk_", kVar.bvE());
            i = 9;
        } else if (id == R.id.god_reply_voice_btn) {
            an anVar = new an("c10760");
            anVar.X("obj_locate", 4);
            TiebaStatic.log(anVar);
            i = 5;
        } else if (id == R.id.god_reply_content) {
            an anVar2 = new an("c10760");
            anVar2.X("obj_locate", 2);
            TiebaStatic.log(anVar2);
            i = 5;
        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
            i = 0;
        } else {
            an anVar3 = new an("c10760");
            anVar3.X("obj_locate", 1);
            TiebaStatic.log(anVar3);
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.cRg, this.dBx, kVar.bvr(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNC = 1;
        dVar.cNI = 1;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(1);
        agVar.setStType("personalize_page");
        agVar.setShareReportFrom(3);
        agVar.aZ(2);
        agVar.aK(32);
        aVar.b(agVar);
        ad a = aVar.a(true, viewGroup, this.OR);
        a.aQ(2);
        af afVar = new af(a);
        afVar.setPageId(this.dBx);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.q.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (q.this.JZ != null) {
                        q.this.JZ.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar2.nk().b(new a.C0052a(1));
                }
            }
        });
        return afVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cRg == null) {
            return null;
        }
        kVar.rt(kVar.position + 1);
        afVar.nk().setPosition(i);
        afVar.nk().setPage(this.LC);
        if (afVar.nk().ne() instanceof ag) {
            ((ag) afVar.nk().ne()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.personalize.a.q.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup, view, i));
                    }
                }
            });
        }
        afVar.ag(false).a(this.dUD);
        afVar.b((af) kVar);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.JZ);
        com.baidu.tieba.card.r.bvh().d(kVar.bvC());
        com.baidu.tieba.a.d.aXG().d(kVar.bvC());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cRg, this.dBx, kVar.bvr());
        return afVar.getView();
    }

    private void bOX() {
        com.baidu.tieba.card.data.k.fMS = "c10730";
        com.baidu.tieba.card.data.k.fMT = "c10731";
        com.baidu.tieba.card.data.k.fMU = "c10704";
        com.baidu.tieba.card.data.k.fMV = "c10755";
        com.baidu.tieba.card.data.k.fMW = "c10710";
        com.baidu.tieba.card.data.k.fMX = "c10736";
        com.baidu.tieba.card.data.k.fMY = "c10737";
        com.baidu.tieba.card.data.k.fMZ = "c10711";
        com.baidu.tieba.card.data.k.fNa = "c10758";
        com.baidu.tieba.card.data.k.fNb = "c10757";
        com.baidu.tieba.card.data.k.fNe = "c10734";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hdx = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUD = aVar;
    }
}
