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
/* loaded from: classes7.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> JE;
    private String Lg;
    private boolean Nj;
    private NEGFeedBackView.a dQj;
    public BdUniqueId dxg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQj = null;
        this.Nj = true;
        this.JE = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 1;
                com.baidu.tieba.card.r.btA().hU(true);
                com.baidu.tieba.a.d.aVo().cm("page_recommend", "show_");
                if (kVar != null && kVar.axQ() != null && !aq.isEmpty(kVar.axQ().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        TiebaStatic.log(kVar.btW());
                        com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btW());
                    } else if (id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.btW());
                        com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btW());
                        i = 5;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.bua());
                        com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.bua());
                        i = 0;
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.btY());
                        com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btY());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.btY());
                        com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btY());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.btX());
                        com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btX());
                        i = 0;
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar = new an("c10760");
                        anVar.Z("obj_locate", 4);
                        TiebaStatic.log(anVar);
                        i = 0;
                    } else if (id == R.id.god_reply_content) {
                        an anVar2 = new an("c10760");
                        anVar2.Z("obj_locate", 2);
                        TiebaStatic.log(anVar2);
                        i = 0;
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                an anVar3 = new an("c10760");
                                anVar3.Z("obj_locate", 3);
                                TiebaStatic.log(anVar3);
                            }
                            TiebaStatic.log(kVar.btZ());
                            com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btZ());
                        }
                        i = 0;
                    } else {
                        an anVar4 = new an("c10760");
                        anVar4.Z("obj_locate", 1);
                        TiebaStatic.log(anVar4);
                        i = 0;
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cNb, m.this.dxg, kVar.btK(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        bNs();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public af<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dxg);
        eVar.aI(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.m.2
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
        kVar.setFromCDN(this.Nj);
        kVar.setForm("index");
        kVar.a(new an("c13342"));
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 1;
        dVar.cJD = 1;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(1);
        agVar.setShareReportFrom(3);
        agVar.aV(2);
        aVar.b(agVar);
        ad mT = aVar.mT();
        mT.aM(2);
        af<com.baidu.tieba.card.data.k> afVar = new af<>(mT);
        afVar.setPageId(this.dxg);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.m.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar2 = (com.baidu.tieba.card.data.k) mVar;
                    kVar2.objType = 1;
                    if (m.this.JE != null) {
                        m.this.JE.a(afVar2.getView(), kVar2);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar2, view.getContext(), 2, false);
                    afVar2.mU().b(new a.C0050a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.mU() == null) {
            return null;
        }
        kVar.rm(kVar.position + 1);
        com.baidu.tieba.card.r.btA().c(kVar.zJ("c12190"));
        if (afVar.mU() instanceof com.baidu.tieba.a.e) {
            afVar.mU().setPage(this.Lg);
        }
        com.baidu.card.w ad = afVar.ad(true);
        ad.a(this.dQj);
        ad.A(kVar.axS());
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.b(this.JE);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cNb, this.dxg, kVar.btK());
        return afVar.getView();
    }

    private void bNs() {
        com.baidu.tieba.card.data.k.fKg = "c10705";
        com.baidu.tieba.card.data.k.fKh = "c10730";
        com.baidu.tieba.card.data.k.fKi = "c10731";
        com.baidu.tieba.card.data.k.fKj = "c10704";
        com.baidu.tieba.card.data.k.fKk = "c10755";
        com.baidu.tieba.card.data.k.fKl = "c10710";
        com.baidu.tieba.card.data.k.fKm = "c10736";
        com.baidu.tieba.card.data.k.fKn = "c10737";
        com.baidu.tieba.card.data.k.fKo = "c10711";
        com.baidu.tieba.card.data.k.fKp = "c10758";
        com.baidu.tieba.card.data.k.fKq = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dQj = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    public void setFromCDN(boolean z) {
        this.Nj = z;
    }
}
