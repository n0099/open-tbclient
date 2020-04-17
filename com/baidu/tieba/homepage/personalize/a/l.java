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
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> acX;
    private String aey;
    private com.baidu.adp.widget.ListView.r ahv;
    public BdUniqueId ebv;
    private NEGFeedBackView.a euS;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.acX = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.bEY().jd(true);
                if (view != null && kVar != null && kVar.aIw() != null && !StringUtils.isNull(kVar.aIw().getTid())) {
                    l.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bZM();
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.ahv = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i;
        an bFt;
        int id = view.getId();
        if (kVar != null) {
            if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                TiebaStatic.log(kVar.bFu());
                com.baidu.tieba.a.d.bfP().a("page_recommend", "clk_", kVar.bFu());
                i = 9;
            } else {
                if (kVar.aJr()) {
                    bFt = kVar.bFy();
                } else {
                    bFt = kVar.bFt();
                }
                TiebaStatic.log(bFt);
                com.baidu.tieba.a.d.bfP().a("page_recommend", "clk_", bFt);
                i = 1;
            }
            if (i != 0) {
                com.baidu.tieba.homepage.personalize.c.a.a(kVar.dqA, this.ebv, kVar.bFh(), i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        aVar.rB().bg(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        aVar.a(new com.baidu.card.j(this.mPageContext.getPageActivity()));
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.ahv);
        a.bc(2);
        af afVar = new af(a);
        afVar.setPageId(this.ebv);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.homepage.personalize.a.l.2
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (l.this.acX != null) {
                        l.this.acX.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar2.rD().b(new a.C0074a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.dqA == null) {
            return null;
        }
        kVar.rN(kVar.position + 1);
        afVar.rD().setPosition(i);
        afVar.rD().setPage(this.aey);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.acX);
        com.baidu.tieba.card.r.bEY().e(kVar.bFs());
        com.baidu.tieba.a.d.bfP().e(kVar.bFs());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dqA, this.ebv, kVar.bFh());
        return afVar.getView();
    }

    private void bZM() {
        com.baidu.tieba.card.data.k.gsg = "c10705";
        com.baidu.tieba.card.data.k.gsh = "c10730";
        com.baidu.tieba.card.data.k.gsi = "c10731";
        com.baidu.tieba.card.data.k.gsj = "c10704";
        com.baidu.tieba.card.data.k.gsk = "c10755";
        com.baidu.tieba.card.data.k.gsl = "c10710";
        com.baidu.tieba.card.data.k.gsm = "c10736";
        com.baidu.tieba.card.data.k.gsn = "c10737";
        com.baidu.tieba.card.data.k.gso = "c10711";
        com.baidu.tieba.card.data.k.gsp = "c10758";
        com.baidu.tieba.card.data.k.gsq = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.euS = aVar;
    }
}
