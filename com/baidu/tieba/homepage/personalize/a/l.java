package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l> afF;
    private String ahu;
    private com.baidu.adp.widget.ListView.v alD;
    public BdUniqueId fsQ;
    private com.baidu.tieba.homepage.personalize.model.e jEn;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afF = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.cor().lN(true);
                com.baidu.tieba.a.d.bIR().dM("page_recommend", "show_");
                if (view != null && l.this.jEn != null && lVar != null && lVar.bjZ() != null && !StringUtils.isNull(lVar.bjZ().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fS(com.baidu.adp.lib.f.b.toLong(lVar.bjZ().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fR(com.baidu.adp.lib.f.b.toLong(lVar.bjZ().getTid(), 0L));
                        l.this.jEn.a(com.baidu.adp.lib.f.b.toLong(lVar.bjZ().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.coD(), lVar.coE(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.bjZ().getBaijiahaoData());
                    }
                    l.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cIV();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alD = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        aq coQ;
        int id = view.getId();
        int i = 0;
        if (lVar != null) {
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                if (lVar.blg()) {
                    coQ = lVar.coV();
                } else {
                    coQ = lVar.coQ();
                }
                TiebaStatic.log(coQ);
                com.baidu.tieba.a.d.bIR().a("page_recommend", "clk_", coQ);
                i = 1;
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(lVar.coR());
                com.baidu.tieba.a.d.bIR().a("page_recommend", "clk_", lVar.coR());
                i = 9;
            }
            if (i != 0) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.exA, this.fsQ, lVar.coD(), i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.tJ();
        aVar.a((com.baidu.card.i) kVar);
        ak a2 = aVar.a(false, viewGroup, this.alD);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fsQ);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.l.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (l.this.afF != null) {
                        l.this.afF.a(amVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false);
                    amVar2.tW().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, am<com.baidu.tieba.card.data.l> amVar) {
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.exA == null) {
            return null;
        }
        lVar.xj(lVar.position + 1);
        amVar.tW().setPosition(i);
        amVar.tW().setPage(this.ahu);
        amVar.b((am<com.baidu.tieba.card.data.l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afF);
        com.baidu.tieba.card.t.cor().e(lVar.coP());
        com.baidu.tieba.a.d.bIR().e(lVar.coP());
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.exA, this.fsQ, lVar.coD());
        return amVar.getView();
    }

    private void cIV() {
        com.baidu.tieba.card.data.l.ibf = "c10705";
        com.baidu.tieba.card.data.l.ibg = "c10730";
        com.baidu.tieba.card.data.l.ibh = "c10731";
        com.baidu.tieba.card.data.l.ibi = "c10704";
        com.baidu.tieba.card.data.l.ibj = "c10755";
        com.baidu.tieba.card.data.l.ibk = "c10710";
        com.baidu.tieba.card.data.l.ibl = "c10736";
        com.baidu.tieba.card.data.l.ibm = "c10737";
        com.baidu.tieba.card.data.l.ibn = "c10711";
        com.baidu.tieba.card.data.l.ibo = "c10758";
        com.baidu.tieba.card.data.l.ibp = "c10757";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jEn = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }
}
