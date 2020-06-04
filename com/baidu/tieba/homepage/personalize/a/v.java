package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.ah;
import com.baidu.card.aj;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class v extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, ag<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adt;
    private String aeX;
    private boolean aha;
    private NEGFeedBackView.a eJK;
    public BdUniqueId epM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eJK = null;
        this.aha = true;
        this.adt = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.bLs().jv(true);
                com.baidu.tieba.a.d.bmb().de("page_recommend", "show_");
                if (view != null && kVar != null && kVar.aOi() != null && !StringUtils.isNull(kVar.aOi().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.Dw("c12642"));
                        com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", kVar.bLO());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.bLS());
                        com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", kVar.bLS());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.bLQ());
                        com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", kVar.bLQ());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.bLQ());
                        com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", kVar.bLQ());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.bLP());
                        com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", kVar.bLP());
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar = new an("c10760");
                        anVar.ag("obj_locate", 4);
                        TiebaStatic.log(anVar);
                    } else if (id == R.id.god_reply_content) {
                        an anVar2 = new an("c10760");
                        anVar2.ag("obj_locate", 2);
                        TiebaStatic.log(anVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        an anVar3 = new an("c10760");
                        anVar3.ag("obj_locate", 1);
                        TiebaStatic.log(anVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            an anVar4 = new an("c10760");
                            anVar4.ag("obj_locate", 3);
                            TiebaStatic.log(anVar4);
                        }
                        TiebaStatic.log(kVar.bLR());
                        com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", kVar.bLR());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dEA, v.this.epM, kVar.bLB(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cgp();
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
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.v.2
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
        aj ajVar = new aj(this.mPageContext.getPageActivity());
        aVar.c(ajVar);
        ajVar.bn(2);
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aha);
        lVar.setForm("index");
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
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.homepage.personalize.a.v.3
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ag)) {
                    ag agVar2 = (ag) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) oVar;
                    kVar.objType = 1;
                    if (v.this.adt != null) {
                        v.this.adt.a(agVar2.getView(), kVar);
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
        if (kVar == null || agVar == null || agVar.getView() == null || kVar.dEA == null) {
            return null;
        }
        kVar.st(kVar.position + 1);
        com.baidu.tieba.card.s.bLs().e(kVar.Dv("c12641"));
        com.baidu.tieba.a.d.bmb().a("page_recommend", "show_", kVar.bLN());
        agVar.rM().setPage(this.aeX);
        agVar.aH(true).a(this.eJK);
        agVar.a(kVar.aOs(), this.hWZ);
        agVar.b((ag<com.baidu.tieba.card.data.k>) kVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.adt);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dEA, this.epM, kVar.bLB());
        return agVar.getView();
    }

    private void cgp() {
        com.baidu.tieba.card.data.k.gHm = "c10705";
        com.baidu.tieba.card.data.k.gHn = "c10730";
        com.baidu.tieba.card.data.k.gHo = "c10731";
        com.baidu.tieba.card.data.k.gHp = "c10704";
        com.baidu.tieba.card.data.k.gHq = "c10755";
        com.baidu.tieba.card.data.k.gHr = "c10710";
        com.baidu.tieba.card.data.k.gHs = "c10736";
        com.baidu.tieba.card.data.k.gHt = "c10737";
        com.baidu.tieba.card.data.k.gHu = "c10711";
        com.baidu.tieba.card.data.k.gHv = "c10758";
        com.baidu.tieba.card.data.k.gHw = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eJK = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    public void setFromCDN(boolean z) {
        this.aha = z;
    }
}
