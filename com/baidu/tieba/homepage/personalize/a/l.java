package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ag<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adt;
    private String aeX;
    private com.baidu.adp.widget.ListView.t aib;
    private NEGFeedBackView.a eJK;
    public BdUniqueId epM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adt = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.bLs().jv(true);
                if (view != null && kVar != null && kVar.aOi() != null && !StringUtils.isNull(kVar.aOi().getTid())) {
                    l.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cgp();
    }

    public void a(com.baidu.adp.widget.ListView.t tVar) {
        this.aib = tVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i;
        an bLO;
        int id = view.getId();
        if (kVar != null) {
            if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                TiebaStatic.log(kVar.bLP());
                com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", kVar.bLP());
                i = 9;
            } else {
                if (kVar.aPk()) {
                    bLO = kVar.bLT();
                } else {
                    bLO = kVar.bLO();
                }
                TiebaStatic.log(bLO);
                com.baidu.tieba.a.d.bmb().a("page_recommend", "clk_", bLO);
                i = 1;
            }
            if (i != 0) {
                com.baidu.tieba.homepage.personalize.c.a.a(kVar.dEA, this.epM, kVar.bLB(), i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        aVar.rK().bh(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        aVar.a(new com.baidu.card.k(this.mPageContext.getPageActivity()));
        ae a = aVar.a(false, viewGroup, this.aib);
        a.setSourceForPb(2);
        ag agVar = new ag(a);
        agVar.setPageId(this.epM);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.homepage.personalize.a.l.2
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ag)) {
                    ag agVar2 = (ag) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) oVar;
                    kVar.objType = 1;
                    if (l.this.adt != null) {
                        l.this.adt.a(agVar2.getView(), kVar);
                    }
                    au.a((AbsThreadDataSupport) kVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.t) viewGroup2, view, i));
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
        agVar.rM().setPosition(i);
        agVar.rM().setPage(this.aeX);
        agVar.a(kVar.aOp(), Align.ALIGN_RIGHT_TOP, this.eJK);
        agVar.b((ag<com.baidu.tieba.card.data.k>) kVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.adt);
        com.baidu.tieba.card.s.bLs().e(kVar.bLN());
        com.baidu.tieba.a.d.bmb().e(kVar.bLN());
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

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eJK = aVar;
    }
}
