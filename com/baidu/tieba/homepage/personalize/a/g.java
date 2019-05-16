package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Vj;
    private String Wt;
    private com.baidu.adp.widget.ListView.r YE;
    public BdUniqueId cwh;
    private com.baidu.tieba.homepage.personalize.model.e gcL;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Vj = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aXM().gM(true);
                com.baidu.tieba.a.d.aBn().bJ("page_recommend", "show_");
                if (view != null && g.this.gcL != null && kVar != null && kVar.abv() != null && !StringUtils.isNull(kVar.abv().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dj(com.baidu.adp.lib.g.b.c(kVar.abv().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.di(com.baidu.adp.lib.g.b.c(kVar.abv().getTid(), 0L));
                        g.this.gcL.a(com.baidu.adp.lib.g.b.c(kVar.abv().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aXW(), kVar.aXX(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    g.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        buk();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.YE = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        am aYi;
        int i;
        int id = view.getId();
        if (kVar != null) {
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                if (kVar.aep()) {
                    aYi = kVar.aYn();
                } else {
                    aYi = kVar.aYi();
                }
                TiebaStatic.log(aYi);
                com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", aYi);
                i = 1;
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(kVar.aYj());
                com.baidu.tieba.a.d.aBn().a("page_recommend", "clk_", kVar.aYj());
                i = 9;
            } else {
                i = 0;
            }
            if (i != 0) {
                com.baidu.tieba.q.c.clt().b(this.cwh, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", i, kVar.aXW(), false, (String) null, (String) null));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        aVar.qq().setBackgroundResource(R.color.cp_bg_line_d);
        x a = aVar.a(false, viewGroup, this.YE);
        a.bq(2);
        z zVar = new z(a);
        zVar.setPageId(this.cwh);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.g.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (g.this.Vj != null) {
                        g.this.Vj.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.qs().b(new a.C0038a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, z<com.baidu.tieba.card.data.k> zVar) {
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.threadData == null) {
            return null;
        }
        kVar.ps(kVar.position + 1);
        zVar.qs().setPosition(i);
        zVar.qs().setPage(this.Wt);
        zVar.a(kVar);
        zVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qs().a(this.Vj);
        com.baidu.tieba.card.t.aXM().b(kVar.aYh());
        com.baidu.tieba.a.d.aBn().b(kVar.aYh());
        com.baidu.tieba.q.c.clt().a(this.cwh, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aXW(), false, null, null));
        return zVar.getView();
    }

    private void buk() {
        com.baidu.tieba.card.data.k.eAF = "c10705";
        com.baidu.tieba.card.data.k.eAG = "c10730";
        com.baidu.tieba.card.data.k.eAH = "c10731";
        com.baidu.tieba.card.data.k.eAI = "c10704";
        com.baidu.tieba.card.data.k.eAJ = "c10755";
        com.baidu.tieba.card.data.k.eAK = "c10710";
        com.baidu.tieba.card.data.k.eAL = "c10736";
        com.baidu.tieba.card.data.k.eAM = "c10737";
        com.baidu.tieba.card.data.k.eAN = "c10711";
        com.baidu.tieba.card.data.k.eAO = "c10758";
        com.baidu.tieba.card.data.k.eAP = "c10757";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gcL = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }
}
