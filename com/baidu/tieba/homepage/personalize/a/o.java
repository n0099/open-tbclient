package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class o extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> JZ;
    private String LC;
    private boolean NK;
    public BdUniqueId dBK;
    private NEGFeedBackView.a dUT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dUT = null;
        this.NK = true;
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 1;
                com.baidu.tieba.card.r.bvm().id(true);
                com.baidu.tieba.a.d.aXK().cu("page_recommend", "show_");
                if (kVar != null && kVar.aAj() != null && !aq.isEmpty(kVar.aAj().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        TiebaStatic.log(kVar.bvI());
                        com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvI());
                    } else if (id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.bvI());
                        com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvI());
                        i = 5;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.bvM());
                        com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvM());
                        i = 0;
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.bvK());
                        com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvK());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.bvK());
                        com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvK());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.bvJ());
                        com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvJ());
                        i = 0;
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar = new an("c10760");
                        anVar.X("obj_locate", 4);
                        TiebaStatic.log(anVar);
                        i = 0;
                    } else if (id == R.id.god_reply_content) {
                        an anVar2 = new an("c10760");
                        anVar2.X("obj_locate", 2);
                        TiebaStatic.log(anVar2);
                        i = 0;
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                an anVar3 = new an("c10760");
                                anVar3.X("obj_locate", 3);
                                TiebaStatic.log(anVar3);
                            }
                            TiebaStatic.log(kVar.bvL());
                            com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvL());
                        }
                        i = 0;
                    } else {
                        an anVar4 = new an("c10760");
                        anVar4.X("obj_locate", 1);
                        TiebaStatic.log(anVar4);
                        i = 0;
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cRt, o.this.dBK, kVar.bvw(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        bPl();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public af<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dBK);
        eVar.aL(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.o.2
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
        aVar.c(new com.baidu.card.p(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.NK);
        kVar.setForm("index");
        kVar.a(new an("c13342"));
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNP = 1;
        dVar.cNV = 1;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(1);
        agVar.setShareReportFrom(3);
        agVar.aZ(2);
        aVar.b(agVar);
        com.baidu.card.ad nj = aVar.nj();
        nj.aQ(2);
        af<com.baidu.tieba.card.data.k> afVar = new af<>(nj);
        afVar.setPageId(this.dBK);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.o.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar2 = (com.baidu.tieba.card.data.k) mVar;
                    kVar2.objType = 1;
                    if (o.this.JZ != null) {
                        o.this.JZ.a(afVar2.getView(), kVar2);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar2, view.getContext(), 2, false);
                    afVar2.nk().b(new a.C0052a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.nk() == null) {
            return null;
        }
        kVar.rv(kVar.position + 1);
        com.baidu.tieba.card.r.bvm().e(kVar.Ab("c12190"));
        if (afVar.nk() instanceof com.baidu.tieba.a.e) {
            afVar.nk().setPage(this.LC);
        }
        com.baidu.card.w ag = afVar.ag(true);
        ag.a(this.dUT);
        ag.A(kVar.aAl());
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.b(this.JZ);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cRt, this.dBK, kVar.bvw());
        return afVar.getView();
    }

    private void bPl() {
        com.baidu.tieba.card.data.k.fNz = "c10705";
        com.baidu.tieba.card.data.k.fNA = "c10730";
        com.baidu.tieba.card.data.k.fNB = "c10731";
        com.baidu.tieba.card.data.k.fNC = "c10704";
        com.baidu.tieba.card.data.k.fND = "c10755";
        com.baidu.tieba.card.data.k.fNE = "c10710";
        com.baidu.tieba.card.data.k.fNF = "c10736";
        com.baidu.tieba.card.data.k.fNG = "c10737";
        com.baidu.tieba.card.data.k.fNH = "c10711";
        com.baidu.tieba.card.data.k.fNI = "c10758";
        com.baidu.tieba.card.data.k.fNJ = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUT = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }

    public void setFromCDN(boolean z) {
        this.NK = z;
    }
}
