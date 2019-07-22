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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> VC;
    private String WN;
    private com.baidu.adp.widget.ListView.r YY;
    public BdUniqueId cxx;
    private com.baidu.tieba.homepage.personalize.model.e gja;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.VC = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aZN().gS(true);
                com.baidu.tieba.a.d.aCF().bJ("page_recommend", "show_");
                if (view != null && g.this.gja != null && kVar != null && kVar.acx() != null && !StringUtils.isNull(kVar.acx().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dq(com.baidu.adp.lib.g.b.c(kVar.acx().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dp(com.baidu.adp.lib.g.b.c(kVar.acx().getTid(), 0L));
                        g.this.gja.a(com.baidu.adp.lib.g.b.c(kVar.acx().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aZX(), kVar.aZY(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    g.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bwS();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.YY = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        an bak;
        int i;
        int id = view.getId();
        if (kVar != null) {
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                if (kVar.afr()) {
                    bak = kVar.bap();
                } else {
                    bak = kVar.bak();
                }
                TiebaStatic.log(bak);
                com.baidu.tieba.a.d.aCF().a("page_recommend", "clk_", bak);
                i = 1;
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(kVar.bal());
                com.baidu.tieba.a.d.aCF().a("page_recommend", "clk_", kVar.bal());
                i = 9;
            } else {
                i = 0;
            }
            if (i != 0) {
                com.baidu.tieba.q.c.coo().b(this.cxx, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", i, kVar.aZX(), false, (String) null, (String) null));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        x a = aVar.a(false, viewGroup, this.YY);
        a.bq(2);
        z zVar = new z(a);
        zVar.setPageId(this.cxx);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.g.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (g.this.VC != null) {
                        g.this.VC.a(zVar2.getView(), kVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.qP().b(new a.C0038a(1));
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
        kVar.pI(kVar.position + 1);
        zVar.qP().setPosition(i);
        zVar.qP().setPage(this.WN);
        zVar.a(kVar);
        zVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qP().a(this.VC);
        com.baidu.tieba.card.t.aZN().c(kVar.baj());
        com.baidu.tieba.a.d.aCF().c(kVar.baj());
        com.baidu.tieba.q.c.coo().a(this.cxx, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aZX(), false, null, null));
        return zVar.getView();
    }

    private void bwS() {
        com.baidu.tieba.card.data.k.eFC = "c10705";
        com.baidu.tieba.card.data.k.eFD = "c10730";
        com.baidu.tieba.card.data.k.eFE = "c10731";
        com.baidu.tieba.card.data.k.eFF = "c10704";
        com.baidu.tieba.card.data.k.eFG = "c10755";
        com.baidu.tieba.card.data.k.eFH = "c10710";
        com.baidu.tieba.card.data.k.eFI = "c10736";
        com.baidu.tieba.card.data.k.eFJ = "c10737";
        com.baidu.tieba.card.data.k.eFK = "c10711";
        com.baidu.tieba.card.data.k.eFL = "c10758";
        com.baidu.tieba.card.data.k.eFM = "c10757";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gja = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }
}
