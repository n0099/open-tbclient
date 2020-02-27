package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> JZ;
    private String LC;
    private com.baidu.adp.widget.ListView.r OR;
    public BdUniqueId dBj;
    private com.baidu.tieba.homepage.personalize.model.e hdj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.bve().ib(true);
                com.baidu.tieba.a.d.aXD().cv("page_recommend", "show_");
                if (view != null && i.this.hdj != null && kVar != null && kVar.aAe() != null && !StringUtils.isNull(kVar.aAe().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dD(com.baidu.adp.lib.f.b.toLong(kVar.aAe().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dC(com.baidu.adp.lib.f.b.toLong(kVar.aAe().getTid(), 0L));
                        i.this.hdj.a(com.baidu.adp.lib.f.b.toLong(kVar.aAe().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.bvo(), kVar.bvp(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.aAe().getBaijiahaoData());
                    }
                    i.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bOU();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.OR = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        an bvA;
        int id = view.getId();
        int i = 0;
        if (kVar != null) {
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                if (kVar.aAZ()) {
                    bvA = kVar.bvF();
                } else {
                    bvA = kVar.bvA();
                }
                TiebaStatic.log(bvA);
                com.baidu.tieba.a.d.aXD().a("page_recommend", "clk_", bvA);
                i = 1;
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(kVar.bvB());
                com.baidu.tieba.a.d.aXD().a("page_recommend", "clk_", kVar.bvB());
                i = 9;
            }
            if (i != 0) {
                com.baidu.tieba.homepage.personalize.c.a.a(kVar.cRe, this.dBj, kVar.bvo(), i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        ad a = aVar.a(false, viewGroup, this.OR);
        a.aQ(2);
        af afVar = new af(a);
        afVar.setPageId(this.dBj);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (i.this.JZ != null) {
                        i.this.JZ.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
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
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cRe == null) {
            return null;
        }
        kVar.rt(kVar.position + 1);
        afVar.nk().setPosition(i);
        afVar.nk().setPage(this.LC);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.JZ);
        com.baidu.tieba.card.r.bve().d(kVar.bvz());
        com.baidu.tieba.a.d.aXD().d(kVar.bvz());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cRe, this.dBj, kVar.bvo());
        return afVar.getView();
    }

    private void bOU() {
        com.baidu.tieba.card.data.k.fMC = "c10705";
        com.baidu.tieba.card.data.k.fMD = "c10730";
        com.baidu.tieba.card.data.k.fME = "c10731";
        com.baidu.tieba.card.data.k.fMF = "c10704";
        com.baidu.tieba.card.data.k.fMG = "c10755";
        com.baidu.tieba.card.data.k.fMH = "c10710";
        com.baidu.tieba.card.data.k.fMI = "c10736";
        com.baidu.tieba.card.data.k.fMJ = "c10737";
        com.baidu.tieba.card.data.k.fMK = "c10711";
        com.baidu.tieba.card.data.k.fML = "c10758";
        com.baidu.tieba.card.data.k.fMM = "c10757";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hdj = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }
}
