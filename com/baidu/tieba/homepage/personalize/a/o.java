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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class o extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Vi;
    private String Ws;
    private com.baidu.adp.widget.ListView.r YD;
    public BdUniqueId cwi;
    private com.baidu.tieba.homepage.personalize.model.e gcO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Vi = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aXP().gM(true);
                com.baidu.tieba.a.d.aBq().bJ("page_recommend", "show_");
                if (view != null && o.this.gcO != null && kVar != null && kVar.abv() != null && !StringUtils.isNull(kVar.abv().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dj(com.baidu.adp.lib.g.b.c(kVar.abv().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.di(com.baidu.adp.lib.g.b.c(kVar.abv().getTid(), 0L));
                        o.this.gcO.a(com.baidu.adp.lib.g.b.c(kVar.abv().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aXZ(), kVar.aYa(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    o.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        buo();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.YD = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        am aYl;
        int i = 1;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.l.V(kVar.threadData)) {
                aYl = kVar.aYq();
                TiebaStatic.log(aYl);
            } else {
                aYl = kVar.aYl();
                TiebaStatic.log(aYl);
            }
            com.baidu.tieba.a.d.aBq().a("page_recommend", "clk_", aYl);
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.aYp());
            com.baidu.tieba.a.d.aBq().a("page_recommend", "clk_", kVar.aYp());
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.aYn());
            com.baidu.tieba.a.d.aBq().a("page_recommend", "clk_", kVar.aYn());
            i = 2;
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.aYn());
            com.baidu.tieba.a.d.aBq().a("page_recommend", "clk_", kVar.aYn());
            i = 2;
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.aYm());
            com.baidu.tieba.a.d.aBq().a("page_recommend", "clk_", kVar.aYm());
            i = 9;
        } else if (id == R.id.god_reply_voice_btn) {
            am amVar = new am("c10760");
            amVar.P("obj_locate", 4);
            TiebaStatic.log(amVar);
            i = 5;
        } else if (id == R.id.god_reply_content) {
            am amVar2 = new am("c10760");
            amVar2.P("obj_locate", 2);
            TiebaStatic.log(amVar2);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            am amVar3 = new am("c10760");
            amVar3.P("obj_locate", 1);
            TiebaStatic.log(amVar3);
            i = 2;
        } else {
            i = 0;
        }
        if (i != 0) {
            com.baidu.tieba.q.c.clw().b(this.cwi, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", i, kVar.aXZ(), false, (String) null, (String) null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bEz = 1;
        dVar.bEE = 1;
        aaVar.setAgreeStatisticData(dVar);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bw(2);
        aVar.a(aaVar);
        aVar.qq().setBackgroundResource(R.color.cp_bg_line_d);
        x a = aVar.a(true, viewGroup, this.YD);
        a.bq(2);
        z zVar = new z(a);
        zVar.setPageId(this.cwi);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.o.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (o.this.Vi != null) {
                        o.this.Vi.a(zVar2.getView(), kVar);
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
        zVar.qs().setPage(this.Ws);
        zVar.a(kVar);
        zVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qs().a(this.Vi);
        com.baidu.tieba.card.t.aXP().b(kVar.aYk());
        com.baidu.tieba.a.d.aBq().b(kVar.aYk());
        com.baidu.tieba.q.c.clw().a(this.cwi, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aXZ(), false, null, null));
        return zVar.getView();
    }

    private void buo() {
        com.baidu.tieba.card.data.k.eAH = "c10730";
        com.baidu.tieba.card.data.k.eAI = "c10731";
        com.baidu.tieba.card.data.k.eAJ = "c10704";
        com.baidu.tieba.card.data.k.eAK = "c10755";
        com.baidu.tieba.card.data.k.eAL = "c10710";
        com.baidu.tieba.card.data.k.eAM = "c10736";
        com.baidu.tieba.card.data.k.eAN = "c10737";
        com.baidu.tieba.card.data.k.eAO = "c10711";
        com.baidu.tieba.card.data.k.eAP = "c10758";
        com.baidu.tieba.card.data.k.eAQ = "c10757";
        com.baidu.tieba.card.data.k.eAT = "c10734";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gcO = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rU(String str) {
        this.Ws = str;
    }
}
