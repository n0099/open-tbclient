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
/* loaded from: classes9.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> JZ;
    private String LC;
    private com.baidu.adp.widget.ListView.r OR;
    public BdUniqueId dBj;
    private NEGFeedBackView.a dUp;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.bve().ib(true);
                if (view != null && kVar != null && kVar.aAe() != null && !StringUtils.isNull(kVar.aAe().getTid())) {
                    j.this.b(view, kVar);
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
        int i;
        an bvA;
        int id = view.getId();
        if (kVar != null) {
            if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                TiebaStatic.log(kVar.bvB());
                com.baidu.tieba.a.d.aXD().a("page_recommend", "clk_", kVar.bvB());
                i = 9;
            } else {
                if (kVar.aAZ()) {
                    bvA = kVar.bvF();
                } else {
                    bvA = kVar.bvA();
                }
                TiebaStatic.log(bvA);
                com.baidu.tieba.a.d.aXD().a("page_recommend", "clk_", bvA);
                i = 1;
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
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        aVar.ni().aU(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        aVar.a(new com.baidu.card.j(this.mPageContext.getPageActivity()));
        ad a = aVar.a(false, viewGroup, this.OR);
        a.aQ(2);
        af afVar = new af(a);
        afVar.setPageId(this.dBj);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.j.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (j.this.JZ != null) {
                        j.this.JZ.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
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

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUp = aVar;
    }
}
