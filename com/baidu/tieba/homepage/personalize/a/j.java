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
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> Jy;
    private String La;
    private com.baidu.adp.widget.ListView.r Ol;
    private NEGFeedBackView.a dQa;
    public BdUniqueId dwY;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Jy = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.bsy().hK(true);
                if (view != null && kVar != null && kVar.axx() != null && !StringUtils.isNull(kVar.axx().getTid())) {
                    j.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bMk();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.Ol = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i;
        an bsU;
        int id = view.getId();
        if (kVar != null) {
            if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                TiebaStatic.log(kVar.bsV());
                com.baidu.tieba.a.d.aUV().a("page_recommend", "clk_", kVar.bsV());
                i = 9;
            } else {
                if (kVar.aAE()) {
                    bsU = kVar.bsZ();
                } else {
                    bsU = kVar.bsU();
                }
                TiebaStatic.log(bsU);
                com.baidu.tieba.a.d.aUV().a("page_recommend", "clk_", bsU);
                i = 1;
            }
            if (i != 0) {
                com.baidu.tieba.homepage.personalize.c.a.a(kVar.cMR, this.dwY, kVar.bsI(), i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        aVar.mR().aQ(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        aVar.a(new com.baidu.card.j(this.mPageContext.getPageActivity()));
        ad a = aVar.a(false, viewGroup, this.Ol);
        a.aM(2);
        af afVar = new af(a);
        afVar.setPageId(this.dwY);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.j.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (j.this.Jy != null) {
                        j.this.Jy.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar2.mT().b(new a.C0050a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cMR == null) {
            return null;
        }
        kVar.rh(kVar.position + 1);
        afVar.mT().setPosition(i);
        afVar.mT().setPage(this.La);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.mT().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mT().a(this.Jy);
        com.baidu.tieba.card.r.bsy().c(kVar.bsT());
        com.baidu.tieba.a.d.aUV().c(kVar.bsT());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cMR, this.dwY, kVar.bsI());
        return afVar.getView();
    }

    private void bMk() {
        com.baidu.tieba.card.data.k.fGW = "c10705";
        com.baidu.tieba.card.data.k.fGX = "c10730";
        com.baidu.tieba.card.data.k.fGY = "c10731";
        com.baidu.tieba.card.data.k.fGZ = "c10704";
        com.baidu.tieba.card.data.k.fHa = "c10755";
        com.baidu.tieba.card.data.k.fHb = "c10710";
        com.baidu.tieba.card.data.k.fHc = "c10736";
        com.baidu.tieba.card.data.k.fHd = "c10737";
        com.baidu.tieba.card.data.k.fHe = "c10711";
        com.baidu.tieba.card.data.k.fHf = "c10758";
        com.baidu.tieba.card.data.k.fHg = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void wq(String str) {
        this.La = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dQa = aVar;
    }
}
