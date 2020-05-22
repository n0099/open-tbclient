package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ag<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adt;
    private String aeX;
    private boolean aha;
    private com.baidu.adp.widget.ListView.t aib;
    public BdUniqueId epM;
    private com.baidu.tieba.homepage.personalize.model.e idp;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aha = true;
        this.adt = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.bLq().jv(true);
                com.baidu.tieba.a.d.blZ().de("page_recommend", "show_");
                if (view != null && i.this.idp != null && kVar != null && kVar.aOi() != null && !StringUtils.isNull(kVar.aOi().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.en(com.baidu.adp.lib.f.b.toLong(kVar.aOi().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.em(com.baidu.adp.lib.f.b.toLong(kVar.aOi().getTid(), 0L));
                        i.this.idp.a(com.baidu.adp.lib.f.b.toLong(kVar.aOi().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.bLz(), kVar.bLA(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.aOi().getBaijiahaoData());
                    }
                    i.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cgg();
    }

    public void a(com.baidu.adp.widget.ListView.t tVar) {
        this.aib = tVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.bLM());
            com.baidu.tieba.a.d.blZ().a("page_recommend", "clk_", kVar.bLM());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.bLO());
            com.baidu.tieba.a.d.blZ().a("page_recommend", "clk_", kVar.bLO());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.bLO());
            com.baidu.tieba.a.d.blZ().a("page_recommend", "clk_", kVar.bLO());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.bLN());
            com.baidu.tieba.a.d.blZ().a("page_recommend", "clk_", kVar.bLN());
            i = 9;
        } else if (id == R.id.god_reply_content) {
            an anVar = new an("c10760");
            anVar.ag("obj_locate", 2);
            TiebaStatic.log(anVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar2 = new an("c10760");
            anVar2.ag("obj_locate", 1);
            TiebaStatic.log(anVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                an anVar3 = new an("c10760");
                anVar3.ag("obj_locate", 3);
                TiebaStatic.log(anVar3);
            }
            TiebaStatic.log(kVar.bLP());
            com.baidu.tieba.a.d.blZ().a("page_recommend", "clk_", kVar.bLP());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.dEA, this.epM, kVar.bLz(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.v vVar = new com.baidu.card.v(this.mPageContext.getPageActivity());
        vVar.setFrom("index");
        vVar.setFromCDN(this.aha);
        aVar.c(vVar);
        ae a = aVar.a(false, viewGroup, this.aib);
        a.setSourceForPb(2);
        ag agVar = new ag(a);
        agVar.setPageId(this.epM);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ag)) {
                    ag agVar2 = (ag) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) oVar;
                    kVar.objType = 1;
                    if (i.this.adt != null) {
                        i.this.adt.a(agVar2.getView(), kVar);
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
        kVar.sr(kVar.position + 1);
        agVar.rM().setPosition(i);
        agVar.rM().setPage(this.aeX);
        agVar.b((ag<com.baidu.tieba.card.data.k>) kVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.adt);
        com.baidu.tieba.card.s.bLq().e(kVar.bLL());
        com.baidu.tieba.a.d.blZ().e(kVar.bLL());
        com.baidu.card.v vVar = (com.baidu.card.v) agVar.rM().rF();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) vVar.aep.ahI.getLayoutParams();
        layoutParams.width = kVar.dEB;
        layoutParams.height = kVar.dEC;
        if (vVar.aep.ahI.getVisibility() != 8) {
            vVar.aep.ahI.setLayoutParams(layoutParams);
        }
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

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.idp = eVar;
    }
}
