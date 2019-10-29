package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Fq;
    private String GC;
    private boolean HY;
    private com.baidu.adp.widget.ListView.r IY;
    public BdUniqueId cKf;
    private com.baidu.tieba.homepage.personalize.model.e glg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.HY = true;
        this.Fq = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.baw().gF(true);
                com.baidu.tieba.a.d.aDe().bO("page_recommend", "show_");
                if (view != null && e.this.glg != null && kVar != null && kVar.agI() != null && !StringUtils.isNull(kVar.agI().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cT(com.baidu.adp.lib.g.b.toLong(kVar.agI().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cS(com.baidu.adp.lib.g.b.toLong(kVar.agI().getTid(), 0L));
                        e.this.glg.a(com.baidu.adp.lib.g.b.toLong(kVar.agI().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.baG(), kVar.baH(), com.baidu.adp.lib.g.b.toInt((String) view.getTag(), 1));
                    }
                    e.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        buY();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.IY = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.baS());
            com.baidu.tieba.a.d.aDe().a("page_recommend", "clk_", kVar.baS());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.baU());
            com.baidu.tieba.a.d.aDe().a("page_recommend", "clk_", kVar.baU());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.baU());
            com.baidu.tieba.a.d.aDe().a("page_recommend", "clk_", kVar.baU());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.baT());
            com.baidu.tieba.a.d.aDe().a("page_recommend", "clk_", kVar.baT());
            i = 9;
        } else if (id == R.id.god_reply_content) {
            an anVar = new an("c10760");
            anVar.O("obj_locate", 2);
            TiebaStatic.log(anVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar2 = new an("c10760");
            anVar2.O("obj_locate", 1);
            TiebaStatic.log(anVar2);
            i = 5;
        } else if (view instanceof TbImageView) {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                an anVar3 = new an("c10760");
                anVar3.O("obj_locate", 3);
                TiebaStatic.log(anVar3);
            }
            TiebaStatic.log(kVar.baV());
            com.baidu.tieba.a.d.aDe().a("page_recommend", "clk_", kVar.baV());
            i = 3;
        } else {
            i = 0;
        }
        if (i != 0) {
            com.baidu.tieba.q.c.cnk().b(this.cKf, com.baidu.tieba.q.a.a(kVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", i, kVar.baG(), false, (String) null, (String) null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public z b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.q qVar = new com.baidu.card.q(this.mPageContext.getPageActivity());
        qVar.setFrom("index");
        qVar.setFromCDN(this.HY);
        aVar.b(qVar);
        x a = aVar.a(false, viewGroup, this.IY);
        a.aF(2);
        z zVar = new z(a);
        zVar.setPageId(this.cKf);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.e.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (e.this.Fq != null) {
                        e.this.Fq.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.lV().b(new a.C0044a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, z<com.baidu.tieba.card.data.k> zVar) {
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.cbq == null) {
            return null;
        }
        kVar.oP(kVar.position + 1);
        zVar.lV().setPosition(i);
        zVar.lV().setPage(this.GC);
        zVar.a(kVar);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.Fq);
        com.baidu.tieba.card.t.baw().c(kVar.baR());
        com.baidu.tieba.a.d.aDe().c(kVar.baR());
        com.baidu.card.q qVar = (com.baidu.card.q) zVar.lV().lO();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.Ge.IF.getLayoutParams();
        layoutParams.width = kVar.cbr;
        layoutParams.height = kVar.cbs;
        if (qVar.Ge.IF.getVisibility() != 8) {
            qVar.Ge.IF.setLayoutParams(layoutParams);
        }
        com.baidu.tieba.q.c.cnk().a(this.cKf, kVar.cbq != null ? kVar.cbq.getId() : null, com.baidu.tieba.q.a.a(kVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", kVar.baG(), false, null, null));
        return zVar.getView();
    }

    private void buY() {
        com.baidu.tieba.card.data.k.ePX = "c10705";
        com.baidu.tieba.card.data.k.ePY = "c10730";
        com.baidu.tieba.card.data.k.ePZ = "c10731";
        com.baidu.tieba.card.data.k.eQa = "c10704";
        com.baidu.tieba.card.data.k.eQb = "c10755";
        com.baidu.tieba.card.data.k.eQc = "c10710";
        com.baidu.tieba.card.data.k.eQd = "c10736";
        com.baidu.tieba.card.data.k.eQe = "c10737";
        com.baidu.tieba.card.data.k.eQf = "c10711";
        com.baidu.tieba.card.data.k.eQg = "c10758";
        com.baidu.tieba.card.data.k.eQh = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.glg = eVar;
    }
}
