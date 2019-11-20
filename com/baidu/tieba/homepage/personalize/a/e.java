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
    private ab<com.baidu.tieba.card.data.k> EP;
    private String Gc;
    private boolean Hx;
    private com.baidu.adp.widget.ListView.r Iu;
    public BdUniqueId cJo;
    private com.baidu.tieba.homepage.personalize.model.e gkp;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Hx = true;
        this.EP = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.bau().gF(true);
                com.baidu.tieba.a.d.aDc().bO("page_recommend", "show_");
                if (view != null && e.this.gkp != null && kVar != null && kVar.agG() != null && !StringUtils.isNull(kVar.agG().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cS(com.baidu.adp.lib.g.b.toLong(kVar.agG().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cR(com.baidu.adp.lib.g.b.toLong(kVar.agG().getTid(), 0L));
                        e.this.gkp.a(com.baidu.adp.lib.g.b.toLong(kVar.agG().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.baE(), kVar.baF(), com.baidu.adp.lib.g.b.toInt((String) view.getTag(), 1));
                    }
                    e.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        buW();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.Iu = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.baQ());
            com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baQ());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.baS());
            com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baS());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.baS());
            com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baS());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.baR());
            com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baR());
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
            TiebaStatic.log(kVar.baT());
            com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baT());
            i = 3;
        } else {
            i = 0;
        }
        if (i != 0) {
            com.baidu.tieba.q.c.cni().b(this.cJo, com.baidu.tieba.q.a.a(kVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", i, kVar.baE(), false, (String) null, (String) null));
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
        qVar.setFromCDN(this.Hx);
        aVar.b(qVar);
        x a = aVar.a(false, viewGroup, this.Iu);
        a.aF(2);
        z zVar = new z(a);
        zVar.setPageId(this.cJo);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.e.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (e.this.EP != null) {
                        e.this.EP.a(zVar2.getView(), kVar);
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
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.caz == null) {
            return null;
        }
        kVar.oO(kVar.position + 1);
        zVar.lV().setPosition(i);
        zVar.lV().setPage(this.Gc);
        zVar.a(kVar);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.EP);
        com.baidu.tieba.card.t.bau().c(kVar.baP());
        com.baidu.tieba.a.d.aDc().c(kVar.baP());
        com.baidu.card.q qVar = (com.baidu.card.q) zVar.lV().lO();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.FD.Ie.getLayoutParams();
        layoutParams.width = kVar.caA;
        layoutParams.height = kVar.caB;
        if (qVar.FD.Ie.getVisibility() != 8) {
            qVar.FD.Ie.setLayoutParams(layoutParams);
        }
        com.baidu.tieba.q.c.cni().a(this.cJo, kVar.caz != null ? kVar.caz.getId() : null, com.baidu.tieba.q.a.a(kVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", kVar.baE(), false, null, null));
        return zVar.getView();
    }

    private void buW() {
        com.baidu.tieba.card.data.k.ePg = "c10705";
        com.baidu.tieba.card.data.k.ePh = "c10730";
        com.baidu.tieba.card.data.k.ePi = "c10731";
        com.baidu.tieba.card.data.k.ePj = "c10704";
        com.baidu.tieba.card.data.k.ePk = "c10755";
        com.baidu.tieba.card.data.k.ePl = "c10710";
        com.baidu.tieba.card.data.k.ePm = "c10736";
        com.baidu.tieba.card.data.k.ePn = "c10737";
        com.baidu.tieba.card.data.k.ePo = "c10711";
        com.baidu.tieba.card.data.k.ePp = "c10758";
        com.baidu.tieba.card.data.k.ePq = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.Gc = str;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gkp = eVar;
    }
}
