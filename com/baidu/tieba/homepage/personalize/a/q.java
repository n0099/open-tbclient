package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aa;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> EP;
    private String Gc;
    private boolean Hx;
    public BdUniqueId cJo;
    private NEGFeedBackView.a dcg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dcg = null;
        this.Hx = true;
        this.EP = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.bau().gF(true);
                com.baidu.tieba.a.d.aDc().bO("page_recommend", "show_");
                if (view != null && kVar != null && kVar.agG() != null && !StringUtils.isNull(kVar.agG().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.uI("c12642"));
                        com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baQ());
                        com.baidu.tieba.q.c.cni().b(q.this.cJo, com.baidu.tieba.q.a.a(kVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, kVar.baE(), false, (String) null, (String) null));
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.baU());
                        com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baU());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.baS());
                        com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baS());
                        com.baidu.tieba.q.c.cni().b(q.this.cJo, com.baidu.tieba.q.a.a(kVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 2, kVar.baE(), false, (String) null, (String) null));
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.baS());
                        com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baS());
                        com.baidu.tieba.q.c.cni().b(q.this.cJo, com.baidu.tieba.q.a.a(kVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 2, kVar.baE(), false, (String) null, (String) null));
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.baR());
                        com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baR());
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar = new an("c10760");
                        anVar.O("obj_locate", 4);
                        TiebaStatic.log(anVar);
                    } else if (id == R.id.god_reply_content) {
                        an anVar2 = new an("c10760");
                        anVar2.O("obj_locate", 2);
                        TiebaStatic.log(anVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        an anVar3 = new an("c10760");
                        anVar3.O("obj_locate", 1);
                        TiebaStatic.log(anVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            an anVar4 = new an("c10760");
                            anVar4.O("obj_locate", 3);
                            TiebaStatic.log(anVar4);
                        }
                        TiebaStatic.log(kVar.baT());
                        com.baidu.tieba.a.d.aDc().a("page_recommend", "clk_", kVar.baT());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        buW();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public z<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cJo);
        dVar.aC(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.a.q.2
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.c(dVar);
        com.baidu.card.ab abVar = new com.baidu.card.ab(this.mPageContext.getPageActivity());
        aVar.b(abVar);
        abVar.aM(2);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.Hx);
        hVar.setForm("index");
        aVar.a((com.baidu.card.f) hVar);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bWZ = 1;
        dVar2.bXe = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.aL(2);
        aVar.a(aaVar);
        x lU = aVar.lU();
        lU.aF(2);
        z<com.baidu.tieba.card.data.k> zVar = new z<>(lU);
        zVar.setPageId(this.cJo);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.q.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (q.this.EP != null) {
                        q.this.EP.a(zVar2.getView(), kVar);
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
        com.baidu.tieba.card.t.bau().c(kVar.uH("c12641"));
        com.baidu.tieba.a.d.aDc().a("page_recommend", "show_", kVar.baP());
        zVar.lV().setPage(this.Gc);
        zVar.lW().a(this.dcg);
        zVar.a(kVar);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.EP);
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

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dcg = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.Gc = str;
    }

    public void setFromCDN(boolean z) {
        this.Hx = z;
    }
}
