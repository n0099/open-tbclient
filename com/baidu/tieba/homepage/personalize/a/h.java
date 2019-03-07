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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Xq;
    private String Yz;
    private boolean ZO;
    private com.baidu.adp.widget.ListView.r aaJ;
    public BdUniqueId cnX;
    private com.baidu.tieba.homepage.personalize.model.e fLQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ZO = true;
        this.Xq = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aQF().go(true);
                com.baidu.tieba.a.d.awk().bA("page_recommend", "show_");
                if (view != null && h.this.fLQ != null && kVar != null && kVar.WR() != null && !StringUtils.isNull(kVar.WR().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cM(com.baidu.adp.lib.g.b.d(kVar.WR().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cL(com.baidu.adp.lib.g.b.d(kVar.WR().getTid(), 0L));
                        h.this.fLQ.a(com.baidu.adp.lib.g.b.d(kVar.WR().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aQP(), kVar.aQQ(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    h.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bmL();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.aaJ = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 1;
        int id = view.getId();
        if (view.getId() == d.g.thread_card_root || id == d.g.thread_info_commont_container) {
            TiebaStatic.log(kVar.aRb());
            com.baidu.tieba.a.d.awk().a("page_recommend", "clk_", kVar.aRb());
        } else if (id == d.g.god_reply_voice_btn) {
            am amVar = new am("c10760");
            amVar.T("obj_locate", 4);
            TiebaStatic.log(amVar);
        } else if (id == d.g.god_reply_content) {
            am amVar2 = new am("c10760");
            amVar2.T("obj_locate", 2);
            TiebaStatic.log(amVar2);
            i = 5;
        } else if (id == d.g.god_reply_user_pendant_header || id == d.g.god_reply_username_text) {
            am amVar3 = new am("c10760");
            amVar3.T("obj_locate", 1);
            TiebaStatic.log(amVar3);
            i = 0;
        } else if (view instanceof TbImageView) {
            if (view.getTag(d.g.god_reply_image_layout) instanceof Integer) {
                am amVar4 = new am("c10760");
                amVar4.T("obj_locate", 3);
                TiebaStatic.log(amVar4);
            }
            TiebaStatic.log(kVar.aRe());
            com.baidu.tieba.a.d.awk().a("page_recommend", "clk_", kVar.aRe());
            i = 3;
        } else {
            i = 0;
        }
        if (i != 0) {
            com.baidu.tieba.q.c.cdq().b(this.cnX, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", i, kVar.aQP(), false, null, null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.ZO);
        hVar.setForm("index");
        aVar.a((com.baidu.card.f) hVar);
        aVar.rv().setBackgroundResource(d.C0236d.cp_bg_line_d);
        x a = aVar.a(false, viewGroup, this.aaJ);
        a.by(2);
        z zVar = new z(a);
        zVar.setPageId(this.cnX);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.h.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (h.this.Xq != null) {
                        h.this.Xq.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.rx().b(new a.C0037a(1));
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
        kVar.os(kVar.position + 1);
        zVar.rx().setPosition(i);
        zVar.rx().setPage(this.Yz);
        zVar.a(kVar);
        zVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.rx().a(this.Xq);
        com.baidu.tieba.card.t.aQF().b(kVar.aRa());
        com.baidu.tieba.a.d.awk().b(kVar.aRa());
        com.baidu.tieba.q.c.cdq().a(this.cnX, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aQP(), false, null, null));
        return zVar.getView();
    }

    private void bmL() {
        com.baidu.tieba.card.data.k.eli = "c10705";
        com.baidu.tieba.card.data.k.elj = "c10730";
        com.baidu.tieba.card.data.k.elk = "c10731";
        com.baidu.tieba.card.data.k.ell = "c10704";
        com.baidu.tieba.card.data.k.elm = "c10755";
        com.baidu.tieba.card.data.k.eln = "c10710";
        com.baidu.tieba.card.data.k.elo = "c10736";
        com.baidu.tieba.card.data.k.elp = "c10737";
        com.baidu.tieba.card.data.k.elq = "c10711";
        com.baidu.tieba.card.data.k.elr = "c10758";
        com.baidu.tieba.card.data.k.els = "c10757";
    }

    public void setFromCDN(boolean z) {
        this.ZO = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.fLQ = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.Yz = str;
    }
}
