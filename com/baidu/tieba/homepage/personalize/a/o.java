package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aa;
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
public class o extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> VC;
    private String WN;
    private com.baidu.adp.widget.ListView.r YY;
    public BdUniqueId cxE;
    private com.baidu.tieba.homepage.personalize.model.e gjQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.VC = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aZP().gS(true);
                com.baidu.tieba.a.d.aCH().bJ("page_recommend", "show_");
                if (view != null && o.this.gjQ != null && kVar != null && kVar.acy() != null && !StringUtils.isNull(kVar.acy().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dq(com.baidu.adp.lib.g.b.c(kVar.acy().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dp(com.baidu.adp.lib.g.b.c(kVar.acy().getTid(), 0L));
                        o.this.gjQ.a(com.baidu.adp.lib.g.b.c(kVar.acy().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aZZ(), kVar.baa(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    o.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bxg();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.YY = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        an bam;
        int i = 1;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.l.W(kVar.threadData)) {
                bam = kVar.bar();
                TiebaStatic.log(bam);
            } else {
                bam = kVar.bam();
                TiebaStatic.log(bam);
            }
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", bam);
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.baq());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.baq());
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.bao());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.bao());
            i = 2;
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.bao());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.bao());
            i = 2;
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.ban());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.ban());
            i = 9;
        } else if (id == R.id.god_reply_voice_btn) {
            an anVar = new an("c10760");
            anVar.P("obj_locate", 4);
            TiebaStatic.log(anVar);
            i = 5;
        } else if (id == R.id.god_reply_content) {
            an anVar2 = new an("c10760");
            anVar2.P("obj_locate", 2);
            TiebaStatic.log(anVar2);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar3 = new an("c10760");
            anVar3.P("obj_locate", 1);
            TiebaStatic.log(anVar3);
            i = 2;
        } else {
            i = 0;
        }
        if (i != 0) {
            com.baidu.tieba.q.c.coG().b(this.cxE, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", i, kVar.aZZ(), false, (String) null, (String) null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFA = 1;
        dVar.bFF = 1;
        aaVar.setAgreeStatisticData(dVar);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bw(2);
        aVar.a(aaVar);
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        x a = aVar.a(true, viewGroup, this.YY);
        a.bq(2);
        z zVar = new z(a);
        zVar.setPageId(this.cxE);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.o.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (o.this.VC != null) {
                        o.this.VC.a(zVar2.getView(), kVar);
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
        kVar.pJ(kVar.position + 1);
        zVar.qP().setPosition(i);
        zVar.qP().setPage(this.WN);
        zVar.a(kVar);
        zVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qP().a(this.VC);
        com.baidu.tieba.card.t.aZP().c(kVar.bal());
        com.baidu.tieba.a.d.aCH().c(kVar.bal());
        com.baidu.tieba.q.c.coG().a(this.cxE, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aZZ(), false, null, null));
        return zVar.getView();
    }

    private void bxg() {
        com.baidu.tieba.card.data.k.eFK = "c10730";
        com.baidu.tieba.card.data.k.eFL = "c10731";
        com.baidu.tieba.card.data.k.eFM = "c10704";
        com.baidu.tieba.card.data.k.eFN = "c10755";
        com.baidu.tieba.card.data.k.eFO = "c10710";
        com.baidu.tieba.card.data.k.eFP = "c10736";
        com.baidu.tieba.card.data.k.eFQ = "c10737";
        com.baidu.tieba.card.data.k.eFR = "c10711";
        com.baidu.tieba.card.data.k.eFS = "c10758";
        com.baidu.tieba.card.data.k.eFT = "c10757";
        com.baidu.tieba.card.data.k.eFW = "c10734";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gjQ = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }
}
