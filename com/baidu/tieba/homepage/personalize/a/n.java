package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.ah;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class n extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, ag<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adt;
    private String aeX;
    private boolean aha;
    private NEGFeedBackView.a eJz;
    public BdUniqueId epM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eJz = null;
        this.aha = true;
        this.adt = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 1;
                com.baidu.tieba.card.s.bLq().jv(true);
                com.baidu.tieba.a.d.blZ().de("page_recommend", "show_");
                if (kVar != null && kVar.aOi() != null && !aq.isEmpty(kVar.aOi().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        TiebaStatic.log(kVar.bLM());
                        com.baidu.tieba.a.d.blZ().a("page_recommend", "clk_", kVar.bLM());
                    } else if (id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.bLM());
                        com.baidu.tieba.a.d.blZ().a("page_recommend", "clk_", kVar.bLM());
                        i = 5;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.bLQ());
                        com.baidu.tieba.a.d.blZ().a("page_recommend", "clk_", kVar.bLQ());
                        i = 0;
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.bLO());
                        com.baidu.tieba.a.d.blZ().a("page_recommend", "clk_", kVar.bLO());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.bLO());
                        com.baidu.tieba.a.d.blZ().a("page_recommend", "clk_", kVar.bLO());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.bLN());
                        com.baidu.tieba.a.d.blZ().a("page_recommend", "clk_", kVar.bLN());
                        i = 0;
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar = new an("c10760");
                        anVar.ag("obj_locate", 4);
                        TiebaStatic.log(anVar);
                        i = 0;
                    } else if (id == R.id.god_reply_content) {
                        an anVar2 = new an("c10760");
                        anVar2.ag("obj_locate", 2);
                        TiebaStatic.log(anVar2);
                        i = 0;
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                an anVar3 = new an("c10760");
                                anVar3.ag("obj_locate", 3);
                                TiebaStatic.log(anVar3);
                            }
                            TiebaStatic.log(kVar.bLP());
                            com.baidu.tieba.a.d.blZ().a("page_recommend", "clk_", kVar.bLP());
                        }
                        i = 0;
                    } else {
                        an anVar4 = new an("c10760");
                        anVar4.ag("obj_locate", 1);
                        TiebaStatic.log(anVar4);
                        i = 0;
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dEA, n.this.epM, kVar.bLz(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cgg();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.epM);
        eVar.aY(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.n.2
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
        aVar.c(new com.baidu.card.q(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aha);
        lVar.setForm("index");
        lVar.a(new an("c13342"));
        aVar.a((com.baidu.card.h) lVar);
        ah ahVar = new ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 1;
        cVar.dBf = 1;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(1);
        ahVar.setShareReportFrom(3);
        ahVar.bm(2);
        aVar.b(ahVar);
        ae rL = aVar.rL();
        rL.setSourceForPb(2);
        ag<com.baidu.tieba.card.data.k> agVar = new ag<>(rL);
        agVar.setPageId(this.epM);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.homepage.personalize.a.n.3
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ag)) {
                    ag agVar2 = (ag) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) oVar;
                    kVar.objType = 1;
                    if (n.this.adt != null) {
                        n.this.adt.a(agVar2.getView(), kVar);
                    }
                    au.a((AbsThreadDataSupport) kVar, view.getContext(), 2, false);
                    agVar2.rM().b(new a.C0097a(1));
                }
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ag<com.baidu.tieba.card.data.k> agVar) {
        if (kVar == null || agVar == null || agVar.rM() == null) {
            return null;
        }
        kVar.sr(kVar.position + 1);
        com.baidu.tieba.card.s.bLq().e(kVar.Du("c12190"));
        if (agVar.rM() instanceof com.baidu.tieba.a.e) {
            agVar.rM().setPage(this.aeX);
        }
        com.baidu.card.x aH = agVar.aH(true);
        aH.a(this.eJz);
        agVar.a(kVar.aOs(), this.hWm);
        aH.D(kVar.aOk());
        agVar.b((ag<com.baidu.tieba.card.data.k>) kVar);
        agVar.b(this.adt);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dEA, this.epM, kVar.bLz());
        return agVar.getView();
    }

    private void cgg() {
        com.baidu.tieba.card.data.k.gHb = "c10705";
        com.baidu.tieba.card.data.k.gHc = "c10730";
        com.baidu.tieba.card.data.k.gHd = "c10731";
        com.baidu.tieba.card.data.k.gHe = "c10704";
        com.baidu.tieba.card.data.k.gHf = "c10755";
        com.baidu.tieba.card.data.k.gHg = "c10710";
        com.baidu.tieba.card.data.k.gHh = "c10736";
        com.baidu.tieba.card.data.k.gHi = "c10737";
        com.baidu.tieba.card.data.k.gHj = "c10711";
        com.baidu.tieba.card.data.k.gHk = "c10758";
        com.baidu.tieba.card.data.k.gHl = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eJz = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    public void setFromCDN(boolean z) {
        this.aha = z;
    }
}
