package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adN;
    private String afx;
    private com.baidu.adp.widget.ListView.v ajt;
    public BdUniqueId eEU;
    private com.baidu.tieba.homepage.personalize.model.e izo;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adN = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.bRL().km(true);
                com.baidu.tieba.a.d.brD().dk("page_recommend", "show_");
                if (view != null && k.this.izo != null && kVar != null && kVar.aTN() != null && !StringUtils.isNull(kVar.aTN().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.eD(com.baidu.adp.lib.f.b.toLong(kVar.aTN().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.eC(com.baidu.adp.lib.f.b.toLong(kVar.aTN().getTid(), 0L));
                        k.this.izo.a(com.baidu.adp.lib.f.b.toLong(kVar.aTN().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.bRX(), kVar.bRY(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.aTN().getBaijiahaoData());
                    }
                    k.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cnr();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajt = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        ap bSk;
        int id = view.getId();
        int i = 0;
        if (kVar != null) {
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                if (kVar.aUR()) {
                    bSk = kVar.bSp();
                } else {
                    bSk = kVar.bSk();
                }
                TiebaStatic.log(bSk);
                com.baidu.tieba.a.d.brD().a("page_recommend", "clk_", bSk);
                i = 1;
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(kVar.bSl());
                com.baidu.tieba.a.d.brD().a("page_recommend", "clk_", kVar.bSl());
                i = 9;
            }
            if (i != 0) {
                com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLK, this.eEU, kVar.bRX(), i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.j jVar = new com.baidu.card.j(this.mPageContext.getPageActivity());
        jVar.rT();
        aVar.a((com.baidu.card.h) jVar);
        ai a = aVar.a(false, viewGroup, this.ajt);
        a.setSourceForPb(2);
        ak akVar = new ak(a);
        akVar.setPageId(this.eEU);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.k.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (k.this.adN != null) {
                        k.this.adN.a(akVar2.getView(), kVar);
                    }
                    ax.a((AbsThreadDataSupport) kVar, view.getContext(), 2, false);
                    akVar2.sg().b(new a.C0096a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ak<com.baidu.tieba.card.data.k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLK == null) {
            return null;
        }
        kVar.tj(kVar.position + 1);
        akVar.sg().setPosition(i);
        akVar.sg().setPage(this.afx);
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.adN);
        com.baidu.tieba.card.s.bRL().e(kVar.bSj());
        com.baidu.tieba.a.d.brD().e(kVar.bSj());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLK, this.eEU, kVar.bRX());
        return akVar.getView();
    }

    private void cnr() {
        com.baidu.tieba.card.data.k.gZQ = "c10705";
        com.baidu.tieba.card.data.k.gZR = "c10730";
        com.baidu.tieba.card.data.k.gZS = "c10731";
        com.baidu.tieba.card.data.k.gZT = "c10704";
        com.baidu.tieba.card.data.k.gZU = "c10755";
        com.baidu.tieba.card.data.k.gZV = "c10710";
        com.baidu.tieba.card.data.k.gZW = "c10736";
        com.baidu.tieba.card.data.k.gZX = "c10737";
        com.baidu.tieba.card.data.k.gZY = "c10711";
        com.baidu.tieba.card.data.k.gZZ = "c10758";
        com.baidu.tieba.card.data.k.haa = "c10757";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.izo = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }
}
