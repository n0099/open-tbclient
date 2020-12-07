package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class p extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> agG;
    private String aiw;
    private boolean alo;
    private NEGFeedBackView.a fWA;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fWA = null;
        this.alo = true;
        this.agG = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 1;
                com.baidu.tieba.card.t.csg().mj(true);
                com.baidu.tieba.a.d.bLT().dS("page_recommend", "show_");
                if (kVar != null && kVar.bmn() != null && !au.isEmpty(kVar.bmn().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        TiebaStatic.log(kVar.csz());
                        com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", kVar.csz());
                    } else if (id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.csz());
                        com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", kVar.csz());
                        i = 5;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.csJ());
                        com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", kVar.csJ());
                        i = 0;
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.csH());
                        com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", kVar.csH());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.csH());
                        com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", kVar.csH());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.csy());
                        com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", kVar.csy());
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
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                ar arVar3 = new ar("c10760");
                                arVar3.al("obj_locate", 3);
                                TiebaStatic.log(arVar3);
                            }
                            TiebaStatic.log(kVar.csI());
                            com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", kVar.csI());
                        }
                        i = 0;
                    } else {
                        ar arVar4 = new ar("c10760");
                        arVar4.al("obj_locate", 1);
                        TiebaStatic.log(arVar4);
                        i = 0;
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.eCR, p.this.fzO, kVar.css(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cNP();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<com.baidu.tieba.card.data.k> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fzO);
        eVar.bt(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.p.2
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
        aVar.c(new com.baidu.card.t(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.alo);
        nVar.setForm("index");
        nVar.a(new ar("c13342"));
        aVar.a((com.baidu.card.i) nVar);
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
        am<com.baidu.tieba.card.data.k> amVar = new am<>(tX);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.p.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (p.this.agG != null) {
                        p.this.agG.a(amVar2.getView(), kVar);
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
        if (kVar == null || amVar == null || amVar.tZ() == null) {
            return null;
        }
        kVar.ym(kVar.position + 1);
        com.baidu.tieba.card.t.csg().e(kVar.Jx("c12190"));
        if (amVar.tZ() instanceof com.baidu.tieba.a.e) {
            amVar.tZ().setPage(this.aiw);
        }
        com.baidu.card.ab aN = amVar.aN(true);
        aN.a(this.fWA);
        amVar.a(kVar.bmx(), this.jIG);
        aN.H(kVar.bmp());
        amVar.b((am<com.baidu.tieba.card.data.k>) kVar);
        amVar.b(this.agG);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.eCR, this.fzO, kVar.css());
        return amVar.getView();
    }

    private void cNP() {
        com.baidu.tieba.card.data.k.imU = "c10705";
        com.baidu.tieba.card.data.k.imV = "c10730";
        com.baidu.tieba.card.data.k.imW = "c10731";
        com.baidu.tieba.card.data.k.imX = "c10704";
        com.baidu.tieba.card.data.k.imY = "c10755";
        com.baidu.tieba.card.data.k.imZ = "c10710";
        com.baidu.tieba.card.data.k.ina = "c10736";
        com.baidu.tieba.card.data.k.inb = "c10737";
        com.baidu.tieba.card.data.k.inc = "c10711";
        com.baidu.tieba.card.data.k.ind = "c10758";
        com.baidu.tieba.card.data.k.ine = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fWA = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }
}
